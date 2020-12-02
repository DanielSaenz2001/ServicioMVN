package com.unac.serviciomvn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.Vehiculo;
import com.unac.serviciomvn.model.VehiculoReparacion;


@Repository
public interface VehiculoReparacionRepository extends JpaRepository<VehiculoReparacion, Integer>   {
	boolean existsByidVehiculoFacturaAndFase(Vehiculo idVehiculoFactura,String fase);
	

	@Query("Select v from VehiculoReparacion v where v.idVehiculoFactura.placa = :placa")
    VehiculoReparacion findPlacaVehiculo(String placa);
	
	@Query("Select v from VehiculoReparacion v where v.idVehiculoReparacion = :idVehiculoReparacion")
    VehiculoReparacion findId(int idVehiculoReparacion);
}
