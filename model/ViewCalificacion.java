package itr.model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;

import java.sql.Timestamp;


/**
 * The persistent class for the view_calificacion database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_calificacion")
@NamedQueries({
	@NamedQuery(name="ViewCalificacion.findAll", query="SELECT v FROM ViewCalificacion v"),
	@NamedQuery(name="ViewCalificacion.findByAlumnoID", query="SELECT v FROM ViewCalificacion v where v.alumno_ID =:alumnoid"),
	@NamedQuery(name="ViewCalificacion.getByClsAlmPerIds", query="SELECT v FROM ViewCalificacion v where v.clase_ID =:claseid and v.alumno_ID =:alumnoid and v.periodo_ID =:periodoid"),
	@NamedQuery(name="ViewCalificacion.getByClsAlmnIds", query="SELECT v FROM ViewCalificacion v where v.clase_ID =:claseid and v.alumno_ID =:alumnoid")
})
public class ViewCalificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="alumno_id")
	private int alumno_ID;

	private Timestamp calificacion_Update;

	@Column(name="clase_id")
	private int clase_ID;

	@Id
	@Column(name="id")
	private int id;

	private int no_AusAsist;

	private String observaciones;

	@Column(name="periodo_id")
	private int periodo_ID;

	@Column(name="porcentaje_practica")
	private float porcentaje_Practica;

	@Column(name="porcentaje_teoria")
	private float porcentaje_Teoria;

	public ViewCalificacion() {
	}

	public int getAlumno_ID() {
		return this.alumno_ID;
	}

	public void setAlumno_ID(int alumno_ID) {
		this.alumno_ID = alumno_ID;
	}

	public Timestamp getCalificacion_Update() {
		return this.calificacion_Update;
	}

	public void setCalificacion_Update(Timestamp calificacion_Update) {
		this.calificacion_Update = calificacion_Update;
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

	public int getNo_AusAsist() {
		return this.no_AusAsist;
	}

	public void setNo_AusAsist(int no_AusAsist) {
		this.no_AusAsist = no_AusAsist;
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

}