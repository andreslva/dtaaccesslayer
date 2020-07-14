package itr.model;

import java.io.Serializable;
import java.text.Collator;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


/**
 * The persistent class for the view_alumno database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_alumno")
@NamedQueries({
@NamedQuery(name="ViewAlumno.findAll", query="SELECT v FROM ViewAlumno v"),
@NamedQuery(name="ViewAlumno.findByGpo", query="SELECT v FROM ViewAlumno v where v.grupoId =:gpoId"),
@NamedQuery(
		name="ViewAlumno.findByFolioId"
		, query="SELECT v FROM ViewAlumno v WHERE v.folioGpoId = :nofolioGpoId"
		, hints=@QueryHint(name=QueryHints.READ_ONLY, value=HintValues.TRUE)
		),
@NamedQuery(name="ViewAlumno.findGpoIDByAlumnoID", query="SELECT v.grupoId FROM ViewAlumno v where v.id =:alumnoId")
})
public class ViewAlumno implements Serializable, Comparable<ViewAlumno> {
	private static final long serialVersionUID = 1L;

	@Column(name="cl_sec_id")
	private byte clSecId;

	private String codigo;

	private short creditos;

	private String curp;

	private String especialidad;

	@Temporal(TemporalType.DATE)
	private Date fecha_Ingreso;

	private int folio;

	@Column(name="folio_gpo_id")
	private int folioGpoId;

	@Column(name="gen_id")
	private int genId;

	@Column(name="gen_lit")
	private String genLit;

	@Column(name="gen_nombre")
	private String genNombre;

	private String genero;

	private String grupo;

	@Column(name="grupo_dgeti")
	private String grupoDgeti;

	@Column(name="grupo_id")
	private int grupoId;

	@Column(name="grupo_literal")
	private String grupoLiteral;

	@Id
	@Column(nullable=false)
	private int id;

	private float mensualidad;

	private int mensualidad_ID;

	private String NO_Control_DGETI;

	private String nombre;

	@Column(name="`Nombre Especialidad`")
	private String nombre_Especialidad;

	private byte posicion_Lista;

	private float prom_Sec;

	@Column(name="sec_tipo_literal")
	private String secTipoLiteral;

	private String semestre;

	private int semestre_ID;

	@Column(name="sexo_id")
	private int sexoId;

	@Column(name="esp_id")
	private int espId;

	public int getEspId() {
		return espId;
	}

	public void setEspId(int espId) {
		this.espId = espId;
	}

	public ViewAlumno() {
	}

	public byte getClSecId() {
		return this.clSecId;
	}

	public void setClSecId(byte clSecId) {
		this.clSecId = clSecId;
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

	public Date getFecha_Ingreso() {
		return this.fecha_Ingreso;
	}

	public void setFecha_Ingreso(Date fecha_Ingreso) {
		this.fecha_Ingreso = fecha_Ingreso;
	}

	public int getFolio() {
		return this.folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public int getFolioGpoId() {
		return this.folioGpoId;
	}

	public void setFolioGpoId(int folioGpoId) {
		this.folioGpoId = folioGpoId;
	}

	public int getGenId() {
		return this.genId;
	}

	public void setGenId(int genId) {
		this.genId = genId;
	}

	public String getGenLit() {
		return this.genLit;
	}

	public void setGenLit(String genLit) {
		this.genLit = genLit;
	}

	public String getGenNombre() {
		return this.genNombre;
	}

	public void setGenNombre(String genNombre) {
		this.genNombre = genNombre;
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

	public String getGrupoDgeti() {
		return this.grupoDgeti;
	}

	public void setGrupoDgeti(String grupoDgeti) {
		this.grupoDgeti = grupoDgeti;
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

	public float getMensualidad() {
		return this.mensualidad;
	}

	public void setMensualidad(float mensualidad) {
		this.mensualidad = mensualidad;
	}

	public int getMensualidad_ID() {
		return this.mensualidad_ID;
	}

	public void setMensualidad_ID(int mensualidad_ID) {
		this.mensualidad_ID = mensualidad_ID;
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

	public byte getPosicion_Lista() {
		return this.posicion_Lista;
	}

	public void setPosicion_Lista(byte posicion_Lista) {
		this.posicion_Lista = posicion_Lista;
	}

	public float getProm_Sec() {
		return this.prom_Sec;
	}

	public void setProm_Sec(float prom_Sec) {
		this.prom_Sec = prom_Sec;
	}

	public String getSecTipoLiteral() {
		return this.secTipoLiteral;
	}

	public void setSecTipoLiteral(String secTipoLiteral) {
		this.secTipoLiteral = secTipoLiteral;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public int getSemestre_ID() {
		return this.semestre_ID;
	}

	public void setSemestre_ID(int semestre_ID) {
		this.semestre_ID = semestre_ID;
	}

	public int getSexoId() {
		return this.sexoId;
	}

	public void setSexoId(int sexoId) {
		this.sexoId = sexoId;
	}

	// Getting a default locale object
	private static Locale locale = Locale.getDefault(); 
	
	@Override
	public int compareTo(ViewAlumno o) 
	{
		//pass the user's locale as an argument
		Collator myCollator = Collator.getInstance(locale);

		//set collator to Ignore case but not accents
		//(default is Collator.TERTIARY, which is
		//case sensitive)
		myCollator.setStrength(Collator.PRIMARY);

		return  myCollator.compare( this.nombre, o.getNombre());
	}
}