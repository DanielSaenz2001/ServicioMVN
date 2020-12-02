package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.Empleado;
import com.unac.serviciomvn.model.Propietario;
import com.unac.serviciomvn.repository.PropietarioRepository;
import com.unac.serviciomvn.security.model.Usuario;

@Service
@Transactional
public class PropietarioService {
	@Autowired
    PropietarioRepository propietarioRepository;
	
	public List<Propietario> list(){
        return propietarioRepository.findAll();
    }

    public Optional<Propietario> getOne(int id){
        return propietarioRepository.findById(id);
    }

    /*public Optional<Mensaje> getByNombre(String nombre){
        return mensajeRepository.findByNombre(nombre);
    }*/
    public boolean existsByPropietario(Usuario id_usuario){
        return propietarioRepository.existsByIdUsuario(id_usuario);
    }
    public void save(Propietario propietario){
    	propietarioRepository.save(propietario);
    }

    public void delete(int id){
    	propietarioRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return propietarioRepository.existsById(id);
    }
    public List<Propietario> findByParameters(String cedula,String nombre){
        return propietarioRepository.findByCedulaIsContainingAndNombreIsContaining(cedula,nombre);
    }
    public boolean existsByEmail(String email){
        return propietarioRepository.existsByEmail(email);
    }
    public boolean existsByTelefono(String telefono){
        return propietarioRepository.existsByTelefono(telefono);
    }
    public boolean existsByCedula(String cedula){
        return propietarioRepository.existsByCedula(cedula);
    }
    public Propietario getPropietarioById(Usuario id_usuario){
        return propietarioRepository.findByIdUsuario(id_usuario);
    }
}
