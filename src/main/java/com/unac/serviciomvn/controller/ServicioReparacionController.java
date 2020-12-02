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
import com.unac.serviciomvn.model.ServicioReparacion;
import com.unac.serviciomvn.services.ServicioReparacionService;

@RestController
@RequestMapping("/servicio")
@CrossOrigin(origins = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ServicioReparacionController {
	@Autowired
	ServicioReparacionService servicioReparacionService;

	@PostMapping("/lista")
    public ResponseEntity<?> list(@RequestBody ServicioReparacion servicio){
		List<ServicioReparacion> list = servicioReparacionService.listServ(servicio.getIdDetalles());
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@GetMapping("/detail/{id}")
    public ResponseEntity<ServicioReparacion> getById(@PathVariable("id") int id){
        if(!servicioReparacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
        ServicioReparacion servicio = servicioReparacionService.getOne(id).get();
        return new ResponseEntity(servicio, HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ServicioReparacion servicioModel){
		if(!servicioReparacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
		ServicioReparacion servicio = servicioReparacionService.getOne(id).get();
		if(servicio.isHabilitado() == false)
			return new ResponseEntity(new Mensaje("No se puede modificar"), HttpStatus.NOT_FOUND);
		servicio.setDescripcion(servicioModel.getDescripcion());
		servicio.setDescuentoServicio(servicioModel.getDescuentoServicio());
		servicio.setHabilitado(servicioModel.isHabilitado());
		servicio.setNombre(servicioModel.getNombre());
		servicio.setPrecioServicio(servicioModel.getPrecioServicio());
		servicio.setIdEmpleadoServicio(servicioModel.getIdEmpleadoServicio());;
		servicioReparacionService.save(servicio);
        return new ResponseEntity(servicio, HttpStatus.OK);
    }
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ServicioReparacion servicio){
		servicioReparacionService.save(servicio);
        return new ResponseEntity(servicio, HttpStatus.OK);
    }
}
