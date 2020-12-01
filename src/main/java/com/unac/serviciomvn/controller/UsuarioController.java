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
import com.unac.serviciomvn.security.model.Rol;
import com.unac.serviciomvn.security.model.Usuario;
import com.unac.serviciomvn.security.service.RolService;
import com.unac.serviciomvn.security.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
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
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioService.getOne(id).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Usuario usuarioModel){
		
    	Usuario usuario = usuarioService.getOne(id).get();
    	if(!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
    	if(usuarioService.existsByNombreUsuario(usuarioModel.getNombreUsuario()) && !( usuario.getNombreUsuario().contentEquals(usuarioModel.getNombreUsuario())) )
            return new ResponseEntity(new Mensaje("El nombre del usuario ya existe"), HttpStatus.BAD_REQUEST);
    	usuario.setEstadoContrato(usuarioModel.getEstadoContrato());
    	usuario.setImagenUser(usuarioModel.getImagenUser());
    	usuario.setNombreUsuario(usuarioModel.getNombreUsuario());
    	usuario.setRoles(usuarioModel.getRoles());
    	usuarioService.save(usuario);
        return new ResponseEntity(usuario, HttpStatus.OK);
    }
	@PostMapping("/filtrar")
	public ResponseEntity<List<Usuario>> filtroNombre(@RequestBody Usuario usuarioModel){
		Usuario list = usuarioService.getByNombreUsuario(usuarioModel.getNombreUsuario());
		return new ResponseEntity(list, HttpStatus.OK);
    }
}
