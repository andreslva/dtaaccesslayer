package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;

import java.util.Date;


/**
 * The persistent class for the view_alumno_baja_data database table.
 * 
 */
@ReadOnly
@Entity
@Table(name="view_alumno_baja_data")
@NamedQueries({
@NamedQuery(name="ViewAlumnoBajaData.findAll", query="SELECT v FROM ViewAlumnoBajaData v"),
@NamedQuery(name="ViewAlumnoBajaData.findbyFolio", query="SELECT v FROM ViewAlumnoBajaData v where v.folio =:folio")
})
public class ViewAlumnoBajaData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="alumno_id")
	private int alumnoId;

	@Column(name="baja_id")
	private int bajaId;

	@Column(name="cl_sec_id")
	private byte clSecId;

	@Column(name="curp")
	private String curp;

	@Column(name="deuda")
	private float deuda;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	@Column(name="folio")
	private int folio;

	@Column(name="grupo_dgeti")
	private String grupoDgeti;

	@Column(name="grupo_literal")
	private String grupoLiteral;

	@Column(name="mensualidad_ID")
	private int mensualidad_ID;

	@Column(name="motivo_id")
	private int motivoId;

	@Column(name="NO_Control_DGETI")
	private String NO_Control_DGETI;

	@Column(name="nombre_alumno")
	private String nombreAlumno;

	@Column(name="nota")
	private String nota;

	@Column(name="semestre_ID")
	private int semestre_ID;

	public ViewAlumnoBajaData() {
	}

	public int getAlumnoId() {
		return this.alumnoId;
	}

	public void setAlumnoId(int alumnoId) {
		this.alumnoId = alumnoId;
	}

	public int getBajaId() {
		return this.bajaId;
	}

	public void setBajaId(int bajaId) {
		this.bajaId = bajaId;
	}

	public byte getClSecId() {
		return this.clSecId;
	}

	public void setClSecId(byte clSecId) {
		this.clSecId = clSecId;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public float getDeuda() {
		return this.deuda;
	}

	public void setDeuda(float deuda) {
		this.deuda = deuda;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public int getFolio() {
		return this.folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public String getGrupoDgeti() {
		return this.grupoDgeti;
	}

	public void setGrupoDgeti(String grupoDgeti) {
		this.grupoDgeti = grupoDgeti;
	}

	public String getGrupoLiteral() {
		return this.grupoLiteral;
	}

	public void setGrupoLiteral(String grupoLiteral) {
		this.grupoLiteral = grupoLiteral;
	}

	public int getMensualidad_ID() {
		return this.mensualidad_ID;
	}

	public void setMensualidad_ID(int mensualidad_ID) {
		this.mensualidad_ID = mensualidad_ID;
	}

	public int getMotivoId() {
		return this.motivoId;
	}

	public void setMotivoId(int motivoId) {
		this.motivoId = motivoId;
	}

	public String getNO_Control_DGETI() {
		return this.NO_Control_DGETI;
	}

	public void setNO_Control_DGETI(String NO_Control_DGETI) {
		this.NO_Control_DGETI = NO_Control_DGETI;
	}

	public String getNombreAlumno() {
		return this.nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public int getSemestre_ID() {
		return this.semestre_ID;
	}

	public void setSemestre_ID(int semestre_ID) {
		this.semestre_ID = semestre_ID;
	}

}