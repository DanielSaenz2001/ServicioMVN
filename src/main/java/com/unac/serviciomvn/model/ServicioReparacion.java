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
	@Column(name = "precio_servicio")       
    private double precioServicio;
	
	@Basic(optional = false)
    @NotNull
	@Column(name = "descuento_servicio")       
    private int descuentoServicio;
	
	@JoinColumn(name = "id_detalles", referencedColumnName = "id_detalles")
	@ManyToOne(optional = false)
    private DetallesReparacion idDetalles;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
	 @JsonIgnore
	 private Collection<ServicioRepuestos> costoCollection;
}
