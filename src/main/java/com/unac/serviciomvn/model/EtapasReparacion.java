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
@Table(name = "etapas_reparacion")
public class EtapasReparacion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_etapas")
    private int idEtapas;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "nombre")    
    private String nombre;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtapaReparacion")
	@JsonIgnore
	private Collection<DetallesReparacion> DetallesReparacionCollection;
	public EtapasReparacion() {
	}

	public int getIdEtapas() {
		return idEtapas;
	}

	public void setIdEtapas(int idEtapas) {
		this.idEtapas = idEtapas;
	}

	public EtapasReparacion(@NotNull String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
