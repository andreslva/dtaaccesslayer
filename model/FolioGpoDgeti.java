package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the folio_gpo_dgeti database table.
 * 
 */
@Entity
@Table(name="folio_gpo_dgeti")
@NamedQuery(name="FolioGpoDgeti.findAll", query="SELECT f FROM FolioGpoDgeti f")
public class FolioGpoDgeti implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descripcion;

	@Column(name="especialidad_id")
	private int especialidadId;

	@Column(name="folio")
	private Integer folio;

	@Column(name="generacion_id")
	private int generacionId;

	private String grupo;

	@Id
	private int id;

	private String literal;

	@Column(name="turno_id")
	private int turnoId;

	public FolioGpoDgeti() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEspecialidadId() {
		return this.especialidadId;
	}

	public void setEspecialidadId(int especialidadId) {
		this.especialidadId = especialidadId;
	}

	public Integer getFolio() {
		return this.folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	public int getGeneracionId() {
		return this.generacionId;
	}

	public void setGeneracionId(int generacionId) {
		this.generacionId = generacionId;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLiteral() {
		return this.literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public int getTurnoId() {
		return this.turnoId;
	}

	public void setTurnoId(int turnoId) {
		this.turnoId = turnoId;
	}

}