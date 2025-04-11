package testcases;

import action.Baseclass;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.testng.annotations.Test;
import pages.Commusoft;
import utility.LocatorString;
import utility.RerunTestCase;

import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeoutException;


public class smokeOwnerUS extends Baseclass {



	@Test(priority = 1)
	public void createCustomer() throws IOException, InterruptedException, GeneralSecurityException,
			InvalidTokenException, ObsoleteVersionException, AgentConnectException {
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewPrivateCustomer()
				.selectTitle()
				.firstName()
				.secondName()
				.landlineNumber()
				.mobileNumber()
				.email("karnan@commusoft.com")
				.addressLine1()
				.customerSave()
				.getCustomerPage()
				.getCustomerNumber();
	}

	@Test(priority = 2)
	public void editCustomer() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartCustomer("Edit the Customer")
				.editPrivateCustomer()
				.editTitle()
				.firstName()
				.secondName()
				.editLandlineNumber()
				.editMobileNumber()
				.editEmail()
				.editAddressLine1()
				.customerSave()
				.verifySave();
	}

	@Test(priority = 3, retryAnalyzer = RerunTestCase.class)
	public void addPreFinalJob() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		driver.get(seleniumhomepage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewPrivateCustomer()
				.selectTitle()
				.firstName()
				.secondName()
				.landlineNumber()
				.mobileNumber()
				.email("karnan@commusoft.com")
				.addressLine1()
				.customerSave()
				.getCustomerPage()
				.getCustomerNumber()
				.searchCustomer()
				.searchCustomerClick();
		commusoft.addNewJob()
				.jobCreate("PreFinal")
				.invoiceTab()
				.verifyInvoiceraised("Prefinal");
	}

	@Test(priority = 4,  retryAnalyzer = RerunTestCase.class)
	public void addJobFinalComplete() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("AutoFinal")
				.editandCompletejob()
				.invoiceTab()
				.verifyInvoiceraised("Final");
	}

	@Test(priority = 5)
	public void addJobWithoutRules() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException {

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.subTotal("500")
				.saveInvoice()
				.verifyInvoiceRasied();
	}

	@Test(priority = 6, retryAnalyzer = RerunTestCase.class)
	public void addJobNoRulesAdditionalInvoice() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Additional invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.fullBreakdownbyCategory()
				.Labour("Labour")
				.labourPrice("300")
				.parts("Price one")
				.saveInvoice()
				.verifyInvoiceRasied();
	}

	@Test(priority = 7, retryAnalyzer = RerunTestCase.class)
	public void acceptEstimate() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewEstimate()
				.chooseDescription("2")
				.estimateNotes("Estimate Note")
				.customerReference("Customer Reference")
				.userGroup("1")
				.estiamteSave();
		commusoft.functionStartEstimate("Accept Estimate")
				.priceTab()
				.noBreakDown()
				.partsTotal("600")
				.estimateInvoiceSchedule()
				.invoiceScheduleDeposit("200")
				.invoiceScheduleCompletion("200")
				.invoiceScheduleRetention("200")
				.sendtoCustomer()
				.acceptOrreject()
				.estimateCheckbox()
				.clickestimateAccept()
				.typeAcceptorReject("ACCEPT")
				.clickAcceptatlast()
				.verifyestimateAcceptUS();
	}

	@Test(priority = 8, retryAnalyzer = RerunTestCase.class)
	public void rejectEstimate() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewEstimate()
				.chooseDescription("2")
				.estimateNotes("Estimate Note")
				.customerReference("Customer Reference")
				.userGroup("1")
				.estiamteSave();
		commusoft.functionStartEstimate("Accept Estimate")
				.priceTab()
				.noBreakDown()
				.partsTotal("600")
				.estimateInvoiceSchedule()
				.invoiceScheduleDeposit("200")
				.invoiceScheduleCompletion("200")
				.invoiceScheduleRetention("200")
				.sendtoCustomer()
				.acceptOrreject()
				.estimateCheckbox()
				.clickestimateReject()
				.typeAcceptorReject("REJECT")
				.rejectReason("Too expensive")
				.clickAcceptatlast()
				.verifyestimateReject();
	}
	@Test(priority = 9, retryAnalyzer = RerunTestCase.class)
	public void createJobNoRulesWithDiaryEvent() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules");
		commusoft.functionStartDiary("Add Diary Event")
				.addDiaryUS()
				.dailyButton()
				.today()
				.timing4_430()
				.saveDiary()
				.verifyDiaryCreatedUS();
	}

	@Test(priority = 10, retryAnalyzer = RerunTestCase.class)
	public void addPaymentJob() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Additional invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.fullBreakdownbyCategory()
				.Labour("Labour")
				.labourPrice("300")
				.parts("Price one")
				.saveInvoice()
				.verifyInvoiceRasied();
		commusoft.functionStartInvoice("Email, Print, Invoice Payment")
				.emailInvoice()
				.printInvoice()
				.invoicePayment("Job payments","180");
	}

	@Test(priority = 11, retryAnalyzer = RerunTestCase.class)
	public void createWorkAddress() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartCustomer("Add Work Address")
				.workAddressTab()
				.workAddressButton()
				.workAddressName("Karikalan")
				.workAddressSurName("Athisivam")
				.workAddressLandline("8248724397")
				.workAddressMobile("8248724397")
				.workAddressEmail("karnan@commusoft.com")
				.workAddressAddressLine1("Mayiladuthurai")
				.workAddressSave()
				.getWorkAddressPage();
	}

	@Test(priority = 12, retryAnalyzer = RerunTestCase.class)
	public void editWorkAddress() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webworkaddresspage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartCustomer("Edit Work Address")
				.workAddressEdit()
				.workAddressTitleEdit()
				.workAddressNameEdit("Nishana")
				.workAddresslastNameEdit("SuresKumar")
				.workAddresslandlineEdit("8248724397")
				.workAddressMobileEdit("8248724397")
				.workAddressEmailEdit("karnan@commusoft.com")
				.workAddressAddressEdit("Chennai Mahanagaram")
				.workAddressSave();
	}

	@Test(priority = 13, retryAnalyzer = RerunTestCase.class)
	public void waAddJobPreFinal() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webworkaddresspage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("PreFinal")
				.invoiceTab()
				.verifyInvoiceraised("Prefinal");
	}

	@Test(priority = 14, retryAnalyzer = RerunTestCase.class)
	public void waAddPaymentJob() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webworkaddresspage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Additional invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.fullBreakdownbyCategory()
				.Labour("Labour")
				.labourPrice("300")
				.parts("Price one")
				.saveInvoice()
				.verifyInvoiceRasied();
		commusoft.functionStartInvoice("Email, Print, Invoice Payment")
				//.emailInvoice()
				.printInvoice()
				.invoicePayment("Job payments","180");
	}

	@Test(priority = 15, retryAnalyzer = RerunTestCase.class)
	public void waEstimateAccept() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webworkaddresspage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewEstimate()
				.chooseDescription("2")
				.estimateNotes("Estimate Note")
				.customerReference("Customer Reference")
				.userGroup("1")
				.estiamteSave();
		commusoft.functionStartEstimate("Accept Estimate")
				.priceTab()
				.noBreakDown()
				.partsTotal("600")
				.estimateInvoiceSchedule()
				.invoiceScheduleDeposit("200")
				.invoiceScheduleCompletion("200")
				.invoiceScheduleRetention("200")
				.sendtoCustomer()
				.acceptOrreject()
				.estimateCheckbox()
				.clickestimateAccept()
				.typeAcceptorReject("ACCEPT")
				.clickAcceptatlast()

				.verifyestimateAcceptUS();
	}

	@Test(priority = 16, retryAnalyzer = RerunTestCase.class)
	public void addInvoice() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.fullBreakdownbyCategory()
				.Labour("Labour")
				.labourPrice("150.84")
				.parts("Price one")
				.saveInvoice()
				.verifyInvoiceRasied();
	}

	@Test(priority = 17, retryAnalyzer = RerunTestCase.class)
	public void editInvoice() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.fullBreakdownbyCategory()
				.Labour("Labour")
				.labourPrice("150.84")
				.parts("Price one")
				.saveInvoice()
				.verifyInvoiceRasied();
		commusoft.functionStartInvoice("Edit Invoice")
				.editInvoicebutton()
				.invoiceType("Interim invoice")
				.editInvoiceDescription("Invoice Description")
				.editInvoiceCategory()
				.editUserGroup()
				.invoicebreakdownEdit()
				.descriptionNameedit("Parts")
				.descriptionValueedit("100.85")
				.clickVAT()
				.saveInvoice();
	}

	@Test(priority = 18, retryAnalyzer = RerunTestCase.class)
	public void deleteInvoice() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(LocatorString.invoicepage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartInvoice("Delete Invoice")
				.quickLinkfromInvoice()
				.deleteInvoicebutton()
				.deleteInvoiceType("delete")
				.deleteInvoicebtn()
				.verifyDeleteInvoice();
	}

	@Test(priority = 19, retryAnalyzer = RerunTestCase.class)
	public void addingAdditionalInvoiceNoBreakdown() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Additional invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.subTotal("500")
				.saveInvoice()
				.verifyInvoiceRasied();
	}

	@Test(priority = 20, retryAnalyzer = RerunTestCase.class)
	public void addingAdditionalInvoiceBreakdownByCategory() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Additional invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.invoicebreakdownEdit()
				.descriptionNameedit("Parts")
				.descriptionValueedit("100.85")
				.clickVAT()
				.saveInvoice()
				.verifyInvoiceRasied();
	}

	@Test(priority = 21, retryAnalyzer = RerunTestCase.class)
	public void addingInterimInvoiceFullBreakdown() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Interim invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.invoiceFullbreakdown()
				.descriptionNameedit("Parts")
				.descriptionValueedit("100.85")
				.clickVAT()
				.saveInvoice()
				.verifyInvoiceRasied();
	}

	@Test(priority = 22, retryAnalyzer = RerunTestCase.class)
	public void addingPrefinalInvoiceFullBreakdownByCategory() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Pre-final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.fullBreakdownbyCategory()
				.Labour("Labour")
				.labourPrice("10.55")
				.parts("Price one")
				.saveInvoice()
				.verifyInvoiceRasied();
	}

	@Test(priority = 23, retryAnalyzer = RerunTestCase.class)
	public void addingFinalInvoiceFullBreakdownByCategory() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.fullBreakdownbyCategory()
				.Labour("Labour")
				.labourPrice("20.55")
				.parts("Price one")
				.saveInvoice()
				.verifyInvoiceRasied();
	}

	@Test(priority = 24, retryAnalyzer = RerunTestCase.class)
	public void minusDepositRetInterimOnFinal() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewEstimate()
				.chooseDescription("2")
				.estimateNotes("Estimate Note")
				.customerReference("Customer Reference")
				.userGroup("1")
				.estiamteSave();
		commusoft.functionStartEstimate("Accept Estimate")
				.priceTab()
				.noBreakDown()
				.partsTotal("600")
				.estimateInvoiceSchedule()
				.invoiceScheduleDeposit("200")
				.invoiceScheduleCompletion("200")
				.invoiceScheduleRetention("200")
				.sendtoCustomer()
				.acceptOrreject()
				.estimateCheckbox()
				.clickestimateAccept()
				.typeAcceptorReject("ACCEPT")
				.clickAcceptatlast()
				.verifyestimateAcceptUS();
		commusoft.functionStartJob("Interim Invoice Creation")
				.invoiceTab(); Thread.sleep(2000);
		LocatorString.minusInvoiceMain = driver.getCurrentUrl();
		commusoft.clickAddInvoice()
				.invoiceType("Interim invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.subTotal("100")
				.saveInvoice()
				.verifyInvoiceRasied();
		commusoft.functionStartJob("Final Invoice Creation");
		Thread.sleep(2000);
		driver.get(LocatorString.minusInvoiceMain);
		commusoft.clickAddInvoice()
				.invoiceType("Final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.saveInvoice()
				.verifyInvoiceRasied()
				.verifyInvoiceCalculation();
	}

	@Test(priority = 25, retryAnalyzer = RerunTestCase.class)
	public void searchInvoice() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.fullBreakdownbyCategory()
				.Labour("Labour")
				.labourPrice("20.55")
				.parts("Price one")
				.saveInvoice()
				.verifyInvoiceRasied()
				.getInvoiceNumber()
				.typeInvoiceNuminSearch()
				.invoiceInSearch();
	}

	@Test(priority = 26, retryAnalyzer = RerunTestCase.class)
	public void estimateDiary() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartDiary("Add Estimate with Diary Event")
				.diaryTabUS()
				.dailyButton()
				.today()
				.timing930_10()
				// .diaryPM()
				.diaryEstimate()
				.diaryCustomerSearch("Karnan")
				.diaryCustomerSelect()
				.diaryDesChoose()
				.saveDiary();
	}
	@Test(priority = 27, retryAnalyzer = RerunTestCase.class)
	public void jobDiary() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartDiary("Add Job with Diary Event")
				.diaryTabUS()
				.dailyButton()
				.today()
				.timing930_10()
				.diaryJob()
				.diaryCustomerSearch("Karnan")
				.diaryCustomerSelect()
				.diaryJobDes()
				.saveDiary();
	}

	@Test(priority = 28, retryAnalyzer = RerunTestCase.class)
	public void normalDiary() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartDiary("Add Normal Event")
				.diaryTabUS()
				.dailyButton()
				.today()
				.timing430_5()
				.normalDes("Normal Event")
				.saveDiary();
	}

	@Test(priority = 29, retryAnalyzer = RerunTestCase.class)
	public void jobFromDiarywithCustomer() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartDiary("Add Job with Customer Create")
				.diaryTabUS()
				.dailyButton()
				.today()
				.timing530_6()
				.diaryJob()
				.addCusfromDiary()
				.diaryJobDes()
				.saveDiary();
	}

	@Test(priority = 30, retryAnalyzer = RerunTestCase.class)
	public void diaryUtility() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(seleniumhomepage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartDiary("Diary Utility checks")
				.diaryTabUS()
				.printJobSheet()
				.printSummarySheet();
	}

	@Test(priority = 31, retryAnalyzer = RerunTestCase.class)
	public void createSupplier() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartCustomer("Supplier Creation")
				.supplierTabUS()
				.supplierAdd()
				.supplierName()
				.supplierEmail()
				.supplierAdderss1()
				.supplierAdderss2()
				.supplierSave();
	}

	@Test(priority = 32, retryAnalyzer = RerunTestCase.class)
	public void supplierPO() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		driver.get(LocatorString.Supplierhomepage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartSupplier("Add Purchase Order to Supplier")
				.addPO()
				.supplierParts("Parts")
				.supplierPartsNominal("Parts")
				.deliveryMethod("Delivery to office")
				.poItems("Items")
				.poItemNominal("rent")
				.savePO()
				.verifySavePO();
	}

	@Test(priority = 33)
	public void supplierInvoice() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		driver.get(LocatorString.Supplierhomepage);
		Commusoft commusoft = new Commusoft(driver); Thread.sleep(2000);
		commusoft.functionStartSupplier("Add Invocie to Supplier")
				.addSupplierInvoice()
				.addSupplierInvoiceNum()
				.addInvoicePart("part")
				.addPartQty("10")
				.addPartCost("300")
				.partsTAB()
				.addPartNominal()
				.addItem("Demo")
				.addItemQty("10")
				.addItemUnitPrice("200")
				.addItemUSalePrice("400")
				.itemTAB()
				.addItemnominal()
				.savePO();
	}

	@Test(priority = 34, retryAnalyzer = RerunTestCase.class)
	public void createCustomerContact() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartCustomer("Create Contact for the Customer")
				.contactTab()
				.addContact()
				.contactName("Athisivam")
				.contactSurName("R")
				.contactEmail("karnan@commusoft.com")
				.contactPhone("8248724397")
				.saveContact()
				.verifyContact();
	}

	@Test(priority = 35, retryAnalyzer = RerunTestCase.class)
	public void customerReports() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Customer Report")
				.reportingTap()
				.sideMenu()
				.Customers()
				.customerReport()
				.filter()
				.datePicker()
				.todayDate()
				.applyFilter()
				.firstButton()
				.viewFirstCustomer();
	}

	@Test(priority = 36, retryAnalyzer = RerunTestCase.class)
	public void serviceReminderReports() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Service Reminders Report")
				.reportingTap()
				.sideMenu()
				.serviceReminders()
				.serviceReminderReport()
				.verifyServiceReminderReport();
	}

	@Test(priority = 37, retryAnalyzer = RerunTestCase.class)
	public void supplierReports() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Supplier Report")
				.reportingTap()
				.sideMenu()
				.suppliers()
				.supplierReport()
				.verifySupplierReport();
	}

	@Test(priority = 38, retryAnalyzer = RerunTestCase.class)
	public void estimateReports() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Estimate Report")
				.reportingTap()
				.sideMenu()
				.estimates()
				.estimateReport()
				.filter()
				.datePicker()
				.todayDate()
				.applyFilter()
				.firstButton()
				.viewFirstEstimate();
	}

	@Test(priority = 39, retryAnalyzer = RerunTestCase.class)
	public void jobReports() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Job Report")
				.reportingTap()
				.sideMenu()
				.jobs()
				.jobReport()
				.firstButton()
				.viewFirstEstimate();
	}

	@Test(priority = 40, retryAnalyzer = RerunTestCase.class)
	public void workAddressReports() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Work Address Report")
				.reportingTap()
				.sideMenu()
				.Customers()
				.workAddressReport()
				.filter()
				.datePicker()
				.todayDate()
				.applyFilter()
				.firstButton()
				.viewFirstEstimate();
	}

	@Test(priority = 41, retryAnalyzer = RerunTestCase.class)
	public void customersReportPrint() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, AWTException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Customer Report Print")
				.reportingTap()
				.sideMenu()
				.Customers()
				.customerReport()
				.filter()
				.datePicker()
				.thisWeekReport()
				.applyFilter()
				.printReport();
		// .handleFileDownload();
	}

	@Test(priority = 42, retryAnalyzer = RerunTestCase.class)
	public void jobsReportPrint() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, AWTException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Job Report Print")
				.reportingTap()
				.sideMenu()
				.jobs()
				.jobReport()
				.filter()
				.jobsDates()
				.thisWeekReport()
				.applyFilter()
				.printReport();
		// .handleFileDownload();
	}

	@Test(priority = 43, retryAnalyzer = RerunTestCase.class)
	public void timeSheetReport() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, AWTException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Job Report Print")
				.reportingTap()
				.sideMenu()
				.users()
				.usersReport()
				.filter()
				.diaryEventDate()
				.thisWeekReport()
				.applyFilter()
				.printReport();
	}

	@Test(priority = 44, retryAnalyzer = RerunTestCase.class)
	public void changeInvoiceType() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Additional invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.fullBreakdownbyCategory()
				.Labour("Labour")
				.labourPrice("150.84")
				.parts("Price one")
				.saveInvoice()
				.verifyInvoiceRasied();
		commusoft.functionStartInvoice("Edit & Change Invoice Type")
				.editInvoicebutton()
				.invoiceType("Final invoice")
				.editInvoiceDescription("Invoice Description")
				.editInvoiceCategory()
				.editUserGroup()
				.invoicebreakdownEdit()
				.descriptionNameedit("Parts")
				.descriptionValueedit("100.85")
				.clickVAT()
				.saveInvoice();
	}

	@Test(priority = 45, retryAnalyzer = RerunTestCase.class)
	public void serviceReminder() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, AWTException {

		driver.get(seleniumhomepage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Job Report Print")
				.viewAllServiceReminder()
				.check2ServiceReminder()
				.processing()
				.verifyProcessed();
	}

	@Test(priority = 46, retryAnalyzer = RerunTestCase.class)
	public void solarSearchPageResponse() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, AWTException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Solar Search Page response")
				.searchCustomerVerifyPageResponse();
	}

	@Test(priority = 46, retryAnalyzer = RerunTestCase.class)
	public void getInvoiceNumberAPI() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, AWTException {

		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartReporting("Job Report Print")
				.searchCustomerVerifyPageResponse();
	}

	@Test(priority = 47, retryAnalyzer = RerunTestCase.class)
	public void estimateAcceptedInPortal() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewEstimate()
				.chooseDescription("2")
				.estimateNotes("Estimate Note")
				.customerReference("Customer Reference")
				.userGroup("1")
				.estiamteSave();
		commusoft.functionStartEstimate("Accept Estimate")
				.priceTab()
				.noBreakDown()
				.partsTotal("600")
				.estimateInvoiceSchedule()
				.invoiceScheduleDeposit("200")
				.invoiceScheduleCompletion("200")
				.invoiceScheduleRetention("200")
				.sendtoCustomer()
				.emailSent()
				.notesTab()
				.estimatePortalLink()
				.estimateAcceptinPortal()
				.estimateDetails()
				.verifyEstimateAccepted();
	}

	@Test(priority = 48)
	public void additionalWorkwithInvoice() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.additionalWorkTabUS()
				.createAdditionalWork();
		commusoft.functionStartEstimate("Adding Additional Work")
				.priceTab()
				.noBreakDown()
				.partsTotal("600")
				.estimateInvoiceSchedule()
				.invoiceScheduleDeposit("200")
				.invoiceScheduleCompletion("200")
				.invoiceScheduleRetention("200")
				.sendtoCustomer()
				.acceptOrreject()
				.clickestimateAccept()
				.typeAcceptorReject("ACCEPT")
				.clickAcceptatlast()
				.invoiceTab();
		commusoft.functionStartInvoice("Adding Final Invoice")
				.clickAddInvoice()
				.invoiceType("Final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.invoiceLineItemUS()
				.invoiceLineItemSelect()
				.saveLineItem()
				.saveInvoice()
				.verifyInvoiceRasied();
	}

	@Test(priority = 49, retryAnalyzer = RerunTestCase.class)
	public void diaryViews() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException{

		driver.get(seleniumhomepage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartDiary("View Diary Views")
				.diaryTabUS()
				.diaryDaily()
				.diaryWeekly()
				.diaryTwoWeeklyUS()
				.diaryMonthly()
				.diaryDaily();
	}

	@Test(priority = 50, retryAnalyzer = RerunTestCase.class)
	public void jobCostAddLabour() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("PreFinal")
				.jobCostTab()
				.addLabour()
				.verifyLabourAdded();
		LocatorString.JobCostPage = driver.getCurrentUrl();
	}

	@Test(priority = 51, retryAnalyzer = RerunTestCase.class)
	public void jobCostAddTravel() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException{

		driver.get(LocatorString.JobCostPage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartJob("Add Travel to Job")
				.addTravel()
				.clickEngineer()
				.chooseEngineer()
				.travelPrice()
				.saveTravel();
	}

	@Test(priority = 52)
	public void jobCostAddPO() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException{

		driver.get(LocatorString.JobCostPage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartJob("Add PO to Job")
				.jobPO()
				.jobPOSupplier()
				.emailSuppliercheck();
		commusoft.functionStartSupplier("Add Purchase Order to Job")
				.supplierParts("Parts")
				.supplierPartsNominal("Parts")
				.deliveryMethod("Delivery to office")
				.poItems("Items")
				.poItemNominal("rent")
				.savePO()
				.verifyCostTapPOUS();
	}

	@Test(priority = 53, retryAnalyzer = RerunTestCase.class)
	public void emailCheckBox() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Additional invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.subTotal("500")
				.emailCheckBox()
				.saveInvoice()
				.verifyInvoiceRasiedwithEmail();
	}

	@Test(priority = 54, retryAnalyzer = RerunTestCase.class)
	public void serviceJobandInvoice() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException {

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.serviceJobCreate("No Rules")
				.addDiaryEvent();
		commusoft.functionStartDiary("Adding Diary Event")
				.diaryDaily()
				.today()
				.timing11PM()
				.saveDiary();
		commusoft.functionStartJob("Invoice Tab")
				.invoiceTab();
		commusoft.functionStartInvoice("Create Invoice")
				.clickAddInvoice()
				.invoiceType("Final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.subTotal("500")
				.saveInvoice()
				.selectService()
				.saveService()
				.verifyInvoiceRasied();
	}

	@Test(priority = 55, retryAnalyzer = RerunTestCase.class)
	public void checkMapLoading() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartDiary("Name")
				.diaryTabUS()
				.clickMap()
				.verifyMapLoading();
	}

	@Test(priority = 56, retryAnalyzer = RerunTestCase.class)
	public void verifyLiveAPILoading() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartAPI("API Loading Check")
				.apiLoaderUS();
	}

	@Test(priority = 57, retryAnalyzer = RerunTestCase.class)
	public void serviceJobfromEdit() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException {

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.editJob()
				.serviceJob()
				.saveJob()
				.verifyServiceJob();
	}

	@Test(priority = 58, retryAnalyzer = RerunTestCase.class)
	public void additionalInvoiceConvert() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException {

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Additional invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.subTotal("500")
				.advanceOption()
				.draftCheckbox()
				.saveInvoice()
				.clickDraftInvoice()
				.confirmText()
				.confirmButton()
				.verifyInvoiceRasied();
	}

	@Test(priority = 59, retryAnalyzer = RerunTestCase.class)
	public void interimInvoiceConvert() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException {

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Interim invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.subTotal("500")
				.advanceOption()
				.draftCheckbox()
				.saveInvoice()
				.clickDraftInvoice()
				.confirmText()
				.confirmButton()
				.verifyInvoiceRasied();
	}

	@Test(priority = 60, retryAnalyzer = RerunTestCase.class)
	public void prefinalInvoiceConvert() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException {

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Pre-final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.subTotal("500")
				.advanceOption()
				.draftCheckbox()
				.saveInvoice()
				.clickDraftInvoice()
				.confirmText()
				.confirmButton()
				.verifyInvoiceRasied();
	}

	@Test(priority = 61, retryAnalyzer = RerunTestCase.class)
	public void finalInvoiceConvert() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException {

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.subTotal("500")
				.advanceOption()
				.draftCheckbox()
				.saveInvoice()
				.clickDraftInvoice()
				.confirmText()
				.confirmButton()
				.verifyInvoiceRasied();
	}

	@Test(priority = 62, retryAnalyzer = RerunTestCase.class)
	public void TRIAG_4027() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewEstimate()
				.chooseDescription("2")
				.estimateNotes("Estimate Note")
				.customerReference("Customer Reference")
				.userGroup("1")
				.estiamteSave();
		commusoft.functionStartEstimate("Accept Estimate")
				.priceTab()
				.noBreakDown()
				.partsTotal("600")
				.estimateInvoiceSchedule()
				.invoiceScheduleDeposit("200")
				.invoiceScheduleCompletion("200")
				.invoiceScheduleRetention("200")
				.sendtoCustomer()
				.acceptOrreject()
				.estimateCheckbox()
				.clickestimateAccept()
				.typeAcceptorReject("ACCEPT")
				.clickAcceptatlast()
				.verifyestimateAcceptUS();
		commusoft.functionStartJob("Check Invoice Does not have VAT Option")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Final invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.verifyVATnotDisplayed()
				.saveInvoice()
				.verifyInvoiceRasied();
	}

	@Test(priority = 63, retryAnalyzer = RerunTestCase.class)
	public void afterSalesCareInvoiceEmailCheck() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.invoiceTab();
		commusoft.clickAddInvoice()
				.invoiceType("Additional invoice")
				.copyfromJD()
				.userGroup()
				.invoiceCategory()
				.fullBreakdownbyCategory()
				.Labour("Labour")
				.labourPrice("150.84")
				.parts("Price one")
				.saveInvoice()
				.verifyInvoiceRasied();
		commusoft.functionStartInvoice("Verify After Sales Care Email")
				.editInvoicebutton()
				.invoiceType("Final invoice")
				.editInvoiceDescription("Invoice Description")
				.editInvoiceCategory()
				.editUserGroup()
				.invoicebreakdownEdit()
				.descriptionNameedit("Parts")
				.descriptionValueedit("100.85")
				.clickVAT()
				.saveInvoice()
				.jobTabfromInvoice()
				.jobNotes()
				.verifyEmailsent();
	}

	@Test(priority = 64, retryAnalyzer = RerunTestCase.class)
	public void afterSalesCareFocEmailCheck() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.quickLink()
				.FOC()
				.reasonFOC()
				.commentFOC()
				.submitFOC()
				.verifyFOC();
		commusoft.functionStartInvoice("Verify After Sales Care Email")
				.jobNotes()
				.verifyEmailsent();
	}

	@Test(priority = 65, retryAnalyzer = RerunTestCase.class)
	public void consolidatedInvoice() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(seleniumhomepage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewPrivateCustomer()
				.selectTitle()
				.firstName()
				.secondName()
				.landlineNumber()
				.mobileNumber()
				.email("karnan@commusoft.com")
				.addressLine1()
				.customerSave()
				.getCustomerPage()
				.getCustomerNumber();
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.customerFromJob();
		commusoft.addNewJob()
				.jobCreate("No Rules")
				.customerFromJob()
				.quickLinkfromJob();
		commusoft.functionStartInvoice("Addint Consolidated Invoice")
				.consolidateInvoice()
				.invoiceDescription()
				.invoiceNotes()
				.invoiceCategory()
				.invoiceAdditional()
				.invoiceInterim()
				.invoiceTotalVerify();
	}

	@Test(priority = 66, retryAnalyzer = RerunTestCase.class)
	public void createCompany() throws IOException, InterruptedException, GeneralSecurityException,
			InvalidTokenException, ObsoleteVersionException, AgentConnectException {
		driver.get(seleniumhomepage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartCustomer("Company Creation")
				.addNewCompany()
				.companyName("Commusoft Pvt Ltd")
				.companyAddress("4th Floor,Commerzone IT Park, Chennai, 600116")
				.secondName()
				.landlineNumber()
				.mobileNumber()
				.email("karnan@commusoft.com")
				.customerSave()
				.verifySave()
				.getCompanyPage()
				.getCompanyNumber();
	}

	@Test(priority = 67, retryAnalyzer = RerunTestCase.class)
	public void editCompany() throws IOException, InterruptedException, GeneralSecurityException,
			InvalidTokenException, ObsoleteVersionException, AgentConnectException {
		driver.get(webcompanypage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartCustomer("Edit Company")
				.editCompanyButton()
				.companyName("Edited Pvt Ltd")
				.companyAddress("Edited Address")
				.editCompanySaveButton();
	}

	@Test(priority = 68, retryAnalyzer = RerunTestCase.class)
	public void deleteCompany() throws IOException, InterruptedException, GeneralSecurityException,
			InvalidTokenException, ObsoleteVersionException, AgentConnectException {
		driver.get(webcompanypage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartCustomer("Delete Company")
				.companyQuickLinks()
				.deleteCompany()
				.deleteConfirmationText("Delete")
				.deleteCompanyButton()
				.verifyDeleteCompany();
	}

	@Test(priority = 69, retryAnalyzer = RerunTestCase.class,description="TRIAG-11495")
	public void addJobModifyFinalInvoice() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

//		driver.get(webcustomerpage);
		driver.get("https://app.commusoft.us/customers/customer/5164/view_v2/property/view");
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("AutoFinal")
				.editandCompletejob()
				.invoiceTab()
				.verifyInvoiceraised("Final")
				.viewInvoice()
				.editInvoice()
				.editInvoiceNotes()
				.editNominalCode();
		commusoft.functionStartInvoice("Edit Final Invoice")
				.saveInvoice()
				.verifyInvoiceEmail();
	}

	@Test(priority = 70, retryAnalyzer = RerunTestCase.class)
	public void createLandLordFromWA() throws InvalidTokenException, AgentConnectException, IOException, ObsoleteVersionException, InterruptedException, GeneralSecurityException, TimeoutException{

		driver.get(webcustomerpage);
		Commusoft commusoft = new Commusoft(driver);
		commusoft.functionStartCustomer("Add LandLord from Work Address")
				.workAddressTab()
				.workAddressButton()
				.addNewLL()
				.titleLandLord("Mr & Mrs")
				.nameLandlord("LandLord")
				.surnameLandlord("Surname")
				.addressLandlord("Central London")
				.saveLL();
		commusoft.functionStartCustomer("Add Work Address")
				.workAddressName("Karikalan")
				.workAddressSurName("Athisivam")
				.workAddressLandline("8248724397")
				.workAddressMobile("8248724397")
				.workAddressEmail("karnan@commusoft.com")
				.workAddressAddressLine1("Mayiladuthurai")
				.workAddressSave()
				.verifySave()
				.getWorkAddressPage();
	}

	@Test(priority = 71, retryAnalyzer = RerunTestCase.class)
	public void addCertificate() throws InvalidTokenException, AgentConnectException, IOException,
			ObsoleteVersionException, InterruptedException, GeneralSecurityException {

//		driver.get(webcustomerpage);
		driver.get("https://app.commusoft.us/customers/customer/5164/view_v2/property/view");
		Commusoft commusoft = new Commusoft(driver);
		commusoft.addNewJob()
				.jobCreate("AutoFinal");
		commusoft.functionStartJob("Create Certificate")
				.certificateTab()
				.addNewForm()
				.selectCertificate("Sample Custom Forms")
				.confirmCertificate()
				.saveAndContinue()
				.inputField("Web Automation")
				.numberField("123")
				.saveAndContinue()
				.customerSignature()
				.saveAndContinue()
				.engineerSignature()
				.saveAndComplete()
				.verifyCertificateAdded();
	}


	


	


	



	


}
