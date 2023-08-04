package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login {
	
	public static Scenario scenario;
	WebDriver driver;
	public Login(CommonSteps commonsteps){
		driver=commonsteps.getDriver();
	}
	@Given("Navigate to scaffold JSW EMS web application") 
	public void Navigatetoscaffoldwebapplication() throws InterruptedException, IOException {

		Thread.sleep(2000);
		CommonSteps.launchBrowser();
		//	System.out.println("Step 1");
		Thread.sleep(2000);
		//	driver.get(URL);
		System.out.println("Driver----"+driver);

		String AppURL = driver.getCurrentUrl();
		Thread.sleep(2000);
		System.out.println("Step2 AppURL"+AppURL);
		Assert.assertEquals(AppURL, "https://scaffold-dev.deliverain.io:8090/Login" );
		System.out.println("URL matching --> Part executed");

	}

	@And("I click on login button") 
	public void Clickonloginbutton() throws Exception {

		driver.findElement(By.id("Submit")).click();
		System.out.println("Logged in");

	}
	@Then("Verify if login screen is displayed") 
	public void loginscreendisplayed() {

		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Login" );
		System.out.println("Loggin page issplayed");

	}
	@And("verify if error message {string} displayed") 
	public void Verifyloginerrormessage(String message) throws Exception {

		String ErrorMessage=driver.findElement(By.xpath("(//div[@class='login-wrapper']//div//form//div//div//div)[2]//li[text()='Incorrect Email or Password']")).getText();
		System.out.println("ErrorMessage"+ ErrorMessage);
		//	Assert.assertEquals(ErrorMessage, "Incorrect Email or Password" );
		Assert.assertEquals(ErrorMessage, message );

		System.out.println("ErrorMessage is matching "+ ErrorMessage);
	}
	@And("I enter the username {string}")
	public void Enterusername(String username) {
		driver.findElement(By.id("user-name")).sendKeys(username);

	}

	@And("I enter the password {string}")
	public void Enterpassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	

}
