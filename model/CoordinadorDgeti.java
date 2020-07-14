package itr.model;

import java.io.Serializable;
import javax.persistence.*;

import itr.dev.DocNameImpl;


/**
 * The persistent class for the coordinador_dgeti database table.
 * 
 */
@Entity
@Table(name="coordinador_dgeti")
@NamedQueries({
@NamedQuery(name="CoordinadorDgeti.findAll", query="SELECT c FROM CoordinadorDgeti c"),
@NamedQuery(name="CoordinadorDgeti.findById", query="SELECT c FROM CoordinadorDgeti c where c.id =:nid")
})
public class CoordinadorDgeti extends DocNameImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable=false)
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

	public CoordinadorDgeti() {
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

	@Override
	public String formatName(boolean wthTitle) {
		StringBuffer name;
		String pNom  = getPrimerNombre();
		String sNom  = getSegundoNombre();
		String pApe  = getPrimerApellido();
		String sApe  = getSegundoApellido();

		name = new StringBuffer(pNom);
		name.append(" ");
		name.append(sNom);
		name.append(" ");
		name.append(pApe);
		name.append(" ");
		name.append(sApe);
		
		if(wthTitle)
		{
			String title = getTitulo().concat(" ");
			name.insert(0, title.trim());
		}
		return name.toString();
	}
}