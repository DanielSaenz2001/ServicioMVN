package com.unac.serviciomvn.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Entity
@Data
@Table(name = "servicio_repuestos")
public class ServicioRepuestos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio_repuestos")
    private int idServicioRepuesto;
	
	@NotNull
	@JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private ServicioReparacion idServicio;
	
    @Column(name = "descuento_repuesto",nullable = true)       
    private int descuentoRespuesto;
	
	@NotNull
	@JoinColumn(name = "id_reparacion", referencedColumnName = "id_respuesto")
    @ManyToOne(optional = false)
    private RepuestosReparacion idRespuesto;
	public ServicioRepuestos() {
	}
	public ServicioRepuestos(@NotNull ServicioReparacion idServicio, int descuentoRespuesto,
			@NotNull RepuestosReparacion idRespuesto) {
		this.idServicio = idServicio;
		this.descuentoRespuesto = descuentoRespuesto;
		this.idRespuesto = idRespuesto;
	}

	public int getIdServicioRepuesto() {
		return idServicioRepuesto;
	}

	public void setIdServicioRepuesto(int idServicioRepuesto) {
		this.idServicioRepuesto = idServicioRepuesto;
	}

	public ServicioReparacion getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(ServicioReparacion idServicio) {
		this.idServicio = idServicio;
	}

	public int getDescuentoRepuesto() {
		return descuentoRespuesto;
	}

	public void setDescuentoRepuesto(int descuentoRespuesto) {
		this.descuentoRespuesto = descuentoRespuesto;
	}

	public RepuestosReparacion getIdRespuesto() {
		return idRespuesto;
	}

	public void setIdRespuesto(RepuestosReparacion idRespuesto) {
		this.idRespuesto = idRespuesto;
	}

	
	
}
