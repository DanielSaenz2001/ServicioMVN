package com.unac.serviciomvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.DetallesReparacion;
import com.unac.serviciomvn.model.EtapasReparacion;
import com.unac.serviciomvn.model.VehiculoReparacion;

@Repository
public interface DetallesReparacionRepository extends JpaRepository<DetallesReparacion, Integer>  {
	boolean existsByIdEtapaReparacionAndIdVehiculoReparacionDetalle(EtapasReparacion idEtapaReparacion, VehiculoReparacion idVehiculoReparacionDetalle);
	boolean existsByIdDetallesAndConfirmarReparacion(int idDetalles, Boolean confirmarReparacion);

	List<DetallesReparacion>  findByIdVehiculoReparacionDetalle(VehiculoReparacion idVehiculoReparacion);

	@Query("Select d from DetallesReparacion d where d.idDetalles = :idDetalles")
	DetallesReparacion findId(int idDetalles);
}
