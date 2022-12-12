package utility_M;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
	public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		File myfile= new File("E:\\velocity_Testing\\ExcelStudy.xlsx");
		String value = WorkbookFactory.create(myfile).getSheet("Sheet3").getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("reading data from excel", true);
		return value;
		
	}
	
	public static void screenshot(WebDriver driver,String screenShotName) throws IOException
	{
		      waittime(driver, 2000);
	          File Source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   		    		  
	   		  File Destination= new File("E:\\velocity_Testing\\Manual-Testing\\Automation\\ScreenshotOutput\\"+screenShotName+".png");
	   		  FileHandler.copy(Source, Destination); 
	   		  Reporter.log("Taking ScreenShot", true);
	}            
	             
	 public static void scrollingintoview(WebDriver driver,WebElement element)
	 {		        
		               waittime(driver, 2000);
		               JavascriptExecutor js = (JavascriptExecutor)driver;
		               js.executeScript("arguments[0].scrollIntoView(true)", element);
		 
	 }
	         
public static void waittime(WebDriver driver, int waitTime)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		  Reporter.log("Waiting for"+waitTime+"ms", true);



}
}