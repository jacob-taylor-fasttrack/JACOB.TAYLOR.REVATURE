package com.revature.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.page.TRMSpage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources", glue = "com.revature.steps")
public class TRMSrunner {
	public static WebDriver driver;
	public static TRMSpage trms;

	@BeforeClass
	public static void setUp() {
		String path = "C:/Users/jtlik/Downloads/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();
		trms = new TRMSpage(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
