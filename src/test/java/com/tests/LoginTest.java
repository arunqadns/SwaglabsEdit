package com.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	//Check Login Functionality

		@Test(priority=0)
		public void Verify_loginButton_Displaying() throws InterruptedException {
			//ivde login page ile Method vilikunnu athinu munp login paginte 
			//object creat cheyyunnund athu BaseTest classil Befor methodil koduthitund.
			Thread.sleep(3000);
			Assert.assertEquals(true,login.IsLoginButtonDisplayed());
		}
		@Test(priority=1)
		public void UsernameField_Displaying() throws InterruptedException {
			Thread.sleep(3000);
			Assert.assertEquals(true,login.IsUsernameFieldsDisplayed());
		}

		@Test(priority=2)
		public void PasswordField_Displaying() throws InterruptedException {
			Thread.sleep(3000);
			Assert.assertEquals(true,login.IsPasswordFieldsDisplayed());
		}


		@Test(priority=3)
		public void login_With_Valid_Credentials() throws InterruptedException, FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException
		{
			login.Enter_valid_username();
			login.Enter_valid_password();
			login.LoginButtonClick();
			Thread.sleep(1000);
			Assert.assertEquals(true,home.IsThisHomePage());	
		}

		@Test(priority=4)
		public void login_With_Invalid_Credentials() throws InterruptedException, FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException
		{
			login.Enter_invalid_username();
			login.Enter_invalid_password();
			login.LoginButtonClick();
			Thread.sleep(1000);
			Assert.assertEquals(true,login.IsThisLoginPage());	
		}


		@Test(priority=5)
		public void Login_With_Invalid_UserName_And_Valid_Password() throws InterruptedException, FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException
		{
			login.Enter_invalid_username();
			login.Enter_valid_password();
			login.LoginButtonClick();
			Thread.sleep(1000);
			Assert.assertEquals(true,login.IsThisLoginPage());	
		}	

		@Test(priority=6)
		public void Login_With_ValidUserName_And_Invalid_Password() throws InterruptedException, FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException
		{
			login.Enter_invalid_username();
			login.Enter_valid_password();
			login.LoginButtonClick();
			Thread.sleep(1000);
			Assert.assertEquals(true,login.IsThisLoginPage());	
		}
		//	Display login error messages	
		@Test(priority=7)
		public void Press_login_Button_Without_Enter_Credentials_Alert() throws InterruptedException
		{
			login.LoginButtonClick();
			String alertMessage=login.GetErrorToastMessage();
			Assert.assertEquals(alertMessage, "Epic sadface: Username is required");
		}

		@Test(priority=8)
		public void Press_login_Button_Without_UserName_With_Password_Alert() throws InterruptedException, FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException
		{

			login.Enter_invalid_password();
			login.LoginButtonClick();
			String alertMessage=login.GetErrorToastMessage();
			Assert.assertEquals(alertMessage, "Epic sadface: Username is required");
		}

		@Test(priority=9)
		public void Press_login_Button_With_UserName_Without_Password_Alert() throws InterruptedException, FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException
		{
			login.Enter_invalid_username();
			login.LoginButtonClick();
			String alertMessage=login.GetErrorToastMessage();
			Assert.assertEquals(alertMessage, "Epic sadface: Password is required");
		}

		@Test(priority=10)
		public void Press_login_Button_With_Invalid_UserName_Invalid_Password_Alert() throws InterruptedException, FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException
		{
			login.Enter_valid_username();
			login.Enter_invalid_password();
			login.LoginButtonClick();
			String alertMessage=login.GetErrorToastMessage();
			Assert.assertEquals(alertMessage, "Epic sadface: Username and password do not match any user in this service");
		}	



		@Test(priority=11)
		public void Verify_LogOut_Button() throws InterruptedException, FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException
		{
			login.Enter_valid_username();
			login.Enter_valid_password();
			login.LoginButtonClick();
			Thread.sleep(2000);
			login.MenuButtonClick();
			Thread.sleep(2000);
			login.LogOutButtonClick();
			Thread.sleep(2000);
			Assert.assertEquals(true,login.IsLoginButtonDisplayed());	
		}	


		@Test(priority=12)
		public void login_With_Excel_Credentials() throws InterruptedException, FileNotFoundException, IOException, ParseException
		{
			login.loginWithExcelTest();
			Assert.assertEquals(true,true);	
		}

}
