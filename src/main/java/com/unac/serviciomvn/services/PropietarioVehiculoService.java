package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.Propietario;
import com.unac.serviciomvn.model.PropietarioVehiculo;
import com.unac.serviciomvn.model.Vehiculo;
import com.unac.serviciomvn.repository.PropietarioVehiculoRepository;

@Service
@Transactional
public class PropietarioVehiculoService {
	@Autowired
    PropietarioVehiculoRepository propietarioVehiculoRepository;
	
	public List<PropietarioVehiculo> list(){
        return propietarioVehiculoRepository.findAll();
    }

    public Optional<PropietarioVehiculo> getOne(int id){
        return propietarioVehiculoRepository.findById(id);
    }


    public void save(PropietarioVehiculo empleado){
    	propietarioVehiculoRepository.save(empleado);
    }

    public void delete(int id){
    	propietarioVehiculoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return propietarioVehiculoRepository.existsById(id);
    }
    public boolean existsdByIdPropietarioAndIdVehiculo(Propietario propietario, Vehiculo vehiculo){
        return propietarioVehiculoRepository.existsByIdPropietarioAndIdVehiculo(propietario,vehiculo);
    }
    public List<PropietarioVehiculo> findByIdVehiculo(Vehiculo vehiculo){
        return propietarioVehiculoRepository.findByIdVehiculo(vehiculo);
    }
    public List<PropietarioVehiculo> findByIdPropietario(Propietario propietario){
        return propietarioVehiculoRepository.findByIdPropietario(propietario);
    }
}
