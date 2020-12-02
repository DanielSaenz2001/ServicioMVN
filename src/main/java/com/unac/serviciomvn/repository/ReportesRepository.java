package com.unac.serviciomvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.Empleado;
import com.unac.serviciomvn.model.Reportes;

@Repository
public interface ReportesRepository extends JpaRepository<Reportes, Integer>  {
	List<Reportes>  findByidEmpleadoReporte(Empleado idEmpleadoReporte);
}
