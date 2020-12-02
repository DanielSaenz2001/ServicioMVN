package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.DetallesReparacion;
import com.unac.serviciomvn.model.EtapasReparacion;
import com.unac.serviciomvn.model.VehiculoReparacion;
import com.unac.serviciomvn.repository.DetallesReparacionRepository;

@Service
@Transactional
public class DetallesReparacionService {
	@Autowired
    DetallesReparacionRepository detallesReparacionRepository;
	
	public List<DetallesReparacion> list(){
        return detallesReparacionRepository.findAll();
    }
	public List<DetallesReparacion> listDetallesVehiculo(VehiculoReparacion idVehiculoReparacion){
        return detallesReparacionRepository.findByIdVehiculoReparacionDetalle(idVehiculoReparacion);
    }
    public Optional<DetallesReparacion> getOne(int id){
        return detallesReparacionRepository.findById(id);
    }
    
    public DetallesReparacion findById(int id){
        return detallesReparacionRepository.findId(id);
    }
    public void save(DetallesReparacion vehiculoReparacion){
    	detallesReparacionRepository.save(vehiculoReparacion);
    }

    public void delete(int id){
    	detallesReparacionRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return detallesReparacionRepository.existsById(id);
    }
    
    public boolean existsByConfirmacion(int idDetalles,boolean confirmarReparacion){
        return detallesReparacionRepository.existsByIdDetallesAndConfirmarReparacion(idDetalles, confirmarReparacion);
    }
    
    public boolean existsByEtapa(EtapasReparacion idEtapaReparacion, VehiculoReparacion idVehiculoReparacion){
        return detallesReparacionRepository.existsByIdEtapaReparacionAndIdVehiculoReparacionDetalle(idEtapaReparacion,idVehiculoReparacion);
    }
}