package com.datadriven.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParameterizationFacebookRegPage
{
		
		public static void main(String[] args)throws InterruptedException
		{
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium_Naveen\\Softwares\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			driver.get("https://www.facebook.com/");
			
			System.out.println(driver.getTitle());
			
			
			Xls_Reader reader = new Xls_Reader("E:\\New Java_Workspace\\ApachePOI_DataDriverTestingPractice\\src\\com\\test\\data\\DataDrivenNew.xlsx");
			
			int rowCount = reader.getRowCount("RegPageTest");
			System.out.println(rowCount);
			
			for (int rowNumber = 2; rowNumber<=rowCount; rowNumber++)
			{
				
				String firstName = reader.getCellData("RegPageTest", "FirstName", rowCount);
				System.out.println(firstName);
				
				String SurName = reader.getCellData("RegPageTest", "SurName", rowCount);
				System.out.println(SurName);
				
				String email = reader.getCellData("RegPageTest", "Email", rowCount);
				System.out.println(email);
				
				String newPass = reader.getCellData("RegPageTest", "NewPassword", rowCount);
				System.out.println(newPass);
				
//				String birthDay = reader.getCellData("RegPageTest", "BirthDay", 2);
//				System.out.println(birthDay);
				
//				String birthMonth = reader.getCellData("RegPageTest", "BirthMonth", rowCount);
//				System.out.println(birthMonth);
				
//				String birthYear = reader.getCellData("RegPageTest", "BirthYear", 2);
//				System.out.println(birthYear);
				
//				String gender = reader.getCellData("RegPageTest", "Gender", 2);
//				System.out.println(gender);
				
				
				
				driver.findElement(By.name("firstname")).clear();
				driver.findElement(By.name("firstname")).sendKeys(firstName);
				
				driver.findElement(By.name("lastname")).clear();
				driver.findElement(By.name("lastname")).sendKeys(SurName);
				
				driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
				driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(email);
				
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).clear();
				driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(email);
				
				driver.findElement(By.xpath("//input[@name='reg_passwd__']")).clear();
				driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(newPass);
				
				
				Select select = new Select(driver.findElement(By.id("day")));
				select.selectByVisibleText("10");
				
				Thread.sleep(2000);
				
				Select select1 = new Select(driver.findElement(By.id("month")));
				select1.selectByVisibleText("Jun");
				
				Thread.sleep(2000);
				
				Select select2 = new Select(driver.findElement(By.id("year")));
				select2.selectByVisibleText("1994");
				
				Thread.sleep(2000);
				
				driver.findElement(By.name("sex")).click();
				
			}
			
		}

	}