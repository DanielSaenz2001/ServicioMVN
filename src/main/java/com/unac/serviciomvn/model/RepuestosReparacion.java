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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "repuestos_reparacion")
public class RepuestosReparacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_respuesto")
    private int idRespuesto;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "nombre")    
    private String nombre;

	@Basic(optional = false)
    @NotNull
    @Column(name = "precio")       
    private double precio;
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRespuesto")
	 @JsonIgnore
	 private Collection<ServicioRepuestos> costoCollection;

	
	public RepuestosReparacion(@NotNull String nombre,  @NotNull double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdRespuesto() {
		return idRespuesto;
	}

	public void setIdRespuesto(int idRespuesto) {
		this.idRespuesto = idRespuesto;
	}
}
