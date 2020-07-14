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

import itr.dev.ViewCalifSimple_Impl;


/**
 * The persistent class for the `view_calif_simple_1-4ps` database table.
 * 
 */
@ReadOnly
@Entity
@Table(name="`view_calif_simple_1_4ps`")
@NamedQueries
({
@NamedQuery(name="ViewCalifSimple1_4p.findAll", query="SELECT v FROM ViewCalifSimple1_4p v"),
@NamedQuery(name="ViewCalifSimple1_4p.findbyAlumnoID", query="SELECT v FROM ViewCalifSimple1_4p v where v.alumnoId = :alumnoid"),
})
public class ViewCalifSimple1_4p extends ViewCalifSimple_Impl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="1p")
	private float p1;

	@Column(name="1t")
	private float t1;

	@Column(name="2p")
	private float p2;

	@Column(name="2t")
	private float t2;

	@Column(name="3p")
	private float p3;

	@Column(name="3t")
	private float t3;

	@Column(name="4p")
	private float p4;

	@Column(name="4t")
	private float t4;

	@Column(name="alumno_id")
	private int alumnoId;

	@Column(name="clase_id")
	private int claseId;

	@Column(name="grupo_id")
	private int grupoId;

	private double prom;

	private double suma;

	//bi-directional one-to-one association to ViewExtraordinarioSolicitadoLast
	@Id
	@OneToOne
	@JoinColumn(name="clave", referencedColumnName="clave")
	private ViewExtraordinarioSolicitadoLast viewExtraordinarioSolicitadoLast;

	public ViewCalifSimple1_4p() {
	}

	public float getP1() {
		return p1;
	}

	public void setP1(float p1) {
		this.p1 = p1;
	}

	public float getT1() {
		return t1;
	}

	public void setT1(float t1) {
		this.t1 = t1;
	}

	public float getP2() {
		return p2;
	}


	public void setP2(float p2) {
		this.p2 = p2;
	}


	public float getT2() {
		return t2;
	}

	public void setT2(float t2) {
		this.t2 = t2;
	}

	public float getP3() {
		return p3;
	}

	public void setP3(float p3) {
		this.p3 = p3;
	}

	public float getT3() {
		return t3;
	}

	public void setT3(float t3) {
		this.t3 = t3;
	}

	public float getP4() {
		return p4;
	}

	public void setP4(float p4) {
		this.p4 = p4;
	}

	public float getT4() {
		return t4;
	}

	public void setT4(float t4) {
		this.t4 = t4;
	}

	public int getAlumnoId() {
		return this.alumnoId;
	}

	public void setAlumnoId(int alumnoId) {
		this.alumnoId = alumnoId;
	}

	public int getClaseId() {
		return this.claseId;
	}

	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	public int getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	public double getProm() {
		return this.prom;
	}

	public void setProm(double prom) {
		this.prom = prom;
	}

	public double getSuma() {
		return this.suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public ViewExtraordinarioSolicitadoLast getViewExtraordinarioSolicitadoLast() {
		return this.viewExtraordinarioSolicitadoLast;
	}

	public void setViewExtraordinarioSolicitadoLast(ViewExtraordinarioSolicitadoLast viewExtraordinarioSolicitadoLast) {
		this.viewExtraordinarioSolicitadoLast = viewExtraordinarioSolicitadoLast;
	}

	public float getLastGrade() {
		return getP4();
	}

	public int getNoPer() {
		return 4;
	}

}