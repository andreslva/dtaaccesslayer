package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_especialidad_area database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_especialidad_area")
@NamedQuery(name="ViewEspecialidadArea.findAll", query="SELECT v FROM ViewEspecialidadArea v")
public class ViewEspecialidadArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="area_estudio_id")
	private Integer areaEstudioId;

	@Column(name="area_estudio_lit")
	private String areaEstudioLit;

	@Column(name="area_estudio_nom")
	private String areaEstudioNom;

	//@Column(name="creditos")
	private short creditos;

	@Column(name="especialidad_codigo")
	private String especialidadCodigo;

	@Id
	@Column(name="especialidad_id")
	private int especialidadId;

	@Column(name="especialidad_lit")
	private String especialidadLit;

	@Column(name="especialidad_nom")
	private String especialidadNom;

	@Column(name="especialidad_nom_corto")
	private String especialidadNomCorto;

	@Column(name="especialidad_nom_cto")
	private String especialidadNomCto;

	@Column(name="especialidad_rvoe")
	private String especialidadRvoe;

	public ViewEspecialidadArea() {
	}

	public Integer getAreaEstudioId() {
		return this.areaEstudioId;
	}

	public void setAreaEstudioId(Integer areaEstudioId) {
		this.areaEstudioId = areaEstudioId;
	}

	public String getAreaEstudioLit() {
		return this.areaEstudioLit;
	}

	public void setAreaEstudioLit(String areaEstudioLit) {
		this.areaEstudioLit = areaEstudioLit;
	}

	public String getAreaEstudioNom() {
		return this.areaEstudioNom;
	}

	public void setAreaEstudioNom(String areaEstudioNom) {
		this.areaEstudioNom = areaEstudioNom;
	}

	public short getCreditos() {
		return this.creditos;
	}

	public void setCreditos(short creditos) {
		this.creditos = creditos;
	}

	public String getEspecialidadCodigo() {
		return this.especialidadCodigo;
	}

	public void setEspecialidadCodigo(String especialidadCodigo) {
		this.especialidadCodigo = especialidadCodigo;
	}

	public int getEspecialidadId() {
		return this.especialidadId;
	}

	public void setEspecialidadId(int especialidadId) {
		this.especialidadId = especialidadId;
	}

	public String getEspecialidadLit() {
		return this.especialidadLit;
	}

	public void setEspecialidadLit(String especialidadLit) {
		this.especialidadLit = especialidadLit;
	}

	public String getEspecialidadNom() {
		return this.especialidadNom;
	}

	public void setEspecialidadNom(String especialidadNom) {
		this.especialidadNom = especialidadNom;
	}

	public String getEspecialidadNomCorto() {
		return this.especialidadNomCorto;
	}

	public void setEspecialidadNomCorto(String especialidadNomCorto) {
		this.especialidadNomCorto = especialidadNomCorto;
	}

	public String getEspecialidadNomCto() {
		return this.especialidadNomCto;
	}

	public void setEspecialidadNomCto(String especialidadNomCto) {
		this.especialidadNomCto = especialidadNomCto;
	}

	public String getEspecialidadRvoe() {
		return this.especialidadRvoe;
	}

	public void setEspecialidadRvoe(String especialidadRvoe) {
		this.especialidadRvoe = especialidadRvoe;
	}

}