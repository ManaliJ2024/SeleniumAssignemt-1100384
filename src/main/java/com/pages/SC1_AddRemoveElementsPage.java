package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.controls.ObjectsControl;

import io.cucumber.java.Scenario;

public class SC1_AddRemoveElementsPage extends ObjectsControl{

	WebDriver driver;
	WebDriverWait wait;
    Scenario scenario;
    
	@FindBy(xpath = "//a[text()='Add/Remove Elements']") WebElement clickOnAddRemoveElement;
	@FindBy(xpath = "//button[text()='Add Element']") WebElement addButton;
	@FindBy(xpath = "//button[text()='Delete'][1]")WebElement deleteButton;
    
	public SC1_AddRemoveElementsPage(WebDriver driver, Scenario scenario) {
		super(driver, scenario);
		
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);	
        
	}

	
    JavascriptExecutor js;
	Actions act;
	Long maxWaitTimeToFindElement = 30l;
	
	
	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add/Remove Elements']"))).click();

	public void navigateToBox() {
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	public void clickOnAddRemoveElementButton() throws Exception {
		click(clickOnAddRemoveElement);
	}
	
	public void addElement() throws Exception {
		click(addButton);
	}
	
	public void deleteElement() throws Exception {
		click(deleteButton);
	}
}
