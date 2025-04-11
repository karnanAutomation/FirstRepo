package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.rmi.AccessException;
import java.security.GeneralSecurityException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import action.Baseclass;
import java.awt.event.KeyEvent;
import utility.LocatorString;
import utility.Locators;
import utility.PageloadResponse;

public class Reporting extends Baseclass{

     WebDriver driver;
     Locators locators;
	public Reporting(WebDriver ldriver) throws IOException, GeneralSecurityException
	{
		this.driver =ldriver;
        this.locators = new Locators(driver); 
        locators.reportingFlows();

	}
    public Reporting reportingTap() throws InterruptedException
    {
		click(driver,LocatorString.reportTab); //report tab
        return this;
    }
	public Reporting sideMenu() throws InterruptedException
    {
		click(driver,LocatorString.sideMenu); //side menu
        return this;
    }
	public Reporting Customers() throws InterruptedException
    {
		click(driver,LocatorString.sideCustomer); //click customer report
        return this;
    }
	public Reporting customerReport() throws InterruptedException
    {
        Thread.sleep(1000);
		click(driver,LocatorString.selectCustomerReport); //click first customer report
        return this;
    }
	public Reporting filter() throws InterruptedException
    {
        Thread.sleep(2000);
		click(driver,LocatorString.filterOption);// click filter option
        return this;
    }
	public Reporting datePicker() throws InterruptedException
    {
        Thread.sleep(2000);
		click(driver,LocatorString.datePicker);
        return this;
    }
	public Reporting todayDate() throws InterruptedException
    {
        Thread.sleep(1000);
		click(driver,LocatorString.todayReport);//click today date
        return this;
    }
    public Reporting thisWeekReport() throws InterruptedException
    {
        click(driver,LocatorString.thisWeekReport);//click date range
        return this;
    }
	public Reporting applyFilter() throws InterruptedException
    {
		click(driver,LocatorString.applyFilter);//apply filter
        return this;
    }
	public Reporting firstButton() throws InterruptedException
    {
		click(driver,LocatorString.clickFirstReport); //click first + button
        return this;
    }
	public Reporting viewFirstCustomer() throws InterruptedException
    {
        Thread.sleep(3000);
		clickAndCloseNewTab(driver,LocatorString.viewFirstCusotmer);//click view customer 
        return this;
    }
	public Reporting serviceReminders() throws InterruptedException
    {
		click(driver,LocatorString.serviceReminder);//click service reminder report
        return this;
    }
	public Reporting serviceReminderReport() throws InterruptedException
    {
        Thread.sleep(2000);
		click(driver,LocatorString.serviceReminderSelect);//click serviceReminderReport
        return this;
    }
	public Reporting verifyServiceReminderReport() throws InterruptedException
    {
		try
		{
		isElementPresent(driver,LocatorString.FirstrowData);
		}
		catch(Exception e)
		{
			String a=getText(driver,LocatorString.noDataFound);
			String b="No records found";
			Assert.assertEquals(a, b,"Records found - Assertion failed");
			
		}
        return this;
    }
	public Reporting suppliers() throws InterruptedException
    {
        Thread.sleep(2000);
		click(driver,LocatorString.supplierReport);//click Supplier report
        return this;
    }
	public Reporting supplierReport() throws InterruptedException
    {
		click(driver,LocatorString.supplierReportSelect);//click Suppliers report
        return this;
    }
	public Reporting verifySupplierReport() throws InterruptedException
    {
		try
		{
			isElementPresent(driver,LocatorString.supplierFirstrowData);
		}
		catch(Exception e)
		{
			String a=getText(driver,LocatorString.noDataFound);
			String b="No records found";
			Assert.assertEquals(a, b,"Records found - Assertion failed");

		}
        return this;
    }
	public Reporting estimates() throws InterruptedException
    {
		click(driver,LocatorString.estimateReport);//click Estimate report
        return this;
    }
	public Reporting estimateReport() throws InterruptedException
    {
		click(driver,LocatorString.estimateReportSelect);//click estimates report
        return this;
    }
	public Reporting viewFirstEstimate() throws InterruptedException
    {
        Thread.sleep(4000);
		clickAndCloseNewTab(driver,LocatorString.viewFirstCusotmer);
        return this;
    }
	public Reporting jobs() throws InterruptedException
    {
        Thread.sleep(5000); 
		click(driver,LocatorString.jobReport);//click Job report
        return this;
    }
	public Reporting jobReport() throws InterruptedException
    {
		click(driver,LocatorString.jobReportSelect);//click jobs report
        return this;
    }
	public Reporting workAddressReport() throws InterruptedException
    {
		click(driver,LocatorString.WAReport); //click 2nd customer report
        return this;
    }
    public Reporting clickPrint() throws InterruptedException
    {
		click(driver,LocatorString.estimateReport);//click Estimate report
        return this;
    }
    public Reporting printReport() throws InterruptedException
    {
        try {
            Thread.sleep(2000);
		    clickAndCloseNewTab(driver,LocatorString.clickPrint);
        } catch (Exception e) {
            System.out.println("Print button not found");
        }
        
        return this;
    }
    public Reporting downloadReport() throws InterruptedException
    {
		//download start


        
        //download end
        
        return this;
    }



    public Reporting handleFileDownload() throws AWTException, InterruptedException, AccessException {
        String os = System.getProperty("os.name").toLowerCase();
        
        // Click the Download Button
        driver.findElement(By.xpath(LocatorString.downloadScreen)).click();
        System.out.println("✅ Clicked on Download button");
    
        if (os.contains("win")) {
            // Windows - Wait and Verify File Download
            System.out.println("🖥 Running on Windows. Waiting for file download...");
            Thread.sleep(5000); // Adjust if needed
            verifyDownloadedFile("C:\\Users\\YourUsername\\Downloads\\");
        } else if (os.contains("mac")) {
            // Mac - Handle Save As Dialog using Robot Class
            System.out.println("🍏 Running on macOS. Handling Save As popup...");
            handleMacSaveAsPopup();
        }
        return this;
    }
    
    // ✅ Method to verify file download in Windows
    public void verifyDownloadedFile(String downloadPath) {
        File folder = new File(downloadPath);
        File[] files = folder.listFiles();
        if (files != null && files.length > 0) {
            System.out.println("✅ File downloaded successfully: " + files[0].getName());
        } else {
            System.out.println("❌ No file found in Downloads folder!");
        }
    }
    
    // ✅ Method to handle macOS Save As popup using Robot Class
    public void handleMacSaveAsPopup() throws AccessException, InterruptedException, AWTException {
        Robot robot = new Robot();
        
        // Press Enter to confirm default download location
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        
        System.out.println("✅ Handled macOS Save As popup");
    }
    public Reporting jobsDates() throws InterruptedException
    {
        click(driver,LocatorString.jobsDates);
        return this;
    }
    public Reporting users() throws InterruptedException
    {
        click(driver,LocatorString.userReport);
        return this;
    }
    public Reporting usersReport() throws InterruptedException
    {
        Thread.sleep(1000);
        click(driver,LocatorString.userReportSelect);
        return this;
    }
    public Reporting diaryEventDate() throws InterruptedException
    {
        click(driver,LocatorString.eventDate);
        return this;
    }
    public Reporting viewAllServiceReminder() throws InterruptedException
    {
        Thread.sleep(3000);
        click(driver,LocatorString.serviceReminder1);
        Thread.sleep(2000);
        return this;
    }
    public Reporting check2ServiceReminder() throws InterruptedException
    {
        click(driver,LocatorString.check2ServiceReminder1); 
        Thread.sleep(2000);
		click(driver,LocatorString.check2ServiceReminder2);
        Thread.sleep(2000);
        return this;
    }
    public Reporting processing() throws InterruptedException
    {
        click(driver,LocatorString.processing);
        return this;
    }
    public Reporting verifyProcessed() throws InterruptedException
    {
        isElementPresent(driver, LocatorString.verifyProcessed);
        return this;
    }
    public Reporting searchCustomerVerifyPageResponse() throws InterruptedException
    {
        type(driver,"Karna",LocatorString.searchInput);
		typeEnter(driver,LocatorString.searchInput);
		String url = driver.getCurrentUrl();
        Thread.sleep(3000);
		click(driver,LocatorString.searchClick);
		PageloadResponse page = new PageloadResponse();
		int a = page.httpResponseCodeViaGet(url);
		System.out.println("Status:- " +a);
		Assert.assertEquals(a, 200);
        return this;
    }
    
    

    
    




}
