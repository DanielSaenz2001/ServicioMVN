package com.unac.serviciomvn.security.controller;

import com.unac.serviciomvn.dto.Mensaje;
import com.unac.serviciomvn.security.dto.JwtDto;
import com.unac.serviciomvn.security.dto.LoginUsuario;
import com.unac.serviciomvn.security.dto.NuevoUsuario;
import com.unac.serviciomvn.security.model.Rol;
import com.unac.serviciomvn.security.model.Usuario;
import com.unac.serviciomvn.security.enums.RolNombre;
import com.unac.serviciomvn.security.jwt.JwtProvider;
import com.unac.serviciomvn.security.service.RolService;
import com.unac.serviciomvn.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(  nuevoUsuario.getNombreUsuario(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()),
                        nuevoUsuario.getImagenUser(), nuevoUsuario.getEstadoContrato());
        Set<Rol> roles = new HashSet<>();
        if(nuevoUsuario.getRoles().contains("ROLE_TECNICOS_TALLER"))
        	roles.add(rolService.getByRolNombre(RolNombre.ROLE_TECNICOS_TALLER).get());
        if(nuevoUsuario.getRoles().contains("ROLE_SUPERVISOR_TALLER"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_SUPERVISOR_TALLER).get());
        if(nuevoUsuario.getRoles().contains("ROLE_ASISTENTE_RECURSOS_HUMANOS"))
        	roles.add(rolService.getByRolNombre(RolNombre.ROLE_ASISTENTE_RECURSOS_HUMANOS).get());
        if(nuevoUsuario.getRoles().contains("ROLE_ASISTENTE_FINANCIERO"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ASISTENTE_FINANCIERO).get());
        if(nuevoUsuario.getRoles().contains("ROLE_GERENTE_FINANCIERO"))
        	roles.add(rolService.getByRolNombre(RolNombre.ROLE_GERENTE_FINANCIERO).get());
        if(nuevoUsuario.getRoles().contains("ROLE_ASISTENTE_GERENCIA"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ASISTENTE_GERENCIA).get());
        if(nuevoUsuario.getRoles().contains("ROLE_GERENTE_GENERAL"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_GERENTE_GENERAL).get());
        if(nuevoUsuario.getRoles().contains("ROLE_INVITADO"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_INVITADO).get());
        usuario.setRoles(roles);
        Usuario usuarioCreate = usuarioService.save(usuario);
        return new ResponseEntity(usuarioCreate, HttpStatus.CREATED);
    }
    
    @PostMapping("/registerPropietario")
    public ResponseEntity<?> nuevoPropietario(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(  nuevoUsuario.getNombreUsuario(),
                        nuevoUsuario.getPassword(),
                        nuevoUsuario.getImagenUser(), nuevoUsuario.getEstadoContrato());
        Set<Rol> roles = new HashSet<>();
        if(nuevoUsuario.getRoles().contains("ROLE_TECNICOS_TALLER"))
        	roles.add(rolService.getByRolNombre(RolNombre.ROLE_TECNICOS_TALLER).get());
        if(nuevoUsuario.getRoles().contains("ROLE_SUPERVISOR_TALLER"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_SUPERVISOR_TALLER).get());
        if(nuevoUsuario.getRoles().contains("ROLE_ASISTENTE_RECURSOS_HUMANOS"))
        	roles.add(rolService.getByRolNombre(RolNombre.ROLE_ASISTENTE_RECURSOS_HUMANOS).get());
        if(nuevoUsuario.getRoles().contains("ROLE_ASISTENTE_FINANCIERO"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ASISTENTE_FINANCIERO).get());
        if(nuevoUsuario.getRoles().contains("ROLE_GERENTE_FINANCIERO"))
        	roles.add(rolService.getByRolNombre(RolNombre.ROLE_GERENTE_FINANCIERO).get());
        if(nuevoUsuario.getRoles().contains("ROLE_ASISTENTE_GERENCIA"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ASISTENTE_GERENCIA).get());
        if(nuevoUsuario.getRoles().contains("ROLE_GERENTE_GENERAL"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_GERENTE_GENERAL).get());
        if(nuevoUsuario.getRoles().contains("ROLE_INVITADO"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_INVITADO).get());
        usuario.setRoles(roles);
        Usuario usuarioCreate = usuarioService.save(usuario);
        return new ResponseEntity(usuarioCreate, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(authentication.getDetails());
        String jwt = jwtProvider.generateToken(authentication);
        System.out.println(jwt);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        System.out.println(userDetails);
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    /*@PostMapping("/invitado")
    public ResponseEntity<JwtDto> invitado(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }*/
    
    @GetMapping("/me")
    public ResponseEntity<JwtDto> me(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	Optional<Usuario> user = usuarioService.getByNombreUsuario(auth.getName());
    	
    	System.out.println(userID());
    	return new ResponseEntity(user, HttpStatus.OK);
    	
    	
    }
    
    public Integer userID() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	Optional<Usuario> user = usuarioService.getByNombreUsuario(auth.getName());
    	Integer id = user.flatMap(Usuario::getId).orElse(0);
    	System.out.println(id);
    	return id;
    }
}
