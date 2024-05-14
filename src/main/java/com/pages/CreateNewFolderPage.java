package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.controls.ObjectsControl;

import io.cucumber.java.Scenario;

public class CreateNewFolderPage extends ObjectsControl{

	WebDriver driver;
	WebDriverWait wait;
    Scenario scenario;
    
	public CreateNewFolderPage(WebDriver driver, Scenario scenario) {
		super(driver, scenario);
		
        this.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);	
        
	}

	
}
