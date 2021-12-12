package com.siwggy;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriver {
	
	WebDriver driver = null;
	final int implicitWaitTime = 15;

	public WebDriver getDriver() {
		if (driver==null) {
			String currDirPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", currDirPath + "\\chromedriver.exe");
			System.setProperty("webdriver.firefox.driver", currDirPath + "\\geckodriver.exe");
			
			String browserName = ReadProperties.get("browser");
			
			switch (browserName) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				throw new RuntimeException("incorrect browser");
			}

			driver.manage().window().maximize();
			Duration waitTime = Duration.ofSeconds(implicitWaitTime);
			driver.manage().timeouts().implicitlyWait(waitTime);

		}
		return driver;
	}
}
