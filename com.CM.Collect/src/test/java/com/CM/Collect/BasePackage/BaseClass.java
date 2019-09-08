package com.CM.Collect.BasePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass 
{
	protected WebDriver D;
	
	@Parameters("LanguageBinder")
	@BeforeTest
	public void launchBrowser(String LanguageBinder)
	{
		System.setProperty("webdriver.chrome.driver", LanguageBinder);
		D = new ChromeDriver();
		D.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Parameters("Application")
	@BeforeMethod
	public void loadApplication(String Application)
	{
		D.navigate().to(Application);;
	}
	
	@AfterSuite
	public void close()
	{
		D.close();
	}
}
