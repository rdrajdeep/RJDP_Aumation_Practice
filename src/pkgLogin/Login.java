package pkgLogin;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pkgConfigDriver.ConfigureDriver;
import pkgPageObjects.*;
import pkgUIoperations.UIoperations;
import pkgWebdriverUtility.WebDriverUtility;

	
	public class Login {
	
        UIoperations objUI=new UIoperations();
        WebDriver driver=ConfigureDriver.getInstance().getDriver();
        
    public  void signIn(String userid, String password) throws InterruptedException{
			
		WebDriverUtility util=new WebDriverUtility();		
		objUI.senData(LoginPageElements.userName, userid);
		objUI.senData(LoginPageElements.password, password);
		objUI.invokeClick(LoginPageElements.submit);
	
		boolean flag=util.isAlertPresent();		
		try{
			if(flag==true){
				Alert alert=driver.switchTo().alert();
				alert.dismiss();
			}else{System.out.println("No alert is present");}
		}catch(UnhandledAlertException e){
			System.out.println("Exception occured in alert: "+e.getMessage());
		}
		
		 ConfigureDriver.getInstance().explicitWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td#logoffURL")));
		String actualPageURL=driver.getCurrentUrl();
		String expectedPageURL="https://www.cvt.inttra.com/portal/landingPage.do";
		//String expectedPageURL="https://www.inttraworks.inttra.com/portal/landingPage.do";
		
		if(actualPageURL.equals(expectedPageURL)){
			WebElement element=driver.findElement(LoginPageElements.loginUser);
			System.out.println("Successfully logged in as: "+element.getText());
		}else{
			System.out.println("Login failed due to invalid User ID or Password. Please try again");
			System.out.println("Exit with code 0");
			driver.close();
			driver.quit();
			//System.exit(0);
		}
		boolean flag2=util.isAlertPresent();	
		try{
			if(flag2==true){
				Alert alert=driver.switchTo().alert();
				alert.accept();
			}else{System.out.println("No alert is present");}
		}catch(UnhandledAlertException e){
			System.out.println("Exception occured in alert: "+e.getMessage());
		}
		
	    }
	    
    public void searchCompany(String input){
    	//objUI.invokeClick(HomePage.administrationURL);
    	
    	objUI.senData(AdministratorPage.COMPANY_ID, input);
    	objUI.invokeClick(AdministratorPage.SearchCompany);
    	System.out.println("Company Id: "+input +"found>>");
    	objUI.invokeClick(CompanySummaryPage.gen2Services);
    	objUI.invokeClick(ServicesDashboard.BK2_Edit);
    	
    }
    
    public void onlySearchCompany(String input){
    	//objUI.invokeClick(HomePage.administrationURL);
    	System.out.println("Trying to search Company..Fuck you..");
    	objUI.senData(AdministratorPage.COMPANY_ID, input);
    	System.out.println("Able to send company id ....");
    	objUI.invokeClick(AdministratorPage.SearchCompany);
    	System.out.println("Company Id: "+input +" found>>");
    	    	
    }
   
    public void BKlinkSetupIB(String ediid,String ftpid, String mapName) throws InterruptedException{
    	//Get current window handle
    	String parentWindow = driver.getWindowHandle();
    	objUI.invokeClick(ServiceConfiguration.addnew_IB);
    	
    	Thread.sleep(5000);
    	driver.getWindowHandles();
    	Set<String> availableWindows=driver.getWindowHandles();
    	String newWindow=null;
    	//Get New window handle
    	for(String window : availableWindows){
    		if(!parentWindow.equals(window)){
    			newWindow=window;
    		}
           }
    	
    	driver.switchTo().window(newWindow);
    	objUI.selectDropDown(LinkSubscriptionPage.selectStatus, "Active");
    	objUI.selectDropDown(LinkSubscriptionPage.selectFormat, mapName);
    	objUI.ajaxCall( LinkSubscriptionPage.ediId, ediid);
    	objUI.ajaxCall(LinkSubscriptionPage.ftpId, ftpid);
    	objUI.invokeClick(LinkSubscriptionPage.save);
    	driver.switchTo().window(parentWindow);
    }
    
    public void BKlinkSetupOB(String ediid,String ftpid, String mapName,String subscriptionType) throws InterruptedException{

    	String parentWindow = driver.getWindowHandle();
    	objUI.invokeClick(ServiceConfiguration.addnew_OB);
    	Thread.sleep(2000);
    	driver.getWindowHandles();
    	Set<String> availableWindows=driver.getWindowHandles();
    	String newWindow=null;
    	//Get New window handle
    	for(String window : availableWindows){
    		if(!parentWindow.equals(window)){
    			newWindow=window;
    		}else{System.out.println("No New window found..");}
           }
    	
    	driver.switchTo().window(newWindow);
    	objUI.selectDropDown(LinkSubscriptionPage.selectStatus, "Active");
    	objUI.selectDropDown(LinkSubscriptionPage.selectSubscriptionType, subscriptionType);
    	Thread.sleep(5000);
    	objUI.selectDropDown(LinkSubscriptionPage.selectFormat, mapName);
    	objUI.ajaxCall( LinkSubscriptionPage.ediId, ediid);
    	objUI.ajaxCall(LinkSubscriptionPage.ftpId, ftpid);
    	objUI.invokeClick(LinkSubscriptionPage.checkBox);
    	objUI.selectDropDown(LinkSubscriptionPage.selectPreference, "{FormatType}_{YYYYMMDD24HHMISS}_{UniqId}");
    	objUI.invokeClick(LinkSubscriptionPage.checkEventName);
    	objUI.invokeClick(LinkSubscriptionPage.checkInttraOnly);
    	objUI.invokeClick(LinkSubscriptionPage.save);
    	driver.switchTo().window(parentWindow);
    	
    }
    
    public void BKEmailSetupOB(String notificationType, String emails) throws InterruptedException{
    	String parent=driver.getWindowHandle();
    	objUI.invokeClick(ServiceConfiguration.addnew_OBEmail);
    	Thread.sleep(5000);
    	driver.getWindowHandles();
    	Set<String> availableWindows=driver.getWindowHandles();
    	String childWindow=null;
    	for(String window: availableWindows){
    		if(!parent.equals(window)){
    			childWindow=window;
    		}else{System.out.println("No new window found>>");}
    	}
    	driver.switchTo().window(childWindow);
    	objUI.selectDropDown(LinkSubscriptionPage.select_EmailStatus, "Active");
    	if(notificationType.equals("Success")){
    		objUI.selectDropDown(LinkSubscriptionPage.select_EmailSubtype, "Booking Success");
    		Thread.sleep(2000);
    		objUI.senData(LinkSubscriptionPage.textarea_Email, emails);
    		objUI.invokeClick(LinkSubscriptionPage.checkbox_eventName);
    		objUI.invokeClick(LinkSubscriptionPage.checkbox_eventName2);
    		objUI.invokeClick(LinkSubscriptionPage.checkbox_inttraOnly);
    		objUI.invokeClick(LinkSubscriptionPage.button_save);
    	}
    	if(notificationType.equals("Error")){
    		objUI.selectDropDown(LinkSubscriptionPage.select_EmailSubtype, "Booking Transaction Error");
    		Thread.sleep(2000);
    		objUI.senData(LinkSubscriptionPage.textarea_Email, emails);
    		objUI.invokeClick(LinkSubscriptionPage.button_save);
    	}
    	
    	
    }
	
    public void addTnT(String ediid,String ftpid) throws InterruptedException{
			String parent=driver.getWindowHandle();
			objUI.invokeClick(CompanySummaryPage.addTnT);
			Thread.sleep(7000);
	    	driver.getWindowHandles();
	    	Set<String> availableWindows=driver.getWindowHandles();
	    	String childWindow=null;
	    	for(String window: availableWindows){
	    		if(!parent.equals(window)){
	    			childWindow=window;
	    		}else{System.out.println("No new window found>>");}
	    	}
	    	driver.switchTo().window(childWindow);
			objUI.senData(CompanySummaryPage.addEDIID, ediid);
			objUI.senData(CompanySummaryPage.addFTPID, ftpid);
			objUI.invokeClick(CompanySummaryPage.buttonAdd);
			objUI.invokeClick(CompanySummaryPage.buttonDone);
			//driver.close();
			driver.switchTo().window(parent);
			Thread.sleep(200);
			objUI.invokeClick(HomePage.Link_admin);
		}

	public void BLlinkSetupOB(String ediid,String ftpid,String mapName) throws InterruptedException{
		WebDriverUtility util=new WebDriverUtility();
		objUI.invokeClick(CompanySummaryPage.gen2Services);
    	
    	WebElement element=util.findElementFluently(ServicesDashboard.BL_status, 10);
    	if(element.getText().equals("Activate")){
    		objUI.invokeClick(ServicesDashboard.BL_status);
    		boolean flag=util.isAlertPresent();
    		try{
    			if(flag==true){
    				Alert alert=driver.switchTo().alert();
    				alert.accept();
    			}else{System.out.println("No alert is present");}
    		}catch(UnhandledAlertException e){
    			System.out.println("Exception occured in alert: "+e.getMessage());
    		}
    	}
    	
    	objUI.invokeClick(ServicesDashboard.BL_Edit);
		String parentWindow = driver.getWindowHandle();
    	objUI.invokeClick(ServiceConfiguration.addnew_OB);
    	Thread.sleep(2000);
    	driver.getWindowHandles();
    	Set<String> availableWindows=driver.getWindowHandles();
    	String newWindow=null;
    	//Get New window handle
    	for(String window : availableWindows){
    		if(!parentWindow.equals(window)){
    			newWindow=window;
    		}else{System.out.println("No New window found..");}
           }
    	
    	driver.switchTo().window(newWindow);
    	objUI.selectDropDown(LinkSubscriptionPage.selectStatus, "Active");	
    	Thread.sleep(5000);
    	objUI.selectDropDown(LinkSubscriptionPage.selectFormat, mapName);
    	objUI.ajaxCall( LinkSubscriptionPage.ediId, ediid);
    	objUI.ajaxCall(LinkSubscriptionPage.ftpId, ftpid);
    	objUI.invokeClick(LinkSubscriptionPage.BL_INNTRAOnlyCheckbox);
    	objUI.invokeClick(LinkSubscriptionPage.save);
    	driver.switchTo().window(parentWindow);
    	objUI.invokeClick(HomePage.administration);
		
		
	}
	
	public void invoiceReprocess(String xlogID) throws InterruptedException{
		Thread.sleep(2000);
		objUI.invokeClick(AdministratorPage.NextGenXlog);
		objUI.senData(AdministratorPage.XLogID, xlogID);
		objUI.invokeClick(AdministratorPage.Search);
		objUI.invokeClick(AdministratorPage.InboundLink);
		objUI.invokeClick(AdministratorPage.Checkbox1);
		objUI.selectDropDown(AdministratorPage.selectAction, "Regenerate Outbound Email & EDI");
		objUI.invokeClick(AdministratorPage.Reprocess);
		
	}
	}


