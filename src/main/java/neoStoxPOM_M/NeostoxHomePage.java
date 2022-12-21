package neoStoxPOM_M;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility_M.Utility;




public class NeostoxHomePage {

	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	@FindBy(id = "lbl_username") private WebElement userName;
	@FindBy(id = "lbl_curbalancetop") private WebElement AccBalance;
	@FindBy(id = "lnk_logout") private WebElement logoutButton;

public NeostoxHomePage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

public void handlePopUp(WebDriver driver)
{
	if(okButton.isDisplayed())
	{
	Utility.waittime(driver, 9000);
	okButton.click();
	//Reporter.log("Clicking on OK button of Popup", true);
	
	Utility.waittime(driver, 9000);
	closeButton.click();
	Reporter.log("Clicking on Close button of Popup", true);
	}
	
	else
	{
		Reporter.log("No Popup Interacted", true);
		Utility.waittime(driver, 5000);

	}
	
}
	
	public String actualUserName(WebDriver driver)
	{
	Utility.waittime(driver, 5000);
	String	ActualUserName= userName.getText();
	String SubStringName= ActualUserName.substring(3);
	Reporter.log("Actual User Name is "+SubStringName, true);
	return SubStringName;

		
	}
	
	public String getAccBalance(WebDriver driver)
	{
		Utility.waittime(driver, 5000);
        String AccountBalance=AccBalance.getText();
      Reporter.log("Actual Balance is"+AccountBalance, true);
        return AccountBalance;		
	}
	
	public void logOut(WebDriver driver)
	{
		Utility.waittime(driver, 5000);
		userName.click();
		logoutButton.click();
		Reporter.log("Logging Out", true);
		
	}
	
	
	
	
}



