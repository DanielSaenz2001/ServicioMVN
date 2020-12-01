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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "vehiculo_reparacion")
public class VehiculoReparacion implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo_reparacion")
    private int idVehiculoReparacion;
	
    @Column(name = "precio_total",nullable = true)       
    private double precioTotal;
	
    @Column(name = "fecha_salida",nullable = true)       
    private Date fechaSalida;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "fase")       
    private String fase;
    
	@JoinColumn(name = "id_propietario", referencedColumnName = "id_propietario",columnDefinition="integer")
    @ManyToOne
    private Propietario idPropietarioFactura;
	
	@NotNull
	@JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false)
    private Vehiculo idVehiculoFactura;
	
	
	@JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado",columnDefinition="integer")
    @ManyToOne
    private Empleado idEmpleadoFactura;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculoReparacion")
	@JsonIgnore
	private Collection<DetallesReparacion> DetallesReparacionCollection;

	public VehiculoReparacion(@Null double precioTotal, @Null Date fechaSalida, @Null Propietario idPropietarioFactura,
			@NotNull Vehiculo idVehiculoFactura, @Null Empleado idEmpleadoFactura) {
		this.precioTotal = precioTotal;
		this.fechaSalida = fechaSalida;
		this.idPropietarioFactura = idPropietarioFactura;
		this.idVehiculoFactura = idVehiculoFactura;
		this.idEmpleadoFactura = idEmpleadoFactura;
	}

	public int getIdVehiculoReparacion() {
		return idVehiculoReparacion;
	}

	public void setIdVehiculoReparacion(int idVehiculoReparacion) {
		this.idVehiculoReparacion = idVehiculoReparacion;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Propietario getIdPropietarioFactura() {
		return idPropietarioFactura;
	}

	public void setIdPropietarioFactura(Propietario idPropietarioFactura) {
		this.idPropietarioFactura = idPropietarioFactura;
	}

	public Vehiculo getIdVehiculoFactura() {
		return idVehiculoFactura;
	}

	public void setIdVehiculoFactura(Vehiculo idVehiculoFactura) {
		this.idVehiculoFactura = idVehiculoFactura;
	}

	public Empleado getIdEmpleadoFactura() {
		return idEmpleadoFactura;
	}

	public void setIdEmpleadoFactura(Empleado idEmpleadoFactura) {
		this.idEmpleadoFactura = idEmpleadoFactura;
	}


}
