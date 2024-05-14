package com.stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverInstance;
import com.pages.SC5_HorizontalSliderPages;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SC5_HorizontalSliderSteps {

	WebDriver driver;
	WebDriverWait wait;
	static DriverInstance instance;
	
	SC5_HorizontalSliderPages hs;
	public Scenario scenario;
	
	{
		instance = DriverInstance.getInstance();
		driver = instance.getDriver();
		wait = instance.getWait();
		hs = new SC5_HorizontalSliderPages(driver, CucumberHooks.scenario);
	}
	
	@Given("I navigate to herokuapp App Horizontal")
	public void iNavigateToHerokuappAppContext() {
		hs.navigateToHerokuapp();
	}

	@Given("I select Horizontal Slider")
	public void iSelectHorizontalSlider() throws Exception {
		hs.clickOnHorizontalSlider();
	}

	
	@Then("Move the slider to {string} value")
	public void moveTheSliderToValue(String string) {
		hs.moveSliderTo(string);
	}

	@When("Click on browser back")
	public void clickOnBrowserBack() {
		driver.navigate().back();
	}

	@Then("I Select Frames")
	public void iSelectFrames() throws Exception {
	    hs.clickOnFrames();
	}

	@Then("Select iframe")
	public void selectIframe() throws Exception {
	    hs.clcikOnIframe();
	}

	@Then("In the new page, delete all the previous content and write {string}")
	public void inTheNewPageDeleteAllThePreviousContentAndWrite(String string) {
		hs.clearAndWriteText(string);
	}

	@Then("Select the content with {string} and make bold with {string}")
	public void selectTheContentWithAndMakeBoldWith(String string, String string2) {
	    hs.selectTheContentWithAndMakeBoldWith(string, string2);
	}
}
