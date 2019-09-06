package com.CM.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.CM.BasePackage.BaseClass;

public class Test_00 extends BaseClass
{
	@Parameters({"UN","PW"})
	@Test
	public static void login(String UN, String PW)
	{
		D.findElement(By.name("email")).sendKeys(UN);
		D.findElement(By.name("password")).sendKeys(PW);
		D.findElement(By.xpath("//button[text()='Sign In']")).click();
		D.findElement(By.xpath("//a[text()='Arpit Nandi']")).click();
		D.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	}
}
