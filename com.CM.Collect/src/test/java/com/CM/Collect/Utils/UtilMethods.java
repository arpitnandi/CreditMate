package com.CM.Collect.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

public class UtilMethods 
{
	public static String readExcell(String S, int i, int j) throws IOException
	{
		FileInputStream f = new FileInputStream("C:\\Eclps_Projects\\Maven_Projects\\com.CreditMate.Staging.Test\\src\\test\\resources\\com\\CreditMate\\Collect\\TetData\\Credentials.xlsx");
		Workbook w = WorkbookFactory.create(f);
		Sheet s = w.getSheet(S);
		String value = s.getRow(i).getCell(j).getStringCellValue();
		return value;
	}
}
