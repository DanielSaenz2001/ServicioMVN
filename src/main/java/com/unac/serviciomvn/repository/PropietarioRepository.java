package com.unac.serviciomvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.Empleado;
import com.unac.serviciomvn.model.Propietario;
import com.unac.serviciomvn.security.model.Usuario;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {
	List<Propietario> findByCedulaIsContainingAndNombreIsContaining(String cedula,String nombre);
    List<Propietario> findByIdPropietario(int idVehiculo);
    boolean existsByEmail(String email);
    boolean existsByCedula(String cedula);
    boolean existsByIdUsuario(Usuario id_usuario);
    boolean existsByTelefono(String telefono);
    Propietario findByIdUsuario(Usuario id_usuario);
}
