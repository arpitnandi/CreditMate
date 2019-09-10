package com.CM.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.CM.BasePackage.BaseClass;

public class Test_00_Login_Test extends BaseClass
{
	@Parameters({"UN","PW"})
	@Test
	public void creditmateLogin(String UN, String PW)
	{
		D.findElement(By.xpath("//a[contains(text(),'Login as')]")).click();
		D.findElement(By.xpath("//a[@class='dropdown-item'][text(),'CreditMate']")).notify();
		D.findElement(By.name("email")).sendKeys(UN);
		D.findElement(By.name("password")).sendKeys(PW);
		D.findElement(By.xpath("//button[text()='Sign In']")).click();
		D.findElement(By.xpath("//a[contains(@class,'logged-user')]/span")).click();
		D.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	}
	
	@Parameters({"UN","PW"})
	@Test
	public void lenderLogin(String UN, String PW)
	{
		D.findElement(By.xpath("//a[contains(text(),'Login as')]")).click();
		D.findElement(By.xpath("//a[@class='dropdown-item'][text(),'Lender']")).click();
		D.findElement(By.name("email")).sendKeys(UN);
		D.findElement(By.name("password")).sendKeys(PW);
		D.findElement(By.xpath("//button[text()='Sign In']")).click();
		D.findElement(By.xpath("//a[contains(@class,'logged-user')]/span")).click();
		D.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	}
	
	@Parameters({"UN","PW"})
	@Test
	public void collectionAgencygencyLogin(String UN, String PW)
	{
		D.findElement(By.xpath("//a[contains(text(),'Login as')]")).click();
		D.findElement(By.xpath("//a[@class='dropdown-item'][text()='Collection Agency']")).click();
		D.findElement(By.name("email")).sendKeys(UN);
		D.findElement(By.name("password")).sendKeys(PW);
		D.findElement(By.xpath("//button[text()='Sign In']")).click();
		D.findElement(By.xpath("//a[contains(@class,'logged-user')]/span")).click();
		D.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	}
	
	@Parameters({"UN","PW"})
	@Test
	public void partnerLogin(String UN, String PW)
	{
		D.findElement(By.xpath("//a[contains(text(),'Login as')]")).click();
		D.findElement(By.xpath("//a[@class='dropdown-item'][text(),'Partner']")).click();
		D.findElement(By.name("email")).sendKeys(UN);
		D.findElement(By.name("password")).sendKeys(PW);
		D.findElement(By.xpath("//button[text()='Sign In']")).click();
		D.findElement(By.xpath("//a[contains(@class,'logged-user')]/span")).click();
		D.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	}
}
