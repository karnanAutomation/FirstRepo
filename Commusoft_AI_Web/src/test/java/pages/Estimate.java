package pages;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import action.Baseclass;
import utility.LocatorString;
import utility.Locators;

public class Estimate extends Baseclass{

    WebDriver driver;
    Locators locators;
    public Estimate(WebDriver ldriver) throws IOException, GeneralSecurityException
    {
        this.driver =ldriver;
        this.locators = new Locators(driver);
        locators.estimateCreate();
        locators.acceptEstimate();
    }
    public Estimate chooseDescription(String dropdownValue) throws InterruptedException, TimeoutException
    {
        selectDropdownValue(driver,dropdownValue,LocatorString.descriptionbyXpath);//choose_description
        return this;
    }
    public Estimate estimateNotes(String estimateNotes) throws InterruptedException
    {
        type(driver,estimateNotes,LocatorString.notesbyXpath);//Estimate_Notes
        return this;
    }
    public Estimate customerReference(String customerReference) throws InterruptedException
    {
        type(driver,customerReference,LocatorString.customerReferencebyXpath);//Estimate_CustomerReference
        return this;
    }
    public Estimate userGroup(String userGroup) throws InterruptedException, TimeoutException
    {
        selectDropdownValue(driver,userGroup,LocatorString.userGroupbyXpath);//Estimate_user_group
        return this;
    }
    public Estimate estiamteSave() throws InterruptedException
    {
        click(driver,LocatorString.SaveEstiamtebyXpath);//estimate save
        return this;
    }
    public Estimate priceTab() throws InterruptedException
    {
        click(driver,LocatorString.estimatepricebyXpath);//Estimate_Price_tab
        return this;
    }
    public Estimate noBreakDown() throws InterruptedException
    {
        click(driver,LocatorString.estimatenobreakdownbyXpath);//Estimate_Price_NoBreakdown
        return this;
    }
    public Estimate partsTotal(String partValue) throws InterruptedException
    {
        //Estimate_Price_NoBreakdown_PartsTotal
        Thread.sleep(1000);
		doubleClick(driver,LocatorString.pricedoubleclickbyXpath);
		type(driver,partValue,LocatorString.pricevaluebyXpath);
		typeEnter(driver,LocatorString.pricevaluebyXpath);Thread.sleep(1000);
		click(driver,LocatorString.pricedoubleclickbyXpath);	
        return this;
    }
    public Estimate estimateInvoiceSchedule() throws InterruptedException
    {
        Thread.sleep(1000);
        click(driver,LocatorString.invoiceschedulebyXpath);//Estimate_InvoiceSchedule
        return this;
    }
    public Estimate invoiceScheduleDeposit(String depositValue) throws InterruptedException
    {
        //Estimate_InvoiceSchedule_Deposite
		doubleClick(driver,LocatorString.depositbyXpath);
		type(driver,depositValue,LocatorString.depositamountbyXpath);
		typeEnter(driver,LocatorString.depositamountbyXpath);
        return this;
    }
    public Estimate invoiceScheduleCompletion(String completionValue) throws InterruptedException
    {
        //Estimate_InvoiceSchedule_Completion
		doubleClick(driver,LocatorString.estimateinvoiceschedulebyXpath);
		type(driver,completionValue,LocatorString.CompletionbyXpath);
		// Thread.sleep(1000);
		typeEnter(driver,LocatorString.CompletionbyXpath);
        return this;
    }
    public Estimate invoiceScheduleRetention(String retentionValue) throws InterruptedException
    {
        //Estimate_InvoiceSchedule_Retention
		doubleClick(driver,LocatorString.RetentionbyXpath);
		type(driver,retentionValue,LocatorString.RetentionTypebyXpath);
		// Thread.sleep(1000);
		typeEnter(driver,LocatorString.RetentionTypebyXpath);
        return this;
    }
    public Estimate sendtoCustomer() throws InterruptedException
    {
        click(driver,LocatorString.sendtocustomerbyXpath);//Estimate_SendtoCustomer
        return this;
    }
    public Estimate acceptOrreject() throws InterruptedException
    {
        //Estimate_Accept
		click(driver,LocatorString.acceptrejectbyXpath);
        return this;
    }
    public Estimate estimateCheckbox() throws InterruptedException
    {
        //Estimate_Accept
        Thread.sleep(2000);
		click(driver,LocatorString.checkboxbyXpath);Thread.sleep(1000);
        return this;
    }
    public Estimate clickestimateAccept() throws InterruptedException
    {
        click(driver,LocatorString.estimateAcceptbyXpath);
        return this;
    }
    public Estimate typeAcceptorReject(String accept_reject) throws InterruptedException
    {
        type(driver,accept_reject,LocatorString.estimateAcceptTypebyXpath);
        return this;
    }
    public Estimate clickAcceptatlast() throws InterruptedException
    {
        click(driver,LocatorString.estimateAcceptbuttonbyXpath);
        return this;
    }
    public Estimate invoiceTab() throws InterruptedException
    {
        click(driver,LocatorString.invoiceTTab);
        return this;
    }
    public Estimate rejectReason(String reason) throws InterruptedException
    {
        selectDropdown(driver, reason,LocatorString.estimateRejectReason);
        return this;
    }
    public Estimate clickestimateReject() throws InterruptedException
    {
        click(driver,LocatorString.estimateRejectbyXpath);
        return this;
    }
    public Estimate verifyestimateReject() throws InterruptedException
    {
        isElementPresent(driver, LocatorString.estimateRejectedsuccess);
        return this;
    }
    public Estimate verifyestimateAccept() throws InterruptedException
    {
        isElementPresent(driver, LocatorString.estimateAcceptsuccess);
        return this;
    }
    public Estimate verifyestimateAcceptUS() throws InterruptedException
    {
        isElementPresent(driver,LocatorString.estimateAcceptsuccess_US);
        return this;
    }
    public Estimate emailSent() throws InterruptedException
    {
        click(driver,LocatorString.emailSent);
        Thread.sleep(1000);
		click(driver,LocatorString.emailSentTo);//click on to field
		click(driver,LocatorString.emailSentToSelect);//select email
		click(driver,LocatorString.emailSentButton);//send email
        return this;
    }
    public Estimate notesTab() throws InterruptedException
    {
        click(driver,LocatorString.estimateNotes);//notes tab
        return this;
    }
    public Estimate estimatePortalLink() throws InterruptedException
    {
        driver.findElement(By.linkText("open the portal")).click();
        return this;
    }
    public Estimate estimateAcceptinPortal() throws InterruptedException
    {
       ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		click(driver,LocatorString.acceptEstimate);

		type(driver,"Addditional Comments",LocatorString.additionalComments);
		type(driver,"accept",LocatorString.typeAccept);
		click(driver,LocatorString.acceptButton);
        Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
        return this;
    }
    public Estimate estimateDetails() throws InterruptedException
    {
        click(driver,LocatorString.estimateDetails);
        return this;
    }
    public Estimate verifyEstimateAccepted() throws InterruptedException
    {
        WebElement ss = driver.findElement(By.xpath(LocatorString.verifyEstimateAccept));
		if(ss.isDisplayed()) {
			System.out.println("Estimate Accepted");
		}else {
			System.out.println("Case Failed kindly recheck");
		}
        return this;
    }
}
