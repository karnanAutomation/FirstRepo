package pages;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import action.Baseclass;
import utility.LocatorString;
import utility.Locators;

public class APIClass extends Baseclass{

     WebDriver driver;
     Locators locators;
	public APIClass(WebDriver ldriver) throws IOException, GeneralSecurityException
	{
		this.driver =ldriver;
        this.locators = new Locators(driver); 
        locators.addCustomer_locators(); 
		locators.searchItems();

	}
    public APIClass apiLoader() throws InterruptedException
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(LocatorString.api);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorString.apiLoader)));
		String apidocumentation=getText(driver,LocatorString.apiLoader);
		Assert.assertEquals(apidocumentation, "API documentation");
		driver.close();
		driver.switchTo().window(tabs.get(0));
        return this;
    }
	public APIClass apiLoaderUS() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(LocatorString.apiUS);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorString.apiLoader)));
		String apidocumentation=getText(driver,LocatorString.apiLoader);
		Assert.assertEquals(apidocumentation, "API documentation");
		driver.close();
		driver.switchTo().window(tabs.get(0));
		return this;
	}
    


}
