package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the sexo database table.
 * 
 */
@Entity
@Table(name="sexo")
@NamedQuery(name="Sexo.findAll", query="SELECT s FROM Sexo s")
public class Sexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=2)
	private String genero;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(length=15)
	private String literal;

	@Column(length=250)
	private String observaciones;

	@Column(nullable=false, length=2)
	private String sexo;

	public Sexo() {
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}