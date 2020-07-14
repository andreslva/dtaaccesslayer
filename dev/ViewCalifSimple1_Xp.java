package itr.dev;

import itr.model.ViewExtraordinarioSolicitadoLast;

public interface ViewCalifSimple1_Xp {

	public int getClaseId();
	public int getAlumnoId();
	//public int getGrupoId();
	public double getSuma();
	public double getProm();
	public ViewExtraordinarioSolicitadoLast getViewExtraordinarioSolicitadoLast();
	public float getLastGrade();
	public int getNoPer();
	public double getPromBfrLast();
}
