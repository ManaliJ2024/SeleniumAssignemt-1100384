package com.stepdefination;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverInstance;
import com.pages.SC2_ContextMenuAlertPage;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SC2_ContextMenuAlertSteps {

	WebDriver driver;
	WebDriverWait wait;
	static DriverInstance instance;
	
	SC2_ContextMenuAlertPage ca;
	//HerokuappCommonPage hp;
	public Scenario scenario;
	
	{
		instance = DriverInstance.getInstance();
		driver = instance.getDriver();
		wait = instance.getWait();
		ca = new SC2_ContextMenuAlertPage(driver, CucumberHooks.scenario);
	}
	
	@Given("I navigate to herokuapp App context")
	public void i_navigate_to_herokuapp_app() {
		ca.navigateToHerokuapp();
	}

	@When("select Context Menu")
	public void select_context_menu() throws Exception {
	    ca.clickOnContextMenu();
	}

	@When("Right click on the dotted box")
	public void right_click_on_the_dotted_box() throws InterruptedException {
		
		ca.rightClickDottedBox();
	}

	
	@Then("get and print the {string} from alert")
	public void get_and_print_the_from_alert(String expectedTitle) {
		Alert alert = driver.switchTo().alert();
        String actualTitle = alert.getText();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Alert Title: " + actualTitle);
        } else {
            System.out.println("Alert Title does not match expected title.");
        }
        //alert.accept();
    }
		/*
		 * Alert alert = driver.switchTo().alert(); String alertText = alert.getText();
		 * alert.accept(); // Accept the alert after getting its text
		 * System.out.println("Alert Text: " + alertText); return alertText;
		 */


	@Then("Accept the alert")
	public void accept_the_alert() {
		ca.acceptAlert();
	}
}
