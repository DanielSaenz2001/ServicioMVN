package com.unac.serviciomvn.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.unac.serviciomvn.security.model.Rol;
import com.unac.serviciomvn.security.model.Usuario;

import lombok.Data;

@Entity
@Data
@Table(name = "Propietario")
public class Propietario {
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
	    @NotNull
	    @Column(name = "fecha_creacion")       
	    private Date fechaCreacion;
	    
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "fecha_actualizacion")       
	    private Date fechaActualizacion;
	    
	    @JoinColumn(name = "usuario_creacion", referencedColumnName = "id_usuario")
	    @ManyToOne(optional = false)
	    private Usuario usuarioCreacion;
	    
	    @JoinColumn(name = "usuario_actualizacion", referencedColumnName = "id_usuario")
	    @ManyToOne(optional = false)
	    private Usuario usuarioActualizacion;

	    
	    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	    @ManyToOne(optional = false)
	    private Usuario idUsuario;
	    
	    @NotNull
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "propietarios_vehiculos", joinColumns = @JoinColumn(name = "id_propietario"),
	    inverseJoinColumns = @JoinColumn(name = "id_vehiculo"))
	    private Set<Vehiculo> vehiculos = new HashSet<>();
	    
	    public Propietario(@NotNull String nombre, @NotNull String apellidos, @NotNull String cedula,
				@NotNull String telefono, @NotNull String email, @NotNull Date fechaCreacion,
				@NotNull Date fechaActualizacion, Usuario usuarioCreacion,
				Usuario usuarioActualizacion, Usuario idUsuario) {
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

		public Usuario getUsuarioCreacion() {
			return usuarioCreacion;
		}

		public void setUsuarioCreacion(Usuario usuarioCreacion) {
			this.usuarioCreacion = usuarioCreacion;
		}

		public Usuario getUsuarioActualizacion() {
			return usuarioActualizacion;
		}

		public void setUsuarioActualizacion(Usuario usuarioActualizacion) {
			this.usuarioActualizacion = usuarioActualizacion;
		}
}
