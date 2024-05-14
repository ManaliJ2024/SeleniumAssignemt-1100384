package com.pages;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.controls.ObjectsControl;

import io.cucumber.java.Scenario;

public class SC4_PfizerJobSearchPage extends ObjectsControl {

	WebDriver driver;
	// WebDriverWait wait;
	Scenario scenario;
	JavascriptExecutor js;
	Actions actions;
	// Actions action;
	Long maxWaitTimeToFindElement = 20l;
	@FindBy(xpath = "//div[@id='block-secondarynavigation']//a[text()='Careers']")
	WebElement careerslink;
	// @FindBy(css = "input[value='Search Careers']") WebElement searchJobs;
	@FindBy(css = "button[aria-label=\"Close\"]")
	WebElement closePopup;
	//@FindBy(css = "input[value='Search Careers']") WebElement searchCareerButton;
	//@FindBy(xpath = "//*[@id=\\\"main-content\\\"]/div[3]/div/div/div/div[3]/div/div[2]/div[1]/table/tbody/tr/td[1]") List<WebElement> jobTitleList;
	
	public SC4_PfizerJobSearchPage(WebDriver driver, Scenario scenario) {
		super(driver, scenario);

		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
	}

	public void navigateToPfizerapp() {
		driver.get("https://www.pfizer.com/");

	}

	public void clickOnSearchCareersButton() throws Exception {
		click(careerslink);

	}

	public void cookiePopupHandler() {
		WebElement cookiePopup = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='onetrust-group-container']")));
		WebElement dismissButton = cookiePopup.findElement(By.xpath("//button[text()='Decline All']"));
		// WebElement dismissButton
		// =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("//button[text()='Decline
		// All']")));

		dismissButton.click();
	}

	public boolean pageVerify(String title) {
		return verifyPageTitle(title);
	}

	public void searchCareers() throws Exception {
		WebElement searchCareerButton = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='Search Careers']")));
		// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
		// searchCareerButton);
		scrollToElement(searchCareerButton);
		clickWithJavaScript(searchCareerButton);
	}

	public void searchJobs(String location) throws InterruptedException, AWTException {

		Thread.sleep(5000);
		WebElement searchDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("workday-location_input")));
		searchDropDown.click();
		// searchDropDown.clear();

		WebElement clearBox = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@id='workday-location_itemList']//*[@class='clear-button']")));
		clearBox.click();

		WebElement checkBox = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-val='" + location + "']")));
		checkBox.click();

		Thread.sleep(5000);
		WebElement clickOnviewJobs = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@id='workday-location_itemList']//div[@class='view-all-button']")));
		clickOnviewJobs.click();
	}

	public void printJobResults() throws InterruptedException {
		System.out.println("==========Print JOB Title===========");
		Thread.sleep(7000);
		//List<WebElement> jobTitleList = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/div/div[3]/div/div[2]/div[1]/table/tbody/tr/td[1]"));
		List<WebElement> jobTitleList = driver.findElements(By.cssSelector("td.job-posting"));
		 //List<WebElement> jobElements =driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/div/div[3]/div/div[2]/div[1]/table/tbody/tr[1]/td[1]"));
		//List<WebElement> jobLocationList = driver.findElements(
				//By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/div/div[3]/div/div[2]/div[1]/table/tbody/tr[1]/td[4]/div/ul/li"));
		//List<WebElement> jobLocationList = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[4]/div/ul/li"));
		
		List<WebElement> jobLocationList = driver.findElements(By.cssSelector("td.locations"));
		
		for(int i=0; i<jobTitleList.size(); i++) {
			System.out.println(jobTitleList.get(i).getText()+ " ===== "+jobLocationList.get(i).getText());
		}
				
		/*
		 * Map<WebElement, WebElement> combinedMap = new LinkedHashMap<>();
		 * 
		 * // Ensure both lists have the same size if (jobLocation.size() ==
		 * jobTitleList.size()) { // Populate the map by iterating over both lists
		 * simultaneously for (int i = 0; i < jobLocation.size(); i++) {
		 * combinedMap.put(jobLocation.get(i), jobTitleList.get(i));
		 * 
		 * } // Print the contents of the map
		 * System.out.println("Contents of the WebElement map:"); for
		 * (Map.Entry<WebElement, WebElement> entry : combinedMap.entrySet()) {
		 * WebElement key = entry.getKey(); WebElement value = entry.getValue();
		 * System.out.println("Key: " + key.getText()); // Example: Get text of
		 * WebElement System.out.println("Value: " + value.getText()); // Example: Get
		 * href attribute of WebElement System.out.println(); } }
		 */
     
        
		
	}
}
