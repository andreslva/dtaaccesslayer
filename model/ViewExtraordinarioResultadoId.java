package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_extraordinario_resultado_id database table.
 * 
 */
@ReadOnly
@Entity
@Table(name="view_extraordinario_resultado_id")
@NamedQueries({
@NamedQuery(name="ViewExtraordinarioResultadoId.findAll", query="SELECT v FROM ViewExtraordinarioResultadoId v"),
@NamedQuery(name="ViewExtraordinarioResultadoId.findFOLPERDGETIEXTRA", query="SELECT v FROM ViewExtraordinarioResultadoId v WHERE v.folioId = :folioid and v.perDgetiExtraId.pDgetiExtId = :perextraid")
})
public class ViewExtraordinarioResultadoId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="calificacion")
	private float calificacion;

	@Column(name="clase_id")
	private int claseId;

	@Id
	@Column(name="extra_id")
	private int extraId;

	@Column(name="folio")
	private int folio;

	@Column(name="folio_id")
	private int folioId;

	@Column(name="gpo_id")
	private int gpoId;

	@Column(name="materia_id")
	private int materia_ID;

	@Column(name="no_sem_mat")
	private int noSemMat;

	@Column(name="no_sem_mat_id")
	private int noSemMatId;

	@Column(name="oportunidad")
	private int oportunidad;

	@Column(name="oportunidad_extra_id")
	private int oportunidad_Extra_ID;

	@Column(name="per_dgeti_extra")
	private String perDgetiExtra;

	//@Column(name="per_dgeti_extra_id")
	//private int perDgetiExtraId;
	@JoinColumn(name="per_dgeti_extra_id", referencedColumnName="p_dgeti_ext_id")
	private ViewPeriodoExtra perDgetiExtraId;
	
	@Column(name="per_dgeti_id")
	private int perDgetiId;

	@Column(name="periodo_extra")
	private String periodoExtra;

	@Column(name="year")
	private int year;

	//uni-directional one-to-one association to Alumno
	//@OneToOne
	//@JoinColumn(name="alumno_id", referencedColumnName="ID")
	//private Alumno alumno;
	//
	//uni-directional one-to-one association to Alumno
	@OneToOne
	@JoinColumn(name="alumno_id", referencedColumnName="ID")
	private ViewAlumnoAll alumno;
	
	@Column(name="Especialidad_ID")
	private int especialidadId;
	
	//uni-directional one-to-one association to Alumno
	@OneToOne
	@JoinColumn(name="programa_id", referencedColumnName="prog_id")
	private ViewPrograma viePrograma;

	public ViewPrograma getViewPrograma() {
		return viePrograma;
	}

	public void setViewPrograma(ViewPrograma viePrograma) {
		this.viePrograma = viePrograma;
	}

	public int getEspecialidadId() {
		return especialidadId;
	}

	public void setEspecialidadId(int especialidadId) {
		this.especialidadId = especialidadId;
	}

	public ViewExtraordinarioResultadoId() {
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

	public ViewPeriodoExtra getPerDgetiExtraId() {
		return this.perDgetiExtraId;
	}

	public void setPerDgetiExtraId(ViewPeriodoExtra perDgetiExtraId) {
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

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ViewAlumnoAll getAlumno() {
		return this.alumno;
	}

	public void setAlumno(ViewAlumnoAll alumno) {
		this.alumno = alumno;
	}

}