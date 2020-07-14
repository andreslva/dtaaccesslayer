package itr.dev;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ITRDataSourceFebJun2015 {

	static final int GPO_ADM_IV = 1;
	static final int GPO_CFC_IV = 2;
	static final int GPO_IA_IV = 3;
	static final int GPO_PUE_IV = 4;
	static final int GPO_CFC_VI = 6;
	static final int GPO_IA_VI = 7;
	static final int GPO_PUE_VI = 8;
	static final int GPO_ADM_II = 12;
	static final int GPO_IA_II = 17;
	//static final int GPO_IA_II_A = 14;
	static final int GPO_PUE_II_A = 15;
	static final int GPO_PUE_II_B = 16;

	static final String GPO_ADM_II_LIT =   "ADM_II";
	static final String GPO_IA_II_LIT =  "IA_II";
	//static final String GPO_IA_II_A_LIT =  "IA_I_A";
	static final String GPO_PUE_II_A_LIT = "PUE_II_A";
	static final String GPO_PUE_II_B_LIT = "PUE_II_B";

	static final String GPO_ADM_IV_LIT =   "ADM_IV";
	static final String GPO_CFC_IV_LIT =  "CFC_IV";
	static final String GPO_IA_IV_LIT =  "IA_IV";
	static final String GPO_PUE_IV_LIT = "PUE_IV";
	static final String GPO_CFC_VI_LIT = "CFC_VI";
	static final String GPO_IA_VI_LIT = "IA_VI";
	static final String GPO_PUE_VI_LIT = "PUE_VI";

	public final static String CSV_COLUMNS_STRING_REGEX = ",|\\^|$";//OK

	//public final static String CSV_DATA_STRING_REGEX =
			//"((.+?),)|(\"(.+?)\")|(\\d+?,)|(\\d+?$)|(.+?$)"
			//"((.+?),)|(\"(.+?)\")|(\\d+?,)|(\\d+?$)" -- ver 02 ok se comia el ultimo # ...5,5
			// "(\"(.+?)\")|(\\d+?,)|(\\d+?$)" -- ver 01 OK
			// -- "\"(.*?)\"" -- ver 00 OK
			//;

	private Properties prop
	//,prop_extra
	;

	private String dbms;
	private String servername;
	private String portnumber;
	private String dbname;
	private String username;
	private String password;
	private String driver;
	private int pdId;

	//private String pdf_folder;
	//private String input_dir;
	//private boolean old_format;
	private String encoding;
	//private String scan_dir;

	//private String actas_eval_dir;

	private String eclipse_extras_dir;
	private String recibidas_extras_dir;

	private String curp_dgeti_sec_dir;

	public String getCurp_dgeti_sec_dir() {
		return curp_dgeti_sec_dir;
	}

	public String getEclipse_extras_dir() {
		return eclipse_extras_dir;
	}

	public String getRecibidas_extras_dir() {
		return recibidas_extras_dir;
	}

	/*public String getActas_eval_dir() {
		return actas_eval_dir;
	}*/

	/*public String getScan_dir() {
		return scan_dir;
	}

	public void setScan_dir(String scan_dir) {
		this.scan_dir = scan_dir;
	}*/

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/*public boolean isOld_format() {
		return old_format;
	}

	public void setOld_format(boolean old_format) {
		this.old_format = old_format;
	}

	public String getInput_dir() {
		return input_dir;
	}

	public void setInput_dir(String input_dir) {
		this.input_dir = input_dir;
	}*/

	public int getPdId() {
		return pdId;
	}

	public ITRDataSourceFebJun2015()
	{
		prop = new Properties();
		//prop_extra = new Properties();

		try
		{
			prop.load(new FileInputStream(
					//".\\prop\\mydb_feb_jun_2015.cfg"
					".\\prop\\mydb_ago_dic_2015.cfg"
					));
			//prop_extra.load(new FileInputStream(".\\prop\\extra.cfg"));

			System.out.println("properties found");

			dbms = prop.getProperty("dbms").toString();
			servername = prop.getProperty("serverName").toString();
			portnumber = prop.getProperty("portNumber").toString();
			dbname = prop.getProperty("dbName").toString();
			username = prop.getProperty("userName").toString();
			password = prop.getProperty("password").toString();
			driver = prop.getProperty("driver").toString();
			//pdf_folder = prop.getProperty("pdf_folder").toString();
			//input_dir = prop.getProperty("input_dir").toString();
			//old_format = Boolean.parseBoolean(prop.getProperty("oldformat").toString());
			encoding = prop.getProperty("encode").toString();
			//scan_dir = prop.getProperty("scan_dir").toString();

			//actas_eval_dir = prop.getProperty("actas_evaluacion_dir").toString(); 

			//eclipse_extras_dir = prop_extra.getProperty("eclipse_dir").toString();
			//recibidas_extras_dir = prop_extra.getProperty("recibidas_dir").toString();

			//curp_dgeti_sec_dir = prop.getProperty("curp_dir").toString();
			pdId = Integer.parseInt(prop.getProperty("pdId"));
		} catch (IOException io)
		{
			io.printStackTrace();
		}

	}

	/*
	public static final String dbms = "mariadb";
	public static final String serverName = "localhost";
	public static final String portNumber = "3406";
	public static final String dbName = "semestres_135_ago_dic_2014";

	public static final String userName = "root";
	public static final String password = "mariadb527";
	 */

	/*public String getPDF_folder() {
		return pdf_folder;
	}*/

	public static void main(String[] args) {
	}

	public static void executeSQL(Connection con, String sql) throws SQLException
	{

		Statement statement = null;

		try {
			statement = con.createStatement();
			boolean rs = statement.execute(sql);

			System.out.println("rs: "+ rs);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			if (statement != null) { statement.close(); }
		}
	}

	public static ResultSet executeQuerySQL(Connection con, String sql) throws SQLException
	{

		ResultSet rs = null;
		Statement statement = null;

		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sql);

			System.out.println("rs: " + rs);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (statement != null) { statement.close(); }
		}

		return rs;
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

}
