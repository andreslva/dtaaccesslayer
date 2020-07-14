package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_reporte database table.
 * 
 */
@Entity
@Table(name="tipo_reporte")
@NamedQuery(name="TipoReporte.findAll", query="SELECT t FROM TipoReporte t")
public class TipoReporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(length=15)
	private String literal;

	@Column(length=250)
	private String observaciones;

	@Column(length=50)
	private String tipo;

	public TipoReporte() {
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

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}