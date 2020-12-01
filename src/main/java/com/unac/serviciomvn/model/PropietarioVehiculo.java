package com.unac.serviciomvn.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="propietario_vehiculo")
//,uniqueConstraints=@UniqueConstraint(columnNames = {"id_propietario", "id_vehiculo"})
public class PropietarioVehiculo {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_propietario_vehiculo")
    private int idPropietarioVehiculo;
	
	@JoinColumn(name = "id_propietario", referencedColumnName = "id_propietario")
    @ManyToOne(optional = false)
    private Propietario idPropietario;
    
	@JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false)
    private Vehiculo idVehiculo;
	public PropietarioVehiculo(){
		
	}
	public PropietarioVehiculo(Propietario idPropietario, Vehiculo idVehiculo, int idPropietarioVehiculo) {
		this.idPropietarioVehiculo = idPropietarioVehiculo;
		this.idPropietario = idPropietario;
		this.idVehiculo = idVehiculo;
	}

	public int getIdPropietarioVehiculo() {
		return idPropietarioVehiculo;
	}

	public void setIdPropietarioVehiculo(int idPropietarioVehiculo) {
		this.idPropietarioVehiculo = idPropietarioVehiculo;
	}

	public Propietario getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(Propietario idPropietario) {
		this.idPropietario = idPropietario;
	}

	public Vehiculo getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Vehiculo idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

}
