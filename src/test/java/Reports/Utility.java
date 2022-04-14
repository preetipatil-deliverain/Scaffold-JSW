package Reports;

import java.io.File;
import java.sql.DriverManager;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sun.jna.platform.FileUtils;

import cucumber.api.Scenario;

public class Utility {
	static WebDriver driver;
	public static String fileWithPath;
	public static String SrcFile;
	
	
	public static Scenario message;    

	public static void takeScreenShotAfterEveryStep() {
	        TakesScreenshot screenshot = (TakesScreenshot) driver;
	        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

               // FileUtils.copyFile(SrcFile, DestFile);
	    }
	public static void setData() {
		
	}
}
