package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the programa database table.
 * 
 */
@Entity
@Table(name="programa")
@NamedQuery(name="Programa.findAll", query="SELECT p FROM Programa p")
public class Programa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(nullable=false)
	private int materia_ID;

	@Column(length=500)
	private String observaciones;

	@Column(nullable=false)
	private int plan_Estudio_ID;

	@Column(nullable=false)
	private int position;
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Programa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMateria_ID() {
		return this.materia_ID;
	}

	public void setMateria_ID(int materia_ID) {
		this.materia_ID = materia_ID;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getPlan_Estudio_ID() {
		return this.plan_Estudio_ID;
	}

	public void setPlan_Estudio_ID(int plan_Estudio_ID) {
		this.plan_Estudio_ID = plan_Estudio_ID;
	}

}