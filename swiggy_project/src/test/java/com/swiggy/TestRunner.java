package com.swiggy;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.swiggy.steps",
		plugin = {"html:target/cucumber-report.html"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {

	@DataProvider
	
	
	
	@Override
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}	
	
}
