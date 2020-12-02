package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.DetallesReparacion;
import com.unac.serviciomvn.model.ServicioReparacion;
import com.unac.serviciomvn.repository.ServicioReparacionRepository;
@Service
@Transactional
public class ServicioReparacionService {
	@Autowired
    ServicioReparacionRepository servicioReparacionRepository;
	
	public List<ServicioReparacion> list(){
        return servicioReparacionRepository.findAll();
    }
	public List<ServicioReparacion> listServ(DetallesReparacion idDetalles){
        return servicioReparacionRepository.findByidDetalles(idDetalles);
    }
    public Optional<ServicioReparacion> getOne(int id){
        return servicioReparacionRepository.findById(id);
    }
    public void save(ServicioReparacion vehiculoReparacion){
    	servicioReparacionRepository.save(vehiculoReparacion);
    }

    public void delete(int id){
    	servicioReparacionRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return servicioReparacionRepository.existsById(id);
    }
}