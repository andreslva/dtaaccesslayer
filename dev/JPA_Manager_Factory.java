package itr.dev;

public class JPA_Manager_Factory {

	public static final int REXA_TYPE = 0;
	public static final int REDI_TYPE = 1;
	
	/*public static JPA_Manager getREXA_JPA_Manager(int folio_ini, int folio_end, int perExtra_ini, int perExtra_end, int pdId)
	{
		return new JPA_Manager(folio_ini, folio_end, perExtra_ini, perExtra_end, pdId);
	}*/
	
	/*public static JPA_Manager getREDI_HIST_JPA_Manager(int folio_ini, int folio_end, int pdId)
	{
		return new JPA_Manager(folio_ini, folio_end, pdId);
	}*/
	
	public static JPA_Manager get_JPA_Manager(int pdId) throws javax.persistence.PersistenceException
	{
		return new JPA_Manager(pdId);
	}
	
	private static final int PERIODO_DGETI_ID_0 = 0;
	public static JPA_Manager get_JPA_ManagerGlobal()
	{
		return new JPA_Manager(PERIODO_DGETI_ID_0);
	}
}
