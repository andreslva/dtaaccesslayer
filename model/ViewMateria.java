package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_materia database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_materia")
@NamedQuery(name="ViewMateria.findAll", query="SELECT v FROM ViewMateria v")
public class ViewMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	private int clave_Materia;

	private int creditos;

	private int hrs_Practica;

	private int hrs_Teoria;

	@Id
	@Column(name="ID")
	private int id;

	private String literal;

	private String nombre;

	private String observaciones;

	public ViewMateria() {
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