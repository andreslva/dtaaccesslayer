package itr.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the extraordinario database table.
 * 
 */
@Entity
@Table(name="extraordinario")
@NamedQuery(name="Extraordinario.findAll", query="SELECT e FROM Extraordinario e")
public class Extraordinario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private int alumno_ID;

	@Column(nullable=false)
	private float calificacion;

	@Column(nullable=false)
	private int clase_ID;

	@Column(nullable=false)
	private Timestamp fecha;

	private Timestamp fecha_Calif_MTO;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(length=150)
	private String nota;

	@Column(nullable=false)
	private int oportunidad_Extra_ID;

	public Extraordinario() {
	}

	public int getAlumno_ID() {
		return this.alumno_ID;
	}

	public void setAlumno_ID(int alumno_ID) {
		this.alumno_ID = alumno_ID;
	}

	public float getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public int getClase_ID() {
		return this.clase_ID;
	}

	public void setClase_ID(int clase_ID) {
		this.clase_ID = clase_ID;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Timestamp getFecha_Calif_MTO() {
		return this.fecha_Calif_MTO;
	}

	public void setFecha_Calif_MTO(Timestamp fecha_Calif_MTO) {
		this.fecha_Calif_MTO = fecha_Calif_MTO;
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

	public int getOportunidad_Extra_ID() {
		return this.oportunidad_Extra_ID;
	}

	public void setOportunidad_Extra_ID(int oportunidad_Extra_ID) {
		this.oportunidad_Extra_ID = oportunidad_Extra_ID;
	}

}