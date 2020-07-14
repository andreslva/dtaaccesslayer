package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;

import java.math.BigInteger;


/**
 * The persistent class for the view_extraordinario_solicitado_last database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_extraordinario_solicitado_last")
@NamedQueries({
@NamedQuery(name="ViewExtraordinarioSolicitadoLast.findAll", query="SELECT v FROM ViewExtraordinarioSolicitadoLast v"),
@NamedQuery(name="ViewExtraordinarioSolicitadoLast.findByClsAlmnIds", query="SELECT v FROM ViewExtraordinarioSolicitadoLast v where v.claseId =:claseid and v.alumnoId =:alumnoid")
})
public class ViewExtraordinarioSolicitadoLast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="alumno_id")
	private int alumnoId;

	@Column(name="clase_id")
	private int claseId;

	@Id
	@Column(name="max_extra_id")
	private int maxExtraId;

	/* orig
	@Column(name="max_oportunidad_extra_id")
	private int maxOportunidadExtraId;
	*/
	@OneToOne
	@JoinColumn(name="max_oportunidad_extra_id", referencedColumnName="ID")
	private OportunidadExtra oportunidadExtra;

	@Column(name="max_periodo_dgeti_extra_id")
	private int maxPeriodoDgetiExtraId;

	@Column(name="oport_no")
	private BigInteger oportNo;

	@Column(name="clave")
	private String clave;
	
	//bi-directional one-to-one association to ViewCalifSimple1_4p
	//@OneToOne(mappedBy="viewExtraordinarioSolicitadoLast")
	//private ViewCalifSimple1_4p viewCalifSimple1_4p;

	public ViewExtraordinarioSolicitadoLast() {
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

	public int getMaxExtraId() {
		return this.maxExtraId;
	}

	public void setMaxExtraId(int maxExtraId) {
		this.maxExtraId = maxExtraId;
	}

	/* orig
	public int getMaxOportunidadExtraId() {
		return this.maxOportunidadExtraId;
	}

	public void setMaxOportunidadExtraId(int maxOportunidadExtraId) {
		this.maxOportunidadExtraId = maxOportunidadExtraId;
	}*/
	public OportunidadExtra getOportunidadExtra() {
		return oportunidadExtra;
	}

	public void setOportunidadExtra(OportunidadExtra oportunidadExtra) {
		this.oportunidadExtra = oportunidadExtra;
	}
	
	public int getMaxPeriodoDgetiExtraId() {
		return this.maxPeriodoDgetiExtraId;
	}

	public void setMaxPeriodoDgetiExtraId(int maxPeriodoDgetiExtraId) {
		this.maxPeriodoDgetiExtraId = maxPeriodoDgetiExtraId;
	}

	public BigInteger getOportNo() {
		return this.oportNo;
	}

	public void setOportNo(BigInteger oportNo) {
		this.oportNo = oportNo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	/*public ViewCalifSimple1_4p getViewCalifSimple1_4p() {
		return this.viewCalifSimple1_4p;
	}

	public void setViewCalifSimple1_4p(ViewCalifSimple1_4p viewCalifSimple1_4p) {
		this.viewCalifSimple1_4p = viewCalifSimple1_4p;
	}*/

}