package com.unac.serviciomvn.security.service;

import com.unac.serviciomvn.security.model.Rol;
import com.unac.serviciomvn.security.enums.RolNombre;
import com.unac.serviciomvn.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
    public List<Rol> list(){
        return rolRepository.findAll();
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
