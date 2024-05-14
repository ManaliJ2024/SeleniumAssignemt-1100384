package com.stepdefination;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverInstance;
import com.pages.SC4_PfizerJobSearchPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SC4_PfizerJobSearchSteps {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	static DriverInstance instance;
	SC4_PfizerJobSearchPage ps;
	JavascriptExecutor js;

	{
		instance = DriverInstance.getInstance();
		driver = instance.getDriver();
		wait = instance.getWait();
		ps = new SC4_PfizerJobSearchPage(driver, CucumberHooks.scenario);
	}

	@When("I Click on Careers menu and verify the page with its {string}")
	public void iClickOnCareersMenuAndVerifyThePageWithItsTitle(String title) throws Exception {
		ps.clickOnSearchCareersButton();
		// ps.cookiePopupHandler();
		Assert.assertTrue("Page title is wrong", ps.pageVerify(title));
	}

	@When("I Click on Search Careers button to view all jobs")
	public void iClickOnButtonToViewAllJobs() throws Exception {
		ps.searchCareers();
	}

	@Then("Verify the new page {string}")
	public void verifyTheNewPage(String title1) {
		Assert.assertTrue("Page title is wrong", ps.pageVerify(title1));
	}

	@Then("Search and view jobs for three locations using datatable")
	public void searchAndViewJobsForThreeLocationsUsingDatatable(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		Thread.sleep(5000);

		// simulate user input, such as key presses and mouse movements
		Robot robot = new Robot();
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}

		List<Map<String, String>> locations = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> locationMap : locations) {
			String location = locationMap.get("location");
			ps.searchJobs(location);
			ps.printJobResults();
		}
	}
}
