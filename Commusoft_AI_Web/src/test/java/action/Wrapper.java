package action;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

import utility.Config;

public class Wrapper {


	public static String seleniumhomepage="https://app.commusoft.co.uk/customers";
	public static String playwrighthome;
	public Object driverOrPage;
	public Config config;
	public static Playwright playwright;
	public static Browser browser;
	public static Page page;
	public static BrowserContext context;
	public static WebDriver driver; 



	public String Name="Customer";//Cutomer
	public String Surname="ForWebAutomation";	
	public String Email="commusoftweb@yopmail.com";
	public String Additionalinvoice="Additional invoice";
	public String Interiminvoice="Interim invoice";
	public String PreFinalinvoice="Pre-final invoice";
	public String Finalinvoice="Final invoice";
	public String InvoiceDes="InvoiceDes";
	public String RanjitCategory="Ranjit Category";
	public String AravindCategory="Aravind Category";
	public String RACategory="RA category";
	public String Subtotal100="100";
	public String Subtotal200="200";
	public String Vat20="20.00";
	public String Vat5="5.00";
	public String Vat0="0.00";
	public String Vat15="15.00";
	public String SalesNominalCode="Sales";
	public String OthersNominalCode="others";
	public String RentNominalCode="rent";
	public String Part="parts";
	public String UnitPrice="122";
	public String UnitPrice2="785";
	public String UnitPrice3="258";
	public String Part2="parts2";
	public String Part3="parts3";
	public String Quantity="1";
	public String EditQuantity="2";
	public String CreditNominalCode="CIS sales";
	public String Stripe_Email ="karnan@commusoft.com";
	public String Stripe_Password = "K^Ar1-022-Lz9^-pO0NzQA";
	public String paymentMethod = "ACH";
	public String ACH = "ACH";//ACH
	public String BACS = "BACS";
	public String NominalCode="Bank";
	public String Card1 = "5454545454545454";
	public String RemoveAndAddFive = "5";
	public String Card2 = "4242424242424242";
	public String RemoveAndAddFour = "4";
	public int Index1 = 1;
	public int Index2 = 2;
	public String Card3 = "5555555555554444";
	public String Card4 = "5200828282828210";
	public static String webcustomerno="11334";
	public static String webcompanyno="5169";
	public static String webcustomerpage = "https://app.commusoft.co.uk/customers/customer_list/11137/view_v2/property/view";
	public static String webworkaddresspage = "https://app.commusoft.co.uk/customers/customer_list/11416/view_v2/property/view";
	public static String webcompanypage = "https://app.commusoft.co.uk/customers/customer_list/11840/view_v2/property/view";


	public boolean click(Page page,String...locators) {

		for (String locator : locators) {
			try {
				Locator element = page.locator(locator);
				//our existing code start
				if (locator.startsWith("$")) {
					element = page.locator("//*[@name='" + locator.substring(1) + "']");  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = page.locator("//*[@id='" + locator.substring(1) + "']");  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = page.locator("." + locator.substring(1));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = page.locator("//*[@class='" + locator.substring(1) + "']");  // Remove '.'
				} else {
					element = page.locator("xpath=" + locator);  // Default to XPath
				}
				element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(15000));
				//our existing code end
				if (element.isVisible()) {  
					element.click();
					System.out.println("✅ Clicked on element: " + locator);
					return true;  // Exit after the first successful click
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ No matching element found to click.");
		throw new RuntimeException("Test Failed: No matching element found to click.");
	}
	public boolean click(WebDriver driver, String... locators) {
		for (String locator : locators) {
			try {
				WebElement element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = driver.findElement(By.name(locator.substring(1)));  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = driver.findElement(By.id(locator.substring(1)));  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = driver.findElement(By.className(locator.substring(1)));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = driver.findElement(By.cssSelector(locator.substring(1)));  // Remove '.'
				} else {
					element = driver.findElement(By.xpath(locator));  // Default to XPath
				}
				isElementClickable(driver, locators);
				isElementPresent(driver, locators);
				//our existing code end
				if (element.isDisplayed() && element.isEnabled()) {
					element.click();
					System.out.println("✅ Clicked on element: " + locator);
					return true;
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ No matching element found to click.");
		throw new RuntimeException("Click Test Failed: No matching element found to click.");
	}
	public boolean selectDropdown(WebDriver driver, String value, String... locators) {
    for (String locator : locators) {
        try {
            WebElement element;
            //our existing code start
            if (locator.startsWith("$")) {
                element = driver.findElement(By.name(locator.substring(1)));  // Remove '$'
            } else if (locator.startsWith("#")) {
                element = driver.findElement(By.id(locator.substring(1)));  // Remove '#'
            } else if (locator.startsWith("~")) {
                element = driver.findElement(By.className(locator.substring(1)));  // Remove '~'
            } else if (locator.startsWith(".")) {
                element = driver.findElement(By.cssSelector(locator.substring(1)));  // Remove '.'
            } else {
                element = driver.findElement(By.xpath(locator));  // Default to XPath
            }

            isElementClickable(driver, locators);
            isElementPresent(driver, locators);
			//our existing code end
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(value);
            
            System.out.println("✅ Selected value: '" + value + "' from dropdown: " + locator);
            return true;
        } catch (Exception e) {
            System.out.println("❌ Failed to select value: '" + value + "' from dropdown: " + locator + ". Error: " + e.getMessage());
        }
    }
    System.out.println("❌ No matching dropdown element found.");
    throw new RuntimeException("Dropdown Selection Failed: No matching element found.");
}
public boolean selectDropdownValue(WebDriver driver, String value, String... locators) throws TimeoutException {
    for (String locator : locators) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
            WebElement element;

            // Wait until the element is present
            if (locator.startsWith("$")) {
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator.substring(1))));
            } else if (locator.startsWith("#")) {
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator.substring(1))));
            } else if (locator.startsWith("~")) {
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator.substring(1))));
            } else if (locator.startsWith(".")) {
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator.substring(1))));
            } else {
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            }

            // Ensure the element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Select value from dropdown
            Select dropdown = new Select(element);
            dropdown.selectByValue(value);

            System.out.println("✅ Successfully selected value: '" + value + "' from dropdown: " + locator);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("❌ Element not found: " + locator);
        } catch (ElementNotInteractableException e) {
            System.out.println("❌ Dropdown is not interactable: " + locator);
        } catch (Exception e) {
            System.out.println("❌ Failed to select value: '" + value + "' from dropdown: " + locator + ". Error: " + e.getMessage());
        }
    }
    System.out.println("❌ No matching dropdown element found.");
    throw new RuntimeException("Dropdown Selection Failed: No matching element found.");
}
public boolean selectDropdownByIndex(WebDriver driver, int index, String... locators) {
    for (String locator : locators) {
        try {
            WebElement element;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for dropdown

            // Determine locator type and find element
            if (locator.startsWith("$")) {
                element = wait.until(ExpectedConditions.elementToBeClickable(By.name(locator.substring(1))));
            } else if (locator.startsWith("#")) {
                element = wait.until(ExpectedConditions.elementToBeClickable(By.id(locator.substring(1))));
            } else if (locator.startsWith("~")) {
                element = wait.until(ExpectedConditions.elementToBeClickable(By.className(locator.substring(1))));
            } else if (locator.startsWith(".")) {
                element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator.substring(1))));
            } else {
                element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            }

            // Initialize dropdown
            Select dropdown = new Select(element);
            List<WebElement> options = dropdown.getOptions();
            
            // Validate index
            if (index < 0 || index >= options.size()) {
                System.out.println("⚠️ Invalid index: " + index + ". Available options: " + (options.size() - 1));
                return false;
            }

            // Select option by index
            dropdown.selectByIndex(index);
            System.out.println("✅ Selected value: '" + options.get(index).getText() + "' at index " + index + " from dropdown: " + locator);
            return true;
        } catch (Exception e) {
            System.out.println("❌ Failed to select index " + index + " from dropdown: " + locator + ". Error: " + e.getMessage());
        }
    }
    throw new RuntimeException("Dropdown Selection Failed: No matching element found.");
}






	public boolean isElementPresent(Page page, String... locators) {
		for (String locator : locators) {
			try {
				Locator element = page.locator(locator);
				element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));
				
				//our existing code start
				if (locator.startsWith("$")) {
					element = page.locator("//*[@name='" + locator.substring(1) + "']");  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = page.locator("//*[@id='" + locator.substring(1) + "']");  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = page.locator("." + locator.substring(1));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = page.locator("//*[@class='" + locator.substring(1) + "']");  // Remove '.'
				} else {
					element = page.locator("xpath=" + locator);  // Default to XPath
				}
				element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));
				//our existing code end
				
				if (element.count() > 0 && element.isVisible()) {  // Ensuring it's present & visible
					System.out.println("✅ Visible element: " + locator);
					return true;
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to locate the element: " + locator + ". Error: " + e.getMessage());			}
		}
		System.out.println("❌ No matching element found.");
		throw new RuntimeException("Test Failed: No matching element found.");
	}
	public boolean isElementPresent(WebDriver driver, String... locators) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 40s wait

		for (String locator : locators) {
			try {
				WebElement element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator.substring(1))));  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator.substring(1))));  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator.substring(1))));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator.substring(1))));  // Remove '.'
				} else {
					element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));  // Default to XPath
				}
				//our existing code end
				wait.until(ExpectedConditions.visibilityOf(element));
				if (element.isDisplayed() && element.isEnabled()) {  // Ensuring it's visible
					return true;
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());			}
		}
		System.out.println("❌ No matching element found.");
		throw new RuntimeException("Test Failed: No matching element found.");
	}
	public boolean isElementClickable(WebDriver driver, String... locators) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 40s wait
	
		for (String locator : locators) {
			try {
				WebElement element;
				// Handling different locator types
				if (locator.startsWith("$")) {
					element = wait.until(ExpectedConditions.elementToBeClickable(By.name(locator.substring(1))));  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = wait.until(ExpectedConditions.elementToBeClickable(By.id(locator.substring(1))));  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = wait.until(ExpectedConditions.elementToBeClickable(By.className(locator.substring(1))));  // Remove '~'
				} else if (locator.startsWith(".")) {
					element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator.substring(1))));  // Remove '.'
				} else {
					element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));  // Default to XPath
				}
				// Checking if the element is displayed and enabled
				if (element.isDisplayed() && element.isEnabled()) {
					return true;
				}
			} catch (Exception e) {
				System.out.println("❌ Element not clickable: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ No clickable element found.");
		throw new RuntimeException("Test Failed: No clickable element found.");
	}
	
	public boolean type(WebDriver driver, String text, String... locators) throws InterruptedException {
		for (String locator : locators) {
			try {
				WebElement element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = driver.findElement(By.name(locator.substring(1)));  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = driver.findElement(By.id(locator.substring(1)));  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = driver.findElement(By.className(locator.substring(1)));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = driver.findElement(By.cssSelector(locator.substring(1)));  // Remove '.'
				} else {
					element = driver.findElement(By.xpath(locator));  // Default to XPath
				}
				//our existing code end
				isElementClickable(driver, locators);
            	isElementPresent(driver, locators);
				if (element.isDisplayed() && element.isEnabled()) {  
					element.clear();  // Clear existing text (optional)

					// Handle special keys
					if ("K.TAB".equalsIgnoreCase(text)) {
						element.sendKeys(Keys.TAB);
					} else if ("K.ENTER".equalsIgnoreCase(text)) {
						element.sendKeys(Keys.ENTER);
					} else {
						element.sendKeys(text);
					}
					System.out.println("✅ (Selenium) Typed '" + text + "' into element: " + locator);
					return true;  
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ (Selenium) No matching element found to type.");
		throw new RuntimeException("Test Failed: No matching element found to type.");
	}
	public boolean typeEnter(WebDriver driver, String... locators) {
		for (String locator : locators) {
			try {
				WebElement element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = driver.findElement(By.name(locator.substring(1)));  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = driver.findElement(By.id(locator.substring(1)));  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = driver.findElement(By.className(locator.substring(1)));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = driver.findElement(By.cssSelector(locator.substring(1)));  // Remove '.'
				} else {
					element = driver.findElement(By.xpath(locator));  // Default to XPath
				}
				//our existing code end
				isElementClickable(driver, locators);
            	isElementPresent(driver, locators);
				if (element.isDisplayed() && element.isEnabled()) {  
					element.sendKeys(Keys.ENTER);
					System.out.println("✅ Enter clicked in Field:  " + locator);
					return true;  
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on Enter: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ (Selenium) No matching element found to type.");
		throw new RuntimeException("Test Failed: No matching element found to typeEnter.");
	}
	public boolean type(Page page, String text, String... locators) {
		for (String locator : locators) {
			try {
				Locator element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = page.locator("[name='" + locator.substring(1) + "']");  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = page.locator("//*[@id='" + locator.substring(1) + "']");  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = page.locator("." + locator.substring(1));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = page.locator("[class='" + locator.substring(1) + "']");  // Remove '.'
				} else {
					element = page.locator("xpath=" + locator);  // Default to XPath
				}
				element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
				//our existing code end
				if (element.isVisible() && element.isEnabled()) {  
					element.clear();  
					element.fill(text);
					System.out.println("✅ (Selenium) Typed '" + text + "' into element: " + locator);
					return true;  
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ (Selenium) No matching element found to type.");
		throw new RuntimeException("Test Failed: No matching element found to type.");
	}
	public boolean typeEnter(Page page, String... locators) {
		for (String locator : locators) {
			try {
				Locator element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = page.locator("[name='" + locator.substring(1) + "']");  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = page.locator("//*[@id='" + locator.substring(1) + "']");  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = page.locator("." + locator.substring(1));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = page.locator("[class='" + locator.substring(1) + "']");  // Remove '.'
				} else {
					element = page.locator("xpath=" + locator);  // Default to XPath
				}
				element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
				//our existing code end
				if (element.isVisible() && element.isEnabled()) {  
					element.press("Enter"); 
					System.out.println("✅ Enter clicked in Field: " + locator);
					return true;  
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on Enter: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ (Selenium) No matching element found to type.");
		throw new RuntimeException("Test Failed: No matching element found to typeEnter.");
	}
	public boolean doubleClick(WebDriver driver, String... locators) {
		Actions actions = new Actions(driver);

		for (String locator : locators) {
			try {
				WebElement element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = driver.findElement(By.name(locator.substring(1)));  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = driver.findElement(By.id(locator.substring(1)));  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = driver.findElement(By.className(locator.substring(1)));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = driver.findElement(By.cssSelector(locator.substring(1)));  // Remove '.'
				} else {
					element = driver.findElement(By.xpath(locator));  // Default to XPath
				}
				//our existing code end
				isElementClickable(driver, locators);
            	isElementPresent(driver, locators);
				if (element.isDisplayed() && element.isEnabled()) {  
					actions.doubleClick(element).perform();
					System.out.println("✅ (Selenium) Double-clicked on element: " + locator);
					return true;  
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ (Selenium) No matching element found to double-click.");
		throw new RuntimeException("Test Failed: No matching element found to double-click.");
	}
	public boolean doubleClick(Page page, String... locators) {
		for (String locator : locators) {
			try {
				Locator element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = page.locator("[name='" + locator.substring(1) + "']");  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = page.locator("//*[@id='" + locator.substring(1) + "']");  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = page.locator("." + locator.substring(1));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = page.locator("[class='" + locator.substring(1) + "']");  // Remove '.'
				} else {
					element = page.locator("xpath=" + locator);  // Default to XPath
				}
				//our existing code end
				element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
				element.dblclick();

				System.out.println("✅ (Playwright) Double-clicked on element: " + locator);
				return true;
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ (Playwright) No matching element found to double-click.");
		throw new RuntimeException("Test Failed: No matching element found to double-click.");
	}
	public String getText(WebDriver driver, String... locators) {
		for (String locator : locators) {
			try {
				WebElement element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = driver.findElement(By.name(locator.substring(1)));  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = driver.findElement(By.id(locator.substring(1)));  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = driver.findElement(By.className(locator.substring(1)));  // Remove '~'
				} else if (locator.startsWith(".")) {
					element = driver.findElement(By.cssSelector(locator));  // CSS selector (no need to remove '.')
				} else {
					element = driver.findElement(By.xpath(locator));  // Default to XPath
				}
				//our existing code end
				if (element.isDisplayed()) {
					String text = element.getText().trim();
					System.out.println("✅ (Selenium) Retrieved text: '" + text + "' from element: " + locator);
					return text;
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ (Selenium) No matching element found to get text.");
		throw new RuntimeException("Test Failed: No matching element found to get text.");
	}
	public String getText(Page page, String... locators) {
		for (String locator : locators) {
			try {
				Locator element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = page.locator("[name='" + locator.substring(1) + "']");  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = page.locator("//*[@id='" + locator.substring(1) + "']");  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = page.locator("." + locator.substring(1));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = page.locator("[class='" + locator.substring(1) + "']");  // Remove '.'
				} else {
					element = page.locator("xpath=" + locator);  // Default to XPath
				}
				//our existing code end
				element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
				String text = element.textContent().trim();
				System.out.println("✅ (Playwright) Retrieved text: '" + text + "' from element: " + locator);
				return text;
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ (Playwright) No matching element found to get text.");
		throw new RuntimeException("Test Failed: No matching element found to get text.");
	}
	public boolean isEnabled(WebDriver driver, String... locators) {
		for (String locator : locators) {
			try {
				WebElement element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = driver.findElement(By.name(locator.substring(1)));  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = driver.findElement(By.id(locator.substring(1)));  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = driver.findElement(By.className(locator.substring(1)));  // Remove '~'
				} else if (locator.startsWith(".")) {
					element = driver.findElement(By.cssSelector(locator));  // CSS selector (no need to remove '.')
				} else {
					element = driver.findElement(By.xpath(locator));  // Default to XPath
				}
				//our existing code end
				if (element.isDisplayed() && element.isEnabled()) {
					System.out.println("✅ (Selenium) Element is enabled: " + locator);
					return true;
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ (Selenium) No matching element found or is disabled.");
		throw new RuntimeException("Test Failed: No matching element found or is disabled.");
	}
	public boolean isEnabled(Page page, String... locators) {
		for (String locator : locators) {
			try {
				Locator element;
				//our existing code start
				if (locator.startsWith("$")) {
					element = page.locator("[name='" + locator.substring(1) + "']");  // Remove '$'
				} else if (locator.startsWith("#")) {
					element = page.locator("//*[@id='" + locator.substring(1) + "']");  // Remove '#'
				} else if (locator.startsWith("~")) {
					element = page.locator("." + locator.substring(1));  // Remove '~'
				} else if(locator.startsWith(".")) {
					element = page.locator("[class='" + locator.substring(1) + "']");  // Remove '.'
				} else {
					element = page.locator("xpath=" + locator);  // Default to XPath
				}
				//our existing code end
				if (element.isVisible() && element.isEnabled()) {
					System.out.println("✅ (Playwright) Element is enabled: " + locator);
					return true;
				}
			} catch (Exception e) {
				System.out.println("❌ Failed to click on element: " + locator + ". Error: " + e.getMessage());
			}
		}
		System.out.println("❌ (Playwright) No matching element found or is disabled.");
		throw new RuntimeException("Test Failed: No matching element found or is disabled.");
	}
	public  void clickAndCloseNewTab(WebDriver driver, String locator) throws InterruptedException {
    // Store the handle of the original tab
    String originalWindow = driver.getWindowHandle();
    System.out.println("🔹 Original Tab Handle: " + originalWindow);

	click(driver,locator);
    System.out.println("✅ Clicked on element: " + locator + " (Expected new tab to open)");

    // Wait for the new tab to open
    new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(d -> d.getWindowHandles().size() > 1);

    // Get all window handles
    Set<String> allWindows = driver.getWindowHandles();
    System.out.println("🔹 All open windows: " + allWindows);

    // Find the new tab and close it
    for (String window : allWindows) {
        if (!window.equals(originalWindow)) {
            System.out.println("🔹 Switching to new tab: " + window);
            driver.switchTo().window(window);

            // Close the new tab
			try {
                System.out.println("⏳ Waiting 5 seconds before closing the new tab...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.close();
            System.out.println("✅ Successfully closed the new tab: " + window);

            // Switch back to the original tab
            driver.switchTo().window(originalWindow);
            System.out.println("🔄 Switched back to the original tab: " + originalWindow);
            break;
        }
    }
}
//toast handle
public void clickAndHandleNewTab(WebDriver driver, String locator) throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

	// ✅ Store the original window handle
	String originalWindow = driver.getWindowHandle();
	System.out.println("🔹 Original Tab Handle: " + originalWindow);

	// ✅ Click the element
	driver.findElement(By.xpath(locator)).click();
	System.out.println("✅ Clicked on element: " + locator);

	// ✅ Wait briefly to check if toast appears
	boolean isToastDisplayed = false;
	try {
		WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'You will be notified after PDF is ready to print')]")
		));

		// ✅ If toast appears, log and skip new tab handling
		System.out.println("✅ Toast Message Displayed: " + toast.getText());
		isToastDisplayed = true;
	} catch (Exception e) {
		System.out.println("⚠ No toast message appeared, proceeding to open new tab.");
	}

	// ✅ If toast is displayed, stop execution
	if (isToastDisplayed) {
		return;
	}

	// ✅ Wait for new tab to open
	wait.until(d -> d.getWindowHandles().size() > 1);

	// ✅ Get all window handles
	Set<String> allWindows = driver.getWindowHandles();
	System.out.println("🔹 All open windows: " + allWindows);

	// Find the new tab and close it
    for (String window : allWindows) {
        if (!window.equals(originalWindow)) {
            System.out.println("🔹 Switching to new tab: " + window);
            driver.switchTo().window(window);

            // Close the new tab
			try {
                System.out.println("⏳ Waiting 5 seconds before closing the new tab...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.close();
            System.out.println("✅ Successfully closed the new tab: " + window);

            // Switch back to the original tab
            driver.switchTo().window(originalWindow);
            System.out.println("🔄 Switched back to the original tab: " + originalWindow);
            break;
        }
    }
}


	







































	public void Sysout(String text)
	{
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
		String apiToken = "896751198:AAE9Xnl-I9yRLETN_l_p1zr06_Fr_SEWXEU";
		String chatId = "-760145184";
		urlString = String.format(urlString, apiToken, chatId, text);
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			@SuppressWarnings("unused")
			InputStream is = new BufferedInputStream(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
