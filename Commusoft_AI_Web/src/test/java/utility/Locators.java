package utility;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.microsoft.playwright.Page;

import action.Baseclass;

public class Locators extends Baseclass {

	WebDriver driver;
	@SuppressWarnings("static-access")
	public Locators(Page page1) {
		this.page = page1;
	}

	@SuppressWarnings("static-access")
	public Locators(WebDriver driver1) {
		this.driver = driver1;
	}

	public void loginpage_locators() throws IOException, GeneralSecurityException {
		// value fetching from database for Login
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.Login);
		LocatorString.clientIDByName = (String) locators.get(1).get(3);
		LocatorString.clientIDByID = (String) locators.get(1).get(4);
		LocatorString.clientIDBycssSelector = (String) locators.get(1).get(5);
		LocatorString.UserNameByName = (String) locators.get(2).get(3);
		LocatorString.UserNameByID = (String) locators.get(2).get(4);
		LocatorString.PasswordByName = (String) locators.get(3).get(3);
		LocatorString.PasswordByID = (String) locators.get(3).get(4);
		LocatorString.LoginByID = (String) locators.get(4).get(4);
		LocatorString.LoginByXpath = (String) locators.get(4).get(2);
		LocatorString.NewPrivateCustomerByName = (String) locators.get(5).get(3);
		LocatorString.NewPrivateCustomerByID = (String) locators.get(5).get(4);
	}

	public void addCustomer_locators() throws IOException, GeneralSecurityException {
		// value fetching from database
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.customer);
		LocatorString.NewPrivateCustomerByName = (String) locators.get(1).get(3);
		LocatorString.NewPrivateCustomerByID = (String) locators.get(1).get(4);
		LocatorString.titleCustomerByxPath = (String) locators.get(2).get(2);
		LocatorString.titleChooseByxPath = (String) locators.get(3).get(2);
		LocatorString.titleEditedCustomerByxPath = (String) locators.get(2).get(7);
		LocatorString.firstNameByxPath = (String) locators.get(4).get(2);
		LocatorString.firstNameByxPath2 = (String) locators.get(4).get(7);
		LocatorString.lastNameByxPath = (String) locators.get(5).get(2);
		LocatorString.lastNameByxPath2 = (String) locators.get(5).get(7);
		LocatorString.landLineByxPath = (String) locators.get(6).get(2);
		LocatorString.landLineByxPath2 = (String) locators.get(6).get(7);
		LocatorString.landLineByxPath3 = (String) locators.get(6).get(8);
		LocatorString.mobileByxPath = (String) locators.get(7).get(2);
		LocatorString.mobileByxPath2 = (String) locators.get(7).get(7);
		LocatorString.mobileByxPath3 = (String) locators.get(7).get(8);
		LocatorString.emailByxPath = (String) locators.get(8).get(2);
		LocatorString.emailByxPath2 = (String) locators.get(8).get(7);
		LocatorString.emailByxPath3 = (String) locators.get(8).get(8);
		LocatorString.address1ByxPath = (String) locators.get(9).get(2);
		LocatorString.address1ByxPath2 = (String) locators.get(9).get(7);
		LocatorString.address1ByxPath3 = (String) locators.get(9).get(8);
		LocatorString.customerSaveByxPath = (String) locators.get(10).get(2);
		LocatorString.customerSaveByxPath2 = (String) locators.get(10).get(7);
		LocatorString.locationActiveByxPath = (String) locators.get(11).get(2);
		LocatorString.locationActiveByxPath2 = (String) locators.get(11).get(7);
		LocatorString.customerNumByxpath1 = (String) locators.get(12).get(2);
		LocatorString.customerNumByxpath2 = (String) locators.get(12).get(7);
		LocatorString.customerEditByxpath = (String) locators.get(13).get(2);
		LocatorString.customerEditByxpath2 = (String) locators.get(13).get(7);
		//supplier
		LocatorString.supplierTabByxpath1 = (String) locators.get(29).get(2);
		LocatorString.supplierTabByxpathUS = (String) locators.get(29).get(8);
		LocatorString.AddsupplierTabByID = (String) locators.get(30).get(4);
		LocatorString.supplierNameByID = (String) locators.get(31).get(4);
		LocatorString.supplierEmailByID = (String) locators.get(32).get(4);
		LocatorString.supplierAddressByID = (String) locators.get(33).get(4);
		LocatorString.supplierAddress2ByID = (String) locators.get(34).get(4);
		LocatorString.supplierSaveBXpath = (String) locators.get(35).get(2);
		//contact
		LocatorString.addContact = (String) locators.get(36).get(2);
		LocatorString.addContact1 = (String) locators.get(37).get(2);
		LocatorString.contactName = (String) locators.get(38).get(4);
		LocatorString.contactSurName = (String) locators.get(39).get(4);
		LocatorString.contactEmail = (String) locators.get(40).get(4);
		LocatorString.contactPhoneoffice = (String) locators.get(41).get(2);
		LocatorString.contactMobile = (String) locators.get(42).get(2);
		LocatorString.contactMobileType = (String) locators.get(43).get(2);
		LocatorString.contactnumber = (String) locators.get(44).get(2);
		LocatorString.saveContact = (String) locators.get(45).get(2);
		LocatorString.verifyCustomerContact = (String) locators.get(46).get(2);
		LocatorString.titleMr = (String) locators.get(47).get(2);
		//company
		LocatorString.addCompany = (String) locators.get(48).get(4);
		LocatorString.companyName = (String) locators.get(49).get(2);
		LocatorString.companyAddress = (String) locators.get(50).get(2);
		LocatorString.editCompanySave = (String) locators.get(51).get(2);
		LocatorString.companyQuickLinks = (String) locators.get(52).get(2);
		LocatorString.deleteCompany = (String) locators.get(53).get(2);
		LocatorString.deleteCompanyConfirmation = (String) locators.get(54).get(2);
		LocatorString.deleteCompanyButton = (String) locators.get(55).get(2);
		LocatorString.verifyDeleteCompany = (String) locators.get(56).get(2);
		LocatorString.addNewLL = (String) locators.get(57).get(2);
		LocatorString.titleLandLord1 = (String) locators.get(58).get(2);
		LocatorString.titleLandLord2 = (String) locators.get(59).get(2);
		LocatorString.nameLandlord = (String) locators.get(60).get(2);
		LocatorString.surnameLandlord = (String) locators.get(61).get(2);
		LocatorString.addressLandlord = (String) locators.get(62).get(2);
		LocatorString.saveLL = (String) locators.get(63).get(2);
	}
	
	public void addWorkAddress() throws IOException, GeneralSecurityException {
		// value fetching from database
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.customer);
		LocatorString.waTabbyXpath = (String) locators.get(14).get(2);
		LocatorString.waAddbyXpath = (String) locators.get(15).get(2);
		LocatorString.waNamebyXpath = (String) locators.get(16).get(2);
		LocatorString.waSurNamebyXpath = (String) locators.get(17).get(2);
		LocatorString.waLandlinebyXpath = (String) locators.get(18).get(2);
		LocatorString.waMobilebyXpath = (String) locators.get(19).get(2);
		LocatorString.waEmailbyXpath = (String) locators.get(20).get(2);
		LocatorString.waAdressbyXpath = (String) locators.get(21).get(2);
		LocatorString.waSavebyXpath = (String) locators.get(22).get(2);
		LocatorString.waSavebyXpath = (String) locators.get(22).get(2);
		
		//Edit Work Address
		LocatorString.waEditbyXpath = (String) locators.get(23).get(2);
		LocatorString.waTitlebyXpath = (String) locators.get(24).get(2);
		LocatorString.walandlineeditbyXpath = (String) locators.get(25).get(2);
		LocatorString.waMobileeditbyXpath = (String) locators.get(26).get(2);
		LocatorString.waEmaileditbyXpath = (String) locators.get(27).get(2);
		LocatorString.waSaveeditbyXpath = (String) locators.get(28).get(2);
	}

	public void searchItems() throws IOException, GeneralSecurityException {
		// value fetching from database
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.search);
		LocatorString.SearchbyXpath = (String) locators.get(1).get(2);
		LocatorString.SearchinputbyID = (String) locators.get(2).get(4);
		LocatorString.Customerclickbyxpath1 = (String) locators.get(3).get(2);
		LocatorString.apiLoader = (String) locators.get(4).get(2);
	}

	public void jobCreate() throws IOException, GeneralSecurityException {
		// value fetching from database
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.jobSheet);
		LocatorString.addJobbyXpath1 = (String) locators.get(1).get(2);
		LocatorString.addJobbyXpath2 = (String) locators.get(1).get(7);
		LocatorString.clickJDbyXpath = (String) locators.get(2).get(2);
		LocatorString.typeJDbyXpath = (String) locators.get(3).get(2);
		LocatorString.clickJDresbyXpath = (String) locators.get(4).get(2);
		LocatorString.saveJobbyXpath = (String) locators.get(5).get(2);
		LocatorString.invoiceTabbyXpath = (String) locators.get(6).get(2);
		LocatorString.invoiceNamebyXpath = (String) locators.get(7).get(2);
		//edit
		LocatorString.editJobbyXpath = (String) locators.get(52).get(2);
		LocatorString.completeJob = (String) locators.get(53).get(2);
		LocatorString.completeJobSave = (String) locators.get(54).get(2);
		//job cost
		LocatorString.jobCostTab = (String) locators.get(55).get(2);
		LocatorString.addLabour1 = (String) locators.get(56).get(2);
		LocatorString.addLabour2 = (String) locators.get(57).get(4);
		LocatorString.addLabour3 = (String) locators.get(58).get(2);
		LocatorString.addLabour4 = (String) locators.get(59).get(2);
		LocatorString.verifyLabourAdded = (String) locators.get(60).get(2);
		LocatorString.additionalWorkTab = (String) locators.get(61).get(2);
		LocatorString.additionalWorkTabUS = (String) locators.get(61).get(8);
		LocatorString.createAdditionalWork = (String) locators.get(62).get(2);
		//travel
		LocatorString.addTravel = (String) locators.get(63).get(2);
		LocatorString.clickEngineer = (String) locators.get(64).get(4);
		LocatorString.chooseEngineer = (String) locators.get(65).get(2);
		LocatorString.travelPrice = (String) locators.get(66).get(4);
		LocatorString.travelSave = (String) locators.get(67).get(2);
		LocatorString.costPO = (String) locators.get(68).get(2);
		//supplier PO
		LocatorString.supplierPO = (String) locators.get(69).get(2);
		LocatorString.supplierNameType = (String) locators.get(70).get(2);
		LocatorString.supplierSelect = (String) locators.get(71).get(2);
		LocatorString.supplierEmail = (String) locators.get(72).get(2);
		LocatorString.verifyCostTapPO = (String) locators.get(73).get(2);
		LocatorString.verifyCostTapPOUS = (String) locators.get(73).get(8);
		LocatorString.isServiceJob = (String) locators.get(76).get(2);
		LocatorString.isServiceJob1 = (String) locators.get(77).get(2);
		LocatorString.serviceBoiler = (String) locators.get(78).get(2);
		LocatorString.addDiaryEventbyXpath = (String) locators.get(79).get(2);
		LocatorString.TestBoiler = (String) locators.get(84).get(2);
		LocatorString.advanceOption = (String) locators.get(85).get(2);
		LocatorString.draftCheckbox = (String) locators.get(86).get(2);
		LocatorString.verifyVATnotDisplayed = (String) locators.get(87).get(2);
		LocatorString.verifyInvoiceEmail = (String) locators.get(107).get(2);
		LocatorString.invoiceTotalVerify3 = (String) locators.get(108).get(2);

		
	}

	public void invoiceCreate() throws IOException, GeneralSecurityException {
		// value fetching from database
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.jobSheet);
		LocatorString.addInvoicebyXpath = (String) locators.get(8).get(2);
		LocatorString.invoiceTypebyXpath = (String) locators.get(9).get(2);
		LocatorString.copyfromJDbyXpath = (String) locators.get(10).get(2);
		LocatorString.usergroupbyXpath = (String) locators.get(11).get(2);
		LocatorString.invoicecategorybyXpath = (String) locators.get(12).get(2);
		LocatorString.subtotalbyXpath = (String) locators.get(13).get(2);
		LocatorString.saveInvoicebyXpath = (String) locators.get(14).get(2);
		LocatorString.verifyInvoicedbyXpath = (String) locators.get(15).get(2);
		LocatorString.verifyInvoicedEmailbyXpath = (String) locators.get(75).get(2);
		// Full breakdown by category
		LocatorString.fullbreakdownbycategorybyXpath = (String) locators.get(16).get(2);
		LocatorString.labourbyXpath = (String) locators.get(17).get(2);
		LocatorString.labourNamebyXpath = (String) locators.get(18).get(2);
		LocatorString.labourvaluebyXpath = (String) locators.get(19).get(2);
		LocatorString.labourvalueEnterbyXpath = (String) locators.get(20).get(2);
		LocatorString.partbyXpath = (String) locators.get(21).get(2);
		LocatorString.partNamebyXpath = (String) locators.get(22).get(2);
		//Full breakdown
		LocatorString.fullbreakdownbyXpath = (String) locators.get(45).get(2);
		//invoice edit
		LocatorString.invoiceEditbyXpath = (String) locators.get(35).get(2);
		LocatorString.invoiceDesEditbyXpath = (String) locators.get(36).get(2);
		LocatorString.invoicebreakdownEditbyXpath = (String) locators.get(37).get(2);
		LocatorString.invoiceDesUnitPriceEditbyXpath = (String) locators.get(38).get(2);
		LocatorString.invoiceVATEditbyXpath = (String) locators.get(39).get(2);
		//invoice delete
		LocatorString.quickLinkfromInvoice = (String) locators.get(40).get(2);
		LocatorString.deleteInvoicebutton = (String) locators.get(41).get(2);
		LocatorString.deleteConfirmation = (String) locators.get(42).get(4);
		LocatorString.deletebuttonInvoice = (String) locators.get(43).get(4);
		LocatorString.verifyDeleteInvoice = (String) locators.get(44).get(2);
		//Minus invoice amount verification
		LocatorString.minusInvoiceText = (String) locators.get(46).get(2);
		LocatorString.minusInvoiceAmount = (String) locators.get(47).get(2);
		LocatorString.getInvoiceNum = (String) locators.get(48).get(2);
		LocatorString.searchMain = (String) locators.get(49).get(4);
		LocatorString.searchMainInvoice = (String) locators.get(50).get(2);
		LocatorString.invoiceNumber = (String) locators.get(51).get(2);
		LocatorString.invoiceEmailCheckbox = (String) locators.get(74).get(2);
		LocatorString.selectService = (String) locators.get(80).get(2);
		LocatorString.saveService = (String) locators.get(81).get(2);
		LocatorString.typeConfirm = (String) locators.get(82).get(2);
		LocatorString.confirmButton = (String) locators.get(83).get(2);
		//add line item
		LocatorString.addLineItem = (String) locators.get(88).get(2);
		LocatorString.addLineItemUS = (String) locators.get(88).get(8);
		LocatorString.invoiceLineItemSelect = (String) locators.get(89).get(2);
		LocatorString.saveLineItem = (String) locators.get(90).get(2);
		LocatorString.clickDraftInvoice = (String) locators.get(91).get(2);
		LocatorString.confirmText = (String) locators.get(92).get(2);
		LocatorString.confirmButton1 = (String) locators.get(93).get(2);
		LocatorString.jobTabfromInvoice = (String) locators.get(94).get(2);
		LocatorString.jobNotes = (String) locators.get(95).get(2);
		LocatorString.verifyEmailsent = (String) locators.get(96).get(2);
		LocatorString.consolidateInvoice = (String) locators.get(97).get(2);
		LocatorString.invoiceDescription = (String) locators.get(98).get(2);
		LocatorString.invoiceNotes = (String) locators.get(99).get(2);
		LocatorString.invoiceAdditional1 = (String) locators.get(100).get(2);
		LocatorString.invoiceAdditional2 = (String) locators.get(101).get(2);
		LocatorString.invoiceInterim1 = (String) locators.get(102).get(2);
		LocatorString.invoiceInterim2 = (String) locators.get(103).get(2);
		LocatorString.invoiceInterim3 = (String) locators.get(104).get(2);
		LocatorString.invoiceTotalVerify1 = (String) locators.get(105).get(2);
		LocatorString.invoiceTotalVerify2 = (String) locators.get(106).get(2);

	}

	public void paymentCreate() throws IOException, GeneralSecurityException {
		// value fetching from database
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.jobSheet);
		LocatorString.emailInvoicebyXpath = (String) locators.get(23).get(2);
		LocatorString.emailInvoiceToAddressbyCSS = (String) locators.get(24).get(5);
		LocatorString.emailInvoiceToAddressbyXpath = (String) locators.get(24).get(2);
		LocatorString.emailInvoiceToselectbyXpath = (String) locators.get(25).get(2);
		LocatorString.emailSentbyXpath = (String) locators.get(26).get(2);
		LocatorString.printInvoicebyXpath = (String) locators.get(27).get(2);
		LocatorString.printInvoicebuttonbyXpath = (String) locators.get(28).get(2);
		LocatorString.paymentbyXpath = (String) locators.get(29).get(2);
		LocatorString.paymentDescriptionbyXpath = (String) locators.get(30).get(2);
		LocatorString.paymentMethodbyXpath = (String) locators.get(31).get(2);
		LocatorString.nominalAccountbyXpath = (String) locators.get(32).get(2);
		LocatorString.paymentAmountbyXpath = (String) locators.get(33).get(2);
		LocatorString.savePaymentbyXpath = (String) locators.get(14).get(2);
		LocatorString.verifyPaymentRaised = (String) locators.get(34).get(2);
	}

	public void estimateCreate() throws IOException, GeneralSecurityException {
		// value fetching from database
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.estimateSheet);
		LocatorString.addEstimatebyXpath = (String) locators.get(1).get(2);
		LocatorString.descriptionbyXpath = (String) locators.get(2).get(2);
		LocatorString.notesbyXpath = (String) locators.get(3).get(2);
		LocatorString.customerReferencebyXpath = (String) locators.get(4).get(2);
		LocatorString.userGroupbyXpath = (String) locators.get(5).get(2);
		LocatorString.SaveEstiamtebyXpath = (String) locators.get(6).get(2);
		//invoice tab
		LocatorString.invoiceTTab = (String) locators.get(39).get(2);
	}

	public void acceptEstimate() throws IOException, GeneralSecurityException {
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.estimateSheet);
		LocatorString.estimatepricebyXpath = (String) locators.get(7).get(2);
		LocatorString.estimatenobreakdownbyXpath = (String) locators.get(8).get(2);
		LocatorString.pricedoubleclickbyXpath = (String) locators.get(9).get(2);
		LocatorString.pricevaluebyXpath = (String) locators.get(10).get(2);
		LocatorString.invoiceschedulebyXpath = (String) locators.get(11).get(2);
		LocatorString.depositbyXpath = (String) locators.get(12).get(2);
		LocatorString.depositamountbyXpath = (String) locators.get(13).get(2);
		LocatorString.estimateinvoiceschedulebyXpath = (String) locators.get(14).get(2);
		LocatorString.CompletionbyXpath = (String) locators.get(15).get(2);
		LocatorString.RetentionbyXpath = (String) locators.get(16).get(2);
		LocatorString.RetentionTypebyXpath = (String) locators.get(17).get(2);
		LocatorString.sendtocustomerbyXpath = (String) locators.get(18).get(2);
		LocatorString.acceptrejectbyXpath = (String) locators.get(19).get(2);
		LocatorString.checkboxbyXpath = (String) locators.get(20).get(2);
		LocatorString.estimateAcceptbyXpath = (String) locators.get(21).get(2);
		LocatorString.estimateAcceptTypebyXpath = (String) locators.get(22).get(2);
		LocatorString.estimateAcceptbuttonbyXpath = (String) locators.get(23).get(2);
		LocatorString.estimateRejectbyXpath = (String) locators.get(24).get(2);
		LocatorString.estimateRejectedsuccess = (String) locators.get(25).get(2);
		LocatorString.estimateAcceptsuccess = (String) locators.get(26).get(2);
		LocatorString.estimateRejectReason = (String) locators.get(27).get(2);
		//email sent
		LocatorString.emailSent = (String) locators.get(28).get(2);
		LocatorString.emailSentTo = (String) locators.get(29).get(2);
		LocatorString.emailSentToSelect = (String) locators.get(30).get(2);
		LocatorString.emailSentButton = (String) locators.get(31).get(2);
		LocatorString.estimateNotes = (String) locators.get(32).get(2);
		LocatorString.estimateDetails = (String) locators.get(33).get(2);
		LocatorString.verifyEstimateAccept = (String) locators.get(34).get(2);
		LocatorString.acceptEstimate = (String) locators.get(35).get(2);
		LocatorString.additionalComments = (String) locators.get(36).get(2);
		LocatorString.typeAccept = (String) locators.get(37).get(2);
		LocatorString.acceptButton = (String) locators.get(38).get(2);
		//US
		LocatorString.estimateAcceptsuccess_US = (String) locators.get(39).get(2);
	}

	public void addDiaryEvent() throws IOException, GeneralSecurityException {
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.diarySheet);
		LocatorString.addDiaryEvent = (String) locators.get(1).get(2);
		LocatorString.addDiaryEventUS = (String) locators.get(1).get(8);
		LocatorString.dailyButton = (String) locators.get(2).get(2);
		LocatorString.todayButton = (String) locators.get(3).get(2);
		LocatorString.clickonDiary = (String) locators.get(4).get(2);
		LocatorString.nextButton = (String) locators.get(5).get(2);
		LocatorString.timing4_430 = (String) locators.get(6).get(2);
		LocatorString.saveDiary = (String) locators.get(7).get(2);
		LocatorString.verifyDiaryscreated = (String) locators.get(8).get(2);
		LocatorString.verifyDiaryscreatedUS = (String) locators.get(8).get(8);

		//From diary screen
		LocatorString.diaryTab = (String) locators.get(9).get(2);
		LocatorString.diaryTabUS = (String) locators.get(9).get(8);
		LocatorString.diaryPM = (String) locators.get(10).get(2);
		LocatorString.timing12_1230 = (String) locators.get(29).get(2);
		LocatorString.diaryEstimate = (String) locators.get(11).get(2);
		LocatorString.diarySearchClick = (String) locators.get(12).get(2);
		LocatorString.diarySearch1select = (String) locators.get(13).get(2);
		LocatorString.diaryDesChoose = (String) locators.get(14).get(2);
		LocatorString.timing930_10 = (String) locators.get(15).get(2);
		LocatorString.diaryJob = (String) locators.get(16).get(2);
		LocatorString.diaryJobDes = (String) locators.get(17).get(2);
		LocatorString.timing430_5 = (String) locators.get(18).get(2);
		LocatorString.normalDes = (String) locators.get(19).get(2);
		LocatorString.timing530_6 = (String) locators.get(20).get(2);

		//Add Customer from Diary
		LocatorString.addCustomerFromDiary = (String) locators.get(21).get(2);
		LocatorString.addCustomerPFromDiary = (String) locators.get(22).get(2);
		LocatorString.addCustomerPPFromDiary = (String) locators.get(23).get(2);
		LocatorString.firstNameDiary = (String) locators.get(24).get(2);
		LocatorString.surNameDiary = (String) locators.get(25).get(2);
		LocatorString.emailDiary = (String) locators.get(26).get(2);
		LocatorString.adressDiary = (String) locators.get(27).get(2);
		LocatorString.saveCusDiary = (String) locators.get(28).get(2);

		LocatorString.printJobSheet = (String) locators.get(30).get(2);
		LocatorString.printSummarySheet = (String) locators.get(31).get(2);
		LocatorString.diaryDaily = (String) locators.get(32).get(2);
		LocatorString.diaryWeekly = (String) locators.get(33).get(2);
		LocatorString.diaryTwoWeekly = (String) locators.get(34).get(2);
		LocatorString.diaryTwoWeeklyUS = (String) locators.get(34).get(8);
		LocatorString.diaryMonthly = (String) locators.get(35).get(2);
		LocatorString.timing11PM = (String) locators.get(36).get(2);
		LocatorString.clickMap = (String) locators.get(37).get(2);
		LocatorString.verifyMap = (String) locators.get(38).get(2);
	}
	public void partsFlow() throws IOException, GeneralSecurityException {
		// value fetching from database
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.parts);
		LocatorString.addPO = (String) locators.get(1).get(2);
		LocatorString.supplierParts = (String) locators.get(2).get(2);
		LocatorString.nameType = (String) locators.get(3).get(2);
		LocatorString.partNominal = (String) locators.get(4).get(2);
		LocatorString.deliveryMethod = (String) locators.get(5).get(2);
		LocatorString.PoItems = (String) locators.get(6).get(2);
		LocatorString.PoItemName = (String) locators.get(7).get(2);
		LocatorString.PoItemNominal = (String) locators.get(8).get(2);
		LocatorString.PoItemNominalSelect = (String) locators.get(9).get(2);
		LocatorString.savePO = (String) locators.get(10).get(2);
		LocatorString.VerifysavePO = (String) locators.get(11).get(2);

		//supplier invoice
		LocatorString.addsupplierInvoice = (String) locators.get(12).get(2);
		LocatorString.addsupplierInvoiceNum = (String) locators.get(13).get(2);
		LocatorString.invoiceNumExist = (String) locators.get(14).get(2);
		LocatorString.invoiceParts = (String) locators.get(15).get(2);
		LocatorString.addInvoicePart = (String) locators.get(16).get(2);
		LocatorString.addPartQty = (String) locators.get(17).get(2);
		LocatorString.addPartQtyType = (String) locators.get(18).get(2);
		LocatorString.addPartVAT = (String) locators.get(19).get(2);
		LocatorString.addPartVATType = (String) locators.get(20).get(2);
		LocatorString.addPartVATT = (String) locators.get(21).get(2);
		LocatorString.addPartNominal = (String) locators.get(22).get(2);
		LocatorString.addPartNominal1 = (String) locators.get(23).get(2);
		LocatorString.addItem = (String) locators.get(24).get(2);
		LocatorString.addItemType = (String) locators.get(25).get(2);
		LocatorString.addItemQty = (String) locators.get(26).get(2);
		LocatorString.addItemQtyType = (String) locators.get(27).get(2);

		
	}
	public void reportingFlows() throws IOException, GeneralSecurityException {
		// value fetching from database
		List<List<Object>> locators = GoogleSheetsReader.getLocators(LocatorString.report);
		//customer report
		LocatorString.reportTab = (String) locators.get(1).get(2);
		LocatorString.sideMenu = (String) locators.get(2).get(2);
		LocatorString.sideCustomer = (String) locators.get(3).get(2);
		LocatorString.selectCustomerReport = (String) locators.get(4).get(2);
		LocatorString.filterOption = (String) locators.get(5).get(2);
		LocatorString.datePicker = (String) locators.get(6).get(2);
		LocatorString.todayReport = (String) locators.get(7).get(2);
		LocatorString.applyFilter = (String) locators.get(8).get(2);
		LocatorString.clickFirstReport = (String) locators.get(9).get(2);
		LocatorString.viewFirstCusotmer = (String) locators.get(10).get(2);
		LocatorString.thisWeekReport = (String) locators.get(23).get(2);

		//service reminder report
		LocatorString.serviceReminder = (String) locators.get(11).get(2);
		LocatorString.serviceReminderSelect = (String) locators.get(12).get(2);
		LocatorString.FirstrowData = (String) locators.get(13).get(2);
		LocatorString.noDataFound = (String) locators.get(14).get(2);

		//supplier report
		LocatorString.supplierReport = (String) locators.get(15).get(2);
		LocatorString.supplierReportSelect = (String) locators.get(16).get(2);
		LocatorString.supplierFirstrowData = (String) locators.get(17).get(2);

		//estimate report
		LocatorString.estimateReport = (String) locators.get(18).get(2);
		LocatorString.estimateReportSelect = (String) locators.get(19).get(2);

		//Job report
		LocatorString.jobReport = (String) locators.get(20).get(2);
		LocatorString.jobReportSelect = (String) locators.get(21).get(2);

		//WA report
		LocatorString.WAReport = (String) locators.get(22).get(2);
		LocatorString.clickPrint = (String) locators.get(24).get(2);
		LocatorString.jobsDates = (String) locators.get(25).get(2);
		LocatorString.downloadScreen = (String) locators.get(27).get(2);
		LocatorString.userReport = (String) locators.get(28).get(2);
		LocatorString.userReportSelect = (String) locators.get(29).get(2);
		LocatorString.eventDate = (String) locators.get(30).get(2);
		LocatorString.serviceReminder1 = (String) locators.get(31).get(2);
		LocatorString.check2ServiceReminder1 = (String) locators.get(32).get(2);
		LocatorString.check2ServiceReminder2 = (String) locators.get(33).get(2);
		LocatorString.processing = (String) locators.get(34).get(2);
		LocatorString.verifyProcessed = (String) locators.get(35).get(2);
		LocatorString.searchInput = (String) locators.get(36).get(4);
		LocatorString.searchClick = (String) locators.get(37).get(2);

	}

}
