package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.Empleado;
import com.unac.serviciomvn.repository.EmpleadoRepository;
import com.unac.serviciomvn.security.model.Usuario;

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
    public List<Empleado> findByParameters(String cedula,String nombre){
        return empleadoRepository.findByCedulaIsContainingAndNombreIsContaining(cedula,nombre);
    }
    public Empleado getEmpleadoById(Usuario id_usuario){
        return empleadoRepository.findByIdUsuario(id_usuario);
    }
    public boolean existsByEmpleado(Usuario id_usuario){
        return empleadoRepository.existsByIdUsuario(id_usuario);
    }
    public boolean existsByEmail(String email){
        return empleadoRepository.existsByEmail(email);
    }
    public boolean existsByTelefono(String telefono){
        return empleadoRepository.existsByTelefono(telefono);
    }
    public boolean existsByCedula(String cedula){
        return empleadoRepository.existsByCedula(cedula);
    }
}
