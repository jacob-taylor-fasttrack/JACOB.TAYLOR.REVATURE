package com.revature.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.page.TRMSpage;

public class TRMSAPPselenium {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/jtlik/Downloads/chromedriver_win32/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		TRMSpage trms = new TRMSpage(driver);

		String url = "file:///C:/Users/jtlik/Downloads/Project1-TRMS/employee.html";
		driver.get(url);

//	wikiMain.english.click();
		trms.clickAdd();

		driver.get(url);
		trms.clickGet();

		driver.get(url);
		trms.clickDelete();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

}