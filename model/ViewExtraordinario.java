package itr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the view_extraordinario database table.
 * 
 */
@Entity
@Table(name="view_extraordinario")
@NamedQuery(name="ViewExtraordinario.findAll", query="SELECT v FROM ViewExtraordinario v")
public class ViewExtraordinario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="alumno_id")
	private int alumnoId;

	private float calificacion;

	@Column(name="clase_id")
	private int claseId;

	private int especialidad_ID;

	@Id
	@Column(name="extra_id")
	private int extraId;

	private int folio;

	@Column(name="folio_id")
	private int folioId;

	@Column(name="gpo_id")
	private int gpoId;

	private int materia_ID;

	@Column(name="no_sem_mat")
	private int noSemMat;

	@Column(name="no_sem_mat_id")
	private int noSemMatId;

	private int oportunidad;

	private int oportunidad_Extra_ID;

	@Column(name="per_dgeti_extra")
	private String perDgetiExtra;

	@Column(name="per_dgeti_extra_id")
	private int perDgetiExtraId;

	@Column(name="per_dgeti_id")
	private int perDgetiId;

	@Column(name="periodo_extra")
	private String periodoExtra;

	private int programa_ID;

	private int year;

	public ViewExtraordinario() {
	}

	public int getAlumnoId() {
		return this.alumnoId;
	}

	public void setAlumnoId(int alumnoId) {
		this.alumnoId = alumnoId;
	}

	public float getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public int getClaseId() {
		return this.claseId;
	}

	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	public int getEspecialidad_ID() {
		return this.especialidad_ID;
	}

	public void setEspecialidad_ID(int especialidad_ID) {
		this.especialidad_ID = especialidad_ID;
	}

	public int getExtraId() {
		return this.extraId;
	}

	public void setExtraId(int extraId) {
		this.extraId = extraId;
	}

	public int getFolio() {
		return this.folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public int getFolioId() {
		return this.folioId;
	}

	public void setFolioId(int folioId) {
		this.folioId = folioId;
	}

	public int getGpoId() {
		return this.gpoId;
	}

	public void setGpoId(int gpoId) {
		this.gpoId = gpoId;
	}

	public int getMateria_ID() {
		return this.materia_ID;
	}

	public void setMateria_ID(int materia_ID) {
		this.materia_ID = materia_ID;
	}

	public int getNoSemMat() {
		return this.noSemMat;
	}

	public void setNoSemMat(int noSemMat) {
		this.noSemMat = noSemMat;
	}

	public int getNoSemMatId() {
		return this.noSemMatId;
	}

	public void setNoSemMatId(int noSemMatId) {
		this.noSemMatId = noSemMatId;
	}

	public int getOportunidad() {
		return this.oportunidad;
	}

	public void setOportunidad(int oportunidad) {
		this.oportunidad = oportunidad;
	}

	public int getOportunidad_Extra_ID() {
		return this.oportunidad_Extra_ID;
	}

	public void setOportunidad_Extra_ID(int oportunidad_Extra_ID) {
		this.oportunidad_Extra_ID = oportunidad_Extra_ID;
	}

	public String getPerDgetiExtra() {
		return this.perDgetiExtra;
	}

	public void setPerDgetiExtra(String perDgetiExtra) {
		this.perDgetiExtra = perDgetiExtra;
	}

	public int getPerDgetiExtraId() {
		return this.perDgetiExtraId;
	}

	public void setPerDgetiExtraId(int perDgetiExtraId) {
		this.perDgetiExtraId = perDgetiExtraId;
	}

	public int getPerDgetiId() {
		return this.perDgetiId;
	}

	public void setPerDgetiId(int perDgetiId) {
		this.perDgetiId = perDgetiId;
	}

	public String getPeriodoExtra() {
		return this.periodoExtra;
	}

	public void setPeriodoExtra(String periodoExtra) {
		this.periodoExtra = periodoExtra;
	}

	public int getPrograma_ID() {
		return this.programa_ID;
	}

	public void setPrograma_ID(int programa_ID) {
		this.programa_ID = programa_ID;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}