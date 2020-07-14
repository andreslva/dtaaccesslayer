package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the generacion database table.
 * 
 */
@Entity
@NamedQuery(name="Generacion.findAll", query="SELECT g FROM Generacion g")
public class Generacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String literal;

	private String nombre;

	public Generacion() {
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