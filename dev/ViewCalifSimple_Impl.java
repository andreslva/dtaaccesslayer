package itr.dev;

public abstract class ViewCalifSimple_Impl implements ViewCalifSimple1_Xp {

	@Override
	public abstract float getLastGrade();

	@Override
	public abstract double getSuma();

	@Override
	public abstract double getProm();

	@Override
	public abstract int getNoPer();

	public double getPromBfrLast() {
		double d = getSuma() - getLastGrade();
		double n = getNoPer() >= 2 ? getNoPer() - 1 : 1;
		return (double) (d/n);
	}
}
