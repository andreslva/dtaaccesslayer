package itr.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the view_semestre_actual database table.
 * 
 */
@Entity
@Table(name="view_semestre_actual")
@NamedQueries({
@NamedQuery(name="ViewSemestreActual.findAll", query="SELECT v FROM ViewSemestreActual v"),
@NamedQuery(name="ViewSemestreActual.findByNoSem", query="SELECT v FROM ViewSemestreActual v where v.numero = :noSem")
})
public class ViewSemestreActual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	private String nombre;

	private String nombre_Corto;

	@Column(name="Numero")
	private int numero;

	private String observaciones;

	public ViewSemestreActual() {
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

}