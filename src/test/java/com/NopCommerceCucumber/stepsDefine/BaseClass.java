package com.NopCommerceCucumber.stepsDefine;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.NopCommerceCucumber.pageObject.AddNewCusPage;
import com.NopCommerceCucumber.pageObject.LoginPage;
import com.NopCommerceCucumber.pageObject.SearchCustPage;

public class BaseClass {
	WebDriver driver;
	LoginPage lp;
	AddNewCusPage cus;
    SearchCustPage search;
    Logger logger;
    
    
	public static String getRandomString() {
		String random = RandomStringUtils.randomAlphabetic(5);
		return random;
	}

}
