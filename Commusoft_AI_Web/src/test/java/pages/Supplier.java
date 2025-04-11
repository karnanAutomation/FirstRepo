package pages;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import action.Baseclass;
import utility.LocatorString;
import utility.Locators;

public class Supplier extends Baseclass{

     WebDriver driver;
     Locators locators;
	public Supplier(WebDriver ldriver) throws IOException, GeneralSecurityException
	{
		this.driver =ldriver;
        this.locators = new Locators(driver); 
        locators.partsFlow();
		locators.jobCreate();

	}
    public Supplier addPO() throws IOException, GeneralSecurityException, InterruptedException
	{
        Thread.sleep(3000);
		click(driver,LocatorString.addPO);
        return this;
	}
    public Supplier supplierParts(String partName) throws IOException, GeneralSecurityException, InterruptedException
	{
		//search parts
		doubleClick(driver,LocatorString.supplierParts);
		type(driver,partName,LocatorString.nameType);
		typeEnter(driver,LocatorString.nameType);
        return this;
	}
    public Supplier supplierPartsNominal(String partName) throws IOException, GeneralSecurityException, InterruptedException
	{
		//search nominal code
		doubleClick(driver,LocatorString.partNominal);
		type(driver,partName,LocatorString.nameType); 
		typeEnter(driver,LocatorString.nameType);
        return this;
	}
    public Supplier deliveryMethod(String deliveryMethod) throws IOException, GeneralSecurityException, InterruptedException
	{
		//search delivery method
		doubleClick(driver,LocatorString.deliveryMethod);
		type(driver,deliveryMethod,LocatorString.nameType);
		typeEnter(driver,LocatorString.nameType);
        return this;
	}
    public Supplier poItems(String itemName) throws IOException, GeneralSecurityException, InterruptedException
	{
		//search PO Items
		doubleClick(driver,LocatorString.PoItems);
		type(driver,"Items",LocatorString.PoItemName);
		typeEnter(driver,LocatorString.PoItemName);
        return this;
	}
    public Supplier poItemNominal(String itemName) throws IOException, GeneralSecurityException, InterruptedException
	{
		//search item nominal code
		doubleClick(driver,LocatorString.PoItemNominal);
		type(driver,itemName,LocatorString.nameType); 
		click(driver,LocatorString.PoItemNominalSelect);
        return this;
	}
    public Supplier savePO() throws IOException, GeneralSecurityException, InterruptedException
	{
		click(driver,LocatorString.savePO);
        return this;
	}
    public Supplier verifySavePO() throws IOException, GeneralSecurityException, InterruptedException
	{
		isElementClickable(driver, LocatorString.VerifysavePO);
        return this;
	}
    public Supplier addSupplierInvoice() throws IOException, GeneralSecurityException, InterruptedException
	{
		Thread.sleep(5000);
		click(driver,LocatorString.addsupplierInvoice);
        return this;
	}
    public Supplier addSupplierInvoiceNum() throws IOException, GeneralSecurityException, InterruptedException
	{
		//for loop starts

	int invoiceNumber = 532; 
    int maxAttempts = 10000; 
    boolean isUnique = false;

    for (int i = 0; i < maxAttempts; i++) {
        // Type the invoice number
        type(driver, String.valueOf(invoiceNumber), LocatorString.addsupplierInvoiceNum);
        try {
            Thread.sleep(1000);  // Wait for toast to appear
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Check if the toast message appears
        List<WebElement> toastMessages = driver.findElements(By.xpath(LocatorString.invoiceNumExist));
        if (toastMessages.isEmpty()) {
            isUnique = true;
            break;  // Break loop if invoice number is unique
        }
        invoiceNumber++;
    }
    if (!isUnique) {
        System.out.println("Couldn't find a unique invoice number within the limit.");
    } else {
        System.out.println("Unique invoice number assigned: " + invoiceNumber);
    }

    doubleClick(driver, LocatorString.invoiceParts);

		//for loop ends
        return this;
	}
    public Supplier addInvoicePart(String partsName) throws IOException, GeneralSecurityException, InterruptedException
	{
		type(driver,partsName,LocatorString.nameType);
	    click(driver,LocatorString.addInvoicePart);
        return this;
	}
    public Supplier addPartQty(String qty) throws IOException, GeneralSecurityException, InterruptedException
	{
		//parts quantity
	    doubleClick(driver,LocatorString.addPartQty);
	    type(driver,qty,LocatorString.addPartQtyType);		
	    typeEnter(driver,LocatorString.addPartQtyType);
        return this;
	}
	public Supplier partsTAB() throws InterruptedException
	{
		doubleClick(driver,LocatorString.addPartVAT);
		typeEnter(driver,LocatorString.addPartVATType);
		return this;
	}
    public Supplier addPartCost(String cost) throws IOException, GeneralSecurityException, InterruptedException
	{
		//unit cost price
	    doubleClick(driver,LocatorString.addPartQty);
	    type(driver,cost,LocatorString.addPartQtyType);
	    typeEnter(driver,LocatorString.addPartQtyType);
        return this;
	}
    public Supplier addPartVat(String cost) throws IOException, GeneralSecurityException, InterruptedException
	{
		//vat rate
	doubleClick(driver,LocatorString.addPartVAT);
	type(driver,cost,LocatorString.addPartVATType);
	click(driver,LocatorString.addPartVATT);
        return this;
	}
    public Supplier addPartNominal() throws IOException, GeneralSecurityException, InterruptedException
	{
		//nominal code
	    doubleClick(driver,LocatorString.addPartNominal);
	    click(driver,LocatorString.addPartNominal1);
        return this;
	}
    public Supplier addItem(String itemName) throws IOException, GeneralSecurityException, InterruptedException
	{
		//items
	    doubleClick (driver,LocatorString.addItem);
	    type(driver,itemName,LocatorString.addItemType);
	    typeEnter(driver,LocatorString.addItemType);
        return this;
	}
    public Supplier addItemQty(String qty) throws IOException, GeneralSecurityException, InterruptedException
	{
		//item quantity
	    doubleClick(driver,LocatorString.addItemQty);
	    type(driver,qty,LocatorString.addItemQtyType);		
	    typeEnter(driver,LocatorString.addItemQtyType);
        return this;
	}
    public Supplier addItemUnitPrice(String qty) throws IOException, GeneralSecurityException, InterruptedException
	{
		//item unit price
	    doubleClick(driver,LocatorString.addItemQty);
	    type(driver,qty,LocatorString.addItemQtyType);
	    typeEnter(driver,LocatorString.addItemQtyType);
        return this;
	}
    public Supplier addItemUSalePrice(String qty) throws IOException, GeneralSecurityException, InterruptedException
	{
		//item scale
	    doubleClick(driver,LocatorString.addItemQty);
	    type(driver,qty,LocatorString.addItemType);
	    typeEnter(driver,LocatorString.addItemType);
        return this;
	}
	public Supplier itemTAB() throws InterruptedException
	{
		doubleClick(driver,LocatorString.addPartVAT);
		typeEnter(driver,LocatorString.addPartVATType);
		return this;
	}
    public Supplier addItemVat(String Vat) throws IOException, GeneralSecurityException, InterruptedException
	{
		//item vat
	    doubleClick(driver,LocatorString.addPartVAT);
	    type(driver,Vat,LocatorString.addPartVATType);
	    click(driver,LocatorString.addPartVATT);
        return this;
	}
    public Supplier addItemnominal() throws IOException, GeneralSecurityException, InterruptedException
	{
		//item nominal code
	    doubleClick(driver,LocatorString.addPartNominal);
	    click(driver,LocatorString.addPartNominal1);
        return this;
	}
	public Supplier verifyCostTapPO() throws IOException, GeneralSecurityException, InterruptedException
	{
		isElementPresent(driver, LocatorString.verifyCostTapPO);
        return this;
	}
	public Supplier verifyCostTapPOUS() throws IOException, GeneralSecurityException, InterruptedException
	{
		isElementPresent(driver, LocatorString.verifyCostTapPOUS);
		return this;
	}











    



















    
    









}
