package com.unac.serviciomvn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unac.serviciomvn.model.Empleado;
import com.unac.serviciomvn.model.Reportes;
import com.unac.serviciomvn.repository.ReportesRepository;


@Service
@Transactional
public class ReportesService {
	@Autowired
    ReportesRepository reportesRepository;
	
	public List<Reportes> list(){
        return reportesRepository.findAll();
    }

    public Optional<Reportes> getOne(int id){
        return reportesRepository.findById(id);
    }

    /*public Optional<Mensaje> getByNombre(String nombre){
        return mensajeRepository.findByNombre(nombre);
    }*/

    public void save(Reportes reporte){
    	reportesRepository.save(reporte);
    }

    public void delete(int id){
    	reportesRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return reportesRepository.existsById(id);
    }
    public List<Reportes> findByParameters(Empleado idEmpleadoReporte){
        return reportesRepository.findByidEmpleadoReporte(idEmpleadoReporte);
    }

}
