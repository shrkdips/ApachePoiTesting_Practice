package com.datadriven.testing;

import com.excel.utility.Xls_Reader;

public class ExcelOperations
{

	public static void main(String[] args)
	{
		
		Xls_Reader reader = new Xls_Reader("E:\\New Java_Workspace\\ApachePOI_DataDriverTestingPractice\\src\\com\\test\\data\\DataDriven.xlsx.xlsx");
		
		
		if(!reader.isSheetExist("HomePage"))
		{
			reader.addSheet("HomePage");
		}
		
		int colCount = reader.getColumnCount("RegTestData");
		System.out.println("The column count is: " + colCount);
		
		int cellCount = reader.getCellRowNum("RegTestData", "FirstName", "SrkDip");
		System.out.println(cellCount);

	}

}
