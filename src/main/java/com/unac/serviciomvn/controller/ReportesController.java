package com.unac.serviciomvn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unac.serviciomvn.dto.Mensaje;
import com.unac.serviciomvn.model.Reportes;
import com.unac.serviciomvn.services.ReportesService;

@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ReportesController {
	@Autowired
	ReportesService reportesService;

	@PostMapping("/lista")
    public ResponseEntity<?> list(@RequestBody Reportes reportes){
		List<Reportes> list = reportesService.findByParameters(reportes.getIdEmpleadoReporte());
        return new ResponseEntity(list, HttpStatus.OK);
    }
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Reportes reportes){
		reportesService.save(reportes);
        return new ResponseEntity(reportes, HttpStatus.OK);
    }
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
		if(!reportesService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		reportesService.delete(id);
        return new ResponseEntity(new Mensaje("Repuesto Eliminado"), HttpStatus.OK);
    }
}
