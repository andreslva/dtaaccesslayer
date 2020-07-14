package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import itr.dev.CalificacionFinal;

/**
 * The persistent class for the view_calificacion_final database table.
 * 
 */
@ReadOnly
@Entity
@Table(name="view_calificacion_final")
@NamedQueries
({
 @NamedQuery(
		 name="ViewCalificacionFinal.findAll"
		 , query="SELECT v FROM ViewCalificacionFinal v")
,@NamedQuery(
		name="ViewCalificacionFinal.findByAlumnoID"
		, query="SELECT v FROM ViewCalificacionFinal v where v.alumnoId = :alumnoid"
		, hints=@QueryHint(name=QueryHints.READ_ONLY, value=HintValues.TRUE))
,@NamedQuery(
		name="ViewCalificacionFinal.findByAlumnoIDFolioID"
		, query="SELECT v FROM ViewCalificacionFinal v where v.alumnoId = :alumnoid and v.folioGpoId = :folioid"
		, hints=@QueryHint(name=QueryHints.READ_ONLY, value=HintValues.TRUE))

		
})
public class ViewCalificacionFinal implements Serializable, CalificacionFinal {
	private static final long serialVersionUID = 1L;

	@Column(name="alumno_id")
	private int alumnoId;

	private float calificacion;

	@Column(name="clase_id")
	private int claseId;

	@Id
	@Column(name="clave")
	private String clave;

	private int folio;

	@Column(name="folio_clase_id")
	private String folioClaseId;
	//@OneToOne
	//@JoinColumn(name="folio_clase_id", referencedColumnName="folio_clase_id")
	//private ViewClasesGpoMtoDoc folioClaseId;

	@Column(name="folio_gpo_id")
	private int folioGpoId;

	private String grupo;

	@Column(name="grupo_id")
	private int grupoId;

	private String modo;

	@Column(name="modo_id")
	private int modoId;

	@Column(name="oport_no")
	private int oportNo;

	private float prom;

	private float suma;

	public ViewCalificacionFinal() {
	}

	@Override
	public int getAlumnoId() {
		return this.alumnoId;
	}

	@Override
	public void setAlumnoId(int alumnoId) {
		this.alumnoId = alumnoId;
	}

	@Override
	public float getCalificacion() {
		return this.calificacion;
	}

	@Override
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public int getClaseId() {
		return this.claseId;
	}

	@Override
	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	@Override
	public String getClave() {
		return this.clave;
	}

	@Override
	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public int getFolio() {
		return this.folio;
	}

	@Override
	public void setFolio(int folio) {
		this.folio = folio;
	}

	@Override
	public String getFolioClaseId() {
		return this.folioClaseId;
	}

	@Override
	public void setFolioClaseId(String folioClaseId) {
		this.folioClaseId = folioClaseId;
	}

	@Override
	public int getFolioGpoId() {
		return this.folioGpoId;
	}

	@Override
	public void setFolioGpoId(int folioGpoId) {
		this.folioGpoId = folioGpoId;
	}

	@Override
	public String getGrupo() {
		return this.grupo;
	}

	@Override
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public int getGrupoId() {
		return this.grupoId;
	}

	@Override
	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	@Override
	public String getModo() {
		return this.modo;
	}

	@Override
	public void setModo(String modo) {
		this.modo = modo;
	}

	@Override
	public int getModoId() {
		return this.modoId;
	}

	@Override
	public void setModoId(int modoId) {
		this.modoId = modoId;
	}

	@Override
	public int getOportNo() {
		return this.oportNo;
	}

	@Override
	public void setOportNo(int oportNo) {
		this.oportNo = oportNo;
	}

	@Override
	public float getProm() {
		return this.prom;
	}

	@Override
	public void setProm(float prom) {
		this.prom = prom;
	}

	@Override
	public float getSuma() {
		return this.suma;
	}

	@Override
	public void setSuma(float suma) {
		this.suma = suma;
	}

}