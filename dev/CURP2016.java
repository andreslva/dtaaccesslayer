package itr.dev;

import java.awt.print.PrinterException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.pdfbox.exceptions.COSVisitorException;

import itr.model.ViewAlumno;
import itr.model.ViewMaestro;
import itr.pdf.pdfbox.ITR_PDFTableGenerator;
import itr.pdf.pdfbox.Table;
import itr.utils.BirthDayComparatorDay;
import itr.utils.BirthDayComparatorDayMto;
import itr.utils.Cumpleano;
import itr.utils.ITRUtils;
import itr.utils.ViewAlumnoComparatorGpo;
import itr.utils.ViewAlumnoComparatorName;

public class CURP2016 {

	private static final String SELECT_CURP_ALUMNO = 
			"select " +
					" v.id " +
					",v.nombre " +
					",v.especialidad " +
					",v.semestre " +
					",v.grupo " +
					",v.grupo_id " +
					",v.grupo_literal " +
					",v.curp " +
					",v.Semestre_ID " +
					",v.Codigo " +
					"from " +
					"view_alumno v";

	private static final String COL_00_ID 		= "id";
	private static final String COL_01_NAME   	= "nombre";
	private static final String COL_02_ESP   	= "especialidad";
	private static final String COL_03_SEM   	= "semestre";
	private static final String COL_04_GPO   	= "grupo";
	private static final String COL_05_GPO_ID   = "grupo_id";
	private static final String COL_06_GPO_LIT  = "grupo_literal";
	private static final String COL_07_CURP   	= "curp";
	private static final String COL_08_SEM_ID   = "semestre_id";
	private static final String COL_09_COD   	= "codigo";

	private static final String SELECT_CURP_MTO =
			/*"select " +
					" v.ID " +
					",v.nombre " +
					",v.RFC " +
					",v.CURP " +
					",v.Email " +
					",v.Fecha_nacimiento " +
					",v.Fecha_Ingreso " +
					"from  " +
					"view_maestro v"*/
			"select " +
			" v.ID " +
			",v.nombre " +
			",v.RFC " +
			",v.CURP " +
			",v.Email " +
			",v.Fecha_nacimiento " +
			",v.Fecha_Ingreso " +
			"from  " +
			"view_personal v";

	private static final String MTO_00_ID 		= "id";
	private static final String MTO_01_NAME   	= "nombre";
	private static final String MTO_02_RFC   	= "RFC";
	private static final String MTO_03_CURP   	= "CURP";
	private static final String MTO_04_EMAIL  	= "Email";
	private static final String MTO_05_FECHNAC 	= "Fecha_nacimiento";;
	private static final String MTO_06_FECHING  = "Fecha_Ingreso";

	private static ArrayList<ViewMaestro> mto   = null;

	private static final String MES00_ENE = "ENERO";
	private static final String MES01_FEB = "FEBRERO";
	private static final String MES02_MAR = "MARZO";
	private static final String MES03_AVR = "ABRIL";
	private static final String MES04_MAI = "MAYO";
	private static final String MES05_JUN = "JUNIO";
	private static final String MES06_JUL = "JULIO";
	private static final String MES07_AGO = "AGOSTO";
	private static final String MES08_SEP = "SEPTIEMBRE";
	private static final String MES09_OCT = "OCTUBRE";
	private static final String MES10_NOV = "NOVIEMBRE";
	private static final String MES11_DIC = "DICIEMBRE";


	public static final String regex = 	
			"[A-Z]{1}[AEIOUX]{1}[A-Z]{2}([0-9]{2})" + 
					"(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" + 
					"[HM]{1}" + "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" + 
					"[B-DF-HJ-NP-TV-Z]{3}" + 
					"([0-9A-Z]{1})[0-9]{1}$"; 

	public static final int YEAR_GPO  = 1;
	public static final int MONTH_GPO = 2;
	public static final int DAY_GPO   = 3;
	public static final int ANO09AZ   = 5;

	private static ArrayList<ViewAlumno> _01jan   = null;
	private static ArrayList<ViewAlumno> _02fev   = null;
	private static ArrayList<ViewAlumno> _03mars  = null;
	private static ArrayList<ViewAlumno> _04avr   = null;
	private static ArrayList<ViewAlumno> _05mai   = null;
	private static ArrayList<ViewAlumno> _06juin  = null;
	private static ArrayList<ViewAlumno> _07juill = null;
	private static ArrayList<ViewAlumno> _08aout  = null;
	private static ArrayList<ViewAlumno> _09sept  = null;
	private static ArrayList<ViewAlumno> _10oct   = null;
	private static ArrayList<ViewAlumno> _11nov   = null;
	private static ArrayList<ViewAlumno> _12dec   = null;

	private static int month = -1;

	private static String mes;

	public static final String ALUM_BD 		= "alums";
	public static final String MTOS_BD 		= "mtos";
	public static final String CURPS_CHECK 	= "check";

	private static ITRDataSourceFebJun2016 ds;

	public static ITRDataSourceFebJun2016 getDs() {
		return ds;
	}

	public static void setDs(ITRDataSourceFebJun2016 ds) {
		CURP2016.ds = ds;
	}

	public static void main(String args[])
	{
		String per = args[0];

		if( args.length > 1 )
		{
			ds = new ITRDataSourceFebJun2016(per);
			setDs(ds);
			
			if(args[1].equalsIgnoreCase(MTOS_BD))
			{
				if( args.length > 2 )
				{
					month = Integer.parseInt(args[2]);
				} else
				{
					System.out.println("n < 0 current");
					System.out.println("00 enero");
					System.out.println("11 diciembre");
					try {
						month = ITRUtils.scanInt("enter month: ");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				printBDMTOS();				
			}
			else if (args[1].equalsIgnoreCase(ALUM_BD))
			{
				if( args.length > 2 )
				{
					month = Integer.parseInt(args[2]);
				} else
				{
					System.out.println("n < 0 current");
					System.out.println("00 enero");
					System.out.println("11 diciembre");
					try {
						month = ITRUtils.scanInt("enter month: ");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				printBDAlumnos();
			}
			else if (args[1].equalsIgnoreCase(CURPS_CHECK))
			{
				//ITRDataSourceFebJun2016 ds2016 = new ITRDataSourceFebJun2016();
				//checkCurps(ds2016);
				checkCurps(ds);
			}
		}
		else
		{
			ds = new ITRDataSourceFebJun2016();
			setDs(ds);

			printBDAlumnos();
		}

		int x = 0;
	}

	private static void printBDAlumnos() {
		ArrayList<ViewAlumno> alumnos = getCurerntMonthCurps();

		ArrayList<Cumpleano> lista = getBD(alumnos);

		if(lista == null)
		{
			System.out.println("no hay cumplea;os de alumnos!!");
			return;
		}

		String[][] bds = new String[lista.size()][3];

		Iterator<Cumpleano> i = lista.iterator();
		Cumpleano s = null;
		int count = 0;
		while(i.hasNext())
		{
			s = i.next();

			bds[count][0] = s.getDia();
			bds[count][1] = s.getGpo();
			bds[count][2] = s.getN();

			System.out.print(s);
			count++;
		}

		Table t = PDF_Cumpleanos.createContent(bds,mes,"ALUMNOS");
		//String fileDir = ds.getPDF_folder();
		String fileName  = //fileDir.concat("cumpleaños_alumnos_"+mes+"_v07.pdf")
				"cumpleaños_alumnos_"+mes+"_v07.pdf"
				;

		ITR_PDFTableGenerator pdfGen = new ITR_PDFTableGenerator();
		PDF_BD pdf = new PDF_BD(ds.getPdId());

		try {
			pdfGen.setPdf(pdf);
			pdfGen.generatePDF(t,fileName);
		} catch (COSVisitorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void printBDMTOS() 
	{
		getCurerntMonthCurpsMtos();

		ArrayList<Cumpleano> lista = getBDMTO(mto);

		if(lista == null)
		{
			System.out.println("NO hya cumpleanos de mtos!!!");
			return;
		}

		String[][] bds = new String[lista.size()][3];

		Iterator<Cumpleano> i = lista.iterator();
		Cumpleano s = null;
		int count = 0;
		while(i.hasNext())
		{
			s = i.next();

			bds[count][0] = s.getDia();
			bds[count][1] = s.getGpo();
			bds[count][2] = s.getN();

			System.out.print(s);
			count++;
		}

		Table t = PDF_Cumpleanos.createContent(bds,mes,"MAESTROS");
		//String fileDir = ds.getPDF_folder();
		String fileName  = //fileDir.concat("cumpleaños_mtos_"+mes+"_v01.pdf")
				"cumpleaños_mtos_"+mes+"_v01.pdf"
				;

		ITR_PDFTableGenerator pdfGen = new ITR_PDFTableGenerator();
		PDF_BD pdf = new PDF_BD(ds.getPdId());

		try {
			pdfGen.setPdf(pdf);
			pdfGen.generatePDF(t,fileName);		
		} catch (COSVisitorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ArrayList<ViewAlumno> getCurerntMonthCurps()
	{
		if(month == -1)
		{
			GregorianCalendar today = new GregorianCalendar();
			month = today.get(GregorianCalendar.MONTH);
		}
		return getCurerntMonthCurps(month);
	}

	private static ArrayList<ViewAlumno> getCurerntMonthCurps(int currMonth)
	{
		ArrayList<ViewAlumno> result = null;

		Connection conn = null;

		_01jan = new ArrayList<ViewAlumno>();
		_02fev = new ArrayList<ViewAlumno>();
		_03mars = new ArrayList<ViewAlumno>();
		_04avr = new ArrayList<ViewAlumno>();
		_05mai = new ArrayList<ViewAlumno>();
		_06juin = new ArrayList<ViewAlumno>();
		_07juill = new ArrayList<ViewAlumno>();
		_08aout = new ArrayList<ViewAlumno>();
		_09sept = new ArrayList<ViewAlumno>();
		_10oct = new ArrayList<ViewAlumno>();
		_11nov = new ArrayList<ViewAlumno>();
		_12dec = new ArrayList<ViewAlumno>();

		/*GregorianCalendar today = new GregorianCalendar();
		int currMonth = today.get(GregorianCalendar.MONTH);*/

		try
		{
			conn = getDs().getConnection();

			HashMap<Integer, ViewAlumno> va = selectViewAlumnos(conn);

			Iterator<ViewAlumno> it = va.values().iterator();
			ViewAlumno v = null;
			String curp = null;
			GregorianCalendar g = null;

			while(it.hasNext())
			{
				v = it.next();
				curp = v.getCurp();
				if(curp != null)
				{
					if(!ITRUtils.validarCURP(curp))
					{
						continue;
					}

					g = ITRUtils.getBirthDay(curp);

					addtoArray(v, g);
				}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		finally {

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		result = getCurrArray(currMonth);

		return result;
	}

	private static void checkCurps(ITRDataSourceFebJun2016 ds)
	{
		Connection conn = null;

		try
		{
			conn = getDs().getConnection();

			HashMap<Integer, ViewAlumno> va = selectViewAlumnos(conn);

			Iterator<ViewAlumno> it = va.values().iterator();
			ViewAlumno v = null;
			String curp = null;
			GregorianCalendar g = null;

			while(it.hasNext())
			{
				v = it.next();
				curp = v.getCurp();
				if(curp != null)
				{
					System.out.println("id: "+ v.getId());
					System.out.println("nombre: "+ v.getNombre());
					System.out.println("curp: "+ curp);
					if(!ITRUtils.validarCURP(curp))
					{
						System.out.println("OK");
						continue;
					}

					g = ITRUtils.getBirthDay(curp);
				}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		finally {

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void /*ArrayList<ViewMaestro>*/ getCurerntMonthCurpsMtos()
	{
		Connection conn = null;

		mto = new ArrayList<ViewMaestro>();

		/*GregorianCalendar today = new GregorianCalendar();
		int currMonth = today.get(GregorianCalendar.MONTH);*/

		try
		{
			conn = getDs().getConnection();

			HashMap<Integer, ViewMaestro> va = selectViewMaestros(conn);

			Iterator<ViewMaestro> it = va.values().iterator();
			ViewMaestro v = null;
			String curp = null;

			while(it.hasNext())
			{
				v = it.next();
				curp = v.getCurp();
				if(curp != null)
				{
					if(!ITRUtils.validarCURP(curp))
					{
						continue;
					}

					if(v.getId() == 18)
					{
						continue;
					}

					addtoArrayMto(v);
				}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		finally {

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static ArrayList<Cumpleano> getBD(ArrayList<ViewAlumno> alumnos)
	{
		ArrayList<Cumpleano> bd = null;

		/*alumnos.sort(new ViewAlumnoComparatorName());
		  alumnos.sort(new ViewAlumnoComparatorGpo());
		  alumnos.sort(new BirthDayComparatorDay());*/
		Collections.sort(alumnos, compose(new BirthDayComparatorDay(), new ViewAlumnoComparatorGpo(), new ViewAlumnoComparatorName()));

		Iterator<ViewAlumno> it = alumnos.iterator();
		ViewAlumno a = null;
		GregorianCalendar g = null;

		String name = null;
		String curp = null;
		String gpolit  = null;
		//month = -1;
		String day = null;
		mes = null;

		Cumpleano c  = null;

		while(it.hasNext())
		{
			if(bd == null)
			{
				bd = new ArrayList<Cumpleano>(10);
			}

			a = it.next();
			name = a.getNombre();
			curp = a.getCurp();
			gpolit  = a.getGrupoLiteral();

			g = ITRUtils.getBirthDay(curp);

			//if(month == -1)
			//{
			int	month = g.get(GregorianCalendar.MONTH);
			//}
			mes = getCurrMonthStr(month);

			day = String.format("%02d", g.get(GregorianCalendar.DAY_OF_MONTH));

			c = new Cumpleano(day, gpolit, name);

			bd.add(c/*s.toString()*/);
		}

		if(bd != null)
		{
			bd.trimToSize();
		}

		return bd;
	}

	public static <T> Comparator<T> compose(
			final Comparator<? super T> primary, 
			final Comparator<? super T> secondary,
			final Comparator<? super T> tertiary) 
	{
		return new Comparator<T>() 
		{
			public int compare(T a, T b) 
			{
				int result = 0;

				/*
				 *  int result = primary.compare(a, b);
				 *	return result==0 ? secondary.compare(a, b) : result;
				 */
				result = primary.compare(a,b);
				if(result == 0)
				{
					result = secondary.compare(a,b);
					result = result==0 ? tertiary.compare(a, b) : result;
				}

				return result;
			}
		};
	}

	private static ArrayList<Cumpleano> getBDMTO(ArrayList<ViewMaestro> mtos)
	{
		ArrayList<Cumpleano> bd = null;

		mtos.sort(new BirthDayComparatorDayMto());

		Iterator<ViewMaestro> it = mtos.iterator();
		ViewMaestro a = null;
		GregorianCalendar g = null;

		String name = null;
		String curp = null;
		String gpolit  = "MAESTROS";
		//month = -1;
		String day = null;
		mes = null;

		Cumpleano c  = null;

		while(it.hasNext())
		{
			if(bd == null)
			{
				bd = new ArrayList<Cumpleano>(10);
			}

			a = it.next();
			name = a.getNombre();
			curp = a.getCurp();

			g = ITRUtils.getBirthDay(curp);

			//if(month == -1)
			//{
			int	month = g.get(GregorianCalendar.MONTH);
			//}
			mes = getCurrMonthStr(month);

			day = String.format("%02d", g.get(GregorianCalendar.DAY_OF_MONTH));

			c = new Cumpleano(day, gpolit, name);

			bd.add(c/*s.toString()*/);
		}
		if(bd != null)
		{
			bd.trimToSize();
		}

		return bd;
	}

	private static HashMap<Integer, ViewAlumno> selectViewAlumnos(Connection conn) {

		HashMap<Integer, ViewAlumno> curps = null;

		try {

			PreparedStatement statement = conn.prepareStatement(SELECT_CURP_ALUMNO);

			try {
				ResultSet rs = statement.executeQuery();

				try {

					//int cont = 0;
					int id = -1;
					ViewAlumno a = null;

					while (rs.next()) {

						if(curps == null)
						{
							curps = new HashMap<Integer, ViewAlumno>(15);
						}

						a = new ViewAlumno();

						id = rs.getInt(COL_00_ID);

						a.setId(id);
						a.setNombre(rs.getString(COL_01_NAME));
						a.setEspecialidad(rs.getString(COL_02_ESP));
						a.setSemestre(rs.getString(COL_03_SEM));
						a.setGrupo(rs.getString(COL_04_GPO));
						a.setGrupoId(rs.getInt(COL_05_GPO_ID));
						a.setGrupoLiteral(rs.getString(COL_06_GPO_LIT));
						a.setCurp(rs.getString(COL_07_CURP));
						a.setSemestre_ID(rs.getInt(COL_08_SEM_ID));
						a.setCodigo(rs.getString(COL_09_COD));

						curps.put(new Integer(id),a);

						//cont++;
					}

					// Do stuff with the result set.
				} finally {
					rs.close();
				}
			} finally {
				statement.close();
			}
		}catch (SQLException io)
		{
			io.printStackTrace();

		}

		return curps;
	}

	private static HashMap<Integer, ViewMaestro> selectViewMaestros(Connection conn) {

		HashMap<Integer, ViewMaestro> curps = null;

		try {

			PreparedStatement statement = conn.prepareStatement(SELECT_CURP_MTO);

			try {
				ResultSet rs = statement.executeQuery();

				try {

					//int cont = 0;
					int id = -1;
					ViewMaestro a = null;

					while (rs.next()) {

						if(curps == null)
						{
							curps = new HashMap<Integer, ViewMaestro>(15);
						}

						a = new ViewMaestro();

						id = rs.getInt(MTO_00_ID);

						a.setId(id);
						a.setNombre(rs.getString(MTO_01_NAME));
						a.setRfc(rs.getString(MTO_02_RFC));
						a.setCurp(rs.getString(MTO_03_CURP));
						a.setEmail(rs.getString(MTO_04_EMAIL));
						a.setFecha_nacimiento(rs.getDate(MTO_05_FECHNAC));
						a.setFecha_Ingreso(rs.getDate(MTO_06_FECHING));

						curps.put(new Integer(id),a);

						//cont++;
					}

					// Do stuff with the result set.
				} finally {
					rs.close();
				}
			} finally {
				statement.close();
			}
		}catch (SQLException io)
		{
			io.printStackTrace();

		}

		return curps;
	}

	private static 	ArrayList<ViewAlumno> getCurrArray(	/*ArrayList<ViewAlumno> result,*/ int currMonth) 
	{
		ArrayList<ViewAlumno> result = null;

		switch (currMonth) {
		case GregorianCalendar.JANUARY:
			result = _01jan;
			break;
		case GregorianCalendar.FEBRUARY:
			result = _02fev;
			break;
		case GregorianCalendar.MARCH:
			result = _03mars;
			break;
		case GregorianCalendar.APRIL:
			result = _04avr;
			break;
		case GregorianCalendar.MAY:
			result = _05mai;
			break;
		case GregorianCalendar.JUNE:
			result = _06juin;
			break;
		case GregorianCalendar.JULY:
			result = _07juill;
			break;
		case GregorianCalendar.AUGUST:
			result = _08aout;
			break;
		case GregorianCalendar.SEPTEMBER:
			result = _09sept;
			break;
		case GregorianCalendar.OCTOBER:
			result = _10oct;
			break;
		case GregorianCalendar.NOVEMBER:
			result = _11nov;
			break;
		case GregorianCalendar.DECEMBER:
			result = _12dec;
			break;
		default:
			break;
		}

		return result;
	}


	private static void addtoArray(ViewAlumno v, GregorianCalendar g) {
		switch (g.get(GregorianCalendar.MONTH)) {
		case GregorianCalendar.JANUARY:
			_01jan.add(v);
			break;
		case GregorianCalendar.FEBRUARY:
			_02fev.add(v);
			break;
		case GregorianCalendar.MARCH:
			_03mars.add(v);
			break;
		case GregorianCalendar.APRIL:
			_04avr.add(v);
			break;
		case GregorianCalendar.MAY:
			_05mai.add(v);
			break;
		case GregorianCalendar.JUNE:
			_06juin.add(v);
			break;
		case GregorianCalendar.JULY:
			_07juill.add(v);
			break;
		case GregorianCalendar.AUGUST:
			_08aout.add(v);
			break;
		case GregorianCalendar.SEPTEMBER:
			_09sept.add(v);
			break;
		case GregorianCalendar.OCTOBER:
			_10oct.add(v);
			break;
		case GregorianCalendar.NOVEMBER:
			_11nov.add(v);
			break;
		case GregorianCalendar.DECEMBER:
			_12dec.add(v);
			break;
		default:
			break;
		}
	}

	private static void addtoArrayMto(ViewMaestro v)
	{ 
		if(month == -1)
		{
			GregorianCalendar today = new GregorianCalendar();
			month = today.get(GregorianCalendar.MONTH);
		}
		addtoArrayMto(v, month);
	}

	private static void addtoArrayMto(ViewMaestro v, int currMonth)
	{ 
		GregorianCalendar g = null;
		g = ITRUtils.getBirthDay(v.getCurp());
		int month = g.get(GregorianCalendar.MONTH);

		/*GregorianCalendar today = new GregorianCalendar();
		int currMonth = today.get(GregorianCalendar.MONTH);*/

		if ( month == currMonth )
		{
			mto.add(v);
		}
	}

	private static String getCurrMonthStr(int month) {
		String mes = "N/A";
		switch (month) {
		case GregorianCalendar.JANUARY:
			mes = MES00_ENE;
			break;
		case GregorianCalendar.FEBRUARY:
			mes = MES01_FEB;
			break;
		case GregorianCalendar.MARCH:
			mes = MES02_MAR;
			break;
		case GregorianCalendar.APRIL:
			mes = MES03_AVR;
			break;
		case GregorianCalendar.MAY:
			mes = MES04_MAI;
			break;
		case GregorianCalendar.JUNE:
			mes = MES05_JUN;
			break;
		case GregorianCalendar.JULY:
			mes = MES06_JUL;
			break;
		case GregorianCalendar.AUGUST:
			mes = MES07_AGO;
			break;
		case GregorianCalendar.SEPTEMBER:
			mes = MES08_SEP;
			break;
		case GregorianCalendar.OCTOBER:
			mes = MES09_OCT;
			break;
		case GregorianCalendar.NOVEMBER:
			mes = MES10_NOV;
			break;
		case GregorianCalendar.DECEMBER:
			mes = MES11_DIC;
			break;
		default:
			break;
		}

		return mes;
	}

}

class ITRDataSourceFebJun2016
{
	private Properties prop;
	private String dbms;
	private String servername;
	private String portnumber;
	private String dbname;
	private String username;
	private String password;
	private String driver;
	private String encoding;
	private int pdId;

	public ITRDataSourceFebJun2016()
	{
		this("mydb_feb_jun_2016");
	}
	
	public ITRDataSourceFebJun2016(String cfgFile)
	{
		StringBuffer fileName = new StringBuffer();
		fileName.append(".\\prop\\");
		fileName.append(cfgFile);
		fileName.append(".cfg");

		prop = new Properties();
		try
		{
			//prop.load(new FileInputStream(".\\prop\\mydb_feb_jun_2016.cfg"));
			prop.load(new FileInputStream(fileName.toString()));
			
			System.out.println("properties found");

			dbms = prop.getProperty("dbms").toString();
			servername = prop.getProperty("serverName").toString();
			portnumber = prop.getProperty("portNumber").toString();
			dbname = prop.getProperty("dbName").toString();
			username = prop.getProperty("userName").toString();
			password = prop.getProperty("password").toString();
			driver = prop.getProperty("driver").toString();
			encoding = prop.getProperty("encode").toString();
			pdId = Integer.parseInt(prop.getProperty("pdId"));
		} catch (IOException io)
		{
			io.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {

		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user",username);
		connectionProps.put("password",password);

		try 
		{

			if (dbms.equals("mysql")) {
				conn = DriverManager.getConnection(
						"jdbc:" + dbms + "://" +
								servername +
								":" + portnumber + "/",
								connectionProps);
			} else if (dbms.equals("derby")) {
				conn = DriverManager.getConnection(
						"jdbc:" + dbms + ":" +
								dbname +
								";create=true",
								connectionProps);
			} else if (dbms.equals("mariadb")) {

				Class.forName(driver);
				//System.out.println("--------------------------");
				//System.out.println("DRIVER: " + driver);

				String url = 
						"jdbc:" + dbms + "://" 
								+ servername 
								+ ":" 
								+ portnumber 
								+ "/"
								+ dbname;

				//System.out.println("url: " + url);

				conn = DriverManager.getConnection(url,
						connectionProps);
			}

		}  catch (ClassNotFoundException ex) {
			Logger.getLogger(ITRDataSourceFebJun2015.class.getName()).log(Level.SEVERE, null, ex);
		} /*catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		//System.out.println("Connected to database");
		return conn;
	}
	
	public int getPdId() {
		return pdId;
	}
}