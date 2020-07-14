package itr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
@Table(name="pago")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private int alumno_ID;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	private Date fecha_deposito;

	@Column(name="ultima_mod")
	@Temporal(TemporalType.DATE)
	private Date ultimaMod;

	@Column(name="met_pago_sat_ID", nullable=false)
	private int metPagoSATId;//forma_pago_ID;

	@Id
	@Column(nullable=false)
	private int id;

	@Lob
	private String observaciones;

	private int tipo_Pago_ID;

	public Pago() {
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

	public Date getFecha_deposito() {
		return this.fecha_deposito;
	}

	public void setFecha_deposito(Date fecha_deposito) {
		this.fecha_deposito = fecha_deposito;
	}

	public Date getUltimaMod() {
		return ultimaMod;
	}

	public void setUltimaMod(Date ultimaMod) {
		this.ultimaMod = ultimaMod;
	}

	public int getMetPagoSATId() {
		return this.metPagoSATId;//forma_pago_ID;
	}

	public void setMetPagoSATId(int metPagoSATId) {
		this.metPagoSATId = metPagoSATId;//forma_pago_ID;
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

	public int getTipo_Pago_ID() {
		return this.tipo_Pago_ID;
	}

	public void setTipo_Pago_ID(int tipo_Pago_ID) {
		this.tipo_Pago_ID = tipo_Pago_ID;
	}

}