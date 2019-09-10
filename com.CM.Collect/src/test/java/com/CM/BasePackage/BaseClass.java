package com.CM.BasePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

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
}
