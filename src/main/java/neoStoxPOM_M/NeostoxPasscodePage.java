package neoStoxPOM_M;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility_M.Utility;



public class NeostoxPasscodePage {

@FindBy(id = "txt_accesspin")  private WebElement EnterYourPassword;
@FindBy(id = "lnk_submitaccesspin") private WebElement SubmitButton;

public NeostoxPasscodePage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

public void enterYourPassword(WebDriver driver, String pass)
{  
	Utility.waittime(driver, 5000);
	EnterYourPassword.sendKeys(pass);
	Reporter.log("Entering Password", true);
}
	
public void clickOnSubmitButton(WebDriver driver)
{
	Utility.waittime(driver, 5000);
	SubmitButton.click();	
	Reporter.log("Clicking on submit Button", true);
}
	
}
