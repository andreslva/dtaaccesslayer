package itr.dev;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import itr.model.Alumno;
import itr.model.AlumnoBajaData;
import itr.model.Calificacion;
import itr.model.CoordinadorDgeti;
import itr.model.DirectorItr;
import itr.model.FolioSemPerDgeti;
import itr.model.InfoDdaAd14fj19Gp;
import itr.model.MetaData;
import itr.model.PeriodoClases;
import itr.model.ResponCtlescItr;
import itr.model.ViewAlumno;
import itr.model.ViewAlumnoAll;
import itr.model.ViewAlumnoAllX;
import itr.model.ViewAlumnoBajaData;
import itr.model.ViewAlumnoRngro;
import itr.model.ViewCalifSimple1_4p;
import itr.model.ViewCalificacion;
import itr.model.ViewCalificacionFinal;
import itr.model.ViewClasesGpoMtoDoc;
import itr.model.ViewClases_grupo_mto;
import itr.model.ViewEspecialidadActual;
import itr.model.ViewExtraordinario;
import itr.model.ViewExtraordinarioResultado;
import itr.model.ViewExtraordinarioResultadoId;
import itr.model.ViewExtraordinarioSolicitadoLast;
import itr.model.ViewFolio;
import itr.model.ViewFolioGrupoInfo;
import itr.model.ViewGrupo;
import itr.model.ViewMaestro;
import itr.model.ViewMateriaPendiente;
import itr.model.ViewPeriodoDgeti;
import itr.model.ViewPeriodoDgetiForaneo;
import itr.model.ViewPeriodoExtra;
import itr.model.ViewPrograma;
import itr.model.ViewSemestre;
import itr.model.ViewSemestreActual;

public class JPA_Manager {

	public static final String connection_prop_file = 
			".\\prop\\conn_jpa.cfg"
			//".\\prop\\connection_jpa.cfg"
			;
	
	private EntityManagerFactory emf = null;

	private static final String PERSISTENT_UNIT = "Semestres_xxx_20xx";

	private static final String PROP_LOG_PARAMS 		= "eclipselink.logging.parameters";// "false"
	private static final String PROP_DRIVERCLASSNAME 	= "driverClassName";// "org.mariadb.jdbc.Driver"
	private static final String PROP_JDBC_URL 			= "javax.persistence.jdbc.url";// "jdbc:mariadb://127.0.0.1:3406/semestres_135_ago_dic_2014"
	private static final String PROP_JDBC_PWD 			= "javax.persistence.jdbc.password";// 
	private static final String PROP_JDBC_USER 			= "javax.persistence.jdbc.user";// 
	
	private Properties prop;

	public static final String driver_token 		= "driver_";//"driver";
	public static final String dbms_token 			= "dbms_";//"dbms";
	public static final String servername_token		= "serverName_";//"serverName";
	public static final String portnumber_token		= "portNumber_";//"portNumber";
	public static final String log_level_token		= "log_level_";//"log_level";
	
	public static final String server_prefix		= "server_";
	public static final String dbname_prefix 		= "dbName_";
	public static final String username_prefix 		= "userName_";
	public static final String password_prefix 		= "password_";
	
	private String driver;
	private String dbms;
	private String servername;
	private String portnumber;
	private String log_level;

	private String server;
	private String dbname;
	private String username;
	private String password;

	private EntityManager em;

	private int pdId;
	
	/*private HashMap<Integer, ViewFolio> validFolio;
	private HashMap<Integer, ViewFolioGrupoInfo> semCurr;
	
	private HashMap<Integer, ViewPeriodoExtra> validExtraPeriod;*/

	private static final String FINDNOEXTRAS = 
			"select count(v.extra_id) as no "
			+ "from view_extraordinario_solicitado_all v "
			+ "where "
			+ "v.folio_gpo_dgeti_id = ? "
			+ "and v.periodo_dgeti_extra_id = ? ";

	private static final String FINDNOOPORT = 
			"SELECT " + 
					"count(e.id) as no_oport " +
					"FROM " +
					"((alumno a " +
					"JOIN extraordinario e ON a.ID = e.Alumno_ID) " +
					"JOIN folio_gpo_dgeti f ON a.folio_gpo_dgeti_id = f.ID) " +
					"JOIN periodo_dgeti_extra pde ON e.periodo_dgeti_extra_id = pde.ID " +
					",view_clases_gpo_mto_doc vi " +
					"WHERE " +
					"    (vi.folio_gpo_dgeti_id = f.ID AND vi.clase_id = e.clase_id) " +
					"AND (pde.periodo_dgeti_id BETWEEN vi.periodo_dgeti_id " +
					"AND ?) " +						/* 1 periodo_dgeti actual*/ 
					"AND (f.ID = ?) " + 			/* 2 folio*/
					"and (e.Clase_ID = ?) " +		/* 3 clase*/
					"and (a.id = ?) " +				/* 4 alumno*/
					"GROUP BY " + 
					" vi.folio_clase_id " + 
					",a.ID ";

	private static final String FINDNOOPORT_Per_PDGTIEXTRA = 
			"SELECT " + 
					"count(e.id) as no_oport " +
					"FROM " +
					"((alumno a " +
					"JOIN extraordinario e ON a.ID = e.Alumno_ID) " +
					"JOIN folio_gpo_dgeti f ON a.folio_gpo_dgeti_id = f.ID) " +
					"JOIN periodo_dgeti_extra pde ON e.periodo_dgeti_extra_id = pde.ID " +
					",view_clases_gpo_mto_doc vi " +
					"WHERE " +
					"    (vi.folio_gpo_dgeti_id = f.ID AND vi.clase_id = e.clase_id) " +
					"AND (pde.ID <= ?) " +	        /* 1 periodo_dgeti_extra*/ 
					"AND (f.ID = ?) " + 			/* 2 folio*/
					"and (e.Clase_ID = ?) " +		/* 3 clase*/
					"and (a.id = ?) " +				/* 4 alumno*/
					"GROUP BY " + 
					" vi.folio_clase_id " + 
					",a.ID ";

	private static final String FINDLAST_EXT_ID = 
			"SELECT " +
			" max(e.ID) as last_ext_id " +
			"FROM " + 
			"((alumno a " + 
			"JOIN extraordinario e ON a.ID = e.Alumno_ID) " + 
			"JOIN folio_gpo_dgeti f ON a.folio_gpo_dgeti_id = f.ID) " + 
			"JOIN periodo_dgeti_extra pde ON e.periodo_dgeti_extra_id = pde.ID " + 
			",view_clases_gpo_mto_doc vi " + 
			"WHERE " + 
			" (vi.folio_gpo_dgeti_id = f.ID AND vi.clase_id = e.clase_id) " + 
			"AND (pde.ID <= ?) " + 	    	/* 1 periodo_dgeti_extra*/
			"AND (f.ID = ?) " +  				/* 2 folio*/	
			"AND (e.Clase_ID = ?) " + 		/* 3 clase*/	
			"AND (a.id = ?) " + 				/* 4 alumno*/
			"GROUP BY " + 
			" vi.folio_clase_id " + 
			",a.ID";			

	private static final String FIND_NO_OF_MAT = 
					"select " +
					"count(x.programa_id) as last_index " +
					"from " +
					"`view_programa-materia_ordered` x " +
					"where " +
					"    x.especialidad_id = ? " +
					"and x.sem_num = ?";
	
	private static final String FIND_DIRECTOR =
			 "select "
			+ "m.Text_Field "
			+ "from "
			+ "meta_data m "
			+ "where "
			+ "m.Campo = \"director\" ";
	
	private static final String FIND_COORDINADOR =
			 "select "
			+ "m.Text_Field "
			+ "from "
			+ "meta_data m "
			+ "where "
			+ "m.Campo = \"coordinador\" ";
	
	private static final String FIND_RESP_CONT_ESC =
			 "select "
			+ "m.Text_Field "
			+ "from "
			+ "meta_data m "
			+ "where "
			+ "m.Campo = \"resp_cont_esc\" ";

	private static final String FIND_USE_AUSENCIA = 
			  "select "
			 //+" m.Campo, "
			 +"m.Numeric_Field "
			 //+",m.Text_Field "
			 //+",m.Descripcion "
			 +"from "
			 +"meta_data m "
			 +"where "
			 +"m.Campo = \"use_ausencia\" ";
	private static final int USE_AUSENCIA = 1; // dEFAULT

	private static final String FIND_VIEW_CALIF_FINAL_BY_ALUMNO_ID =
			 "select "
			+ "v.* "
			+ "from "
			+ "view_calificacion_final v "
			+ "where "
			+ "v.alumno_id = ? ";

	private static final String FIND_VIEW_CALIF_SIMPLE_14PS_BY_ALUMNO_ID =
			 "select "
			+ "v.* "
			+ "from "
			+ "view_calif_simple_1_4ps v "
			+ "where "
			+ "v.alumno_id = ? ";

	private static final String FIND_VIEW_CALIF_FINAL_PEND_BY_ALUMNO_ID =
			 "select "
			+ "v.* "
			+ "from "
			+ "view_calificacion_final v "
			+ "where "
			+ "v.alumno_id = ? "
			+ "and "
			+ "v.Calificacion < 6 ";
	
	private static final String FIND_VIEW_MATERIA_PEND_BY_SEMID_ESPID =
			 "select "
			+ "v.* "
			+ "from "
			+ "view_materia_pendiente v "
			+ "where "
			+ "v.sem_id = ? "
			+ "and "
			+ "v.Especialidad_ID = ? ";

	private static final String FIND_VIEW_MATERIA_PEND_BY_NOSEM_ESPID =
			 "select "
			+ "v.* "
			+ "from "
			+ "view_materia_pendiente v "
			+ "where "
			+ "v.no_semestre = ? "
			+ "and "
			+ "v.Especialidad_ID = ? ";
	
	private static final String FIND_VIEW_MATERIA_PEND_BY_NOSEM_ESPID_CE =
			 "SELECT " 
			+" e.alumno_id "
			+"FROM  "
			+" view_calificacion_final e "
			+"LEFT JOIN view_alumno_baja_data d ON e.alumno_id = d.alumno_id "
			+"WHERE "
			+" d.alumno_id IS NULL AND " 
			+" ((e.modo_id = (select o.ID from calificacion_modo o where o.Literal = 'E') " 
			+" AND e.calificacion < (select m.Numeric_Field from meta_data m where m.Campo = 'calif_aprob' )) OR " 
			+" (e.modo_id = (select o.ID from calificacion_modo o where o.Literal = 'P'))) "
			+ " AND "
			+ " e.alumno_id = ?1 "
			+"GROUP BY  "
			+" e.alumno_id "
			+"HAVING COUNT(e.clase_id) > (select m.Numeric_Field from meta_data m where m.Campo = 'max_no_ext' ) ";

	/*private static final String FIND_VIEW_MATERIA_PEND_BY_NOSEM_ESPID_DANGER =
			 "select "
			+ "v.* "
			+ "from "
			+ "view_materia_pendiente v "
			+ "where "
			+ "v.no_semestre = ?1 "
			+ "and "
			+ "v.Especialidad_ID = ?2 "
			+ "and "
			+ "v.alumno_id in "
			+ "(select "
			+ "e.alumno_id "
			+ "from "
			+ "view_calificaciones_finales e left join view_alumno_baja_data d on e.alumno_id = d.alumno_id "
			+ "where "
			+ "d.alumno_id is null "
			+ "and "
			+ "((e.modo_id = ?3 and e.calificacion < ?4) "
			+ "or "
			+ "(e.modo_id = ?5)) "
			+ "group by "
			+ "e.alumno_id "
			+ "having "
			+ "count(e.clase_id) > ?6 "
			+ ") ";*/

	private static final String GET_VIEW_EXTRAORDINARIO_RESULTADO_ID_APROBADO_folioid_perextraid =
			  "select "
			+ "i.* "
			+ "from "
			+ "view_extraordinario_solicitado_last v join view_extraordinario_resultado_id i on v.max_extra_id = i.extra_id "
			+ "where "
			+ "i.Calificacion >= "
			+ "(select "
			+ "ap.Numeric_Field "
			+ "from "
			+ "meta_data ap "
			+ "where "
			+ "ap.Campo = \"calif_aprob\") "
			+ "and "
			+ "i.folio_id = ? "
			+ "and "
			+ "i.per_dgeti_extra_id = ?;";

	private static final String GET_VIEW_EXTRAORDINARIO_RESULTADO_ID_APROBADO_folioid =
			  "select "
			+ "i.* "
			+ "from "
			+ "view_extraordinario_solicitado_last v join view_extraordinario_resultado_id i on v.max_extra_id = i.extra_id "
			+ "where "
			+ "i.Calificacion >= "
			+ "(select "
			+ "ap.Numeric_Field "
			+ "from "
			+ "meta_data ap "
			+ "where "
			+ "ap.Campo = \"calif_aprob\") "
			+ "and "
			+ "i.folio_id = ? ;";	

	private static final String GET_VIEW_EXTRAORDINARIO_RESULTADO_ID_APROBADOCnt =
			  "select "
			+ "count(i.extra_id) as no "
			+ "from "
			+ "view_extraordinario_solicitado_last v join view_extraordinario_resultado_id i on v.max_extra_id = i.extra_id "
			+ "where "
			+ "i.Calificacion >= 6 "
			+ "and "
			+ "i.folio_id = ?";
	
	public JPA_Manager(int pdId) throws javax.persistence.PersistenceException
	{
		this.pdId = pdId;
		setupEM (pdId);
		em = getEmf().createEntityManager();
	}
	
	//public JPA_Manager(int folio_ini, int folio_end, int perExtra_ini, int perExtra_end)
	//{
	//	setupEM ();
	//	
	//	em = getEmf().createEntityManager();
	//	try{
	//
	//		setFolioCurr(em, folio_ini, folio_end);
	//		setCurrSem(em, folio_ini, folio_end);
	//		setPerDGETIExtraValid(em, perExtra_ini, perExtra_end);
	//
	//	}catch(Exception e)
	//	{
	//		e.printStackTrace();
	//	}/*finally{
	//		closeEntityManager();
	//	}*/
	//}

	//public JPA_Manager(int folio_ini, int folio_end, int perExtra_ini, int perExtra_end, int pdId)
	//{
	//	setupEM (pdId);
	//	
	//	em = getEmf().createEntityManager();
	//	try{
	//
	//		setFolioCurr(em, folio_ini, folio_end);
	//		setCurrSem(em, folio_ini, folio_end);
	//		setPerDGETIExtraValid(em, perExtra_ini, perExtra_end);
	//
	//	}catch(Exception e)
	//	{
	//		e.printStackTrace();
	//	}/*finally{
	//		closeEntityManager();
	//	}*/
	//}

	/*public JPA_Manager(int folio_ini, int folio_end, int pdId)
	{
		setupEM (pdId);
		
		em = getEmf().createEntityManager();
		try{

			setFolioCurr(em, folio_ini, folio_end);
			setCurrSem(em, folio_ini, folio_end);
			
			setPerDGETIExtraValid(null, 0, -1);
			//this.validExtraPeriod = null;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	public void closeEntityManager() {
		em.close();
		emf.close();
	}

	/*public static void main(String args[])
	{

		JPA_Manager jpa = new JPA_Manager();
	}*/

	private EntityManagerFactory getEmf() {
		return emf;
	}

	/*private Collection<PeriodoDgetiExtra> getPerDgetiExtra()
	{
		EntityManager em = 	getEmf().createEntityManager();

		List<PeriodoDgetiExtra> l = null;

		try{
			Query query = em.createNamedQuery("PeriodoDgetiExtra.findAll");
			l = castList(PeriodoDgetiExtra.class, query.getResultList()); 
		}finally{
			em.close();
		}

		return l;
	}*/

	//private void setPerDGETIExtraValid(EntityManager em, final int id_ini, final int id_end ){
	//	//EntityManager em = getEmf().createEntityManager();
	//
	//	if(em == null)
	//	{
	//		this.validExtraPeriod = null;
	//		return;
	//	}
	//	
	//	int size = id_end - id_ini +1;
	//	validExtraPeriod = new HashMap<Integer, ViewPeriodoExtra>(size);
	//
	//	int key = -1;
	//
	//	//try{
	//	for(int i = id_ini; i <= id_end; i++)
	//	{
	//		key = new Integer(i);
	//		ViewPeriodoExtra p = em.find(ViewPeriodoExtra.class, key);
	//		validExtraPeriod.put(key, p );
	//	}
	//	//}finally{
	//	//em.close();
	//	//}
	//
	//	//return valiodPeriod;
	//}

	/*private HashMap<Integer, ViewPeriodoExtra> getPerDGETIExtraValid(EntityManager em, final int id_ini, final int id_end ){
		HashMap<Integer, ViewPeriodoExtra> validExtraPeriod;

		int size = id_end - id_ini +1;
		validExtraPeriod = new HashMap<Integer, ViewPeriodoExtra>(size);

		int key = -1;

		for(int i = id_ini; i <= id_end; i++)
		{
			key = new Integer(i);
			ViewPeriodoExtra p = em.find(ViewPeriodoExtra.class, key);
			validExtraPeriod.put(key, p );
		}

		return validExtraPeriod;
	}*/

	//private void setFolioCurr(EntityManager em, final int folio_ini, final int folio_end ){
	//	//EntityManager em = getEmf().createEntityManager();
	//
	//	int size = folio_end - folio_ini +1;
	//	validFolio = new HashMap<Integer, ViewFolio>(size);
	//
	//	int key = -1;
	//
	//	//try{
	//	for(int i = folio_ini; i <= folio_end; i++)
	//	{
	//		key = new Integer(i);
	//		ViewFolio p = em.find(ViewFolio.class, key);
	//		validFolio.put(key, p );
	//	}
	//	//}finally{
	//	//    em.close();
	//	//}
	//
	//	//return validFolio;
	//}
	
	/*private HashMap<Integer, ViewFolio> getFolioCurr(EntityManager em, final int folio_ini, final int folio_end ){
		HashMap<Integer, ViewFolio> validFolio;
		
		int size = folio_end - folio_ini +1;
		validFolio = new HashMap<Integer, ViewFolio>(size);

		int key = -1;

		for(int i = folio_ini; i <= folio_end; i++)
		{
			key = new Integer(i);
			ViewFolio p = em.find(ViewFolio.class, key);
			validFolio.put(key, p );
		}

		return validFolio;
	}*/
	
	/*private void setCurrSem(EntityManager em, final int folio_ini, final int folio_end ){

		int size = folio_end - folio_ini +1;
		semCurr = new HashMap<Integer, ViewFolioGrupoInfo>(size);

		int key = -1;

		for(int i = folio_ini; i <= folio_end; i++)
		{
			key = new Integer(i);
			ViewFolioGrupoInfo p = em.find(ViewFolioGrupoInfo.class, key);
			semCurr.put(key, p );
		}
	}*/

	/*private HashMap<Integer, ViewFolioGrupoInfo> getCurrSem(EntityManager em, final int folio_ini, final int folio_end ){
		HashMap<Integer, ViewFolioGrupoInfo> semCurr;
		
		int size = folio_end - folio_ini +1;
		semCurr = new HashMap<Integer, ViewFolioGrupoInfo>(size);

		int key = -1;

		for(int i = folio_ini; i <= folio_end; i++)
		{
			key = new Integer(i);
			ViewFolioGrupoInfo p = em.find(ViewFolioGrupoInfo.class, key);
			semCurr.put(key, p );
		}
		
		return semCurr;
	}*/

	/*private void findFolio(int folio){
		EntityManager em = getEmf().createEntityManager();
		try{
			em.getTransaction().begin();
			ViewFolio vf = em.find(ViewFolio.class, new Integer(folio));
			em.getTransaction().commit();
		}finally{
			em.close();
		}
	}*/
	public Alumno findAlumno(int alumno_id){
		EntityManager em = getEm();
		Alumno a = null;

		//em.getTransaction().begin();
		a = em.find(Alumno.class, alumno_id);
		//em.getTransaction().commit();

		return a;
	}

	public ViewEspecialidadActual findViewEspecialidadActual(int esp_id){
		EntityManager em = getEm();
		ViewEspecialidadActual a = null;

		//em.getTransaction().begin();
		a = em.find(ViewEspecialidadActual.class, esp_id);
		//em.getTransaction().commit();

		return a;
	}

	public ViewSemestreActual findSemestreActualByNoSem(int noSem){
		EntityManager em = getEm();
	     
		ViewSemestreActual res = null;
		
		try{
            Query query = em.createNamedQuery("ViewSemestreActual.findByNoSem");
            query.setParameter("noSem", noSem);
            
            res = (ViewSemestreActual)query.getSingleResult();
            
            //res = castList(ViewFolio.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public ViewPeriodoDgeti findPeriodo_DGETI(int per_dgeti_id){
		EntityManager em = getEm();
		ViewPeriodoDgeti a = null;

		//em.getTransaction().begin();
		a = em.find(ViewPeriodoDgeti.class, per_dgeti_id);
		//em.getTransaction().commit();

		return a;
	}

	public ViewPrograma findPrograma(int prog_id){
		EntityManager em = getEm();
		ViewPrograma p = null;

		p = em.find(ViewPrograma.class, prog_id);

		return p;
	}

	public Collection<ViewAlumno> getViewAlumnoByGpoId(int gpoID){
		EntityManager em = getEm();
	     
		List<ViewAlumno> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewAlumno.findByGpo");
            query.setParameter("gpoId", gpoID);
            
            res = castList(ViewAlumno.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}
	
	public int getGpoIDFromAlumnoID(final int alumnoID){
		EntityManager em = getEm();
	     
		int gpoID = -1;
		
		try{
            Query query = em.createNamedQuery("ViewAlumno.findGpoIDByAlumnoID");
            query.setParameter("alumnoId", alumnoID);
            
            gpoID = (int)query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
		
		return gpoID;
	}
	
	public int getGpoIDFromAlumnoIDAll(final int alumnoID) throws NoResultException {
		EntityManager em = getEm();
	     
		int gpoID = -1;
		
		try{
            Query query = em.createNamedQuery("ViewAlumnoAll.findGpoIDByAlumnoID");
            query.setParameter("alumnoId", alumnoID);
            
            gpoID = (int)query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
		
		return gpoID;
	}
	
	public Collection<ViewAlumno> getViewAlumnoByFolioId(int nofolioGpoId){
		EntityManager em = getEm();
	     
		List<ViewAlumno> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewAlumno.findByFolioId");
            query.setParameter("nofolioGpoId", nofolioGpoId);
            
            res = castList(ViewAlumno.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}
	
	public Collection<ViewAlumnoAll> getAlumnoByFolio(int noFolio){
		EntityManager em = getEm();
	     
		List<ViewAlumnoAll> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewAlumnoAll.findByFolio");
            query.setParameter("nofolio", noFolio);
            
            res = castList(ViewAlumnoAll.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<ViewAlumnoAllX> getAlumnoXByFolio(int noFolio){
		EntityManager em = getEm();
	     
		List<ViewAlumnoAllX> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewAlumnoAllX.findByFolio");
            query.setParameter("nofolio", noFolio);
            
            res = castList(ViewAlumnoAllX.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<ViewAlumnoAll> getAlumnoByFolioId(int nofolioGpoId){
		EntityManager em = getEm();
	     
		List<ViewAlumnoAll> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewAlumnoAll.findByFolioId");
            query.setParameter("nofolioGpoId", nofolioGpoId);
            
            res = castList(ViewAlumnoAll.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<ViewAlumnoAllX> getAlumnoXByFolioId(int nofolioGpoId){
		EntityManager em = getEm();
	     
		List<ViewAlumnoAllX> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewAlumnoAllX.findByFolioId");
            query.setParameter("nofolioGpoId", nofolioGpoId);
            
            res = castList(ViewAlumnoAllX.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		res.removeIf(x -> x.getNO_Control_DGETI().trim().equals(""));
		
		return res;
	}

	public ViewFolio findFolioByNo(int noFolio){
		EntityManager em = getEm();
	     
		ViewFolio res = null;
		
		try{
            Query query = em.createNamedQuery("ViewFolio.findByFolioNo");
            query.setParameter("nofolio", noFolio);
            
            res = (ViewFolio)query.getSingleResult();
            
            //res = castList(ViewFolio.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public ViewFolio findViewFolio(int key){
		EntityManager em = getEm();
	     
		ViewFolio vf = null;
		
		try{
			vf = em.find(ViewFolio.class, key);
        } catch (Exception ex) {
            throw ex;
        }
		
		return vf;
	}

	public Object find(Class<?> clase, int key){
		EntityManager em = getEm();
	     
		Object o = null;
		
		try{
		o = em.find(clase, key);
        } catch (Exception ex) {
            throw ex;
        }
		
		return o;
	}

	public Object find(Class<?> clase, Object key){
		EntityManager em = getEm();
	     
		Object o = null;
		
		try{
		o = em.find(clase, key);
        } catch (Exception ex) {
            throw ex;
        }
		
		return o;
	}

	public ViewFolioGrupoInfo findFolioGpoInfoByNo(int noFolio) throws PersistenceException {
		EntityManager em = getEm();
	     
		ViewFolioGrupoInfo res = null;
		
		try{
            Query query = em.createNamedQuery("ViewFolioGrupoInfo.findByFolioNo");
            query.setParameter("nofolio", noFolio);
            
            res = (ViewFolioGrupoInfo)query.getSingleResult();
            
            //res = castList(ViewFolio.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public ViewFolioGrupoInfo findViewFolioGpoInfoByFolioNoAndGrupoID(final int noFolio, final int gpoID) throws PersistenceException {
		EntityManager em = getEm();
	     
		ViewFolioGrupoInfo res = null;
		
		try{
            Query query = em.createNamedQuery("ViewFolioGrupoInfo.findByFolioNoAndGrupoID");
            query.setParameter("noFolio", noFolio);
            query.setParameter("gpoID", gpoID);
            
            res = (ViewFolioGrupoInfo)query.getSingleResult();

        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public ViewFolioGrupoInfo findViewFolioGpoInfo(int key){
		EntityManager em = getEm();
	     
		ViewFolioGrupoInfo vfgi = null;
		
		try{
            vfgi = em.find(ViewFolioGrupoInfo.class, key);
        } catch (Exception ex) {
            throw ex;
        }
		
		return vfgi;
	}

	public ViewPeriodoExtra findViewPeriodoExtra(int key){
		EntityManager em = getEm();
	     
		ViewPeriodoExtra vpe = null;
		
		try{
            vpe = em.find(ViewPeriodoExtra.class, key);
        } catch (Exception ex) {
            throw ex;
        }
		
		return vpe;
	}
	
	private void setupEM (int pdId)
	{
		String strPdID = Integer.toString(pdId); 
		
		prop = new Properties();
		Map<String,String> props1 = new HashMap<String,String>();
		
		//"jdbc:mariadb://127.0.0.1:3406/semestres_135_ago_dic_2014"
		StringBuffer url = new StringBuffer(0);
		
		try
		{   
			prop.load(new FileInputStream(connection_prop_file));
					
			System.out.println("properties found");

			server      = prop.getProperty(JPA_Manager.server_prefix.concat(strPdID)).toString();
			
			driver 		= prop.getProperty(driver_token.concat(server)).toString();
			dbms 		= prop.getProperty(dbms_token.concat(server)).toString();
			servername 	= prop.getProperty(servername_token.concat(server)).toString();
			portnumber 	= prop.getProperty(portnumber_token.concat(server)).toString();
			log_level 	= prop.getProperty(log_level_token.concat(server)).toString();

			dbname 		= prop.getProperty(dbname_prefix.concat(strPdID)).toString();
			username 	= prop.getProperty(username_prefix.concat(strPdID)).toString();
			password 	= prop.getProperty(password_prefix.concat(strPdID)).toString();

			getURL(url);

			props1.put(PROP_LOG_PARAMS, 		log_level);
			props1.put(PROP_DRIVERCLASSNAME , 	driver);
			props1.put(PROP_JDBC_URL, 			url.toString());
			props1.put(PROP_JDBC_USER , 		username);
			props1.put(PROP_JDBC_PWD , 			password);
			props1.put("eclipselink.jdbc.exclusive-connection.mode", "Always");
			
		} catch (IOException io)
		{
			io.printStackTrace();
			return;
		}
		
		if (emf == null){
			emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT, props1);
		}
	}

	private void getURL(StringBuffer url) {
		url.append("jdbc:");
		url.append(dbms);
		url.append("://");
		url.append(servername);
		url.append(":");
		url.append(portnumber);
		url.append("/");
		url.append(dbname);
	}

	/*private void setupEM ()
	{
		if (emf == null){
			emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT);
		}
	}*/	

	private EntityManager getEm() {
		return em;
	}
	
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		List<T> r = new ArrayList<T>(c.size());
		for(Object o: c)
			r.add(clazz.cast(o));
		return r;
	}

    public Collection<ViewExtraordinarioResultado> getExtraResults(int folio, int per_dgeti_extra)
    {
		EntityManager em = getEm();//getEmf().createEntityManager();
     
		List<ViewExtraordinarioResultado> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewExtraordinarioResultado.findFOLPERDGETIEXTRA");
            query.setParameter("folioid", folio);
            query.setParameter("perextraid", per_dgeti_extra);
            
            res = castList(ViewExtraordinarioResultado.class,query.getResultList());
            
            return res;
            //return query.getResultList();
        } catch (Exception ex) {
            throw ex;
        }/*finally{
            em.close();
        }*/
    }

	public ViewExtraordinario findExtraordinario(int extraId){
		EntityManager em = getEm();
	     
		ViewExtraordinario verid = null;
		
		try{
			verid = em.find(ViewExtraordinario.class, extraId);
        } catch (Exception ex) {
            throw ex;
        }
		
		return verid;
	}
    
    public Collection<ViewExtraordinarioResultadoId> getExtraIDResults(int folioId, int per_dgeti_extra)
    {
		EntityManager em = getEm();//getEmf().createEntityManager();
     
		List<ViewExtraordinarioResultadoId> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewExtraordinarioResultadoId.findFOLPERDGETIEXTRA");
            query.setParameter("folioid", folioId);
            query.setParameter("perextraid", per_dgeti_extra);
            
            res = castList(ViewExtraordinarioResultadoId.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
    }
    
    public Collection<ViewPrograma> getProgramaByEspSem(int esp_id, int sem_id)
    {
		EntityManager em = getEm();//getEmf().createEntityManager();
     
		List<ViewPrograma> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewPrograma.findByEspSem");
            query.setParameter("esp_id", esp_id);
            query.setParameter("sem_id", sem_id);
            
            res = castList(ViewPrograma.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
    }

    public Collection<ViewPrograma> getProgramaByEsp(int esp_id)
    {
		EntityManager em = getEm();
     
		List<ViewPrograma> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewPrograma.findByEsp");
            query.setParameter("esp_id", esp_id);
            
            res = castList(ViewPrograma.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
    }

    public int getExtraResultsCnt(int folioId, int per_dgeti_extra)
    {
		EntityManager em = getEm();//getEmf().createEntityManager();

		//List<Integer> res = null;
		
		Long no = null;
		
		try{
            Query query = em.createNativeQuery(FINDNOEXTRAS);
            query.setParameter(1, folioId);
            query.setParameter(2, per_dgeti_extra);
            
            no = (Long)query.getSingleResult();
            
            //no = res.size();
            //return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            no = new Long(0);
        }/*finally{
            em.close();
        }*/
		
        return no.intValue();
    }

    public int getNO_OF_Mat(int esp_id, int sem_no)
    {
		EntityManager em = getEm();
	
		long no = -1L;
		
		try{
            Query query = em.createNativeQuery(FIND_NO_OF_MAT);
            query.setParameter(1, esp_id);
            query.setParameter(2, sem_no);
            
            no = (long)query.getSingleResult();
         
		} catch (NoResultException i)
		{
			no = 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
        return (int)no;
    }
    
    public String getNOMDIR()
    {
		EntityManager em = getEm();
	
		String nom = null;
		
		try{
            Query query = em.createNativeQuery(FIND_DIRECTOR);
           
            nom = (String)query.getSingleResult();
         
		} catch (NoResultException i)
		{
			nom = "n/a";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
        return nom;
    }
    
    public String getNOMCOR()
    {
		EntityManager em = getEm();
	
		String nom = null;
		
		try{
            Query query = em.createNativeQuery(FIND_COORDINADOR);
           
            nom = (String)query.getSingleResult();
         
		} catch (NoResultException i)
		{
			nom = "n/a";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
        return nom;
    }
    
    public String getNOM_RESP_CONT_ESC()
    {
		EntityManager em = getEm();
	
		String nom = null;
		
		try{
            Query query = em.createNativeQuery(FIND_RESP_CONT_ESC);
           
            nom = (String)query.getSingleResult();
         
		} catch (NoResultException i)
		{
			nom = "n/a";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
        return nom;
    }

    public boolean getUSE_AUSENCIA()
    {
		EntityManager em = getEm();

		int value = -1;
		try{
            Query query = em.createNativeQuery(FIND_USE_AUSENCIA);
            value = (Integer)query.getSingleResult();
		} catch (NoResultException i)
		{
			value = USE_AUSENCIA;
			System.out.println("ERROR! NO use_ausencia field!!! pid: " + getPdId());
        } catch (Exception ex) {
        	value = USE_AUSENCIA;
        	System.out.println("ERROR! NO meta_data table!!! pid: " + getPdId());
            ex.printStackTrace();
        }

		boolean useAusencia = false;
		if(value == USE_AUSENCIA)
		{
			useAusencia = true;
		}

        return useAusencia;
    }

    public int getExtraResultsOpt(int per_dgeti_id, int folio_id, int clase_id, int alumno_id)
    {
		EntityManager em = getEm();
		
		Long no = null;
		
		try{
            Query query = em.createNativeQuery(FINDNOOPORT);
            query.setParameter(1, per_dgeti_id);
            query.setParameter(2, folio_id);
            query.setParameter(3, clase_id);
            query.setParameter(4, alumno_id);
            
            no = (Long)query.getSingleResult();
            
		} 
		catch(NoResultException nr)
		{
			no = 0L;
		}catch (Exception ex) {
			ex.printStackTrace();
			no = new Long(-1);
		}

		return no.intValue();
    }

    public int getExtraResultsOptPerPDGTIEXT(int per_dgeti_extra_id, int folio_id, int clase_id, int alumno_id)
    {
		EntityManager em = getEm();
		
		Long no = null;
		
		try{
            Query query = em.createNativeQuery(FINDNOOPORT_Per_PDGTIEXTRA);
            query.setParameter(1, per_dgeti_extra_id);
            query.setParameter(2, folio_id);
            query.setParameter(3, clase_id);
            query.setParameter(4, alumno_id);
            
            no = (Long)query.getSingleResult();
            
		} 
		catch(NoResultException nr)
		{
			no = 0L;
		}catch (Exception ex) {
			ex.printStackTrace();
			no = new Long(-1);
		}

		return no.intValue();
    }

    public int findLastExtID(int per_dgeti_extra_id, int folio_id, int clase_id, int alumno_id)
    {
		EntityManager em = getEm();
		
		Integer no = null;
		
		try{
            Query query = em.createNativeQuery(FINDLAST_EXT_ID);
            query.setParameter(1, per_dgeti_extra_id);
            query.setParameter(2, folio_id);
            query.setParameter(3, clase_id);
            query.setParameter(4, alumno_id);
            
            no = (Integer)query.getSingleResult();
            
		} 
		catch(NoResultException nr)
		{
			no = 0;
		}catch (Exception ex) {
			ex.printStackTrace();
			no = new Integer(-1);
		}

		return no.intValue();
    }

    @SuppressWarnings("unchecked")
	public Collection<ViewCalificacionFinal> getCalifFinalByAlumnoID(int alumnoid)
    {
		EntityManager em = getEm();
     
		List<ViewCalificacionFinal> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewCalificacionFinal.findByAlumnoID");
            query.setParameter("alumnoid", alumnoid);
            
            res = query.getResultList();
            //res = castList(ViewCalificacionFinal.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
    }

    @SuppressWarnings("unchecked")
	public List<ViewCalificacionFinal> getCalifFinalByAlumnoIDNative(final int alumno_id)
    {
		EntityManager em = getEm();
		
		List<ViewCalificacionFinal> res = null;
		
		try{
            Query query = em.createNativeQuery(FIND_VIEW_CALIF_FINAL_BY_ALUMNO_ID,ViewCalificacionFinal.class);
            query.setParameter(1, alumno_id);
            
            res = (List<ViewCalificacionFinal>) query.getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return res;
    }

    @SuppressWarnings("unchecked")
	public Collection<ViewCalifSimple1_4p> getCalifSimple14psByAlumnoID(int alumnoid)
    {
		EntityManager em = getEm();
     
		List<ViewCalifSimple1_4p> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewCalifSimple1_4p.findbyAlumnoID");
            query.setParameter("alumnoid", alumnoid);
            
            res = query.getResultList();
            //res = castList(ViewCalificacionFinal.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
    }
    
    @SuppressWarnings("unchecked")
	public Collection<ViewCalifSimple1_Xp> getCalifSimple13psGenByAlumnoID(int alumnoid)
    {
		EntityManager em = getEm();
     
		List<ViewCalifSimple1_Xp> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewCalifSimple1_3p.findbyAlumnoID");
            query.setParameter("alumnoid", alumnoid);
            
            res = query.getResultList();
            //res = castList(ViewCalificacionFinal.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
    }

    @SuppressWarnings("unchecked")
	public Collection<ViewCalifSimple1_Xp> getCalifSimple14psGenByAlumnoID(int alumnoid)
    {
		EntityManager em = getEm();
     
		List<ViewCalifSimple1_Xp> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewCalifSimple1_4p.findbyAlumnoID");
            query.setParameter("alumnoid", alumnoid);
            
            res = query.getResultList();
            //res = castList(ViewCalificacionFinal.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
    }

    @SuppressWarnings("unchecked")
	public List<ViewCalifSimple1_4p> getCalifSimple14psByAlumnoIDNative(final int alumno_id)
    {
		EntityManager em = getEm();
		
		List<ViewCalifSimple1_4p> res = null;
		
		try{
            Query query = em.createNativeQuery(FIND_VIEW_CALIF_SIMPLE_14PS_BY_ALUMNO_ID, ViewCalifSimple1_4p.class);
            query.setParameter(1, alumno_id);
            
            res = (List<ViewCalifSimple1_4p>) query.getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return res;
    }

    @SuppressWarnings("unchecked")
	public List<ViewCalificacionFinal> getCalifFinalPENDByAlumnoIDNative(final int alumno_id)
    {
		EntityManager em = getEm();
		
		List<ViewCalificacionFinal> res = null;
		
		try{
            Query query = em.createNativeQuery(FIND_VIEW_CALIF_FINAL_PEND_BY_ALUMNO_ID,ViewCalificacionFinal.class);
            query.setParameter(1, alumno_id);
            
            res = (List<ViewCalificacionFinal>) query.getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return res;
    }

    @SuppressWarnings("unchecked")
	public List<ViewMateriaPendiente> getMatPENDBySEMID_ESPID(final int sem_id, final int especialidad_id)
    {
		EntityManager em = getEm();
		
		List<ViewMateriaPendiente> res = null;
		
		try{
            Query query = em.createNativeQuery(FIND_VIEW_MATERIA_PEND_BY_SEMID_ESPID, ViewMateriaPendiente.class);
            query.setParameter(1, sem_id);
            query.setParameter(2, especialidad_id);
            
            res = (List<ViewMateriaPendiente>) query.getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return res;
    }

    @SuppressWarnings("unchecked")
	public List<ViewMateriaPendiente> getMatPENDByNOSEM_ESPID(final int no_semestre, final int especialidad_id)
    {
		EntityManager em = getEm();
		
		List<ViewMateriaPendiente> res = null;
		
		try{
            Query query = em.createNativeQuery(FIND_VIEW_MATERIA_PEND_BY_NOSEM_ESPID, ViewMateriaPendiente.class);
            query.setParameter(1, no_semestre);
            query.setParameter(2, especialidad_id);
            
            res = (List<ViewMateriaPendiente>) query.getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return res;
    }

	public boolean isMatPENDByNOSEM_ESPID_CE(int alumnoID){
		EntityManager em = getEm();
		
		boolean isCE = false;
		
		try{
            Query query = em.createNativeQuery(FIND_VIEW_MATERIA_PEND_BY_NOSEM_ESPID_CE);
            query.setParameter(1, alumnoID);
            
            Integer id = (Integer) query.getSingleResult();
            isCE = true;
		} catch(NoResultException | NonUniqueResultException e)
		{
			isCE = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			isCE = false;
		}

		return isCE;
	}
    
    /*@SuppressWarnings("unchecked")
	public List<ViewMateriaPendiente> getMatPENDByNOSEM_ESPID_DANGER(
			final int no_semestre, 
			final int especialidad_id,
			final int extraModo_id,
			final int minGrade,
			final int pendModo_id,
			final int maxNoExt
			)
    {
		EntityManager em = getEm();
		
		List<ViewMateriaPendiente> res = null;
		
		try{
            Query query = em.createNativeQuery(FIND_VIEW_MATERIA_PEND_BY_NOSEM_ESPID_DANGER, ViewMateriaPendiente.class);
            query.setParameter(1, no_semestre);
            query.setParameter(2, especialidad_id);
            query.setParameter(3, extraModo_id);
            query.setParameter(4, minGrade);
            query.setParameter(5, pendModo_id);
            query.setParameter(6, maxNoExt);

            res = (List<ViewMateriaPendiente>) query.getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return res;
    }*/

    @SuppressWarnings("unchecked")
	public List<ViewExtraordinarioResultadoId> getExtraIdResultsPLUS6Native(final int folioId, final int perExtraId)
    {
		EntityManager em = getEm();
		
		List<ViewExtraordinarioResultadoId> res = null;
		
		try{
            Query query = em.createNativeQuery(GET_VIEW_EXTRAORDINARIO_RESULTADO_ID_APROBADO_folioid_perextraid, ViewExtraordinarioResultadoId.class);
            query.setParameter(1, folioId);
            query.setParameter(2, perExtraId);
            
            res = (List<ViewExtraordinarioResultadoId>) query.getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return res;
    }

    @SuppressWarnings("unchecked")
	public List<ViewExtraordinarioResultadoId> getExtraIdResultsPLUS6Native(final int folioId)
    {
		EntityManager em = getEm();
		
		List<ViewExtraordinarioResultadoId> res = null;
		
		try{
            Query query = em.createNativeQuery(GET_VIEW_EXTRAORDINARIO_RESULTADO_ID_APROBADO_folioid, ViewExtraordinarioResultadoId.class);
            query.setParameter(1, folioId);
            
            res = (List<ViewExtraordinarioResultadoId>) query.getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return res;
    }

    /*public int getExtraIdResultsPLUS6NativeCnt(int folioId)
    {
		EntityManager em = getEm();

		Long no = null;

		try{
            Query query = em.createNativeQuery(GET_VIEW_EXTRAORDINARIO_RESULTADO_ID_APROBADOCnt);
            query.setParameter(1, folioId);
            
            no = (Long)query.getSingleResult();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            no = new Long(0);
        }

        return no.intValue();
    }*/
    
    public Collection<ViewCalificacionFinal> getCalifFinalByAlumnoIDFolioID(int alumnoid, int folioid)
    {
		EntityManager em = getEm();
     
		List<ViewCalificacionFinal> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewCalificacionFinal.findByAlumnoIDFolioID");
            query.setParameter("alumnoid", alumnoid);
            query.setParameter("folioid", folioid);
            
            res = castList(ViewCalificacionFinal.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
    }

    public ViewClasesGpoMtoDoc findClaseByFolioClaseIds(final int folioid, final int claseid){
		EntityManager em = getEm();
	     
		ViewClasesGpoMtoDoc res = null;
		
		try{
            Query query = em.createNamedQuery("ViewClasesGpoMtoDoc.findByFolioClaseIds");
            query.setParameter("folioid", folioid);
            query.setParameter("claseid", claseid);
            
            res = (ViewClasesGpoMtoDoc)query.getSingleResult();
		} catch (NoResultException i)
		{
			return null;
        } catch (Exception ex) {
            throw ex;
        }

		return res;
	}

    public Collection<ViewClasesGpoMtoDoc> getViewClasesGpoMtoDocByFolioId(final int folioid)
    {
		EntityManager em = getEm();

		List<ViewClasesGpoMtoDoc> res = null;

		try{
            Query query = em.createNamedQuery("ViewClasesGpoMtoDoc.findByFolioId");
            query.setParameter("folioid", folioid);
            
            res = castList(ViewClasesGpoMtoDoc.class,query.getResultList());
        } catch (Exception ex) {
            throw ex;
        }

		return res;
	}

    public Collection<ViewClasesGpoMtoDoc> getViewClasesGpoMtoDocByFolioGrupoIds(final int folioid, final int grupoid)
    {
		EntityManager em = getEm();

		List<ViewClasesGpoMtoDoc> res = null;

		try{
            Query query = em.createNamedQuery("ViewClasesGpoMtoDoc.findByFolioGrupoIds");
            query.setParameter("folioid", folioid);
            query.setParameter("grupoid", grupoid);
            
            res = castList(ViewClasesGpoMtoDoc.class,query.getResultList());
        } catch (Exception ex) {
            throw ex;
        }

		return res;
	}

    public Collection<ViewClasesGpoMtoDoc> getViewClasesGpoMtoDocByFolioGrupoIdsDoc(final int folioid, final int grupoid)
    {
		EntityManager em = getEm();

		List<ViewClasesGpoMtoDoc> res = null;

		try{
            Query query = em.createNamedQuery("ViewClasesGpoMtoDoc.findByFolioGrupoIdsDoc");
            query.setParameter("folioid", folioid);
            query.setParameter("grupoid", grupoid);
            
            res = castList(ViewClasesGpoMtoDoc.class,query.getResultList());
        } catch (Exception ex) {
            throw ex;
        }

		return res;
	}
    
    public Collection<ViewClasesGpoMtoDoc> getViewClasesGpoMtoDocByFolioNo(final int foliono){
		EntityManager em = getEm();

		List<ViewClasesGpoMtoDoc> res = null;

		try{
            Query query = em.createNamedQuery("ViewClasesGpoMtoDoc.findByFolioNo");
            query.setParameter("foliono", foliono);
            
            res = castList(ViewClasesGpoMtoDoc.class,query.getResultList());
        } catch (Exception ex) {
            throw ex;
        }

		return res;
	}

    public ViewClases_grupo_mto findMateriaByClaseId(final int claseid){
		EntityManager em = getEm();
	     
		ViewClases_grupo_mto res = null;
		
		try{
            Query query = em.createNamedQuery("ViewClases_grupo_mto.findByClaseId");
            query.setParameter("claseid", claseid);
            
            res = (ViewClases_grupo_mto)query.getSingleResult();
            
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public AlumnoBajaData findAlumnoBajaDataByAlumnoID(int alumno_id){
		EntityManager em = getEm();
	     
		AlumnoBajaData res = null;
		
		try{
            Query query = em.createNamedQuery("AlumnoBajaData.find");
            query.setParameter("alumno_id", alumno_id);
            
            res = (AlumnoBajaData)query.getSingleResult();
		} catch (NoResultException ex) {
            res = null;
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public ViewAlumnoBajaData findViewAlumnoBajaData(int alumnoId){
		EntityManager em = getEm();
	     
		ViewAlumnoBajaData vfgi = null;
		
		try{
            vfgi = em.find(ViewAlumnoBajaData.class, alumnoId);
        } catch (Exception ex) {
            throw ex;
        }
		
		return vfgi;
	}

	public ViewPeriodoDgetiForaneo findViewPeriodoDgetiForaneo(int alumnoId){
		EntityManager em = getEm();
	     
		ViewPeriodoDgetiForaneo vfgi = null;
		
		try{
            vfgi = em.find(ViewPeriodoDgetiForaneo.class, alumnoId);
        } catch (Exception ex) {
            throw ex;
        }
		
		return vfgi;
	}

	public Collection<ViewAlumnoBajaData> getViewAlumnoBajaDataByFolio(int folio){
		EntityManager em = getEm();
	     
		List<ViewAlumnoBajaData> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewAlumnoBajaData.findbyFolio");
            query.setParameter("folio", folio);
            
            res = castList(ViewAlumnoBajaData.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<ViewSemestreActual> getViewSemestreActual(){
		EntityManager em = getEm();
	     
		List<ViewSemestreActual> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewSemestreActual.findAll");
            
            res = castList(ViewSemestreActual.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<ViewGrupo> getViewGrupoAll(){
		EntityManager em = getEm();
	     
		List<ViewGrupo> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewGrupo.findAll");
            
            res = castList(ViewGrupo.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<PeriodoClases> getPeriodoClasesAll(){
		EntityManager em = getEm();
	     
		List<PeriodoClases> res = null;
		
		try{
            Query query = em.createNamedQuery("PeriodoClases.findAll");
            
            res = castList(PeriodoClases.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}
	
	public ViewGrupo findViewGrupoById(int key) throws PersistenceException {
		
		EntityManager em = getEm();
	     
		ViewGrupo vg = null;
		
		try{
			vg = em.find(ViewGrupo.class, key);
        } catch (Exception ex) {
            throw ex;
        }
		
		return vg;
	}

	public Collection<ViewFolioGrupoInfo> getViewFolioGrupoInfo(){
		EntityManager em = getEm();
	     
		List<ViewFolioGrupoInfo> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewFolioGrupoInfo.findAll");
            
            res = castList(ViewFolioGrupoInfo.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<ViewFolioGrupoInfo> findViewFolioGpoInfoByNoSemester(final int noSem){
		EntityManager em = getEm();
	     
		List<ViewFolioGrupoInfo> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewFolioGrupoInfo.findByNoSemester");
            query.setParameter("noSem", noSem);
            
            res = castList(ViewFolioGrupoInfo.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }

		return res;
	}

	public Collection<ViewFolio> getViewFolio(){
		EntityManager em = getEm();

		List<ViewFolio> res = null;

		try{
            Query query = em.createNamedQuery("ViewFolio.findAll");

            res = castList(ViewFolio.class, query.getResultList());

        } catch (Exception ex) {
            throw ex;
        }

		return res;
	}

	public Collection<ViewPeriodoExtra> getViewPeriodoExtra(){
		EntityManager em = getEm();
	     
		List<ViewPeriodoExtra> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewPeriodoExtra.findAll");
            
            res = castList(ViewPeriodoExtra.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<ViewFolioGrupoInfo> getViewFolioGrupoInfoByGpoID(int grupoID){
		EntityManager em = getEm();
	     
		List<ViewFolioGrupoInfo> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewFolioGrupoInfo.findByGrupoID");
            query.setParameter("grupoID", grupoID);
            
            res = castList(ViewFolioGrupoInfo.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<ViewFolioGrupoInfo> getViewFolioGrupoInfoByGenID(int genID){
		EntityManager em = getEm();
	     
		List<ViewFolioGrupoInfo> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewFolioGrupoInfo.findByGenID");
            query.setParameter("genID", genID);
            
            res = castList(ViewFolioGrupoInfo.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}
	
	public Collection<ViewEspecialidadActual> getViewEspecialidadActual(){
		EntityManager em = getEm();
	     
		List<ViewEspecialidadActual> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewEspecialidadActual.findAll");
            
            res = castList(ViewEspecialidadActual.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<ViewMaestro> getViewMaestroActual(){
		EntityManager em = getEm();
	     
		List<ViewMaestro> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewMaestro.findAll");
            
            res = castList(ViewMaestro.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public ViewMaestro findViewMaestroById(int key){
		EntityManager em = getEm();
	     
		ViewMaestro mto = null;
		
		try{
            mto = em.find(ViewMaestro.class, key);
        } catch (Exception ex) {
            throw ex;
        }
		
		return mto;
	}
	
	public List<ViewSemestre> getViewSemestre(){
		EntityManager em = getEm();
	     
		List<ViewSemestre> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewSemestre.findAll");
            
            res = castList(ViewSemestre.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		Collections.sort(res);

		return res;
	}

	public int getPdId() {
		return pdId;
	}

	public void setPdId(int pdId) {
		this.pdId = pdId;
	}

    /*public HashMap<Integer, ViewFolio> getValidFolio() {
		return validFolio;
	}

	public HashMap<Integer, ViewPeriodoExtra> getValidExtraPeriod() {
		return validExtraPeriod;
	}

	public HashMap<Integer, ViewFolioGrupoInfo> getSemCurr() {
		return semCurr;
	}*/

	public Collection<MetaData> getMetaData(){
		EntityManager em = getEm();
	     
		List<MetaData> res = null;
		
		try{
            Query query = em.createNamedQuery("MetaData.findAll");
            
            res = castList(MetaData.class, query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public MetaData findMetaDataField(String campoName){
		EntityManager em = getEm();
	     
		MetaData res = null;
		
		try{
            Query query = em.createNamedQuery("MetaData.findProp");
            query.setParameter("fieldName", campoName);
            
            res = (MetaData)query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}
	
	public Calificacion findCalificacionByClsAlmnPer(final int claseId, final int almnoId, final int perId) throws NoResultException
	{
		EntityManager em = getEm();
	     
		Calificacion cal = null;
		
		try{
            Query query = em.createNamedQuery("Calificacion.findCalificacionByClsAlmnPer");
            query.setParameter("claseId", claseId);
            query.setParameter("almnoId", almnoId);
            query.setParameter("perId", perId);
            
            cal = (Calificacion)query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
		
		return cal;
	}

	public EntityTransaction getTransaction() {
		return em.getTransaction();
	}

	public FolioSemPerDgeti findfindFolioSemPerDgetiByNoFolio(final int noFolio){
		EntityManager em = getEm();
	     
		FolioSemPerDgeti res = null;
		
		try{
            Query query = em.createNamedQuery("FolioSemPerDgeti.findByFolio");
            query.setParameter("noFolio", noFolio);
            
            res = (FolioSemPerDgeti)query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public ViewCalificacion findViewCalificacionByClsAlmPerIds(int claseid, int alumnoid, int periodoid)
    {
		EntityManager em = getEm();

		ViewCalificacion res = null;

		try{
            Query query = em.createNamedQuery("ViewCalificacion.findByClsAlmPerIds");
            query.setParameter("claseid", claseid);
            query.setParameter("alumnoid", alumnoid);
            query.setParameter("periodoid", periodoid);
            
            res = (ViewCalificacion)query.getSingleResult();
		} catch (NoResultException i)
		{
			return null;
        } catch (Exception ex) {
            throw ex;
        }

		return res;
    }

	@SuppressWarnings("unchecked")
	public Collection<ViewCalificacion> getViewCalificacionByClsAlmnIds(int claseid, int alumnoid)
    {
		EntityManager em = getEm();

		List<ViewCalificacion> res = null;

		try{
            Query query = em.createNamedQuery("ViewCalificacion.getByClsAlmnIds");
            query.setParameter("claseid", claseid);
            query.setParameter("alumnoid", alumnoid);
            
            res = query.getResultList();
            //res = castList(ViewCalificacion.class,query.getResultList());
		} catch (Exception ex) {
            throw ex;
        }

		return res;
    }

	@SuppressWarnings("unchecked")
	public Collection<ViewCalificacion> getViewCalificacionByAlumnoID(int alumnoid)
    {
		EntityManager em = getEm();
     
		List<ViewCalificacion> res = null;
		
		try{
            Query query = em.createNamedQuery("ViewCalificacion.findByAlumnoID");
            query.setParameter("alumnoid", alumnoid);
            
            res = query.getResultList();
            //res = castList(ViewCalificacion.class,query.getResultList());
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
    }

	public ViewExtraordinarioSolicitadoLast findViewExtraordinarioSolicitadoLast(int claseid, int alumnoid)
    {
		EntityManager em = getEm();

		ViewExtraordinarioSolicitadoLast res = null;

		try{
            Query query = em.createNamedQuery("ViewExtraordinarioSolicitadoLast.findByClsAlmnIds");
            query.setParameter("claseid", claseid);
            query.setParameter("alumnoid", alumnoid);
            
            res = (ViewExtraordinarioSolicitadoLast)query.getSingleResult();
		} catch (NoResultException i)
		{
			return null;
		} catch (Exception ex) {
            throw ex;
        }

		return res;
    }	
	
	public Collection<ViewAlumnoRngro> getViewAlumnoRngrByNOCTLDGETI(String noctldgeti){
		EntityManager em = getEm();
	     
		List<ViewAlumnoRngro> v_almnrngrlist = null;
		
		try{
            Query query = em.createNamedQuery("ViewAlumnoRngro.getByNOCTLDGETI");
            query.setParameter("noctldgeti", noctldgeti.trim());
            
            v_almnrngrlist = castList(ViewAlumnoRngro.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return v_almnrngrlist;
	}

	public CoordinadorDgeti findCoordinadorDgetiById(int nid){
		EntityManager em = getEm();
	     
		CoordinadorDgeti res = null;
		
		try{
            Query query = em.createNamedQuery("CoordinadorDgeti.findById");
            query.setParameter("nid", nid);
            
            res = (CoordinadorDgeti)query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}
	
	public ResponCtlescItr findRespCtlEscById(int nid){
		EntityManager em = getEm();
	     
		ResponCtlescItr res = null;
		
		try{
            Query query = em.createNamedQuery("ResponCtlescItr.findById");
            query.setParameter("nid", nid);
            
            res = (ResponCtlescItr)query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public Collection<DirectorItr> getDirectorItr(){
		EntityManager em = getEm();
	     
		List<DirectorItr> res = null;
		
		try{
            Query query = em.createNamedQuery("DirectorItr.findAll");
            
            res = castList(DirectorItr.class,query.getResultList());
            
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public DirectorItr findDirectorITrById(int nid){
		EntityManager em = getEm();
	     
		DirectorItr res = null;
		
		try{
            Query query = em.createNamedQuery("DirectorItr.findById");
            query.setParameter("nid", nid);
            
            res = (DirectorItr)query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
		
		return res;
	}

	public InfoDdaAd14fj19Gp findAD14FJ19Debt(int almnId){
		EntityManager em = getEm();
	     
		InfoDdaAd14fj19Gp almnIdDebt = null;
		
		try{
			almnIdDebt = em.find(InfoDdaAd14fj19Gp.class, almnId);
        } catch (Exception ex) {
            throw ex;
        }
		
		return almnIdDebt;
	}	
}
