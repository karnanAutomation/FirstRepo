package pages;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.openqa.selenium.WebDriver;
import action.Baseclass;
import utility.LocatorString;
import utility.Locators;


public class Commusoft extends Baseclass {
	
	WebDriver driver;
	Locators locators;
	public Commusoft(WebDriver ldriver) throws IOException, GeneralSecurityException
	{
		this.driver =ldriver;
		this.locators = new Locators(driver);
		locators.addCustomer_locators();
		locators.jobCreate();
		locators.invoiceCreate();
		locators.estimateCreate();
		locators.addDiaryEvent();
		locators.partsFlow();
	}
	public Customer functionStartCustomer(String testcaseName) throws IOException, GeneralSecurityException
	{
		return new Customer(driver);
	}
	public Job functionStartJob(String testcaseName) throws IOException, GeneralSecurityException
	{
		return new Job(driver);
	}
	public Estimate functionStartEstimate(String testcaseName) throws IOException, GeneralSecurityException
	{
		return new Estimate(driver);
	}
	public Invoice functionStartInvoice(String testcaseName) throws IOException, GeneralSecurityException
	{
		return new Invoice(driver);
	}
	public Diary functionStartDiary(String testcaseName) throws IOException, GeneralSecurityException
	{
		return new Diary(driver);
	}
	public Reporting functionStartReporting(String testcaseName) throws IOException, GeneralSecurityException
	{
		return new Reporting(driver);
	}
	public APIClass functionStartAPI(String testcaseName) throws IOException, GeneralSecurityException
	{
		return new APIClass(driver);
	}

	public Job addNewJob() throws IOException, GeneralSecurityException
	{
		click(driver,LocatorString.addJobbyXpath1, LocatorString.addJobbyXpath2.replace("{Customer_Number}", webcustomerno));
		return new Job(driver);
	}
	public Customer addNewPrivateCustomer() throws IOException, GeneralSecurityException
	{
		click(driver, LocatorString.NewPrivateCustomerByID, LocatorString.NewPrivateCustomerByName);
		return new Customer(driver);
	}
	public Invoice clickAddInvoice() throws IOException, GeneralSecurityException
	{
		click(driver,LocatorString.addInvoicebyXpath);
		return new Invoice(driver);
	}
	public Estimate addNewEstimate() throws IOException, GeneralSecurityException
	{
		click(driver,LocatorString.addEstimatebyXpath);//add new estimate
		return new Estimate(driver);
	}
	public Supplier functionStartSupplier(String testcaseName) throws IOException, GeneralSecurityException
	{
		return new Supplier(driver);
	}
	
	
	
	
}
