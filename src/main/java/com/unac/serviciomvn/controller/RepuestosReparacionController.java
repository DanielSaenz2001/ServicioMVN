package com.unac.serviciomvn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unac.serviciomvn.dto.Mensaje;
import com.unac.serviciomvn.model.RepuestosReparacion;
import com.unac.serviciomvn.services.RepuestosReparacionService;

@RestController
@RequestMapping("/repuestos")
@CrossOrigin(origins = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class RepuestosReparacionController {
	@Autowired
	RepuestosReparacionService repuestosReparacionService;

	@GetMapping("/lista")
    public ResponseEntity<?> list(){
		List<RepuestosReparacion> list = repuestosReparacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RepuestosReparacion respuesto){
		repuestosReparacionService.save(respuesto);
        return new ResponseEntity(respuesto, HttpStatus.OK);
    }
	@GetMapping("/detail/{id}")
    public ResponseEntity<RepuestosReparacion> getById(@PathVariable("id") int id){
        if(!repuestosReparacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
        RepuestosReparacion repuesto = repuestosReparacionService.getOne(id).get();
        return new ResponseEntity(repuesto, HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody RepuestosReparacion respuestoModel){
		if(!repuestosReparacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
		RepuestosReparacion respuesto = repuestosReparacionService.getOne(id).get();
		
		respuesto.setNombre(respuestoModel.getNombre());
		respuesto.setPrecio(respuestoModel.getPrecio());
		
		repuestosReparacionService.save(respuesto);
        return new ResponseEntity(respuesto, HttpStatus.OK);
    }
}
