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
 * The persistent class for the ausencia database table.
 * 
 */
@Entity
@Table(name="ausencia")
@NamedQuery(name="Ausencia.findAll", query="SELECT a FROM Ausencia a")
public class Ausencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private int alumno_ID;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	@Id
	@Column(nullable=false)
	private int id;

	private byte justificante;

	@Column(length=50)
	private String motivo;

	@Column(length=150)
	private String observaciones;

	@Column(nullable=false)
	private int status_Ausencia_ID;

	public Ausencia() {
	}

	public int getAlumno_ID() {
		return this.alumno_ID;
	}

	public void setAlumno_ID(int alumno_ID) {
		this.alumno_ID = alumno_ID;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getJustificante() {
		return this.justificante;
	}

	public void setJustificante(byte justificante) {
		this.justificante = justificante;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getStatus_Ausencia_ID() {
		return this.status_Ausencia_ID;
	}

	public void setStatus_Ausencia_ID(int status_Ausencia_ID) {
		this.status_Ausencia_ID = status_Ausencia_ID;
	}

}