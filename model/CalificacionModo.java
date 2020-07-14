package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calificacion_modo database table.
 * 
 */
@Entity
@Cacheable
@Table(name="calificacion_modo")
@NamedQuery(name="CalificacionModo.findAll", query="SELECT c FROM CalificacionModo c")
public class CalificacionModo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descripcion;

	@Id
	private int id;

	private String literal;

	private String nombre;

	public CalificacionModo() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

}