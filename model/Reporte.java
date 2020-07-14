package itr.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the reporte database table.
 * 
 */
@Entity
@Table(name="reporte")
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private int alumno_ID;

	@Column(length=250)
	private String comentario;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	@Column(nullable=false)
	private Timestamp fecha_Modificacion;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(nullable=false)
	private int maestro_ID;

	@Column(length=150)
	private String motivo;

	@Column(nullable=false)
	private int status_Reporte_ID;

	@Column(nullable=false)
	private int tipo_Reporte_ID;

	public Reporte() {
	}

	public int getAlumno_ID() {
		return this.alumno_ID;
	}

	public void setAlumno_ID(int alumno_ID) {
		this.alumno_ID = alumno_ID;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Timestamp getFecha_Modificacion() {
		return this.fecha_Modificacion;
	}

	public void setFecha_Modificacion(Timestamp fecha_Modificacion) {
		this.fecha_Modificacion = fecha_Modificacion;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaestro_ID() {
		return this.maestro_ID;
	}

	public void setMaestro_ID(int maestro_ID) {
		this.maestro_ID = maestro_ID;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public int getStatus_Reporte_ID() {
		return this.status_Reporte_ID;
	}

	public void setStatus_Reporte_ID(int status_Reporte_ID) {
		this.status_Reporte_ID = status_Reporte_ID;
	}

	public int getTipo_Reporte_ID() {
		return this.tipo_Reporte_ID;
	}

	public void setTipo_Reporte_ID(int tipo_Reporte_ID) {
		this.tipo_Reporte_ID = tipo_Reporte_ID;
	}

}