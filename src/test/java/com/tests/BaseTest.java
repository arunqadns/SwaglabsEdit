package com.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.configurations.Base;
import com.pages.HomePage;
import com.pages.LoginPage;

public class BaseTest extends Base {
//WebDriver driver;
	LoginPage login;
	HomePage home;
	//----------------------
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws IOException
	{
//		driver=new ChromeDriver();
//		driver.get("https://www.saucedemo.com/v1/");
//		driver.manage().window().maximize();
		
		initialisation(browser);// mukalil kaanunnathellam initialisation enna Method Base clasil koduthu.
		 login= new LoginPage(driver);
		 home= new HomePage(driver);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}
}
