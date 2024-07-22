package com.NopCommerceCucumber.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = ".\\Features",
		glue = "com.NopCommerceCucumber.stepsDefine",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty", "html:test-output"},
		tags= ("@sanity")
		
	
		)

public class TestRunner {

	

}
