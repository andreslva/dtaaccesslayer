package itr.model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_alumno_rngro database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_alumno_rngro")
@NamedQueries({
@NamedQuery(name="ViewAlumnoRngro.getByNOCTLDGETI", query="SELECT v FROM ViewAlumnoRngro v where v.NO_Control_DGETI =:noctldgeti"),
@NamedQuery(name="ViewAlumnoRngro.findAll", query="SELECT v FROM ViewAlumnoRngro v")

})
public class ViewAlumnoRngro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CURP")
	private String curp;

	@Column(name="esp_id_a")
	private int espIDA;
	
	@Column(name="esp_a")
	private String espA;

	@Column(name="folio")
	private Integer folio;

	@Column(name="folio_gpo_id")
	private int folioGpoId;

	@Column(name="gen_id_a")
	private int genIdA;

	@Column(name="gen_lit_a")
	private String genLitA;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="NO_Control_DGETI")
	private String NO_Control_DGETI;

	@Column(name="nombre")
	private String nombre;

	public ViewAlumnoRngro() {
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getEspA() {
		return this.espA;
	}

	public void setEspA(String espA) {
		this.espA = espA;
	}

	public Integer getFolio() {
		return this.folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	public int getFolioGpoId() {
		return this.folioGpoId;
	}

	public void setFolioGpoId(int folioGpoId) {
		this.folioGpoId = folioGpoId;
	}

	public int getGenIdA() {
		return this.genIdA;
	}

	public void setGenIdA(int genIdA) {
		this.genIdA = genIdA;
	}

	public String getGenLitA() {
		return this.genLitA;
	}

	public void setGenLitA(String genLitA) {
		this.genLitA = genLitA;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEspIDA() {
		return espIDA;
	}

	public void setEspIDA(int espIDA) {
		this.espIDA = espIDA;
	}
}