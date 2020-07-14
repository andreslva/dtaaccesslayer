package itr.pdf.pdfbox;


import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.print.PrintService;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDCcitt;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;

public class ITR_PDFTableGenerator {

	protected static final boolean 	DEBUG 		 = false;
	protected static final String 	ROW00 		 = "SEP SUBSECRETARIA DE EDUCACIÓN PÚBLICA E INVESTIGACIÓN TECNOLÓGICAS";
	protected static final String 	ROW01 		 = "DIRECCIÓN GENERAL DE EDUCACIÓN TECNOLÓGICA INDUSTRIAL";
	protected static final String 	ROW03 		 = "BACHILLERATO TECNOLÓGICO DEL INSTITUTO TECNOLÓGICO ROOSEVELT, PLANTEL AGUASCALIENTES";
	protected static final String 	FIELD_04_PCT = "CLAVE : 01PCT0004H";

	protected static final float headerLineWidth  = 0.5f;
	protected static final float underLineWidth   = 0.3f;
	protected static final float underlineYoffset = 1.5f;//0.9f

	//private static final int   col_clv_gen_per   		= 100;
	//private static final float col_clv_gen_per_ini 		= 507f;
	//private static final float col_clv_gen_per_width 	=  78f;// 612

	private static final String PDFSUFFIX = ".pdf";

	protected static final int line_15 = 1;
	protected static final int line_25 = 2;
	protected static final int line_35 = 3;
	protected static final int line_45 = 4;
	protected static final int line_55 = 5;
	protected static final int line_65 = 6;
	protected static final int line_75 = 7;
	protected static final int line_85 = 8;
	protected static final int line_95 = 9;
	protected static final int line_10 = 10;
	protected static final int line_11 = 11;
	protected static final int line_12 = 12;
	
	protected static final float EMPTY_GPOTNOFOL_SEP = 15;
	
	private static final float POINTS_PER_INCH = 72;
	private static final float MM_PER_INCH = 1 / (10 * 2.54f) * POINTS_PER_INCH;
	/** A rectangle the size of U.S. Letter, 8.5" x 11". */
	public static final PDRectangle LETTER = new PDRectangle(8.5f * POINTS_PER_INCH,
			11f *POINTS_PER_INCH);
	/**  A rectangle the size of U.S. Legal, 8.5" x 14". */
	public static final PDRectangle LEGAL = new PDRectangle(8.5f * POINTS_PER_INCH,
			14f * POINTS_PER_INCH);

	/**  A rectangle the size of FOLIO, 8.5" x 13". */
	public static final PDRectangle FOLIO = new PDRectangle(8.5f * POINTS_PER_INCH,
			13.374f * POINTS_PER_INCH);
	/**  A rectangle the size of A0 Paper. */
	public static final PDRectangle A0 = new PDRectangle(841 * MM_PER_INCH, 1189 * MM_PER_INCH);
	/** A rectangle the size of A1 Paper. */
	public static final PDRectangle A1 = new PDRectangle(594 * MM_PER_INCH, 841 * MM_PER_INCH);
	/**  A rectangle the size of A2 Paper. */
	public static final PDRectangle A2 = new PDRectangle(420 * MM_PER_INCH, 594 * MM_PER_INCH);
	/** A rectangle the size of A3 Paper.  */
	public static final PDRectangle A3 = new PDRectangle(297 * MM_PER_INCH, 420 * MM_PER_INCH);
	/**  A rectangle the size of A4 Paper. */
	public static final PDRectangle A4 = new PDRectangle(210 * MM_PER_INCH, 297 * MM_PER_INCH);
	/** A rectangle the size of A5 Paper. */
	public static final PDRectangle A5 = new PDRectangle(148 * MM_PER_INCH, 210 * MM_PER_INCH);
	/**  A rectangle the size of A6 Paper. */
	public static final PDRectangle A6 = new PDRectangle(105 * MM_PER_INCH, 148 * MM_PER_INCH);

	protected static int wpos = 0;
	protected static int offpos = 1;

	private int legendsNoLinesField;
	private int footerNoLinesField;
	
	/*private static float[] getCol_CLV_GEN_PER()
	{
		float [] res = new float[2];
		
		float width 	= col_clv_gen_per_width;
		float xOffset 	= col_clv_gen_per_ini;
		
		res[wpos] = width;
		res[offpos] = xOffset;
		
		return res;
	}*/

	protected void printHeaderLastColLine(int n, String s)
			throws IOException {

		float xOffset = getPrintbleLineSize();
		xOffset += getMargin();
		xOffset -= getHeaderStringSize(FIELD_04_PCT);

		if( DEBUG )
		{
			float y = (	this.getPdf().getPageHeaderRowHeight() * n );
			contentStream.drawLine(xOffset, getPageHeight()-y , xOffset + getHeaderStringSize(s), getPageHeight()-y);
		}
		
		PDFont font = getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.getPdf().getPageHeaderFontSize() );
		contentStream.moveTextPositionByAmount(
				xOffset,
				getPageHeight() 
				- (	this.getPdf().getPageHeaderRowHeight() * n )
				- this.getPdf().getPageMarginSuperior()
				);
		contentStream.drawString( s );
		contentStream.endText();
	}
	
	/*protected void printHeaderLastColLine2(int n, String s) //original
			throws IOException {

		float wx[] = getCol_CLV_GEN_PER();
		
		float width   = wx[wpos];
		float xOffset = wx[offpos];

		if( DEBUG )
		{
			float y = (	this.getPdf().getPageHeaderRowHeight() * n );
			contentStream.drawLine(xOffset, getPageHeight()-y , xOffset + width, getPageHeight()-y);
		}
		
		PDFont font = getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.getPdf().getPageHeaderFontSize() );
		contentStream.moveTextPositionByAmount(
				xOffset,
				getPageHeight() 
				- (	this.getPdf().getPageHeaderRowHeight() * n )
				- this.getPdf().getPageMarginSuperior()
				);
		contentStream.drawString( s );
		contentStream.endText();
	}*/

	protected static void createDirectoryIfNeeded(String directoryName, boolean printDirectly) 
	{
		if(printDirectly)
		{	
			return;
		}
		
		createDirectoryIfNeeded(directoryName);
		/*if( (directoryName == null) || (directoryName.isEmpty()) )
		{
			return;
		}

		File theDir = new File(directoryName);

		// if the directory does not exist, create it
		if (!theDir.exists())
		{
			System.out.println("creating directory: " + directoryName);
			theDir.mkdir();
		}*/
	}

	protected static boolean createPerDirIfNeeded(PDF_SuperClass pdf)
	{
		StringBuffer dir = new StringBuffer();
		dir.append(pdf.getDgeti_docs_dir());
		dir.append(pdf.getDgeti_perx_dir());

		return createDirectoryIfNeeded(dir.toString());
	}
	
	protected static boolean createDirectoryIfNeeded(String directoryName) 
	{
		boolean res = false;
		if( (directoryName == null) || (directoryName.isEmpty()) )
		{
			return false;
		}

		File theDir = new File(directoryName);

		// if the directory does not exist, create it
		if (!theDir.exists())
		{
			System.out.println("creating directory: " + directoryName);
			res =theDir.mkdir();
		}
		return res;
	}

	protected static float getXOffset(float availSpace, float clvStrSize) {
		availSpace -= clvStrSize;
		if(availSpace < 0)
		{
			availSpace = 0;
		}else
		{
			availSpace /= 2f;
		}
		return availSpace;
	}
	
	private static String equalsLine = null;

	protected PDDocument doc;
	protected PDPage page;
	protected PDPageContentStream contentStream;
	protected Table table;

	protected PDF_SuperClass pdf = null;

	private PDXObjectImage ximageFirma;
	private PDXObjectImage ximageDGTFirma;
	private PDXObjectImage ximageDGTSello;
	private PDXObjectImage ximageITR;
	private PDXObjectImage ximageITRSello;
	protected boolean useImageFirma;
	private float height;
	private float width;
	
	private boolean printDirectly;
	private boolean printSilently;
	
	protected float legendsSize   = 0;
	protected int	noLegendLines = 0;
	protected float footerSize    = 0;

	public ITR_PDFTableGenerator() {
	}

	// Generates document from Table object
	/*public void generatePDF(Table t) throws IOException, COSVisitorException {
		table = t;
		this.doc = new PDDocument();
		try {
			drawTable(doc);
			doc.save("sample.pdf");
		} finally {
			if (doc != null) {
				doc.close();
			}
		}
	}*/

	/*public void generatePDF(Table t, String file) throws IOException, COSVisitorException {
		table = t;
		this.doc = new PDDocument();
		try {
			drawTable(doc);
			doc.save(file);
		} finally {
			if (doc != null) {
				doc.close();
			}
		}
	}*/
	public void generatePDF(Table t, String fileName) throws IOException, COSVisitorException, PrinterException 
	{
		table = t;

		generatePDF(fileName);
		/*StringBuffer pdfFile = buildFileName(fileName);

		this.doc = new PDDocument();
		try {
			drawTable(doc);
			doc.save(pdfFile.toString());
		} finally {
			if (doc != null) {
				doc.close();
			}
		}*/
	}

	public String generatePDF(String fileName) throws IOException, COSVisitorException, PrinterException 
	{
		StringBuffer pdfFile = buildFileName(fileName);

		this.doc = new PDDocument();
		try {
			drawTable(doc);
			if(isPrintDirectly())
			{	
				if(isPrintSilently())
				{
					this.doc.silentPrint();
				}
				else
				{
					printPDF(choosePrinter());
				}
			}
			else
			{
				doc.save(pdfFile.toString());
			}
		} finally {
			if (doc != null) {
				doc.close();
			}
		}
		return pdfFile.toString();
	}

	public boolean deletePDF(String fileName) throws IOException, COSVisitorException, PrinterException 
	{
		StringBuffer pdfFile = buildFileName(fileName);
		File deleteFile = new File(pdfFile.toString());
		
		boolean deleted = false;
		if(deleteFile.exists())
		{
			try{
				deleted = deleteFile.delete();
			} catch(SecurityException e)
			{
				System.out.println("Cant delete file: " + deleteFile.getAbsolutePath());
			}
		}
		return deleted;
	}

	protected StringBuffer buildFileName(String fileName) {
		StringBuffer pdfFile = new StringBuffer(0);

		if(getBaseDir() != null)
		{
			pdfFile.append(getBaseDir());
		}

		if(getFolderName() != null)
		{
			pdfFile.append(getFolderName());
			pdfFile.append("\\");
		}

		//createDirectoryIfNeeded(pdfFile.toString(), isPrintDirectly());
		if(!printDirectly)
		{	
			createDirectoryIfNeeded(pdfFile.toString());
		}

		pdfFile.append(fileName);
		if(!fileName.endsWith(PDFSUFFIX))
		{
			pdfFile.append(PDFSUFFIX);
		}
		return pdfFile;
	}

	protected static final int FIRST_PAGE_INDEX = 0;
	
	// Configures basic setup for the table and draws it page by page
	public void drawTable(PDDocument doc/*-jlv-, Table table*/) throws IOException {
		// Calculate pagination
		int totalNoLines = new Double(Math.floor(table.getHeight() / table.getRowHeight())).intValue() - 1; // subtract
		int rowsPerPage_int = totalNoLines; 
		//header
		int headerNoLines = new Double(Math.floor(getHeaderHeight() / table.getRowHeight())).intValue(); //header
		rowsPerPage_int -= headerNoLines;

		//if legends;
		//orig: int lengendsNoLines = new Double(Math.floor(calculateLegendsHeight()/ table.getRowHeight())).intValue();
		        int lengendsNoLines = new Double(Math.floor(/*getLegendsSize() bad timing is set after */calculateLegendsHeight()/ getPdf().getPageHeaderRowHeight())).intValue();
		rowsPerPage_int -= lengendsNoLines;
		setLegendsNoLinesField(lengendsNoLines);

		//if footer
		//orig: int footerNoLines = new Double(Math.floor(calculateFooterHeight() / table.getRowHeight())).intValue(); 
		        int footerNoLines = new Double(Math.floor(calculateFooterHeight() / getPdf().getPageHeaderRowHeight())).intValue();
		rowsPerPage_int -= footerNoLines;
		setFooterNoLinesField(footerNoLines);

		//page numberging
        //int bottomMarginNoLines = new Double(Math.floor(getMargin() / table.getFontSize())).intValue();
        rowsPerPage_int -= 1;//numeracion
		
		Integer rowsPerPage = new Integer(rowsPerPage_int);
		//max rows per page without the legends
		int maxRowNo =
				totalNoLines - headerNoLines - footerNoLines; 
				//rowsPerPage.intValue() + getLengendsNoLinesField()
				;
		
		//fix? Integer numberOfPages = new Double(Math.ceil(table.getNumberOfRows().floatValue() / rowsPerPage)).intValue();
		Double finalNoLines = new Double(table.getNumberOfRows() + lengendsNoLines);
		Integer numberOfPages = new Double(Math.ceil(finalNoLines / (double) maxRowNo)).intValue();
		System.out.println(" table.getNumberOfRows()		----> "+table.getNumberOfRows());
		System.out.println(" lengendsNoLines 		 	----> "+lengendsNoLines);
		System.out.println(" finalNoLines  			 	----> "+finalNoLines);
		System.out.println(" maxRowNo      			 	----> "+maxRowNo);
		System.out.println(" numberOfPages 			 	----> "+numberOfPages);
		// Generate each page, get the content and draw it
		for (int pageCount = FIRST_PAGE_INDEX; pageCount < numberOfPages; pageCount++) {
			page = generatePage(doc, table);
			contentStream = new PDPageContentStream(doc, page, false, true); /* jlv */
			generateContentStream(table);//generateContentStream(doc, page, table);

			//debugHeader();
			drawHeader();

			//table content
			float nextY = 
					//WORKS FINE drawTableContent(rowsPerPage, pageCount)
					drawTableContent2Morepages(rowsPerPage, pageCount, numberOfPages)//TEST
					;

			//legends
			//before drawLegends(nextY); 

			if( (pageCount == (numberOfPages-1)) && table.isUseFoooter() )
			{
				System.out.println("drawing Legends!!! in page: "+(pageCount+1));
				drawLegends(nextY);//after 
				drawFooter();
			}

			drawPageNo(contentStream, pageCount, numberOfPages);
			
			contentStream.close();
		}
	}

	protected float drawTableContent(Integer rowsPerPage, int pageCount)
			throws IOException {
		String[][] currentPageContent = getContentForCurrentPage(table, rowsPerPage, pageCount);
		float nextY = drawCurrentPage(table, currentPageContent/*, contentStream*/);
		return nextY;
	}

	/*orig: protected float drawTableContent2Morepages(Integer rowsPerPage, int pageCount)
			throws IOException {
		String[][] currentPageContent = getContentForCurrentPage2Morepages(table, rowsPerPage, pageCount);

		float nextY = 0;

		if(currentPageContent == null)
		{
			nextY = getTableTopY();
		}else
		{
			nextY = drawCurrentPage(table, currentPageContent);
		}
		return nextY;
	}*/
	
	//ver version original, arriba
	protected float drawTableContent2Morepages(Integer rowsPerPage, final int pageCount, final int numberOfPages)
			throws IOException {
		String[][] currentPageContent = getContentForCurrentPage2Morepages(table, rowsPerPage, pageCount, numberOfPages);

		float nextY = 0;

		if(currentPageContent == null)
		{
			nextY = getTableTopY();
		}else
		{
			nextY = drawCurrentPage(table, currentPageContent);
		}
		return nextY;
	}
	
	private static final String pageSep = "/";
	public static final String baja   = "(B)";
	protected static final StringBuffer bajaLegend = new StringBuffer();
	
	protected static final String POS_LN33 = "AUXILIAR ACADEMICO DE LA D.G.E.T.I.";//"Encargado del Despacho";
	protected static final String POS_LN23 = "EN AGUASCALIENTES";//"Subdirección de Enlace Operativo";
	protected static final String POS_LN13 = "";//"DGETI - Aguascalientes";
	protected static final float SIGN_LINE_PADDING = 1f;
	
	static
	{
		bajaLegend.append(baja);
		bajaLegend.append(" : alumno de baja");
	}
	
	public static final String strRegular   = "R";
	//public static final String strIrregular = "I";
	protected static final StringBuffer regLegend = new StringBuffer();
	//protected static final StringBuffer irregLegend = new StringBuffer();

	static
	{
		//irregLegend.append(strIrregular);
		//irregLegend.append(" : alumno irregular");
		regLegend.append(strRegular);
		regLegend.append(" : alumno regular");
	}

	private PDFont ttfFont;
	public static String c;

	protected void drawPageNo(PDPageContentStream contentStream, int pageIndex, final int numberOfPages) throws IOException
	{
		if(numberOfPages == 1)
		{
			return;
		}
		
		float x = getMargin();
		float y = getMargin();
		int no = ++pageIndex;
		StringBuffer s = new StringBuffer(Integer.toString(no));
		s.append(pageSep);
		s.append(numberOfPages);
		
		contentStream.beginText();
		contentStream.setFont( /*table.*/getTextFont(), table.getFontSize() );
		contentStream.moveTextPositionByAmount(x, y);
		contentStream.drawString(s.toString());
		contentStream.endText();
	}
	
	/*private void closeContentStream() throws IOException
	{
		contentStream.close();
	}*/

	/*private void debugHeader() throws IOException {
		if(DEBUG)
		{
			PDFont font = PDType1Font.HELVETICA_BOLD;
			contentStream.beginText();
			contentStream.setFont( font, 12 );
			contentStream.moveTextPositionByAmount(
					getMargin(),
					this.table.getPageSize().getHeight() - getMargin()
					);
			contentStream.drawString( "Hello World" );
			contentStream.endText();
		}
	}*/

	protected void drawHeader() throws IOException {
		/*begin debug jlv*/
		PDFont font = /*this.table.*/getTextFont()/*PDType1Font.HELVETICA_BOLD*/;
		contentStream.beginText();
		contentStream.setFont( font, 12 );
		//contentStream.moveTextPositionByAmount( 10, 700 );
		contentStream.moveTextPositionByAmount(
				getMargin(),
				getPageHeight()//this.table.getPageSize().getHeight() 
				- getMargin()
				);
		contentStream.drawString( table.getTitle() );
		contentStream.endText();

		/*end debug jlv*/
	}

	protected void drawFooter() throws IOException {
		/*begin debug jlv*/
		PDFont font = /*this.table.*/getTextFont()/*PDType1Font.HELVETICA_BOLD*/;
		contentStream.beginText();
		contentStream.setFont( font, 12 );
		//contentStream.moveTextPositionByAmount( 10, 700 );
		contentStream.moveTextPositionByAmount(
				getMargin(),
				/*this.table.getPageSize().getHeight() -*/ getMargin()
				);
		contentStream.drawString( ""/*table.getTitle()*/ );
		contentStream.endText();

		/*end debug jlv*/
	}

	protected void drawLegends(final float nextY ) throws IOException {
	}

	// ORIGINAL
	// Draws current page table grid and border lines and content
	protected float drawCurrentPage(Table table, String[][] currentPageContent/*, PDPageContentStream contentStream*/)
			throws IOException {
		float tableTopY = table.isLandscape() ? 
				table.getPageSize().getWidth()  - table.getMargin() - table.getHeaderHeight(): 
					table.getPageSize().getHeight() - table.getMargin() - table.getHeaderHeight();

				// Draws grid and borders
				int noLines = currentPageContent.length;
				drawGridBorders(table, tableTopY, noLines);

				// Position cursor to start drawing content
				float nextTextX = table.getMargin() + table.getCellMargin();
				// Calculate center alignment for text in cell considering font height
				float nextTextY = tableTopY - (table.getRowHeight() / 2f)
						- ((getTextFont().getFontDescriptor().getFontBoundingBox().getHeight() / 1000f * table.getFontSize()) / 4f);

				// Write column headers
				if(table.isUseColumnHdr())
				{
					writeContentLine(table.getColumnsNamesAsArray(), contentStream, nextTextX, nextTextY, table);
					nextTextY -= table.getRowHeight();
					//nextTextX = table.getMargin() + table.getCellMargin();
				}

				/** write division */
				if (table.isWithTableHeaderDiv())
				{
					drawTableHeaderDivLine(table, nextTextX, nextTextY);
					nextTextY -= table.getRowHeight();
				}
				/***/

				// Write content
				nextTextY = writeTableContent(table, currentPageContent, nextTextX, nextTextY);

				/** write division */
				if (table.isWithTableHeaderDiv())
				{
					float upperLinePos =  nextTextY/* + (table.getRowHeight()/3)*/;
					//orig drawTableHeaderDivLine(table, nextTextX, nextTextY);
					drawTableHeaderDivLine(table, nextTextX, upperLinePos);
					nextTextY -= table.getRowHeight();
				}
				/***/

				//-jlv- contentStream.close();
				return nextTextY;
	}

	// NEW
	protected float drawCurrentPage(String[][] currentPageContent/*, PDPageContentStream contentStream*/)
			throws IOException {
		float tableTopY = getTableTopY();

		// Draws grid and borders
		int noLines = currentPageContent.length;
		drawGridBorders(table, tableTopY, noLines);

		// Position cursor to start drawing content
		float nextTextX = table.getMargin() + table.getCellMargin();
		// Calculate center alignment for text in cell considering font height
		float nextTextY = tableTopY - (table.getRowHeight() / 2f)
				- ((getTextFont().getFontDescriptor().getFontBoundingBox().getHeight() / 1000f * table.getFontSize()) / 4f);

		// Write column headers
		if(table.isUseColumnHdr())
		{
			writeContentLine(table.getColumnsNamesAsArray(), contentStream, nextTextX, nextTextY, table);
			nextTextY -= table.getRowHeight();
			//nextTextX = table.getMargin() + table.getCellMargin();
		}

		/** write division */
		if (table.isWithTableHeaderDiv())
		{
			drawTableHeaderDivLine(table, nextTextX, nextTextY);
			nextTextY -= table.getRowHeight();
		}
		/***/

		// Write content
		nextTextY = writeTableContent(table, currentPageContent, nextTextX, nextTextY);

		/** write division */
		if (table.isWithTableHeaderDiv())
		{
			drawTableHeaderDivLine(table, nextTextX, nextTextY);
			nextTextY -= table.getRowHeight();
		}
		/***/

		//-jlv- contentStream.close();
		return nextTextY;
	}

	protected float getTableTopY() {
		float tableTopY = table.isLandscape() ? 
				table.getPageSize().getWidth()  - table.getMargin() - table.getHeaderHeight(): 
					table.getPageSize().getHeight() - table.getMargin() - table.getHeaderHeight();
		return tableTopY;
	}
	
	protected float writeTableContent(Table table, String[][] currentPageContent, float nextTextX, float nextTextY) throws IOException 
	{
		for (int i = 0; i < currentPageContent.length; i++) {
			writeContentLine(currentPageContent[i], contentStream, nextTextX, nextTextY, table);
			nextTextY -= table.getRowHeight();
			//nextTextX = table.getMargin() + table.getCellMargin();
		}
		return nextTextY;
	}

	protected void drawGridBorders(final Table table, final float tableTopY, final int noLines)
			throws IOException {

		float nextY = tableTopY;
		int newNoLines = noLines;

		if (table.isWithBorder())
		{
			if(!table.isUseColumnHdr())
			{
				newNoLines--;
			}

			//drawTableGrid(table, currentPageContent, contentStream, tableTopY);
			drawTableGrid(table, newNoLines, contentStream, nextY);
		}
	}

	protected void drawTableHeaderDivLine(Table table, float nextTextX,
			float nextTextY) throws IOException {
		contentStream.drawLine(table.getMargin(), nextTextY, table.getMargin() + getPrintbleLineSize(), nextTextY);
	}

	public void drawDivLine(int n, float rowHeight, float superiorMargin) throws IOException 
	{
		float y = getPageHeight()//this.table.getPageSize().getHeight() 
				- (	rowHeight	* n )
				- superiorMargin;

		contentStream.drawLine(table.getMargin(), y, table.getMargin() + getPrintbleLineSize(), y);
	}

	public void drawHeaderLine(final int line, final float xoffset, final float width) throws IOException 
	{
		float newY = 	getPageHeight() - 
				(this.getPdf().getPageHeaderRowHeight()	* line ) - 
				this.getPdf().getPageMarginSuperior();

		float x = table.getMargin()+xoffset;
		contentStream.drawLine(x, newY, x+width, newY);
	}

	public void drawDivLine(int n) throws IOException 
	{
		float y = getPageHeight()//this.table.getPageSize().getHeight() 
				- (	this.getPdf().getPageHeaderRowHeight()	* n )
				- this.getPdf().getPageMarginSuperior();

		contentStream.drawLine(table.getMargin(), y, table.getMargin() + getPrintbleLineSize(), y);
	}

	// Writes the content for one line
	protected void writeContentLine(String[] lineContent, PDPageContentStream contentStream, float nextTextX, float nextTextY,
			Table table) throws IOException {
		for (int i = 0; i < table.getNumberOfColumns(); i++) {
			String text = lineContent[i];
			if(text != null)
			{
				 text = getLimitStr(text, table.getColumns().get(i).getWidth());//jlv	
			}
			contentStream.beginText();
			contentStream.setFont( getTextFont(), table.getFontSize() );//jlv
			contentStream.moveTextPositionByAmount(nextTextX, nextTextY);
			contentStream.drawString(text != null ? text : "");
			contentStream.endText();
			nextTextX += table.getColumns().get(i).getWidth();
		}
	}

	protected void drawTableGrid(Table table, String[][] currentPageContent, PDPageContentStream contentStream, float tableTopY)
			throws IOException {
		// Draw row lines
		float nextY = tableTopY;
		for (int i = 0; i <= currentPageContent.length + 1; i++) {
			contentStream.drawLine(table.getMargin(), nextY, table.getMargin() + table.getWidth(), nextY);
			nextY -= table.getRowHeight();
		}
		if (table.isWithTableHeaderDiv())
		{
			contentStream.drawLine(table.getMargin(), nextY, table.getMargin() + table.getWidth(), nextY);
		}

		// Draw column lines
		final float tableYLength = table.getRowHeight() + (table.getRowHeight() * currentPageContent.length);
		final float tableBottomY = tableTopY - tableYLength;
		float nextX = table.getMargin();
		for (int i = 0; i < table.getNumberOfColumns(); i++) {
			contentStream.drawLine(nextX, tableTopY, nextX, tableBottomY);
			nextX += table.getColumns().get(i).getWidth();
		}
		contentStream.drawLine(nextX, tableTopY, nextX, tableBottomY);

		if (table.isWithTableHeaderDiv())
		{
			nextX = table.getMargin();
			for (int i = 0; i < table.getNumberOfColumns(); i++) {
				contentStream.drawLine(nextX, tableBottomY, nextX, nextY);
				nextX += table.getColumns().get(i).getWidth();
			}
			contentStream.drawLine(nextX, tableBottomY, nextX, nextY);
		}
	}

	protected void drawTableGrid(Table table, int length, PDPageContentStream contentStream, float tableTopY)
			throws IOException {
		// Draw row lines
		float nextY = tableTopY;
		for (int i = 0; i <= length + 1; i++) {
			contentStream.drawLine(table.getMargin(), nextY, table.getMargin() + table.getWidth(), nextY);
			nextY -= table.getRowHeight();
		}
		if (table.isWithTableHeaderDiv())
		{
			contentStream.drawLine(table.getMargin(), nextY, table.getMargin() + table.getWidth(), nextY);
		}

		// Draw column lines
		final float tableYLength = table.getRowHeight() + (table.getRowHeight() * length);
		final float tableBottomY = tableTopY - tableYLength;
		float nextX = table.getMargin();
		for (int i = 0; i < table.getNumberOfColumns(); i++) {
			contentStream.drawLine(nextX, tableTopY, nextX, tableBottomY);
			nextX += table.getColumns().get(i).getWidth();
		}
		contentStream.drawLine(nextX, tableTopY, nextX, tableBottomY);

		if (table.isWithTableHeaderDiv())
		{
			nextX = table.getMargin();
			for (int i = 0; i < table.getNumberOfColumns(); i++) {
				contentStream.drawLine(nextX, tableBottomY, nextX, nextY);
				nextX += table.getColumns().get(i).getWidth();
			}
			contentStream.drawLine(nextX, tableBottomY, nextX, nextY);
		}
	}

	protected String[][] getContentForCurrentPage(Table table, Integer rowsPerPage, int pageCount) {
		int startRange = pageCount * rowsPerPage;
		int endRange = (pageCount * rowsPerPage) + rowsPerPage;
		if (endRange > table.getNumberOfRows()) {
			endRange = table.getNumberOfRows();
		}
		return Arrays.copyOfRange(table.getContent(), startRange, endRange);
	}

	/*orig: protected String[][] getContentForCurrentPage2Morepages(Table table, Integer rowsPerPage, final int pageCount) {
		
		int startRange = 0;
		int endRange   = 0;
		
		if(pageCount == FIRST_PAGE_INDEX)
		{
			startRange = 0;
			endRange = rowsPerPage + getLengendsNoLinesField();
		}
		else
		{
			startRange = ((pageCount-1) * rowsPerPage) + (rowsPerPage + getLengendsNoLinesField());
			endRange   = startRange + rowsPerPage; 
		}

		if (startRange > table.getNumberOfRows()) {
			return null;
		}

		if (endRange > table.getNumberOfRows()) {
			endRange = table.getNumberOfRows();
		}
		return Arrays.copyOfRange(table.getContent(), startRange, endRange);
	}*/

	// ver metodo arriba, el original
	protected String[][] getContentForCurrentPage2Morepages(Table table, int rowsPerPage, final int pageCount, final int numberOfPages) {
		
		int startRange = 0;
		int endRange   = 0;
		int fullPageNoLines = (rowsPerPage + getLegendsNoLinesField());

		if(pageCount == FIRST_PAGE_INDEX) // 1era pagina
		{
			startRange = 0;
			endRange = fullPageNoLines;
		}
		else if(pageCount != numberOfPages-1) // pag intermedia
		{
			startRange = (pageCount) * fullPageNoLines;
			endRange   = startRange + fullPageNoLines; 
		} else // ultima pagina
		{
			startRange = (pageCount) * fullPageNoLines;
			endRange   = table.getNumberOfRows();//table.getContent().length; 
		}

		if (startRange > table.getNumberOfRows()) {
			return null;
		}

		if (endRange > table.getNumberOfRows()) {
			endRange = table.getNumberOfRows();
		}
		/*String[][] pageTblContent = Arrays.copyOfRange(table.getContent(), startRange, endRange);
		StringBuffer ptcMsg = new StringBuffer();
		ptcMsg.append("no of Pages: "+ numberOfPages);
		ptcMsg.append("\n");
		ptcMsg.append("page idx: "+ pageCount);
		ptcMsg.append("\n");
		ptcMsg.append("startRange: "+ startRange);
		ptcMsg.append("\n");
		ptcMsg.append("endRange: "+ endRange);
		ptcMsg.append("\n");
		ptcMsg.append("pageTblContent size: "+ pageTblContent.length);
		System.out.println(ptcMsg.toString());
		return pageTblContent;*/
		return Arrays.copyOfRange(table.getContent(), startRange, endRange);
	}

	protected PDPage generatePage(PDDocument doc, Table table) {
		PDPage page = new PDPage();
		page.setMediaBox(table.getPageSize());
		page.setRotation(table.isLandscape() ? 90 : 0);
		doc.addPage(page);
		return page;
	}

	protected PDPageContentStream generateContentStream(PDDocument doc, PDPage page, Table table) throws IOException {
		contentStream = new PDPageContentStream(doc, page, false, false);
		// User transformation matrix to change the reference when drawing.
		// This is necessary for the landscape position to draw correctly
		if (table.isLandscape()) {
			contentStream.concatenate2CTM(0, 1, -1, 0, table.getPageSize().getWidth(), 0);
		}
		contentStream.setFont(/*table.*/getTextFont(), table.getFontSize());
		return contentStream;
	}

	protected PDPageContentStream generateContentStream(Table table) throws IOException {
		// User transformation matrix to change the reference when drawing.
		// This is necessary for the landscape position to draw correctly
		if (table.isLandscape()) {
			contentStream.concatenate2CTM(0, 1, -1, 0, table.getPageSize().getWidth(), 0);
		}
		contentStream.setFont(/*table.*/getTextFont(), table.getFontSize());
		contentStream.setLineWidth(getHeaderlinewidth());

		return contentStream;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	protected String getDottedLine() 
	{
		if(equalsLine == null)
		{	
			c = "=";
			float equalSignSize = -1;
			try {
				equalSignSize = getTableStringSize(c)  
						//this.table.getFontSize()
						//* getStrWidth1000(c)
						//(/*this.table.*/getTextFont().getStringWidth(c) / 1000f)
						;
			} catch (IOException e) {
				e.printStackTrace();
			}

			float lenght = getPrintbleLineSize()-/*equalSignSize*/0;
			StringBuffer s = new StringBuffer();
			float len = 0;
			do
			{
				s.append(c);
				len += equalSignSize;
			}while( len < lenght );

			s.trimToSize();
			equalsLine = s.toString(); 
		}
		return equalsLine;
	}

	public float getPrintbleLineSize()
	{
		return  getPageWidth()//table.getPageSize().getWidth() 
				- (2f*table.getMargin());
	}

	protected void printDivLine(float yoffset) throws IOException 
	{
		PDFont font = /*this.table.*/getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.table.getFontSize() );
		contentStream.moveTextPositionByAmount(
				getMargin(),
				yoffset
				);
		contentStream.drawString( getDottedLine() );
		contentStream.endText();
	}

	protected void printDivLine(int n) throws IOException
	{
		float y = getPageHeight() 
				- (	this.getPdf().getPageHeaderRowHeight()	* n )
				- this.getPdf().getPageMarginSuperior();
		PDFont font = /*this.table.*/getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.table.getFontSize() );
		contentStream.moveTextPositionByAmount(
				getMargin(),
				y
				);
		contentStream.drawString( getDottedLine() );
		contentStream.endText();
	}
	
	protected float getTableStringSize(String l) throws IOException {
		return this.table.getFontSize() * getStrWidth1000(l);
	}

	protected float getStrWidth1000(String l) throws IOException
	{
		return (getTextFont().getStringWidth(l) / 1000f);
	}

	public PDF_SuperClass getPdf() {
		return this.pdf;
	}

	public void setPdf(PDF_SuperClass pdf) {
		this.pdf = pdf;
	}

	public String getFolderName() {
		return null;
	}

	public String getBaseDir() {
		String dir = null;
		if (getPdf() != null)
		{
			createPerDirIfNeeded(getPdf());//in case period does not exist
			dir = getPdf().getPdf_dir();
			createDirectoryIfNeeded(dir);
		}

		return dir;
	}

	protected float printHeaderLine(int n, String s)
			throws IOException {
		float newY = getPageHeight()//this.table.getPageSize().getHeight() 
				- (this.getPdf().getPageHeaderRowHeight()	* n ) - 
				this.getPdf().getPageMarginSuperior();

		PDFont font = /*this.table.*/getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.getPdf().getPageHeaderFontSize() );
		contentStream.moveTextPositionByAmount(
				getMargin(),
				newY
				);
		contentStream.drawString( s );
		contentStream.endText();

		return (newY - this.getPdf().getPageHeaderRowHeight());
	}

	protected float printHeaderLine(int n, float xoffset, String s)
			throws IOException {
		float newY = 	getPageHeight() - 
				(this.getPdf().getPageHeaderRowHeight()	* n ) - 
				this.getPdf().getPageMarginSuperior();

		PDFont font = /*this.table.*/getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.getPdf().getPageHeaderFontSize() );
		contentStream.moveTextPositionByAmount(
				xoffset,
				newY
				);
		contentStream.drawString( s );
		contentStream.endText();

		return (newY - this.getPdf().getPageHeaderRowHeight());
	}

	protected float printHeaderElement(int n, float xoffset, String s)
			throws IOException {
		float newY = 	getPageHeight() - 
				(this.getPdf().getPageHeaderRowHeight()	* n ) - 
				this.getPdf().getPageMarginSuperior();

		float newX = getMargin() + xoffset;
		
		PDFont font = /*this.table.*/getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.getPdf().getPageHeaderFontSize() );
		contentStream.moveTextPositionByAmount(
				newX,
				newY
				);
		contentStream.drawString( s );
		contentStream.endText();

		if(DEBUG)
		{
			contentStream.drawLine(newX+2, newY-2, newX+ getHeaderStringSize(s)-2, newY-2);
		}
		
		return (newY - this.getPdf().getPageHeaderRowHeight());
	}
	
	protected float printHeaderLineAttheEnd(int n, String s)
			throws IOException {
		float newY = 	getPageHeight() - 
				(this.getPdf().getPageHeaderRowHeight()	* n ) - 
				this.getPdf().getPageMarginSuperior();

		float newX = getPageWidth() - getMargin() - getHeaderStringSize(s);
		
		PDFont font = /*this.table.*/getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.getPdf().getPageHeaderFontSize() );
		contentStream.moveTextPositionByAmount(
				newX,
				newY
				);
		contentStream.drawString( s );
		contentStream.endText();

		return (newY - this.getPdf().getPageHeaderRowHeight());
	}

	protected float printHeaderLineAttheBeginning(int n, String s)
			throws IOException {
		float newY = 	getPageHeight() - 
				(this.getPdf().getPageHeaderRowHeight()	* n ) - 
				this.getPdf().getPageMarginSuperior();

		float newX = getMargin();
		
		PDFont font = getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.getPdf().getPageHeaderFontSize() );
		contentStream.moveTextPositionByAmount(
				newX,
				newY
				);
		contentStream.drawString( s );
		contentStream.endText();

		return (newY - this.getPdf().getPageHeaderRowHeight());
	}

	protected float getHeaderStringSize(String l) throws IOException {
		float size = this.getPdf().getPageHeaderFontSize() * getStrWidth1000(l);
		return size;
	}

	protected float printLegendElement(float yoffset, float xoffset, String s)
			throws IOException {
		float x = getMargin() + xoffset;

		PDFont font = /*this.table.*/getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.getPdf().getPageHeaderFontSize() );
		contentStream.moveTextPositionByAmount(
				x,
				yoffset
				);
		contentStream.drawString( s );
		float size = getHeaderStringSize(s);
		contentStream.endText();

		if(DEBUG)
		{
			contentStream.drawLine(x+2, yoffset-2, x+size-2, yoffset-2);
		}

		return size;
	}

	public float printLegendLine(float yoffset, final String s) throws IOException
	{
		float y = yoffset;

		printLegendElement(y, 0, s);
		y -= this.getPdf().getPageHeaderRowHeight();
		return y;
	}

	protected float printLegendElementUnderlined(float yoffset, float xoffset, String s)
			throws IOException 
	{
		float nextY = printLegendElement(yoffset, xoffset, s);

		float w = getHeaderStringSize(s);
		
		float x = getMargin()+ xoffset;
		float y = yoffset - getUnderlineyoffset();
		contentStream.setLineWidth(getUnderlinewidth());
		contentStream.drawLine(x, y, x+w, y);
		contentStream.setLineWidth(getHeaderlinewidth());

		return nextY;
	}
	
	protected float getCenterOffset(String l) throws IOException {

		float size = getHeaderStringSize(l);

		float pageWidth = getPageWidth();/*this.table.getPageSize().getWidth();*/

		float offset = (pageWidth - size)/2;
		return offset;
	}

	protected void printHeaderLineCentered(int n, String s)
			throws IOException {

		float xOffset = getCenterOffset(s);

		PDFont font = /*this.table.*/getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.getPdf().getPageHeaderFontSize() );
		contentStream.moveTextPositionByAmount(
				xOffset,
				getPageHeight()//this.table.getPageSize().getHeight() 
				- (	this.getPdf().getPageHeaderRowHeight() * n )
				- this.getPdf().getPageMarginSuperior()
				);
		contentStream.drawString( s );
		contentStream.endText();
	}

	protected String getEmptyStr(float n) {
		String e = " ";
		float emptSize = -1;
		try {
			emptSize = getHeaderStringSize(e);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		StringBuffer s = new StringBuffer();

		//for(int i = 0; i < n/emptSize; i++)
		for(float i = emptSize; i < n; i+=emptSize)
		{
			s.append(e);
		}

		s.trimToSize();
		return s.toString();
	}

	public void drawSignatureImage(String image, float x, float y, float linelength)
			throws IOException {

		/*if(!isUseImageFirma())
		{
			return;
		}

		if(ximageFirma == null)
		{	

			if( image.toLowerCase().endsWith( ".jpg" ) )
			{
				ximageFirma = new PDJpeg(doc, new FileInputStream( image ) );
			}
			else if (image.toLowerCase().endsWith(".tif") || image.toLowerCase().endsWith(".tiff"))
			{
				ximageFirma = new PDCcitt(doc, new RandomAccessFile(new File(image),"r"));
			}
			else
			{
				//BufferedImage awtImage = ImageIO.read( new File( image ) );
				//ximage = new PDPixelMap(doc, awtImage);
				throw new IOException( "Image type not supported:" + image );
			}
		}

		float newW = ximageFirma.getWidth()*PDF_SuperClass.FIRMA_SCALE;
		float newY = ximageFirma.getHeight()*PDF_SuperClass.FIRMA_SCALE;

		float oOffset = (newW - linelength)/2.0f;

		contentStream.drawXObject(
				ximageFirma
				, x - oOffset
				, y
				, newW
				, newY);
		//contentStream.drawImage( ximageFirma, x, y );*/
		float ranx = x+(float)Math.random()*10;
		float rany = y+(float)Math.random()*10;
		drawSignatureImage(contentStream, image, ranx, rany, linelength);
	}

	public void drawDgtSignatureImage(String image, float x, float y, float linelength)
			throws IOException {
		if(image == null)
		{
			return;
		}
		float ranx = x+(float)Math.random()*10;
		float rany = y+(float)Math.random()*10;
		drawDgtSignatureImage(contentStream, image, ranx, rany, linelength);
	}

	public void drawDgtSelloImage(String image, float x, float y, float linelength)
			throws IOException {
		if(image == null)
		{
			return;
		}
		float ranx = x+(float)Math.random()*10;
		float rany = y+(float)Math.random()*10;
		drawDgtSelloImage(contentStream, image, ranx, rany, linelength);
	}

	public void drawSignatureImage(PDPageContentStream contentStream, String image, float x, float y, float linelength)
			throws IOException {

		/*
		 * la mia siempre, ya no
		 */ 
		if(!isUseImageFirma())
		{
			return;
		}

		setximageFirma(image);

		float newW = ximageFirma.getWidth()*PDF_SuperClass.FIRMA_SCALE;
		float newH = ximageFirma.getHeight()*PDF_SuperClass.FIRMA_SCALE;

		float oOffset = (newW - linelength)/2.0f;

		contentStream.drawXObject(
				ximageFirma
				, x - oOffset
				, y
				, newW
				, newH);
		//contentStream.drawImage( ximageFirma, x, y );
	}

	public void drawDgtSignatureImage(PDPageContentStream contentStream, String image, float x, float y, float linelength)
			throws IOException {

		if(!isUseImageFirma())
		{
			return;
		}

		if(image == null)
		{
			return;
		}
		
		setximageDgtFirma(image);

		float newW = ximageDGTFirma.getWidth()*PDF_SuperClass.DGT_FIRMA_SCALE;
		float newH = ximageDGTFirma.getHeight()*PDF_SuperClass.DGT_FIRMA_SCALE;

		float oOffset = (newW - linelength)/2.0f;

		contentStream.drawXObject(
				ximageDGTFirma
				, x - oOffset
				, y
				, newW
				, newH);
		//contentStream.drawImage( ximageFirma, x, y );
	}

	public void drawDgtSelloImage(PDPageContentStream contentStream, String image, float x, float y, float linelength)
			throws IOException {

		if(!isUseImageFirma())
		{
			return;
		}

		if(image == null)
		{
			return;
		}
		
		setximageDgtSello(image);

		float newW = ximageDGTSello.getWidth()*PDF_SuperClass.DGT_SELLO_SCALE;
		float newH = ximageDGTSello.getHeight()*PDF_SuperClass.DGT_SELLO_SCALE;

		float oOffset = (newW - linelength)/2.0f;

		contentStream.drawXObject(
				ximageDGTSello
				, x - oOffset
				, y
				, newW
				, newH);
		//contentStream.drawImage( ximageFirma, x, y );
	}
	
	public void drawSelloImage(PDPageContentStream contentStream, String image, float x, float y, float linelength)
			throws IOException {

		/*
		 * la mia siempre
		 * 
		 * if(!isUseImageFirma())
		{
			return;
		}*/

		if(image == null)
		{
			return;
		}
		
		setXimageITRSello(image);

		float newW = ximageITRSello.getWidth()*PDF_SuperClass.ITR_SELLO_SCALE;
		float newH = ximageITRSello.getHeight()*PDF_SuperClass.ITR_SELLO_SCALE;

		float oOffset = (newW - linelength)/2.0f;

		contentStream.drawXObject(
				ximageITRSello
				, x - oOffset
				, y
				, newW
				, newH);
		//contentStream.drawImage( ximageFirma, x, y );
	}

	public void drawXImageITR(String image, float x, float y)
			throws IOException {

		drawXImageITR(contentStream, image, x, y);
	}
	
	public void drawXImageITR(PDPageContentStream contentStream, String image, float x, float y)
			throws IOException {

		setXimageITR(image);

		float newW = ximageITR.getWidth()*PDF_SuperClass.ITR_IMG_SCALE;
		float newH = ximageITR.getHeight()*PDF_SuperClass.ITR_IMG_SCALE;

		float newY = y - newH - getPdf().getPageMarginSuperior();
		float newX = x - newW - (getMargin()*1);

		contentStream.drawXObject(
				ximageITR
				, newX
				, newY
				, newW
				, newH);
	}

	public void drawXImageITRSello(String image, float x, float y, float linelength)
			throws IOException {

		float ranx = x+(float)Math.random()*10;
		float rany = y+(float)Math.random()*10;
		drawXImageITRSello(contentStream, image, ranx, rany, linelength);
	}

	public void drawXImageITRSello(PDPageContentStream contentStream, String image, float x, float y, float linelength)
			throws IOException {

		setXimageITRSello(image);

		float newW = ximageITRSello.getWidth()*PDF_SuperClass.ITR_SELLO_SCALE;
		float newH = ximageITRSello.getHeight()*PDF_SuperClass.ITR_SELLO_SCALE;

		float oOffset = (newW - linelength)/2.0f;
		
		contentStream.drawXObject(
				ximageITRSello
				, x - oOffset
				, y
				, newW
				, newH);
	}

	private void setximageFirma(String image) throws IOException,
			FileNotFoundException {
		if(ximageFirma == null)
		{	
			if( image.toLowerCase().endsWith( ".jpg" ) )
			{
				ximageFirma = new PDJpeg(/*doc*/getDoc(), new FileInputStream( image ) );
			}
			else if (image.toLowerCase().endsWith(".tif") || image.toLowerCase().endsWith(".tiff"))
			{
				ximageFirma = new PDCcitt(/*doc*/getDoc(), new RandomAccessFile(new File(image),"r"));
			}
			else
			{
				BufferedImage awtImage = ImageIO.read( new File( image ) );
				ximageFirma = new PDPixelMap(/*doc*/getDoc(), awtImage);
				//throw new IOException( "Image type not supported:" + image );
			}
		}
	}

	private void setximageDgtFirma(String image) throws IOException,
	FileNotFoundException {
		if(ximageDGTFirma == null)
		{	
			if(image == null)
			{
				return;
			}
			
			if( image.toLowerCase().endsWith( ".jpg" ) )
			{
				ximageDGTFirma = new PDJpeg(/*doc*/getDoc(), new FileInputStream( image ) );
			}
			else if (image.toLowerCase().endsWith(".tif") || image.toLowerCase().endsWith(".tiff"))
			{
				ximageDGTFirma = new PDCcitt(/*doc*/getDoc(), new RandomAccessFile(new File(image),"r"));
			}
			else
			{
				BufferedImage awtImage = ImageIO.read( new File( image ) );
				ximageDGTFirma = new PDPixelMap(/*doc*/getDoc(), awtImage);
				//throw new IOException( "Image type not supported:" + image );
			}
		}
	}
	
	private void setximageDgtSello(String image) throws IOException,
	FileNotFoundException {
		if(ximageDGTSello == null)
		{	
			if( image.toLowerCase().endsWith( ".jpg" ) )
			{
				ximageDGTSello = new PDJpeg(/*doc*/getDoc(), new FileInputStream( image ) );
			}
			else if (image.toLowerCase().endsWith(".tif") || image.toLowerCase().endsWith(".tiff"))
			{
				ximageDGTSello = new PDCcitt(/*doc*/getDoc(), new RandomAccessFile(new File(image),"r"));
			}
			else
			{
				BufferedImage awtImage = ImageIO.read( new File( image ) );
				ximageDGTSello = new PDPixelMap(/*doc*/getDoc(), awtImage);
				//throw new IOException( "Image type not supported:" + image );
			}
		}
	}	

	private void setXimageITR(String image) throws IOException,	FileNotFoundException {
		if(ximageITR == null)
		{	
			if( image.toLowerCase().endsWith( ".jpg" ) )
			{
				ximageITR = new PDJpeg(getDoc(), new FileInputStream( image ) );
			}
			else if (image.toLowerCase().endsWith(".tif") || image.toLowerCase().endsWith(".tiff"))
			{
				ximageITR = new PDCcitt(getDoc(), new RandomAccessFile(new File(image),"r"));
			}
			else
			{
				BufferedImage awtImage = ImageIO.read( new File( image ) );
				ximageITR = new PDPixelMap(getDoc(), awtImage);
			}
		}
	}

	private void setXimageITRSello(String image) throws IOException,	FileNotFoundException {
		if(ximageITRSello == null)
		{	
			if( image.toLowerCase().endsWith( ".jpg" ) )
			{
				ximageITRSello = new PDJpeg(getDoc(), new FileInputStream( image ) );
			}
			else if (image.toLowerCase().endsWith(".tif") || image.toLowerCase().endsWith(".tiff"))
			{
				ximageITRSello = new PDCcitt(getDoc(), new RandomAccessFile(new File(image),"r"));
			}
			else
			{
				BufferedImage awtImage = ImageIO.read( new File( image ) );
				ximageITRSello = new PDPixelMap(getDoc(), awtImage);
				System.out.println("ximageITRSello.getWidth(): "+ximageITRSello.getWidth());
			}
		}
	}

	public float getPageHeight()
	{
		height = table.isLandscape() ? 
				table.getPageSize().getWidth(): 
					table.getPageSize().getHeight();
				return height;		
	}

	public float getPageWidth()
	{

		width = table.isLandscape() ? 
				table.getPageSize().getHeight(): 
					table.getPageSize().getWidth();

				return width;		
	}

	public float getRightMarginPos(String str) throws IOException
	{
		return  getPageWidth() - getMargin() - getHeaderStringSize(str);
	}

	public float getMargin() {
		return table.getMargin();
	}

	public boolean isLandscape() {
		return table.isLandscape();
	}

	public float getHeaderHeight() {
		return table.getHeaderHeight();
	}

	public PDFont getTextFont() {
		
		if( ttfFont == null)
		{
			try {
				ttfFont = PDTrueTypeFont.loadTTF(getDoc(), this.pdf.getFont_file());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ttfFont;//table.getTextFont();
	}

	public float getTableFontSize() {
		return table.getFontSize();
	}

	public boolean isUseImageFirma() {
		return useImageFirma;
	}

	public void setUseImageFirma(boolean useImageFirma) {
		this.useImageFirma = useImageFirma;
	}

	protected String getEmptyStrSepStr() {
		return getEmptyStr(EMPTY_GPOTNOFOL_SEP);
	}

	public boolean isPrintDirectly() {
		return printDirectly;
	}

	public void setPrintDirectly(boolean printDirectly) {
		this.printDirectly = printDirectly;
	}

	public boolean isPrintSilently() {
		return printSilently;
	}

	public void setPrintSilently(boolean printSilently) {
		this.printSilently = printSilently;
	}

	public ITR_PDFTableGenerator(boolean printDirectly, boolean printSilently) {
		super();
		this.printDirectly = printDirectly;
		this.printSilently = printSilently;
	}

	public static PrintService choosePrinter() {
		PrinterJob printJob = PrinterJob.getPrinterJob();
		if(printJob.printDialog()) {
			return printJob.getPrintService();          
		}
		else {
			return null;
		}
	}

	public static void printPDF(String fileName, PrintService printer)
			throws IOException, PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintService(printer);
		PDDocument doc = PDDocument.load(fileName);
		doc.silentPrint(job);
	}

	public void printPDF(PrintService printer)
			throws IOException, PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintService(printer);
		/*this.doc*/getDoc().silentPrint(job);
	}

	protected float calculateLegendsHeight() {
		this.legendsSize = 0;
		return this.legendsSize;
	}

	protected float calculateFooterHeight() {
		setFooterSize(getMargin());//this.footerSize = getMargin();
		return this.footerSize;
	}

	public String getLimitStr(final String orig, float maxSize)
	{
		String res = orig;

		maxSize -= this.getTable().getCellMargin()*2f;
		
		try{

			float size = getTableStringSize(res);

			float diff = size - maxSize;

			if(diff >= 0f )
			{
				String tmp = orig.substring(0, orig.length()-1);
				while(getTableStringSize(tmp) >= maxSize)
				{
					tmp = tmp.substring(0, tmp.length()-1);
				}
				res = tmp;
			}
		} catch(IOException e)
		{
			e.printStackTrace();
		}

		return res;
	}

	public static String getLimitStr(final String orig, final float maxSize, PDFont font)
	{
		String res = orig;

		try{

			float size = (font.getStringWidth(res) / 1000f);

			float diff = size - maxSize;

			if(diff <= 0 )
			{
				String tmp = orig.substring(0, orig.length());
				while((font.getStringWidth(tmp) / 1000f)>= maxSize)
				{
					tmp = tmp.substring(0, tmp.length());
				}
				res = tmp;
			}
		} catch(IOException e)
		{
			e.printStackTrace();
		}

		return res;
	}
	
	public PDDocument getDoc() {
		return doc;
	}

	public void setDoc(PDDocument doc) {
		this.doc = doc;
	}

	public static float getHeaderlinewidth() {
		return headerLineWidth;
	}

	public static float getUnderlinewidth() {
		return underLineWidth;
	}
	
	public static float getUnderlineyoffset() {
		return underlineYoffset;
	}

	public float getLegendsSize() {
		return legendsSize;
	}

	public void setLegendsSize(float legendsSize) {
		this.legendsSize = legendsSize;
	}

	public int getNoLegendLines() {
		return noLegendLines;
	}

	public void setNoLegendLines(int noLegendLines) {
		this.noLegendLines = noLegendLines;
	}

	public float getFooterSize() {
		return footerSize;
	}

	public void setFooterSize(float footerSize) {
		this.footerSize = footerSize;
	}

	public int getLegendsNoLinesField() {
		return legendsNoLinesField;
	}

	public void setLegendsNoLinesField(int lengendsNoLinesField) {
		this.legendsNoLinesField = lengendsNoLinesField;
	}

	public int getFooterNoLinesField() {
		return footerNoLinesField;
	}

	public void setFooterNoLinesField(int footerNoLinesField) {
		this.footerNoLinesField = footerNoLinesField;
	}
	
	public float getSignatureHeight() {
		
		if(isUseImageFirma())
		{
			try {
				setximageFirma(this.getPdf().getSign_file());
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
			return ximageFirma.getHeight()*PDF_SuperClass.FIRMA_SCALE;	
		}
		else
		{
			return 0;
		}
	}

	public float getDgtSignatureHeight() {
		
		if(isUseImageFirma())
		{
			try {
				setximageDgtFirma(this.getPdf().getDgt_sign_file());
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
			return ximageDGTFirma != null ? ximageDGTFirma.getHeight()*PDF_SuperClass.DGT_FIRMA_SCALE : 0;	
		}
		else
		{
			return 0;
		}
	}
	
	public float getDgtSelloHeight() {
		
		if(isUseImageFirma())
		{
			try {
				setximageDgtSello(this.getPdf().getDgt_seal_file());
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
			return ximageDGTSello.getHeight()*PDF_SuperClass.DGT_SELLO_SCALE;	
		}
		else
		{
			return 0;
		}
	}
	
	public float getSignatureWidth() {
		if(isUseImageFirma())
		{
			try {
				setximageFirma(this.getPdf().getSign_file());
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
			return ximageFirma.getWidth()*PDF_SuperClass.FIRMA_SCALE;	
		}
		else
		{
			return 0;
		}
	}

	public float getDgtSignatureWidth() {
		if(isUseImageFirma())
		{
			try {
				setximageDgtFirma((this.getPdf().getDgt_sign_file()));
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
			return ximageDGTFirma != null ? ximageDGTFirma.getWidth()*PDF_SuperClass.DGT_FIRMA_SCALE : 0;	
		}
		else
		{
			return 0;
		}
	}
	
	public float getDgtSelloWidth() {
		if(isUseImageFirma())
		{
			try {
				setximageDgtSello((this.getPdf().getDgt_seal_file()));
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
			return ximageDGTSello.getWidth()*PDF_SuperClass.DGT_SELLO_SCALE;	
		}
		else
		{
			return 0;
		}
	}
	
	protected float drawPosition(final boolean dgeti, final String txt, final int footerLineNo) throws IOException {
		StringBuffer cor = new StringBuffer(txt);
		cor.trimToSize();
		float halfpage = getPrintbleLineSize()/2;
		float sizeD = getHeaderStringSize(cor.toString());
		halfpage -= sizeD;
		halfpage /= 2;
	
		PDFont font = getTextFont();
		contentStream.beginText();
		contentStream.setFont( font, this.getPdf().getPageHeaderFontSize() );
		float xoffset = getMargin() +
				(dgeti ? (getPrintbleLineSize()/2) : 0)
				+ halfpage;
		float yoffset = getMargin() + (getPdf().getPageHeaderRowHeight()*(float)footerLineNo);
		contentStream.moveTextPositionByAmount(
				xoffset,
				yoffset
				);
		contentStream.drawString( cor.toString() );
		contentStream.endText();
	
		return yoffset + getPdf().getPageHeaderRowHeight();
	}

	protected float drawSignLine(final boolean dgeti, final String txt, final int footerLineNo) throws IOException {
		StringBuffer cor = new StringBuffer(txt);
		cor.trimToSize();
		float halfpage = getPrintbleLineSize()/2;
		float sizeD = getHeaderStringSize(cor.toString());
		halfpage -= sizeD;
		halfpage /= 2;
	
		float xoffset = getMargin() +
				(dgeti ? (getPrintbleLineSize()/2) : 0)
				+ halfpage;
		float yoffset = getMargin() + (getPdf().getPageHeaderRowHeight()*(float)footerLineNo);
	
		yoffset += getPdf().getPageHeaderRowHeight()*SIGN_LINE_PADDING;
		contentStream.drawLine(
				  xoffset
				, yoffset
				, xoffset + getHeaderStringSize(txt)
				, yoffset);
	
		return yoffset + getPdf().getPageHeaderRowHeight();
	}

	protected void setPageBookmark(String bookmarkTitle) {
		//bookmark begin
		//first create the document outline and add it to the page
		PDDocumentOutline outline =  new PDDocumentOutline();
		doc.getDocumentCatalog().setDocumentOutline( outline );
	
		//Create a root element to show in the tree
		//PDOutlineItem root = new PDOutlineItem();
		//root.setTitle( "ITR_BOOKMARKs" );
		//outline.appendChild( root);
	
		//Get the page to refer to
		PDPage firstPage = (PDPage)doc.getDocumentCatalog().getAllPages().get( 0 );
		//Create the outline item to refer to the first page.
		PDOutlineItem firstPageItem = new PDOutlineItem();
		firstPageItem.setTitle(bookmarkTitle);
		firstPageItem.setDestination( firstPage );
		outline.appendChild( firstPageItem );
	
		firstPageItem.openNode();
		outline.openNode();
		//boorkmark end
	}

	protected float printFooterNoteTxt(boolean right, String s, final float pageInferiorMargin) throws IOException {
		float y = getMargin() +
				pageInferiorMargin
				//PDF_hist.PAGE_MARGIN_INFERIOR
				;
		
		float xOffset = right ? getRightMarginPos(s) : getMargin();
		
		contentStream.beginText();
		contentStream.setFont( getTextFont(), this.getPdf().getPageHeaderFontSize() );
		contentStream.moveTextPositionByAmount(
				xOffset,
				y
				);
		contentStream.drawString( s.toString() );
		contentStream.endText();
		
		return y;
	}
} 
