package itr.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the area_estudio database table.
 * 
 */
@Entity
@Table(name="area_estudio")
@NamedQuery(name="AreaEstudio.findAll", query="SELECT a FROM AreaEstudio a")
public class AreaEstudio implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descripcion;

	@Id
	@Column(name="id")
	private Integer id;

	private String literal;

	private String nombre;

	public AreaEstudio() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

}