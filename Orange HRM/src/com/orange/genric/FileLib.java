package com.orange.genric;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.j2objc.annotations.Property;

public class FileLib 
{
	public String readProperty(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
	    String	data=p.getProperty(key);
	    return data;
	}
	public String readExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./data/testscrpite.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	    String	data=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	    return data;
	}
	public void writeExcelData(String sheetName,int row,int cell,String value ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./data/testscrpite.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./data/testscrpite.xlsx");
		wb.write(fos);
	}

}
