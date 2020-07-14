package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the status_ausencia database table.
 * 
 */
@Entity
@Table(name="status_ausencia")
@NamedQuery(name="StatusAusencia.findAll", query="SELECT s FROM StatusAusencia s")
public class StatusAusencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(length=10)
	private String literal;

	@Column(length=250)
	private String observaciones;

	@Column(name="estatus", length=25)
	private String status;

	public StatusAusencia() {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}