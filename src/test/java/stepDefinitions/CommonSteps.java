package stepDefinitions;

import java.io.File;
import java.io.IOException;

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


public class CommonSteps {
	public static WebDriver driver;
	static String URL = "https://scaffold-dev.deliverain.io:5000/Login";
	static BaseDriver basedriver;
	static Scenario scenario;


	public static WebDriver getDriver() throws WebDriverException {	
		//if (driver != null)
		//driver.close();		
		WebDriverManager.chromedriver().setup();
		if (driver == null)
			driver =new ChromeDriver();
		driver.manage().window().maximize();
		try {
			TakeScreenshot("ScaffoldV2Applaunch");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	public static void TakeScreenshot(String FileName)
			throws IOException
	{
		// Creating instance of File
		File File = ((TakesScreenshot)driver)
				.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(File,
				new File("E:\\ScaffoldReport\\Scaffold\\AdminWebApp\\AdminWebApp\\AdminWebApp\\screenshots\\"
						+ FileName + ".jpeg"));
		byte[] file = ((TakesScreenshot)driver)
				.getScreenshotAs(OutputType.BYTES);
		//scenario.write("testing");//(file, "image/png");

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
