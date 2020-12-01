package com.unac.serviciomvn.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
@Table(name = "mensaje")
public class MensajePrueba implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "mensaje")    
    private String mensaje;
    
    public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_user")       
    private Integer idUser;

    public MensajePrueba() {
    }
    public MensajePrueba(String mensaje, Integer idUser) {
        this.mensaje = mensaje;
        this.idUser = idUser;
    }
}
