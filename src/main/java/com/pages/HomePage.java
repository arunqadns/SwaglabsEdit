package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilities.Utilities;

public class HomePage {
	
	By HOMEPAGE_APPLOGO=By.xpath("//div[@class='app_logo']");
	By SORT_OPTION=By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/select[1]");
	By PRODUCT_TITLE=By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]");
	By CLOSE_MENU_ICON=By.xpath("//button[normalize-space()='Close Menu']");
	By ABOUTSIDEBAR_LINK=By.xpath("//a[@id='about_sidebar_link']");
	By INVENTORY_CONTAINER=By.id("inventory_container");
	By MENU_ICON=By.cssSelector("div[class='bm-burger-button'] button");
	By LOGOUTBUTTON=By.id("logout_sidebar_link");
	By CART_ICON=By.cssSelector("path[fill='currentColor']");
	
	WebDriver driver;
	String HOMEPAGEURL="https://www.saucedemo.com/v1/inventory.html";
	
	
	public HomePage(WebDriver driver)//constructor
	{
		this.driver=driver;	
	}
	
	
	
	public boolean IsProductTitleDisplaying() throws InterruptedException
	{
		//return driver.findElement(HOMEPAGE_APPLOGO).isDisplayed();
		return Utilities.isElementDisplayed(driver, PRODUCT_TITLE);
	}
	
	public boolean IsCarticonDisplaying()
	{
		//return driver.findElement(MENU_ICON).isDisplayed();
		return Utilities.isElementDisplayed(driver, CART_ICON);
	}
	
	public boolean IsSortOptionDisplaying()
	{
		//return driver.findElement(MENU_ICON).isDisplayed();
		return Utilities.isElementDisplayed(driver,SORT_OPTION);
	}
	
	public void MenuButtonClick()
	{	
		Utilities.clickElement(driver, MENU_ICON);
	}
	
	public void CloseMenuButtonClick()
	{	
		Utilities.clickElement(driver, CLOSE_MENU_ICON);
	}
	
	
	public boolean IsThisHomePage()
	{
		boolean result=false;
		if(driver.getCurrentUrl().equalsIgnoreCase(HOMEPAGEURL))
		{
			result=true;
		}
		return result;
	}
	

	public boolean IsSideNavBarOpen() throws InterruptedException
	{
		Thread.sleep(1000);
		return Utilities.isElementDisplayed(driver, ABOUTSIDEBAR_LINK);
		
	}
	
	public boolean IsSideNavBarclose() throws InterruptedException
	{
		
		return Utilities.isElementDisplayed(driver, ABOUTSIDEBAR_LINK);
	}
	
	public boolean InventoryContainer() throws InterruptedException
	{
		Thread.sleep(2000);
		//return driver.findElement(ABOUTSIDEBAR_LINK).isDisplayed();
		return Utilities.isElementDisplayed(driver, INVENTORY_CONTAINER);	
	}
	
	
	public boolean VerifyPriceDecendingOrder()
	{
		//1. before filter capture the prices
		List<WebElement> beforeFilterPrice = driver.findElements (By.className("inventory_item_price"));
		System.out.println(beforeFilterPrice);
		//2. remove the $ symbol from the price and convert the string into double
		List<Double> beforeFilterPriceList = new ArrayList<>();
		for (WebElement p: beforeFilterPrice) {
		beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
		}
		//3. filter the price from the dropdown
		Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
		dropdown.selectByValue("hilo");
		//4. after filter capture the prices
		List<WebElement> afterFilterPrice = driver.findElements (By.className("inventory_item_price"));
	
		//5. remove the $ symbol from the price and convert the string into double
		List<Double> afterFilterPriceList = new ArrayList<>();
		for (WebElement p: afterFilterPrice) {
		afterFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
		}
		//6. compare the values/Assert the values (first we need to sort the values of before filtered values)
		Collections.sort (beforeFilterPriceList); // list will get sorted in the form of ascending order
		Collections.reverse (beforeFilterPriceList); // list will get sorted in the form of descending order
		
		System.out.println(beforeFilterPriceList);
		System.out.println(afterFilterPriceList);
		
		if(beforeFilterPriceList.equals(afterFilterPriceList))
		{
			return true;
		}
		else
		{
			return false;
		}

		}
	
	
	public boolean VerifyPriceAcendingOrder()
	{
		//1. before filter capture the prices
		List<WebElement> beforeFilterPrice = driver.findElements (By.className("inventory_item_price"));
		System.out.println(beforeFilterPrice);
		//2. remove the $ symbol from the price and convert the string into double
		List<Double> beforeFilterPriceList = new ArrayList<>();
		for (WebElement p: beforeFilterPrice) {
		beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
		}
		//3. filter the price from the dropdown
		Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
//		dropdown.selectByVisibleText("Price (high to low)");
		dropdown.selectByValue("lohi");
		//4. after filter capture the prices
		List<WebElement> afterFilterPrice = driver.findElements (By.className("inventory_item_price"));
	
		
		//5. remove the $ symbol from the price and convert the string into double
		List<Double> afterFilterPriceList = new ArrayList<>();
		for (WebElement p: afterFilterPrice) {
		afterFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
		}
		//6. compare the values/Assert the values (first we need to sort the values of before filtered values)
		Collections.sort (beforeFilterPriceList); // list will get sorted in the form of ascending order

		
		System.out.println(beforeFilterPriceList);
		System.out.println(afterFilterPriceList);
		
		if(beforeFilterPriceList.equals(afterFilterPriceList))
		{
			System.out.println("true");
			return true;	
		}
		else
		{
			System.out.println("false");
			return false;		
		} 
		}
		
	
	
	public boolean VerifyNameAcendingOrder()
	{
		//1. before filter capture the prices
		List<WebElement> beforeSortByName = driver.findElements (By.className("inventory_item_name"));
   		//2. convert to string 
		List<String> beforeSortByNameList = new ArrayList<>();
		for (WebElement p: beforeSortByName) {
			beforeSortByNameList.add(String.valueOf(p.getText()));
		}
		//3. filter the price from the dropdown
		Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
		dropdown.selectByValue("az");
		//4. after filter by name accending
		List<WebElement> afterSortByName = driver.findElements (By.className("inventory_item_name"));
	
		List<String> afterSortByNameList = new ArrayList<>();
		for (WebElement p: afterSortByName) {
			afterSortByNameList.add(String.valueOf(p.getText()));
			}
		//6. compare the values/Assert the values (first we need to sort the values of before filtered values)
		Collections.sort(beforeSortByNameList); // list will get sorted in the form of ascending order
		
		System.out.println(beforeSortByNameList);
		System.out.println(afterSortByNameList);
		
		if(beforeSortByNameList.equals(afterSortByNameList))
		{
			System.out.println("true");
			return true;	
		}
		else
		{
			System.out.println("false");
			return false;
		}
		}
	public boolean VerifyNameDecendingOrder()
	{
		//1. before filter capture the prices
		List<WebElement> beforeSortByName = driver.findElements (By.className("inventory_item_name"));
   		//2. convert to string 
		List<String> beforeSortByNameList = new ArrayList<>();
		for (WebElement p: beforeSortByName) {
			beforeSortByNameList.add(String.valueOf(p.getText()));
		}
		//3. filter the price from the dropdown
		Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
		dropdown.selectByValue("za");
		//4. after filter by name Decending
		List<WebElement> afterSortByName = driver.findElements (By.className("inventory_item_name"));
	
		List<String> afterSortByNameList = new ArrayList<>();
		for (WebElement p: afterSortByName) {
			afterSortByNameList.add(String.valueOf(p.getText()));
			}
		//6. compare the values/Assert the values (first we need to sort the values of before filtered values)
		Collections.sort(beforeSortByNameList); // list will get sorted in the form of ascending order

		Collections.reverse (beforeSortByNameList); // list will get sorted in the form of descending order
		
		System.out.println(afterSortByNameList);
		System.out.println(beforeSortByNameList);
		
		if(beforeSortByNameList.equals(afterSortByNameList))
		{
			System.out.println("true");
			return true;	
		}
		else
		{
			System.out.println("false");
			return false;
		}
		}	

}
