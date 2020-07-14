package itr.pdf.pdfbox;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import itr.utils.ITRUtils;

public class PDF_SuperClass {

	//public static final String			FIRMA_FILE 		= ".\\firma\\f_test00_trans.jpg";
	public static final float 			FIRMA_SCALE		= 0.30f;
	public static final float 			DGT_FIRMA_SCALE	= 0.19f;
	public static final float 			DGT_SELLO_SCALE	= 0.19f;
	public static final float 			ITR_SELLO_SCALE	= 0.08f;
	public static final float 			ITR_IMG_SCALE	= 0.50f;
	
	protected static final String PROP_FILE 	 			= ".\\prop\\pdf.cfg";
	protected static final String dgt_name_file 			= "dgt_hash.cfg";
	protected static final String dgt_sign_name_file 		= "dgt_sign_hash.cfg";
	protected static final String dgt_seal_name_file 		= "dgt_seal_hash.cfg";
	protected static final String dgt_name_path 			= ".\\prop\\".concat(dgt_name_file);
	protected static final String dgt_sign_path 			= ".\\prop\\".concat(dgt_sign_name_file);
	protected static final String dgt_seal_path 			= ".\\prop\\".concat(dgt_seal_name_file);
	protected static final String dgt_name_delimiter		= "_";
	protected static final String dgt_name_keyFormat		= "%2s";

	protected static final String DGETI_DOCS_DIR_PROP 		= "dgeti_docs_dir";
	protected static final String EVA_DIR_NAME_PROP   		= "eva_dir";
	protected static final String EVAF_DIR_NAME_PROP  		= "eva_final_dir";
	protected static final String HIST_DIR_NAME_PROP  		= "hist_dir";
	protected static final String HIST_GPO_DIR_NAME_PROP  	= "hist_gpo";
	protected static final String EXTRA_PEND_DIR_NAME_PROP  = "ext_pend_dir";
	protected static final String EXTRA_CALIF_DIR_NAME_PROP = "ext_calif_dir";
	protected static final String ESP_CASE_DIR_NAME_PROP  	= "esp_case_dir";
	protected static final String REDI_DIR_NAME_PROP  		= "redi_dir";
	protected static final String REXA_DIR_NAME_PROP  		= "rexa_dir";
	protected static final String REXA_COUNT_DIR_NAME_PROP  = "rexa_cnt_dir";
	protected static final String EXT_APROB_DIR_NAME_PROP  	= "aprob_dir";
	protected static final String ACTA_DIR_NAME_PROP  		= "pdf_acta_dir"; 
	protected static final String SIGN_FILE			  		= "sign_file";
	protected static final String LISTA_DIR_NAME_PROP 		= "lista_dir";
	protected static final String PROM_DIR_NAME_PROP 		= "prom_gpo";
	protected static final String PROM_STATS_DIR_NAME_PROP 	= "prom_gpo_stats";
	protected static final String FONTR_FILE_NAME_PROP 		= "pdf_font_file";
	protected static final String UAA_DIR_NAME_PROP 		= "uaa_dir";
	protected static final String ITR_UAA_IMG		  		= "itr_uaa_img";
	protected static final String DGETI_RESP_LIN1	  		= "pos_ln13";
	protected static final String DGETI_RESP_LIN2	  		= "pos_ln23";

	protected static final String DGETI_RESP_LIN3	  		= "pos_ln33";
	protected static final String DGETI_ROW00	  			= "row00";//arriba de dgeti
	protected static final String DGETI_ROW01	  			= "row01";//dgeti

	protected static final String DGT_SIGN_FILE			  	= "dgt_firma";
	protected static final String DGT_SEAL_FILE			  	= "dgt_sello";
	protected static final String ITR_SELLO_FILE			= "itr_sello";
	
	protected static final int DGT_NAME_DEFAULT				= 1; //UEMSTIS
	protected static final int DGT_SIGN_DEFAULT				= -1; //none
	protected static final int DGT_SEAL_DEFAULT				= -1; //none

	protected static final String DGETI_ROW03	  			= "row03";//roosevelt
	protected static final String DGETI_PCT		  			= "pct";  //leyenda cct
	
	protected float PAGE_MARGIN_SUPERIOR = 15;//5

	private float PAGE_HEADER_ROW_HEIGHT = 9;
	private int   PAGE_HEADER_FONT_SIZE  = 6;

	protected String dgeti_docs_dir;
	protected String dgeti_perx_dir;
	protected String pdf_dir;
	protected String sign_file;
	protected String dgt_sign_file;
	protected String dgt_seal_file;
	protected String itr_sello_file;
	protected String itr_uaa_img_file;
	protected String font_file;
	protected Properties prop;
	protected String posln13;
	protected String posln23;
	protected String posln33;
	
	protected Map<String, String> pdgt_nmap;
	protected Map<String, String> pdgt_sign_nmap;//mapa firmas
	protected Map<String, String> pdgt_seal_nmap;//mapa sellos
	protected int dgt_id;///id del nombre
	protected int dgt_sign_id;///id de la firma dgt
	protected int dgt_seal_id;///id del sello dgt
	protected String row00;
	protected String row01;
	protected String row03;
	protected String pct;

	protected int pdId;
	protected int pdIdHeader;//id del encabezado
	protected int pdIdDgtSign;//id de la firma de dgti
	protected int pdIdDgtSeal;//id del sello de dgti
	protected String coord;
	
	public PDF_SuperClass(int pdId) {
		super();
		this.pdId = pdId;
		prop = new Properties();
		try
		{
			prop.load(new FileInputStream(PROP_FILE));
			System.out.println("properties found");
		} catch (IOException io)
		{
			io.printStackTrace();
		}

		setPdIdHeader(pdId);//de entrada son iguales
		setPdIdDGTSign(pdId);
		setPdIdDGTSeal(pdId);
	}

	public PDF_SuperClass(String baseDir, String dgeti_perx_dir, int pdId)
	{
		this(baseDir, pdId);
		setDgeti_perx_dir(dgeti_perx_dir);
	}
	
	public PDF_SuperClass(String baseDir, int pdId) {
		this(pdId);
		
		setPdf_dir(prop.getProperty(baseDir).toString());
		setDgeti_docs_dir(prop.getProperty(DGETI_DOCS_DIR_PROP).toString());
		setSign_file(prop.getProperty(SIGN_FILE).toString());
		setItr_sello_file(prop.getProperty(ITR_SELLO_FILE).toString());
		setItr_uaa_img_file(prop.getProperty(ITR_UAA_IMG).toString());
		setFont_file(prop.getProperty(FONTR_FILE_NAME_PROP).toString());

		setRow03(prop.getProperty(DGETI_ROW03));
		setPct(prop.getProperty(DGETI_PCT));
		if(getRow00() == null){
			setRow00(ITR_PDFTableGenerator.ROW00);
		}
		if(getRow01() == null){
			setRow01(ITR_PDFTableGenerator.ROW01);
		}
		if(getRow03() == null){
			setRow03(ITR_PDFTableGenerator.ROW03);
		}
		if(getPct() == null){
			setPct(ITR_PDFTableGenerator.FIELD_04_PCT);
		}

		// 
		if(getPosln13() == null){
			setPosln13(prop.getProperty(DGETI_RESP_LIN1));
		}
		if(getPosln23() == null){
			setPosln23(prop.getProperty(DGETI_RESP_LIN2));
		}
	}

	protected void loadHash_dgt_file() {
		//nombre dgeti
		if(this.pdgt_nmap == null)
		{
			this.pdgt_nmap = new HashMap<String, String>();
			int rslt = ITRUtils.readHashFile(this.pdgt_nmap, dgt_name_path, hash_file_delimiter);
			if(rslt != 0)
			{
				//error en el archivo
				this.dgt_id = DGT_NAME_DEFAULT;
			} 
		}

		read_dgt_id(getPdIdHeader());
		System.out.println("==**==**==**==** using pdgt_name_id: " + this.dgt_id);
	}

	protected void loadHash_dgt_sign_file() {
		//firma dgeti
		if(this.pdgt_sign_nmap == null)
		{
			this.pdgt_sign_nmap = new HashMap<String, String>();
			int rslt = ITRUtils.readHashFile(this.pdgt_sign_nmap, dgt_sign_path, hash_file_delimiter);
			if(rslt != 0)
			{
				//error en el archivo
				this.dgt_sign_id = DGT_SIGN_DEFAULT;
			} 
		}

		read_dgt_sign_id(getPdIdDgtSign());
		System.out.println("==**==**==**==** using pdgt_sign_id: " + this.dgt_sign_id);
	}

	protected void loadHash_dgt_seal_file() {
		//firma dgeti
		if(this.pdgt_seal_nmap == null)
		{
			this.pdgt_seal_nmap = new HashMap<String, String>();
			int rslt = ITRUtils.readHashFile(this.pdgt_seal_nmap, dgt_seal_path, hash_file_delimiter);
			if(rslt != 0)
			{
				//error en el archivo
				this.dgt_seal_id = DGT_SEAL_DEFAULT;
			} 
		}

		read_dgt_seal_id(getPdIdDgtSeal());
		System.out.println("==**==**==**==** using pdgt_seal_id: " + this.dgt_sign_id);
	}

	private int read_dgt_id(int pdIdHeader) {
		// find pdgt_name
		int rslt = 0;

		String key = String.format(dgt_name_keyFormat, pdIdHeader).replace(' ', '0');
		String pdgt_name_id = pdgt_nmap.get(key);
		try{
			this.dgt_id = Integer.parseInt(pdgt_name_id);
		} catch(NumberFormatException e)
		{
			rslt = -1;
			this.dgt_id = DGT_NAME_DEFAULT;
			e.printStackTrace();
		}

		return rslt;
	}

	private int read_dgt_sign_id(int pdIdSign) {
		// find pdgt_sign
		int rslt = 0;

		String key = String.format(dgt_name_keyFormat, pdIdSign).replace(' ', '0');
		String pdgt_sign_id = pdgt_sign_nmap.get(key);
		try{
			this.dgt_sign_id = Integer.parseInt(pdgt_sign_id);
		} catch(NumberFormatException e)
		{
			rslt = -1;
			this.dgt_sign_id = DGT_SIGN_DEFAULT;
			e.printStackTrace();
		}

		return rslt;
	}

	private int read_dgt_seal_id(int pdIdSeal) {
		// find pdgt_sign
		int rslt = 0;

		String key = String.format(dgt_name_keyFormat, pdIdSeal).replace(' ', '0');
		String pdgt_seal_id = pdgt_seal_nmap.get(key);
		try{
			this.dgt_seal_id = Integer.parseInt(pdgt_seal_id);
		} catch(NumberFormatException e)
		{
			rslt = -1;
			this.dgt_seal_id = DGT_SEAL_DEFAULT;
			e.printStackTrace();
		}

		return rslt;
	}

	protected static final String hash_file_delimiter = ":";
	
	protected static StringBuffer gralDotPadding(float colWidth, final String dot,
			final float dotsize, float size) {
		float diff = colWidth - size;
		int no_dots = (int)(diff/dotsize);
		StringBuffer a = new StringBuffer();
		//for(float i = 0; i < diff; i+= dotsize)
		for(int i = 0; i < no_dots; i++)
		{
			a.append(dot);
		}
		a.trimToSize();
		return a;
	}

	protected void setPAGE_HEADER_ROW_HEIGHT(float pAGE_HEADER_ROW_HEIGHT) {
		this.PAGE_HEADER_ROW_HEIGHT = pAGE_HEADER_ROW_HEIGHT;
	}
	protected void setPAGE_HEADER_FONT_SIZE(int pAGE_HEADER_FONT_SIZE) {
		this.PAGE_HEADER_FONT_SIZE = pAGE_HEADER_FONT_SIZE;
	}
	public void setPAGE_MARGIN_SUPERIOR(float pAGE_MARGIN_SUPERIOR) {
		this.PAGE_MARGIN_SUPERIOR = pAGE_MARGIN_SUPERIOR;
	}

	public float getPageHeaderRowHeight() {
		return PAGE_HEADER_ROW_HEIGHT;
	}
	public  int getPageHeaderFontSize() {
		return PAGE_HEADER_FONT_SIZE;
	}
	public float getPageMarginSuperior() {
		return PAGE_MARGIN_SUPERIOR;
	}
	protected void setPdf_dir(String pdf_dir) {
		this.pdf_dir = pdf_dir;
	}
	public String getPdf_dir() {
		
		StringBuffer dir = new StringBuffer();
		dir.append(getDgeti_docs_dir());
		dir.append(getDgeti_perx_dir());
		dir.append(pdf_dir);

		return dir.toString();
		//orig return pdf_dir;
	}
	public String getSign_file() {
		return sign_file;
	}
	public void setSign_file(String sign_file) {
		this.sign_file = sign_file;
	}

	public String getDgt_sign_file() {
		return dgt_sign_file;
	}

	public void setDgt_sign_file(String dgt_sign_file) {
		this.dgt_sign_file = dgt_sign_file;
	}

	public String getDgt_seal_file() {
		return dgt_seal_file;
	}

	public void setDgt_seal_file(String dgt_seal_file) {
		this.dgt_seal_file = dgt_seal_file;
	}

	public String getItr_sello_file() {
		return itr_sello_file;
	}

	public void setItr_sello_file(String itr_sello_file) {
		this.itr_sello_file = itr_sello_file;
	}

	public String getItr_uaa_img_file() {
		return itr_uaa_img_file;
	}

	public void setItr_uaa_img_file(String itr_uaa_img_file) {
		this.itr_uaa_img_file = itr_uaa_img_file;
	}

	public String getFont_file() {
		return font_file;
	}

	public void setFont_file(String font_file) {
		this.font_file = font_file;
	}

	protected String getDgeti_docs_dir() {
		return dgeti_docs_dir;
	}
	protected void setDgeti_docs_dir(String dgeti_docs_dir) {
		this.dgeti_docs_dir = dgeti_docs_dir;
	}

	public String getDgeti_perx_dir() {
		return dgeti_perx_dir;
	}
	public void setDgeti_perx_dir(String dgeti_perx_dir) {
		this.dgeti_perx_dir = dgeti_perx_dir;
	}

	public int getPdId() {
		return pdId;
	}

	public void setPdId(int pdId) {
		this.pdId = pdId;
	}

	public int getPdIdHeader() {
		return pdIdHeader;
	}

	public int getPdIdDgtSign() {
		return pdIdDgtSign;
	}

	public int getPdIdDgtSeal() {
		return pdIdDgtSeal;
	}

	public String getCoord() {
		return coord;
	}

	public void setCoord(String coord) {
		this.coord = coord;
	}

	public void setPdIdHeader(int pdIdHeader) {

		this.pdIdHeader = pdIdHeader;

		loadHash_dgt_file();

		// cambios de nov en dgeti 09/feb/2018
		StringBuffer actualROW00 = new StringBuffer(DGETI_ROW00);
		actualROW00.append(dgt_name_delimiter);
		actualROW00.append(getDGT_ID());
		setRow00(prop.getProperty(actualROW00.toString()));

		StringBuffer actualROW01 = new StringBuffer(DGETI_ROW01);
		actualROW01.append(dgt_name_delimiter);
		actualROW01.append(getDGT_ID());
		setRow01(prop.getProperty(actualROW01.toString()));

		StringBuffer actPosln33 = new StringBuffer(DGETI_RESP_LIN3);
		actPosln33.append(dgt_name_delimiter);
		actPosln33.append(getDGT_ID());
		setPosln33(prop.getProperty(actPosln33.toString()));

	}

	public void setPdIdDGTSign(int pdId) {

		this.pdIdDgtSign = pdId;

		loadHash_dgt_sign_file();

		StringBuffer actualDgtSign = new StringBuffer(DGT_SIGN_FILE);
		actualDgtSign.append(dgt_name_delimiter);
		actualDgtSign.append(getDgt_sign_id());
		
		String filePath = prop.getProperty(actualDgtSign.toString());
		setDgt_sign_file(filePath);
		
		// cambios de nov en dgeti 09/feb/2018
		// StringBuffer actualDgtSign = new StringBuffer(DGT_SIGN_FILE);
		// actualDgtSign.append(dgt_name_delimiter);
		// actualDgtSign.append(getDgt_sign_id());
		// setRow00(prop.getProperty(actualDgtSign.toString()));
	}

	public void setPdIdDGTSeal(int pdId) {

		this.pdIdDgtSeal = pdId;

		loadHash_dgt_seal_file();

		StringBuffer actualDgtSeal = new StringBuffer(DGT_SEAL_FILE);
		actualDgtSeal.append(dgt_name_delimiter);
		actualDgtSeal.append(getDgt_seal_id());
		
		String filePath = prop.getProperty(actualDgtSeal.toString());
		setDgt_seal_file(filePath);
	}

	public String getPosln13() {
		return posln13;
	}

	public void setPosln13(String posln13) {
		this.posln13 = posln13;
	}

	public String getPosln23() {
		return posln23;
	}

	public void setPosln23(String posln23) {
		this.posln23 = posln23;
	}

	public String getPosln33() {
		return posln33;
	}

	public void setPosln33(String posln33) {
		this.posln33 = posln33;
	}

	public int getDGT_ID() {
		return dgt_id;
	}

	public int getDgt_sign_id() {
		return dgt_sign_id;
	}

	public int getDgt_seal_id() {
		return dgt_seal_id;
	}

	public String getRow00() {
		return row00;
	}

	public void setRow00(String row00) {
		this.row00 = row00;
	}

	public String getRow01() {
		return row01;
	}

	public void setRow01(String row01) {
		this.row01 = row01;
	}

	public String getRow03() {
		return row03;
	}

	public void setRow03(String row03) {
		this.row03 = row03;
	}

	public String getPct() {
		return pct;
	}

	public void setPct(String pct) {
		this.pct = pct;
	}
}
