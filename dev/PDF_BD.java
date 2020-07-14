package itr.dev;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import itr.pdf.pdfbox.PDF_SuperClass;

class PDF_BD extends PDF_SuperClass
{
	public PDF_BD(int pdId) {
		super(pdId);

		try
		{
			prop.load(new FileInputStream(PROP_FILE));
			
			System.out.println("properties found");
			
			setPdf_dir(prop.getProperty("pdf_BD_folder").toString());
			setDgeti_docs_dir(prop.getProperty(DGETI_DOCS_DIR_PROP).toString());
			setFont_file(prop.getProperty(FONTR_FILE_NAME_PROP).toString());
		} catch (IOException io)
		{
			io.printStackTrace();
		}
	}
	
	public String getPdf_dir() {
		
		StringBuffer dir = new StringBuffer();
		dir.append(getDgeti_docs_dir());
		dir.append(pdf_dir);
		System.out.println("dir: "+dir.toString());
		return dir.toString();
	}
	
}