package itr.model;

import java.io.Serializable;
import java.text.Collator;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


/**
 * The persistent class for the view_alumno_all_x database table.
 * 
 */
@ReadOnly
@Entity
@Table(name="view_alumno_all_x")
@NamedQueries({
@NamedQuery(name="ViewAlumnoAllX.findAll", query="SELECT v FROM ViewAlumnoAllX v"),
@NamedQuery(name="ViewAlumnoAllX.findByFolio", query="SELECT v FROM ViewAlumnoAllX v WHERE v.folio = :nofolio"),
@NamedQuery(
		name="ViewAlumnoAllX.findByFolioId"
		, query="SELECT v FROM ViewAlumnoAllX v WHERE v.folioGpoId = :nofolioGpoId and v.NO_Control_DGETI is not null"
		, hints=@QueryHint(name=QueryHints.READ_ONLY, value=HintValues.TRUE)
		)
})
public class ViewAlumnoAllX implements Serializable, Comparable<ViewAlumnoAll> {
	private static final long serialVersionUID = 1L;

	// Getting a default locale object
	private static Locale locale = Locale.getDefault(); 

	@Column(name="cl_sec_id")
	private byte clSecId;

	private String codigo;

	private short creditos;

	private String curp;

	@Column(name="esp_nom_corto")
	private String espNomCorto;

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

	@Column(name="grupo_dgeti")
	private String grupoDgeti;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="NO_Control_DGETI")
	private String NO_Control_DGETI;

	@Column(name="nom_especialidad")
	private String nomEspecialidad;

	private String nombre;

	private float prom_Sec;

	@Column(name="sec_tipo_literal")
	private String secTipoLiteral;

	@Column(name="sexo_id")
	private int sexoId;

	@Column(name="esp_id")
	private int espId;

	@Column(name="Grupo_ID")
	private int grupoid;

	public int getEspId() {
		return espId;
	}

	public void setEspId(int espId) {
		this.espId = espId;
	}

	public int getGrupoID() {
		return grupoid;
	}

	public void setGrupoID(int grupoid) {
		this.grupoid = grupoid;
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

	public ViewAlumnoAllX() {
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

	public String getEspNomCorto() {
		return this.espNomCorto;
	}

	public void setEspNomCorto(String espNomCorto) {
		this.espNomCorto = espNomCorto;
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

	public String getGrupoDgeti() {
		return this.grupoDgeti;
	}

	public void setGrupoDgeti(String grupoDgeti) {
		this.grupoDgeti = grupoDgeti;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNO_Control_DGETI() {
		return this.NO_Control_DGETI;
	}

	public void setNO_Control_DGETI(String NO_Control_DGETI) {
		this.NO_Control_DGETI = NO_Control_DGETI;
	}

	public String getNomEspecialidad() {
		return this.nomEspecialidad;
	}

	public void setNomEspecialidad(String nomEspecialidad) {
		this.nomEspecialidad = nomEspecialidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getSexoId() {
		return this.sexoId;
	}

	public void setSexoId(int sexoId) {
		this.sexoId = sexoId;
	}

	/*public String[] getREDILine()
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
	}*/
	
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
}