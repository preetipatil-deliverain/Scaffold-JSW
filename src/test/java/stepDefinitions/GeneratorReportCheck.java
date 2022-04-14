package stepDefinitions;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.io.IOException;

public class GeneratorReportCheck{
	WebDriver driver;
	Scenario scenario;
	public GeneratorReportCheck(CommonSteps cm){
		driver=cm.getDriver();
	}


	@Then("Navigate to Generator Check Log Report")
	public void navigate_to_generator_check_log_report()throws InterruptedException, IOException {
		System.out.print("Driver details" +driver);
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"toggleBtn\"]/img")).click();
		driver.findElement(By.linkText("Generator Hourly Log - Check")).click();
		Thread.sleep(5000);
		String LogNo = driver.findElement(By.xpath("//*[@id=\"logContainer\"]/form/div[1]/div[1]")).getText();
		if (LogNo.contains("Generator Hourly Log (Check) - Log No : 13")){
			System.out.print("Generator log is displayed");	    
		}else {
			System.out.print("Generator log is not displayed");
			//scenario.write("Generator is not displayed");
		}
	}

	@Then("^Validate all the assets displayed in Generator Check log$")
	public void validateAllTheAssetsDisplayedInGeneratorCheckLog() throws Throwable {
		System.out.println("Asset validation is in progress");

	}

}
