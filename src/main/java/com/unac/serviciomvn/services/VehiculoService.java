package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.Vehiculo;
import com.unac.serviciomvn.repository.VehiculoRepository;

@Service
@Transactional
public class VehiculoService {
	@Autowired
    VehiculoRepository vehiculoRepository;
	public List<Vehiculo> list(){
        return vehiculoRepository.findAll();
    }

    public Optional<Vehiculo> getOne(int id){
        return vehiculoRepository.findById(id);
    }

    public void save(Vehiculo vehiculo){
    	vehiculoRepository.save(vehiculo);
    }

    public void delete(int id){
    	vehiculoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return vehiculoRepository.existsById(id);
    }
    public List<Vehiculo> findByIdVehiculo(int idVehiculo){
        return vehiculoRepository.findByIdVehiculo(idVehiculo);
    }
    public List<Vehiculo> findByPlaca(String placa){
        return vehiculoRepository.findByPlacaIsContaining(placa);
    }
}
