package itr.dev;

import itr.pdf.pdfbox.Column;
import itr.pdf.pdfbox.ITR_PDFTableGenerator;
import itr.pdf.pdfbox.PDFTableGenerator;
import itr.pdf.pdfbox.Table;
import itr.pdf.pdfbox.TableBuilder;

import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDF_Cumpleanos {

	// Page configuration
	private static final PDRectangle PAGE_SIZE = PDPage.PAGE_SIZE_LETTER;
	private static final float MARGIN = 30;
	private static final boolean IS_LANDSCAPE = false;
	// Font configuration
	private static final PDFont TEXT_FONT = PDType1Font.HELVETICA;
	private static final float FONT_SIZE = 16;
	// Table configuration
	private static final float ROW_HEIGHT = 24;
	private static final float CELL_MARGIN = 2;
	private static final float HEADERHEIGHT = 50;
	private static final boolean WITHBORDER = false;
	private static final String TITLE = "CUMPLEAÑOS";
	
	public static Table createContent(String[][] content, String mes, String s) {
		// Total size of columns must not be greater than table width.
		List<Column> columns = new ArrayList<Column>();
		columns.add(new Column("DÍA", 45));
		columns.add(new Column("GRUPO", 110));
		
		float nSize = PAGE_SIZE.getWidth() - (MARGIN*2) - 45 - 110; 
		
		columns.add(new Column("NOMBRE", nSize));
		/*columns.add(new Column("ZipCode", 43));
		columns.add(new Column("MailOptIn", 50));
		columns.add(new Column("Code", 80));
		columns.add(new Column("Branch", 39));
		columns.add(new Column("Product", 300));
		columns.add(new Column("Date", 120));
		columns.add(new Column("Channel", 43));*/
		/*
		String[][] content = {
				{ "FirstName", "LastName", "fakemail@mock.com"},
				{ "FirstName", "LastName", "fakemail@mock.com"},
				{ "FirstName", "LastName", "fakemail@mock.com"}
		};*/
		
		float tableHeight = IS_LANDSCAPE ? PAGE_SIZE.getWidth() - (2 * MARGIN) : PAGE_SIZE.getHeight() - (2 * MARGIN);
		Table table = new TableBuilder()
		.setCellMargin(CELL_MARGIN)
		.setColumns(columns)
		.setContent(content)
		.setHeight(tableHeight)
		.setNumberOfRows(content.length)
		.setRowHeight(ROW_HEIGHT)
		.setMargin(MARGIN)
		.setPageSize(PAGE_SIZE)
		.setLandscape(IS_LANDSCAPE)
		.setTextFont(TEXT_FONT)
		.setFontSize(FONT_SIZE)
		.setHeaderHeight(HEADERHEIGHT)
		.setWithBorder(WITHBORDER)
		.setTitle(TITLE.concat(" ").concat(mes).concat(" ").concat(s))
		.build();
		return table;
	}

	public static void main(String[] args) throws IOException, COSVisitorException {
		
		/*ITRDataSourceFebJun2015 ds = new ITRDataSourceFebJun2015();
	
		String fileDir = ds.getPDF_folder();
		String fileName  = fileDir.concat("cumple_v00.pdf");
		
		String[][] content = {
				{ "FirstName", "LastName", "fakemail@mock.com"},
				{ "FirstName", "LastName", "fakemail@mock.com"},
				{ "FirstName", "LastName", "fakemail@mock.com"}
		};
		
		Table t = createContent(content,"mes","ALUMNOS");
		
		try {
			new ITR_PDFTableGenerator().generatePDF(t,fileName);
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	
}
