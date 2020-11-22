/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unac.serviciomvn.security.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unac.serviciomvn.model.Empleado;
import com.unac.serviciomvn.model.Propietario;

import lombok.Data;

/**
 *
 * @author davidmp
 */
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
	public Integer idUsuario;
    
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @Column(name = "imagen_user")
    private String imagenUser;
    
    @Basic(optional = false)
    @Column(name = "estado_contrato")
    private Boolean estadoContrato;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    @JsonIgnore
    private Collection<Empleado> empleadoCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    @JsonIgnore
    private Collection<Propietario> propietarioCollection;
    
    
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    
    
    public Usuario(){
    }
    
   
	public Usuario(String nombreUsuario, String password, String imagenUser, Boolean estadoContrato) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.imagenUser = imagenUser;
		this.estadoContrato = estadoContrato;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImagenUser() {
		return imagenUser;
	}
	public void setImagenUser(String imagenUser) {
		this.imagenUser = imagenUser;
	}
	public Boolean getEstadoContrato() {
		return estadoContrato;
	}
	public void setEstadoContrato(Boolean estadoContrato) {
		this.estadoContrato = estadoContrato;
	}
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Optional<Integer> getId() {
        return Optional.ofNullable(idUsuario);
    }
}
