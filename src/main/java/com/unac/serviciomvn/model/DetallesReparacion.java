package com.unac.serviciomvn.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "detalles_reparacion")
public class DetallesReparacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalles")
    private int idDetalles;
	
	@Column(name = "fecha_inicio",nullable = true)       
    private Date fechaInicio;
	
	@Column(name = "fecha_fin",nullable = true)       
    private Date fechaFin;
	
	@Column(name = "tiempo_reparacion",nullable = true)       
    private Date tiempoReparacion;
	
	@Column(name = "confirnar_reparacion",nullable = true)       
    private boolean confirmarReparacion;
	
	@JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado",columnDefinition="integer")
    @ManyToOne
    private Empleado idEmpleadoDetalle;
	
	@JoinColumn(name = "id_propietario", referencedColumnName = "id_propietario",columnDefinition="integer")
    @ManyToOne
    private Propietario idPropietarioDetalle;
	
	
	
	@JoinColumn(name = "id_etapas", referencedColumnName = "id_etapas")
	@ManyToOne(optional = false)
    private EtapasReparacion idEtapaReparacion;
	
	@JoinColumn(name = "id_vehiculo_reparacion", referencedColumnName = "id_vehiculo_reparacion")
	@ManyToOne(optional = false)
    private VehiculoReparacion idVehiculoReparacion;

	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idDetalles")
	@JsonIgnore
	private Collection<ServicioReparacion> servicioCollection;



	public DetallesReparacion(Date fechaInicio, Date fechaFin, Date tiempoReparacion, boolean confirmarReparacion,
			Empleado idEmpleadoDetalle, Propietario idPropietarioDetalle, EtapasReparacion idEtapaReparacion,
			VehiculoReparacion idVehiculoReparacion) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tiempoReparacion = tiempoReparacion;
		this.confirmarReparacion = confirmarReparacion;
		this.idEmpleadoDetalle = idEmpleadoDetalle;
		this.idPropietarioDetalle = idPropietarioDetalle;
		this.idEtapaReparacion = idEtapaReparacion;
		this.idVehiculoReparacion = idVehiculoReparacion;
	}



	public int getIdDetalles() {
		return idDetalles;
	}



	public void setIdDetalles(int idDetalles) {
		this.idDetalles = idDetalles;
	}



	public Date getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public Date getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}



	public Date getTiempoReparacion() {
		return tiempoReparacion;
	}



	public void setTiempoReparacion(Date tiempoReparacion) {
		this.tiempoReparacion = tiempoReparacion;
	}



	public boolean isConfirmarReparacion() {
		return confirmarReparacion;
	}



	public void setConfirmarReparacion(boolean confirmarReparacion) {
		this.confirmarReparacion = confirmarReparacion;
	}



	public Empleado getIdEmpleadoDetalle() {
		return idEmpleadoDetalle;
	}



	public void setIdEmpleadoDetalle(Empleado idEmpleadoDetalle) {
		this.idEmpleadoDetalle = idEmpleadoDetalle;
	}



	public Propietario getIdPropietarioDetalle() {
		return idPropietarioDetalle;
	}



	public void setIdPropietarioDetalle(Propietario idPropietarioDetalle) {
		this.idPropietarioDetalle = idPropietarioDetalle;
	}



	public EtapasReparacion getIdEtapaReparacion() {
		return idEtapaReparacion;
	}



	public void setIdEtapaReparacion(EtapasReparacion idEtapaReparacion) {
		this.idEtapaReparacion = idEtapaReparacion;
	}



	public VehiculoReparacion getIdVehiculoReparacion() {
		return idVehiculoReparacion;
	}



	public void setIdVehiculoReparacion(VehiculoReparacion idVehiculoReparacion) {
		this.idVehiculoReparacion = idVehiculoReparacion;
	}
	
	
}
