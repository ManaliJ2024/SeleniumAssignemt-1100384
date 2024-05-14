package com.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.controls.ObjectsControl;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.Scenario;

public class SC3_PfizerScienceMenuPages extends ObjectsControl{

	WebDriver driver;
	//WebDriverWait wait;
    Scenario scenario;
    JavascriptExecutor js;
    Actions actions;
  	//Actions action;
  	Long maxWaitTimeToFindElement = 20l;
  	@FindBy(xpath = "//a[text()='Science']") WebElement scienceMenu;
  	@FindBy(css = "li[aria-label='Clinical Trials']") WebElement clinicalTrialsSub;
  	@FindBy(xpath = "//a[text()='Clinical Trials in Children']") WebElement clinicalTrialsInChildren;
  	@FindBy(css = "div[id='onetrust-group-container']") WebElement cookiePopup;
  	@FindBy(linkText = "Go to Pfizer Clinical Trials Site") WebElement link;
  	//@FindBy(css = "section[data-title=\"Clinical Trials search\"]") WebElement abovelinkText;
  	//@FindBy(linkText = "The Breakthrough newsletter") WebElement breakthroughlink;
  	
  	public SC3_PfizerScienceMenuPages(WebDriver driver, Scenario scenario) {
		super(driver, scenario);
		
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
	}
	
	public void navigateToPfizerapp() {
		driver.get("https://www.pfizer.com/");
		
	}
	
	/*
	 * public boolean verifyLoginErrorMessage() throws Throwable {
	 * Thread.sleep(1500); WebElement dismissButton =
	 * cookiePopup.findElement(By.xpath("//button[text()='Decline All']"));
	 * dismissButton.click(); return isPresentAndVisible(dismissButton); }
	 */
	public void hoverOverScienceMenu() throws Exception {
			
		
		Thread.sleep(7000);
		  //if(isPresentAndVisible(cookiePopup)) { 
//		WebElement cookiePopup=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='onetrust-group-container']")));
//		boolean displayFlag=cookiePopup.isDisplayed();
//		WebElement dismissButton =cookiePopup.findElement(By.xpath("//button[text()='Decline All']"));
//		 dismissButton.click(); 
		  //}
		 
		  Thread.sleep(1000);
		 
		     actions = new Actions(driver);
	        actions.moveToElement(scienceMenu).perform();
            
	}
	public void hoverOverClinicalTrialsSubMenu() {
		//WebElement clinicalTrialsSub=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li[aria-label='Clinical Trials']")));
		//wait.until(ExpectedConditions.visibilityOf(clinicalTrialsSub));
		actions = new Actions(driver);
		 actions.moveToElement(clinicalTrialsSub).perform();
    }

    public void clickClinicalTrialsInChildren() {
    	//actions = new Actions(driver);
    	//wait.until(ExpectedConditions.visibilityOf(clinicalTrialsInChildren));
		actions.moveToElement(clinicalTrialsInChildren).perform(); 
		clinicalTrialsInChildren.click();
		
		
		}
    
    public boolean pageVerify(String title) {
		return verifyPageTitle(title);
	}
    
    public void scrollToGoToPfizerClinicalTrialsSiteLink(String linkText) throws Exception { //
   	 WebElement abovelinkText =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section[data-title='Clinical Trials search']")));
  	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", abovelinkText);
  	   	  
  	  //WebElement link = driver.findElement(By.linkText("+ linkText +"));
  	 ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='60%'");
  	  WebElement link2 =wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText))); 
  	  	  
  	  //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", link2);
  	  //link2.click(); 
  	  clickWithJavaScript(link2);
  	  }
    
	/*
	 * public void scrollToGoToPfizerClinicalTrialsSiteLink() { // WebElement link1
	 * = driver.findElement((By) linkText);
	 * ((JavascriptExecutor)driver).executeScript(
	 * "arguments[0].scrollIntoView(true);", link1); //link.click();
	 * 
	 * //WebElement link = driver.findElement(By.linkText("+ linkText +"));
	 * 
	 * //
	 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(link)));
	 * ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='70%'");
	 * WebElement link2 =wait.until(ExpectedConditions.presenceOfElementLocated((By)
	 * link));
	 * 
	 * 
	 * // ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);", link2);
	 * link2.click(); }
	 */
	 
	/*
	 * public void scrollToAndClickLink() { // WebElement link =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText
	 * )));
	 * 
	 * // Scroll to the element ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);", linkText);
	 * 
	 * // Check if the element is above the current viewport Boolean
	 * isElementAboveViewport = (Boolean) ((JavascriptExecutor) driver)
	 * .executeScript("return arguments[0].getBoundingClientRect().top < 0;", link);
	 * 
	 * // If the element is above the viewport, scroll up if
	 * (isElementAboveViewport) { ((JavascriptExecutor)
	 * driver).executeScript("window.scrollBy(0, -500);"); // Adjust the scroll
	 * distance as needed }
	 * 
	 * // Click on the element link.click(); }
	 */

    public void scrollToTheBreakthroughNewsletterLink(String breakthroughlink) throws Exception {
    	WebElement breakLink =wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(breakthroughlink)));
    	//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", breakLink);
    	scrollToPageBottom();
    	clickWithJavaScript(breakLink);

    }

	public void breakthroughNewsNewTab(String expectedTitle) throws InterruptedException {
		// Get all window handles
		switchToTabWithUrl(expectedTitle);
		/*
		 * Set<String> handles = driver.getWindowHandles();
		 * 
		 * // Switch to the new tab for (String handle : handles) {
		 * driver.switchTo().window(handle); }
		 * 
		 * // Verify the title of the new tab String actualTitle = driver.getTitle();
		 * System.out.println("TITLE3----"+actualTitle); if
		 * (actualTitle.equals(expectedTitle)) { System.out.println("Title matched: " +
		 * expectedTitle); } else { System.out.println("Title did not match. Expected: "
		 * + expectedTitle + ", Actual: " + actualTitle); // Handle the mismatch
		 * according to your test requirements }
		 * 
		 * // Close the new tab driver.close();
		 * 
		 * // Switch back to the original tab driver.switchTo().window((String)
		 * handles.toArray()[0]);
		 */
    }
		 

  }
