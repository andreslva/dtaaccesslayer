package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the plan_estudio database table.
 * 
 */
@Entity
@Table(name="plan_estudio")
@NamedQuery(name="PlanEstudio.findAll", query="SELECT p FROM PlanEstudio p")
public class PlanEstudio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private int especialidad_ID;

	@Id
	@Column(nullable=false)
	private int id;

	@Lob
	@Column(nullable=false)
	private String literal;

	@Column(nullable=false, length=50)
	private String nombre_Programa;

	@Lob
	@Column(nullable=false)
	private String observaciones;

	@Column(nullable=false)
	private int semestre_ID;

	public PlanEstudio() {
	}

	public int getEspecialidad_ID() {
		return this.especialidad_ID;
	}

	public void setEspecialidad_ID(int especialidad_ID) {
		this.especialidad_ID = especialidad_ID;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLiteral() {
		return this.literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public String getNombre_Programa() {
		return this.nombre_Programa;
	}

	public void setNombre_Programa(String nombre_Programa) {
		this.nombre_Programa = nombre_Programa;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getSemestre_ID() {
		return this.semestre_ID;
	}

	public void setSemestre_ID(int semestre_ID) {
		this.semestre_ID = semestre_ID;
	}

}