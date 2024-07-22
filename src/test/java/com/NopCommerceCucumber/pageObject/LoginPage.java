package com.NopCommerceCucumber.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(css = "#Email")
	WebElement userId;

	@FindBy(css = "#Password")
	WebElement password;
	
	@FindBy(xpath = "//*[text()='Log in']")
	WebElement login;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;
	
	public void clearUserId() {
		userId.clear();
	}
	
	public void clearPassword() {
		password.clear();
	}
	
	public void enterUserId(String id) {
		userId.sendKeys(id);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
		
	
	
	
}
