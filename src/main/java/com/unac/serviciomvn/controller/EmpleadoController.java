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
import com.unac.serviciomvn.model.Empleado;
import com.unac.serviciomvn.services.EmpleadoService;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class EmpleadoController {
	@Autowired
    EmpleadoService empleadoService;
	
	
	@GetMapping("/lista")
    public ResponseEntity<List<Empleado>> list(){
        List<Empleado> list = empleadoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@GetMapping("/detail/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable("id") int id){
        if(!empleadoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
        Empleado empleado = empleadoService.getOne(id).get();
        return new ResponseEntity(empleado, HttpStatus.OK);
    }
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Empleado empleadoModel){
		
		if(empleadoService.existsByCedula(empleadoModel.getCedula()))
			return new ResponseEntity(new Mensaje("Ya existe esa cedula registrada"), HttpStatus.NOT_FOUND);
		if(empleadoService.existsByEmail(empleadoModel.getEmail()))
			return new ResponseEntity(new Mensaje("Ya existe ese email registrado"), HttpStatus.NOT_FOUND);
		if(empleadoService.existsByTelefono(empleadoModel.getTelefono()))
			return new ResponseEntity(new Mensaje("Ya existe ese telefono registrado"), HttpStatus.NOT_FOUND);
		
		empleadoService.save(empleadoModel);
        return new ResponseEntity(new Mensaje("Empleado Registrado Exitosamente"), HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Empleado empleadoModel){
		
		
    	if(!empleadoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
    	Empleado empleado = empleadoService.getOne(id).get();
    	
    	if(empleadoService.existsByCedula(empleadoModel.getCedula()) && !( empleado.getCedula().contentEquals(empleadoModel.getCedula()))  )
			return new ResponseEntity(new Mensaje("Ya existe esa cedula registrada"), HttpStatus.NOT_FOUND);
		if(empleadoService.existsByEmail(empleadoModel.getEmail()) && !(empleado.getEmail().contentEquals(empleadoModel.getEmail()) )  )
			return new ResponseEntity(new Mensaje("Ya existe ese email registrado"), HttpStatus.NOT_FOUND);
		if(empleadoService.existsByTelefono(empleadoModel.getTelefono())  && !(empleado.getTelefono().contentEquals(empleadoModel.getTelefono()))  )
			return new ResponseEntity(new Mensaje("Ya existe ese telefono registrado"), HttpStatus.NOT_FOUND);
		
    	empleado.setNombre(empleadoModel.getNombre());
    	empleado.setCedula(empleadoModel.getCedula());
    	empleado.setApellidos(empleadoModel.getApellidos());
    	empleado.setEmail(empleadoModel.getEmail());
    	empleado.setTelefono(empleadoModel.getTelefono());
		empleado.setIdUsuario(empleadoModel.getIdUsuario());
		empleadoService.save(empleadoModel);
        return new ResponseEntity(empleadoModel, HttpStatus.OK);
    }
	@PostMapping("/filtrar")
	public ResponseEntity<List<Empleado>> filtroNombre(@RequestBody Empleado empleado){
		List<Empleado> list = empleadoService.findByParameters(empleado.getCedula(), empleado.getNombre());
		return new ResponseEntity(list, HttpStatus.OK);
    }
}
