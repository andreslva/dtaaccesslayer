package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;

import java.math.BigInteger;

import jdk.nashorn.internal.ir.annotations.Ignore;


/**
 * The persistent class for the view_extraordinario_resultado database table.
 * 
 */
@ReadOnly
@Entity
@Table(name="view_extraordinario_resultado")
@NamedQueries({
@NamedQuery(name="ViewExtraordinarioResultado.findAll", query="SELECT v FROM ViewExtraordinarioResultado v"),
@NamedQuery(name="ViewExtraordinarioResultado.findFOLPERDGETIEXTRA", query="SELECT v FROM ViewExtraordinarioResultado v WHERE v.folioGpoDgetiId = :folioid and v.periodoDgetiExtraId = :perextraid")
})
public class ViewExtraordinarioResultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="alumno_id")
	private int alumnoId;

	private float calificacion;

	@Column(name="clase_id")
	private int claseId;

	@Column(name="codigo")
	private String codigo;

	@Column(name="creditos")
	private int creditos;

	@Column(name="especialidad_id")
	private int especialidad_ID;

	@Column(name="folio")
	private Integer folio;

	@Column(name="folio_clase_id")
	private String folioClaseId;

	@Column(name="folio_gpo_dgeti_id")
	private int folioGpoDgetiId;

	@Column(name="gen_lit")
	private String genLit;

	@Column(name="gpo_dgeti")
	private String gpoDgeti;

	private String grupo;

	@Column(name="grupo_id")
	private int grupoId;

	@Column(name="hrs")
	private int hrs;

	@Column(name="hrs_practica")
	private int hrs_Practica;

	@Column(name="hrs_teoria")
	private int hrs_Teoria;

	@Id
	private int id;

	@Column(name="literal_ext")
	private String literalExt;

	private String maestro;

	@Column(name="maestro_id")
	private int maestroId;

	private String materia;

	@Column(name="materia_id")
	private int materiaId;

	@Column(name="year")
	private int year;

	private String NO_Control_DGETI;

	@Column(name="no_semestre")
	private int noSemestre;

	@Column(name="nom_especialidad")
	private String nomEspecialidad;

	/*@Column(name="nombre_alumno")
	private String nombreAlumno;*/

	@Column(name="observaciones")
	private String observaciones;

	@Column(name="p_dgeti_id_extra")
	private int pDgetiIdExtra;

	@Column(name="p_dgeti_id_materia")
	private int pDgetiIdMateria;

	@Column(name="periodo_dgeti")
	private String periodoDgeti;

	@Column(name="periodo_dgeti_extra_id")
	private int periodoDgetiExtraId;

	@Column(name="periodo_dgeti_id")
	private int periodoDgetiId;

	@Column(name="periodo_extra")
	private String periodoExtra;

	@Lob
	@Column(name="plan_estudio")
	private String planEstudio;

	@Column(name="plan_estudio_id")
	private int planEstudioId;

	@Column(name="programa_id")
	private int programaId;

	@Column(name="sem_dgeti_fol")
	private BigInteger semDgetiFol;

	@Column(name="sem_fol")
	private BigInteger semFol;

	@Column(name="turno")
	private String turno;

	@Transient
	private int noOpt;
	
	public int getNoOpt() {
		return noOpt;
	}

	public void setNoOpt(int noOpt) {
		this.noOpt = noOpt;
	}

	public ViewExtraordinarioResultado() {
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

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCreditos() {
		return this.creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getEspecialidad_ID() {
		return this.especialidad_ID;
	}

	public void setEspecialidad_ID(int especialidad_ID) {
		this.especialidad_ID = especialidad_ID;
	}

	public Integer getFolio() {
		return this.folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	public String getFolioClaseId() {
		return this.folioClaseId;
	}

	public void setFolioClaseId(String folioClaseId) {
		this.folioClaseId = folioClaseId;
	}

	public int getFolioGpoDgetiId() {
		return this.folioGpoDgetiId;
	}

	public void setFolioGpoDgetiId(int folioGpoDgetiId) {
		this.folioGpoDgetiId = folioGpoDgetiId;
	}

	public String getGenLit() {
		return this.genLit;
	}

	public void setGenLit(String genLit) {
		this.genLit = genLit;
	}

	public String getGpoDgeti() {
		return this.gpoDgeti;
	}

	public void setGpoDgeti(String gpoDgeti) {
		this.gpoDgeti = gpoDgeti;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	public int getHrs() {
		return this.hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
	}

	public int getHrs_Practica() {
		return this.hrs_Practica;
	}

	public void setHrs_Practica(int hrs_Practica) {
		this.hrs_Practica = hrs_Practica;
	}

	public int getHrs_Teoria() {
		return this.hrs_Teoria;
	}

	public void setHrs_Teoria(int hrs_Teoria) {
		this.hrs_Teoria = hrs_Teoria;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLiteralExt() {
		return this.literalExt;
	}

	public void setLiteralExt(String literalExt) {
		this.literalExt = literalExt;
	}

	public String getMaestro() {
		return this.maestro;
	}

	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}

	public int getMaestroId() {
		return this.maestroId;
	}

	public void setMaestroId(int maestroId) {
		this.maestroId = maestroId;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public int getMateriaId() {
		return this.materiaId;
	}

	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getNO_Control_DGETI() {
		return this.NO_Control_DGETI;
	}

	public void setNO_Control_DGETI(String NO_Control_DGETI) {
		this.NO_Control_DGETI = NO_Control_DGETI;
	}

	public int getNoSemestre() {
		return this.noSemestre;
	}

	public void setNoSemestre(int noSemestre) {
		this.noSemestre = noSemestre;
	}

	public String getNomEspecialidad() {
		return this.nomEspecialidad;
	}

	public void setNomEspecialidad(String nomEspecialidad) {
		this.nomEspecialidad = nomEspecialidad;
	}

	/*public String getNombreAlumno() {
		return this.nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}*/

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getPDgetiIdExtra() {
		return this.pDgetiIdExtra;
	}

	public void setPDgetiIdExtra(int pDgetiIdExtra) {
		this.pDgetiIdExtra = pDgetiIdExtra;
	}

	public int getPDgetiIdMateria() {
		return this.pDgetiIdMateria;
	}

	public void setPDgetiIdMateria(int pDgetiIdMateria) {
		this.pDgetiIdMateria = pDgetiIdMateria;
	}

	public String getPeriodoDgeti() {
		return this.periodoDgeti;
	}

	public void setPeriodoDgeti(String periodoDgeti) {
		this.periodoDgeti = periodoDgeti;
	}

	public int getPeriodoDgetiExtraId() {
		return this.periodoDgetiExtraId;
	}

	public void setPeriodoDgetiExtraId(int periodoDgetiExtraId) {
		this.periodoDgetiExtraId = periodoDgetiExtraId;
	}

	public int getPeriodoDgetiId() {
		return this.periodoDgetiId;
	}

	public void setPeriodoDgetiId(int periodoDgetiId) {
		this.periodoDgetiId = periodoDgetiId;
	}

	public String getPeriodoExtra() {
		return this.periodoExtra;
	}

	public void setPeriodoExtra(String periodoExtra) {
		this.periodoExtra = periodoExtra;
	}

	public String getPlanEstudio() {
		return this.planEstudio;
	}

	public void setPlanEstudio(String planEstudio) {
		this.planEstudio = planEstudio;
	}

	public int getPlanEstudioId() {
		return this.planEstudioId;
	}

	public void setPlanEstudioId(int planEstudioId) {
		this.planEstudioId = planEstudioId;
	}

	public int getProgramaId() {
		return this.programaId;
	}

	public void setProgramaId(int programaId) {
		this.programaId = programaId;
	}

	public BigInteger getSemDgetiFol() {
		return this.semDgetiFol;
	}

	public void setSemDgetiFol(BigInteger semDgetiFol) {
		this.semDgetiFol = semDgetiFol;
	}

	public BigInteger getSemFol() {
		return this.semFol;
	}

	public void setSemFol(BigInteger semFol) {
		this.semFol = semFol;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

}