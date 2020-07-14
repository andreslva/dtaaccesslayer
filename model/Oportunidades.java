package itr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the oportunidades database table.
 * 
 */
@Entity
@Table(name="oportunidades")
@NamedQuery(name="Oportunidades.findAll", query="SELECT o FROM Oportunidades o")
public class Oportunidades implements Serializable {
	private static final long serialVersionUID = 1L;

	private int alumno_ID;

	@Temporal(TemporalType.DATE)
	private Date desde;

	@Column(length=20)
	private String folio;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(length=250)
	private String observaciones;

	public Oportunidades() {
	}

	public int getAlumno_ID() {
		return this.alumno_ID;
	}

	public void setAlumno_ID(int alumno_ID) {
		this.alumno_ID = alumno_ID;
	}

	public Date getDesde() {
		return this.desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public String getFolio() {
		return this.folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}