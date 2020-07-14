package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the materia database table.
 * 
 */
@Entity
@Table(name="materia")
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	private int clave_Materia;

	@Column(nullable=false)
	private int creditos;

	@Column(nullable=false)
	private int hrs_Practica;

	@Column(nullable=false)
	private int hrs_Teoria;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(nullable=false, length=17)
	private String literal;

	@Column(nullable=false, length=50)
	private String nombre;

	@Column(length=550)
	private String observaciones;

	public Materia() {
	}

	public int getClave_Materia() {
		return this.clave_Materia;
	}

	public void setClave_Materia(int clave_Materia) {
		this.clave_Materia = clave_Materia;
	}

	public int getCreditos() {
		return this.creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getHrs_Practica() {
		return this.hrs_Practica;
	}

	public void setHrs_Practica(int hrs_Practica) {
		this.hrs_Practica = hrs_Practica;
	}

	public int getHrs_Teoria() {
		return this.hrs_Teoria;
	}

	public void setHrs_Teoria(int hrs_Teoria) {
		this.hrs_Teoria = hrs_Teoria;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}