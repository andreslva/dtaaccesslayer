package itr.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;

import java.util.Date;


/**
 * The persistent class for the alumno_baja_data database table.
 * 
 */
@ReadOnly
@Entity
@Cacheable
@Table(name="alumno_baja_data")
@NamedQueries({
@NamedQuery(name="AlumnoBajaData.findAll", query="SELECT a FROM AlumnoBajaData a"),
@NamedQuery(name="AlumnoBajaData.find", query="SELECT a FROM AlumnoBajaData a where a.alumnoId = :alumno_id")
})
public class AlumnoBajaData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="alumno_id")
	private int alumnoId;

	private float deuda;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	@Id
	@Column(name="id")
	private int id;

	@Column(name="motivo_id")
	private int motivoId;

	private String nota;

	public AlumnoBajaData() {
	}

	public int getAlumnoId() {
		return this.alumnoId;
	}

	public void setAlumnoId(int alumnoId) {
		this.alumnoId = alumnoId;
	}

	public float getDeuda() {
		return this.deuda;
	}

	public void setDeuda(float deuda) {
		this.deuda = deuda;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMotivoId() {
		return this.motivoId;
	}

	public void setMotivoId(int motivoId) {
		this.motivoId = motivoId;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

}