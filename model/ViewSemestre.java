package itr.model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the view_semestre database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="view_semestre")
@NamedQueries({
@NamedQuery(name="ViewSemestre.findAll", query="SELECT v FROM ViewSemestre v"),
@NamedQuery(name="ViewSemestre.findByNO", query="SELECT v FROM ViewSemestre v where v.numero =:noSem")
})
public class ViewSemestre implements Serializable, Comparable<ViewSemestre> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID", nullable=false)
	private int id;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Nombre_Corto")
	private String nombre_Corto;

	@Column(name="Numero")
	private int numero;

	@Column(name="Observaciones")
	private String observaciones;

	public ViewSemestre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_Corto() {
		return this.nombre_Corto;
	}

	public void setNombre_Corto(String nombre_Corto) {
		this.nombre_Corto = nombre_Corto;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int compareTo(ViewSemestre o) {
		int retval = this.getNumero() - o.getNumero();
		return retval;
		//return this.getNumero() > o.getNumero() ? +1 : this.getNumero() < o.getNumero() ? -1 : 0;
	}

}