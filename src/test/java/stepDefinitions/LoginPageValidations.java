package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;

import cucumber.api.Scenario;

public class LoginPageValidations {
	
	public static Scenario scenario;
	WebDriver driver;
	public LoginPageValidations(CommonSteps commonsteps){
		driver=commonsteps.getDriver();
	}
/*	@Given("Navigate to scaffold v2 web application") 
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
		Assert.assertEquals(Title, "Login - TAQA" );
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
	
	@Then("verify if error message {string} {string} displayed")
	public void Verifyerrormessageifnousernameandpassword(String message1, String message2) {
		String UsernameMessage=driver.findElement(By.xpath("//*[@id=\"user-name-error\"]")).getText();
		System.out.println("UsernameMessage"+ UsernameMessage);
		Assert.assertEquals(UsernameMessage, message1 );
		System.out.println("ErrorMessage is matching "+ UsernameMessage);

		String PasswordMessage=driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText();
		System.out.println("UsernameMessage"+ PasswordMessage);
		Assert.assertEquals(PasswordMessage, message2 );
		System.out.println("ErrorMessage is matching "+ PasswordMessage);

	}
	@Then("verify if error message {string} displayed for blank username field")
	public void Verifyerrormessageifnousername(String message1) {
		String UsernameMessage=driver.findElement(By.xpath("//*[@id=\"user-name-error\"]")).getText();
		System.out.println("UsernameMessage"+ UsernameMessage);
		Assert.assertEquals(UsernameMessage, message1 );
		System.out.println("ErrorMessage is matching "+ UsernameMessage);


	}
	@Then("verify if error message {string} displayed for blank password field")
	public void Verifyerrormessageifnopassword(String message1) {
		String PasswordMessage=driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText();
		System.out.println("UsernameMessage"+ PasswordMessage);
		Assert.assertEquals(PasswordMessage, message1 );
		System.out.println("ErrorMessage is matching "+ PasswordMessage);

	} */
}
