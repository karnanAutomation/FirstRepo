package utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;

@SuppressWarnings("deprecation")
public class Browsers {

    static Map<String, Object> prefs = new HashMap<>();
     {
        prefs.put("download.prompt_for_download", false);  // Disable the popup
        // prefs.put("download.default_directory", "C:\\Users\\Downloads");  // Set the default download directory
    }
    
            
        public static WebDriver startapplication(WebDriver driver, String browser, String URL,boolean headless) 
            throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException {
        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless=new");
options.addArguments("--disable-gpu");
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
options.addArguments("window-size=1920,1080");
options.addArguments("--remote-debugging-port=9222");
options.addArguments("user-agent=Mozilla/5.0");

            }

            options.addArguments("--detach", "--incognito");
            options.setCapability("goog:loggingPrefs", Map.of("performance", "ALL"));
            options.setExperimentalOption("prefs", prefs);
          

        WebDriver delegate = new ChromeDriver(options);
        driver = SelfHealingDriver.create(delegate);  // Wrap once
    } else if (browser.contains("firefox")) {
        driver = new FirefoxDriver();
    } else if (browser.contains("Edge")) {
        System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
        driver = new EdgeDriver();
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(URL);
    return driver;
}


	

}
