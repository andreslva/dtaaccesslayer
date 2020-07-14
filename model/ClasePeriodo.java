package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clase_periodo database table.
 * 
 */
@Entity
@Cacheable
@Table(name="clase_periodo")
@IdClass(value=ClasePeriodoPK.class)
@NamedQuery(name="ClasePeriodo.findAll", query="SELECT c FROM ClasePeriodo c")
public class ClasePeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="clase_id")
    int claseId;

	@Id
	@Column(name="per_clases_id")
	int perClasePerId;
	
	@Column(length=200)
	private String descripcion;

	@Column(name="no_sesiones", nullable=false)
	private byte noSesiones;

	public ClasePeriodo() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getNoSesiones() {
		return this.noSesiones;
	}

	public void setNoSesiones(byte noSesiones) {
		this.noSesiones = noSesiones;
	}

	public int getClaseId() {
		return claseId;
	}

	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	public int getPerClasePerId() {
		return perClasePerId;
	}

	public void setPerClasePerId(int perClasePerId) {
		this.perClasePerId = perClasePerId;
	}

}