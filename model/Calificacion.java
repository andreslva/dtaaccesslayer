package itr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calificacion database table.
 * 
 */
@Entity
@Table(name="calificacion")
@NamedQueries({
	@NamedQuery(name="Calificacion.findAll", query="SELECT c FROM Calificacion c"),
	@NamedQuery(name="Calificacion.findCalificacionByClsAlmnPer", 
	query="SELECT c FROM Calificacion c where c.clase_ID =:claseId AND c.alumno_ID =:almnoId AND c.periodo_ID =:perId")
})
public class Calificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="alumno_id", nullable=false)
	private int alumno_ID;

	@Column(name="clase_id", nullable=false)
	private int clase_ID;

	@Id
	@Column(name="id",nullable=false)
	private int id;

	@Column(name="No_AusAsist")
	private byte noAusAsist;

	@Column(nullable=true, length=300)
	private String observaciones;

	@Column(name="periodo_id",nullable=false)
	private int periodo_ID;

	@Column(name="porcentaje_practica",nullable=false)
	private float porcentaje_Practica;

	@Column(name="porcentaje_teoria",nullable=false)
	private float porcentaje_Teoria;

	@Column(name="calificacion_update")
	private Timestamp update;

	public Calificacion() {
	}

	public int getAlumno_ID() {
		return this.alumno_ID;
	}

	public void setAlumno_ID(int alumno_ID) {
		this.alumno_ID = alumno_ID;
	}

	public int getClase_ID() {
		return this.clase_ID;
	}

	public void setClase_ID(int clase_ID) {
		this.clase_ID = clase_ID;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getNoAusAsist() {
		return this.noAusAsist;
	}

	public void setNo_Asistencias(byte no_Asistencias) {
		this.noAusAsist = no_Asistencias;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getPeriodo_ID() {
		return this.periodo_ID;	
	}

	public void setPeriodo_ID(int periodo_ID) {
		this.periodo_ID = periodo_ID;
	}

	public float getPorcentaje_Practica() {
		return this.porcentaje_Practica;
	}

	public void setPorcentaje_Practica(float porcentaje_Practica) {
		this.porcentaje_Practica = porcentaje_Practica;
	}

	public float getPorcentaje_Teoria() {
		return this.porcentaje_Teoria;
	}

	public void setPorcentaje_Teoria(float porcentaje_Teoria) {
		this.porcentaje_Teoria = porcentaje_Teoria;
	}

	public Timestamp getUpdate() {
		return this.update;
	}

	public void setUpdate(Timestamp update) {
		this.update = update;
	}

}