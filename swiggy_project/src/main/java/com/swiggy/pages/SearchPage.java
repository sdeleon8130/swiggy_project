package com.swiggy.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.siwggy.ReadProperties;

public class SearchPage {

	WebDriver driver;
	
	//First Time Search Location
	By idDeliveryLocation = By.id("location");
	//Does not click even though it's a link? Doesn't recognize automation input(requires keystrokes)?
	By linkTextFindFoodButton = By.linkText("FIND FOOD");
	By firstDropdownSelectionMain = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[3]/div[1]/span[2]");
	
	//Toolbar After Area Selection
	By xpathAreaSelection = By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/div/span[1]/span");
	By newAreaSearchBar = By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[2]/div[2]/div/input");
	By xpathFirstSearchResult = By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div/div/div[1]/div/div[2]/div[1]");
	
	//Search Restaurants and Dishes
	By searchItemButton = By.linkText("Search");
	By searchItemSearchBox = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div[1]/div/input");
	By dishesTab = By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div/div[2]/div[1]/button[2]");
	By firstRestaurantResult = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div/div[1]/div[1]/a/div/div/div[1]/img");
	By firstDishesResult = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div/div[1]/div[1]/h2");
	
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
	}

	public void navigate() {
		ReadProperties.loadProperties();
		String url = ReadProperties.get("loginUrl");
		driver.get(url);
	}
	
	public void enterDeliveryLocation(String Area) {
		WebElement deliverySearchBox = driver.findElement(idDeliveryLocation);
		deliverySearchBox.sendKeys(Area);
		WebElement newDelhiSelection = driver.findElement(firstDropdownSelectionMain);
		newDelhiSelection.click();
	}
	
	public void changeArea(String newArea) {
		WebElement searchArea = driver.findElement(xpathAreaSelection);
		searchArea.click();
		WebElement searchBox = driver.findElement(newAreaSearchBar);
		searchBox.sendKeys(newArea);
	}
	
	public void verifyCurrentArea(String Area) {	
		WebElement currentArea = driver.findElement(xpathAreaSelection);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(currentArea));
		String textCurrentArea = currentArea.getText();
		Assert.assertEquals(textCurrentArea, Area);
	}
	
	public void clickAreaChangeSearchBox() {
		WebElement beginFlow = driver.findElement(xpathAreaSelection);
		beginFlow.click();
		WebElement secondarySearchBox = driver.findElement(newAreaSearchBar);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(secondarySearchBox));
	}
	
	public void enterNewAreaAndClickFirstResult(String newArea) {
		WebElement secondarySearchBox = driver.findElement(newAreaSearchBar);
		secondarySearchBox.sendKeys(newArea);
		WebElement firstResult = driver.findElement(xpathFirstSearchResult);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(firstResult));
		firstResult.click();
	}
	
	public void enterSearch() {
		WebElement searchButton = driver.findElement(searchItemButton);
		searchButton.click();
	}
	
	public void searchItem(String item) {
		WebElement searchBox = driver.findElement(searchItemSearchBox);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(item);
		searchBox.sendKeys(Keys.RETURN);
	}
		
	public void switchToDishesTabForResults() {
		WebElement switchToDishes = driver.findElement(dishesTab);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(switchToDishes));
		switchToDishes.click();
		WebElement firstResultHeader = driver.findElement(firstDishesResult);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(firstResultHeader));
	}
	
	public String getFirstHeaderDishes() {
		WebElement firstResultHeader = driver.findElement(firstDishesResult);
		String firstResultHeaderText = firstResultHeader.getText();
		return firstResultHeaderText;
	}
	
}
