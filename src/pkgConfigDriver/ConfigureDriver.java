package pkgConfigDriver;
import java.util.concurrent.TimeUnit;
//import java.util.function.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigureDriver {

	private  WebDriver driver;
	private ConfigureDriver(){}
	private static ConfigureDriver config=new ConfigureDriver();
	
	
	public static ConfigureDriver getInstance(){
	return config;		
	}
	
	public  void setDriver() {

		String browserName="IE";
		WebDriver driver=null;
		switch(browserName){
		    case "IE" :
			 System.out.println("Internet Explorer is initiating");
			 driver=initiateIE();
			 this.driver=driver;
		       break; 
		    case "CH" :
		    System.out.println("Chrome Driver is initiating");
		    driver=initiateChrome();
		    this.driver=driver;
		       break; 
		    
		    default : 
		    	System.out.println("By Default Chrome is initiating");
		    driver=initiateChrome();
		    this.driver=driver;
		       break;
		    	
		}
		}
	
		public  WebDriver getDriver(){
			return driver;
		}
		
		  private  WebDriver initiateIE() {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		    capabilities.setCapability("enablePersistentHover", false);
		    capabilities.setCapability("ie.enableNativeElement", true);
	        capabilities.setCapability("ie.ensureCleanSession", true);
	        capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
		    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		    capabilities.setCapability("ie.introduceInstabilityByIgnoringProtectedModeSettings",true);
		    System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
		    //System.setProperty("webdriver.ie.driver", "/E:/eclipse-java-mars-1-win32/IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;
		}
				
		  private   WebDriver initiateChrome(){
			  System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			  WebDriver driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  return driver;
		  }
		 
		  public WebDriverWait explicitWait(int time){
			  return new WebDriverWait(getDriver(),time);
		  }

		  
}
