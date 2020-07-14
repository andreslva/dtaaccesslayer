package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import java.text.Collator;
import java.util.Date;
import java.util.Locale;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a"),
@NamedQuery(name="Alumno.find", query="SELECT a FROM Alumno a where a.id = :alumno_id")
})
public class Alumno implements Serializable, Comparable<Alumno> 
{
	private static final long serialVersionUID = 1L;

	// Getting a default locale object
	private static Locale locale = Locale.getDefault(); 

	@Column(name="apellido_Materno")
	private String apellido_Materno;

	@Column(name="apellido_Paterno")
	private String apellido_Paterno;

	@Column(name="`Cel.`")
	private String cel_;

	@Column(name="curp")
	private String curp;

	@Column(name="domicilio_ID")
	private int domicilio_ID;

	@Temporal(TemporalType.DATE)
	private Date fecha_Ingreso;

	@Column(name="folio_gpo_dgeti_id")
	private int folioGpoDgetiId;

	@Column(name="grupo_ID")
	private int grupo_ID;

	@Id
	@Column(name="id")
	private Integer id;

	@Column(name="mensualidad_ID")
	private int mensualidad_ID;

	@Column(name="inscripcion_ID")
	private int inscripcion_ID;

	@Column(name="NO_Control_DGETI")
	private String NO_Control_DGETI;

	@Column(name="NO_Control_ITR")
	private String NO_Control_ITR;

	@Column(name="nombre_Completo_Tutor")
	private String nombre_Completo_Tutor;

	@Column(name="observaciones")
	private String observaciones;

	@Column(name="primer_Nombre")
	private String primer_Nombre;

	@Column(name="prom_Sec")
	private float prom_Sec;

	@Column(name="secundaria_ID")
	private int secundaria_ID;

	@Column(name="segundo_Nombre")
	private String segundo_Nombre;

	@Column(name="sexo_ID")
	private int sexo_ID;

	@Column(name="`Tel.`")
	private String tel_;

	public Alumno() {
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

	public int getDomicilio_ID() {
		return this.domicilio_ID;
	}

	public void setDomicilio_ID(int domicilio_ID) {
		this.domicilio_ID = domicilio_ID;
	}

	public Date getFecha_Ingreso() {
		return this.fecha_Ingreso;
	}

	public void setFecha_Ingreso(Date fecha_Ingreso) {
		this.fecha_Ingreso = fecha_Ingreso;
	}

	public int getFolioGpoDgetiId() {
		return this.folioGpoDgetiId;
	}

	public void setFolioGpoDgetiId(int folioGpoDgetiId) {
		this.folioGpoDgetiId = folioGpoDgetiId;
	}

	public int getGrupo_ID() {
		return this.grupo_ID;
	}

	public void setGrupo_ID(int grupo_ID) {
		this.grupo_ID = grupo_ID;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getMensualidad_ID() {
		return this.mensualidad_ID;
	}

	public void setMensualidad_ID(int mensualidad_ID) {
		this.mensualidad_ID = mensualidad_ID;
	}

	public int getInscripcion_ID() {
		return inscripcion_ID;
	}

	public void setInscripcion_ID(int inscripcion_ID) {
		this.inscripcion_ID = inscripcion_ID;
	}

	public String getNO_Control_DGETI() {
		return this.NO_Control_DGETI;
	}

	public void setNO_Control_DGETI(String NO_Control_DGETI) {
		this.NO_Control_DGETI = NO_Control_DGETI;
	}

	public String getNO_Control_ITR() {
		return this.NO_Control_ITR;
	}

	public void setNO_Control_ITR(String NO_Control_ITR) {
		this.NO_Control_ITR = NO_Control_ITR;
	}

	public String getNombre_Completo_Tutor() {
		return this.nombre_Completo_Tutor;
	}

	public void setNombre_Completo_Tutor(String nombre_Completo_Tutor) {
		this.nombre_Completo_Tutor = nombre_Completo_Tutor;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPrimer_Nombre() {
		return this.primer_Nombre;
	}

	public void setPrimer_Nombre(String primer_Nombre) {
		this.primer_Nombre = primer_Nombre;
	}

	public float getProm_Sec() {
		return this.prom_Sec;
	}

	public void setProm_Sec(float prom_Sec) {
		this.prom_Sec = prom_Sec;
	}

	public int getSecundaria_ID() {
		return this.secundaria_ID;
	}

	public void setSecundaria_ID(int secundaria_ID) {
		this.secundaria_ID = secundaria_ID;
	}

	public String getSegundo_Nombre() {
		return this.segundo_Nombre;
	}

	public void setSegundo_Nombre(String segundo_Nombre) {
		this.segundo_Nombre = segundo_Nombre;
	}

	public int getSexo_ID() {
		return this.sexo_ID;
	}

	public void setSexo_ID(int sexo_ID) {
		this.sexo_ID = sexo_ID;
	}

	public String getTel_() {
		return this.tel_;
	}

	public void setTel_(String tel_) {
		this.tel_ = tel_;
	}

	public String getFullName()
	{
		StringBuffer fullName = new StringBuffer();
		
		final String space = " ";
		
		fullName.append(this.apellido_Paterno != null ? this.apellido_Paterno.trim() : "");
		fullName.append(space);
		fullName.append(this.apellido_Materno != null ? this.apellido_Materno.trim() : "");
		fullName.append(space);
		fullName.append(this.primer_Nombre != null ? this.primer_Nombre.trim() : "");
		fullName.append(space);
		fullName.append(this.segundo_Nombre != null ? this.segundo_Nombre.trim() : "");
		
		fullName.trimToSize();
		return fullName.toString();
	}

	@Override
	public int compareTo(Alumno o) {
		//pass the user's locale as an argument
		Collator myCollator = Collator.getInstance(locale);

		//set collator to Ignore case but not accents
		//(default is Collator.TERTIARY, which is
		//case sensitive)
		myCollator.setStrength(Collator.PRIMARY);

		return  myCollator.compare( this.getFullName(), o.getFullName());
	}
	
}