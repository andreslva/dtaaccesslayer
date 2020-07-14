package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the especialidad database table.
 * 
 */
@Entity
@Table(name="especialidad")
@NamedQuery(name="Especialidad.findAll", query="SELECT e FROM Especialidad e")
public class Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=20)
	private String codigo;

	private short creditos;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(length=125)
	private String nombre;

	@Column(length=25)
	private String nombre_Corto;

	@Column(length=250)
	private String observaciones;

	@Column(length=25)
	private String rvoe;

	public Especialidad() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public short getCreditos() {
		return this.creditos;
	}

	public void setCreditos(short creditos) {
		this.creditos = creditos;
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRvoe() {
		return this.rvoe;
	}

	public void setRvoe(String rvoe) {
		this.rvoe = rvoe;
	}

}