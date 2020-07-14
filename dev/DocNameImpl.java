package itr.dev;

public abstract class DocNameImpl implements DocNameInterface {

	public DocNameImpl() {
	}

	@Override
	public String formatName(boolean wthTitle) {
		StringBuffer name;
		String pNom  = getPrimerNombre();
		String sNom  = getSegundoNombre();
		String pApe  = getPrimerApellido();
		String sApe  = getSegundoApellido();
		
		if(sNom.trim().compareToIgnoreCase("") != 0)
		{
			sNom = sNom.substring(0,1).toUpperCase().concat(".");
		}
		
		if(sApe.trim() != "")
		{
			sApe = sApe.substring(0,1).toUpperCase().concat(".");
		}

		name = new StringBuffer(pNom);
		name.append(" ");
		name.append(sNom);
		name.append(" ");
		name.append(pApe);
		name.append(" ");
		name.append(sApe);
		
		if(wthTitle)
		{
			String title = getTitulo().concat(" ");
			name.insert(0, title.trim());
		}
		return name.toString();
	}
}
