package com.unac.serviciomvn.model;

import java.io.Serializable;


import lombok.Data;
@SuppressWarnings({"serial","unused"})
@Data
public class MensajeUsuario  implements  Serializable{
	private String mensaje;
	private String nombreUsuario;
	
	public MensajeUsuario(String mensaje, String nombreUsuario) {
		this.mensaje = mensaje;
		this.nombreUsuario = nombreUsuario;
	}
	public MensajeUsuario() {
	}
}
