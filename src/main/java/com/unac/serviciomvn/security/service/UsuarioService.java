package com.unac.serviciomvn.security.service;


import com.unac.serviciomvn.security.model.Usuario;
import com.unac.serviciomvn.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional


public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public List<Usuario> list(){
        return usuarioRepository.findAll();
    }
    
    
    public Optional<Usuario> getOne(int id){
        return usuarioRepository.findById(id);
    }
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    
    public boolean existsById(int id){
        return usuarioRepository.existsById(id);
    }
}
