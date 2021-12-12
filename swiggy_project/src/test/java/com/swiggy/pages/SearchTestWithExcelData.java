package com.swiggy.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.siwggy.BrowserDriver;
import com.siwggy.ReadExcel;

public class SearchTestWithExcelData {

	WebDriver driver;
	SearchPage searchPageObj;
	
	@BeforeMethod public void beforeClass() {
		BrowserDriver browserDriver = new BrowserDriver();
		driver = browserDriver.getDriver();
	}
	
	@DataProvider(name="exceldata")
	public Object[][] getData() {
		String projectPath = System.getProperty("user.dir");
		String excelFilePath = projectPath + "/TestData.xlsx";
		
		Object[][] obj = ReadExcel.loadExcel(excelFilePath, 0, true);
		
		return obj;
	}
	
	@Test(dataProvider = "exceldata")
	public void searchItem(Double tc, String location, String item, String firstRestaurant)  throws Throwable{
		System.out.println("Running TC: " + tc + ", Location: " + location + ", item: " + item + ", First Result: " + firstRestaurant);
		
		searchPageObj = new SearchPage(driver);
		
		searchPageObj.navigate();
		searchPageObj.enterDeliveryLocation(location);
		searchPageObj.verifyCurrentArea(location);
		searchPageObj.enterSearch();
		searchPageObj.searchItem(item);
		searchPageObj.switchToDishesTabForResults();
		String firstResultHeaderText = searchPageObj.getFirstHeaderDishes();
		
		Assert.assertEquals(firstRestaurant, firstResultHeaderText);
	}
	
	@AfterMethod
	public void afterClass() throws Throwable {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
