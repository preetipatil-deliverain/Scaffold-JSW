package Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import stepDefinitions.CommonSteps;
import cucumber.api.Scenario;

import java.sql.DriverManager;

import org.apache.log4j.Logger;


public class Hooks extends AbstractTestNGCucumberTests {	

	WebDriver driver;
	Logger log = Logger.getLogger(Hooks.class);
	public Hooks(CommonSteps commonsteps) throws Exception{
		driver=CommonSteps.getDriver();		
	}

	@Before
	public void setUp() {
		System.out.println("Application is initiated");

	}
	
	@After
	public void tearDown(Scenario scenario) {
		log.info("Closing the browsers");
		//if (scenario.isFailed()) 
			try{
				System.out.println(scenario.getStatus()+"is failed");
				final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}catch (Exception e) {
				e.printStackTrace();

			}
		this.driver.quit();
	}

}
