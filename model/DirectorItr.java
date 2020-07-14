package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import itr.dev.DocNameImpl;


/**
 * The persistent class for the director_itr database table.
 * 
 */
@Entity
@Table(name="director_itr")
@NamedQueries({
@NamedQuery(name="DirectorItr.findAll", query="SELECT d FROM DirectorItr d"),
@NamedQuery(name="DirectorItr.findById", query="SELECT d FROM DirectorItr d where d.id =:nid")
})
public class DirectorItr extends DocNameImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="nom_lit")
	private String nomLit;

	private String nota;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	private String titulo;

	public DirectorItr() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomLit() {
		return this.nomLit;
	}

	public void setNomLit(String nomLit) {
		this.nomLit = nomLit;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@Override
	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	@Override
	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	@Override
	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	@Override
	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	@Override
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}