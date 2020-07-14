package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the semestre database table.
 * 
 */
@Entity
@Table(name="semestre")
@NamedQuery(name="Semestre.findAll", query="SELECT s FROM Semestre s")
public class Semestre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(nullable=false, length=50)
	private String nombre;

	@Column(nullable=false, length=15)
	private String nombre_Corto;

	@Column(nullable=false)
	private int numero;

	@Column(length=250)
	private String observaciones;

	public Semestre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_Corto() {
		return this.nombre_Corto;
	}

	public void setNombre_Corto(String nombre_Corto) {
		this.nombre_Corto = nombre_Corto;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}