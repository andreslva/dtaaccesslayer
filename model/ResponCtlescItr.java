package itr.model;

import java.io.Serializable;
import javax.persistence.*;

import itr.dev.DocNameImpl;
import itr.dev.DocNameInterface;


/**
 * The persistent class for the respon_ctlesc_itr database table.
 * 
 */
@Entity
@Table(name="respon_ctlesc_itr")
@NamedQueries({
@NamedQuery(name="ResponCtlescItr.findAll", query="SELECT r FROM ResponCtlescItr r"),
@NamedQuery(name="ResponCtlescItr.findById", query="SELECT r FROM ResponCtlescItr r where r.id =:nid")
})
public class ResponCtlescItr extends DocNameImpl implements Serializable {
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

	public ResponCtlescItr() {
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

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}