package validateUserIDAnd_Balance;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBase_M.Base;
import neoStoxPOM_M.NeostoxHomePage;
import neoStoxPOM_M.NeostoxLoginPage;
import neoStoxPOM_M.NeostoxPasscodePage;
import utility_M.Utility;



public class ValidateNeoStoxAccBalance extends Base {
	NeostoxPasscodePage password;
	NeostoxLoginPage login;
	NeostoxHomePage home;
	
	 @BeforeClass
	  public void launchNeoStox() throws InterruptedException
	 {
		 launchBrowser();// from base class as we extends means property of base class extend or taker by ValidateNeoStoxUserName class
		  password= new NeostoxPasscodePage(driver);
		  login= new NeostoxLoginPage(driver);
		  home= new NeostoxHomePage(driver);
	  }
	 @BeforeMethod
	 
	  public void logintoNeoStox() throws EncryptedDocumentException, IOException, InterruptedException 
	 {
		login.sendMobileNumber(driver, Utility.readDataFromExcel(2,0));
		Utility.waittime(driver, 2000);
		login.clickonSignInButton(driver);
		Utility.waittime(driver, 2000);
		password.enterYourPassword(driver, Utility.readDataFromExcel(2,0));
		Thread.sleep(2000);
		password.clickOnSubmitButton(driver);
		Thread.sleep(9000);
		home.handlePopUp(driver);
		
		
		
		
	 }

	 	
	
  @Test(priority=-1)
  public void ValidateUserID() throws EncryptedDocumentException, IOException
  {
	  Assert.assertEquals(home.actualUserName(driver), Utility.readDataFromExcel(4, 0),"TC is Failed as Acutul and Expected User Nmae is NOT same");
	  Utility.screenshot(driver, home.actualUserName(driver));
  }
  
  @Test
   public void ValidateAccBalance() throws IOException
   {
	  Assert.assertNotNull(home.getAccBalance(driver),"TC failed unable to Fetch Account Balance");
	  Utility.screenshot(driver, "Account_Balace_of_Sameer");
	  
	  
   }
  
  
  
 @AfterMethod
 public void logOutFromNeoStox()
 {
	 home.logOut(driver);
 }

 @AfterClass
 public void closeBrowser()
 {
	 Reporter.log("Closing Browser", true);
	 driver.close();
 }
 
	
	
	
	
}
