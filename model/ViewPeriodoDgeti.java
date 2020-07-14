package itr.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_periodo_dgeti database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_periodo_dgeti")
@NamedQuery(name="ViewPeriodoDgeti.findAll", query="SELECT v FROM ViewPeriodoDgeti v")
public class ViewPeriodoDgeti implements Serializable {
	private static final long serialVersionUID = 1L;

	private String literal;

	@Column(name="literal_ext")
	private String literalExt;

	private String nombre;

	@Id
	@Column(name="p_dgeti_id")
	private int pDgetiId;

	@OneToOne
	@JoinColumn(name="dgeti_sep_nom_id", referencedColumnName="ID")
	private DgetiSepNombre dgtSepNom;
	
	@Column(name="year_id")
	private int yearId;

	@Column(name="year_lit")
	private int yearLit;

	@Column(name="year_nombre")
	private int yearNombre;

	@Column(name="p_sem_anual_id")
	private int pSemAnualId;

	public ViewPeriodoDgeti() {
	}

	public String getLiteral() {
		return this.literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public String getLiteralExt() {
		return this.literalExt;
	}

	public void setLiteralExt(String literalExt) {
		this.literalExt = literalExt;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPDgetiId() {
		return this.pDgetiId;
	}

	public void setPDgetiId(int pDgetiId) {
		this.pDgetiId = pDgetiId;
	}

	public int getpSemAnualId() {
		return pSemAnualId;
	}

	public void setpSemAnualId(int pSemAnualId) {
		this.pSemAnualId = pSemAnualId;
	}

	public int getYearId() {
		return this.yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public int getYearLit() {
		return this.yearLit;
	}

	public void setYearLit(int yearLit) {
		this.yearLit = yearLit;
	}

	public int getYearNombre() {
		return this.yearNombre;
	}

	public void setYearNombre(int yearNombre) {
		this.yearNombre = yearNombre;
	}

	public DgetiSepNombre getDgtSepNom() {
		return dgtSepNom;
	}

	public void setDgtSepNom(DgetiSepNombre dgtSepNom) {
		this.dgtSepNom = dgtSepNom;
	}
}