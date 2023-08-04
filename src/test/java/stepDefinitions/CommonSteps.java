package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import Utility.Hooks;
import cucumber.api.Scenario;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import stepDefinitions.BaseDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class CommonSteps implements Framework_constants{
	public static WebDriver driver;
	static String URL = "https://scaffold-dev.deliverain.io:8090/Login";
	static BaseDriver basedriver;
	static Scenario scenario;
	public static ExtentTest test;

	public static WebDriver getDriver() throws WebDriverException {	
		//if (driver != null)
		//driver.close();		
		WebDriverManager.chromedriver().setup();
		if (driver == null)
			driver =new ChromeDriver();
		driver.manage().window().maximize();
//		try {
//			TakeScreenshot("ScaffoldV2Applaunch");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return driver;
	}

	public static void TakeScreenshot(WebDriver driver,ITestResult result)
			throws IOException
	{
		Date date = new Date();
		String actual_date=date.toString().replaceAll(":", "-");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(screenshot_path+actual_date+result.getName()+".jpeg");
		try
		{
			FileHandler.copy(src, dst);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void launchBrowser(){
		// TODO Auto-generated method stub	
		getDriver();
		System.out.print("Initializing the browser");	
		try {
			Runtime.getRuntime().exec("taskkill /F /IM <browserinstance>.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(URL);		
		System.out.println("Browser was launched and navigated to URL:" + URL);		
	}	

}
