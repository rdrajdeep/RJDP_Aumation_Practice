package pkgPageObjects;

import org.openqa.selenium.By;

public class HomePage {
	    //Administrator Page elements..
		public static By administrationURL= By.id("administrationURL");
		public static By administration = By.xpath("html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[4]/a");
		public static By Link_admin = By.xpath("html/body/div[2]/div/table/tbody/tr/td/a[2]");
		public static By link_logout = By.cssSelector("td#logoffURL");
}
