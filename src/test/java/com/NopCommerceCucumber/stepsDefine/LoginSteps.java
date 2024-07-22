package com.NopCommerceCucumber.stepsDefine;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.NopCommerceCucumber.pageObject.AddNewCusPage;
import com.NopCommerceCucumber.pageObject.LoginPage;
import com.NopCommerceCucumber.pageObject.SearchCustPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginSteps extends BaseClass {

	@Given("user launch Chrome browser")
	public void user_launch_chrome_browser() {
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");
		driver = new ChromeDriver();
		//driver= new FirefoxDriver();
		//driver=new EdgeDriver();
		logger.info("Launching the browser");
	}

	@When("user open the url {string}")
	public void user_open_the_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		logger.info("Opening the app");
	}

	@Then("user enter valid userid {string} and password {string}")
	public void user_enter_valid_userid_and_password(String id, String pass) {
		lp = new LoginPage(driver);
		lp.clearUserId();
		lp.enterUserId(id);
		lp.clearPassword();
		lp.enterPassword(pass);
		logger.info("Entering user id and password");
	}

	@Then("click to the login")
	public void click_to_the_login() {
		lp.clickLogin();
		logger.info("Click to login");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertEquals(driver.getTitle(), title);
		logger.info("Veryfing the title");
	}

	@When("user need to click logout")
	public void user_need_to_click_logout() {
		lp.clickLogout();
		logger.info("Logout from application");
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
		logger.info("Closing the browser");
	}

	// Adding new customer steps

	@When("user click to to Customers")
	public void user_click_to_to_customers() throws InterruptedException {
		cus = new AddNewCusPage(driver);
		Thread.sleep(3000);
		cus.clickCustomerMain();
	}

	@When("user also click to the Customer link")
	public void user_also_click_to_the_customer_link() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cus.clickCustomer();
	}

	@Then("user need to click to Add New")
	public void user_need_to_click_to_add_new() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cus.clickAddNew();
		
		cus.clickPlus();
	
	}

	@Then("user need to enter Customer information")
	public void user_need_to_enter_customer_information() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cus.enterEmail(getRandomString() + "@gmail.com");
		cus.enterPass("12345");
		cus.enterFirstName("Shyamla");
		cus.enterLastName("Prabhu");
		cus.selectGender("female");
		cus.enterDOB("06", "01", "1999");
		cus.enterComapanyName("TCS");
		cus.selectCustomerRole("Guests");
		cus.enterComments("entry as guest");

	}

	@Then("click to the save")
	public void click_to_the_save() {
		cus.clickSave();
		logger.info("Adding new customer");
	}

	@Then("User can also see the confirmation msg {string}")
	public void user_can_also_see_the_confirmation_msg(String conmsg) {
		cus.alertafterSave(conmsg);
		logger.info("Customer added succesfully");
	}

	// Searching the customer

	@When("user need to enter mail id {string}")
	public void user_need_to_enter_mail_id(String mail) {
		search = new SearchCustPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		search.enterEmail(mail);
	}

	@When("click to the Search button")
	public void click_to_the_search_button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		search.clickSearch();
		logger.info("Searching customer by mail");
	}

	@Then("verify the email is present")
	public void verify_the_email_is_present() {
		boolean status = search.searchCustomerByMail("steve_gates@nopCommerce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertEquals(true, status);
		
	}

	// Search by First and Last name

	@When("user need to enter First name and Last name")
	public void user_need_to_enter_first_name_and_last_name() {
		search = new SearchCustPage(driver);
		search.enterFirstName("Virat");
		search.enterLastName("Kohli");
		logger.info("Searching customer by Name");
	}

	@Then("verify the name is present")
	public void verify_the_name_is_present() {
		boolean status1 = search.searchByName("Virat Kohli");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertEquals(true, status1);
	}

}
