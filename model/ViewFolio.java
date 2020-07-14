package itr.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ReadOnly;



/**
 * The persistent class for the view_folio database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Cache(
		  type=CacheType.SOFT, // Cache everything until the JVM decides memory is low.
		  size=64000,  		   // Use 64,000 as the initial cache size.
		  expiry=36000000,     // 10 minutes
		  coordinationType=CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS  // if cache coordination is used, only send invalidation messages.
		)
@Table(name="view_folio")
@NamedQueries({
@NamedQuery(name="ViewFolio.findAll", query="SELECT v FROM ViewFolio v"),
@NamedQuery(name="ViewFolio.findByFolioNo", query="SELECT v FROM ViewFolio v where v.folio =:nofolio"),
})
public class ViewFolio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="codigo")
	private String codigo;

	@Column(name="folio")
	private Integer folio;

	@Id
	@Column(name="folio_gpo_dgeti_id")
	private Integer folioGpoDgetiId;

	@Column(name="lit_gen")
	private String litGen;

	@Column(name="lit_tno")
	private String litTno;

	@Column(name="no_gpo")
	private String noGpo;

	@Column(name="nom_cto_esp")
	private String nomCtoEsp;

	@Column(name="nom_esp")
	private String nomEsp;

	@Column(name="nom_gen")
	private String nomGen;

	@Column(name="nom_tno")
	private String nomTno;

	//uni-directional one-to-one association to ViewEspecialidadArea
	@OneToOne
	@JoinColumn(name="especialidad_id", referencedColumnName="especialidad_id")
	private ViewEspecialidadArea viewEspArea;

	@Column(name="gen_id")
	private Integer genId;

	public Integer getGenId() {
		return genId;
	}

	public void setGenId(Integer genId) {
		this.genId = genId;
	}

	public ViewEspecialidadArea getViewEspArea() {
		return viewEspArea;
	}

	public void setViewEspArea(ViewEspecialidadArea viewEspArea) {
		this.viewEspArea = viewEspArea;
	}

	public ViewFolio() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getFolio() {
		return this.folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	public Integer getFolioGpoDgetiId() {
		return this.folioGpoDgetiId;
	}

	public void setFolioGpoDgetiId(Integer folioGpoDgetiId) {
		this.folioGpoDgetiId = folioGpoDgetiId;
	}

	public String getLitGen() {
		return this.litGen;
	}

	public void setLitGen(String litGen) {
		this.litGen = litGen;
	}

	public String getLitTno() {
		return this.litTno;
	}

	public void setLitTno(String litTno) {
		this.litTno = litTno;
	}

	public String getNoGpo() {
		return this.noGpo;
	}

	public void setNoGpo(String noGpo) {
		this.noGpo = noGpo;
	}

	public String getNomCtoEsp() {
		return this.nomCtoEsp;
	}

	public void setNomCtoEsp(String nomCtoEsp) {
		this.nomCtoEsp = nomCtoEsp;
	}

	public String getNomEsp() {
		return this.nomEsp;
	}

	public void setNomEsp(String nomEsp) {
		this.nomEsp = nomEsp;
	}

	public String getNomGen() {
		return this.nomGen;
	}

	public void setNomGen(String nomGen) {
		this.nomGen = nomGen;
	}

	public String getNomTno() {
		return this.nomTno;
	}

	public void setNomTno(String nomTno) {
		this.nomTno = nomTno;
	}

	public String getBookmarkStr()
	{
		StringBuffer bmk = new StringBuffer();
		bmk.append(getCodigo());
		bmk.append("_");
		bmk.append(getLitGen());
		bmk.append("_");
		bmk.append(getFolio());
		return bmk.toString();
	}
}