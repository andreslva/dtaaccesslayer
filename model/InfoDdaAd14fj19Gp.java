package itr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the info_dda_ad14fj19_gp database table.
 * 
 */
@Entity
@Table(name="info_dda_ad14fj19_gp")
@NamedQuery(name="InfoDdaAd14fj19Gp.findAll", query="SELECT i FROM InfoDdaAd14fj19Gp i")
public class InfoDdaAd14fj19Gp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="addo_insc")
	private double addoInsc;

	@Id
	@Column(name="almno_id")
	private int almnoId;

	@Column(name="code_sum")
	private int codeSum;

	@Column(name="deuda_baja")
	private double deudaBaja;

	@Column(name="gen_lit")
	private String genLit;

	@Column(name="generacion_id")
	private int generacionId;

	@Column(name="no_atras")
	private int noAtras;

	@Column(name="no_entries")
	private int noEntries;

	@Column(name="ttl_atras")
	private double ttlAtras;

	public InfoDdaAd14fj19Gp() {
	}

	public double getAddoInsc() {
		return this.addoInsc;
	}

	public void setAddoInsc(double addoInsc) {
		this.addoInsc = addoInsc;
	}

	public int getAlmnoId() {
		return this.almnoId;
	}

	public void setAlmnoId(int almnoId) {
		this.almnoId = almnoId;
	}

	public int getCodeSum() {
		return this.codeSum;
	}

	public void setCodeSum(int codeSum) {
		this.codeSum = codeSum;
	}

	public double getDeudaBaja() {
		return this.deudaBaja;
	}

	public void setDeudaBaja(double deudaBaja) {
		this.deudaBaja = deudaBaja;
	}

	public String getGenLit() {
		return this.genLit;
	}

	public void setGenLit(String genLit) {
		this.genLit = genLit;
	}

	public int getGeneracionId() {
		return this.generacionId;
	}

	public void setGeneracionId(int generacionId) {
		this.generacionId = generacionId;
	}

	public int getNoAtras() {
		return this.noAtras;
	}

	public void setNoAtras(int noAtras) {
		this.noAtras = noAtras;
	}

	public int getNoEntries() {
		return this.noEntries;
	}

	public void setNoEntries(int noEntries) {
		this.noEntries = noEntries;
	}

	public double getTtlAtras() {
		return this.ttlAtras;
	}

	public void setTtlAtras(double ttlAtras) {
		this.ttlAtras = ttlAtras;
	}

}