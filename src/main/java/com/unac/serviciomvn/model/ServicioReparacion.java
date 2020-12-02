package com.unac.serviciomvn.model;

import java.io.Serializable;
import java.util.Collection;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "servicio_reparacion")
public class ServicioReparacion implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private int idServicio;
	
	@Basic(optional = false)
    @NotNull
	@Column(name = "descripcion")       
    private String descripcion;
	
	@Basic(optional = false)
    @NotNull
	@Column(name = "nombre")       
    private String nombre;
	
	@Basic(optional = false)
    @NotNull
	@Column(name = "precio_servicio")       
    private double precioServicio;
	@Basic(optional = false)
    @NotNull
	@Column(name = "habilitado")       
    private boolean habilitado;
	
	@Basic(optional = false)
    @NotNull
	@Column(name = "descuento_servicio")       
    private int descuentoServicio;
	
	@JoinColumn(name = "id_detalles", referencedColumnName = "id_detalles")
	@ManyToOne(optional = false)
    private DetallesReparacion idDetalles;
	
	@JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
	@ManyToOne(optional = false)
    private Empleado idEmpleadoServicio;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
	 @JsonIgnore
	 private Collection<ServicioRepuestos> costoCollection;
	public ServicioReparacion() {
	}
	public ServicioReparacion(@NotNull double precioServicio, @NotNull int descuentoServicio, @NotNull String descripcion,
			DetallesReparacion idDetalles, @NotNull String nombre, @NotNull boolean habilitado, Empleado idEmpleadoServicio) {
		super();
		this.precioServicio = precioServicio;
		this.descuentoServicio = descuentoServicio;
		this.descripcion = descripcion;
		this.idDetalles = idDetalles;
		this.nombre = nombre;
		this.habilitado = habilitado;
		this.idEmpleadoServicio = idEmpleadoServicio;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public double getPrecioServicio() {
		return precioServicio;
	}

	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public void setPrecioServicio(double precioServicio) {
		this.precioServicio = precioServicio;
	}

	public int getDescuentoServicio() {
		return descuentoServicio;
	}

	public void setDescuentoServicio(int descuentoServicio) {
		this.descuentoServicio = descuentoServicio;
	}

	public DetallesReparacion getIdDetalles() {
		return idDetalles;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setIdDetalles(DetallesReparacion idDetalles) {
		this.idDetalles = idDetalles;
	}
	public Empleado getIdEmpleadoServicio() {
		return idEmpleadoServicio;
	}
	public void setIdEmpleadoServicio(Empleado idEmpleadoServicio) {
		this.idEmpleadoServicio = idEmpleadoServicio;
	}
	
	
}
