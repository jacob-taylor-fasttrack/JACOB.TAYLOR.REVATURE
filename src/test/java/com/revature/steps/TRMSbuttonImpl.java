package com.revature.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.revature.page.TRMSpage;
import com.revature.runners.TRMSrunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TRMSbuttonImpl {
	public static TRMSpage trms = TRMSrunner.trms;
	public static WebDriver driver = TRMSrunner.driver;

	@Given("^The Guest is on the TRMS Employee Page$")
	public void the_Guest_is_on_the_TRMS_Employee_Page() {
		driver.get("file:///C:/Users/jtlik/Downloads/Project1-TRMS/employee.html");
	}

	@When("^The Guest clicks Add Request$")
	public void the_Guest_clicks_Add_Request() {
		trms.add.click();
		;
	}

	@Then("^The Guest should be on the Add Request Page$")
	public void the_Guest_should_be_on_the_Add_Request_Page() {
		assertEquals("Reimbursement Request Adder", driver.getTitle());
	}

	@When("^The Guest clicks Get Request$")
	public void the_Guest_clicks_Get_Request() {
		trms.get.click();
	}

	@Then("^The Guest should be on the View Request Page$")
	public void The_Guest_should_be_on_the_View_Request_Pages() {
		assertEquals("Request Viewer", driver.getTitle());
	}

	@When("^The Guest clicks Delete Request$")
	public void The_Guest_clickes_Delete_Request() {
		trms.delete.click();
	}

	@Then("^The Guest should be on the View Request Page$")
	public void The_Guest_should_be_on_the_View_Request_Page() {
		assertEquals("Request Viewer", driver.getTitle());
	}

}
