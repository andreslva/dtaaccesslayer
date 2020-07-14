package itr.model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the folio_sem_per_dgeti database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="folio_sem_per_dgeti")
@NamedQueries({
@NamedQuery(name="FolioSemPerDgeti.findAll", query="SELECT f FROM FolioSemPerDgeti f"),
@NamedQuery(name="FolioSemPerDgeti.findByFolio", query="SELECT f FROM FolioSemPerDgeti f where f.folio =:noFolio"),
})
public class FolioSemPerDgeti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="especialidad_id")
	private int especialidad_ID;

	@Column(name="folio")
	private Integer folio;

	@Id
	@Column(name="folio_gpo_dgeti_id")
	private int folioGpoDgetiId;

	@Column(name="nom_semestre")
	private String nomSemestre;

	@Column(name="num_sem_actual")
	private int numSemActual;

	@Column(name="per_dgeti_lit")
	private String perDgetiLit;

	@Column(name="per_ext_dgeti_lit")
	private String perExtDgetiLit;

	@Column(name="periodo_dgeti_id")
	private int periodoDgetiId;

	@Column(name="sem_id")
	private int semId;

	@Column(name="year_num")
	private int yearNum;

	public FolioSemPerDgeti() {
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

	public int getFolioGpoDgetiId() {
		return this.folioGpoDgetiId;
	}

	public void setFolioGpoDgetiId(int folioGpoDgetiId) {
		this.folioGpoDgetiId = folioGpoDgetiId;
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

}