package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_clases_gpo_mto_doc database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_clases_gpo_mto_doc")
@NamedQueries({
@NamedQuery(name="ViewClasesGpoMtoDoc.findAll", query="SELECT v FROM ViewClasesGpoMtoDoc v"),
@NamedQuery(name="ViewClasesGpoMtoDoc.findByFolioClaseIds", query="SELECT v FROM ViewClasesGpoMtoDoc v where v.folio_gpo_dgeti_id = :folioid and v.claseId = :claseid"),
@NamedQuery(name="ViewClasesGpoMtoDoc.findByFolioId", query="SELECT v FROM ViewClasesGpoMtoDoc v where v.folio_gpo_dgeti_id = :folioid"),
@NamedQuery(name="ViewClasesGpoMtoDoc.findByFolioNo", query="SELECT v FROM ViewClasesGpoMtoDoc v where v.folio = :foliono"),
@NamedQuery(name="ViewClasesGpoMtoDoc.findByFolioGrupoIds", query="SELECT v FROM ViewClasesGpoMtoDoc v where v.folio_gpo_dgeti_id = :folioid and v.grupoId =:grupoid"),
@NamedQuery(name="ViewClasesGpoMtoDoc.findByFolioGrupoIdsDoc", query="SELECT v FROM ViewClasesGpoMtoDoc v where v.folio_gpo_dgeti_id = :folioid and v.grupoId =:grupoid and v.cls_cmplto_id IS NULL")
})
public class ViewClasesGpoMtoDoc implements Serializable, Comparable<ViewClasesGpoMtoDoc> {
	private static final long serialVersionUID = 1L;

	@Column(name="clase_id")
	private int claseId;

	private String codigo;

	private int creditos;

	private int especialidad_ID;

	private Integer folio;

	@Id
	@Column(name="folio_clase_id")
	private String folioClaseId;

	@Column(name="gen_lit")
	private String genLit;

	@Column(name="gen_id")
	private int genId;

	@Column(name="gpo_dgeti")
	private String gpoDgeti;

	private String grupo;

	@Column(name="grupo_id")
	private int grupoId;

	private int hrs;

	private int hrs_Practica;

	private int hrs_Teoria;

	private String maestro;

	@Column(name="maestro_id")
	private int maestroId;

	private String materia;

	@Column(name="materia_id")
	private int materiaId;

	@Column(name="no_semestre")
	private int noSemestre;

	@Column(name="nom_especialidad")
	private String nomEspecialidad;

	private String observaciones;

	@Column(name="periodo_dgeti")
	private String periodoDgeti;

	@Lob
	@Column(name="plan_estudio")
	private String planEstudio;

	@Column(name="plan_estudio_id")
	private int planEstudioId;

	//orig: @Column(name="programa_id")
	//orig: #private int programaId;
	//uni-directional one-to-one association to ViewEspecialidadArea
	@OneToOne
	@JoinColumn(name="programa_id", referencedColumnName="prog_id")
	private ViewPrograma viewPrograma;

	private String turno;
	
	private int turno_id;
	
	private int sem_id;

	@Column(name="position")
	private int position;

	@Column(name="folio_gpo_dgeti_id")
	private int folio_gpo_dgeti_id;
	
	@Column(name="no_cls_prog")
	private int no_cls_prog;
	
	@OneToOne
	@JoinColumn(name="cls_cmplto_id", referencedColumnName="ID")
	private ClaseComplemento cls_cmplto_id;
	
	public ClaseComplemento getCls_cmplto_id() {
		return cls_cmplto_id;
	}

	public void setCls_cmplto_id(ClaseComplemento cls_cmplto_id) {
		this.cls_cmplto_id = cls_cmplto_id;
	}

	public int getNo_cls_prog() {
		return no_cls_prog;
	}

	public void setNo_cls_prog(int no_cls_prog) {
		this.no_cls_prog = no_cls_prog;
	}

	public int getFolio_gpo_dgeti_id() {
		return folio_gpo_dgeti_id;
	}

	public void setFolio_gpo_dgeti_id(int folio_gpo_dgeti_id) {
		this.folio_gpo_dgeti_id = folio_gpo_dgeti_id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public ViewClasesGpoMtoDoc() {
	}

	public int getClaseId() {
		return this.claseId;
	}

	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCreditos() {
		return this.creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getEspecialidad_ID() {
		return this.especialidad_ID;
	}

	public void setEspecialidad_ID(int especialidad_ID) {
		this.especialidad_ID = especialidad_ID;
	}

	public Integer getFolio() {
		return this.folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	public String getFolioClaseId() {
		return this.folioClaseId;
	}

	public void setFolioClaseId(String folioClaseId) {
		this.folioClaseId = folioClaseId;
	}

	public String getGenLit() {
		return this.genLit;
	}

	public void setGenLit(String genLit) {
		this.genLit = genLit;
	}

	public int getGenId() {
		return genId;
	}

	public void setGenId(int genId) {
		this.genId = genId;
	}

	public String getGpoDgeti() {
		return this.gpoDgeti;
	}

	public void setGpoDgeti(String gpoDgeti) {
		this.gpoDgeti = gpoDgeti;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	public int getHrs() {
		return this.hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
	}

	public int getHrs_Practica() {
		return this.hrs_Practica;
	}

	public void setHrs_Practica(int hrs_Practica) {
		this.hrs_Practica = hrs_Practica;
	}

	public int getHrs_Teoria() {
		return this.hrs_Teoria;
	}

	public void setHrs_Teoria(int hrs_Teoria) {
		this.hrs_Teoria = hrs_Teoria;
	}

	public String getMaestro() {
		return this.maestro;
	}

	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}

	public int getMaestroId() {
		return this.maestroId;
	}

	public void setMaestroId(int maestroId) {
		this.maestroId = maestroId;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public int getMateriaId() {
		return this.materiaId;
	}

	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}

	public int getNoSemestre() {
		return this.noSemestre;
	}

	public void setNoSemestre(int noSemestre) {
		this.noSemestre = noSemestre;
	}

	public String getNomEspecialidad() {
		return this.nomEspecialidad;
	}

	public void setNomEspecialidad(String nomEspecialidad) {
		this.nomEspecialidad = nomEspecialidad;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPeriodoDgeti() {
		return this.periodoDgeti;
	}

	public void setPeriodoDgeti(String periodoDgeti) {
		this.periodoDgeti = periodoDgeti;
	}

	public String getPlanEstudio() {
		return this.planEstudio;
	}

	public void setPlanEstudio(String planEstudio) {
		this.planEstudio = planEstudio;
	}

	public int getPlanEstudioId() {
		return this.planEstudioId;
	}

	public void setPlanEstudioId(int planEstudioId) {
		this.planEstudioId = planEstudioId;
	}

	/*orig
	public int getProgramaId() {
		return this.programaId;
	}

	public void setProgramaId(int programaId) {
		this.programaId = programaId;
	}*/

	public ViewPrograma getViewPrograma() {
		return viewPrograma;
	}

	public void setViewPrograma(ViewPrograma viewPrograma) {
		this.viewPrograma = viewPrograma;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public int getTurno_id() {
		return turno_id;
	}

	public void setTurno_id(int turno_id) {
		this.turno_id = turno_id;
	}

	public int getSem_id() {
		return sem_id;
	}

	public void setSem_id(int sem_id) {
		this.sem_id = sem_id;
	}

	public String getLegend() {
		StringBuffer s = new StringBuffer(Integer.toString(this.getPosition()));
		s.append(" ");
		s.append(this.getMateria());
		return s.toString();
	}
	
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		
		String sep = " ";
		
		s.append(getPosition());
		s.append(sep);
		s.append(getMateria());
		s.append(sep);
		s.append(getMaestro());
		s.append(sep);
		s.append(getSem_id());
		s.append(sep);
		s.append(getMateriaId());

		return s.toString();
	}
	
	@Override
	public int compareTo(ViewClasesGpoMtoDoc o) {

		//pass the user's locale as an argument
		/*Collator myCollator = Collator.getInstance(locale);*/

		//set collator to Ignore case but not accents
		//(default is Collator.TERTIARY, which is
		//case sensitive)
		/*myCollator.setStrength(Collator.PRIMARY);*/

		//return  myCollator.compare( this.getMateria().getNombre(), o.getMateria().getNombre());*/
		

		int retval = this.getPosition() - o.getPosition();

		return retval;
	}
}