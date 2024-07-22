package com.NopCommerceCucumber.pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import junit.framework.Assert;

public class AddNewCusPage {
	WebDriver driver;

	public AddNewCusPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//p[normalize-space()='Customers']//i[contains(@class,'right fas fa-angle-left')]")
	WebElement customerMain;

	@FindBy(xpath = "//*[text()=' Customers']")
	WebElement customer;

	@FindBy(xpath = "//*[@class=\"fas fa-plus-square\"]")
	WebElement addNew;
	
	@FindBy(xpath = "//*[@id=\"customer-info\"]/div[1]/div[2]/button/i")
	WebElement clickplus;
	

	@FindBy(css = "*[id=\"Email\"]")
	WebElement email;

	@FindBy(css = "#Password")
	WebElement password;

	@FindBy(css = "#FirstName")
	WebElement firstName;

	@FindBy(css = "#LastName")
	WebElement lastName;
	@FindBy(css = "#Gender_Male")
	WebElement maleG;

	@FindBy(css = "#Gender_Female")
	WebElement femaleG;

	@FindBy(css = "#DateOfBirth")
	WebElement DOB;

	@FindBy(css = "#Company")
	WebElement company;

	@FindBy(css = "#IsTaxExempt")
	WebElement taxExempt;

	@FindBy(css = "*[type=\"search\"]")
	WebElement newsletter;

	@FindBy(css = "#customer_attribute_1_1")
	WebElement male1;

	@FindBy(css = "#customer_attribute_1_2")
	WebElement female1;

	@FindBy(xpath = "//a[@id='backTop']")
	WebElement customerRole;
	
	@FindBy(xpath = "//span[@role='presentation']")
	WebElement removereg;
	

	@FindBy(xpath = "//li[text()='Administrators']")
	WebElement croleAdminstrator;

	@FindBy(xpath = "//li[text()='Guests']")
	WebElement croleGuests;

	@FindBy(xpath = "//li[text()='Registered']")
	WebElement croleRegistered;

	@FindBy(css = "#VendorId")
	WebElement vendorId;

	@FindBy(css = "#AdminComment")
	WebElement adminComment;

	@FindBy(css = "*[name=\"save\"]")
	WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	WebElement alert;

	@FindBy(xpath = "//*[@class='select2-selection__choice']//child::span")
	WebElement deleteExistingRole;
	
	public void clickCustomerMain() {
		customerMain.click();
	}

	public void clickCustomer() {
		customer.click();
	}

	public void clickAddNew() {
		addNew.click();
	}
	
	public void clickPlus() throws InterruptedException {
	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	if(email.isDisplayed()==false) {
		clickplus.click();
	}
	
		
	}

	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}

	public void enterPass(String pass) {
		password.sendKeys(pass);
	}

	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterDOB(String month, String date, String year) {
		DOB.sendKeys(month);
		DOB.sendKeys(date);
		DOB.sendKeys(year);
	}

	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			maleG.click();
		} else if (gender.equalsIgnoreCase("female")) {
			femaleG.click();
		}
	}

	public void enterComapanyName(String cname) {
		company.sendKeys(cname);
	}

	public void selectCustomerRole(String cr)  {
		removereg.click();

		if (cr.equalsIgnoreCase("Administrator")) {
			croleAdminstrator.click();
		} else if (cr.equalsIgnoreCase("Guests")) {
			croleGuests.click();
		} else if (cr.equalsIgnoreCase("Registered")) {
			croleRegistered.click();
		}
	}

	public void enterComments(String cmnt) {
		adminComment.sendKeys(cmnt);
	}

	public void clickSave() {
		save.click();
	}

	public void alertafterSave(String conf) {
		String alertmsg = alert.getText();
		if (alertmsg.contains(conf)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

}
