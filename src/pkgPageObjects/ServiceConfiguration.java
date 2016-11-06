package pkgPageObjects;

import org.openqa.selenium.By;

public class ServiceConfiguration {
	public static By addnew_IB = By.xpath("//td[contains(text(),'Subscriptions for INTTRA Link transactions sent inbound to INTTRA ')]/preceding-sibling::td[1]/input[@id='addsubscription']");
	public static By addnew_OB = By.xpath("//td[contains(text(),'Subscriptions for INTTRA Link transactions sent outbound from INTTRA')]/preceding-sibling::td[1]/input[@id='addsubscription']");
	public static By addnew_OBEmail = By.xpath("//td[contains(text(),'Subscriptions for Email transactions sent outbound from INTTRA')]/preceding-sibling::td[1]/input[@id='addsubscription']");
	
}
