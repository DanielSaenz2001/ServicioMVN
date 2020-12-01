package com.unac.serviciomvn.model;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unac.serviciomvn.security.model.Usuario;

import lombok.Data;

@Entity
@Data
@Table(name = "Propietario")
public class Propietario implements Serializable {
	
		private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id_propietario")
	    private int idPropietario;
	 
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "nombre")    
	    private String nombre;
	    
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "apellidos")       
	    private String apellidos;
	    
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "cedula")       
	    private String cedula;
	    
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "telefono")       
	    private String telefono;
	    
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "email")       
	    private String email;
	    
	    @Basic(optional = false)
	    @Null
	    @Column(name = "password")       
	    private String password;

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

	    
	    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	    @OneToOne(optional = false)
	    private Usuario idUsuario;


	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropietario")
	    @JsonIgnore
	    private Collection<PropietarioVehiculo> propietarioVehiculoCollection;
	    
	    
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropietarioFactura")
	    @JsonIgnore
	    private Collection<VehiculoReparacion> PropietarioReparacionCollection;
	    
	    
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropietarioDetalle")
	    @JsonIgnore
	    private Collection<DetallesReparacion> PropietarioDetallesReparacionCollection;
	    
		public Propietario(@NotNull String nombre, @NotNull String apellidos, @NotNull String cedula,
				@NotNull String telefono, @NotNull String email, @NotNull Date fechaCreacion,
				@NotNull Date fechaActualizacion, Empleado usuarioCreacion,
				Empleado usuarioActualizacion, Usuario idUsuario, @Null String password) {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.cedula = cedula;
			this.telefono = telefono;
			this.email = email;
			this.fechaCreacion = fechaCreacion;
			this.fechaActualizacion = fechaActualizacion;
			this.usuarioCreacion = usuarioCreacion;
			this.usuarioActualizacion = usuarioActualizacion;
			this.idUsuario = idUsuario;
			this.password = password;
		}

		public int getIdPropietario() {
			return idPropietario;
		}



		public void setIdPropietario(int idPropietario) {
			this.idPropietario = idPropietario;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getTelefono() {
			return telefono;
		}
	    
	    
	    public Propietario() {
	    }
	    
		

		public Usuario getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Usuario idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getCedula() {
			return cedula;
		}

		public void setCedula(String cedula) {
			this.cedula = cedula;
		}

		public String Telefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
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
