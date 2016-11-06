package pkgPageObjects;
import org.openqa.selenium.By;

public class AdministratorPage {
	//public static By COMPANY_ID= By.id("COMPANY_ID");
	public static By COMPANY_ID = By.cssSelector("input#COMPANY_ID");
	public static By SearchCompany = By.cssSelector("input[name='Submit']");
	
	public static By NextGenXlog = By.xpath("/html/body/div[9]/table/tbody/tr/td[2]/div[5]/table/tbody/tr[3]/td/a[3]");//("//td/a[text()='Next Gen XLOG']");
	
	public static By XLogID= By.cssSelector("input[name='xlogId']");
	public static By Search= By.cssSelector("input[name='submit']");
	//public static By InboundLink= By.xpath("//td/a[contains(text(),'Inbound')]");
	public static By InboundLink=By.cssSelector(".search_listdata_nowrap_alignTop>a");
	public static By Checkbox1=By.cssSelector("#check1");
	public static By selectAction=By.cssSelector(".form_fielddata");
	public static By Reprocess=By.xpath("//td/input[name='go']");
	//public static By Submit=By.xpath("//input[@name='Submit']");
}
