package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.Empleado;
import com.unac.serviciomvn.repository.EmpleadoRepository;

@Service
@Transactional
public class EmpleadoService {
	@Autowired
    EmpleadoRepository empleadoRepository;
	
	public List<Empleado> list(){
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> getOne(int id){
        return empleadoRepository.findById(id);
    }

    /*public Optional<Mensaje> getByNombre(String nombre){
        return mensajeRepository.findByNombre(nombre);
    }*/

    public void save(Empleado empleado){
    	empleadoRepository.save(empleado);
    }

    public void delete(int id){
    	empleadoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return empleadoRepository.existsById(id);
    }
    public List<Empleado> findByParameters(String cedula,String nombre, String apellidos){
        return empleadoRepository.findByCedulaIsContainingAndNombreIsContainingAndApellidosIsContaining(cedula,nombre,apellidos);
    }
}
