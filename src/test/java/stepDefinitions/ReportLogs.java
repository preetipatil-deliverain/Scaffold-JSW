package stepDefinitions;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.io.IOException;

public class ReportLogs{
	WebDriver driver;
	Scenario scenario;
	CommonSteps commonsteps;
	String strHeader;
	public ReportLogs(CommonSteps cm){
		driver=cm.getDriver();
	}

	@When("^verify if \"(.*?)\" Report log page is displayed$")
	public void verifyScaffoldReportLog(String string) throws InterruptedException, IOException {
		System.out.println(string);
		Thread.sleep(5000);
		switch(string) {
		case "24Hr Log Report":
			strHeader = driver.findElement(By.id("dashboard_embeddedbi_title")).getText();
			if (strHeader.equals(string)){
				System.out.println(string+" Report Log is displayed");
			}else {
				System.out.println(string+" Report Log is not displayed");
				commonsteps.TakeScreenshot(string +"reportlognotdisplayed");
			}
			break;
		case "Consolidated Reports":		
			strHeader = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div")).getText();
			if (strHeader.contains(string)){
				System.out.println(string+" Report Log is displayed");
			}else {
				System.out.println(string+" Report Log is not displayed");
				commonsteps.TakeScreenshot(string +"reportlognotdisplayed");
			}
			break;
		default:
			strHeader = driver.findElement(By.cssSelector("#logContainer > form > div.row.f-13.fw-500.c-black > div.col-lg-4.f-14.my-auto")).getText();
			System.out.println(strHeader);
			if (strHeader.contains(string)){
				System.out.println(string+" Report Log is displayed");
			}else {
				System.out.println(string+" Report Log is not displayed");
				commonsteps.TakeScreenshot(string +"reportlognotdisplayed");
			}	
			break;
		}
	}

	@And("^click on the \"(.*?)\" link$")
	public void clickReportLogs(String string) throws InterruptedException, IOException {
		driver.findElement(By.linkText(string)).click();
	}
}

