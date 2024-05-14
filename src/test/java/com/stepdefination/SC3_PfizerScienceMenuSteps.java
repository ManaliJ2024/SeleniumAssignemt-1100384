package com.stepdefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverInstance;
import com.pages.SC3_PfizerScienceMenuPages;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SC3_PfizerScienceMenuSteps {

	WebDriver driver;
	WebDriverWait wait;
	static DriverInstance instance;
	
	SC3_PfizerScienceMenuPages ps;
	public Scenario scenario;
	
	{
		instance = DriverInstance.getInstance();
		driver = instance.getDriver();
		wait = instance.getWait();
		ps = new SC3_PfizerScienceMenuPages(driver, CucumberHooks.scenario);
	}
	
	@Given("I navigate to Pfizer App")
	public void iNavigateToPfizerApp() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		ps.navigateToPfizerapp();
	}

	@When("I Hover over Science menu")
	public void iHoverOverScienceMenu() throws Exception {
	    ps.hoverOverScienceMenu();
	}

	@When("I Hover over clinical trials sub menu")
	public void iHoverOverClinicalTrialsSubMenu() {
	    ps.hoverOverClinicalTrialsSubMenu();
	}

	@Then("Click on clinical Trials in Children")
	public void clickOnClinicalTrialsInChildren() {
	    ps.clickClinicalTrialsInChildren();
	}

	@Then("Verify {string} of this page with one given in feature")
	public void verifyOfThisPageWithOneGivenInFeature(String title) {
		//ps.verifyTitle(title);
		Assert.assertTrue("Page title is wrong",ps.pageVerify(title));
	}

	@Then("Scroll down and click {string} link")
	public void scrollDownAndClickLink(String linkText) throws Exception {
		ps.scrollToGoToPfizerClinicalTrialsSiteLink(linkText);
        //ps.scrollToAndClickLink();

        }
	
	@Then("Again Verify {string} of this page with one given in feature")
	public void againVerifyOfThisPageWithOneGivenInFeature1(String title1) {
		Assert.assertTrue("Page title is wrong",ps.pageVerify(title1));
	    
	}

	@Then("Scroll down to page footer and click on {string}")
	public void scrollDownToPageFooterAndClickOn(String string) throws Exception {
		ps.scrollToTheBreakthroughNewsletterLink(string);
        
	}

	@Then("In the new page, Again Verify {string} of this page with one given in feature")
	public void inTheNewPageAgainVerifyOfThisPageWithOneGivenInFeature(String title2) throws InterruptedException {
		ps.breakthroughNewsNewTab(title2);
		Assert.assertTrue("Page title is wrong",ps.pageVerify(title2));   
	}
}
