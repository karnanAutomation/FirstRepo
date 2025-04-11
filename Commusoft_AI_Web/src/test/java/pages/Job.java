package pages;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import action.Baseclass;
import utility.LocatorString;
import utility.Locators;

public class Job extends Baseclass{
    WebDriver driver;
    Locators locators;
    public Job(WebDriver ldriver) throws IOException, GeneralSecurityException
    {
        this.driver =ldriver;
        this.locators = new Locators(driver);
        locators.jobCreate();
    }

    public Job jobCreate(String JD) throws IOException, GeneralSecurityException, InterruptedException
    {
        // click(driver,addJobbyXpath1,addJobbyXpath2.replace("{Customer_Number}", webcustomerno));
        click(driver,LocatorString.clickJDbyXpath);
        type(driver,JD,LocatorString.typeJDbyXpath);
        click(driver,LocatorString.clickJDresbyXpath);
        click(driver,LocatorString.saveJobbyXpath); Thread.sleep(2000);
        isElementPresent(driver, LocatorString.invoiceTabbyXpath);
        return this;
    }
    public Job customerFromJob()
    {
        click(driver, "//*[@ui-sref=\"loggedin.customer_list.view.property({ id: selectedId, type:customerMode  })\"]");
        return this;
    }
    public Job editJob() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,"//a[@has-permission=\"Jobs,updateaccess\"]");	
        return this;
    }
    public Job serviceJobCreate(String JD) throws IOException, GeneralSecurityException, InterruptedException
    {
        // click(driver,addJobbyXpath1,addJobbyXpath2.replace("{Customer_Number}", webcustomerno));
        click(driver,LocatorString.clickJDbyXpath);
        type(driver,JD,LocatorString.typeJDbyXpath);
        click(driver,LocatorString.clickJDresbyXpath);
        click(driver,LocatorString.isServiceJob);
        click(driver,LocatorString.isServiceJob1);
        click(driver,LocatorString.serviceBoiler);


        click(driver,LocatorString.saveJobbyXpath); Thread.sleep(2000);
        isElementPresent(driver, LocatorString.invoiceTabbyXpath);
        return this;
    }
    public Job serviceJob()
    {
        click(driver,LocatorString.isServiceJob);
        click(driver,LocatorString.isServiceJob1);
        click(driver,LocatorString.TestBoiler);
        return this;
    }
    public Job editandCompletejob()
    {
        click(driver, LocatorString.editJobbyXpath);
        click(driver,LocatorString.completeJob);
        click(driver,LocatorString.completeJobSave);
        return this;
    }
    public Job invoiceTab()
    {
        click(driver,LocatorString.invoiceTabbyXpath);
        return this;
    }
    public Job saveJob()
    {
        click(driver,LocatorString.saveJobbyXpath);
        return this;
    }
    public Job verifyServiceJob()
    {
        click(driver,"//*[contains(text(),\"Service type\")]");
        return this;
    }
    public Job verifyInvoiceraised(String invoiceName) throws IOException, GeneralSecurityException, InterruptedException
    {
        //invoice
        // click(driver,invoiceTabbyXpath);
        String prefinaltext=getText(driver,LocatorString.invoiceNamebyXpath);
        Assert.assertEquals(prefinaltext, invoiceName);
        return this;
    }
    public Job additionalWorkTab() throws InterruptedException
    {
        click(driver,LocatorString.additionalWorkTab);
        return this;
    }
    public Job additionalWorkTabUS() throws InterruptedException
    {
        click(driver,LocatorString.additionalWorkTabUS);
        return this;
    }
    public Job createAdditionalWork() throws InterruptedException
    {
        click(driver,LocatorString.createAdditionalWork);
        return this;
    }
    public Job jobCostTab() throws InterruptedException
    {
        click(driver,LocatorString.jobCostTab);
        return this;
    }
    public Job addLabour() throws InterruptedException
    {
        click(driver,LocatorString.addLabour1);
        click(driver,LocatorString.addLabour2);
        click(driver,LocatorString.addLabour3);
        type(driver,"100",LocatorString.addLabour4);
        click(driver,LocatorString.saveJobbyXpath);
        return this;
    }
    public Job verifyLabourAdded() throws InterruptedException
    {
        isElementPresent(driver, LocatorString.verifyLabourAdded);
        return this;
    }
    public Job addTravel() throws InterruptedException
    {
        click(driver,LocatorString.addTravel);
        return this;
    }
    public Job clickEngineer() throws InterruptedException
    {
        click(driver,LocatorString.clickEngineer);
        return this;
    }
    public Job chooseEngineer() throws InterruptedException
    {
        click(driver,LocatorString.chooseEngineer);
        return this;
    }
    public Job travelPrice() throws InterruptedException
    {
        type(driver,"100",LocatorString.travelPrice);
        return this;
    }
    public Job saveTravel() throws InterruptedException
    {
        click(driver,LocatorString.travelSave);
        return this;
    }
    public Job jobPO() throws InterruptedException
    {
        click(driver,LocatorString.costPO);
        return this;
    }
    public Job jobPOSupplier() throws InterruptedException
    {
        click (driver,LocatorString.supplierPO);
        type(driver,"new",LocatorString.supplierNameType);
        click(driver,LocatorString.supplierSelect);
        return this;
    }
    public Job emailSuppliercheck() throws InterruptedException
    {
        click(driver,LocatorString.supplierEmail);
        return this;
    }
    public Job addDiaryEvent()
    {
        click (driver,LocatorString.addDiaryEventbyXpath);
        return this;
    }
    public Job quickLink()
    {
        click(driver,"//a[@class=\"btn dropdown-toggle btn-small quick-links-btn\"]");
        return this;
    }
    public Job FOC()
    {
        click(driver,"//a[@has-permission=\"Completejobasfreeofcharge,writeaccess\"]");
        return this;
    }
    public Job reasonFOC() throws TimeoutException
    {
        selectDropdownValue(driver,"1","$freeofchargeandabortjob[reason]");
        return this;
    }
    public Job commentFOC() throws TimeoutException, InterruptedException
    {
        type(driver,"To check aftersalescare from Free of charge.","//textarea[@id=\"freeofchargeandabortjob_moredetails\"]");
        return this;
    }
    public Job submitFOC() throws TimeoutException, InterruptedException
    {
        click(driver,"//button[@type=\"submit\"]");
        return this;
    }
    public Job verifyFOC() throws TimeoutException, InterruptedException
    {
        isElementPresent(driver,"//strong[text()='This job has been free of charged']");
        return this;
    }
    public Job quickLinkfromJob() throws InterruptedException
    {
        Thread.sleep(2000);
        click(driver,"//*[contains(text(),'Quick links')]");
        return this;
    }
    public Job viewInvoice() throws InterruptedException
    {
        Thread.sleep(2000);
		click(driver,"//*[contains(text(),'View')]");
        return this;
    }
    public Job editInvoice() throws InterruptedException
    {
        click(driver,"//a[@has-permission=\"Customerinvoicing,updateaccess\"]");
        return this;
    }
    public Job editInvoiceNotes() throws InterruptedException
    {
        type(driver,"Edited through Automation","//textarea[@formcontrolname=\"invoiceNotes\"]");
        return this;
    }
    public Job editNominalCode() throws InterruptedException
    {
        click(driver,"(//span[@class=\"select2-chosen\"])[last()]");
		type(driver,"sales",LocatorString.typeJDbyXpath);
		typeEnter(driver,LocatorString.typeJDbyXpath);
        return this;
    }
    public Job certificateTab() throws InterruptedException
    {
        click(driver,"//a[@ui-sref=\"loggedin.customer_list.view.job.certificates({ id: $state.params.id, type: customerMode, jobId: $state.params.jobId })\"]");
        return this;
    }
    public Job addNewForm() throws InterruptedException
    {
        click(driver,"//a[@ng-click=\"openCertificateAddEditSidePanel()\"]");
        return this;
    }
    public Job selectCertificate(String certificateName) throws InterruptedException
    {
        click(driver,"//*[contains(text(),'"+certificateName+"')]");
        return this;
    }
    public Job confirmCertificate() throws InterruptedException
    {
        click(driver,"//button[@type=\"button\"]"); Thread.sleep(1000);
        return this;
    }
    public Job saveAndContinue() throws InterruptedException
    {
        click(driver,"//*[contains(text(),'Save and continue ')]");//save and continue
        return this;
    }
    public Job saveAndComplete() throws InterruptedException
    {
        click(driver,"//button[contains(text(),'Save and complete ')]");//save and complete
        return this;
    }
    public Job inputField(String inputValue) throws InterruptedException
    {
        Thread.sleep(1000);
        type(driver,inputValue,"(//input[@class=\"ng-untouched ng-pristine ng-valid\"])[2]");
        return this;
    }
    public Job numberField(String numberValue) throws InterruptedException
    {
        type(driver,numberValue,"//input[@type=\"number\"]");
        return this;
    }
    public Job customerSignature() throws InterruptedException
    {
        click(driver,"(//a[@class=\"select2-choice\"])[last()]");
        click(driver,"(//div[@class=\"select2-result-label\"])[2]");
        type(driver,"Karnan Athisivam","(//input[@class=\"ng-untouched ng-pristine ng-valid\"])[2]");
        click(driver,"(//div[@class=\"signature\"])[1]");//click on sign pad
        type(driver,"Karna","(//input[@class=\"ng-untouched ng-pristine ng-valid\"])[last()]");
        click(driver,"(//label[@class=\"sig-container\"])[1]");//select first sign name
        click(driver,"(//button[@class=\"btn btn-primary primary-button\"])[last()]");
        isElementPresent(driver,"//img[@class=\"sig-img\"]");
        return this;
    }
    public Job engineerSignature() throws InterruptedException
    {
        click(driver,"(//div[@class=\"signature\"])[2]");//click on sign pad
        type(driver,"Karikalan","(//input[@class=\"ng-valid ng-dirty ng-touched\"])[last()]");
        click(driver,"(//label[@class=\"sig-container\"])[1]");//select first sign name
        click(driver,"(//button[@class=\"btn btn-primary primary-button\"])[last()]");
        isElementPresent(driver,"(//img[@class=\"sig-img\"])[2]");
        return this;
    }
    public Job verifyCertificateAdded() throws InterruptedException
    {
        isElementPresent(driver,"//span[@class=\"preview-file-link actions-toggle ng-scope ss-plus\"]");//verify certificate created
        return this;
    }



}
