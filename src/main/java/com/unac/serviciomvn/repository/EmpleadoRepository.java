package com.unac.serviciomvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.Empleado;
import com.unac.serviciomvn.security.model.Usuario;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>  {
	List<Empleado> findByCedulaIsContainingAndNombreIsContaining(String cedula, String nombre);
	Empleado findByIdUsuario(Usuario id_usuario);
    boolean existsByIdUsuario(Usuario id_usuario);
    boolean existsByEmail(String email);
    boolean existsByCedula(String cedula);
    boolean existsByTelefono(String telefono);
}
