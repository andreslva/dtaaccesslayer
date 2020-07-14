package itr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


/**
 * The persistent class for the meta_data database table.
 * 
 */
@ReadOnly
@Entity
@Table(name="meta_data")
@NamedQueries({
@NamedQuery(name="MetaData.findAll", query="SELECT m FROM MetaData m"),
@NamedQuery(
		name="MetaData.findProp"
		, query="SELECT v FROM MetaData v WHERE v.campo = :fieldName"
		, hints=@QueryHint(name=QueryHints.READ_ONLY, value=HintValues.TRUE)
		)
})
public class MetaData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=15)
	private String campo;

	@Lob
	private String descripcion;

	@Id
	@Column(nullable=false)
	private int id;

	private int numeric_Field;

	@Lob
	private String text_Field;

	public MetaData() {
	}

	public String getCampo() {
		return this.campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeric_Field() {
		return this.numeric_Field;
	}

	public void setNumeric_Field(int numeric_Field) {
		this.numeric_Field = numeric_Field;
	}

	public String getText_Field() {
		return this.text_Field;
	}

	public void setText_Field(String text_Field) {
		this.text_Field = text_Field;
	}

}