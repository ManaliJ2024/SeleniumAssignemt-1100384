package com.stepdefination;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverInstance;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMStep {

	WebDriver driver;
	WebDriverWait wait;
	public Scenario scenario;
	
	public  OrangeHRMStep() {
		DriverInstance instance = DriverInstance.getInstance();
		driver = instance.getDriver();
		wait = instance.getWait();
		this.scenario = CucumberHooks.scenario;	// equating the scenario here
	}
	
	@Given("user navigates to the Orange HRM App")
	public void user_navigates_to_the_orange_hrm_app() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("user enter the correct {string} and {string} and Login to the app")
	public void user_enter_the_correct_and_and_login_to_the_app(String username, String password) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='username']"))).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))).sendKeys(password);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();

	}

	@Then("user verify the {string} in the app")
	public void user_verify_the_in_the_app(String title) {
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	@Then("verify orangeHRM logo on dashboard")
	public void verifyOrangeHRMLogoOnDashboard() {
		
		WebElement logo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"oxd-brand-banner\"]")));
		//Assert.assertFalse(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"oxd-brand-banner\"]"))).isDisplayed());

	}
}
