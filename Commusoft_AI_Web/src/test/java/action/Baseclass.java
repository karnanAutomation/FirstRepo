package action;

import java.io.IOException;
import java.net.InetAddress;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.epam.healenium.SelfHealingDriver;

import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import pages.LoginPage;
import utility.Browsers;
import utility.Config;
import utility.GoogleSheetsReader;
import utility.LocatorString;
import utility.PerformanceMetrics;


@Listeners(ChainTestListener.class)
public class Baseclass extends Wrapper {

    public PerformanceMetrics metric;

    public static String configureUniqueReport(String className) 
    {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return "Reports/" + className + "_TestReport_" + timestamp + ".html";
    }








	@BeforeClass(alwaysRun = true)	
public void fetchCredentialsforclass() throws IOException, GeneralSecurityException, InterruptedException {

    // performance included
    metric = new PerformanceMetrics();


    String testClassName = this.getClass().getSimpleName();
    
    String[] credentials = GoogleSheetsReader.fetchCredentialsforclassmain(testClassName);
    
    if (credentials != null) {
        LocatorString.clientId = credentials[0];  // Client ID
        LocatorString.username = credentials[1];  // Username
        LocatorString.password = credentials[2];  // Password

		LoginPage loginpage = new LoginPage(driver);
		loginpage.seleniumLogin(LocatorString.clientId, LocatorString.username, LocatorString.password);
				 
		
    } else {
		System.out.println("Login failed: No credentials found for this system.");
        throw new RuntimeException("❌ Credentials not found for " + testClassName);
    }
}



	@BeforeTest(alwaysRun = true)
	public void setup() throws IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException,
			InterruptedException {
		config = new Config();
		Date today = new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
		String date = DATE_FORMAT.format(today);
		String SystemName = InetAddress.getLocalHost().getHostName();
		Sysout("Commusoft Web-Automation Started in :   " + SystemName + "" + "Date:" + "" + date);
        System.out.println("Detected System Name: " + System.getProperty("user.name"));
		driver = Browsers.startapplication(driver, config.Browser(), config.URl(),false);// live
	}

	

	@AfterMethod
public void teardown(ITestResult result) throws IOException {
    System.out.println("🛠️ @AfterMethod Running for: " + result.getName());

    if (result.isSuccess()) {
        System.out.println("🏆 Method Executed Successfully: " + result.getName());
    } else if (result.getStatus() == ITestResult.FAILURE) {
        System.out.println("💔 Method Failed: " + result.getName());

        byte[] screenshot = takeScreenshot();
        if (screenshot != null) {
            System.out.println("📌 Embedding Screenshot...");
            ChainTestListener.embed(screenshot, "image/png");
        } else {
            System.out.println("⚠️ Screenshot not captured!");
        }
    } else if (result.getStatus() == ITestResult.SKIP) {
        System.out.println("⏩🤷 Method Skipped: " + result.getName());
    }
}



public byte[] takeScreenshot() {
    try {
        WebDriver actualDriver = driver instanceof SelfHealingDriver 
            ? ((SelfHealingDriver) driver).getDelegate()  // Get original WebDriver
            : driver;

        if (actualDriver instanceof TakesScreenshot) {
            return ((TakesScreenshot) actualDriver).getScreenshotAs(OutputType.BYTES);
        } else {
            System.out.println("⚠️ Actual WebDriver is NOT a TakesScreenshot instance!");
        }
    } catch (Exception e) {
        System.out.println("❌ Screenshot Capture Failed: " + e.getMessage());
        e.printStackTrace();
    }
    return null;
}






	

	@AfterSuite
	public void tearDown() throws IOException {
		Date today = new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
		String date = DATE_FORMAT.format(today);
		System.out.println("Date: " + date);
		
	}





	

}
