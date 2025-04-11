package pages;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;

import action.Baseclass;
import utility.LocatorString;
import utility.Locators;

public class Customer extends Baseclass{

     WebDriver driver;
     Locators locators;
	public Customer(WebDriver ldriver) throws IOException, GeneralSecurityException
	{
		this.driver =ldriver;
        this.locators = new Locators(driver); 
        locators.addCustomer_locators(); 
        locators.searchItems();
        locators.addWorkAddress();

	}
    public Customer selectTitle() throws InterruptedException
    {
        click(driver, LocatorString.titleCustomerByxPath);
        type(driver, "Mr & Mrs", LocatorString.titleChooseByxPath);
		typeEnter(driver, LocatorString.titleChooseByxPath);
        return this;
    }
    public Customer editPrivateCustomer() throws IOException
	{
		click(driver, LocatorString.customerEditByxpath2.replace("{CUSTOMER_NO}", webcustomerno),LocatorString.customerEditByxpath.replace("{CUSTOMER_NO}",  webcustomerno));
		//customerEditByxpath2
		return this;
	}
    public Customer editTitle() throws InterruptedException
    {
        click(driver, LocatorString.titleEditedCustomerByxPath); 
		click(driver,LocatorString.titleMr);
        return this;
    }
    public Customer firstName() throws InterruptedException
    {
        type(driver, "Karnan", LocatorString.firstNameByxPath, LocatorString.firstNameByxPath2);
        return this;
    }
    public Customer secondName() throws InterruptedException
    {
        type(driver, "Athisivam", LocatorString.lastNameByxPath, LocatorString.lastNameByxPath2);
        return this;
    }
    public Customer landlineNumber() throws InterruptedException
    {
        type(driver, "8248724397", LocatorString.landLineByxPath, LocatorString.landLineByxPath2);
        return this;
    }
    public Customer editLandlineNumber() throws InterruptedException
    {
        type(driver, "1111111", LocatorString.landLineByxPath3);
        return this;
    }
    public Customer mobileNumber() throws InterruptedException
    {
        type(driver, "8989898989", LocatorString.mobileByxPath, LocatorString.mobileByxPath2);
        return this;
    }
    public Customer editMobileNumber() throws InterruptedException
    {
        type(driver, "2222222", LocatorString.mobileByxPath3);
        return this;
    }
    public Customer email(String email) throws InterruptedException
    {
        type(driver, email, LocatorString.emailByxPath, LocatorString.emailByxPath2);
        return this;
    }
    public Customer editEmail() throws InterruptedException
    {
        type(driver, "edited@commusoft.com", LocatorString.emailByxPath3); 
        return this;
    }
    public Customer addressLine1() throws InterruptedException
    {
        type(driver, "Chennai", LocatorString.address1ByxPath, LocatorString.address1ByxPath2);
        return this;
    }
    public Customer editAddressLine1() throws InterruptedException
    {
        type(driver, "EditedChennai", LocatorString.address1ByxPath3);
        return this;
    }
    public Customer customerSave() throws InterruptedException
    {
        click(driver, LocatorString.customerSaveByxPath, LocatorString.customerSaveByxPath2);
        return this;
    }
    public Customer verifySave()
    {
        isElementPresent(driver, LocatorString.locationActiveByxPath2, LocatorString.locationActiveByxPath);
        return this;
    }
    public Customer getCustomerNumber() throws InterruptedException
    {
        isElementPresent(driver, LocatorString.locationActiveByxPath2, LocatorString.locationActiveByxPath);
		try {
			webcustomerno = getText(driver, LocatorString.customerNumByxpath2, LocatorString.customerNumByxpath1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Customer Number: "+webcustomerno);
        return this;
    }
    public Customer getCustomerPage() throws InterruptedException
    {
        isElementPresent(driver, LocatorString.locationActiveByxPath2, LocatorString.locationActiveByxPath);
		try {
			webcustomerpage = driver.getCurrentUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Customer Page: "+webcustomerpage);
        return this;
    }
    public Customer searchCustomer() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver, LocatorString.SearchbyXpath);
		type(driver, webcustomerno, LocatorString.SearchinputbyID);
		typeEnter(driver, LocatorString.SearchinputbyID);
        return this;
	}
    public Customer searchCustomerClick() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver, LocatorString.Customerclickbyxpath1.replace("{CUSTOMER_NO}", webcustomerno));
        return this;
	}
    public Customer workAddressTab() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.waTabbyXpath);
        return this;
	}
    public Customer workAddressButton() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.waAddbyXpath);
        return this;
	}
    public Customer workAddressName(String workAddressName) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddressName,LocatorString.waNamebyXpath);
        return this;
	}
    public Customer workAddressSurName(String workAddressSurName) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddressSurName,LocatorString.waSurNamebyXpath);
        return this;
	}
    public Customer workAddressLandline(String workAddressLandline) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddressLandline,LocatorString.waLandlinebyXpath);
        return this;
	}
    public Customer workAddressMobile(String workAddressMobile) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddressMobile,LocatorString.waMobilebyXpath);
        return this;
	}
    public Customer workAddressEmail(String workAddressEmail) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddressEmail,LocatorString.waEmailbyXpath);
        return this;
	}
    public Customer workAddressAddressLine1(String workAddressAddressLine1) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddressAddressLine1,LocatorString.waAdressbyXpath);
        return this;
	}
    public Customer workAddressSave() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.waSavebyXpath);
        return this;
	}
    public Customer getWorkAddressPage() throws InterruptedException
    {
        isElementPresent(driver, LocatorString.locationActiveByxPath2, LocatorString.locationActiveByxPath);
		try {
			webworkaddresspage = driver.getCurrentUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Customer Page: "+webworkaddresspage);
        return this;
    }
    public Customer workAddressEdit() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.waEditbyXpath);
        return this;
	}
    public Customer workAddressTitleEdit() throws IOException, GeneralSecurityException, InterruptedException
	{
		Select value = new Select(driver.findElement(By.xpath(LocatorString.waTitlebyXpath)));
		value.selectByValue("3");
        return this;
	}
    public Customer workAddressNameEdit(String workAddressName) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddressName,LocatorString.waNamebyXpath);
        return this;
	}
    public Customer workAddresslastNameEdit(String workAddresslastName) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddresslastName,LocatorString.waSurNamebyXpath);
        return this;
	}
    public Customer workAddresslandlineEdit(String workAddresslandlineEdit) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddresslandlineEdit,LocatorString.walandlineeditbyXpath);
        return this;
	}
    public Customer workAddressMobileEdit(String workAddressMobileEdit) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddressMobileEdit,LocatorString.waMobileeditbyXpath);
        return this;
	}
    public Customer workAddressEmailEdit(String workAddressEmailEdit) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddressEmailEdit, LocatorString.waEmaileditbyXpath);
        return this;
	}
    public Customer workAddressAddressEdit(String workAddressAddressEdit) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,workAddressAddressEdit, LocatorString.waAdressbyXpath);
        return this;
	}
    public Customer workAddressSaveEdit() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.waSaveeditbyXpath);
        return this;
	}
    public Customer supplierTab() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.supplierTabByxpath1);
        return this;
	}
	public Customer supplierTabUS() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.supplierTabByxpathUS);
		return this;
	}
    public Customer supplierAdd() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.AddsupplierTabByID);
        return this;
	}
    public Customer supplierName() throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,"Supplier Name",LocatorString.supplierNameByID);
        return this;
	}
    public Customer supplierEmail() throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,"karnan@commusoft.com",LocatorString.supplierEmailByID);
        return this;
	}
    public Customer supplierAdderss1() throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,"Madurai 1 ",LocatorString.supplierAddressByID);
        return this;
	}
    public Customer supplierAdderss2() throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,"Madurai 2 ",LocatorString.supplierAddress2ByID);
        return this;
	}
    public Customer supplierSave() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.supplierSaveBXpath); Thread.sleep(3000);
		LocatorString.Supplierhomepage = driver.getCurrentUrl();
        return this;
	}
    public Customer contactTab() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.addContact);
        return this;
	}
    public Customer addContact() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.addContact1);
        return this;
	}
    public Customer contactName(String contactName) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,contactName,LocatorString.contactName);
        return this;
	}
    public Customer contactSurName(String contactSurName) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,contactSurName,LocatorString.contactSurName);
        return this;
	}
    public Customer contactEmail(String email) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,email,LocatorString.contactEmail);
        return this;
	}
    public Customer contactPhone(String number) throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.contactPhoneoffice);
		click(driver,LocatorString.contactMobile);
		type(driver,number,LocatorString.contactMobileType);
		click(driver,LocatorString.contactnumber);
        return this;
	}
    public Customer saveContact() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.saveContact);
        return this;
	}
    public Customer verifyContact() throws IOException, GeneralSecurityException, InterruptedException
	{
		isElementPresent(driver,LocatorString.verifyCustomerContact);
        return this;
	}
	public Customer addNewCompany() throws InterruptedException
    {
		click(driver,LocatorString.addCompany);
        return this;
    }
	public Customer companyName(String name) throws InterruptedException
    {
		type(driver,name,LocatorString.companyName);
        return this;
    }
	public Customer companyAddress(String address) throws InterruptedException
    {
		type(driver,address,LocatorString.companyAddress);
        return this;
    }
	public Customer getCompanyPage() throws InterruptedException
    {
        isElementPresent(driver, LocatorString.locationActiveByxPath2, LocatorString.locationActiveByxPath);
		try {
			webcompanypage = driver.getCurrentUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Customer Page: "+webcompanypage);
        return this;
    }
	public Customer getCompanyNumber() throws InterruptedException
    {
        isElementPresent(driver, LocatorString.locationActiveByxPath2, LocatorString.locationActiveByxPath);
		try {
			webcompanyno = getText(driver, LocatorString.customerNumByxpath2, LocatorString.customerNumByxpath1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Customer Number: "+webcompanyno);
        return this;
    }
	public Customer editCompanyButton() throws IOException
	{
		click(driver, LocatorString.customerEditByxpath2.replace("{CUSTOMER_NO}", webcompanyno),LocatorString.customerEditByxpath.replace("{CUSTOMER_NO}",  webcompanyno));
		//customerEditByxpath2
		return this;
	}
	public Customer editCompanySaveButton() throws IOException
	{
		click(driver, LocatorString.editCompanySave);
		return this;
	}
	public Customer companyQuickLinks() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		click(driver,LocatorString.companyQuickLinks);
		return this;
	}
	public Customer deleteCompany() throws IOException, InterruptedException
	{
		click(driver,LocatorString.deleteCompany);
		Thread.sleep(2000);
		return this;
	}
	public Customer deleteConfirmationText(String confirmText) throws IOException, InterruptedException
	{
		type(driver,"Delete",LocatorString.deleteCompanyConfirmation);
		return this;
	}
	public Customer deleteCompanyButton() throws IOException, InterruptedException
	{
		click(driver,LocatorString.deleteCompanyButton);
		return this;
	}
	public Customer verifyDeleteCompany() throws IOException, InterruptedException
	{
		isElementPresent(driver,LocatorString.verifyDeleteCompany);
		return this;
	}
	public Customer addNewLL() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.addNewLL);
        return this;
	}
	public Customer titleLandLord(String title) throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver, LocatorString.titleLandLord1);
		click(driver, LocatorString.titleLandLord2.replace("{title}", title));
        return this;
	}
	public Customer nameLandlord(String name) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver, name,LocatorString.nameLandlord);
        return this;
	}
	public Customer surnameLandlord(String surName) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver, surName,LocatorString.surnameLandlord);
        return this;
	}
	public Customer addressLandlord(String address) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver, address,LocatorString.addressLandlord);
        return this;
	}
	public Customer saveLL() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver, LocatorString.saveLL);
        return this;
	}
	

	
	














    



















    public Customer addCustomer() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver, LocatorString.NewPrivateCustomerByID, LocatorString.NewPrivateCustomerByName);
		click(driver, LocatorString.titleCustomerByxPath);
		type(driver, "Mr & Mrs", LocatorString.titleChooseByxPath);
		typeEnter(driver, LocatorString.titleChooseByxPath);
        type(driver, "Karnan", LocatorString.firstNameByxPath, LocatorString.firstNameByxPath2);
		type(driver, "Athisivam", LocatorString.lastNameByxPath, LocatorString.lastNameByxPath2);
		type(driver, "8248724397", LocatorString.landLineByxPath, LocatorString.landLineByxPath2);
		type(driver, "8989898989", LocatorString.mobileByxPath, LocatorString.mobileByxPath2);
		type(driver, "karnan@commusoft.com", LocatorString.emailByxPath, LocatorString.emailByxPath2);
		type(driver, "Chennai", LocatorString.address1ByxPath, LocatorString.address1ByxPath2);
		click(driver, LocatorString.customerSaveByxPath, LocatorString.customerSaveByxPath2);
		isElementPresent(driver, LocatorString.locationActiveByxPath2, LocatorString.locationActiveByxPath);
		try {
			webcustomerno = getText(driver, LocatorString.customerNumByxpath2, LocatorString.customerNumByxpath1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Customer Number: "+webcustomerno);
        return this;
	}
    public Customer editCustomer() throws IOException, GeneralSecurityException, InterruptedException
	{
		Locators locators = new Locators(page);
		locators.addCustomer_locators();
		click(driver, LocatorString.customerEditByxpath.replace("{CUSTOMER_NO}", webcustomerno));
		click(driver, LocatorString.titleEditedCustomerByxPath); 
		click(driver,LocatorString.titleMr);
		type(driver, "FirstName", LocatorString.firstNameByxPath, LocatorString.firstNameByxPath2); 
		type(driver, "LastName", LocatorString.lastNameByxPath, LocatorString.lastNameByxPath2);
		type(driver, "1111111", LocatorString.landLineByxPath3);
		type(driver, "2222222", LocatorString.mobileByxPath3); 
		type(driver, "edited@commusoft.com", LocatorString.emailByxPath3); 
		type(driver, "EditedChennai", LocatorString.address1ByxPath3); 
		click(driver, LocatorString.customerSaveByxPath, LocatorString.customerSaveByxPath2);
		isElementPresent(driver, LocatorString.locationActiveByxPath2, LocatorString.locationActiveByxPath);
        return this;
	}




}
