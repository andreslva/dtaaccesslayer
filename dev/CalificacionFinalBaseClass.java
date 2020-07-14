package itr.dev;

public class CalificacionFinalBaseClass implements CalificacionFinal {

	public CalificacionFinalBaseClass() {
	}

	private int alumnoId;
	private float calificacion;
	private int claseId;
	private String clave;
	private int folio;
	private String folioClaseId;
	private int folioGpoId;
	private String grupo;
	private int grupoId;
	private String modo;
	private int modoId;
	private int oportNo;
	private float prom;
	private float suma;
	
	@Override
	public int getAlumnoId() {
		return this.alumnoId;
	}

	@Override
	public void setAlumnoId(int alumnoId) {
		this.alumnoId = alumnoId;
	}

	@Override
	public float getCalificacion() {
		return this.calificacion;
	}

	@Override
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public int getClaseId() {
		return this.claseId;
	}

	@Override
	public void setClaseId(int claseId) {
		this.claseId = claseId;
	}

	@Override
	public String getClave() {
		return this.clave;
	}

	@Override
	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public int getFolio() {
		return this.folio;
	}

	@Override
	public void setFolio(int folio) {
		this.folio = folio;
	}

	@Override
	public String getFolioClaseId() {
		return this.folioClaseId;
	}

	@Override
	public void setFolioClaseId(String folioClaseId) {
		this.folioClaseId = folioClaseId;
	}

	@Override
	public int getFolioGpoId() {
		return this.folioGpoId;
	}

	@Override
	public void setFolioGpoId(int folioGpoId) {
		this.folioGpoId = folioGpoId;
	}

	@Override
	public String getGrupo() {
		return this.grupo;
	}

	@Override
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public int getGrupoId() {
		return this.grupoId;
	}

	@Override
	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	@Override
	public String getModo() {
		return this.modo;
	}

	@Override
	public void setModo(String modo) {
		this.modo = modo;
	}

	@Override
	public int getModoId() {
		return this.modoId;
	}

	@Override
	public void setModoId(int modoId) {
		this.modoId = modoId;
	}

	@Override
	public int getOportNo() {
		return this.oportNo;
	}

	@Override
	public void setOportNo(int oportNo) {
		this.oportNo = oportNo;
	}

	@Override
	public float getProm() {
		return this.prom;
	}

	@Override
	public void setProm(float prom) {
		this.prom = prom;
	}

	@Override
	public float getSuma() {
		return this.suma;
	}

	@Override
	public void setSuma(float suma) {
		this.suma = suma;
	}

}
