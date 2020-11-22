package com.unac.serviciomvn.controller;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unac.serviciomvn.dto.Mensaje;
import com.unac.serviciomvn.model.Empleado;
import com.unac.serviciomvn.model.Propietario;
import com.unac.serviciomvn.services.PropietarioService;

@RestController
@RequestMapping("/propietario")
@CrossOrigin(origins = "*")
public class PropietarioController {
	@Autowired
	PropietarioService propietarioService;
	
	
	@GetMapping("/lista")
    public ResponseEntity<List<Propietario>> list(){
        List<Propietario> list = propietarioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

	
	@GetMapping("/detail/{id}")
    public ResponseEntity<Propietario> getById(@PathVariable("id") int id){
        if(!propietarioService.existsById(id))
            return new ResponseEntity(new Mensaje("mensaje no encontrado"), HttpStatus.NOT_FOUND);
        Propietario propietario = propietarioService.getOne(id).get();
        return new ResponseEntity(propietario, HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Propietario propietarioModel){
		
    	
    	if(!propietarioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
    	Propietario propietario = propietarioService.getOne(id).get();
    	
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
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Propietario propietario){

		propietarioService.save(propietario);
        return new ResponseEntity(propietario.getUsuarioCreacion(), HttpStatus.OK);
    }
	@PostMapping("/filtrar")
	public ResponseEntity<List<Propietario>> filtroNombre(@RequestBody Propietario propietario){
		List<Propietario> list = propietarioService.findByParameters(propietario.getCedula(),propietario.getNombre(),propietario.getApellidos());
		return new ResponseEntity(list, HttpStatus.OK);
    }
	/*@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		if(!propietarioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		propietarioService.delete(id);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }*/
	@PostMapping("/email")
	public ResponseEntity<?> Email(@RequestBody Propietario propietario){
		//propietario.getEmail()
		
		return new ResponseEntity(propietario.getEmail(), HttpStatus.OK);
    }
	
	
}
