package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationListValidations {

	 public static Scenario scenario;
	 WebDriver driver;
	 public LocationListValidations(CommonSteps commonsteps){
			driver=commonsteps.getDriver();
		}	
	 @When("I click on menu icon")
	 public void i_click_on_menu_icon() {
		 driver.findElement(By.xpath("//span[@id='toggleBtn']")).click();
	 }
	 
	 @When("I click on Administrator Menu")
	 public void i_click_on_adm_menu() {
		 driver.findElement(By.linkText("Administration")).click();
	 }
	 
	 @When("I click on Report Menu")
	 public void i_click_on_rep_menu() {
		 driver.findElement(By.linkText("Report")).click();
	 }
	 
	 @Then("Click on Locations option")
	 public void click_on_locations_option() throws InterruptedException {
		 Thread.sleep(500);
		 driver.findElement(By.linkText("Locations")).click(); 
	 }
	 @Then("Verify Location List page is displayed")
	 public void verify_location_list_page_is_displayed() throws InterruptedException {
		 Thread.sleep(3000);
			String userlist=driver.findElement(By.xpath("//div[text()='Location List']")).getText();
			Assert.assertEquals(userlist, "Location List");		
	 }
	 
	 @Then("Verify Manage Assets List page is displayed")
	 public void verify_ManageAssets_list_page_is_displayed() throws InterruptedException {
		 Thread.sleep(3000);		 
			String manageassetlist=driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div")).getText();
			Assert.assertEquals(manageassetlist, "LogSheet List");		
	 }
	 
	 @Then("verify All headers {string} are displayed on Location List table")
		public void verify_all_headers_are_displayed_on_location_list_table(String actualheader) {
		 List<WebElement> header=driver.findElements(By.xpath("(//div[@id='logContainer']//div)[6]//thead//th"));
		 boolean staus=false;
		 System.out.print("Headers"+header);
		 for(WebElement ele:header)
		 {
		 String headervalue=ele.getText();
		 System.out.print("Headers-----"+headervalue);
			if(headervalue.contentEquals(actualheader))
					{
				staus=true;
				break;
					}
		  }
		 System.out.print("Headers are displayed");
		}
	 @Then("verify All headers {string} are displayed on Manage Assets List table")
		public void verify_all_headers_are_displayed_on_Manage_Assets_table(String actualheader) {
		 List<WebElement> header=driver.findElements(By.xpath("//div[@class=\"table-responsive\"]//thead//th"));
		 boolean status=false;
		 System.out.print("Headers"+header);
		 for(WebElement ele:header)
		 {
		 String headervalue=ele.getText();
		 System.out.print("Headers-----"+headervalue);
			if(headervalue.contentEquals(actualheader))
					{
				status=true;
				break;
					}
		  }
		 System.out.print("Headers are displayed");
		}
	 
	 @Then("verify Edit link is displayed on the location list table")
	 public void verify_edit_link_is_displayed_on_location_list_table() {
		 boolean Edit = driver.findElement(By.linkText("Edit")).isDisplayed();
			System.out.print("Edit is displayed"+Edit);
	 }
	 @Then("I create a Location")
	 public void i_create_a_location() throws InterruptedException {

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='inputLocation']")).sendKeys("TestLocation");
			Select Status=new Select(driver.findElement(By.xpath("//select[@id='status']")));
			Status.selectByVisibleText("Active");
			//WebElement NFCCheckbox=driver.findElement(By.xpath("//input[@id='enableNFC']"));
			//NFCCheckbox.click();
			 List <WebElement> LogSheetsCheckbox=driver.findElements(By.xpath("(//div[@id='logContainer']//div)[8]//div//div//label"));
			int size=LogSheetsCheckbox.size();
			for(int i=0; i<=4;i++)
			{
			
				LogSheetsCheckbox.get(i).click();
				System.out.print("LogSheetsCheckbox is selected"+LogSheetsCheckbox);
			}
			driver.findElement(By.xpath("(//div[@class='form-group col-md-12 text-center mt-3']//input)[2]")).click();
			
	 }
	 @Then("Verify Location is created successfuly")
		public void Verifylocationcreatedsuccessfuly() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			String SuccessMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("snackbar"))).getText();
			Assert.assertEquals(SuccessMessage, "Create Location Successful");
			System.out.print("Location created successfuly"+SuccessMessage);
			
		}
	 @Then("I create a Location and click on cancel button")
		public void Clickoncancelbutton() throws InterruptedException {
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='inputLocation']")).sendKeys("TestLocation");
			Select Status=new Select(driver.findElement(By.xpath("//select[@id='status']")));
			Status.selectByVisibleText("Active");
			//WebElement NFCCheckbox=driver.findElement(By.xpath("//input[@id='enableNFC']"));
			//NFCCheckbox.click();
			 List <WebElement> LogSheetsCheckbox=driver.findElements(By.xpath("(//div[@id='logContainer']//div)[8]//div//div//label"));
			int size=LogSheetsCheckbox.size();
			for(int i=0; i<=4;i++)
			{
			
				LogSheetsCheckbox.get(i).click();
				System.out.print("LogSheetsCheckbox is selected"+LogSheetsCheckbox);
			}
			driver.findElement(By.xpath("(//div[@class='form-group col-md-12 text-center mt-3']//input)[1]")).click();
			
		}
	 
	 @When("^verify if \"(.*?)\" is displayed in Manage Assets page$")
		public void verifyManageAssetslog(String actualstring) throws InterruptedException, IOException {
		 List<WebElement> header=driver.findElements(By.xpath("//div[@class='table-responsive']//table//tbody//tr//td"));
		 System.out.print(header);
		 boolean staus=false;
		 System.out.print("Headers"+header);
		 for(WebElement ele:header)
		 {
		 String headervalue=ele.getText();
		 System.out.print("Headers-----"+headervalue);
			if(headervalue.contentEquals(actualstring))
					{
				staus=true;
				break;
					}
		  }
		 System.out.print("Headers are displayed");
		}
}
