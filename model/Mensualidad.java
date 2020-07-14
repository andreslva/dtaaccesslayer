package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the mensualidad database table.
 * 
 */
@Entity
@Table(name="mensualidad")
@NamedQuery(name="Mensualidad.findAll", query="SELECT m FROM Mensualidad m")
public class Mensualidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(nullable=false)
	private float monto_Mensual;

	private int observaciones;

	@Column(nullable=false, length=30)
	private String porcentaje_Beca;

	@Column(nullable=false)
	private float porcentaje_Numerico;

	public Mensualidad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMonto_Mensual() {
		return this.monto_Mensual;
	}

	public void setMonto_Mensual(float monto_Mensual) {
		this.monto_Mensual = monto_Mensual;
	}

	public int getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(int observaciones) {
		this.observaciones = observaciones;
	}

	public String getPorcentaje_Beca() {
		return this.porcentaje_Beca;
	}

	public void setPorcentaje_Beca(String porcentaje_Beca) {
		this.porcentaje_Beca = porcentaje_Beca;
	}

	public float getPorcentaje_Numerico() {
		return this.porcentaje_Numerico;
	}

	public void setPorcentaje_Numerico(float porcentaje_Numerico) {
		this.porcentaje_Numerico = porcentaje_Numerico;
	}

}