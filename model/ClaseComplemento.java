package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clase_complemento database table.
 * 
 */
@Entity
@Cacheable
@Table(name="clase_complemento")
@NamedQuery(name="ClaseComplemento.findAll", query="SELECT c FROM ClaseComplemento c")
public class ClaseComplemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nota;

	public ClaseComplemento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

}