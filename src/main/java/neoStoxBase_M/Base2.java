package neoStoxBase_M;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base2 {

//Here write down all browser launch and close methods.
 protected static WebDriver driver;
public void launchBrowser() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "E:\\velocity_Testing\\chromedriver.exe");
    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://neostox.com/sign-in");
    Thread.sleep(7000);

}
	
	
	
	
}
