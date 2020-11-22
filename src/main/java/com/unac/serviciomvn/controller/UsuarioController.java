package com.unac.serviciomvn.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unac.serviciomvn.dto.Mensaje;
import com.unac.serviciomvn.model.MensajePrueba;
import com.unac.serviciomvn.security.dto.JwtDto;
import com.unac.serviciomvn.security.dto.LoginUsuario;
import com.unac.serviciomvn.security.enums.RolNombre;
import com.unac.serviciomvn.security.model.Rol;
import com.unac.serviciomvn.security.model.Usuario;
import com.unac.serviciomvn.security.service.RolService;
import com.unac.serviciomvn.security.service.UsuarioService;
import com.unac.serviciomvn.services.MensajeService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
	@Autowired
    UsuarioService usuarioService;
	@Autowired
    RolService rolService;
	
	@GetMapping("/lista")
    public ResponseEntity<List<Usuario>> list(){
        List<Usuario> list = usuarioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@GetMapping("/roles")
    public ResponseEntity<List<Rol>> roles(){
        List<Rol> list = rolService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@GetMapping("/detail/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") int id){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("mensaje no encontrado"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioService.getOne(id).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Usuario usuarioModel){
		
    	Usuario usuario = usuarioService.getOne(id).get();
    	if(!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
    	usuario.setEstadoContrato(usuarioModel.getEstadoContrato());
    	usuario.setImagenUser(usuarioModel.getImagenUser());
    	usuario.setNombreUsuario(usuarioModel.getNombreUsuario());
    	usuario.setRoles(usuarioModel.getRoles());
    	usuarioService.save(usuario);
        return new ResponseEntity(usuario, HttpStatus.OK);
    }
	@PostMapping("/filtrar")
	public ResponseEntity<List<Usuario>> filtroNombre(@RequestBody Usuario usuarioModel){
		Optional<Usuario> list = usuarioService.getByNombreUsuario(usuarioModel.getNombreUsuario());
		return new ResponseEntity(list, HttpStatus.OK);
    }
}
