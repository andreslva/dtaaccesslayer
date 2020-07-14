package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the periodo_dgeti database table.
 * 
 */
@Entity
@Table(name="periodo_dgeti")
@NamedQuery(name="PeriodoDgeti.findAll", query="SELECT p FROM PeriodoDgeti p")
public class PeriodoDgeti implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descripcion;

	@Id
	private int id;

	private String literal;

	@Column(name="literal_ext")
	private String literalExt;

	private String nombre;

	@Column(name="periodo_sem_anual_id")
	private int periodoSemAnualId;

	@Column(name="year_id")
	private int yearId;

	@Column(name="dgeti_sep_nom_id")
	private int dgtiSepNomID;

	@Column(name="coord_dgt_id")
	private int coordDgtID;

	@Column(name="respCtlEsc_id")
	private int respCtlEscID;
	
	public PeriodoDgeti() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLiteral() {
		return this.literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public String getLiteralExt() {
		return this.literalExt;
	}

	public void setLiteralExt(String literalExt) {
		this.literalExt = literalExt;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeriodoSemAnualId() {
		return this.periodoSemAnualId;
	}

	public void setPeriodoSemAnualId(int periodoSemAnualId) {
		this.periodoSemAnualId = periodoSemAnualId;
	}

	public int getYearId() {
		return this.yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public int getDgtiSepNomID() {
		return dgtiSepNomID;
	}

	public void setDgtiSepNomID(int dgtiSepNomID) {
		this.dgtiSepNomID = dgtiSepNomID;
	}

	public int getCoordDgtID() {
		return coordDgtID;
	}

	public void setCoordDgtID(int coordDgtID) {
		this.coordDgtID = coordDgtID;
	}

	public int getRespCtlEscID() {
		return respCtlEscID;
	}

	public void setRespCtlEscID(int respCtlEscID) {
		this.respCtlEscID = respCtlEscID;
	}
}