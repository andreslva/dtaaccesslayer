package itr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the maestro database table.
 * 
 */
@Entity
@Table(name="maestro")
@NamedQuery(name="Maestro.findAll", query="SELECT m FROM Maestro m")
public class Maestro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=50)
	private String apellido_Materno;

	@Column(length=50)
	private String apellido_Paterno;

	@Column(name="`Cel.`", length=50)
	private String cel_;

	@Column(length=50)
	private String curp;

	@Column(length=50)
	private String direccion;

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

	@Column(length=50)
	private String observaciones;

	@Column(length=100)
	private String ocupacion;

	@Column(length=50)
	private String primer_Nombre;

	@Column(length=50)
	private String rfc;

	@Column(length=50)
	private String segundo_Nombre;

	@Column(name="`Tel.`", length=50)
	private String tel_;

	private int tipo_Contrato_ID;

	public Maestro() {
	}

	public String getApellido_Materno() {
		return this.apellido_Materno;
	}

	public void setApellido_Materno(String apellido_Materno) {
		this.apellido_Materno = apellido_Materno;
	}

	public String getApellido_Paterno() {
		return this.apellido_Paterno;
	}

	public void setApellido_Paterno(String apellido_Paterno) {
		this.apellido_Paterno = apellido_Paterno;
	}

	public String getCel_() {
		return this.cel_;
	}

	public void setCel_(String cel_) {
		this.cel_ = cel_;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getPrimer_Nombre() {
		return this.primer_Nombre;
	}

	public void setPrimer_Nombre(String primer_Nombre) {
		this.primer_Nombre = primer_Nombre;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getSegundo_Nombre() {
		return this.segundo_Nombre;
	}

	public void setSegundo_Nombre(String segundo_Nombre) {
		this.segundo_Nombre = segundo_Nombre;
	}

	public String getTel_() {
		return this.tel_;
	}

	public void setTel_(String tel_) {
		this.tel_ = tel_;
	}

	public int getTipo_Contrato_ID() {
		return this.tipo_Contrato_ID;
	}

	public void setTipo_Contrato_ID(int tipo_Contrato_ID) {
		this.tipo_Contrato_ID = tipo_Contrato_ID;
	}

}