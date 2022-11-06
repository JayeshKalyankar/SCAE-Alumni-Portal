package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testBase.BrowserFactory;
import testBase.DriverFactory;
import testBase.TestBase;

public class TaskPageObjects extends TestBase{

	//Peronal Details
	By Mr = new By.ByXPath("//input[@id='flexRadioDefault_mr']");
	By Mrs = new By.ByXPath("//input[@value='Mrs']");
	By Miss = new By.ByXPath("//input[@value='Miss']");
	By Ms = new By.ByXPath("//input[@value='Ms']");
	By FirstName = new By.ByXPath("//input[@id='first_name']");
	By MiddleName = new By.ByXPath("//input[@id='middle_name']");
	By LastName = new By.ByXPath("//input[@id='last_name']");
	By Email = new By.ByXPath("//input[@id='email']");
	By Email_Alt = new By.ByXPath("//input[@id='email_alt']");
	By Bounced_Email = new By.ByXPath("//*[@formcontrolname='bounced_email']");
	By Unsubscribed_Email = new By.ByXPath("//*[@formcontrolname='unsubscribed_email']");
	By Formar_Name = new By.ByXPath("//input[@id='formar_name']");
	By ContactNumber = new By.ByXPath("//ngx-intl-tel-input[@id='phone']//input[@id='phone']");
	By AltContactNumber = new By.ByXPath("//ngx-intl-tel-input[@id='phone_alt']//input[@id='phone']");
	By dd_Country = new By.ByXPath("//select[@id='country']");
	By dd_State = new By.ByXPath("//select[@id='state']");
	By dd_City = new By.ByXPath("//select[@id='city']");
	By ResidentialAddress = new By.ByXPath("//textarea[@id='residential_address']");
	By Nationality = new By.ByXPath("//input[@name='nationality']");
	By OtherNnationality = new By.ByXPath("//input[@name='other_nationality']");
	By dd_Region = new By.ByXPath("//select[@formcontrolname='region']");
	By dd_Gender = new By.ByXPath("//select[@formcontrolname='gender']");
	By Birthday = new By.ByXPath("//input[@id='birthday']");
	By submitButton1 = new By.ByXPath("//div[@class='next-btn']//button[@type='submit']");
	
	//Educational Details
	By dd_InstituteType = new By.ByXPath("//*[contains(text(), 'Institute Type')]/following-sibling::select[1]");
	By dd_Faculty = new By.ByXPath("//*[contains(text(), 'Faculty')]/following-sibling::select[1]");
	By dd_Institue_Name = new By.ByXPath("//*[contains(text(), 'Institute Name 1 ')]/following-sibling::select[1]");
	By dd_degreetype = new By.ByXPath("//select[@formcontrolname='degreetype']");
	By dd_degree = new By.ByXPath("//select[@formcontrolname='degree']");
	By dd_year_passing = new By.ByXPath("//select[@formcontrolname='year_passing']");
	By prn = new By.ByXPath("//input[@id='prn']");
	By pass_fail_status = new By.ByXPath("//select[@formcontrolname='pass_fail_status']");
	By dd_hsc_board = new By.ByXPath("//select[@formcontrolname='hsc_board']");
	By dd_ssc_board = new By.ByXPath("//select[@formcontrolname='ssc_board']");
	By submitButton2 = new By.ByXPath("//div[@id='nav-personal']//button[2]");
	
	
	//Professional Details
	By submitButton3 = new By.ByXPath("//div[@id='nav-university']//button[2]");
	
	//Social Media Details
	By submitButton4 = new By.ByXPath("//div[@id='nav-work']//button[2]");
	
	//Other Details
	By submitButton5 = new By.ByXPath("//button[normalize-space()='Submit']");

	
	
	public void createTask(HashMap<String, String> testData) throws Throwable {
		
		//Personal Details
		Thread.sleep(2000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(Mr), "Mr Button");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(FirstName),"First Name", testData.get("FirstName"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(MiddleName),"Middle Name", testData.get("MiddleName"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(LastName),"Last Name", testData.get("LastName"));
	//	sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(Email),"Email", testData.get("Email"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(Bounced_Email), "Bounced_Email");
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(Formar_Name),"Formar Name", testData.get("FormerName"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(ContactNumber),"Contact Number", testData.get("ContactNumber"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Country), "Country", testData.get("Country"));
		Thread.sleep(2000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_State), "State", testData.get("State"));
		Thread.sleep(2000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_City), "City", testData.get("City"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(ResidentialAddress),"Residential Adress", testData.get("ResidentialAddress"));
		Thread.sleep(2000);
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(Nationality),"Nationality", testData.get("Nationality"));
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Region), "Region", testData.get("Region"));
		Thread.sleep(2000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Gender), "Gender", testData.get("Gender"));
		sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(Birthday),"Birthday", testData.get("Birthday"));
		click_custom(DriverFactory.getInstance().getDriver().findElement(submitButton1), "Submit Button 1");
		
		//Educational Details
		Thread.sleep(2000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_InstituteType), "Institute Type", testData.get("InstituteType"));
		Thread.sleep(2000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Faculty), "Faculty", testData.get("Faculty"));
		Thread.sleep(2000);
		selectDropDownByVisibleText_custom(DriverFactory.getInstance().getDriver().findElement(dd_Institue_Name), "Institue Name", testData.get("InstituteName"));
		Thread.sleep(2000);
		click_custom(DriverFactory.getInstance().getDriver().findElement(submitButton2), "Submit Button 2");
		
		//Professional Details
		Thread.sleep(500);
		click_custom(DriverFactory.getInstance().getDriver().findElement(submitButton3), "Submit Button 3");
		
		//Social Details
		Thread.sleep(500);
		click_custom(DriverFactory.getInstance().getDriver().findElement(submitButton4), "Submit Button 4");
		
		//Other Details
		Thread.sleep(500);
		click_custom(DriverFactory.getInstance().getDriver().findElement(submitButton5), "Submit Button 5");
		
		
		
	}
	
}
