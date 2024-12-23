package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utilities {
	
	public static boolean isElementDisplayed(WebDriver driver,By byLocator)
	{
		return driver.findElement(byLocator).isDisplayed();	

	}
	
	public static void clickElement(WebDriver driver,By byLocator)
	{
		driver.findElement(byLocator).click();	
	}
	
	public static String getTextValue(WebDriver driver,By byLocator)
	{
		return driver.findElement(byLocator).getText();	
	}
	

	
	
	
	public static void enterText(WebDriver driver,By byLocator,String value)
	{
		driver.findElement(byLocator).clear();
		driver.findElement(byLocator).sendKeys(value);
	}
	
	//--------------------
	public static String getPropertiesFileValue(String PropertyName) throws IOException
	{// /src/main/resources ile config.properties file il nalkiyirikunna data read cheyyan.
		
		String PropertyValue;
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("./src/main/resources/config.properties");
		prop.load(fis);
		PropertyValue=prop.getProperty(PropertyName);
		return PropertyValue;
		
	}
	
	public static String readJsonFIle(String nodeValue,String filePath) throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException
	{// /src/main/resources ile login.json file il nalkiyirikunna data read cheyyan.
		String value;
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader(filePath));
		JSONObject jsonObject=(JSONObject) obj;
		value=(String) jsonObject.get(nodeValue);	
		return value;
		
	}

}
