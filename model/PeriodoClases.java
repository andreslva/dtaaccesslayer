package itr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the periodo_clases database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="periodo_clases")
@NamedQuery(name="PeriodoClases.findAll", query="SELECT p FROM PeriodoClases p")
public class PeriodoClases implements Serializable, Comparable<PeriodoClases> {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date fin;

	@Id
	@Column(nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date inicio;

	@Lob
	private String literal;

	private byte no_dias_habiles;

	@Lob
	private String nombre;

	private int numero;

	@Lob
	private String observaciones;

	public PeriodoClases() {
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public String getLiteral() {
		return this.literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public byte getNo_dias_habiles() {
		return this.no_dias_habiles;
	}

	public void setNo_dias_habiles(byte no_dias_habiles) {
		this.no_dias_habiles = no_dias_habiles;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int compareTo(PeriodoClases o) {
		int retval = this.getNumero() - o.getNumero();
		return retval;
	}

}