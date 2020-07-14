package itr.model;

import java.io.Serializable;
import java.text.Collator;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the clave_secundaria database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="clave_secundaria")
@NamedQuery(name="ClaveSecundaria.findAll", query="SELECT c FROM ClaveSecundaria c")
public class ClaveSecundaria implements Serializable, Comparable<ClaveSecundaria> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="clave")
	private Integer clave;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="id")
	private int id;

	@Column(name="literal")
	private String literal;

	public ClaveSecundaria() {
	}

	public Integer getClave() {
		return this.clave;
	}

	public void setClave(Integer clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@Override
	public int compareTo(ClaveSecundaria o) {
		return this.getClave() - o.getClave();
	}

	public String getPrintLine()
	{
		String t = " - ";
		StringBuffer s = new StringBuffer();
		s.append(this.getClave());
		s.append(t);
		s.append(this.getLiteral());
		return s.toString();
	}
	
}