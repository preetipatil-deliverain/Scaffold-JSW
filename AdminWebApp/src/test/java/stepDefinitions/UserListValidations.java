package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import cucumber.api.Scenario;

public class UserListValidations {
	//		 String URL = "https://scaffold-dev.deliverain.io:5000/Login";
		 public static Scenario scenario;
		 WebDriver driver;
		 public UserListValidations(CommonSteps commonsteps){
				driver=commonsteps.getDriver();
			}	

	@Then("Verify the table {string} is displayed")
	public void Verifytableheader(String header) {
		boolean headertext = driver.findElement(By.xpath("//div[@class='table-responsive']//thead//tr//th[text()='"+header+"']")).isDisplayed();
		
		
		if (headertext == true)
			System.out.println(header+" Section is displayed");
		 else
			 System.out.println(header+" Section is not displayed");
		System.out.print(headertext);
	}
	@Then("verify Action buttons are displayed")
	public void Verifyactionbuttonds() {
		boolean Edit = driver.findElement(By.linkText("Edit")).isDisplayed();
		System.out.print("Edit is displayed"+Edit);
		boolean Delete = driver.findElement(By.xpath("//div[@id='logContainer']//tr//span[text()='Delete']")).isDisplayed();
		System.out.print("Delete is displayed"+Delete);
	}
	
	@Then("verify All headers {string} are displayed")
	public void Verifyallheaders(String actualheader) {
		 List<WebElement> header=driver.findElements(By.xpath("//div[@class=\"table-responsive\"]//thead//th"));
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
	@And("Click on Add Record button")
	public void Clickonaddrecordbutton() {
		driver.findElement(By.xpath("(//div[@id='logContainer']//a)[1]")).click();
	}
	@Then("I Create user")
	public void Createuser() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='logContainer']//form//input[@name='firstName']")).sendKeys("userone");
		driver.findElement(By.xpath("(//div[@id='logContainer']//form//input)[2]")).sendKeys("userone");
		driver.findElement(By.xpath("(//div[@id='logContainer']//form//input)[3]")).sendKeys("123");
		Select role=new Select(driver.findElement(By.xpath("//div[@id='logContainer']//form//select[@id='inputRole']")));
		role.selectByVisibleText("Operator");
		Select reportingto=new Select(driver.findElement(By.xpath("//div[@id='logContainer']//form//select[@id='inputReportingTo']")));
		reportingto.selectByVisibleText("Test User User");
		Select primarylocation=new Select(driver.findElement(By.xpath("//div[@id='logContainer']//form//select[@id='inputPrimaryLocation']")));
		primarylocation.selectByVisibleText("ASCE");
		Select secondarylocation=new Select(driver.findElement(By.xpath("//div[@id='logContainer']//form//select[@id='inputSecondaryLocation']")));
		secondarylocation.selectByVisibleText("Turbine DCS");
		Select secondarylocation2=new Select(driver.findElement(By.xpath("//div[@id='logContainer']//form//select[@id='inputSecondaryLocation2']")));
		secondarylocation2.selectByVisibleText("Turbine Local");
		driver.findElement(By.xpath("(//div[@id='logContainer']//form//input)[4]")).sendKeys("user1@deliverain.com");
		driver.findElement(By.xpath("(//div[@id='logContainer']//form//input)[5]")).sendKeys("12345667890");
		driver.findElement(By.xpath("(//div[@id='logContainer']//form//input)[6]")).sendKeys("Test@123");
		driver.findElement(By.xpath("((//div[@id='logContainer']//form//div)[18]//input)[2]")).click();
	}
	
	@Then("I delete a record")
	public void Ideleterecord() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		
		driver.findElement(By.xpath("(//div[@id='logContainer']//tr//span[text()='Delete'])[last()]")).click();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String changes=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='snackbar']"))).getText();
		Assert.assertEquals(changes, "Delete User Successful");
		System.out.print("last record is Deleted");	
	}
	
	@And("Verify the record is deleted successfuly")
	public void Verifyrecorddeleted() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String changes=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='snackbar']"))).getText();
		Assert.assertEquals(changes, "Delete User Successful");
		System.out.print("last record is Deleted");	
	}
	
	@Then("Click on edit")
	public void Clickonedit() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		
		driver.findElement(By.xpath("(//div[@id='logContainer']//tr//a[text()='Edit'])[last()]")).click();
		System.out.print("Edit  is clicked");	
	}
	
	@Then("I edit a record")
	public void Editrecord() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.xpath("//div[@id='logContainer']//form//input[@name='firstName']")).clear();
		driver.findElement(By.xpath("//div[@id='logContainer']//form//input[@name='firstName']")).sendKeys("useroneTest");
		driver.findElement(By.xpath("((//div[@id='logContainer']//form//div)[18]//input)[2]")).click();		
	}
	
	@Then("Verify the changes")
	public void Verifthechanges() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String changes=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='snackbar']"))).getText();
		Assert.assertEquals(changes, "Edit User Successful");
		System.out.print("Edited text is matching"+changes);
		
	}
	@Then("Click on cancel button on create user page")
	public void Clickoncancelbutton() throws InterruptedException {		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='logContainer']//form//input[@name='firstName']")).sendKeys("userone");
		driver.findElement(By.xpath("(//div[@id='logContainer']//form//input)[2]")).sendKeys("userone");
		driver.findElement(By.xpath("(//div[@id='logContainer']//form//input)[3]")).sendKeys("123");
		Select role=new Select(driver.findElement(By.xpath("//div[@id='logContainer']//form//select[@id='inputRole']")));
		role.selectByVisibleText("Operator");
		Select reportingto=new Select(driver.findElement(By.xpath("//div[@id='logContainer']//form//select[@id='inputReportingTo']")));
		reportingto.selectByVisibleText("Test User User");
		Select primarylocation=new Select(driver.findElement(By.xpath("//div[@id='logContainer']//form//select[@id='inputPrimaryLocation']")));
		primarylocation.selectByVisibleText("ASCE");
		Select secondarylocation=new Select(driver.findElement(By.xpath("//div[@id='logContainer']//form//select[@id='inputSecondaryLocation']")));
		secondarylocation.selectByVisibleText("Turbine DCS");
		Select secondarylocation2=new Select(driver.findElement(By.xpath("//div[@id='logContainer']//form//select[@id='inputSecondaryLocation2']")));
		secondarylocation2.selectByVisibleText("Turbine Local");
		driver.findElement(By.xpath("(//div[@id='logContainer']//form//input)[4]")).sendKeys("user1@deliverain.com");
		driver.findElement(By.xpath("(//div[@id='logContainer']//form//input)[5]")).sendKeys("12345667890");
		driver.findElement(By.xpath("(//div[@id='logContainer']//form//input)[6]")).sendKeys("Test@123");
		driver.findElement(By.xpath("((//div[@id='logContainer']//form//div)[18]//input)[1]")).click();
	}
	
	@And("Verify the user list page")
	public void Verifyuserlistpage() throws InterruptedException {
		
		Thread.sleep(3000);
		String userlist=driver.findElement(By.xpath("//div[text()='User List']")).getText();
		Assert.assertEquals(userlist, "User List");		
	}
	@And("Verify Email column")
	public void Verifycolumn() throws InterruptedException {
		
		Thread.sleep(3000);
//		String userlist=driver.findElement(By.xpath("//div[text()='User List']")).getText();
//		Assert.assertEquals(userlist, "User List");		
		 List<WebElement> Emailcolumn=driver.findElements(By.xpath("//div[@class='table-responsive']//table//tbody//tr//td[2]"));
		 int columncount=Emailcolumn.size();
		 for(int i=0;i<=columncount;i++)
		 {
			 for (WebElement emal : Emailcolumn) {
				
				 String emailid=emal.getText();
				 if(emailid.isEmpty())
				 {
					 break;
				 }
				 System.out.print("emailid is present\n"+emailid);
				 
			}
		 }
		 System.out.print("emailid is  not present"+Emailcolumn);
	}
	
	
}

