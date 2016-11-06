package pkgPageObjects;
import org.openqa.selenium.By;


public abstract class LoginPageElements {

	public static By userName = By.xpath("//input[@name='userName']");
	public static By password = By.xpath("//input[@name='password']");
	public static By submit = By.xpath("//input[@name='submit']");
	public static By loginUser = By.xpath("//*[@id='landingFm']/div[2]/div[2]/div[2]");
}
