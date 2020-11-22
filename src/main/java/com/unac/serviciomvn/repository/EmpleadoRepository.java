package com.unac.serviciomvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>  {
	List<Empleado> findByCedulaIsContainingAndNombreIsContainingAndApellidosIsContaining(String cedula, String nombre,String apellidos);
}
