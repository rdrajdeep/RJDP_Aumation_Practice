package pkgPageObjects;

import org.openqa.selenium.By;

public class ServicesDashboard {
	public static By BK2_Edit =  By.xpath("//td/a[text()='Edit']");
	public static By BL_Edit = By.xpath("//td[contains(text(),'Bill Of Lading 1.0')]/following-sibling::td[9]/a[text()='Edit']");
	public static By BL_status = By.xpath("//td[contains(text(),'Bill Of Lading 1.0')]/following-sibling::td[1]/span/a");
	
}
