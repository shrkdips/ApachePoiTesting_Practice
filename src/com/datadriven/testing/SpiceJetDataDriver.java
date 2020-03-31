package com.datadriven.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class SpiceJetDataDriver
{

	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium_Naveen\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://book.spicejet.com/Register.aspx");
		
		
		Xls_Reader reader = new Xls_Reader("E:\\New Java_Workspace\\ApachePOI_DataDriverTestingPractice\\src\\com\\test\\data\\DataDriven.xlsx.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		
		for (int rowNum = 2; rowNum<=rowCount; rowNum++)
		{
			String fName = reader.getCellData("RegTestData", "FirstName" , rowNum);
			System.out.println(fName);
			
			String lName = reader.getCellData("RegTestData", "LastName" , rowNum);
			System.out.println(lName);
			
			String phNum = reader.getCellData("RegTestData", "PhoneNumber", rowNum);
			System.out.println(phNum);
			
			String pass = reader.getCellData("RegTestData", "Password" , rowNum);
			System.out.println(pass);
			
			String email = reader.getCellData("RegTestData", "Email" , rowNum);
			System.out.println(email);
			
			
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxFirstName']")).clear();
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxFirstName']")).sendKeys(fName);
			
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxLastName']")).clear();
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxLastName']")).sendKeys(lName);
			
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TEXTBOXINTLMOBILENUMBER']")).clear();
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TEXTBOXINTLMOBILENUMBER']")).sendKeys(phNum);
			
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$MemberInputRegisterView$PasswordFieldAgentPassword']")).clear();
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$MemberInputRegisterView$PasswordFieldAgentPassword']")).sendKeys(pass);
			
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$MemberInputRegisterView$PasswordFieldPasswordConfirm']")).clear();
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$MemberInputRegisterView$PasswordFieldPasswordConfirm']")).sendKeys(pass);
			
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxEmail']")).clear();
			driver.findElement(By.xpath("//input[@name='CONTROLGROUPREGISTERVIEW$PersonInputRegisterView$TextBoxEmail']")).sendKeys(email);
		
		}

	}
}