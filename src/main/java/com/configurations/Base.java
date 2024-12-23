package com.configurations;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utilities.Utilities;

public class Base {
	
public static WebDriver driver;
	
	public static void initialisation(String browser) throws IOException
	{
	//cmd vazhi >mvn clean test -D browsername="eg.firefox" koduthal fire foxil run aavum.
		
		//XML test suite run cheyyanum ithu vazhi pattum.
//		String browser=System.getProperty("browsername","edge");//ivde chrome matti "fire fox" koduthal athil run aavum.
	
//		String browser=System.getProperty("browsername",Utilities.getPropertiesFileValue("browser"));
		
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("invalid option");
		}
		
		
		driver.get(Utilities.getPropertiesFileValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	

}
