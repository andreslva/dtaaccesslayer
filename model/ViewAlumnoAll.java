package itr.model;

import itr.utils.ITRUtils;

import java.io.Serializable;
import java.text.Collator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


/**
 * The persistent class for the view_alumno_all database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_alumno_all")
@NamedQueries({
@NamedQuery(name="ViewAlumnoAll.findAll", query="SELECT v FROM ViewAlumnoAll v"),
@NamedQuery(name="ViewAlumnoAll.findByFolio", query="SELECT v FROM ViewAlumnoAll v WHERE v.folio = :nofolio"),
@NamedQuery(
		name="ViewAlumnoAll.findByFolioId"
		, query="SELECT v FROM ViewAlumnoAll v WHERE v.folio_gpo_id = :nofolioGpoId"
		, hints=@QueryHint(name=QueryHints.READ_ONLY, value=HintValues.TRUE)
		),
@NamedQuery(name="ViewAlumnoAll.findGpoIDByAlumnoID", query="SELECT v.grupoId FROM ViewAlumnoAll v where v.id =:alumnoId")
})
public class ViewAlumnoAll implements Serializable, Comparable<ViewAlumnoAll> {
	private static final long serialVersionUID = 1L;

	// Getting a default locale object
	private static Locale locale = Locale.getDefault(); 

	//uni-directional one-to-one association to Alumno
	@OneToOne
	@JoinColumn(name="cl_sec_id", referencedColumnName="clave")
	private ClaveSecundaria clSecId;

	@Column(name="codigo")
	private String codigo;

	@Column(name="creditos")
	private short creditos;

	@Column(name="curp")
	private String curp;

	@Column(name="especialidad")
	private String especialidad;

	@Temporal(TemporalType.DATE)
	private Date fecha_Ingreso;

	@Column(name="folio")
	private int folio;

	@Column(name="folio_gpo_id")
	private int folio_gpo_id;

	@Column(name="genero")
	private String genero;

	@Column(name="grupo")
	private String grupo;

	@Column(name="grupo_dgeti")
	private String grupoDgeti;

	@Column(name="grupo_id")
	private int grupoId;

	@Column(name="grupo_literal")
	private String grupoLiteral;

	@Id
	@Column(name="id")
	private int id;

	@Column(name="mensualidad")
	private float mensualidad;

	@Column(name="mensualidad_ID")
	private int mensualidad_ID;

	@Column(name="NO_Control_DGETI")
	private String NO_Control_DGETI;

	@Column(name="nombre")
	private String nombre;

	@Column(name="`Nombre Especialidad`")
	private String nombre_Especialidad;

	@Column(name="posicion_Lista")
	private byte posicion_Lista;

	@Column(name="prom_Sec")
	private float prom_Sec;

	@Column(name="sec_tipo_literal")
	private String secTipoLiteral;

	@Column(name="semestre")
	private String semestre;

	@Column(name="semestre_ID")
	private int semestre_ID;

	@Column(name="sexo_id")
	private int sexoId;

	@Column(name="gen_id")
	private int genID;
	
	@Column(name="gen_nombre")
	private String genNombre;
	
	@Column(name="gen_lit")
	private String genLit;
	
	public int getGenID() {
		return genID;
	}

	@Column(name="esp_id")
	private int espId;

	public int getEspId() {
		return espId;
	}

	public void setEspId(int espId) {
		this.espId = espId;
	}

	public void setGenID(int genID) {
		this.genID = genID;
	}

	public String getGenNombre() {
		return genNombre;
	}

	public void setGenNombre(String genNombre) {
		this.genNombre = genNombre;
	}

	public String getGenLit() {
		return genLit;
	}

	public void setGenLit(String genLit) {
		this.genLit = genLit;
	}
	
	@Transient
	private int ln = -1; 
	
	public int getLn() {
		return ln;
	}

	public void setLn(int ln) {
		this.ln = ln;
	}

	@Transient
	private boolean isBaja;
	
	public boolean isBaja() {
		return isBaja;
	}

	public void setBaja(boolean isBaja) {
		this.isBaja = isBaja;
	}

	public ViewAlumnoAll() {
	}

	public ClaveSecundaria getClSecId() {
		return this.clSecId;
	}

	public void setClSecId(ClaveSecundaria clSecId) {
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
		return this.NO_Control_DGETI != null ? this.NO_Control_DGETI.toUpperCase() : "N/A";
	}

	public boolean hasNO_Control_DGETI() {
		return this.NO_Control_DGETI != null ? true : false;
	}

	public boolean isNO_Control_DGETI_Null() {
		return this.NO_Control_DGETI == null;
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

	public int getFolio_gpo_id() {
		return folio_gpo_id;
	}

	public void setFolio_gpo_id(int folio_gpo_id) {
		this.folio_gpo_id = folio_gpo_id;
	}
	
	@Override
	public int compareTo(ViewAlumnoAll o) 
	{
		//pass the user's locale as an argument
		Collator myCollator = Collator.getInstance(locale);

		//set collator to Ignore case but not accents
		//(default is Collator.TERTIARY, which is
		//case sensitive)
		myCollator.setStrength(Collator.PRIMARY);

		return  myCollator.compare( this.nombre, o.getNombre());
	}
	
	public String[] getREDLine()
	{
		String[] line = new String[7];
		line[0] = Integer.toString(this.getLn());
		line[1] = this.getNO_Control_DGETI();
		line[2] = this.getNombre();
		line[3] = this.getGenero();
		
		GregorianCalendar g = null;
		String y = ITRUtils.NO_CURP;
		if(this.getCurp() != null)
		{
			g = ITRUtils.getBirthDay(this.getCurp());
			if(g != null)
			{
				y = Integer.toString(g.get(GregorianCalendar.YEAR));
				y = y.substring(2);
			}
			else
			{
				y = ITRUtils.WRONG_CURP;
			}
		}

		line[4] = y;
		line[5] = Integer.toString(this.getClSecId().getClave());
		line[6] = this.getProm_Sec() == 0 ? "-" : Float.toString(this.getProm_Sec()); 
		
		return line;
	}
	
}