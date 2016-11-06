package pkgWebdriverUtility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import pkgConfigDriver.ConfigureDriver;

public class WebDriverUtility {
	
	ConfigureDriver config=ConfigureDriver.getInstance();
	WebDriver driver=config.getDriver();

	public boolean isAlertPresent(){
		
		boolean alert_flag=false;
		try{
			config.explicitWait(2).until(ExpectedConditions.alertIsPresent());
		    alert_flag=true;
			}catch(TimeoutException e){
			alert_flag=false;
		}
		return alert_flag;
	}
	
	public WebElement findElement(By locator){
		
		try{
			config.explicitWait(20).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)); 
			config.explicitWait(10).until(ExpectedConditions.elementToBeClickable(locator));
		}catch(TimeoutException te){
			System.out.println("Element path: "+locator+" not found after waiting 20 second");
			}
		return (driver.findElement(locator));
	}
	
	public  WebElement findElementFluently(final By locator, final int timeoutSeconds) {
	
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
	            .pollingEvery(500, TimeUnit.MILLISECONDS)
	            .ignoring(NoSuchElementException.class);

	
	    WebElement element= wait.until(new Function<WebDriver, WebElement>() {
	        				public WebElement apply(WebDriver webdriver) {
	        					return driver.findElement(locator);
	        					}
	    					});
	     return element;
	}
	
	public boolean isFieldEnable(WebElement element){
		boolean Flag=false;
		if(element.isEnabled()||element.isDisplayed()) {Flag=true;}
		return Flag;
		}
	
}
