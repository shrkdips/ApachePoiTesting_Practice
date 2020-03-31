package com.datadriven.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizationDataDriverTesting
{

	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium_Naveen\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		
		//data driven approach is also called as "parameterization".
		//It is used to create data driven framework : driving the test data from the excel file.
		
		//get test data from excel
		Xls_Reader reader = new Xls_Reader("E:\\New Java_Workspace\\ApachePOI_DataDriverTestingPractice\\src\\com\\test\\data\\DataDriven.xlsx.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		
		reader.addColumn("RegTestData", "Status"); // to add new column.
		
		for (int rowNum = 2; rowNum<=rowCount; rowNum++)
		{
			String fName = reader.getCellData("RegTestData", "FirstName" , rowNum);
			System.out.println(fName);
			
			String lName = reader.getCellData("RegTestData", "LastName" , rowNum);
			System.out.println(lName);
			
			String email = reader.getCellData("RegTestData", "Email" , rowNum);
			System.out.println(email);
			
			String pass = reader.getCellData("RegTestData", "Password" , rowNum);
			System.out.println(pass);
			
			
			driver.findElement(By.name("firstname")).clear();
			driver.findElement(By.name("firstname")).sendKeys(fName);
			
			driver.findElement(By.name("lastname")).clear();
			driver.findElement(By.name("lastname")).sendKeys(lName);
			
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("email")).clear();
			
			driver.findElement(By.name("PASSWORD")).sendKeys(pass);
			
			// *Imp Note:- we should always close the excel sheet while adding the data into the excel sheet.
			reader.setCellData("RegTestData", "Status", rowNum, "Pass"); //write the data into the excel sheet.
		}

	}

}