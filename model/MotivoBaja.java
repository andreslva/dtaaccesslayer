package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the motivo_baja database table.
 * 
 */
@Entity
@Table(name="motivo_baja")
@NamedQuery(name="MotivoBaja.findAll", query="SELECT m FROM MotivoBaja m")
public class MotivoBaja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=50)
	private String desc_corta;

	@Column(nullable=false, length=350)
	private String descripcion;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(length=200)
	private String nota;

	public MotivoBaja() {
	}

	public String getDesc_corta() {
		return this.desc_corta;
	}

	public void setDesc_corta(String desc_corta) {
		this.desc_corta = desc_corta;
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

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

}