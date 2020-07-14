package itr.dev;

public interface DocNameInterface {

	String getPrimerApellido();

	String getPrimerNombre();

	String getSegundoApellido();

	String getSegundoNombre();

	String getTitulo();
	
	String getNomLit();

	String formatName(boolean wthTitle);	
}