package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.RepuestosReparacion;
import com.unac.serviciomvn.repository.RepuestosReparacionRepository;

@Service
@Transactional
public class RepuestosReparacionService {
	@Autowired
    RepuestosReparacionRepository repuestosReparacionRepository;
	
	public List<RepuestosReparacion> list(){
        return repuestosReparacionRepository.findAll();
    }
    public Optional<RepuestosReparacion> getOne(int id){
        return repuestosReparacionRepository.findById(id);
    }
    public void save(RepuestosReparacion repuestosReparacion){
    	repuestosReparacionRepository.save(repuestosReparacion);
    }

    public void delete(int id){
    	repuestosReparacionRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return repuestosReparacionRepository.existsById(id);
    }
}