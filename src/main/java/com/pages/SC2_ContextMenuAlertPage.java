package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.controls.ObjectsControl;

import io.cucumber.java.Scenario;

public class SC2_ContextMenuAlertPage extends ObjectsControl{

	WebDriver driver;
	WebDriverWait wait;
    Scenario scenario;
    JavascriptExecutor js;
  	Actions actions;
  	Long maxWaitTimeToFindElement = 30l;
  	  
	@FindBy(xpath = "//a[text()='Context Menu']") WebElement clickOnContextMenu;
	@FindBy(css = "div[id='hot-spot']") WebElement elementToRightClick;
	

	public SC2_ContextMenuAlertPage(WebDriver driver, Scenario scenario) {
super(driver, scenario);
		
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
	}

	public void navigateToHerokuapp() {
		driver.get("https://the-internet.herokuapp.com/");
		
	}
	
	public void clickOnContextMenu() throws Exception {
		click(clickOnContextMenu);
	}
	
	
	
	public void rightClickDottedBox() {
		//WebElement elementToRightClick=driver.findElement(By.id("hot-spot"));
		actions = new Actions(driver);
        actions.contextClick(elementToRightClick).perform();
        //WebElement dottedBox = driver.findElement(elementToRightClick);
        //Actions actions = new Actions(driver);
        //actions.contextClick(elementToRightClick).perform();
    }

    public void getAlertText(String title) {
    	
        //return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
        //actions.sendKeys(Keys.ESCAPE).perform();
        actions.sendKeys(Keys.ESCAPE);
    }

}
