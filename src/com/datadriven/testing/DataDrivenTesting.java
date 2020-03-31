package com.datadriven.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTesting
{

	public static void main(String[] args)
	{
		
		Xls_Reader reader = new Xls_Reader("E:\\New Java_Workspace\\ApachePOI_DataDriverTestingPractice\\src\\com\\test\\data\\DataDriven.xlsx.xlsx");
		
		String fName = reader.getCellData("RegTestData", "FirstName" , 2);
		System.out.println(fName);
		
		String lName = reader.getCellData("RegTestData", "LastName" , 2);
		System.out.println(lName);
		
		String email = reader.getCellData("RegTestData", "Email" , 2);
		System.out.println(email);
		
		String pass = reader.getCellData("RegTestData", "Password" , 2);
		System.out.println(pass);
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium_Naveen\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		driver.findElement(By.name("firstname")).sendKeys(fName);
		driver.findElement(By.name("lastname")).sendKeys(lName);
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("PASSWORD")).sendKeys(pass);

	}

}
