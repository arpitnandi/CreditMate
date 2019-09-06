package com.CM.BasePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass 
{
	protected static WebDriver D;
	
	@Parameters("LanguageBinder")
	@BeforeTest
	public static void launchBrowser(String LanguageBinder)
	{
		System.setProperty("WebDriver.Chrome.Driver", LanguageBinder);
		D = new ChromeDriver();
		D.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Parameters("Application")
	@BeforeClass
	public static void launchApplication(String Application)
	{
		D.get(Application);
	}
	
	@AfterClass
	public static void close()
	{
		D.close();
	}
}
