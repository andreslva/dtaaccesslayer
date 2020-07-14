package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alumno_foraneo database table.
 * 
 */
@Entity
@Cacheable
@Table(name="alumno_foraneo")
@NamedQuery(name="AlumnoForaneo.findAll", query="SELECT a FROM AlumnoForaneo a")
public class AlumnoForaneo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String observaciones;

	private int per_dgeti_Id;

	public AlumnoForaneo() {
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

	public int getPer_dgeti_Id() {
		return this.per_dgeti_Id;
	}

	public void setPer_dgeti_Id(int per_dgeti_Id) {
		this.per_dgeti_Id = per_dgeti_Id;
	}

}