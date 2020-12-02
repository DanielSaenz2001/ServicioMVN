package com.unac.serviciomvn.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Data
@Table(name = "Reportes")
public class Reportes implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reportes")
    private int idReportes;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "descripcion")    
    private String descripcion;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "fecha")    
    private Date fecha;
	

	@JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleadoReporte;

	public Reportes(){
		
	}
	public Reportes(@NotNull String descripcion, @NotNull Date fecha, Empleado idEmpleadoReporte) {
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.idEmpleadoReporte = idEmpleadoReporte;
	}

	public int getIdReportes() {
		return idReportes;
	}

	public void setIdReportes(int idReportes) {
		this.idReportes = idReportes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Empleado getIdEmpleadoReporte() {
		return idEmpleadoReporte;
	}

	public void setIdEmpleadoReporte(Empleado idEmpleadoReporte) {
		this.idEmpleadoReporte = idEmpleadoReporte;
	}

}
