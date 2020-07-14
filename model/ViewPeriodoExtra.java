package itr.model;

import itr.utils.ITRUtils;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;

import java.math.BigInteger;
import java.text.Collator;


/**
 * The persistent class for the view_periodo_extra database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_periodo_extra")
@NamedQuery(name="ViewPeriodoExtra.findAll", query="SELECT v FROM ViewPeriodoExtra v")
public class ViewPeriodoExtra implements Serializable, Comparable<ViewPeriodoExtra> {
	private static final long serialVersionUID = 1L;

	private String literal;

	@Column(name="literal_ext")
	private String literalExt;

	private String nombre;

	@Id
	@Column(name="p_dgeti_ext_id")
	private int pDgetiExtId;

	@Column(name="p_dgeti_id")
	private int pDgetiId;

	@Column(name="linked_pdgt_id")
	private int linkedPdgetiId;

	@Column(name="coord_dgti_id")
	private int coordDGETI_ID;

	@Column(name="coord_dgti_lit")
	private String coordDGETI_LIT;
	
	@Column(name="p_key")
	private String pKey;

	@Column(name="periodo_examen")
	private String periodoExamen;

	@Column(name="periodo_extra")
	private String periodoExtra;

	private Integer year;

	@Column(name="year_id")
	private int yearId;

	@Column(name="year_lit")
	private int yearLit;

	@Column(name="year_nombre")
	private int yearNombre;

	@Column(name="p_sem_anual_id")
	private int pSemAnualId;
	
	@Column(name="p_extra_enum_id")
	private int pExtEnumId;
	
	public ViewPeriodoExtra() {
	}

	public int getpSemAnualId() {
		return pSemAnualId;
	}

	public void setpSemAnualId(int pSemAnualId) {
		this.pSemAnualId = pSemAnualId;
	}

	public int getpExtEnumId() {
		return pExtEnumId;
	}

	public void setpExtEnumId(int pExtEnumId) {
		this.pExtEnumId = pExtEnumId;
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

	public int getPDgetiExtId() {
		return this.pDgetiExtId;
	}

	public void setPDgetiExtId(int pDgetiExtId) {
		this.pDgetiExtId = pDgetiExtId;
	}

	public int getPDgetiId() {
		return this.pDgetiId;
	}

	public void setPDgetiId(int pDgetiId) {
		this.pDgetiId = pDgetiId;
	}

	public int getLinkedPdgetiId() {
		return linkedPdgetiId;
	}

	public void setLinkedPdgetiId(int linkedPdgetiId) {
		this.linkedPdgetiId = linkedPdgetiId;
	}

	public String getPKey() {
		return this.pKey;
	}

	public void setPKey(String pKey) {
		this.pKey = pKey;
	}

	public String getPeriodoExamen() {
		return this.periodoExamen;
	}

	public void setPeriodoExamen(String periodoExamen) {
		this.periodoExamen = periodoExamen;
	}

	public String getPeriodoExtra() {
		return this.periodoExtra;
	}

	public void setPeriodoExtra(String periodoExtra) {
		this.periodoExtra = periodoExtra;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public int getYearId() {
		return this.yearId;
	}

	public void setYearId(int yearId) {
		this.yearId = yearId;
	}

	public int getYearLit() {
		return this.yearLit;
	}

	public void setYearLit(int yearLit) {
		this.yearLit = yearLit;
	}

	public int getYearNombre() {
		return this.yearNombre;
	}

	public void setYearNombre(int yearNombre) {
		this.yearNombre = yearNombre;
	}

	public int getCoordDGETI_ID() {
		return coordDGETI_ID;
	}

	public void setCoordDGETI_ID(int coordDGETI_ID) {
		this.coordDGETI_ID = coordDGETI_ID;
	}

	public String getCoordDGETI_LIT() {
		return coordDGETI_LIT;
	}

	public void setCoordDGETI_LIT(String coordDGETI_LIT) {
		this.coordDGETI_LIT = coordDGETI_LIT;
	}

	public String getLit()
	{
		String month = getPeriodoExtra().substring(0, 1);
		String year  = getYear().toString().substring(2);
		
		StringBuffer res = new StringBuffer();
		res.append(month);
		res.append(year);

		res.trimToSize();
		
		return res.toString();
	}

	public String getLitLegend()
	{
		String month = getPeriodoExtra().substring(0, 1);
		String year  = getYear().toString().substring(2);
		
		StringBuffer res = new StringBuffer();
		res.append(month);
		res.append(year);
		res.append(": ");
		res.append(getPeriodoExtra());
		res.append(" ");
		res.append(getYear().toString());

		res.trimToSize();
		
		return res.toString();
	}

	@Override
	public int compareTo(ViewPeriodoExtra o) {

		//pass the user's locale as an argument
		//Collator myCollator = Collator.getInstance(ITRUtils.locale);

		//set collator to Ignore case but not accents
		//(default is Collator.TERTIARY, which is
		//case sensitive)
		//myCollator.setStrength(Collator.PRIMARY);
		
		//int result = this.getGrupoLiteral().compareTo(o.getGrupoLiteral()); 
		//int result = myCollator.compare(this.getYear().intValue(), o.getYear().intValue());
		int result = this.getYear().intValue() > o.getYear().intValue() ? +1 : this.getYear().intValue() < o.getYear().intValue() ? -1 : 0;
		
		if(result == 0)
		{
			//result = myCollator.compare(this.getpExtEnumId(), o.getpExtEnumId());
			result = this.getpExtEnumId() > o.getpExtEnumId() ? +1 : this.getpExtEnumId() < o.getpExtEnumId() ? -1 : 0;
		}
		
		return result;

	}
}