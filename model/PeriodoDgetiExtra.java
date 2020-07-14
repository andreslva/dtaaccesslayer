package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the periodo_dgeti_extra database table.
 * 
 */
@Entity
@Table(name="periodo_dgeti_extra")
@NamedQuery(name="PeriodoDgetiExtra.findAll", query="SELECT p FROM PeriodoDgetiExtra p")
public class PeriodoDgetiExtra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="descripcion")
	private String descripcion;

	@Id
	private int id;

	@Column(name="periodo_dgeti_id")
	private int periodoDgetiId;

	@Column(name="periodo_extra")
	private String periodoExtra;

	@Column(name="linked_pdgt_id")
	private int linkedPDGT_ID;
	
	@Column(name="coord_dgti_id")
	private int coordDGETI_ID;
	
	public PeriodoDgetiExtra() {
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

	public int getPeriodoDgetiId() {
		return this.periodoDgetiId;
	}

	public void setPeriodoDgetiId(int periodoDgetiId) {
		this.periodoDgetiId = periodoDgetiId;
	}

	public String getPeriodoExtra() {
		return this.periodoExtra;
	}

	public void setPeriodoExtra(String periodoExtra) {
		this.periodoExtra = periodoExtra;
	}

	public int getLinkedPDGT_ID() {
		return linkedPDGT_ID;
	}

	public void setLinkedPDGT_ID(int linkedPDGT_ID) {
		this.linkedPDGT_ID = linkedPDGT_ID;
	}

	public int getCoordDGETI_ID() {
		return coordDGETI_ID;
	}

	public void setCoordDGETI_ID(int coordDGETI_ID) {
		this.coordDGETI_ID = coordDGETI_ID;
	}
}