package itr.model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_periodo_dgeti_foraneo database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_periodo_dgeti_foraneo")
@NamedQueries({
@NamedQuery(name="ViewPeriodoDgetiForaneo.findAll", query="SELECT v FROM ViewPeriodoDgetiForaneo v"),
@NamedQuery(name="ViewPeriodoDgetiForaneo.findByAlumnoID", query="SELECT v FROM ViewPeriodoDgetiForaneo v where v.alumnoId = :alumnoId")
})
public class ViewPeriodoDgetiForaneo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="alumno_id")
	private int alumnoId;

	private String literal;

	@Column(name="literal_ext")
	private String literalExt;

	private String nombre;

	@Column(name="p_dgeti_id")
	private int pDgetiId;

	@Column(name="p_sem_anual_id")
	private int pSemAnualId;

	@Column(name="year_id")
	private int yearId;

	@Column(name="year_lit")
	private int yearLit;

	@Column(name="year_nombre")
	private int yearNombre;

	public ViewPeriodoDgetiForaneo() {
	}

	public int getAlumnoId() {
		return this.alumnoId;
	}

	public void setAlumnoId(int alumnoId) {
		this.alumnoId = alumnoId;
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

	public int getPSemAnualId() {
		return this.pSemAnualId;
	}

	public void setPSemAnualId(int pSemAnualId) {
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

}