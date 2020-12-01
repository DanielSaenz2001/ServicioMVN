package com.unac.serviciomvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.Propietario;
import com.unac.serviciomvn.model.PropietarioVehiculo;
import com.unac.serviciomvn.model.Vehiculo;

@Repository
public interface PropietarioVehiculoRepository extends JpaRepository<PropietarioVehiculo, Integer>  {
	//@Query("select pv from PropietarioVehiculo pv where pv.idPropietario = :propietario and pv.idVehiculo =:vehiculo")
	boolean existsByIdPropietarioAndIdVehiculo(Propietario idPropietario, Vehiculo idVehiculo);

	List<PropietarioVehiculo>  findByIdVehiculo(Vehiculo idVehiculo);
	List<PropietarioVehiculo>  findByIdPropietario(Propietario idPropietario);
}
