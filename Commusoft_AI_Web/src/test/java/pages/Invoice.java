package pages;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import action.Baseclass;
import utility.LocatorString;
import utility.Locators;

public class Invoice extends Baseclass{

    WebDriver driver;
     Locators locators;
    public Invoice(WebDriver ldriver) throws IOException, GeneralSecurityException
    {
        this.driver =ldriver;
        this.locators = new Locators(driver); 
        locators.addCustomer_locators(); 
        locators.searchItems();
        locators.invoiceCreate();
        locators.paymentCreate();

    }
    public Invoice clickAddInvoice() throws IOException, GeneralSecurityException
	{
		click(driver,LocatorString.addInvoicebyXpath);
		return new Invoice(driver);
	}
    public Invoice invoiceType(String type) throws InterruptedException
    {
        selectDropdown(driver,type,LocatorString.invoiceTypebyXpath);
        Thread.sleep(1000);
        return this;
    }
    public Invoice copyfromJD() throws InterruptedException
    {
        click(driver,LocatorString.copyfromJDbyXpath);
        return this;
    }
    public Invoice userGroup() throws InterruptedException, TimeoutException
    {
        selectDropdownValue(driver,"1",LocatorString.usergroupbyXpath);
        return this;
    }
    public Invoice invoiceCategory() throws InterruptedException, TimeoutException
    {
        Thread.sleep(1000);
        selectDropdownByIndex(driver,1,LocatorString.invoicecategorybyXpath);
        return this;
    }
    public Invoice subTotal(String value) throws InterruptedException
    {
        type(driver,value,LocatorString.subtotalbyXpath);
        return this;
    }
    public Invoice saveInvoice() throws InterruptedException
    {
        Thread.sleep(1000);
        click(driver, LocatorString.saveInvoicebyXpath);
        return this;
    }
    public Invoice emailCheckBox() throws InterruptedException
    {
        click(driver,LocatorString.invoiceEmailCheckbox);
        return this;
    }
    public Invoice verifyInvoiceRasied()
    {
        isElementPresent(driver, LocatorString.verifyInvoicedbyXpath);
        LocatorString.invoicepage=driver.getCurrentUrl();
        return this;
    }
    public Invoice verifyInvoiceRasiedwithEmail()
    {
        isElementPresent(driver, LocatorString.verifyInvoicedEmailbyXpath);
        LocatorString.invoicepage=driver.getCurrentUrl();
        return this;
    }
    public Invoice fullBreakdownbyCategory()
    {
        click(driver,LocatorString.fullbreakdownbycategorybyXpath);
        return this;
    }
    public Invoice Labour(String name) throws InterruptedException
    {
        doubleClick(driver, LocatorString.labourbyXpath);
        type(driver, name, LocatorString.labourNamebyXpath);
        Thread.sleep(1000);
		typeEnter(driver,LocatorString.labourNamebyXpath);
        return this;
    }
    public Invoice labourPrice(String number) throws InterruptedException
    {
        doubleClick(driver,LocatorString.labourvaluebyXpath); 
		type(driver,number,LocatorString.labourvalueEnterbyXpath);
        return this;
    }
    public Invoice parts(String name) throws InterruptedException
    {
        doubleClick(driver,LocatorString.partbyXpath);
        type(driver,name,LocatorString.partNamebyXpath);Thread.sleep(1000);
        typeEnter(driver,LocatorString.partNamebyXpath);
        return this;
    }
    public Invoice emailInvoice() throws InterruptedException {
        // emailinvoice
        Thread.sleep(2000);
        click(driver, LocatorString.emailInvoicebyXpath);
        click(driver,LocatorString.emailInvoiceToAddressbyXpath, LocatorString.emailInvoiceToAddressbyCSS,".input#s2id_autogen23");
        click(driver, LocatorString.emailInvoiceToselectbyXpath);
        click(driver, LocatorString.emailSentbyXpath);
        return this;
    }
    public Invoice printInvoice() throws InterruptedException {
        //printinvoice
        Thread.sleep(1000);
		click(driver, LocatorString.printInvoicebyXpath);
		clickAndCloseNewTab(driver, LocatorString.printInvoicebuttonbyXpath);
        return this;
    }
    public Invoice invoicePayment(String paymentDes , String paymentAmount) throws InterruptedException, TimeoutException {
        // payment start
        Thread.sleep(2000);
        click(driver, LocatorString.paymentbyXpath);
        type(driver, paymentDes, LocatorString.paymentDescriptionbyXpath);
        selectDropdownValue(driver, "4", LocatorString.paymentMethodbyXpath);
        selectDropdownByIndex(driver, 1, LocatorString.nominalAccountbyXpath);
        type(driver, paymentAmount, LocatorString.paymentAmountbyXpath);
        click(driver, LocatorString.savePaymentbyXpath);
        isElementPresent(driver, LocatorString.verifyPaymentRaised);
        return this;
    }
    public Invoice editInvoicebutton() throws InterruptedException {
        //edit Invoice
		click(driver,LocatorString.invoiceEditbyXpath);
        return this;
    }
    public Invoice editInvoiceDescription(String Des) throws InterruptedException {
        //edit Invoice
        Thread.sleep(2000);
		type(driver,Des,LocatorString.invoiceDesEditbyXpath);
        return this;
    }
    public Invoice editInvoiceCategory() throws InterruptedException, TimeoutException
    {
//        selectDropdownValue(driver,"2",LocatorString.invoicecategorybyXpath);
        selectDropdownByIndex(driver,2,LocatorString.invoicecategorybyXpath);
        Thread.sleep(1000);
        return this;
    }
    public Invoice editUserGroup() throws InterruptedException, TimeoutException
    {
        selectDropdownValue(driver,"2",LocatorString.usergroupbyXpath);
        selectDropdownByIndex(driver,2,LocatorString.usergroupbyXpath);
        return this;
    }
    public Invoice invoicebreakdownEdit() throws InterruptedException, TimeoutException
    {
        click(driver,LocatorString.invoicebreakdownEditbyXpath);
        return this;
    }
    public Invoice invoiceFullbreakdown() throws InterruptedException, TimeoutException
    {
        click(driver,LocatorString.fullbreakdownbyXpath);
        return this;
    }
    public Invoice descriptionNameedit(String descriptionName) throws InterruptedException, TimeoutException
    {
        doubleClick(driver,LocatorString.labourbyXpath);
        type(driver,"Parts",LocatorString.labourNamebyXpath);
        Thread.sleep(2000);
        typeEnter(driver,LocatorString.labourNamebyXpath);
        Thread.sleep(1000);
        click(driver,LocatorString.labourbyXpath);
	    Thread.sleep(2000);
            return this;
    }
    public Invoice descriptionValueedit(String value) throws InterruptedException, TimeoutException
    {
        doubleClick(driver,LocatorString.invoiceDesUnitPriceEditbyXpath);
        Thread.sleep(1000);
        type(driver,value,LocatorString.labourvalueEnterbyXpath);
        Thread.sleep(1000);
            return this;
    }
    public Invoice clickVAT() throws InterruptedException, TimeoutException
    {
        click(driver,LocatorString.invoiceVATEditbyXpath);
            return this;
    }
    public Invoice saveinvoicee() throws InterruptedException, TimeoutException
    {
        click(driver,LocatorString.saveInvoicebyXpath);
            return this;
    }
    public Invoice quickLinkfromInvoice() throws InterruptedException, TimeoutException
    {
        click(driver,LocatorString.quickLinkfromInvoice);
            return this;
    }
    public Invoice deleteInvoicebutton() throws InterruptedException, TimeoutException
    {
        click(driver,LocatorString.deleteInvoicebutton);
            return this;
    }
    public Invoice deleteInvoiceType(String confirmationText) throws InterruptedException, TimeoutException
    {
        type(driver,confirmationText,LocatorString.deleteConfirmation);
            return this;
    }
    public Invoice deleteInvoicebtn() throws InterruptedException, TimeoutException
    {
        click(driver,LocatorString.deletebuttonInvoice);  
            return this;
    }
    public Invoice verifyDeleteInvoice() throws InterruptedException, TimeoutException
    {
        isElementPresent(driver, LocatorString.verifyDeleteInvoice);
            return this;
    }
    public Invoice verifyInvoiceCalculation()
    {
        isElementPresent(driver,LocatorString.minusInvoiceText);
		isElementPresent(driver, LocatorString.minusInvoiceAmount);
        return this;
    }
    public Invoice getInvoiceNumber()
    {
        LocatorString.invoiceNum = getText(driver, LocatorString.getInvoiceNum);
        return this;
    }
    public Invoice typeInvoiceNuminSearch() throws InterruptedException
    {
        type(driver,LocatorString.invoiceNum,LocatorString.searchMain);
		typeEnter(driver,LocatorString.searchMain);
        return this;
    }
    public Invoice invoiceInSearch() throws InterruptedException
    {
        click(driver,LocatorString.searchMainInvoice);
		click(driver,LocatorString.invoiceNumber.replace("{invoiceNumber}", LocatorString.invoiceNum));
        return this;
    }
    public Invoice invoiceLineItem() throws InterruptedException
    {
        click(driver,LocatorString.addLineItem);//add line iem
        return this;
    }
    public Invoice invoiceLineItemUS() throws InterruptedException
    {
        click(driver,LocatorString.addLineItemUS);//add line iem
        return this;
    }
    public Invoice invoiceLineItemSelect() throws InterruptedException
    {
        click(driver,LocatorString.invoiceLineItemSelect);
        return this;
    }
    public Invoice saveLineItem() throws InterruptedException
    {
        click(driver,LocatorString.saveLineItem);
        return this;
    }
    public Invoice selectService() throws InterruptedException
    {
        click(driver,LocatorString.selectService);
        return this;
    }
    public Invoice saveService() throws InterruptedException
    {
        Thread.sleep(1000);
    	click(driver,LocatorString.saveService);

        try {
            type(driver,"confirm",LocatorString.typeConfirm);
		    click(driver,LocatorString.confirmButton);
        } catch (Exception e) {
        }


        return this;
    }
    public Invoice advanceOption() throws InterruptedException
    {
        click(driver, LocatorString.advanceOption);
        return this;
    }
    public Invoice draftCheckbox() throws InterruptedException
    {
        click(driver, LocatorString.draftCheckbox);
        return this;
    }
    public Invoice clickDraftInvoice() throws InterruptedException
    {
        click(driver, LocatorString.clickDraftInvoice);
        return this;
    }
    public Invoice confirmText() throws InterruptedException
    {
        type(driver,"SAVE",LocatorString.confirmText);
        return this;
    }
    public Invoice confirmButton() throws InterruptedException
    {
        click(driver, LocatorString.confirmButton1);
        return this;
    }
    public Invoice verifyVATnotDisplayed() throws InterruptedException
    {
        // driver.findElement(By.xpath(LocatorString.verifyVATnotDisplayed)).isDisplayed();
       if(!driver.findElement(By.xpath(LocatorString.verifyVATnotDisplayed)).isDisplayed())
       {
        System.out.println("VAT is not displayed");
       }
        return this;
    }
    public Invoice jobTabfromInvoice() throws InterruptedException
    {
        click(driver,LocatorString.jobTabfromInvoice);//job
        return this;
    }
    public Invoice jobNotes() throws InterruptedException
    {
        click(driver,LocatorString.jobNotes);//job notes
        return this;
    }
    public Invoice verifyEmailsent() throws InterruptedException
    {
        WebElement element = driver.findElement(By.xpath(LocatorString.verifyEmailsent));
						if (element.isDisplayed()) {
    						System.out.println("Element is visible.");
						} else {
   							System.out.println("Element is not visible.");
						}
        return this;
    }
    public Invoice consolidateInvoice() throws InterruptedException
    {
        click(driver,LocatorString.consolidateInvoice);//click 
        return this;
    }
    public Invoice invoiceDescription() throws InterruptedException
    {
        type(driver,"inv description",LocatorString.invoiceDescription);
        return this;
    }
    public Invoice invoiceNotes() throws InterruptedException
    {
        type(driver,"Invoice notes for testing",LocatorString.invoiceNotes);
        return this;
    }
    public Invoice invoiceAdditional() throws InterruptedException
    {
        //additional invoice
		doubleClick(driver,LocatorString.invoiceAdditional1);
		type(driver,"50",LocatorString.invoiceAdditional2);
		typeEnter(driver,LocatorString.invoiceAdditional2);
        return this;
    }
    public Invoice invoiceInterim() throws InterruptedException
    {
        //interim invoice
		Thread.sleep(2000);
		doubleClick(driver,LocatorString.invoiceInterim1);
		type(driver,"Interim",LocatorString.invoiceInterim2);
		typeEnter(driver,LocatorString.invoiceInterim2);
		doubleClick(driver,LocatorString.invoiceInterim3);
		type(driver,"100",LocatorString.invoiceAdditional2);
		typeEnter(driver,LocatorString.invoiceAdditional2);
        return this;
    }
    public Invoice invoiceTotalVerify() throws InterruptedException
    {
        //total check webcustomerno
		isElementPresent(driver,LocatorString.invoiceTotalVerify1);
		click(driver,LocatorString.invoiceTotalVerify2);
		isElementPresent(driver,LocatorString.invoiceTotalVerify1);
		isElementClickable(driver, LocatorString.invoiceTotalVerify3.replace("{webcustomerno}", webcustomerno));
        return this;
    }
    public Invoice verifyInvoiceEmail() throws InterruptedException
    {
        isElementPresent(driver,LocatorString.verifyInvoiceEmail);
        return this;
    }
   
    

}
