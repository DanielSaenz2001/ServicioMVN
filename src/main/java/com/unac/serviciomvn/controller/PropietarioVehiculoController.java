package com.unac.serviciomvn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unac.serviciomvn.dto.Mensaje;
import com.unac.serviciomvn.model.Propietario;
import com.unac.serviciomvn.model.PropietarioVehiculo;
import com.unac.serviciomvn.model.Vehiculo;
import com.unac.serviciomvn.services.PropietarioService;
import com.unac.serviciomvn.services.PropietarioVehiculoService;
import com.unac.serviciomvn.services.VehiculoService;

@RestController
@RequestMapping("/propietariovehiculo")
@CrossOrigin(origins = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PropietarioVehiculoController {
	@Autowired
	PropietarioVehiculoService propietarioVehiculoService;

	@Autowired
	VehiculoService vehiculoService;
	
	@Autowired
	PropietarioService propietarioService;
	
	@GetMapping("/lista")
    public ResponseEntity<List<PropietarioVehiculo>> list(){
        List<PropietarioVehiculo> list = propietarioVehiculoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PropietarioVehiculo propietarioVehiculo){
		if(propietarioVehiculoService.existsdByIdPropietarioAndIdVehiculo(propietarioVehiculo.getIdPropietario(), propietarioVehiculo.getIdVehiculo()))
			return new ResponseEntity(new Mensaje("El propietario ya cuenta con ese vehiculo"), HttpStatus.BAD_REQUEST);
		propietarioVehiculoService.save(propietarioVehiculo);
        return new ResponseEntity(propietarioVehiculo, HttpStatus.OK);
    }
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
		System.out.println(id);
		System.out.println(!propietarioVehiculoService.existsById(id));
		if(!propietarioVehiculoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		propietarioVehiculoService.delete(id);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }
	@GetMapping("/lista/vehiculos/{id}")
    public ResponseEntity<List<PropietarioVehiculo>> listVehiculos(@PathVariable("id") int id){
		if(!vehiculoService.existsById(id))
			return new ResponseEntity(new Mensaje("mensaje no encontrado"), HttpStatus.NOT_FOUND);
		Vehiculo vehiculo = vehiculoService.getOne(id).get();
        List<PropietarioVehiculo> list = propietarioVehiculoService.findByIdVehiculo(vehiculo);
        return new ResponseEntity(list, HttpStatus.OK);
    }
	@GetMapping("/lista/propietarios/{id}")
	public ResponseEntity<List<PropietarioVehiculo>> listPropietarios(@PathVariable("id") int id){
		if(!propietarioService.existsById(id))
			return new ResponseEntity(new Mensaje("mensaje no encontrado"), HttpStatus.NOT_FOUND);
		Propietario propietario = propietarioService.getOne(id).get();
        List<PropietarioVehiculo> list = propietarioVehiculoService.findByIdPropietario(propietario);
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
