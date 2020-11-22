package com.unac.serviciomvn.controller;


import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.unac.serviciomvn.dto.Mensaje;
import com.unac.serviciomvn.model.MensajePrueba;
import com.unac.serviciomvn.model.MensajeUsuario;
import com.unac.serviciomvn.security.controller.AuthController;
import com.unac.serviciomvn.security.model.Usuario;
import com.unac.serviciomvn.security.service.UsuarioService;
import com.unac.serviciomvn.services.MensajeService;


@RestController
@RequestMapping("/mensaje")
@CrossOrigin(origins = "*")
public class MensajeController {
		@Autowired
	    MensajeService mensajeService;
		
		@Autowired
	    UsuarioService usuarioService;
		
	    
		@GetMapping("/lista")
	    public ResponseEntity<List<MensajePrueba>> list(){
	        List<MensajePrueba> list = mensajeService.list();
	        return new ResponseEntity(list, HttpStatus.OK);
	    }
	    @GetMapping("/lista2")
	    public ResponseEntity<List<MensajeUsuario>> listMensaje(){
	        List<MensajeUsuario> list = mensajeService.MensajeUsuario();
	        return new ResponseEntity(list, HttpStatus.OK);
	    }
		@GetMapping("/detail/{id}")
	    public ResponseEntity<MensajePrueba> getById(@PathVariable("id") int id){
	        if(!mensajeService.existsById(id))
	            return new ResponseEntity(new Mensaje("mensaje no encontrado"), HttpStatus.NOT_FOUND);
	        MensajePrueba mensaje = mensajeService.getOne(id).get();
	        return new ResponseEntity(mensaje, HttpStatus.OK);
	    }
		@PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody MensajePrueba mensajeModel){
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	Optional<Usuario> user = usuarioService.getByNombreUsuario(auth.getName());
	    	Integer iduser = user.flatMap(Usuario::getId).orElse(0);
			
			mensajeModel.setIdUser(iduser);	
			mensajeService.save(mensajeModel);
	        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
	    }
		@PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody MensajePrueba mensajeModel){
			
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	Optional<Usuario> user = usuarioService.getByNombreUsuario(auth.getName());
	    	Integer iduser = user.flatMap(Usuario::getId).orElse(0);
			
			
			MensajePrueba mensaje = mensajeService.getOne(id).get();
			mensaje.setMensaje(mensajeModel.getMensaje());
			mensaje.setIdUser(iduser);
			mensajeService.save(mensaje);
	        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
	    }
		@DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")int id){
	        if(!mensajeService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        mensajeService.delete(id);
	        return new ResponseEntity(new Mensaje("mensaje eliminado"), HttpStatus.OK);
	    }
}
