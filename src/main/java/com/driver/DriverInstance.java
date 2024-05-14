package com.driver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverInstance {

	private static DriverInstance instance;
	private WebDriver driver;
	private WebDriverWait wait;

	private DriverInstance(String browser) throws MalformedURLException {
		
	
		if (browser.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
		} else if (browser.equals("chrome")) {
			Map<String, Object> prefsMap = new HashMap<String, Object>();
			prefsMap.put("profile.default_content_settings.cookies", 2);
			prefsMap.put("profile.default_content_settings.popups", 0);
			prefsMap.put("download.default_directory", System.getProperty("user.dir")+"\\downloads");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefsMap);
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}else if (browser.equals("edge")) {
//			WebDriverManager.edgedriver().setup();
			this.driver = new EdgeDriver();

			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().window().maximize();

	}

	public static void setInstance(String browser) throws MalformedURLException {

		instance = new DriverInstance(browser);
	}

	public static DriverInstance getInstance() {

		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {

		this.driver = driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}
}
