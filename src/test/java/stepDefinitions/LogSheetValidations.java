package stepDefinitions;

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

public class LogSheetValidations {

	 public static Scenario scenario;
	 WebDriver driver;
	 public LogSheetValidations(CommonSteps commonsteps){
			driver=commonsteps.getDriver();
		}	

	 @Then("Click on save button")
	 public void click_on_save_button() {
		 driver.findElement(By.xpath("//input[@id='unitSuccessBtn']")).click();
		 try {
		 WebElement timeleft=driver.findElement(By.xpath("(//div[@class='row m-0']//div[@class='col my-auto text-center']//div)[1]"));
		 System.out.print("Time left"+timeleft.getText());
		 }
		 catch(Exception e){
			 WebElement Timeout=driver.findElement(By.xpath("//div[text()='Time out!']"));
			 System.out.print("Time out!!!"+Timeout.getText());
		 }
		 }
	 
}
