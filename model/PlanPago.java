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
 * The persistent class for the plan_pago database table.
 * 
 */
@Entity
@Table(name="plan_pago")
@NamedQuery(name="PlanPago.findAll", query="SELECT p FROM PlanPago p")
public class PlanPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private int alumno_ID;

	@Temporal(TemporalType.DATE)
	private Date fecha_Acuerdo;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha_Tentativa;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(length=250)
	private String observaciones;

	@Column(length=250)
	private String plan_Propuesto;

	private Timestamp ultima_Actualizacion;

	@Column(nullable=false)
	private byte valido;

	public PlanPago() {
	}

	public int getAlumno_ID() {
		return this.alumno_ID;
	}

	public void setAlumno_ID(int alumno_ID) {
		this.alumno_ID = alumno_ID;
	}

	public Date getFecha_Acuerdo() {
		return this.fecha_Acuerdo;
	}

	public void setFecha_Acuerdo(Date fecha_Acuerdo) {
		this.fecha_Acuerdo = fecha_Acuerdo;
	}

	public Date getFecha_Tentativa() {
		return this.fecha_Tentativa;
	}

	public void setFecha_Tentativa(Date fecha_Tentativa) {
		this.fecha_Tentativa = fecha_Tentativa;
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

	public String getPlan_Propuesto() {
		return this.plan_Propuesto;
	}

	public void setPlan_Propuesto(String plan_Propuesto) {
		this.plan_Propuesto = plan_Propuesto;
	}

	public Timestamp getUltima_Actualizacion() {
		return this.ultima_Actualizacion;
	}

	public void setUltima_Actualizacion(Timestamp ultima_Actualizacion) {
		this.ultima_Actualizacion = ultima_Actualizacion;
	}

	public byte getValido() {
		return this.valido;
	}

	public void setValido(byte valido) {
		this.valido = valido;
	}

}