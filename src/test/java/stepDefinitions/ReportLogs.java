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
		case "Plant Summary":
			strHeader = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div/div[2]/div[1]/div[1]/div")).getText();
			if (strHeader.equals(string)){
				System.out.println(string+" Report Log is displayed");
			}else {
				System.out.println(string+" Report Log is not displayed");
//				commonsteps.TakeScreenshot(string +"report log not displayed");
			}
			break;
		case "Consolidated Reports":		
			strHeader = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div")).getText();
			if (strHeader.contains(string)){
				System.out.println(string+" Report Log is displayed");
			}else {
				System.out.println(string+" Report Log is not displayed");
//				commonsteps.TakeScreenshot(string +"report log not displayed");
			}
			break;
		default:
			strHeader = driver.findElement(By.xpath("//*[@id=\"logContainer\"]/form/div[1]/div[1]")).getText();
			System.out.println(strHeader);
			if (strHeader.contains(string)){
				System.out.println(string+" Report Log is displayed");
			}else {
				System.out.println(string+" Report Log is not displayed");
//				commonsteps.TakeScreenshot(string +"report log not displayed");
			}	
			break;
		}
	}

	@And("^click on the \"(.*?)\" link$")
	public void clickReportLogs(String string) throws InterruptedException, IOException {
		Thread.sleep(500);
		driver.findElement(By.linkText(string)).click();
	}
}

