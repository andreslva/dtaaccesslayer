package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the view_especialidad_actual database table.
 * 
 */
@Entity
@Table(name="view_especialidad_actual")
@NamedQuery(name="ViewEspecialidadActual.findAll", query="SELECT v FROM ViewEspecialidadActual v")
public class ViewEspecialidadActual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="area_estudio_id")
	private int areaEstudioId;

	private String codigo;

	private short creditos;

	@Id
	@Column(name="ID")
	private int id;

	private String literal;

	private String nombre;

	private String nombre_Corto;

	private String observaciones;

	private String rvoe;

	public ViewEspecialidadActual() {
	}

	public int getAreaEstudioId() {
		return this.areaEstudioId;
	}

	public void setAreaEstudioId(int areaEstudioId) {
		this.areaEstudioId = areaEstudioId;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public short getCreditos() {
		return this.creditos;
	}

	public void setCreditos(short creditos) {
		this.creditos = creditos;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_Corto() {
		return this.nombre_Corto;
	}

	public void setNombre_Corto(String nombre_Corto) {
		this.nombre_Corto = nombre_Corto;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRvoe() {
		return this.rvoe;
	}

	public void setRvoe(String rvoe) {
		this.rvoe = rvoe;
	}

}