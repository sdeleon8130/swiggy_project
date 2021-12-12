package com.swiggy.steps;

import org.openqa.selenium.WebDriver;

import com.siwggy.BrowserDriver;
import com.swiggy.pages.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageStepDefinitions {

	
	WebDriver driver;
	SearchPage searchPage;
	
	@Given("I open the browser")
	public void browserIsOpen() {
		driver = new BrowserDriver().getDriver();
	}
	
	@Given("I navigate to swiggy.com")
	public void i_navigate_to_swiggy_com() throws Throwable{
	    searchPage = new SearchPage(driver);
	    searchPage.navigate();
	}
	@When("I select the Area {string} and click search")
	public void i_select_the_Area(String Area) {
	    searchPage = new SearchPage(driver);
	    searchPage.enterDeliveryLocation(Area);
	}
	
	@Then("I verify the location {string} is selected and displayed")
	public void verifyAreaSelected(String Area) {
		searchPage = new SearchPage(driver);
		searchPage.verifyCurrentArea(Area);
	}
	
	@When("I click the secondary Area selection")
	public void openNewLocationSelection() {
		searchPage = new SearchPage(driver);
		searchPage.clickAreaChangeSearchBox();
	}
	
	@And("I enter the new Area as {string} and click the first result")
	public void enterNewAreaAndClickFirstResult(String newArea) {
		searchPage = new SearchPage(driver);
		searchPage.enterNewAreaAndClickFirstResult(newArea);
	}

	
}