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
import com.unac.serviciomvn.model.DetallesReparacion;
import com.unac.serviciomvn.model.EtapasReparacion;
import com.unac.serviciomvn.repository.EtapasReparacionRepository;
import com.unac.serviciomvn.services.DetallesReparacionService;

@RestController
@RequestMapping("/detalles/reparacion")
@CrossOrigin(origins = "*")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class DetallesReparacionController {
	@Autowired
	DetallesReparacionService detallesReparacionService;
	
	@Autowired
	EtapasReparacionRepository EtapaService;
	
	@GetMapping("/lista")
    public ResponseEntity<List<DetallesReparacion>> list(){
        List<DetallesReparacion> list = detallesReparacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	@GetMapping("/etapas")
    public ResponseEntity<List<EtapasReparacion>> listEtapas(){
        List<EtapasReparacion> list = EtapaService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	@PostMapping("/lista/vehiculo")
    public ResponseEntity<List<DetallesReparacion>> listDetalles(@RequestBody DetallesReparacion detalles){
        List<DetallesReparacion> list = detallesReparacionService.listDetallesVehiculo(detalles.getIdVehiculoReparacionDetalle());
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	@GetMapping("/detail/{id}")
    public ResponseEntity<DetallesReparacion> getById(@PathVariable("id") int id){
        if(!detallesReparacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
        DetallesReparacion detalles = detallesReparacionService.getOne(id).get();
        return new ResponseEntity(detalles, HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DetallesReparacion detallesModel){
		
    	
    	if(!detallesReparacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe nadie con ese ID"), HttpStatus.NOT_FOUND);
    	DetallesReparacion detalle = detallesReparacionService.getOne(id).get();
    	
    	if(detallesReparacionService.existsByConfirmacion(id, detallesModel.isConfirmarReparacion()))
			return new ResponseEntity(new Mensaje("Ya esta actualizada"), HttpStatus.NOT_FOUND);
		
    	if(detallesModel.getIdEtapaReparacion().getIdEtapas() == 4) {
    		System.out.println("AUTORIZANDO");
    		detalle.setConfirmarReparacion(detallesModel.isConfirmarReparacion());
	    	detalle.setFechaFin(detallesModel.getFechaFin());
	    	detalle.setIdPropietarioDetalle(detallesModel.getIdPropietarioDetalle());
    	}
    		
    		
    	if(detallesModel.getIdEtapaReparacion().getIdEtapas() == 6) {
    		System.out.println("CONTROL");
    		detalle.setConfirmarReparacion(detallesModel.isConfirmarReparacion());
	    	detalle.setFechaFin(detallesModel.getFechaFin());
	    	detalle.setIdEmpleadoDetalle(detallesModel.getIdEmpleadoDetalle());
    	}
    		

    	detallesReparacionService.save(detalle);
    	
        return new ResponseEntity(detalle, HttpStatus.OK);
    }
	@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DetallesReparacion detalles){
		if(detallesReparacionService.existsByEtapa(detalles.getIdEtapaReparacion(), detalles.getIdVehiculoReparacionDetalle()))
			return new ResponseEntity(new Mensaje("Ya existe la placa registrada"), HttpStatus.NOT_FOUND);

		detallesReparacionService.save(detalles);
        return new ResponseEntity(detalles, HttpStatus.OK);
    }
	/*@PostMapping("/filtrar")
	public ResponseEntity<List<DetallesReparacion>> filtroPlaca(@RequestBody Vehiculo vehiculo){
		List<Vehiculo> list = vehiculoService.findByPlaca(vehiculo.getPlaca());
		return new ResponseEntity(list, HttpStatus.OK);
    }*/
}
