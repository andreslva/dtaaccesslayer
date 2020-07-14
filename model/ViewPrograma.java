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

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_programa database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_programa")
@NamedQueries({
@NamedQuery(name="ViewPrograma.findAll", query="SELECT v FROM ViewPrograma v"),
@NamedQuery(name="ViewPrograma.findByEspSem", query="SELECT v FROM ViewPrograma v where v.espId = :esp_id and v.semId = :sem_id"),
@NamedQuery(name="ViewPrograma.findByEsp", query="SELECT v FROM ViewPrograma v where v.espId = :esp_id")
})
public class ViewPrograma implements Serializable, Comparable<ViewPrograma> 
{
	private static final long serialVersionUID = 1L;

	// Getting a default locale object
	//private static Locale locale = Locale.getDefault(); 
	
	private String codigo;

	private int creditos;

	@Column(name="esp_id")
	private int espId;

	private int hrs_Practica;

	private int hrs_Teoria;

	/*@Column(name="mat_id")
	private int matId;*/
	//uni-directional one-to-one association to Alumno
	@OneToOne
	@JoinColumn(name="mat_id", referencedColumnName="ID")
	private ViewMateria viewMateria;

	@Column(name="nom_corto_esp")
	private String nomCortoEsp;

	@Column(name="nom_esp")
	private String nomEsp;

	@Column(name="nom_mat")
	private String nomMat;

	@Column(name="nom_sem")
	private String nomSem;

	private String nombre_Programa;

	@Column(name="num_sem")
	private int numSem;

	@Column(name="plan_id")
	private int planId;

	@Id
	@Column(name="prog_id")
	private int progId;

	@Column(name="sem_id")
	private int semId;

	@Column(name="position")
	private int position;
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public ViewPrograma() {
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

	public int getEspId() {
		return this.espId;
	}

	public void setEspId(int espId) {
		this.espId = espId;
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

	/*public int getMatId() {
		return this.matId;
	}

	public void setMatId(int matId) {
		this.matId = matId;
	}*/
	public ViewMateria getViewMateria() {
		return this.viewMateria;
	}

	public void setViewMateria(ViewMateria materia) {
		this.viewMateria = materia;
	}
	
	public String getNomCortoEsp() {
		return this.nomCortoEsp;
	}

	public void setNomCortoEsp(String nomCortoEsp) {
		this.nomCortoEsp = nomCortoEsp;
	}

	public String getNomEsp() {
		return this.nomEsp;
	}

	public void setNomEsp(String nomEsp) {
		this.nomEsp = nomEsp;
	}

	public String getNomMat() {
		return this.nomMat;
	}

	public String getLegend() {
		StringBuffer s = new StringBuffer(Integer.toString(this.getPosition()));
		s.append(" ");
		s.append(this.nomMat);
		return s.toString();
	}
	
	public void setNomMat(String nomMat) {
		this.nomMat = nomMat;
	}

	public String getNomSem() {
		return this.nomSem;
	}

	public void setNomSem(String nomSem) {
		this.nomSem = nomSem;
	}

	public String getNombre_Programa() {
		return this.nombre_Programa;
	}

	public void setNombre_Programa(String nombre_Programa) {
		this.nombre_Programa = nombre_Programa;
	}

	public int getNumSem() {
		return this.numSem;
	}

	public void setNumSem(int numSem) {
		this.numSem = numSem;
	}

	public int getPlanId() {
		return this.planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getProgId() {
		return this.progId;
	}

	public void setProgId(int progId) {
		this.progId = progId;
	}

	public int getSemId() {
		return this.semId;
	}

	public void setSemId(int semId) {
		this.semId = semId;
	}
	
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		
		String sep = " ";
		
		s.append(getPosition());
		s.append(sep);
		s.append(getViewMateria().getNombre());
		s.append(sep);
		s.append(getViewMateria().getId());
		s.append(sep);
		s.append(getSemId());
		s.append(sep);
		s.append(getNumSem());
		s.append(sep);

		return s.toString();
	}
	
	@Override
	public int compareTo(ViewPrograma o) {

		int retval = this.getPosition() - o.getPosition();

		return retval;
	}

}