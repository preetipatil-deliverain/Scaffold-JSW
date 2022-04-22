package stepDefinitions;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WaterSteamCycleLocalLog {
	public static Scenario scenario;
	 WebDriver driver;
	 public WaterSteamCycleLocalLog(CommonSteps commonsteps){
			driver=commonsteps.getDriver();
		}	
	 @Then("Verify {string} page is displayed")
	 public void verify_page_is_displayed(String string) {
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
		 driver.findElement(By.linkText(string)).click();
	 }
	 @And("Verify table data")
	 public void Verifytabledata() {
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
			List<WebElement> Data=driver.findElements(By.xpath("//div[@id='asset_section']//div[@id='assetcontainer_00']//div//div"));
			
			for(WebElement TableData:Data)
			 {
				String columntext=TableData.getText();
				
			 }
			 }
	 
@Then("verify downloaded file")
public void VerifyDownloadedFile() throws InterruptedException {
//	String home = System.getProperty("C:\\Users\\Dell");
//    String file_name = "Water Steam Cycle Local Log_04-04-2022.xlsx";
//    String file_with_location = home + "\\Downloads\\" + file_name;
//    System.out.println("Function Name ===========================" + home + "\\Downloads\\" + file_name);
//    File file = new File(file_with_location);
//    if (file.exists()) {
//        System.out.println(file_with_location + " is present");
//        
//    } else {
//        System.out.println(file_with_location + " is not present");
//    }
	File file = new File("C:\\Users\\Dell\\Downloads\\Water Steam Cycle Local Log_16-04-2022.xlsx"); 
	   if(file.delete())
	       System.out.println("file deleted");
	   else
	 System.out.println("file not deleted");
	   
    // Write code here that turns the phrase above into concrete actions
    
    driver.findElement(By.linkText("Download")).isDisplayed();
    driver.findElement(By.linkText("Download")).click();	    
     System.out.println("Downloaded");
     Thread.sleep(3000);
//     String home = System.getProperty("C:\\Users\\Dell");
	    String file_name = "Water Steam Cycle Local Log_16-04-2022.xlsx";
	    String file_with_location = "C:\\Users\\Dell" + "\\Downloads\\" + file_name;
	    System.out.println("Function Name ===========================" + "C:\\Users\\Dell" + "\\Downloads\\" + file_name);
	    File files = new File(file_with_location);
	    if (files.exists()) {
	        System.out.println(file_with_location + " is present");
	        
	    } else {
	        System.out.println(file_with_location + " is not present");
	    }
     
//     Thread.sleep(5000);
	
//	String downloadPath = "C:\\Users\\Dell\\Downloads";
//	   File getLatestFile = getLatestFilefromDir(downloadPath);
//	   String fileName = getLatestFile.getName();
//	   Assert.assertTrue(fileName.equals("Water Steam Cycle Local Log_04-04-2022.xlsx"), "Downloaded file name is not matching with expected file name");
    
    }
private File getLatestFilefromDir(String downloadPath) {
	// TODO Auto-generated method stub
	return null;
}	
@And("Search for result {string}")
public void SearchResul(String string) {
	 JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	 driver.findElement(By.id(string)).sendKeys("BP Seal");
	 
}

@Then("Verify the search Result")
public void verify_the_search_result() {
    
}
@Then("Select Date from date picker")
public void select_date_from_date_picker() {
	 driver.findElement(By.xpath("//button//img")).click();
	 driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//a//span[text()='Prev']")).click();
//	 driver.findElement(By.id("datepicker")).click();
	 Calendar cal = Calendar.getInstance();          
	 cal.add(Calendar.MONTH, -1);
	 cal.add(Calendar.DATE, -1);
	 System.out.println("calander:  "+cal);
	 driver.findElement(By.id("datepicker")).sendKeys(Keys.ENTER);
	 
}

}
