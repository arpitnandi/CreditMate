package com.CM.UtilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utils
{
	private String readExcell(String path,String sheet,int i,int j) throws EncryptedDocumentException, IOException 
	{
		FileInputStream F = new FileInputStream("C:\\Users\\Arpith\\git\\CM_Git\\com.CM.Collect\\src\\test\\resources\\com\\TestData\\CM_Users.xlsx");
		Workbook W = WorkbookFactory.create(F);
		Sheet S = W.getSheet("Credentials");
		String Value = S.getRow(i).getCell(j).getStringCellValue();
		return Value;
	}
	
	private Sheet getDataSheet(String path,String sheet,int i,int j) throws EncryptedDocumentException, IOException 
	{
		FileInputStream F = new FileInputStream("C:\\Users\\Arpith\\git\\CM_Git\\com.CM.Collect\\src\\test\\resources\\com\\TestData\\CM_Users.xlsx");
		Workbook W = WorkbookFactory.create(F);
		Sheet S = W.getSheet("Credentials");
		return S;
	}
	
	private void readProperties() 
	{
		File F = new File("C:\\Users\\Arpith\\git\\CM_Git\\com.CM.Collect\\src\\test\\resources\\com\\Properties\\FilePaths.properties"); 
	}
}
