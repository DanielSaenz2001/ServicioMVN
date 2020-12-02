package com.unac.serviciomvn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unac.serviciomvn.dto.Mensaje;
import com.unac.serviciomvn.model.Vehiculo;
import com.unac.serviciomvn.model.VehiculoReparacion;
import com.unac.serviciomvn.services.VehiculoReparacionService;


@RestController
@RequestMapping("/vehiculo/reparacion")
@CrossOrigin(origins = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class VehiculoReparacionController {
	@Autowired
	VehiculoReparacionService vehiculoReparacionService;
	
	
	@GetMapping("/lista")
    public ResponseEntity<List<VehiculoReparacion>> list(){
        List<VehiculoReparacion> list = vehiculoReparacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

	
	@GetMapping("/detail/{id}")
    public ResponseEntity<VehiculoReparacion> getById(@PathVariable("id") int id){
        if(!vehiculoReparacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
        VehiculoReparacion vehiculo = vehiculoReparacionService.getOne(id).get();
        return new ResponseEntity(vehiculo, HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody VehiculoReparacion vehiculoModel){
		
    	
    	if(!vehiculoReparacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
    	VehiculoReparacion vehiculo = vehiculoReparacionService.getOne(id).get();
    	
    	
    	vehiculo.setPrecioTotal(vehiculoModel.getPrecioTotal());
    	vehiculo.setIdEmpleadoFactura(vehiculoModel.getIdEmpleadoFactura());
    	vehiculo.setFase(vehiculoModel.getFase());
    	vehiculo.setIdPropietarioFactura(vehiculoModel.getIdPropietarioFactura());
    	vehiculo.setFechaSalida(vehiculoModel.getFechaSalida());
    	
    	vehiculoReparacionService.save(vehiculo);
    	
        return new ResponseEntity(vehiculo, HttpStatus.OK);
    }
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VehiculoReparacion vehiculo){
		if(vehiculoReparacionService.existsByfase(vehiculo.getIdVehiculoFactura(),vehiculo.getFase()))
			return new ResponseEntity(new Mensaje("El vehiculo sigue en produccion"), HttpStatus.NOT_FOUND);

		vehiculoReparacionService.save(vehiculo);
        return new ResponseEntity(vehiculo, HttpStatus.OK);
    }
	@PostMapping("/filtrar")
	public ResponseEntity<List<VehiculoReparacion>> filtroPlaca(@RequestBody VehiculoReparacion vehiculo){
		List<VehiculoReparacion> list = (List<VehiculoReparacion>) vehiculoReparacionService.findByPlaca(vehiculo.getIdVehiculoFactura().getPlaca());
		return new ResponseEntity(list, HttpStatus.OK);
    }
}