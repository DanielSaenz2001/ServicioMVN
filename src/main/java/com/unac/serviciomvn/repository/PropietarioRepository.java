package com.unac.serviciomvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.Propietario;
import com.unac.serviciomvn.model.Vehiculo;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {
	List<Propietario> findByCedulaIsContainingAndNombreIsContainingAndApellidosIsContaining(String cedula,String nombre,String apellidos);
    List<Propietario> findByIdPropietario(int idVehiculo);
}
