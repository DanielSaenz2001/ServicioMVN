package com.unac.serviciomvn.repository;

import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.MensajePrueba;
import com.unac.serviciomvn.model.MensajeUsuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface MensajeRepository extends JpaRepository<MensajePrueba, Integer>  {
	  	//Optional<Producto> findByNombre(String nombre);
	  	//boolean existsByNombre(String nombre);
	@Query("SELECT new com.unac.serviciomvn.model.MensajeUsuario(m.mensaje, u.nombreUsuario) FROM MensajePrueba m inner join Usuario u on m.idUser = u.id")
	public List<MensajeUsuario> MensajeUser();
		
}
