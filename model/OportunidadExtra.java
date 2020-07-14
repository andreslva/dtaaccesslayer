package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the oportunidad_extra database table.
 * 
 */
@Entity
@Table(name="oportunidad_extra")
@NamedQuery(name="OportunidadExtra.findAll", query="SELECT o FROM OportunidadExtra o")
public class OportunidadExtra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(length=50)
	private String observacion;

	@Column(nullable=false)
	private int oportunidad;

	public OportunidadExtra() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getOportunidad() {
		return this.oportunidad;
	}

	public void setOportunidad(byte oportunidad) {
		this.oportunidad = oportunidad;
	}

}