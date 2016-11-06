package pkgPageObjects;

import org.openqa.selenium.By;

public class CompanySummaryPage {
	//Company Summary page elements..
		public static By gen2Services= By.xpath("//td/a[text()='Gen2 services']");

	//For TnT setup
		public static By addTnT= By.xpath("//span[4]/*//td[contains(text(),'Message Format')]");
		public static By addEDIID= By.name("detail28");
		public static By addFTPID= By.name("path28");
		public static By buttonAdd= By.name("save");
		public static By buttonDone= By.name("done");
}
