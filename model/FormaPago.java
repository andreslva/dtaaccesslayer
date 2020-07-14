package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the forma_pago database table.
 * 
 */
@Entity
@Table(name="forma_pago")
@NamedQuery(name="FormaPago.findAll", query="SELECT f FROM FormaPago f")
public class FormaPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=75)
	private String forma_Pago;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(nullable=false, length=25)
	private String literal;

	@Column(length=250)
	private String observaciones;

	public FormaPago() {
	}

	public String getForma_Pago() {
		return this.forma_Pago;
	}

	public void setForma_Pago(String forma_Pago) {
		this.forma_Pago = forma_Pago;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLiteral() {
		return this.literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}