package itr.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_materia_pendiente database table.
 * 
 */
@ReadOnly
@Entity
@Table(name="view_materia_pendiente")
@NamedQueries({
@NamedQuery(name="ViewMateriaPendiente.findAll", query="SELECT v FROM ViewMateriaPendiente v"),
@NamedQuery(name="ViewMateriaPendiente.findByNoSemEspID", query="SELECT v FROM ViewMateriaPendiente v where v.noSemestre = :noSem and v.especialidad_ID = :espID"),
@NamedQuery(name="ViewMateriaPendiente.findBySemIDEspID", query="SELECT v FROM ViewMateriaPendiente v where v.semId = :semID and v.especialidad_ID = :espID")
})
public class ViewMateriaPendiente implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Column(name="alumno_id")
	//private int alumnoId;
	//uni-directional one-to-one association to Alumno
	@OneToOne
	@JoinColumn(name="alumno_id", referencedColumnName="ID")
	private ViewAlumnoAll alumno;
	
	private double calificacion;

	@Column(name="clase_id")
	private int claseId;

	@Id
	@Column(name="clave")
	private String clave;

	private int especialidad_ID;

	private int folio;

	@Column(name="folio_clase_id")
	private String folioClaseId;

	@Column(name="folio_gpo_id")
	private int folioGpoId;

	private String grupo;

	@Column(name="maestro_id")
	private int maestroId;

	@Column(name="materia_id")
	private int materiaId;

	private String modo;

	@Column(name="modo_id")
	private int modoId;

	@Column(name="isForaneo")
	private int isForaneo;

	@Column(name="no_semestre")
	private int noSemestre;

	@Column(name="oport_no")
	private Integer oportNo;

	private double prom;

	@Column(name="sem_id")
	private int semId;

	private double suma;

	@Column(name="gen_lit")
	private String genLit;

	@Column(name="gen_id")
	private int genID;
	
	@Column(name="programa_id")
	private int programaID;
	
	public int getProgramaID() {
		return programaID;
	}

	public void setProgramaID(int programaID) {
		this.programaID = programaID;
	}

	public String getGenLit() {
		return genLit;
	}

	public void setGenLit(String genLit) {
		this.genLit = genLit;
	}

	public int getGenID() {
		return genID;
	}

	public void setGenID(int genID) {
		this.genID = genID;
	}

	public ViewMateriaPendiente() {
	}

	/*public int getAlumnoId() {
		return this.alumnoId;
	}

	public void setAlumnoId(int alumnoId) {
		this.alumnoId = alumnoId;
	}*/
	public ViewAlumnoAll getAlumno() {
		return this.alumno;
	}

	public void setAlumno(ViewAlumnoAll alumno) {
		this.alumno = alumno;
	}

	public double getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public int getClaseId() {
		return this.claseId;
	}

	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getEspecialidad_ID() {
		return this.especialidad_ID;
	}

	public void setEspecialidad_ID(int especialidad_ID) {
		this.especialidad_ID = especialidad_ID;
	}

	public int getFolio() {
		return this.folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public String getFolioClaseId() {
		return this.folioClaseId;
	}

	public void setFolioClaseId(String folioClaseId) {
		this.folioClaseId = folioClaseId;
	}

	public int getFolioGpoId() {
		return this.folioGpoId;
	}

	public void setFolioGpoId(int folioGpoId) {
		this.folioGpoId = folioGpoId;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getMaestroId() {
		return this.maestroId;
	}

	public void setMaestroId(int maestroId) {
		this.maestroId = maestroId;
	}

	public int getMateriaId() {
		return this.materiaId;
	}

	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}

	public String getModo() {
		return this.modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public int getModoId() {
		return this.modoId;
	}

	public void setModoId(int modoId) {
		this.modoId = modoId;
	}

	public int getNoSemestre() {
		return this.noSemestre;
	}

	public void setNoSemestre(int noSemestre) {
		this.noSemestre = noSemestre;
	}

	public Integer getOportNo() {
		return this.oportNo;
	}

	public void setOportNo(Integer oportNo) {
		this.oportNo = oportNo;
	}

	public double getProm() {
		return this.prom;
	}

	public void setProm(double prom) {
		this.prom = prom;
	}

	public int getSemId() {
		return this.semId;
	}

	public void setSemId(int semId) {
		this.semId = semId;
	}

	public double getSuma() {
		return this.suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public int getIsForaneo() {
		return isForaneo;
	}

	public void setIsForaneo(int isForaneo) {
		this.isForaneo = isForaneo;
	}
}