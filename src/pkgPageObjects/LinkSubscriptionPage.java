package pkgPageObjects;
import org.openqa.selenium.By;

public class LinkSubscriptionPage {
	
	//Gen2Service page elements..Booking Link setup page ..
	public static By selectStatus  = By.name("status");
	public static By selectSubscriptionType= By.name("subType");
	public static By selectFormat = By.name("format");
	
	public static By ediId   = By.cssSelector("input[name=ediId]");
	public static By ftpId   = By.cssSelector("input[name=ftpId]");
	public static By save    = By.cssSelector("input[id=save]");	
	public static By checkBox = By.name("prefValues(21_19)");
	
	//For OB Link Setup..
	public static By selectPreference= By.name("prefValues(35)");
	public static By checkEventName = By.id("mastercheck3");
	public static By checkInttraOnly = By.id("inttra_bookings_only");
	
	//For OB Email Setup
	public static By select_EmailStatus = By.name("status");
	public static By select_EmailSubtype = By.name("subType");
	public static By textarea_Email = By.name("email");
	public static By button_save = By.id("save");
	
	public static By checkbox_eventName= By.id("mastercheck2");
	public static By checkbox_eventName2  = By.id("mastercheck3");
	public static By checkbox_inttraOnly = By.id("inttra_bookings_only");
	
	//For BL Link setup
	public static By BL_INNTRAOnlyCheckbox  = By.id("inttra_bookings_only");
//	public static By selectSubscriptionType= By.name("subType");
//	public static By selectFormat = By.name("format");
}
