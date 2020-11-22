package com.unac.serviciomvn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.Vehiculo;


@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>   {
    List<Vehiculo> findByPlacaIsContaining(String placa);
    List<Vehiculo> findByIdVehiculo(int idVehiculo);
}
