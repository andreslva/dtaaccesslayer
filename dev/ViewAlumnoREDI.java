package itr.dev;

import java.text.Collator;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import itr.model.ClaveSecundaria;
import itr.model.ViewAlumnoAll;
import itr.model.ViewAlumnoRngro;

public class ViewAlumnoREDI implements Comparable<ViewAlumnoREDI>{

	private ViewAlumnoAll valumnoall;
	private Collection<ViewAlumnoRngro> listvaRngro;
	
	private boolean isRngro;
	
	public ViewAlumnoREDI() {

	}

	public ViewAlumnoREDI(ViewAlumnoAll valumnoall, Collection<ViewAlumnoRngro> listvaRngro) {
		super();
		this.valumnoall = valumnoall;
		this.listvaRngro = listvaRngro;

		boolean isRngro = true;
		if((this.listvaRngro == null) || (this.listvaRngro.isEmpty()))
		{
			isRngro = false;
		}
		this.isRngro = isRngro;
	}

	public boolean isRngro() {
		return this.isRngro;
	}


	public int getGenID() {
		return valumnoall.getGenID();
	}

	public int getEspId() {
		return valumnoall.getEspId();
	}

	public String getGenNombre() {
		return valumnoall.getGenNombre();
	}

	public String getGenLit() {
		return valumnoall.getGenLit();
	}

	public int getLn() {
		return valumnoall.getLn();
	}

	public boolean isBaja() {
		return valumnoall.isBaja();
	}

	public ClaveSecundaria getClSecId() {
		return valumnoall.getClSecId();
	}

	public String getCodigo() {
		return valumnoall.getCodigo();
	}

	public short getCreditos() {
		return valumnoall.getCreditos();
	}

	public String getCurp() {
		return valumnoall.getCurp();
	}

	public String getEspecialidad() {
		return valumnoall.getEspecialidad();
	}

	public Date getFecha_Ingreso() {
		return valumnoall.getFecha_Ingreso();
	}

	public int getFolio() {
		return valumnoall.getFolio();
	}

	public String getGenero() {
		return valumnoall.getGenero();
	}

	public String getGrupo() {
		return valumnoall.getGrupo();
	}

	public String getGrupoDgeti() {
		return valumnoall.getGrupoDgeti();
	}

	public int getGrupoId() {
		return valumnoall.getGrupoId();
	}

	public String getGrupoLiteral() {
		return valumnoall.getGrupoLiteral();
	}

	public int getId() {
		return valumnoall.getId();
	}

	public float getMensualidad() {
		return valumnoall.getMensualidad();
	}

	public int getMensualidad_ID() {
		return valumnoall.getMensualidad_ID();
	}

	public String getNO_Control_DGETI() {
		return valumnoall.getNO_Control_DGETI();
	}

	public boolean hasNO_Control_DGETI() {
		return valumnoall.hasNO_Control_DGETI();
	}

	public boolean isNO_Control_DGETI_Null() {
		return valumnoall.isNO_Control_DGETI_Null();
	}

	public String getNombre() {
		return valumnoall.getNombre();
	}

	public String getNombre_Especialidad() {
		return valumnoall.getNombre_Especialidad();
	}

	public byte getPosicion_Lista() {
		return valumnoall.getPosicion_Lista();
	}

	public float getProm_Sec() {
		return valumnoall.getProm_Sec();
	}

	public String getSecTipoLiteral() {
		return valumnoall.getSecTipoLiteral();
	}

	public String getSemestre() {
		return valumnoall.getSemestre();
	}

	public int getSemestre_ID() {
		return valumnoall.getSemestre_ID();
	}

	public int getSexoId() {
		return valumnoall.getSexoId();
	}

	public int getFolio_gpo_id() {
		return valumnoall.getFolio_gpo_id();
	}

	public String[] getREDLine() {
		return valumnoall.getREDLine();
	}


	public void setLn(int ln) {
		valumnoall.setLn(ln);
	}


	// Getting a default locale object
	private static Locale locale = Locale.getDefault(); 
	
	@Override
	public int compareTo(ViewAlumnoREDI o) 
	{
		//pass the user's locale as an argument
		Collator myCollator = Collator.getInstance(locale);
		
		//set collator to Ignore case but not accents
		//(default is Collator.TERTIARY, which is
		//case sensitive)
		myCollator.setStrength(Collator.PRIMARY);

		int comp = Boolean.compare(this.isRngro, o.isRngro);
		
		if(comp == 0)
		{
			comp = myCollator.compare( this.getNO_Control_DGETI(), o.getNO_Control_DGETI() );			
		}

		return comp;
	}
}
