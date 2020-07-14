package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_historial_academico database table.
 * 
 */
@ReadOnly
@Entity
@Table(name="view_historial_academico")
@NamedQuery(name="ViewHistorialAcademico.findAll", query="SELECT v FROM ViewHistorialAcademico v")
public class ViewHistorialAcademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="alumno_id", nullable=false)
	private int alumnoId;

	private double calificacion;

	@Column(name="clase_id", nullable=false)
	private int claseId;

	@Id
	@Column(length=23)
	private String clave;

	@Column(length=20)
	private String codigo;

	@Column(nullable=false)
	private int creditos;

	@Column(length=25)
	private String curp;

	@Column(length=25)
	private String especialidad;

	@Column(nullable=false, length=2)
	private String genero;

	@Column(nullable=false, length=10)
	private String grupo;

	@Column(name="grupo_id", nullable=false)
	private int grupoId;

	@Column(name="grupo_literal", nullable=false, length=15)
	private String grupoLiteral;

	@Column(nullable=false)
	private int id;

	@Column(length=105)
	private String maestro;

	@Column(nullable=false, length=50)
	private String materia;

	@Column(nullable=false, length=1)
	private String modo;

	@Column(length=20)
	private String NO_Control_DGETI;

	@Column(length=333)
	private String nombre;

	@Column(name="`Nombre_Especialidad`", length=125)
	private String nombre_Especialidad;

	private double prom;

	@Column(nullable=false, length=15)
	private String semestre;

	@Column(nullable=false)
	private double suma;

	private short total_Creditos;

	public ViewHistorialAcademico() {
	}

	public int getAlumnoId() {
		return this.alumnoId;
	}

	public void setAlumnoId(int alumnoId) {
		this.alumnoId = alumnoId;
	}

	public double getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public int getClaseId() {
		return this.claseId;
	}

	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCreditos() {
		return this.creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	public String getGrupoLiteral() {
		return this.grupoLiteral;
	}

	public void setGrupoLiteral(String grupoLiteral) {
		this.grupoLiteral = grupoLiteral;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaestro() {
		return this.maestro;
	}

	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getModo() {
		return this.modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public String getNO_Control_DGETI() {
		return this.NO_Control_DGETI;
	}

	public void setNO_Control_DGETI(String NO_Control_DGETI) {
		this.NO_Control_DGETI = NO_Control_DGETI;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_Especialidad() {
		return this.nombre_Especialidad;
	}

	public void setNombre_Especialidad(String nombre_Especialidad) {
		this.nombre_Especialidad = nombre_Especialidad;
	}

	public double getProm() {
		return this.prom;
	}

	public void setProm(double prom) {
		this.prom = prom;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public double getSuma() {
		return this.suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public short getTotal_Creditos() {
		return this.total_Creditos;
	}

	public void setTotal_Creditos(short total_Creditos) {
		this.total_Creditos = total_Creditos;
	}

}