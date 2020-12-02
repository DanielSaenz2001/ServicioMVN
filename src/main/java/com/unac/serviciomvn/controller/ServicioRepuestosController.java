package com.unac.serviciomvn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unac.serviciomvn.dto.Mensaje;
import com.unac.serviciomvn.model.ServicioRepuestos;
import com.unac.serviciomvn.services.ServicioRepuestosService;

@RestController
@RequestMapping("/servicio/repuestos")
@CrossOrigin(origins = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ServicioRepuestosController {
	@Autowired
	ServicioRepuestosService servicioRepuestosService;

	@PostMapping("/lista")
    public ResponseEntity<?> list(@RequestBody ServicioRepuestos servicio){
		List<ServicioRepuestos> list = servicioRepuestosService.listServ(servicio.getIdServicio());
        return new ResponseEntity(list, HttpStatus.OK);
    }
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ServicioRepuestos servicio){
		servicioRepuestosService.save(servicio);
        return new ResponseEntity(servicio, HttpStatus.OK);
    }
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
		System.out.println(id);
		System.out.println(!servicioRepuestosService.existsById(id));
		if(!servicioRepuestosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		servicioRepuestosService.delete(id);
        return new ResponseEntity(new Mensaje("Repuesto Eliminado"), HttpStatus.OK);
    }
}
