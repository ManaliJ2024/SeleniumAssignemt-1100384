package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	 public static WebDriver driver;

	    public static void setDriver(){
	        //System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	        driver = new ChromeDriver();
	    }

	    public static void navigateToHome(){
	        driver.get("https://the-internet.herokuapp.com/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    }

	    public static void closeDriver(){
	        driver.quit();
	    }
}
