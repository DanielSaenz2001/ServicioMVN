package com.unac.serviciomvn.model;

import java.sql.Date;
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
@Table(name = "Vehiculo")
public class Vehiculo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private int idVehiculo;
 
    @Basic(optional = false)
    @NotNull
    @Column(name = "marca")    
    private String marca;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "modelo")       
    private String modelo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "color")       
    private String color;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "placa")       
    private String placa;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")       
    private String tipo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "imagen_vehiculo")       
    private String imagenVehiculo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")       
    private Date fechaCreacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion")       
    private Date fechaActualizacion;
    
    @JoinColumn(name = "usuario_creacion", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)     
    private Empleado usuarioCreacion;
    
    @JoinColumn(name = "usuario_actualizacion", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)    
    private Empleado usuarioActualizacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculo")
    @JsonIgnore
    private Collection<PropietarioVehiculo> propietarioVehiculoCollection;
    
	public Vehiculo(@NotNull String marca, @NotNull String modelo, @NotNull String color, @NotNull String placa,
			@NotNull String imagenVehiculo,@NotNull String tipo, @NotNull Date fechaCreacion, 
			@NotNull Date fechaActualizacion,Empleado usuarioCreacion, Empleado usuarioActualizacion) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.placa = placa;
		this.imagenVehiculo = imagenVehiculo;
		this.tipo = tipo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioActualizacion = usuarioActualizacion;
	}
	public Vehiculo() {
	}
	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getImagenVehiculo() {
		return imagenVehiculo;
	}
	public void setImagenVehiculo(String imagenVehiculo) {
		this.imagenVehiculo = imagenVehiculo;
	}
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Empleado getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(Empleado usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Empleado getUsuarioActualizacion() {
		return usuarioActualizacion;
	}

	public void setUsuarioActualizacion(Empleado usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}
    
    
}
