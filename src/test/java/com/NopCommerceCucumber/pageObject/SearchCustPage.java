package com.NopCommerceCucumber.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustPage {
	WebDriver driver;

	public SearchCustPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(css = "*[id=\"SearchEmail\"]")
	WebElement searchMail;

	@FindBy(css = "*[id='SearchFirstName']")
	WebElement searchName;

	@FindBy(css = "*[id='SearchLastName']")
	WebElement searchLastName;
	
	@FindBy(css = "*[id=\"search-customers\"]")
	WebElement searchButton;


	@FindBy(xpath = "//*[@id=\"customers-grid\"]")
	WebElement table;

	@FindBy(xpath = "//*[@id=\"customers-grid\"]/tbody/tr")
	List<WebElement> tableRow;

	@FindBy(xpath = "//*[@id=\"customers-grid\"]/tbody/tr/td")
	List<WebElement> tableCol;

	public void enterEmail(String mail) {
		searchMail.sendKeys(mail);
	}

	public void enterFirstName(String name) {
		searchName.sendKeys(name);
	}

	public void enterLastName(String lname) {
		searchLastName.sendKeys(lname);
	}
	
	public void clickSearch() {
		searchButton.click();
	}

	public int getRowNum() {
		return (tableRow.size());
	}

	public int getColumnNum() {
		return (tableCol.size());
	}

	public boolean searchCustomerByMail(String email) {
		boolean flag = false;

		for (int i = 1; i <= getRowNum(); i++) {
			String mail = table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
			
			if (mail.equals(email)) {
				flag = true;
			}
		}

		return flag;
	}

	public boolean searchByName(String fname) {
		boolean f=false;
		for(int i=1;i<=getRowNum();i++) {
			String name = table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(name);
			String names[]=name.split(" ");
			if(names[0].equalsIgnoreCase("Virat") && names[1].equalsIgnoreCase("Kohli")) {
			f=true;
		}
	
		}
		return f;
	}
	
	
}
