package com.stepdefination;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverInstance;
import com.pages.SC1_AddRemoveElementsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SC1_AddRemoveElementsSteps {

	WebDriver driver;
	WebDriverWait wait;
	static DriverInstance instance;
	
	SC1_AddRemoveElementsPage ar;
	public Scenario scenario;
	
	{
		instance = DriverInstance.getInstance();
		driver = instance.getDriver();
		wait = instance.getWait();
		ar = new SC1_AddRemoveElementsPage(driver, CucumberHooks.scenario);
	}
	
	
	@When("I navigate to herokuapp App")
	public void AddRemoveElementsSteps() {
		ar.navigateToBox();
	}

	@Given("I select Add\\/Remove Elements")
	public void i_select_add_remove_elements() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add/Remove Elements']"))).click();
		ar.clickOnAddRemoveElementButton();
	}

	@When("I add the following elements")
	public void add_Elements(DataTable dataTable) throws Exception {
		//Each inner list represents a row of data, and each element within that inner list represents a cell value.
	   	List<List<String>> data = dataTable.asLists();				  //extracts the data from the DataTable provided as a parameter and stores it in a List of List<String>. 
        int numberOfElements = Integer.parseInt(data.get(1).get(0)); // Assuming the data table starts with headers
        System.out.println("Number of elements to add:"+numberOfElements);	//5
        
        for (int i = 0; i < numberOfElements; i++) {
            //driver.findElement(addButton).click();
        	ar.addElement();
        }
        
	}

	@Then("I delete the following elements")
	public void delete_Elements(DataTable dataTable) throws Exception {
	    		
				List<List<String>> data = dataTable.asLists(String.class);
        int numberOfElements = Integer.parseInt(data.get(1).get(0)); // Assuming the data table starts with headers
        System.out.println("Number of elements to Delete:"+numberOfElements);
        
        for (int i = 0; i < numberOfElements; i++) {
                	ar.deleteElement();
        }
	}

}
