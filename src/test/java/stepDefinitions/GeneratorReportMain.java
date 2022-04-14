package stepDefinitions;

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import stepDefinitions.BaseDriver;
import cucumber.api.Scenario;


public class GeneratorReportMain{

	String URL = "https://scaffold-dev.deliverain.io:5000/Login";
	public static Scenario scenario;
	WebDriver driver;
	CommonSteps commonsteps;
	public GeneratorReportMain(CommonSteps commonsteps){
		driver=commonsteps.getDriver();
	}	 

	@Given("Login into Scaffold Log Automation Application As Admin")
	public void login_into_scaffold_log_automation_application_as_admin() throws InterruptedException, IOException {
		//Navigate to URL
		Thread.sleep(2000);
		System.out.println("Driver"+driver);
		System.out.println("Step 1");
		CommonSteps.launchBrowser();
		System.out.println("Scenario"+scenario);
		Thread.sleep(3000);
		driver.findElement(By.id("user-name")).sendKeys("vinod.r@deliverain.com");
		driver.findElement(By.id("password")).sendKeys("Test@123");
		driver.findElement(By.id("Submit")).click();
		System.out.println("Logged in");
		//scenario.write("Logged in");
		commonsteps.TakeScreenshot("LoginSucessful");
	}

	@Then("Navigate to Generator Main Log Report")
	public void navigate_to_generator_log_report() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions		
		driver.findElement(By.xpath("//*[@id=\"toggleBtn\"]/img")).click();
		driver.findElement(By.linkText("Generator Hourly Log - Main")).click();
		Thread.sleep(5000);
		String LogNo = driver.findElement(By.xpath("//*[@id=\"logContainer\"]/form/div[1]/div[1]")).getText();
		if (LogNo.contains("Generator Hourly Log (Main) - Log No : 13")){
			System.out.print("Generator log is displayed");	
			//scenario.write("Generator log is displayed");
		}else {
			System.out.print("Generator log is not displayed");
			//scenario.write("Generator log is not displayed");
		}
	}

	@And("verify if all the assets associated with Generator Main Report is displayed")
	public void testvalidation() {
	}
}
