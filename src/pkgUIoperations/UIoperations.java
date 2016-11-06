package pkgUIoperations;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pkgConfigDriver.ConfigureDriver;
import pkgWebdriverUtility.WebDriverUtility;

public  class UIoperations {
	WebDriverUtility util=new WebDriverUtility();
	WebElement element;
	WebDriver driver=ConfigureDriver.getInstance().getDriver();
	
	public void senData(By locator, String input){
		element=util.findElementFluently(locator, 10);
		element.sendKeys(input);
		}
	
	public void invokeClick(By locator){
		element=util.findElementFluently(locator,20);
		System.out.println("Clicking Link: "+element.getText());
		element.click();
		//System.out.println("Clicked on: "+element.getText());
		
	}
	
	public void selectDropDown(By locator, String selectValue){
		
		String selectByvissible=null;
		element=util.findElementFluently(locator, 20);
		Select select=new Select(element);
		List <WebElement> allVissibleValues = select.getOptions();
		for(WebElement value: allVissibleValues){
				String tempMatcher = value.getText();
				//System.out.println("All value of Drop down: "+tempMatcher);
			if(tempMatcher.equals(selectValue)){
				selectByvissible=tempMatcher;
				System.out.println("Value: "+selectByvissible+" selected");
				break;
				}
			}
		select.selectByVisibleText(selectByvissible);
		}
	
	public void ajaxCall(By locator, String input){
		
		element=util.findElement(locator);
		
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].enable=true",element);
			Thread.sleep(500);
		} catch (InterruptedException|WebDriverException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		element.clear();
		element.sendKeys(input);
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.RETURN);
	}
}
