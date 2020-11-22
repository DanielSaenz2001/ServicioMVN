package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.Propietario;
import com.unac.serviciomvn.repository.PropietarioRepository;

@Service
@Transactional
public class PropietarioService {
	@Autowired
    PropietarioRepository propietarioRepository;
	
	public List<Propietario> list(){
        return propietarioRepository.findAll();
    }

    public Optional<Propietario> getOne(int id){
        return propietarioRepository.findById(id);
    }

    /*public Optional<Mensaje> getByNombre(String nombre){
        return mensajeRepository.findByNombre(nombre);
    }*/

    public void save(Propietario propietario){
    	propietarioRepository.save(propietario);
    }

    public void delete(int id){
    	propietarioRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return propietarioRepository.existsById(id);
    }
    public List<Propietario> findByParameters(String cedula,String nombre,String apellidos){
        return propietarioRepository.findByCedulaIsContainingAndNombreIsContainingAndApellidosIsContaining(cedula,nombre,apellidos);
    }
}
