package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@Table(name="grupo")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private int especialidad_ID;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(nullable=false, length=15)
	private String literal_ID;

	private int numero_Alumnos;

	@Column(nullable=false, length=10)
	private String numero_Grupo;

	@Column(length=250)
	private String observaciones;

	private int plan_Estudio_ID;

	@Column(nullable=false)
	private int semestre_ID;

	private int tutor_ID;

	public Grupo() {
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

	public String getLiteral_ID() {
		return this.literal_ID;
	}

	public void setLiteral_ID(String literal_ID) {
		this.literal_ID = literal_ID;
	}

	public int getNumero_Alumnos() {
		return this.numero_Alumnos;
	}

	public void setNumero_Alumnos(int numero_Alumnos) {
		this.numero_Alumnos = numero_Alumnos;
	}

	public String getNumero_Grupo() {
		return this.numero_Grupo;
	}

	public void setNumero_Grupo(String numero_Grupo) {
		this.numero_Grupo = numero_Grupo;
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

	public int getSemestre_ID() {
		return this.semestre_ID;
	}

	public void setSemestre_ID(int semestre_ID) {
		this.semestre_ID = semestre_ID;
	}

	public int getTutor_ID() {
		return this.tutor_ID;
	}

	public void setTutor_ID(int tutor_ID) {
		this.tutor_ID = tutor_ID;
	}

}