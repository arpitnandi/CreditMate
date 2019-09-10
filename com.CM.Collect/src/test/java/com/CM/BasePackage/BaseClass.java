package com.CM.BasePackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.google.common.io.Files;

public class BaseClass 
{
	protected WebDriver D;
	
	@Parameters({"LanguageBinder","Application"})
	@BeforeClass
	public void launchBrowser(String LanguageBinder,String Application)
	{
		System.setProperty("webdriver.chrome.driver", LanguageBinder);
		D = new ChromeDriver();
		D.get(Application);
		D.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Parameters({"Interface","UserType","Credentials"})
	@BeforeMethod
	public void loginUser(String Interface,String UserType,String Credintials)
	{
		
	}
	
	@AfterMethod
	public void close()
	{
		D.close();
	}
	
	@AfterSuite
	private void takeReports(String ID, String Results) throws IOException 
	{
		File Test = new File("C:\\Eclps_Projects\\Maven_Projects\\CreditMate\\com.CM.Collect\\test-output\\Suite\\Test.html");
		File Index = new File("C:\\Eclps_Projects\\Maven_Projects\\CreditMate\\com.CM.Collect\\test-output\\Index.html");
		File Emailable = new File("C:\\Eclps_Projects\\Maven_Projects\\CreditMate\\com.CM.Collect\\test-output\\emailable-report.html");
		
		//Default Results Location.
		Results = "C:\\Eclps_Projects\\Maven_Projects\\CreditMate\\com.CM.Collect\\src\\test\\resources\\com\\CM"; 
		
		Files.copy(Test, new File(Results+"Test_Report"+ID+".html"));
		Files.copy(Index, new File(Results+"Index_Report"+ID+".html"));
		Files.copy(Emailable, new File(Results+"Emailable_Report"+ID+".html"));
		
		D.quit();
	}
}
