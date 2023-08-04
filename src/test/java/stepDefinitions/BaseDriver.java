package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class BaseDriver extends CommonSteps{
	private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	private static final String USERNAME = "Test"; //"TOOLSQA-Test";
	private static final String PASSWORD = "Test@123";//"Test@@123";
	private static final String BASE_URL = "https://bookstore.toolsqa.com";

	private static String token;
	private static Response response;
	private static String jsonString;
	private static String bookId;
	WebDriver driver;
	public static Scenario scenario;
	CommonSteps commonsteps;
	WebElement profile;
	public BaseDriver(CommonSteps commonsteps) throws Exception{
		driver=commonsteps.getDriver();		
	}	
@Test
	@And("Verify if user logged in sucessfully")
	public void verfiylogin() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		
		System.out.print("Login Validation");
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Enquiry" );
		System.out.println("Logged in successfully");
		profile = driver.findElement(By.xpath("//img[@src='/img/default-avatar.svg']"));
		profile.isDisplayed();
		System.out.println("Profile image is displayed");
		driver.findElement(By.xpath("//div[@id='cmp-logo']")).isDisplayed();	
		System.out.println("Application logo is displayed");
		driver.findElement(By.xpath("//*[local-name()='svg']")).isDisplayed();
		System.out.println("System Notification is displayed");
		System.out.println("All the verification points were confirmed post login");
//		try {
//			commonsteps.TakeScreenshot("LoginSuccessful");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Assert.fail();
//		test.log(Status.FAIL, "screenshot captured");
	}

	@Given("Logout of the application")
	public void logout_of_the_application()throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions
		WebElement logout = driver.findElement(By.xpath("//img[@alt='Logout']"));
		if (profile.isDisplayed()) {
			profile.click();
			logout.click();
			
		}else {
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", logout);
		}
//		try {
////			commonsteps.TakeScreenshot("LogoutSuccessful");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@When("^verify if \"(.*?)\" section is displayed$")
	public void verifyScaffoldWebAppsection(String string) throws InterruptedException, IOException {
		//driver.findElement(By.xpath("//*[@id=\"toggleBtn\"]/img")).click();
		boolean sectiondisplay = driver.findElement(By.linkText(string)).isDisplayed();
		if (sectiondisplay == true) {
			System.out.println(string+" Section is displayed");
//			commonsteps.TakeScreenshot(string +"sectiondisplayed");
		}else {
			System.out.println(string+" Section is not displayed");
//			try {
//				commonsteps.TakeScreenshot(string +"sectionnotdisplayed");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

	@When("^verify if \"(.*?)\" report links are displayed$")
	public void verifyReportLogsion(String string) throws InterruptedException, IOException {
		//driver.findElement(By.xpath("//*[@id=\"toggleBtn\"]/img")).click();
		boolean sectiondisplay = driver.findElement(By.linkText(string)).isDisplayed();
		if (sectiondisplay == true)
			System.out.println(string+" Reportlog is displayed");
		else
			System.out.println(string+" Reportlog is not displayed");
	}	
}