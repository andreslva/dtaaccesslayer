package itr.dev;

import java.io.Serializable;

import itr.model.ViewExtraordinarioSolicitadoLast;

public class ViewCalifSimple1_XpImpl implements ViewCalifSimple1_Xp {

	private int claseid;
	private int alumnoid;
	private double suma;
	private double prom;
	private int noPer;
	private float lastGrade;//ultima calificacion
	private ViewExtraordinarioSolicitadoLast extraLast;

	public ViewCalifSimple1_XpImpl(int claseid, int alumnoid, double suma, double prom, int noPer, float lastGrade,
			ViewExtraordinarioSolicitadoLast extraLast) {
		super();
		this.claseid = claseid;
		this.alumnoid = alumnoid;
		this.suma = suma;
		this.prom = prom;
		this.noPer = noPer;
		this.lastGrade = lastGrade;
		this.extraLast = extraLast;
	}

	@Override
	public int getClaseId() {
		return claseid;
	}

	@Override
	public int getAlumnoId() {
		return alumnoid;
	}

	@Override
	public double getSuma() {
		return suma;
	}

	@Override
	public double getProm() {
		return prom;
	}

	@Override
	public ViewExtraordinarioSolicitadoLast getViewExtraordinarioSolicitadoLast() {
		return this.extraLast;
	}

	@Override
	public float getLastGrade() {
		return lastGrade;
	}

	@Override
	public int getNoPer() {
		return noPer;
	}

	public double getPromBfrLast() {
		double d = this.suma - this.lastGrade;
		double n = this.noPer >= 2 ? this.noPer - 1 : 1;
		return (double) (d/n);
	}
}
