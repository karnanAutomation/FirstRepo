package pages;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.openqa.selenium.WebDriver;

import action.Baseclass;
import utility.LocatorString;
import utility.Locators;


public class LoginPage extends Baseclass {
	
	WebDriver driver;
	@SuppressWarnings("static-access")
	public LoginPage(WebDriver ldriver)
	{
		this.driver =ldriver;
	}
	
	public void seleniumLogin(String clientID,String username,String pass ) throws InterruptedException, IOException, GeneralSecurityException {

		Locators locators = new Locators(page);
		locators.loginpage_locators();	
		
		//implementation
		click(driver,LocatorString.clientIDByName, LocatorString.clientIDByID);
		type(driver,clientID,LocatorString.clientIDByName, LocatorString.clientIDByID, LocatorString.clientIDBycssSelector); 
		click(driver, LocatorString.UserNameByName, LocatorString.UserNameByID);
		type(driver, username,LocatorString.UserNameByID, LocatorString.UserNameByName);
		click(driver, LocatorString.PasswordByName, LocatorString.PasswordByID);
		type(driver, pass,LocatorString.PasswordByName, LocatorString.PasswordByID);
		click(driver, LocatorString.LoginByXpath, LocatorString.LoginByID);
		isElementPresent(driver, LocatorString.NewPrivateCustomerByID,LocatorString.NewPrivateCustomerByName);
		seleniumhomepage = driver.getCurrentUrl();		
	}
	
	public void playLogin(String clientID, String password) throws IOException, GeneralSecurityException
	{
		Locators locators = new Locators(page);
		locators.loginpage_locators();
		//implementation
		click(page,LocatorString.clientIDByName, LocatorString.clientIDByID);
		type(page,clientID,LocatorString.clientIDByName, LocatorString.clientIDByID, LocatorString.clientIDBycssSelector); 
		click(page, LocatorString.UserNameByName, LocatorString.UserNameByID);
		type(page, "play",LocatorString.UserNameByID, LocatorString.UserNameByName);
		click(page, LocatorString.PasswordByName, LocatorString.PasswordByID);
		type(page, password,LocatorString.PasswordByName, LocatorString.PasswordByID);
		click(page, LocatorString.LoginByXpath, LocatorString.LoginByID);
		isElementPresent(page, LocatorString.NewPrivateCustomerByID,LocatorString.NewPrivateCustomerByName);
		playwrighthome = page.url();
		//System.out.println("playwrighthome------->"+playwrighthome);
	}
	
	
}
