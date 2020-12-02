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
import com.unac.serviciomvn.model.Propietario;
import com.unac.serviciomvn.services.PropietarioService;
import com.unac.serviciomvn.services.VehiculoService;

@RestController
@RequestMapping("/propietario")
@CrossOrigin(origins = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PropietarioController {
	@Autowired
	PropietarioService propietarioService;
	

	@Autowired
	VehiculoService vehiculoService;
	
	
	@GetMapping("/lista")
    public ResponseEntity<List<Propietario>> list(){
        List<Propietario> list = propietarioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

	
	@GetMapping("/detail/{id}")
    public ResponseEntity<Propietario> getById(@PathVariable("id") int id){
        if(!propietarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
        Propietario propietario = propietarioService.getOne(id).get();
        return new ResponseEntity(propietario, HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Propietario propietarioModel){
		
    	
    	if(!propietarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
    	Propietario propietario = propietarioService.getOne(id).get();
    	

		if(propietarioService.existsByCedula(propietarioModel.getCedula()) && !( propietario.getCedula().contentEquals(propietarioModel.getCedula()))  )
			return new ResponseEntity(new Mensaje("Ya existe esa cedula registrada"), HttpStatus.NOT_FOUND);
		if(propietarioService.existsByEmail(propietarioModel.getEmail()) && !(propietario.getEmail().contentEquals(propietarioModel.getEmail()) )  )
			return new ResponseEntity(new Mensaje("Ya existe ese email registrado"), HttpStatus.NOT_FOUND);
		if(propietarioService.existsByTelefono(propietarioModel.getTelefono())  && !(propietario.getTelefono().contentEquals(propietarioModel.getTelefono()))  )
			return new ResponseEntity(new Mensaje("Ya existe ese telefono registrado"), HttpStatus.NOT_FOUND);
		
    	
    	
    	propietario.setNombre(propietarioModel.getNombre());
    	propietario.setApellidos(propietarioModel.getApellidos());
    	propietario.setCedula(propietarioModel.getCedula());
    	propietario.setEmail(propietarioModel.getEmail());
    	propietario.setTelefono(propietarioModel.getTelefono());
    	
    	
    	propietario.setFechaActualizacion(propietarioModel.getFechaActualizacion());
    	propietario.setUsuarioActualizacion(propietarioModel.getUsuarioActualizacion());
    	propietario.setIdUsuario(propietarioModel.getIdUsuario());
    	
    	propietarioService.save(propietario);
    	
        return new ResponseEntity(propietario, HttpStatus.OK);
    }
	
	
	@PutMapping("/update/invitado/{id}")
    public ResponseEntity<?> updateInivtado(@PathVariable("id")int id, @RequestBody Propietario propietarioModel){
    	if(!propietarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
    	Propietario propietario = propietarioService.getOne(id).get();
    	propietario.setTelefono(propietarioModel.getTelefono());
    	propietarioService.save(propietario);
    	
        return new ResponseEntity(propietario, HttpStatus.OK);
    }
	
	
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Propietario propietario){

        if(propietarioService.existsByCedula(propietario.getCedula()))
			return new ResponseEntity(new Mensaje("Ya existe esa cedula registrada"), HttpStatus.NOT_FOUND);
		if(propietarioService.existsByEmail(propietario.getEmail()))
			return new ResponseEntity(new Mensaje("Ya existe ese email registrado"), HttpStatus.NOT_FOUND);
		if(propietarioService.existsByTelefono(propietario.getTelefono()))
			return new ResponseEntity(new Mensaje("Ya existe ese telefono registrado"), HttpStatus.NOT_FOUND);
		propietarioService.save(propietario);
        return new ResponseEntity(propietario, HttpStatus.OK);
    }
	@PutMapping("/insert/vehiculo/{id}")
    public ResponseEntity<?> vehiculo(@RequestBody Propietario propietario, @PathVariable("id") int id){
        return new ResponseEntity(propietario, HttpStatus.OK);
    }
	@PostMapping("/filtrar")
	public ResponseEntity<List<Propietario>> filtroNombre(@RequestBody Propietario propietario){
		List<Propietario> list = propietarioService.findByParameters(propietario.getCedula(),propietario.getNombre());
		return new ResponseEntity(list, HttpStatus.OK);
    }
	@PostMapping("/email")
	public ResponseEntity<?> Email(@RequestBody Propietario propietario){
		return new ResponseEntity(propietario.getEmail(), HttpStatus.OK);
    }
	
	
}
