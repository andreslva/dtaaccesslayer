package itr.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the hora_clase database table.
 * 
 */
@Entity
@Table(name="hora_clase")
@NamedQuery(name="HoraClase.findAll", query="SELECT h FROM HoraClase h")
public class HoraClase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=50)
	private String descripcion;

	private Time fin;

	@Id
	@Column(nullable=false)
	private int id;

	private Time inicio;

	@Column(length=25)
	private String literal;

	@Column(length=15)
	private String numeracion;

	@Column(length=150)
	private String observaciones;

	public HoraClase() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Time getFin() {
		return this.fin;
	}

	public void setFin(Time fin) {
		this.fin = fin;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getInicio() {
		return this.inicio;
	}

	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}

	public String getLiteral() {
		return this.literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public String getNumeracion() {
		return this.numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}