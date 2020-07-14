package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the secundaria database table.
 * 
 */
@Entity
@Table(name="secundaria")
@NamedQuery(name="Secundaria.findAll", query="SELECT s FROM Secundaria s")
public class Secundaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=50)
	private String cct;

	private int clave_ID;

	@Column(nullable=false, length=150)
	private String coordinacion;

	@Column(nullable=false, length=350)
	private String direccion;

	@Column(nullable=false, length=250)
	private String director;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(nullable=false, length=50)
	private String localidad;

	@Column(nullable=false, length=50)
	private String medio;

	@Column(nullable=false, length=50)
	private String modalidad;

	@Column(nullable=false, length=50)
	private String municipio;

	@Column(nullable=false, length=15)
	private String nivel;

	@Column(nullable=false, length=250)
	private String nombre;

	@Column(nullable=false, length=50)
	private String sostenimiento;

	@Column(nullable=false, length=50)
	private String telefono;

	@Column(nullable=false)
	private byte total;

	@Column(nullable=false, length=25)
	private String turno;

	@Column(nullable=false)
	private int ze;

	@Column(nullable=false, length=50)
	private String zeb;

	public Secundaria() {
	}

	public String getCct() {
		return this.cct;
	}

	public void setCct(String cct) {
		this.cct = cct;
	}

	public int getClave_ID() {
		return this.clave_ID;
	}

	public void setClave_ID(int clave_ID) {
		this.clave_ID = clave_ID;
	}

	public String getCoordinacion() {
		return this.coordinacion;
	}

	public void setCoordinacion(String coordinacion) {
		this.coordinacion = coordinacion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMedio() {
		return this.medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public String getModalidad() {
		return this.modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSostenimiento() {
		return this.sostenimiento;
	}

	public void setSostenimiento(String sostenimiento) {
		this.sostenimiento = sostenimiento;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public byte getTotal() {
		return this.total;
	}

	public void setTotal(byte total) {
		this.total = total;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getZe() {
		return this.ze;
	}

	public void setZe(int ze) {
		this.ze = ze;
	}

	public String getZeb() {
		return this.zeb;
	}

	public void setZeb(String zeb) {
		this.zeb = zeb;
	}

}