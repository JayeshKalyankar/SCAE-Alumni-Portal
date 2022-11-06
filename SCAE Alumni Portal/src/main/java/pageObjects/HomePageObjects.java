package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testBase.DriverFactory;

public class HomePageObjects {

	WebDriver driver=null;
	
	//By sidebarMenu_Dashboard = By.xpath("//div[@class='top-panel ng-tns-c66-0']");
	
	//click on menu bar - by passing name of menu
		public void clickOnSideMenu(String menu) {
			String MenuXpath = "//span[normalize-space()='"+menu+"']";
			DriverFactory.getInstance().getDriver().findElement(By.xpath(MenuXpath)).click();
		}
}
