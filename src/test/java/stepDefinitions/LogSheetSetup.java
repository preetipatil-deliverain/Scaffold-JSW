package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogSheetSetup{
	WebDriver driver;
	Scenario scenario;
	public LogSheetSetup(CommonSteps cm){
		driver=cm.getDriver();
	}

	 @When("Validate if log sheet is displayed with default display as {string}")
		public void verifyLogSheetDisplay(String logsection) throws InterruptedException, IOException {
			//Navigate to URL
//			Thread.sleep(2000);
			String pageheader = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div")).getText();			
			if(pageheader.equalsIgnoreCase("Log Sheet")) {
				System.out.println("Log Sheet page is displayed");		
			}else {
				System.out.println("Log Sheet page is not displayed");
//				CommonSteps.TakeScreenshot("LogSheetSetup_Header");
			}
		    Select logsheetselect = new Select(driver.findElement(By.id("LogSheets")));
			String defaultValue = logsheetselect.getFirstSelectedOption().getText();
			if(defaultValue.equalsIgnoreCase(logsection)) {
				System.out.println(logsection+" is selected in default");		
			}else {
				System.out.println(logsection+" is not selected in default");	
//				CommonSteps.TakeScreenshot("LogSheetSetup_defaultSelection is incorrect");
			}
			 
		}
	 
	 @Then("verify Asset headers {string} displayed in logsheet page")
		public void Verifylogsheetheaders(String strheadername) {
		 switch(strheadername){    
		    //case statements within the switch block  
		    case "Gauge Name":
		    	String strguagename = driver.findElement(By.id("nameGuage_0_0")).getText();
		    	if (strguagename.equals("Gauge Name"))
		    		System.out.println("Gauge Name is displayed");
		    	else
		    		System.out.println("Gauge Name is not displayed");
		    	break;    
		    case "Code":
		    	String strcode = driver.findElement(By.id("nameCode_0_0")).getText();
		    	if (strcode.equals("Code"))
		    		System.out.println("Code is displayed");
		    	else
		    		System.out.println("Code is not displayed");
		    	break;
		    case "Status":
		    	String strstatus = driver.findElement(By.xpath("//*[@id=\"faq_0_0\"]/div/table/thead[1]/tr/th[3]")).getText();
		    	if (strstatus.equals("Status"))
		    		System.out.println("Status is displayed");
		    	else
		    		System.out.println("Status is not displayed");
		    	break;
		    case "Display":
		    	String strdisplay = driver.findElement(By.xpath("//*[@id=\"faq_0_0\"]/div/table/thead[1]/tr/th[4]")).getText();
		    	if (strdisplay.equals("Display"))
		    		System.out.println("Display is displayed");
		    	else
		    		System.out.println("Display is not displayed");
		    	break; 
		    case "Enabled":
		    	String strenable = driver.findElement(By.xpath("//*[@id=\"faq_0_0\"]/div/table/thead[1]/tr/th[5]")).getText();
		    	if (strenable.equals("Enabled"))
		    		System.out.println("Enabled is displayed");
		    	else
		    		System.out.println("Enabled is not displayed");
		    	break; 
		    case "Mandatory":
		    	String srtmandat = driver.findElement(By.xpath("//*[@id=\"faq_0_0\"]/div/table/thead[1]/tr/th[6]")).getText();
		    	if (srtmandat.equals("Mandatory"))
		    		System.out.println("Mandatory is displayed");
		    	else
		    		System.out.println("Mandatory is not displayed");
		    	break;    	
		    case "Min Value":
		    	String strminval = driver.findElement(By.xpath("//*[@id=\"faq_0_0\"]/div/table/thead[1]/tr/th[7]")).getText();
		    	if (strminval.equals("Min Value"))
		    		System.out.println("Max Value is displayed");
		    	else
		    		System.out.println("Max Value is not displayed");
		    	break;    	
		   case "Max Value":
		    	String strmaxval = driver.findElement(By.xpath("//*[@id=\"faq_0_0\"]/div/table/thead[1]/tr/th[8]")).getText();
		    	if (strmaxval.equals("Max Value"))
		    		System.out.println("Max Value is displayed");
		    	else
		    		System.out.println("Max Value is not displayed");				
		    	break; 		     
		    default:
		    	System.out.println("No header validation");
		    	break;
		    } 
			 System.out.print("Headers are displayed");
		}	 
		 
	 @When("I select {string} as the option for update")
		public void selectLogsheetDropdown(String logselection) throws InterruptedException, IOException {
			//Navigate to URL
//			Thread.sleep(2000);			
		    Select logsheetselect = new Select(driver.findElement(By.id("LogSheets")));
		    logsheetselect.selectByVisibleText(logselection);		  
			String defaultValue = driver.findElement(By.id("LogSheets")).getText();
			if(defaultValue.equalsIgnoreCase(logselection)) {
				System.out.println(logselection+" is selected in default");		
			}else {
				System.out.println(logselection+" is not selected in default");	
//				CommonSteps.TakeScreenshot("LogSheetSetup_defaultSelectionincorrect");
			}
	 }
	 
	 @When("I verify if {string} is selected in the drop down")
		public void verifyLogsheetDropdown(String logselection) throws InterruptedException, IOException {
			//Navigate to URL
//			Thread.sleep(2000);			
		    //Select logsheetselect = new Select(driver.findElement(By.id("LogSheets")));		    
		    String defaultValue = driver.findElement(By.id("LogSheets")).getText();
			if(defaultValue.equalsIgnoreCase(logselection)) {
				System.out.println(logselection+" is selected in default");		
			}else {
				System.out.println(logselection+" is not selected in default");	
//				CommonSteps.TakeScreenshot("LogSheetSetup_IncorrectdropdownSelection");
			}
	 } 
	 
	 @Then("Enter assets for {string} for {string}")
		public void EnterAssetsData(String tableno, String assetname) throws InterruptedException {
//			Thread.sleep(2000);
			List<WebElement> select = null;
			List<WebElement> displayed = null;
			List<WebElement> Enabled = null;
			List<WebElement> Mandatory = null;
			List<WebElement> MinValue = null;
			List<WebElement> MaxValue = null;
			switch(tableno){    
		    //case statements within the switch block  
			case "Table 1":

//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				select = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//select"));
				displayed = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//td[@data-label='Display']"));
				Enabled = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//td[@data-label='Enabled']"));
				Mandatory = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//td[@data-label='Mandatory']"));
				MinValue = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//td[@data-label='Min Value']//input"));
				MaxValue = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//td[@data-label='Max Value']//input"));
				break;
		    case "Table 2":
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//td[@data-label='Max Value']//input"));
		    	break;
		    case "Table 3":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//td[@data-label='Max Value']//input"));
		    	break;
		    case "Table 4":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//td[@data-label='Max Value']//input"));
		    	break; 
		    case "Table 5":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//td[@data-label='Max Value']//input"));
		    	break; 
		    case "Table 6":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//td[@data-label='Max Value']//input"));
		    	break;    	
		    case "Table 7":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//td[@data-label='Max Value']//input"));
		    	break;    	
		   case "Table 8":
//			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 9":
//			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 10":
//			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 11":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 12":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 13":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 14":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 15":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 16":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 17":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 18":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 19":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 20":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 21":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 22":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 23":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 24":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 25":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 26":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 27":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 28":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 29":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 30":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
		   case "Table 31":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//td[@data-label='Max Value']//input"));
		    	
		    	break; 
case "Table 32":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 33":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 34":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 35":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 36":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 37":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 38":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 39":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 40":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 41":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 42":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 43":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 44":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 45":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 46":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 47":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 48":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 49":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 50":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 51":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 52":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 53":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 54":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 55":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 56":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 57":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//td[@data-label='Max Value']//input"));
		    	
		    	break; 
case "Table 58":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//td[@data-label='Max Value']//input"));
		    	
		    	break; 				
		    default:
		    	System.out.println("No header validation");
		    	break;
			}
			
			for (WebElement sel : select) {
				Select s = new Select(sel);
				if (assetname.equals("Shutdown Log General")) {
					s.selectByVisibleText("In Service");
				}
				else if(assetname.equals("Generator (MWhr)")||assetname.equals("UAT #1 (MWhr)")||assetname.equals("UAT #2 (MWhr)")||assetname.equals("Active Load (MW) - MF/2")||assetname.equals("Reactive Load (Mvar) - MF/2")||assetname.equals("Hourly Generation (MWhr)")||assetname.equals("MWhr (Cumulative)")||assetname.equals("MWhr (Cumulative)")||assetname.equals("MWhr (Cumulative)"))
				{
					s.selectByVisibleText("Check");
				}
				else if(assetname.equals("Generator (MWhr)")||assetname.equals("UAT #1 (MWhr)")||assetname.equals("UAT #2 (MWhr)")||assetname.equals("Active Load (MW) - MF/2")||assetname.equals("Reactive Load (Mvar) - MF/2")||assetname.equals("Hourly Generation (MWhr)")||assetname.equals("MWhr (Cumulative)")||assetname.equals("MWhr (Cumulative)")||assetname.equals("MWhr (Cumulative)"))
				{
					s.selectByVisibleText("Main");
				}
				else if(assetname.equals("PERAMBALUR")||assetname.equals("NLC")||assetname.equals("DEVIAKURICHI")||assetname.equals("CUDDALORE")||assetname.equals("PERAMBALUR")||assetname.equals("NLC")||assetname.equals("DEVIAKURICHI 123")||assetname.equals("CUDDALORE"))
				{
					s.selectByVisibleText("Check");
				}
				else if(assetname.equals("PERAMBALUR")||assetname.equals("NLC")||assetname.equals("DEVIAKURICHI")||assetname.equals("CUDDALORE")||assetname.equals("PERAMBALUR")||assetname.equals("NLC")||assetname.equals("DEVIAKURICHI")||assetname.equals("CUDDALORE"))
				{
					s.selectByVisibleText("Main");
				}
				else
				{
				
				s.selectByVisibleText("In Service");
				}
				
			}

			/* Displayed */	

			int columncount = displayed.size();

			for (WebElement disp : displayed) {
				boolean selected = disp.isSelected();
				if (selected) {
					disp.click();
				}
			}
			/* Enabled */			

			for (WebElement enbl : Enabled) {
				boolean selected = enbl.isSelected();
				if (selected) {
					enbl.click();
				}
			}
			/* Mandatory */
			
			for (WebElement Mandt : Mandatory) {
				boolean selected = Mandt.isSelected();
				if (selected) {
					Mandt.click();
				}
			}
			/* Min Value */
			
			for (WebElement Min : MinValue) {
//				Thread.sleep(3000);
				Min.clear();
				Min.sendKeys("250");
			}
			/* Max Value */
			
			for (WebElement Max : MaxValue) {
//				Thread.sleep(3000);
				Max.clear();
				Max.sendKeys("1000");
			}	
			}
	 
	 @Then("verify if assets for {string} for {string} are updated")
		public void verifyassetsUpdated(String tableno, String assetname)throws InterruptedException {
//			Thread.sleep(2000);
			List<WebElement> select = null;
			List<WebElement> displayed = null;
			List<WebElement> Enabled = null;
			List<WebElement> Mandatory = null;
			List<WebElement> MinValue = null;
			List<WebElement> MaxValue = null;
			switch(tableno){    
			//case statements within the switch block  
			case "Table 1":		
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				select = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//select"));
				displayed = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//td[@data-label='Display']"));
				Enabled = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//td[@data-label='Enabled']"));
				Mandatory = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//td[@data-label='Mandatory']"));
				MinValue = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//td[@data-label='Min Value']//input"));
				MaxValue = driver.findElements(By.xpath("//div[@id='faq_0_0']//tbody[@id='tableBody_0_0']//td[@data-label='Max Value']//input"));	
		    case "Table 2":		
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_1']//td[@data-label='Max Value']//input"));
		    case "Table 3":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_2']//td[@data-label='Max Value']//input"));		  
		    case "Table 4":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//td[@data-label='Max Value']//input"));
		    	break; 
		    case "Table 5":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//td[@data-label='Max Value']//input"));
		    	break; 
		    case "Table 6":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//td[@data-label='Max Value']//input"));
		    	break;    	
		    case "Table 7":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//td[@data-label='Max Value']//input"));
		    	break;
		    case "Table 8":	
//		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//td[@data-label='Max Value']//input"));
		    	break;    	
		   case "Table 9":
//			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 10":
//			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 11":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 12":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 13":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 14":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 15":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 16":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 17":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 18":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 19":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 20":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 21":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 22":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 23":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 24":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 25":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 26":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 27":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 28":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 29":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 30":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//td[@data-label='Max Value']//input"));
		       	break; 	
		   case "Table 31":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//td[@data-label='Max Value']//input"));
		    	
		    	break; 
case "Table 32":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 33":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 34":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 35":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 36":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 37":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 38":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 39":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 40":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 41":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 42":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 43":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 44":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 45":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 46":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 47":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 48":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 49":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 50":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 51":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 52":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 53":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 54":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 55":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 56":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//td[@data-label='Max Value']//input"));
		    	
		    	break; 	
case "Table 57":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//td[@data-label='Max Value']//input"));
		    	
		    	break; 
case "Table 58":
			   select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//select"));
		    	displayed = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//td[@data-label='Display']"));
		    	Enabled = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//td[@data-label='Enabled']"));
		    	Mandatory = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//td[@data-label='Mandatory']"));
		    	MinValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//td[@data-label='Min Value']//input"));
		    	MaxValue = driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//td[@data-label='Max Value']//input"));
		    	
		    	break; 				
		    default:
		    	System.out.println("No header validation");
		    	break;
			}
			
			for (WebElement sel : select) {
//				Thread.sleep(2000);
				Select s = new Select(sel);
				String strSelectedVal = s.getFirstSelectedOption().getText();
				if (strSelectedVal.equals("Active")){
					System.out.println("Selected Option is Active");
				}else if(strSelectedVal.equals("Check"))
				{
					System.out.println("Selected Option is Check");
				}
				else if(strSelectedVal.equals("Main"))
				{
					System.out.println("Selected Option is Main");
				}
				else {
					System.out.println("Selected Option is In-Active");
				}
			}

			/* Displayed */
			
			int columncount = displayed.size();
			for (WebElement disp : displayed) {
				boolean selected = disp.isEnabled();
				System.out.println(selected);
				if (selected) {
					System.out.println("displayed field is selected");
				}else {
					System.out.println("displayed field is not selected");
				}
			}
			/* Enabled */
			
			for (WebElement enbl : Enabled) {
				boolean enabled = enbl.isEnabled();
				System.out.println(enabled);
				if (enabled) {
					System.out.println("Enabled field is selected");
				}else {
					System.out.println("Enabled field is not selected");
				}
			}
			/* Mandatory */
			
			for (WebElement Mandt : Mandatory) {
				boolean mandatory = Mandt.isEnabled();
				if (mandatory) {
					System.out.println("Mandatory field is selected");
				}else {
					System.out.println("Mandatory field is not selected");
				}
			}
			/* Min Value */
			
			for (WebElement Min : MinValue) {
				String strMinVal = Min.getAttribute("value");
				System.out.println(strMinVal);
				Assert.assertEquals("250",strMinVal);
//				if (strMinVal.equals("250")) {
//					System.out.println("Min values is updated with the required value");
//				}else {
//					System.out.println("Min values is not updated with the required value");
//				}
			}
			/* Max Value */
			
			for (WebElement Max : MaxValue) {
				String strMaxVal = Max.getAttribute("value");
				System.out.println(strMaxVal);
				Assert.assertEquals("1000",strMaxVal);
//				if (strMaxVal.equals("1000")) {
//					System.out.println("Max values is updated with the required value");
//				}else {
//					System.out.println("Max values is not updated with the required value");
//				}	
			}
		} 
	 
	 @Then("Select {string} as Type")
		public void SelectType(String Type) throws InterruptedException{
//		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		 Thread.sleep(2000);
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		 List<WebElement> Typeselect =driver.findElements(By.xpath("//td[@data-label='Status']//select"));
		
//	System.out.println("Type----"+s);
//		 JavascriptExecutor js = (JavascriptExecutor)driver;
//		 js.executeScript("arguments[0].scrollIntoView();", Typeselect);
		 for (WebElement type : Typeselect) {
			 Select typeselect = new Select(type);
			 typeselect.selectByVisibleText(Type);
			
//			 System.out.println("Status"+selecttext);
			
		}
			
	 } 
}
