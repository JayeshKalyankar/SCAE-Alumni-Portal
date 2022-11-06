package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.BrowserFactory;
import testBase.DriverFactory;
import testBase.TestBase;

public class LoginPageObjects extends TestBase {

	
	By EMAIL = By.xpath("//input[@placeholder='Email']");
	By PASSWORD = By.xpath("//input[@placeholder='Password']");
	By LOGIN_BTN = By.xpath("//button[normalize-space()='LOGIN']");


	//login to App
	public void login(String email, String password) {
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(EMAIL), "LoginEmailFIeld", email);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(PASSWORD), "LoginPasswordFIeld", password);

		click_custom(DriverFactory.getInstance().getDriver().findElement(LOGIN_BTN), "LoginButton");

	}

	
}
