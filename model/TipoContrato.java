package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_contrato database table.
 * 
 */
@Entity
@Table(name="tipo_contrato")
@NamedQuery(name="TipoContrato.findAll", query="SELECT t FROM TipoContrato t")
public class TipoContrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=250)
	private String descripcion;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(nullable=false, length=30)
	private String literal;

	@Column(length=250)
	private String notas;

	@Column(nullable=false, length=125)
	private String tipo;

	public TipoContrato() {
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

	public String getNotas() {
		return this.notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}