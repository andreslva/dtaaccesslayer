package itr.pdf.itext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Properties;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ITR_PDFHandler {

	private static final String root_pdf_dir_property = "pdf_folder";
	
	private Document document;
	private PdfWriter writer; 
	
	private String fileName;

	private Properties prop;
	
	private String root_pdf_dir;
	
	public ITR_PDFHandler(final String fileName) throws FileNotFoundException
	{
		prop = new Properties();
		
		try
		{
			prop.load(new FileInputStream(".\\prop\\pdf.cfg"));

			System.out.println("properties found");

			root_pdf_dir = prop.getProperty(root_pdf_dir_property).toString();

		} catch (IOException io)
		{
			io.printStackTrace();
		}
		
		
		this.fileName = fileName;
		
		this.document = new Document(PageSize.LETTER);
		
		StringBuffer fullFileName = new StringBuffer(this.root_pdf_dir.concat(this.fileName));
		
		GregorianCalendar gc = new GregorianCalendar(Locale.getDefault());
		String d,m,y;
		d = Integer.toString(gc.get(Calendar.DAY_OF_MONTH));
		m = Integer.toString(gc.get(Calendar.MONTH)+1);
		y = Integer.toString(gc.get(Calendar.YEAR));
		StringBuffer sb = new StringBuffer();
		sb.append(d.length() == 1 ? "0".concat(d):d);
		sb.append("-");
		sb.append(m.length() == 1 ? "0".concat(m):m);
		sb.append("-");
		sb.append(y.length() == 1 ? "0".concat(y):y);
		
		fullFileName.append("_");
		fullFileName.append(sb);
		fullFileName.append(".pdf");
		
		try {
			this.writer = PdfWriter.getInstance(this.document, new FileOutputStream(fullFileName.toString()));
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FileNotFoundException("invali pdf output folder!!: " + fullFileName.toString());
		}
		
	}

	public void openDocument()
	{
		this.document.open();
	}
	
	public void writeDocument(final String text)
	{
		Font font = FontFactory.getFont("Arial",11);
		Paragraph p = new Paragraph(text,font);
		p.setKeepTogether(true);
		
		try {
			this.document.add(p);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeDocument()
	{
		this.document.close();
		this.writer.close();
	}
	
	public String getRootPdfDir() {
		return root_pdf_dir;
	}
	
	/*
	private String getFileName() {
		return fileName;
	}

	private String getDir() {
		return dir;
	}*/

}
