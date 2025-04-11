package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PerformanceMetrics {

    private static final String directoryPath = "Reports/performance_logs";
    private static final String fileName = "load_times.txt"; // Fixed filename for a single log file

    // Get Page Load Time in Selenium WebDriver
    public static long getPageLoadTime(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Number loadTime = (Number) js.executeScript(
            "if (window.performance.timing.loadEventEnd > 0) " +
            "{ return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart; } " +
            "else { return -1; }"
        );
        return loadTime.longValue();
    }

    public void driverPageTime(WebDriver driver, String text) {
        long loadTime = PerformanceMetrics.getPageLoadTime(driver);
        double loadTimeInSeconds = loadTime / 1000.0;
    
        System.out.println("Load time for " + text + ": " + loadTimeInSeconds + " seconds");
        writeToFile("Load time for " + text + ": " + loadTimeInSeconds + " seconds");

        // Throw exception if load time is greater than 8 seconds
        if (loadTime > 8000) { 
            throw new RuntimeException("Page load time exceeded 8 seconds for: " + text);
        }
    }

    public void writeToFile(String logEntry) {
        // Ensure the directory exists
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Open the file in append mode so all entries go into the same file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(directoryPath, fileName), true))) {
            writer.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())) 
                         + " - " + logEntry);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
