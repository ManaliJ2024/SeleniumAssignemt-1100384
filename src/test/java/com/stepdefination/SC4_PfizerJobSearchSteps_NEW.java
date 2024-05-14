package com.stepdefination;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverInstance;

import io.cucumber.java.en.Then;


public class SC4_PfizerJobSearchSteps_NEW {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	//static DriverInstance instance;
	JavascriptExecutor js;
	
	static DriverInstance instance;
	Map<String, List<String>> jobsMap = new HashMap<>();
	
//	@Then("Search and view jobs for three locations using datatable")
//	public void searchAndViewJobsForThreeLocationsUsingDatatable(io.cucumber.datatable.DataTable dataTable) throws InterruptedException, AWTException {
//		ChromeDriver driver=new ChromeDriver();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//		driver.navigate().to("https://www.pfizer.com/about/careers/search-results?count=10&sort=latest");
//		driver.manage().window().maximize();
//		//JavascriptExecutor js =(JavascriptExecutor) driver;
//		//((JavascriptExecutor)driver).executeScript("document.body.style.zoom='60%'");
//		Thread.sleep(5000);
//		
//		
//		  Robot robot = new Robot(); for (int i = 0; i < 4; i++) {
//		  robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_SUBTRACT);
//		  robot.keyRelease(KeyEvent.VK_SUBTRACT);
//		  robot.keyRelease(KeyEvent.VK_CONTROL); }
//		 
//		 
//		
//		List<Map<String, String>> locations = dataTable.asMaps(String.class, String.class);
//
//        for (Map<String, String> locationMap : locations) {
//            String location = locationMap.get("location");
//            
//		WebElement searchDropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("workday-location_input")));
//		searchDropDown.click();
//		//searchDropDown.sendKeys("India - Delhi");
//		WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-val='"+location+"']")));
//		checkBox.click();
//		
//       	Thread.sleep(5000);           
//		WebElement clickOnviewJobs = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='workday-location_itemList']//div[@class='view-all-button']")));
//		clickOnviewJobs.click();
//		System.out.println("Clicked on View Jobs buttom");
//          
//		Thread.sleep(5000); 
//		List<WebElement> jobElements = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/div/div[3]/div/div[2]/div[1]/table/tbody/tr/td[1]"));
//		//List<WebElement> jobElements = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[3]/div/div/div/div[3]/div/div[2]/div[1]/table/tbody/tr[1]/td[1]"));
//        for (WebElement jobElement : jobElements) {
//        	System.out.println(jobElement.getText());
//        }
//        
       
		
//        WebElement chatclose = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='Close']")));
//        action = new Actions(driver);
//        // Move to the element outside the grid
//        action.moveToElement(chatclose).click().perform();
//        
//		  Map<String, String> jobMap = new HashMap<>(); List<WebElement> jobResults =
//		  driver.findElements(By.xpath("//th[text()='Site Location']"));
//		  
//		  
//		  WebElement column = driver.findElement(By.xpath(
//		  "//*[@id=\"main-content\"]/div[3]/div/div/div/div[3]/div/div[2]/div[1]/table/thead/tr/th[1]"
//		  )); WebElement rows = driver.findElement(By.xpath(
//		  "//*[@id=\"main-content\"]/div[3]/div/div/div/div[3]/div/div[2]/div[1]/table/tbody/tr/td[1]"
//		  )); System.out.println(column.getText()); System.out.println(rows.getText());
		 
        
        
}
