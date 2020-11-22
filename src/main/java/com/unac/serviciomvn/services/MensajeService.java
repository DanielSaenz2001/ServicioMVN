package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.MensajePrueba;
import com.unac.serviciomvn.model.MensajeUsuario;
import com.unac.serviciomvn.repository.MensajeRepository;

@Service
@Transactional
public class MensajeService {
	@Autowired
    MensajeRepository mensajeRepository;
	
	public List<MensajePrueba> list(){
        return mensajeRepository.findAll();
    }

    public Optional<MensajePrueba> getOne(int id){
        return mensajeRepository.findById(id);
    }

    /*public Optional<Mensaje> getByNombre(String nombre){
        return mensajeRepository.findByNombre(nombre);
    }*/

    public void save(MensajePrueba mensaje){
    	mensajeRepository.save(mensaje);
    }

    public void delete(int id){
    	mensajeRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return mensajeRepository.existsById(id);
    }

    public List<MensajeUsuario> MensajeUsuario(){
        return mensajeRepository.MensajeUser();
    }
	
	
}
