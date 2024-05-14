package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.controls.ObjectsControl;

import io.cucumber.java.Scenario;

public class SC5_HorizontalSliderPages  extends ObjectsControl{

	WebDriver driver;
	//WebDriverWait wait;
    Scenario scenario;
    JavascriptExecutor js;
  	Actions action;
  	Long maxWaitTimeToFindElement = 30l;
  	@FindBy(xpath = "//a[text()='Horizontal Slider']") WebElement clickOnHorizontalSlider;
  	@FindBy(css = "div[class='sliderContainer']") WebElement moveSlider;
  	@FindBy(xpath = "//span[text()='3.5']") WebElement range;
  	@FindBy(xpath = "//input[@type='range']") private WebElement slider;
  	@FindBy(linkText  = "Frames") private WebElement clickOnFrame;
  	@FindBy(linkText  = "iFrame") private WebElement clickOniFrame;
  	  	

	public SC5_HorizontalSliderPages(WebDriver driver, Scenario scenario) {
		super(driver, scenario);
				
		        this.driver = driver;
		        this.scenario = scenario;
		        PageFactory.initElements(driver, this);
			}
	public void navigateToHerokuapp() {
		driver.get("https://the-internet.herokuapp.com/");
		
	}
	
	public void clickOnHorizontalSlider() throws Exception {
		click(clickOnHorizontalSlider);
	}
	
	 public void moveSliderTo(String value) {
		// WebElement slider = driver.findElement(By.cssSelector("div[class='sliderContainer']"));
		 
		// JavascriptExecutor js = (JavascriptExecutor)driver; 
		 //js.executeScript("arguments[0].scrollIntoView()", range);
		 //clickWithJavaScript(clickOnHorizontalSlider);
		 
		// int maxSliderValue = Integer.parseInt(slider.getAttribute("5"));
		 String maxAttributeValue = slider.getAttribute("max");
		 System.out.println(maxAttributeValue);
		 if (maxAttributeValue != null) {
	            double maxSliderValue = Double.parseDouble(maxAttributeValue);
	            // Convert the specified value string to a double
	            double targetValue = Double.parseDouble(value);

	         // Calculate the offset based on the maximum value and the desired value
	          //  calculates the offset in pixels for the target value on the slider component. It scales the target value relative to the slider's maximum value, then converts it to an offset within the width of the slider. The resulting offset variable holds the pixel position where the slider thumb or indicator should be placed to represent the target value. 
	           // (targetValue / maxSliderValue): This calculates the ratio of the target value to the maximum value of the slider. It gives you a value between 0 and 1, indicating where the target value lies within the range of the slider.
	            int offset = (int) Math.round((targetValue / maxSliderValue) * slider.getSize().getWidth()); //This retrieves the width of the slider component.
	            System.out.println("Offset value"+offset);

	            // Move the slider to the specified value
	          action = new Actions(driver);
	          action.clickAndHold(slider).moveByOffset(offset, 0).release().perform();
	        } else {
	            throw new IllegalStateException("Maximum value attribute is null");
	        }
	    }
	 
	  public void clickOnFrames() throws Exception {
		  WebElement clickOnFrameLink=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Frames")));
		   click(clickOnFrameLink);
		}

		
		public void clcikOnIframe() throws Exception {
			  WebElement clickOniFrameLink=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("iFrame")));
			  click(clickOniFrameLink);

		}
		
		public void clearAndWriteText(String string) {
			//WebElement iframeElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mce_0_ifr")));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mce_0_ifr")); 
			WebElement iframeElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.className("mce-content-body")));

			iframeElement.clear();
			iframeElement.sendKeys(string);
			//clearTypeKeys(text, string);
		}
		
		public void selectTheContentWithAndMakeBoldWith(String selectText, String boldText) {
	        // Locate the element containing the content
	        WebElement contentEditableElement = driver.findElement(By.className("mce-content-body"));

	        wait.until(ExpectedConditions.visibilityOf(contentEditableElement));
	        wait.until(ExpectedConditions.elementToBeClickable(contentEditableElement));
	        contentEditableElement.click();
	        
	        action = new Actions(driver);
	        action.keyDown(Keys.CONTROL)
	               .sendKeys("a") // Select all
	               //.keyUp(Keys.CONTROL)
	               //.sendKeys(selectText) // Type the desired text
	               .perform();

	        // Make the selected text bold
	        action.keyDown(Keys.CONTROL)
	               .sendKeys("b") // Make it bold
	               .keyUp(Keys.CONTROL)
	               .perform();
	        
	    }

	
}
