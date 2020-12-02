package com.unac.serviciomvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.DetallesReparacion;
import com.unac.serviciomvn.model.ServicioReparacion;

@Repository
public interface ServicioReparacionRepository extends JpaRepository<ServicioReparacion, Integer>  {
	List<ServicioReparacion>  findByidDetalles(DetallesReparacion idDetalles);
}