package com.stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverInstance;
import com.pages.CreateNewFolderPage;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewFolderSteps extends CreateNewFolderPage{

	public CreateNewFolderSteps(WebDriver driver, Scenario scenario) {
		super(driver, scenario);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	WebDriverWait wait;
	static DriverInstance instance;
	
	CreateNewFolderPage create;
	public Scenario scenario;
	
	{
		instance = DriverInstance.getInstance();
		driver = instance.getDriver();
		wait = instance.getWait();
		create = new CreateNewFolderPage(driver, CucumberHooks.scenario);
	}
	
	@Given("user navigates to the Box App")
	public void user_navigates_to_the_box_app() {
	    
	}

	@When("user enter the correct {string} and {string} and click on submit button")
	public void user_enter_the_correct_and_and_click_on_submit_button(String string, String string2) {
	  
	}

	@Then("Click on Dev Console")
	public void click_on_dev_console() {
	    
	}

	@Then("Click on folder name and Configuration tab")
	public void click_on_folder_name_and_configuration_tab() {
	   
	}

	@Then("Click on Generate Developer Token")
	public void click_on_generate_developer_token() {
	    
	}

	@Then("Copy Dev token")
	public void copy_dev_token() {
	    
	}
}
