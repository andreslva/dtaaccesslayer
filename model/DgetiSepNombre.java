package itr.model;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;


/**
 * The persistent class for the dgeti_sep_nombre database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="dgeti_sep_nombre")
@NamedQuery(name="DgetiSepNombre.findAll", query="SELECT d FROM DgetiSepNombre d")
public class DgetiSepNombre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="initials_subsecretaria")
	private String initialsSubsecretaria;

	@Column(name="nom_pto_aux_academico")
	private String nomPtoAuxAcademico;

	@Column(name="nom_secretaria")
	private String nomSecretaria;

	@Column(name="nom_subsecretaria")
	private String nomSubsecretaria;

	@Column(name="nom_unidad")
	private String nomUnidad;

	private String nota;

	public DgetiSepNombre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInitialsSubsecretaria() {
		return this.initialsSubsecretaria;
	}

	public void setInitialsSubsecretaria(String initialsSubsecretaria) {
		this.initialsSubsecretaria = initialsSubsecretaria;
	}

	public String getNomPtoAuxAcademico() {
		return this.nomPtoAuxAcademico;
	}

	public void setNomPtoAuxAcademico(String nomPtoAuxAcademico) {
		this.nomPtoAuxAcademico = nomPtoAuxAcademico;
	}

	public String getNomSecretaria() {
		return this.nomSecretaria;
	}

	public void setNomSecretaria(String nomSecretaria) {
		this.nomSecretaria = nomSecretaria;
	}

	public String getNomSubsecretaria() {
		return this.nomSubsecretaria;
	}

	public void setNomSubsecretaria(String nomSubsecretaria) {
		this.nomSubsecretaria = nomSubsecretaria;
	}

	public String getNomUnidad() {
		return this.nomUnidad;
	}

	public void setNomUnidad(String nomUnidad) {
		this.nomUnidad = nomUnidad;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

}