package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ExcelUtility;
import cucumber.api.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LogSheetValidations {

	public static Scenario scenario;
	WebDriver driver;
	String path="E:\\Scaffold\\Deepa\\scaffold-v2-test-automation\\scaffold-v2-test-automation\\TestData\\TestData.xlsx";
	ExcelUtility xlutility;
	
	

	public LogSheetValidations(CommonSteps commonsteps) {
		driver = commonsteps.getDriver();
	}

	@Then("Click on save button")
	public void click_on_save_button() {
		driver.findElement(By.xpath("//input[@id='unitSuccessBtn']")).click();
		try {
			WebElement timeleft = driver
					.findElement(By.xpath("(//div[@class='row m-0']//div[@class='col my-auto text-center']//div)[1]"));
			System.out.print("Time left" + timeleft.getText());
		} catch (Exception e) {
			WebElement Timeout = driver.findElement(By.xpath("//div[text()='Time out!']"));
			System.out.print("Time out!!!" + Timeout.getText());
		}
	}

	@Then("Click on {string}")
	public void ClickOnLogSheet(String string) {
		driver.findElement(By.linkText(string)).click();
	}
	
	@Then("Verify Logsheet page")
	public void VerifyLogsheetPage() throws InterruptedException {
		Thread.sleep(3000);
		String Logsheet = driver.findElement(By.xpath("//div[text()='Log Sheet']")).getText();

		Assert.assertEquals(Logsheet, "Log Sheet");
	}

	@Then("Select {string} Log Sheet")
	public void SelectLogSheet_Commen(String logsheet) throws InterruptedException {
		Select Lossheet = new Select(driver.findElement(By.id("LogSheets")));
		Lossheet.selectByVisibleText(logsheet);
	}
	
	@Then("Click on Save and Continue button")
	public void ClickonSaveandContinuebutton() {
		driver.findElement(By.xpath("//input[@id='Submit']")).click();

	}
	@Then("Select Log Sheet")
	public void SelectLogSheet() throws InterruptedException {
		Select Lossheet = new Select(driver.findElement(By.id("LogSheets")));
		Lossheet.selectByVisibleText("Water Steam Cycle Local Log");
	}
	 @Then("verify TableAsset {string} data is displayed in logsheet page")
		public void VerifyTableAsset(String Table) throws IOException {
		 String path="E:\\Scaffold\\Deepa\\scaffold-v2-test-automation\\scaffold-v2-test-automation\\TestData\\TestData.xlsx";
			ExcelUtility xlutility =new ExcelUtility(path);
			int row=xlutility.getRowCount("LogSheet");
			
			/*Table Headers*/
			xlutility.setCellData("LogSheet", 1, 0, "GaugeName");
			xlutility.setCellData("LogSheet", 1, 1, "Code");
			xlutility.setCellData("LogSheet", 1, 2, "Status");
			xlutility.setCellData("LogSheet", 1, 3, "Display");
			xlutility.setCellData("LogSheet", 1, 4, "Enabled");
			xlutility.setCellData("LogSheet", 1, 5, "Mandatory");
			xlutility.setCellData("LogSheet", 1, 6, "Min Value");
			xlutility.setCellData("LogSheet", 1, 7, "Max Value");			
			
			switch(Table){    
//		    case statements within the switch block  
		    case "Table 1":
		    	String Table1Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_0']")).getText();				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", 0, 0, Table1Title);
				
				/*Capture table rows*/
				WebElement Table1=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']"));
				int Table1rows=Table1.findElements(By.xpath("tr")).size();	
				
				for(int r=1;r<=Table1rows;r++)
				{
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", r+1, 0,Gaugename);
					xlutility.setCellData("LogSheet", r+1, 1,Code);
					xlutility.setCellData("LogSheet", r+1, 2,Status);
					xlutility.setCellData("LogSheet", r+1, 3,Display);
					xlutility.setCellData("LogSheet", r+1, 4,Enabled);
					xlutility.setCellData("LogSheet", r+1, 5,Mandatory);
					xlutility.setCellData("LogSheet", r+1, 6,MinValue);
					xlutility.setCellData("LogSheet", r+1, 7,MaxValue);
				}
			
		    	break;
		    case "Table 2":
		    	String Table2Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_1']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table2Title);
				
				/*Capture table rows*/
				WebElement Table2=driver.findElement(By.id("tableBody_0_1"));
				int Table2rows=Table2.findElements(By.xpath("tr")).size();
				int tableexcel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table2rows;r++)
				{
					int count1 = tableexcel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}
			
		    	break;
		    case "Table 3":
		    	String Table3Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_2']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table3Title);
				
				/*Capture table rows*/
				WebElement Table3=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']"));
				int Table3rows=Table3.findElements(By.xpath("tr")).size();
				int table3excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table3rows;r++)
				{
					int count1 = table3excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}
				
		    	break;
		    case "Table 4":
		    	String Table4Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_3']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table4Title);
				
				/*Capture table rows*/
				WebElement Table4=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr"));
				int Table4rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//tr")).size();
				int table4excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table4rows;r++)
				{
					int count1 = table4excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 5":
		    	String Table5Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_4']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table5Title);
				
				/*Capture table rows*/
				
				int Table5rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//tr")).size();
				int table5excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table5rows;r++)
				{
					int count1 = table5excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 6":
		    	String Table6Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_5']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table6Title);
				
				/*Capture table rows*/
				
				int Table6rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//tr")).size();
				int table6excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table6rows;r++)
				{
					int count1 = table6excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 7":
		    	String Table7Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_6']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table7Title);
				
				/*Capture table rows*/
				
				int Table7rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//tr")).size();
				int table7excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table7rows;r++)
				{
					int count1 = table7excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 8":
		    	String Table8Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_7']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table8Title);
				
				/*Capture table rows*/
				
				int Table8rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//tr")).size();
				int table8excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table8rows;r++)
				{
					int count1 = table8excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 9":
		    	String Table9Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_8']")).getText();				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table9Title);
				
				/*Capture table rows*/				
				int Table9rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//tr")).size();
				int table9excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table9rows;r++)
				{
					int count1 = table9excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 10":
		    	String Table10Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_9']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table10Title);
				
				/*Capture table rows*/
				
				int Table10rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//tr")).size();
				int table10excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table10rows;r++)
				{
					int count1 = table10excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}
		    	break;
		    case "Table 11":
		    	String Table11Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_10']")).getText();
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table11Title);
				
				/*Capture table rows*/				
				int Table11rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//tr")).size();
				int table11excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table11rows;r++)
				{
					int count1 = table11excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 12":
		    	String Table12Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_11']")).getText();				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table12Title);
				
				/*Capture table rows*/
				
				int Table12rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//tr")).size();
				int table12excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table12rows;r++)
				{
					int count1 = table12excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 13":
		    	String Table13Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_12']")).getText();
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table13Title);
				
				/*Capture table rows*/				
				int Table13rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//tr")).size();
				int table13excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table13rows;r++)
				{
					int count1 = table13excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 14":
		    	String Table14Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_13']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table14Title);
				
				/*Capture table rows*/				
				int Table14rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//tr")).size();
				int tabl14excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table14rows;r++)
				{
					int count1 = tabl14excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[3]")).getAttribute("Value");
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 15":
		    	String Table15Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_14']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData("LogSheet", row+1, 0, Table15Title);
				
				/*Capture table rows*/
				
				int Table15rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//tr")).size();
				int tabl15excel=xlutility.getRowCount("LogSheet");
				
				for(int r=1;r<=Table15rows;r++)
				{
					int count1 = tabl15excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData("LogSheet", count1, 0,Gaugename);
					xlutility.setCellData("LogSheet", count1, 1,Code);
					xlutility.setCellData("LogSheet", count1, 2,Status);
					xlutility.setCellData("LogSheet", count1, 3,Display);
					xlutility.setCellData("LogSheet", count1, 4,Enabled);
					xlutility.setCellData("LogSheet", count1, 5,Mandatory);
					xlutility.setCellData("LogSheet", count1, 6,MinValue);
					xlutility.setCellData("LogSheet", count1, 7,MaxValue);
				}				
		    	break;
			}
			
	 }
	 @Then("verify {string} Asset {string} is displayed on logsheet page and save in excel")
		public void VerifyAssetDisplayedOnLogSheetPage(String LogSheet, String Table) throws IOException {
		 String path="E:\\Master_Final\\scaffold-v2-test-automation\\TestData\\TestData.xlsx";
			ExcelUtility xlutility =new ExcelUtility(path);
			int row=xlutility.getRowCount(LogSheet);
			List<WebElement> select = null;
			
			/*Table Headers*/
			xlutility.setCellData(LogSheet, 1, 0, "GaugeName");
			xlutility.setCellData(LogSheet, 1, 1, "Code");
			xlutility.setCellData(LogSheet, 1, 2, "Status");
			xlutility.setCellData(LogSheet, 1, 3, "Display");
			xlutility.setCellData(LogSheet, 1, 4, "Enabled");
			xlutility.setCellData(LogSheet, 1, 5, "Mandatory");
			xlutility.setCellData(LogSheet, 1, 6, "Min Value");
			xlutility.setCellData(LogSheet, 1, 7, "Max Value");
			
			switch(Table){    
//		    case statements within the switch block  
		    case "Table 1":
		    	String Table1Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_0']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, 0, 0, Table1Title);
				
				/*Capture table rows*/
				WebElement Table1=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']"));
				select = driver.findElements(By.xpath("//tbody[@id='tableBody_0_0']//select"));
				
			int Table1rows=Table1.findElements(By.xpath("tr")).size();
				for(int r=1;r<=Table1rows;r++)
				{
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[2]")).getText();					
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[3]//select")).getAttribute("Value");
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_0']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, r+1, 0,Gaugename);
					xlutility.setCellData(LogSheet, r+1, 1,Code);
					xlutility.setCellData(LogSheet, r+1, 2,Status);
					xlutility.setCellData(LogSheet, r+1, 3,Display);
					xlutility.setCellData(LogSheet, r+1, 4,Enabled);
					xlutility.setCellData(LogSheet, r+1, 5,Mandatory);
					xlutility.setCellData(LogSheet, r+1, 6,MinValue);
					xlutility.setCellData(LogSheet, r+1, 7,MaxValue);
				}			
		    	break;
		    case "Table 2":
		    	String Table2Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_1']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table2Title);
				
				/*Capture table rows*/
				WebElement Table2=driver.findElement(By.id("tableBody_0_1"));
				int Table2rows=Table2.findElements(By.xpath("tr")).size();
				int tableexcel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table2rows;r++)
				{
					int count1 = tableexcel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_1']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
				}			
		    	break;
		    case "Table 3":
		    	String Table3Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_2']")).getText();
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table3Title);
				
				/*Capture table rows*/
				WebElement Table3=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']"));
				int Table3rows=Table3.findElements(By.xpath("tr")).size();
				int table3excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table3rows;r++)
				{
					int count1 = table3excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_2']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
				}				
		    	break;
		    case "Table 4":
		    	String Table4Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_3']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table4Title);
				
				/*Capture table rows*/
				WebElement Table4=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr"));
				int Table4rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_3']//tr")).size();
				int table4excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table4rows;r++)
				{
					int count1 = table4excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_3']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 5":
		    	String Table5Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_4']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table5Title);
				
				/*Capture table rows*/
				
				int Table5rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_4']//tr")).size();
				int table5excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table5rows;r++)
				{
					int count1 = table5excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_4']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 6":
		    	String Table6Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_5']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table6Title);
				
				/*Capture table rows*/
				
				int Table6rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_5']//tr")).size();
				int table6excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table6rows;r++)
				{
					int count1 = table6excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_5']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 7":
		    	String Table7Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_6']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table7Title);
				
				/*Capture table rows*/
				
				int Table7rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_6']//tr")).size();
				int table7excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table7rows;r++)
				{
					int count1 = table7excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_6']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 8":
		    	String Table8Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_7']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table8Title);
				
				/*Capture table rows*/
				
				int Table8rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_7']//tr")).size();
				int table8excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table8rows;r++)
				{
					int count1 = table8excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_7']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 9":
		    	String Table9Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_8']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table9Title);
				
				/*Capture table rows*/
				
				int Table9rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_8']//tr")).size();
				int table9excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table9rows;r++)
				{
					int count1 = table9excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_8']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 10":
		    	String Table10Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_9']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table10Title);
				
				/*Capture table rows*/
				
				int Table10rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_9']//tr")).size();
				int table10excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table10rows;r++)
				{
					int count1 = table10excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_9']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 11":
		    	String Table11Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_10']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table11Title);
				
				/*Capture table rows*/
				
				int Table11rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_10']//tr")).size();
				int table11excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table11rows;r++)
				{
					int count1 = table11excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_10']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 12":
		    	String Table12Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_11']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table12Title);
				
				/*Capture table rows*/
				
				int Table12rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_11']//tr")).size();
				int table12excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table12rows;r++)
				{
					int count1 = table12excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_11']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 13":
		    	String Table13Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_12']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table13Title);
				
				/*Capture table rows*/
				
				int Table13rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_12']//tr")).size();
				int table13excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table13rows;r++)
				{
					int count1 = table13excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_12']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 14":
		    	String Table14Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_13']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table14Title);
				
				/*Capture table rows*/
				
				int Table14rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_13']//tr")).size();
				int tabl14excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table14rows;r++)
				{
					int count1 = tabl14excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_13']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;
		    case "Table 15":
		    	String Table15Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_14']")).getText();
				
				
				/*Write Table Title*/
				xlutility.setCellData(LogSheet, row+1, 0, Table15Title);
				
				/*Capture table rows*/
				
				int Table15rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_14']//tr")).size();
				int tabl15excel=xlutility.getRowCount(LogSheet);
				
				for(int r=1;r<=Table15rows;r++)
				{
					int count1 = tabl15excel+r;
					System.out.println("count ---"+count1);	
					
					String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[1]")).getText();
					String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[2]")).getText();
					String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[3]")).getText();
					String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[4]//input")).getAttribute("Value");
					String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[5]//input")).getAttribute("Value");
					String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[6]//input")).getAttribute("Value");
					String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[7]//input")).getAttribute("Value");
					String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_14']//tr["+r+"]//td[8]//input")).getAttribute("Value");
					System.out.println(Gaugename+Code+Status+Display+Enabled+Mandatory+MinValue+MaxValue);
					
					/*Writing Asset On Excel Sheet*/
					xlutility.setCellData(LogSheet, count1, 0,Gaugename);
					xlutility.setCellData(LogSheet, count1, 1,Code);
					xlutility.setCellData(LogSheet, count1, 2,Status);
					xlutility.setCellData(LogSheet, count1, 3,Display);
					xlutility.setCellData(LogSheet, count1, 4,Enabled);
					xlutility.setCellData(LogSheet, count1, 5,Mandatory);
					xlutility.setCellData(LogSheet, count1, 6,MinValue);
					xlutility.setCellData(LogSheet, count1, 7,MaxValue);
					
				
				}
				
		    	break;


			}
			
	 }
	
			
			
	 
}
