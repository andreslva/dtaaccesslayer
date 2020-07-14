package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;

import java.math.BigInteger;


/**
 * The persistent class for the `view_clases-grupo-mto` database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="`view_clases-grupo-mto`")
@NamedQueries({
@NamedQuery(name="ViewClases_grupo_mto.findAll", query="SELECT v FROM ViewClases_grupo_mto v"),
@NamedQuery(name="ViewClases_grupo_mto.findByClaseId", query="SELECT v FROM ViewClases_grupo_mto v where v.claseId = :claseid")
})
public class ViewClases_grupo_mto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="clase_id")
	private int claseId;

	private String codigo;

	private int creditos;

	private int especialidad_ID;

	private String grupo;

	@Column(name="grupo_id")
	private int grupoId;

	private Integer hrs;

	private int hrs_Practica;

	private int hrs_Teoria;

	private String maestro;

	@Column(name="maestro_id")
	private int maestroId;

	private String materia;

	@Column(name="materia_id")
	private int materiaId;

	@Column(name="no_semestre")
	private int noSemestre;

	@Column(name="nom_especialidad")
	private String nomEspecialidad;

	private String observaciones;

	@Lob
	@Column(name="plan_estudio")
	private String planEstudio;

	@Column(name="plan_estudio_id")
	private int planEstudioId;

	@Column(name="programa_id")
	private int programaId;

	@Column(name="periodo_dgeti")
	private String periodoDgeti;

	@Column(name="periodo_dgeti_id")
	private int periodoDgetiId;

	@Column(name="turno_id")
	private int turno_id;

	@Column(name="turno")
	private String turno; 

	@Column(name="position")
	private int position;

	private int sem_id;

	@Column(name="no_cls_prog")
	private int no_cls_prog;

	@OneToOne
	@JoinColumn(name="cls_cmplto_id", referencedColumnName="ID")
	private ClaseComplemento cls_cmplto_id;

	public ClaseComplemento getCls_cmplto_id() {
		return cls_cmplto_id;
	}

	public void setCls_cmplto_id(ClaseComplemento cls_cmplto_id) {
		this.cls_cmplto_id = cls_cmplto_id;
	}

	public int getNo_cls_prog() {
		return no_cls_prog;
	}

	public void setNo_cls_prog(int no_cls_prog) {
		this.no_cls_prog = no_cls_prog;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPeriodoDgetiId() {
		return periodoDgetiId;
	}

	public void setPeriodoDgetiId(int periodoDgetiId) {
		this.periodoDgetiId = periodoDgetiId;
	}

	public int getSem_id() {
		return sem_id;
	}

	public void setSem_id(int sem_id) {
		this.sem_id = sem_id;
	}

	public ViewClases_grupo_mto() {
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

	public Integer getHrs() {
		return this.hrs;
	}

	public void setHrs(Integer hrs) {
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	public String getPeriodoDgeti() {
		return this.periodoDgeti;
	}

	public void setPeriodoDgeti(String periodoDgeti) {
		this.periodoDgeti = periodoDgeti;
	}

	public int getTurno_id() {
		return turno_id;
	}

	public void setTurno_id(int turno_id) {
		this.turno_id = turno_id;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
}