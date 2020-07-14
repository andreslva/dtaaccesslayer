package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_folio_grupo_info database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_folio_grupo_info")
@NamedQueries({
@NamedQuery(name="ViewFolioGrupoInfo.findAll", query="SELECT v FROM ViewFolioGrupoInfo v"),
@NamedQuery(name="ViewFolioGrupoInfo.findByFolioNo", query="SELECT v FROM ViewFolioGrupoInfo v where v.folio =:nofolio"),
@NamedQuery(name="ViewFolioGrupoInfo.findByGrupoID", query="SELECT v FROM ViewFolioGrupoInfo v where v.grupo_ID =:grupoID"),
@NamedQuery(name="ViewFolioGrupoInfo.findByNoSemester", query="SELECT v FROM ViewFolioGrupoInfo v where v.numSemActual =:noSem"),
@NamedQuery(name="ViewFolioGrupoInfo.findByFolioNoAndGrupoID", query="SELECT v FROM ViewFolioGrupoInfo v where v.folio =:noFolio and v.grupo_ID =:gpoID"),
@NamedQuery(name="ViewFolioGrupoInfo.findByGenID", query="SELECT v FROM ViewFolioGrupoInfo v where v.genId =:genID"),
})
public class ViewFolioGrupoInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="folio")
	private Integer folio;

	@Id
	@Column(name="folio_gpo_dgeti_id")
	private int folioGpoDgetiId;

	@Column(name="grupo_id")
	private int grupo_ID;

	@Column(name="literal_id")
	private String literal_ID;

	@Column(name="nom_semestre")
	private String nomSemestre;

	@Column(name="num_sem_actual")
	private int numSemActual;

	@Column(name="numero_grupo")
	private String numero_Grupo;

	@Column(name="per_ext_dgeti_lit")
	private String per_ext_dgeti_lit;

	@Column(name="per_dgeti_lit")
	private String perDgetiLit;
	
	@Column(name="periodo_dgeti_id")
	private int periodoDgetiId;

	@Column(name="year_num")
	private int yearNum;

	@Column(name="especialidad_id")
	private int especialidadID;

	@Column(name="sem_id")
	private int semestreID;

	@Column(name="gen_id")
	private Integer genId;

	public Integer getGenId() {
		return genId;
	}

	public void setGenId(Integer genId) {
		this.genId = genId;
	}

	public int getEspecialidadID() {
		return especialidadID;
	}

	public void setEspecialidadID(int especialidadID) {
		this.especialidadID = especialidadID;
	}

	public int getSemestreID() {
		return semestreID;
	}

	public void setSemestreID(int semestreID) {
		this.semestreID = semestreID;
	}

	public ViewFolioGrupoInfo() {
	}

	public Integer getFolio() {
		return this.folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	public int getFolioGpoDgetiId() {
		return this.folioGpoDgetiId;
	}

	public void setFolioGpoDgetiId(int folioGpoDgetiId) {
		this.folioGpoDgetiId = folioGpoDgetiId;
	}

	public int getGrupo_ID() {
		return this.grupo_ID;
	}

	public void setGrupo_ID(int grupo_ID) {
		this.grupo_ID = grupo_ID;
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

	public int getPeriodoDgetiId() {
		return this.periodoDgetiId;
	}

	public void setPeriodoDgetiId(int periodoDgetiId) {
		this.periodoDgetiId = periodoDgetiId;
	}

	public int getYearNum() {
		return this.yearNum;
	}

	public void setYearNum(int yearNum) {
		this.yearNum = yearNum;
	}

	public String getPer_ext_dgeti_lit() {
		return per_ext_dgeti_lit;
	}

	public void setPer_ext_dgeti_lit(String per_ext_dgeti_lit) {
		this.per_ext_dgeti_lit = per_ext_dgeti_lit;
	}
}