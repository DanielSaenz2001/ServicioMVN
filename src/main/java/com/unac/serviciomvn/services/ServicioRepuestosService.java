package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.ServicioReparacion;
import com.unac.serviciomvn.model.ServicioRepuestos;
import com.unac.serviciomvn.repository.ServicioRepuestosRepository;

@Service
@Transactional
public class ServicioRepuestosService {
	@Autowired
    ServicioRepuestosRepository servicioRepuestosRepository;
	
	public List<ServicioRepuestos> list(){
        return servicioRepuestosRepository.findAll();
    }
	public List<ServicioRepuestos> listServ(ServicioReparacion idServicio){
        return servicioRepuestosRepository.findByidServicio(idServicio);
    }
    public Optional<ServicioRepuestos> getOne(int id){
        return servicioRepuestosRepository.findById(id);
    }
    public void save(ServicioRepuestos servicioRepuestos){
    	servicioRepuestosRepository.save(servicioRepuestos);
    }

    public void delete(int id){
    	servicioRepuestosRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return servicioRepuestosRepository.existsById(id);
    }
}