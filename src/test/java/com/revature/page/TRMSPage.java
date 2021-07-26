package com.revature.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TRMSPage {
	public TRMSPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebDriver driver;

	@FindBy(id = "addreimb")
	public WebElement add;

	@FindBy(id = "getreimb")
	public WebElement get;

	@FindBy(id = "deletereimb")
	public WebElement delete;

	public void clickAdd() {
		add.click();
	}

	public void clickGet() {
		get.click();
	}

	public void clickDelete() {
		delete.click();
	}
}