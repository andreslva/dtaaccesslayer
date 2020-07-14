package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the view_grupo database table.
 * 
 */
@Entity
@Cacheable
@Table(name="view_grupo")
@NamedQueries({
@NamedQuery(name="ViewGrupo.findAll", query="SELECT v FROM ViewGrupo v"),
@NamedQuery(name="ViewGrupo.findByGpoId", query="SELECT v FROM ViewGrupo v where v.id =:grupoID")
})

public class ViewGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int especialidad_ID;

	@Id
	private int id;

	private String literal_ID;
	
	private String turno;

	@Column(name="nom_semestre")
	private String nomSemestre;

	private String nombre_Programa;

	@Column(name="num_sem_actual")
	private int numSemActual;

	private String numero_Grupo;

	@Column(name="per_dgeti_lit")
	private String perDgetiLit;

	@Column(name="per_ext_dgeti_lit")
	private String perExtDgetiLit;

	@Column(name="periodo_dgeti_id")
	private int periodoDgetiId;

	@Column(name="plan_estudio_id")
	private int planEstudioId;

	@Column(name="turno_id")
	private int turnoId;

	@Column(name="sem_id")
	private int semId;

	@Column(name="year_num")
	private int yearNum;

	public ViewGrupo() {
	}

	public int getEspecialidad_ID() {
		return this.especialidad_ID;
	}

	public void setEspecialidad_ID(int especialidad_ID) {
		this.especialidad_ID = especialidad_ID;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLiteral_ID() {
		return this.literal_ID;
	}

	public void setLiteral_ID(String literal_ID) {
		this.literal_ID = literal_ID;
	}

	public String getNomSemestre() {
		return this.nomSemestre;
	}

	public void setNomSemestre(String nomSemestre) {
		this.nomSemestre = nomSemestre;
	}

	public String getNombre_Programa() {
		return this.nombre_Programa;
	}

	public void setNombre_Programa(String nombre_Programa) {
		this.nombre_Programa = nombre_Programa;
	}

	public int getNumSemActual() {
		return this.numSemActual;
	}

	public void setNumSemActual(int numSemActual) {
		this.numSemActual = numSemActual;
	}

	public String getNumero_Grupo() {
		return this.numero_Grupo;
	}

	public void setNumero_Grupo(String numero_Grupo) {
		this.numero_Grupo = numero_Grupo;
	}

	public String getPerDgetiLit() {
		return this.perDgetiLit;
	}

	public void setPerDgetiLit(String perDgetiLit) {
		this.perDgetiLit = perDgetiLit;
	}

	public String getPerExtDgetiLit() {
		return this.perExtDgetiLit;
	}

	public void setPerExtDgetiLit(String perExtDgetiLit) {
		this.perExtDgetiLit = perExtDgetiLit;
	}

	public int getPeriodoDgetiId() {
		return this.periodoDgetiId;
	}

	public void setPeriodoDgetiId(int periodoDgetiId) {
		this.periodoDgetiId = periodoDgetiId;
	}

	public int getPlanEstudioId() {
		return this.planEstudioId;
	}

	public void setPlanEstudioId(int planEstudioId) {
		this.planEstudioId = planEstudioId;
	}

	public int getSemId() {
		return this.semId;
	}

	public void setSemId(int semId) {
		this.semId = semId;
	}

	public int getYearNum() {
		return this.yearNum;
	}

	public void setYearNum(int yearNum) {
		this.yearNum = yearNum;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getTurnoId() {
		return turnoId;
	}

	public void setTurnoId(int turnoId) {
		this.turnoId = turnoId;
	}
}