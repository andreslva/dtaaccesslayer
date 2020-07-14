package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itr_dgeti_gpo_relation database table.
 * 
 */
@Entity
@Table(name="itr_dgeti_gpo_relation")
@NamedQuery(name="ItrDgetiGpoRelation.findAll", query="SELECT i FROM ItrDgetiGpoRelation i")
public class ItrDgetiGpoRelation implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descripcion;

	@Id
	@Column(name="dgeti_gpo_id")
	private int dgetiGpoId;

	private int id;

	@Column(name="itr_gpo_id")
	private int itrGpoId;

	public ItrDgetiGpoRelation() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDgetiGpoId() {
		return this.dgetiGpoId;
	}

	public void setDgetiGpoId(int dgetiGpoId) {
		this.dgetiGpoId = dgetiGpoId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItrGpoId() {
		return this.itrGpoId;
	}

	public void setItrGpoId(int itrGpoId) {
		this.itrGpoId = itrGpoId;
	}

}