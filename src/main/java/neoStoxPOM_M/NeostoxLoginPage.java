package neoStoxPOM_M;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility_M.Utility;



public class NeostoxLoginPage {

	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private WebElement EnterMobileNumber;
	@FindBy(xpath = "//a[@id= 'lnk_signup1']") private WebElement SignButton;
	
	public NeostoxLoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void sendMobileNumber(WebDriver driver, String mobNum)
	{
		Utility.waittime(driver, 5000);
		EnterMobileNumber.sendKeys(mobNum);
		Reporter.log("Clicking on SignIn Button", true);
	}
	
	public void clickonSignInButton(WebDriver driver)
	{
		Utility.waittime(driver, 5000);
		SignButton.click();
		Reporter.log("Clicking on SignIN Button", true);
		
	}
	
	
}
