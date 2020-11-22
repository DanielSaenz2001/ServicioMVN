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
import com.unac.serviciomvn.services.VehiculoService;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin(origins = "*")
public class VehiculoController {
	@Autowired
	VehiculoService vehiculoService;
	
	
	@GetMapping("/lista")
    public ResponseEntity<List<Vehiculo>> list(){
        List<Vehiculo> list = vehiculoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

	
	@GetMapping("/detail/{id}")
    public ResponseEntity<Vehiculo> getById(@PathVariable("id") int id){
        if(!vehiculoService.existsById(id))
            return new ResponseEntity(new Mensaje("mensaje no encontrado"), HttpStatus.NOT_FOUND);
        Vehiculo vehiculo = vehiculoService.getOne(id).get();
        return new ResponseEntity(vehiculo, HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Vehiculo vehiculoModel){
		
    	
    	if(!vehiculoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
    	Vehiculo vehiculo = vehiculoService.getOne(id).get();
    	
    	vehiculo.setColor(vehiculoModel.getColor());
    	vehiculo.setFechaActualizacion(vehiculoModel.getFechaActualizacion());
    	vehiculo.setMarca(vehiculoModel.getMarca());
    	vehiculo.setModelo(vehiculoModel.getModelo());
    	vehiculo.setPlaca(vehiculoModel.getPlaca());
    	vehiculo.setImagenVehiculo(vehiculoModel.getImagenVehiculo());
    	vehiculo.setTipo(vehiculoModel.getTipo());
    	vehiculo.setUsuarioActualizacion(vehiculoModel.getUsuarioActualizacion());
    	
    	vehiculoService.save(vehiculo);
    	
        return new ResponseEntity(vehiculo, HttpStatus.OK);
    }
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Vehiculo vehiculo){

		vehiculoService.save(vehiculo);
        return new ResponseEntity(vehiculo, HttpStatus.OK);
    }
	@PostMapping("/filtrar")
	public ResponseEntity<List<Vehiculo>> filtroPlaca(@RequestBody Vehiculo vehiculo){
		List<Vehiculo> list = vehiculoService.findByPlaca(vehiculo.getPlaca());
		return new ResponseEntity(list, HttpStatus.OK);
    }
	/*@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		if(!propietarioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		propietarioService.delete(id);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }*/
}
