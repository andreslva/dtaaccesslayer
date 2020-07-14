package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;

import java.util.Date;


/**
 * The persistent class for the view_maestro database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_maestro")
@NamedQuery(name="ViewMaestro.findAll", query="SELECT v FROM ViewMaestro v")
public class ViewMaestro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=50)
	private String curp;

	@Column(length=50)
	private String email;

	@Temporal(TemporalType.DATE)
	private Date fecha_Baja;

	@Temporal(TemporalType.DATE)
	private Date fecha_Ingreso;

	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(length=203)
	private String nombre;

	@Column(length=100)
	private String ocupacion;

	@Column(length=50)
	private String rfc;

	@Column(name="tipo_contrato", length=250)
	private String tipoContrato;

	public ViewMaestro() {
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFecha_Baja() {
		return this.fecha_Baja;
	}

	public void setFecha_Baja(Date fecha_Baja) {
		this.fecha_Baja = fecha_Baja;
	}

	public Date getFecha_Ingreso() {
		return this.fecha_Ingreso;
	}

	public void setFecha_Ingreso(Date fecha_Ingreso) {
		this.fecha_Ingreso = fecha_Ingreso;
	}

	public Date getFecha_nacimiento() {
		return this.fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getTipoContrato() {
		return this.tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

}