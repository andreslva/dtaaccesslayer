package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the clase database table.
 * 
 */
@Entity
@Table(name="clase")
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private int grupo_ID;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(nullable=false)
	private int maestro_ID;

	private String observaciones;

	@Column(nullable=false)
	private int programa_ID;

	public Clase() {
	}

	public int getGrupo_ID() {
		return this.grupo_ID;
	}

	public void setGrupo_ID(int grupo_ID) {
		this.grupo_ID = grupo_ID;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaestro_ID() {
		return this.maestro_ID;
	}

	public void setMaestro_ID(int maestro_ID) {
		this.maestro_ID = maestro_ID;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getPrograma_ID() {
		return this.programa_ID;
	}

	public void setPrograma_ID(int programa_ID) {
		this.programa_ID = programa_ID;
	}

}