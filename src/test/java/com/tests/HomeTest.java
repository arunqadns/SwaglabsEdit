package com.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
//	WebDriver driver;

	@Test(priority = 0)
	public void Verify_Products_Title() throws InterruptedException, FileNotFoundException, IOException, ParseException,
			org.json.simple.parser.ParseException {
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		// Assert.assertEquals(true,home.IsThisHomePage());
		Assert.assertEquals(true, home.IsProductTitleDisplaying());

	}

	@Test(priority = 1)

	public void Verify_Sort_Option() throws InterruptedException, FileNotFoundException, IOException, ParseException,
			org.json.simple.parser.ParseException {
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		// Assert.assertEquals(true,home.IsThisHomePage());
		Assert.assertEquals(true, home.IsSortOptionDisplaying());
	}

	@Test(priority = 2)
	public void Veryfy_SideMenu_open() throws InterruptedException, FileNotFoundException, IOException, ParseException,
			org.json.simple.parser.ParseException {
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		home.MenuButtonClick();
    	Assert.assertEquals(true, home.IsSideNavBarOpen());

	}

	@Test(priority = 3)
	public void Veryfy_SideMenu_close() throws InterruptedException, FileNotFoundException, IOException, ParseException,
			org.json.simple.parser.ParseException {
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		home.MenuButtonClick();
		Thread.sleep(1000);
		if (true == home.IsSideNavBarOpen()) {
			home.CloseMenuButtonClick();
		}
		Thread.sleep(1000);
		Assert.assertEquals(false, home.IsSideNavBarclose());
		// driver.close();
	}

	@Test(priority = 4)
	public void Verify_Inventory_Items_Container() throws FileNotFoundException, IOException, ParseException,
			InterruptedException, org.json.simple.parser.ParseException {
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(1000);
		boolean ww = home.InventoryContainer();
		Assert.assertEquals(ww, true);
	}

	@Test(priority = 5)
	public void Verify_Items_Price_Sort_High_To_Low() throws FileNotFoundException, IOException, ParseException,
			InterruptedException, org.json.simple.parser.ParseException {
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		boolean result = home.VerifyPriceDecendingOrder();
		Assert.assertEquals(result, true);

	}

	@Test(priority = 6)
	public void Verify_Items_Price_Sort_Low_To_High() throws FileNotFoundException, IOException, ParseException,
			InterruptedException, org.json.simple.parser.ParseException {
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		boolean result = home.VerifyPriceAcendingOrder();
		Assert.assertEquals(result, true);

	}

	@Test(priority = 7)
	public void Verify_Items_Name_Order_Acending() throws FileNotFoundException, IOException, ParseException,
			InterruptedException, org.json.simple.parser.ParseException {
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		boolean result = home.VerifyNameAcendingOrder();
		Assert.assertEquals(result, true);

	}

	@Test(priority = 8)
	public void Verify_Items_Name_Order_Decending() throws FileNotFoundException, IOException, ParseException,
			InterruptedException, org.json.simple.parser.ParseException {
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		boolean result = home.VerifyNameDecendingOrder();
		Assert.assertEquals(result, true);

	}

	@Test(priority = 9)
	public void Verify_cart_Icon_Present_or_Not() throws FileNotFoundException, IOException, ParseException,
			InterruptedException, org.json.simple.parser.ParseException {
		login.Enter_valid_username();
		login.Enter_valid_password();
		login.LoginButtonClick();
		Thread.sleep(4000);
		boolean result = home.IsCarticonDisplaying();
		System.out.println(result);
		Assert.assertEquals(result, true);
	}
	// button[normalize-space()='Open Menu']

}
