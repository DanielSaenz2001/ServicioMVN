package com.unac.serviciomvn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.ServicioReparacion;
import com.unac.serviciomvn.model.ServicioRepuestos;

@Repository
public interface ServicioRepuestosRepository extends JpaRepository<ServicioRepuestos, Integer>  {
	List<ServicioRepuestos>  findByidServicio(ServicioReparacion idServicio);
}