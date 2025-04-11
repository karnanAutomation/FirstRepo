package pages;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;

import action.Baseclass;
import utility.LocatorString;
import utility.Locators;

public class Diary extends Baseclass{
    
    WebDriver driver;
     Locators locators;
    public Diary(WebDriver ldriver) throws IOException, GeneralSecurityException
    {
        this.driver =ldriver;
        this.locators = new Locators(driver); 
        locators.addDiaryEvent();
    }
    public Diary addDiary() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.addDiaryEvent);
        return this;
    }
    public Diary addDiaryUS() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.addDiaryEventUS);
        return this;
    }
    public Diary dailyButton() throws IOException, GeneralSecurityException, InterruptedException
    {
        try{click(driver,LocatorString.dailyButton);}catch(Exception e){}
        return this;
    }
    public Diary today() throws IOException, GeneralSecurityException, InterruptedException
    {
        try {
            click(driver, LocatorString.todayButton);
            click(driver, LocatorString.clickonDiary);
        } catch (Exception e) {
            Thread.sleep(2000);
            click(driver, LocatorString.nextButton); Thread.sleep(2000);
            click(driver, LocatorString.todayButton);
        }
        return this;
    }
    public Diary timing4_430() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.timing4_430);
        return this;
    }
    public Diary timing930_10() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.timing930_10);//9:30-10
        return this;
    }
    public Diary timing430_5() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.timing430_5);//4.30-5
        return this;
    }
    public Diary timing530_6() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.timing530_6);//4.30-5
        return this;
    }
    public Diary timing11PM() throws IOException, GeneralSecurityException, InterruptedException
    {
        click (driver,LocatorString.timing11PM);
        return this;
    }
    public Diary saveDiary() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.saveDiary);
        return this;
    }
    public Diary verifyDiaryCreated() throws IOException, GeneralSecurityException, InterruptedException
    {
        isElementClickable(driver, LocatorString.verifyDiaryscreated);
        return this;
    }
    public Diary verifyDiaryCreatedUS() throws IOException, GeneralSecurityException, InterruptedException
    {
        isElementClickable(driver, LocatorString.verifyDiaryscreatedUS);
        return this;
    }
    public Diary diaryTab() throws IOException, GeneralSecurityException, InterruptedException
    {
        Thread.sleep(4000);
        click(driver, LocatorString.diaryTab);
        return this;
    }
    public Diary diaryTabUS() throws IOException, GeneralSecurityException, InterruptedException
    {
        Thread.sleep(4000);
        click(driver, LocatorString.diaryTabUS);
        return this;
    }
    public Diary diaryDaily() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.diaryDaily);
        return this;
    }
    public Diary diaryWeekly() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.diaryWeekly);
        return this;
    }
    public Diary diaryTwoWeekly() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.diaryTwoWeekly);
        return this;
    }
    public Diary diaryTwoWeeklyUS() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.diaryTwoWeeklyUS);
        return this;
    }
    public Diary diaryMonthly() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.diaryMonthly);
        return this;
    }
    public Diary diaryPM() throws IOException, GeneralSecurityException, InterruptedException
    {
        
        click(driver,LocatorString.timing12_1230);//PM
        // click(driver,LocatorString.diaryPM);//PM
        // Thread.sleep(2000);
        return this;
    }
    public Diary diaryEstimate() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.diaryEstimate);//choose estimate
        return this;
    }
    public Diary diaryCustomerSearch(String customerName) throws IOException, GeneralSecurityException, InterruptedException
    {
        //property search
        type(driver,customerName,LocatorString.diarySearchClick);
        typeEnter(driver,LocatorString.diarySearchClick);
        return this;
    }
    public Diary diaryCustomerSelect() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.diarySearch1select);
        return this;
    }
    public Diary diaryDesChoose() throws IOException, GeneralSecurityException, InterruptedException, TimeoutException
	{
        selectDropdownValue(driver,"1",LocatorString.diaryDesChoose);
        return this;
	}
    public Diary diaryJob() throws IOException, GeneralSecurityException, InterruptedException, TimeoutException
	{
        click(driver,LocatorString.diaryJob);
        return this;
	}
    public Diary diaryJobDes() throws IOException, GeneralSecurityException, InterruptedException, TimeoutException
	{
        selectDropdownValue(driver,"1",LocatorString.diaryJobDes);
        return this;
	}
    public Diary normalDes(String eventDescription) throws IOException, GeneralSecurityException, InterruptedException, TimeoutException
	{
        type(driver,eventDescription,LocatorString.normalDes);
        return this;
	}
    public Diary addCusfromDiary() throws IOException, GeneralSecurityException, InterruptedException, TimeoutException
	{
        click(driver,LocatorString.addCustomerFromDiary);//add property
        selectDropdown(driver,"Customer",LocatorString.addCustomerPFromDiary);
		selectDropdownValue(driver,"0",LocatorString.addCustomerPPFromDiary);
		type(driver,"Karnan",LocatorString.firstNameDiary);
		type(driver,"Diary",LocatorString.surNameDiary);
		type(driver,"ranjit@commusoft.com",LocatorString.emailDiary);
		type(driver,"Madurai",LocatorString.adressDiary);
		click(driver,LocatorString.saveCusDiary);
        return this;
	}
    public Diary printJobSheet() throws IOException, GeneralSecurityException, InterruptedException, TimeoutException
	{
        Thread.sleep(5000);
        clickAndCloseNewTab(driver,LocatorString.printJobSheet);
        return this;
	}
    public Diary printSummarySheet() throws IOException, GeneralSecurityException, InterruptedException, TimeoutException
	{
        clickAndCloseNewTab(driver,LocatorString.printSummarySheet);
        return this;
	}
    public Diary clickMap() throws IOException, GeneralSecurityException, InterruptedException
    {
        click(driver,LocatorString.clickMap);
        return this;
    }
    public Diary verifyMapLoading() throws IOException, GeneralSecurityException, InterruptedException
    {
        isElementPresent(driver,LocatorString.verifyMap);
        return this;
    }

}
