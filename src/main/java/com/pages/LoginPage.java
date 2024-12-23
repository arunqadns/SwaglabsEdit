package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utilities.Utilities;


public class LoginPage {
//  STATIC VARIABLES   Send keys vechu username,password nalkiyirunnathu ozhivakki ingane variable aayi nalki.benefit enthengilum changes undengil ivde change aaaakiyal mathi.
//	String validUserName="standard_user";
//	String validPassword="secret_sauce";	
	//lOGIN PAGE WEBELEMENTS
	By LOGINBUTTON=By.id("login-button");
	By USERNAMEFEILD=By.id("user-name");
	By PASSWORDFIELD=By.id("password");
	By ERROR_TOAST=By.xpath("//h3[@data-test='error']");
	By MENU_BUTTON=By.xpath("//button[normalize-space()='Open Menu']");
	By USERNAME_FEILD=By.name("user-name");
	By PASSWORD_FEILD=By.name("password");
	By MENU_ICON=By.xpath("//*[name()='path' and contains(@fill,'currentCol')]");
	By LOGOUTBUTTON=By.id("logout_sidebar_link");
	
	String LOGINPAGEURL="https://www.saucedemo.com/v1/";
		
	WebDriver driver; //INITIALISING WEB DRIVER
	
	
	public LoginPage(WebDriver driver1)//CONSTRUCTOR
	{
		this.driver=driver1;
	}
	
	
	public void Enter_valid_username() throws FileNotFoundException, IOException, ParseException, java.text.ParseException, org.json.simple.parser.ParseException
	{
		//driver.findElement(By.name("user-name")).sendKeys(validUserName);  //ivde hard core aayi aanu username koduthath
//		Utilities.enterText(driver, USERNAME_FEILD, validUserName);  hard core matti "validUserNam" enna Static variablil koduthu.
		Utilities.enterText(driver, USERNAME_FEILD, Utilities.readJsonFIle("validusername","./src/main/resources/login.json")); //valid username oru JSON file il ezhuthi vechitund.ippolavide ninnum read cheyyunnu.
		
	}
	public void Enter_valid_password() throws FileNotFoundException, IOException, ParseException, java.text.ParseException, org.json.simple.parser.ParseException
	{
		
		Utilities.enterText(driver, PASSWORD_FEILD, Utilities.readJsonFIle("validpassword","./src/main/resources/login.json")); 
		
	}
	
	public void Enter_invalid_username() throws FileNotFoundException, IOException, ParseException, java.text.ParseException, org.json.simple.parser.ParseException
	{
		
		Utilities.enterText(driver, USERNAME_FEILD, Utilities.readJsonFIle("invalidusername","./src/main/resources/login.json")); 
	}
	
	public void Enter_invalid_password() throws FileNotFoundException, IOException, ParseException, java.text.ParseException, org.json.simple.parser.ParseException
	{

		Utilities.enterText(driver, PASSWORD_FEILD, Utilities.readJsonFIle("invalidpassword","./src/main/resources/login.json")); 
		
	}
	public void LoginButtonClick()
	{
		Utilities.clickElement(driver, LOGINBUTTON);
	}
	
	
	public boolean IsThisLoginPage()
	{
		boolean result=false;
		if(driver.getCurrentUrl().equalsIgnoreCase(LOGINPAGEURL))
		{
			
			result=true;
		}
		return result;
	}
	
	
	
	public boolean IsLoginButtonDisplayed() throws InterruptedException
	{	
		//return driver.findElement(LOGINBUTTON).isDisplayed();
		return Utilities.isElementDisplayed(driver, LOGINBUTTON);	
	}
	
	public boolean IsUsernameFieldsDisplayed() throws InterruptedException
	{	
		return Utilities.isElementDisplayed(driver, USERNAMEFEILD);	
	}

	public boolean IsPasswordFieldsDisplayed() throws InterruptedException
	{	
		return Utilities.isElementDisplayed(driver, PASSWORDFIELD);	
	}
		
	public String GetErrorToastMessage() throws InterruptedException
	{	
		return Utilities.getTextValue(driver, ERROR_TOAST);	
	}

	
	
	public void MenuButtonClick()
	{	
		Utilities.clickElement(driver, MENU_BUTTON);
	}
	
	public void LogOutButtonClick()
	{
		Utilities.clickElement(driver, LOGOUTBUTTON);
	}
		

//	public boolean loginWithValidCredentialsFromExcel() throws InterruptedException, FileNotFoundException, IOException, ParseException
//	{
////		Enter_valid_username();
//		//Utilities.enterText(driver, USERNAME_FEILD, validUserName);  
//        Enter_valid_username();  //pakaram alredy mukalil ullla valid password enter cheyyunnathinulla method call cheyyikunnu.
////		Enter_valid_password();	
////		Utilities.enterText(driver, PASSWORD_FEILD, validPassword);
//		Enter_valid_password();	//pakaram alredy mukalil ullla valid password enter cheyyunnathinulla method call cheyyikunnu.
////		driver.findElement(LOGINBUTTON).click();
//		LoginButtonClick();
//
//	
//		Thread.sleep(1000);
//		String expectedUrl="https://www.saucedemo.com/v1/inventory.html";
//        String actualUrl= driver.getCurrentUrl();
//        System.out.println(expectedUrl+"="+actualUrl);
//        Boolean flag=true;
//        if (actualUrl.equalsIgnoreCase(expectedUrl))
//        {
//        	flag=true;
//        }
//        else
//        {
//        	flag=false;
//        }
//        	
//		return flag;
//				
//	}
	
	
//Data Read From Excel	
		public void loginWithExcelTest() throws IOException, InterruptedException, ParseException
		{
			FileInputStream input = new FileInputStream("./src/main/resources/credentials1.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(input);
			XSSFSheet sh=wb.getSheet("Sheet1");

		    for (int i=0; i<=sh.getLastRowNum();i++) 
		    {
	        driver.findElement(USERNAME_FEILD).clear();
	        String Value1=String.valueOf(sh.getRow(i).getCell(0).getStringCellValue());
	        String Value11=Value1.strip();
	        driver.findElement(USERNAME_FEILD).sendKeys(Value11);
			        
			        		       
	        driver.findElement(PASSWORD_FEILD).clear();
        	String Value2=String.valueOf(sh.getRow(i).getCell(1).getStringCellValue());
	        String Value22=Value2.strip();

	        driver.findElement(PASSWORD_FEILD).sendKeys(Value22);
	        driver.findElement(LOGINBUTTON).click();

	        Thread.sleep(4000);

	        String expectedUrl="https://www.saucedemo.com/v1/inventory.html";
	        String actualUrl= driver.getCurrentUrl();

	        if (actualUrl.equalsIgnoreCase(expectedUrl)) 
	        {
            sh.getRow(i).createCell(2).setCellValue("pass");
    		} 
	        else {

            sh.getRow(i).createCell(2).setCellValue("fail");
		        }
	        FileOutputStream output = new FileOutputStream("./src/main/resources/credentials.xlsx");
	        wb.write(output);
	        output.close(); // close the FileOutputStream
	        driver.get("https://www.saucedemo.com/v1/");
		    input.close(); // close the FileInputStream			
}
	}

}
