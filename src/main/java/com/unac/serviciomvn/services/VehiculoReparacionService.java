package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.Vehiculo;
import com.unac.serviciomvn.model.VehiculoReparacion;
import com.unac.serviciomvn.repository.VehiculoReparacionRepository;

@Service
@Transactional
public class VehiculoReparacionService {
	@Autowired
    VehiculoReparacionRepository vehiculoReparacionRepository;
	
	public List<VehiculoReparacion> list(){
        return vehiculoReparacionRepository.findAll();
    }

    public Optional<VehiculoReparacion> getOne(int id){
        return vehiculoReparacionRepository.findById(id);
    }
    
    public VehiculoReparacion findById(int id){
        return vehiculoReparacionRepository.findId(id);
    }
    public VehiculoReparacion findByPlaca(String placa){
        return vehiculoReparacionRepository.findPlacaVehiculo(placa);
    }
    public void save(VehiculoReparacion vehiculoReparacion){
    	vehiculoReparacionRepository.save(vehiculoReparacion);
    }

    public void delete(int id){
    	vehiculoReparacionRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return vehiculoReparacionRepository.existsById(id);
    }
    public boolean existsByfase(Vehiculo idVehiculoFactura ,String fase){
        return vehiculoReparacionRepository.existsByidVehiculoFacturaAndFase(idVehiculoFactura, fase);
    }
}