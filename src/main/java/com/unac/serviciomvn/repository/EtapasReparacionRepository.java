package com.unac.serviciomvn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unac.serviciomvn.model.EtapasReparacion;


@Repository
public interface EtapasReparacionRepository extends JpaRepository<EtapasReparacion, Integer>  {
}