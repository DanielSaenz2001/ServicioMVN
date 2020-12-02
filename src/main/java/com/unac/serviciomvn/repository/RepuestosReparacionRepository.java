package com.unac.serviciomvn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.RepuestosReparacion;

@Repository
public interface RepuestosReparacionRepository extends JpaRepository<RepuestosReparacion, Integer>  {
}