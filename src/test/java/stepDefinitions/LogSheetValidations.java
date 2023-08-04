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
	public void ClickonSaveandContinuebutton() throws Exception {
		WebElement save=driver.findElement(By.xpath("//input[@id='Submit']"));
		save.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Submit']")));

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
		String path="C:\\Users\\Admin\\Downloads\\Older\\scaffold-v2-test-automation\\scaffold-v2-test-automation\\scaffold-v2-test-automation\\TestData\\TestData.xlsx";
		ExcelUtility xlutility =new ExcelUtility(path);
		int row=xlutility.getRowCount(LogSheet);

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
		case "Table 16":
			String Table16Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_15']")).getText();


			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table16Title);

			/*Capture table rows*/

			int Table16rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_15']//tr")).size();
			int tabl16excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table16rows;r++)
			{
				int count1 = tabl16excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_15']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_15']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_15']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_15']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_15']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_15']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_15']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_15']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
		case "Table 17":
			String Table17Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_16']")).getText();


			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table17Title);

			/*Capture table rows*/

			int Table17rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_16']//tr")).size();
			int tabl17excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table17rows;r++)
			{
				int count1 = tabl17excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_16']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_16']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_16']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_16']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_16']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_16']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_16']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_16']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
		case "Table 18":
			String Table18Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_17']")).getText();


			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table18Title);

			/*Capture table rows*/

			int Table18rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_17']//tr")).size();
			int tabl18excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table18rows;r++)
			{
				int count1 = tabl18excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_17']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_17']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_17']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_17']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_17']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_17']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_17']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_17']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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

		case "Table 19":
			String Table19Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_18']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table19Title);

			/*Capture table rows*/

			int Table19rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_18']//tr")).size();
			int tabl19excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table19rows;r++)
			{
				int count1 = tabl19excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_18']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_18']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_18']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_18']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_18']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_18']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_18']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_18']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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

		case "Table 20":
			String Table20Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_19']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table20Title);

			/*Capture table rows*/
			int Table20rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_19']//tr")).size();
			int tabl20excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table20rows;r++)
			{
				int count1 = tabl20excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_19']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_19']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_19']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_19']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_19']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_19']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_19']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_19']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
		case "Table 21":
			String Table21Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_20']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table21Title);

			/*Capture table rows*/
			int Table21rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_20']//tr")).size();
			int tabl21excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table21rows;r++)
			{
				int count1 = tabl21excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_20']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_20']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_20']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_20']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_20']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_20']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_20']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_20']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
		case "Table 22":
			String Table22Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_21']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table22Title);

			/*Capture table rows*/
			int Table22rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_21']//tr")).size();
			int tabl22excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table22rows;r++)
			{
				int count1 = tabl22excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_21']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_21']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_21']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_21']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_21']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_21']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_21']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_21']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
		case "Table 23":
			String Table23Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_22']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table23Title);

			/*Capture table rows*/

			int Table23rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_22']//tr")).size();
			int tabl23excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table23rows;r++)
			{
				int count1 = tabl23excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_22']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_22']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_22']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_22']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_22']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_22']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_22']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_22']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
		case "Table 24":
			String Table24Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_23']")).getText();


			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table24Title);

			/*Capture table rows*/
			int Table24rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_23']//tr")).size();
			int tabl24excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table24rows;r++)
			{
				int count1 = tabl24excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_23']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_23']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_23']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_23']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_23']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_23']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_23']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_23']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
		case "Table 25":
			String Table25Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_24']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table25Title);

			/*Capture table rows*/
			int Table25rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_24']//tr")).size();
			int tabl25excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table25rows;r++)
			{
				int count1 = tabl25excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_24']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_24']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_24']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_24']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_24']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_24']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_24']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_24']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
		case "Table 26":
			String Table26Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_25']")).getText();
			
			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table26Title);

			/*Capture table rows*/
			int Table26rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_25']//tr")).size();
			int tabl26excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table26rows;r++)
			{
				int count1 = tabl26excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_25']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_25']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_25']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_25']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_25']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_25']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_25']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_25']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
		case "Table 27":
			String Table27Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_26']")).getText();


			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table27Title);

			/*Capture table rows*/
			int Table27rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_26']//tr")).size();
			int tabl27excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table27rows;r++)
			{
				int count1 = tabl27excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_26']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_26']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_26']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_26']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_26']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_26']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_26']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_26']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
		case "Table 28":
			String Table28Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_27']")).getText();
			
			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table28Title);

			/*Capture table rows*/
			int Table28rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_27']//tr")).size();
			int tabl28excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table28rows;r++)
			{
				int count1 = tabl28excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_27']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_27']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_27']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_27']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_27']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_27']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_27']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_27']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
		case "Table 29":
			String Table29Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_28']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table29Title);

			/*Capture table rows*/
			int Table29rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_28']//tr")).size();
			int tabl29excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table29rows;r++)
			{
				int count1 = tabl29excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_28']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_28']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_28']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_28']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_28']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_28']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_28']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_28']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
		case "Table 30":
			String Table30Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_29']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table30Title);

			/*Capture table rows*/

			int Table30rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_29']//tr")).size();
			int tabl30excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table30rows;r++)
			{
				int count1 = tabl30excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_29']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_29']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_29']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_29']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_29']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_29']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_29']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_29']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
		case "Table 31":
			String Table31Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_30']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table31Title);

			/*Capture table rows*/

			int Table31rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_30']//tr")).size();
			int tabl31excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table31rows;r++)
			{
				int count1 = tabl31excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_30']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_30']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_30']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_30']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_30']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_30']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_30']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_30']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
			
case "Table 32":
			String Table32Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_31']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table32Title);

			/*Capture table rows*/

			int Table32rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_31']//tr")).size();
			int tabl32excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table32rows;r++)
			{
				int count1 = tabl32excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_31']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_31']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_31']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_31']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_31']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_31']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_31']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_31']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 33":
			String Table33Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_32']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table33Title);

			/*Capture table rows*/

			int Table33rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_32']//tr")).size();
			int tabl33excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table33rows;r++)
			{
				int count1 = tabl33excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_32']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_32']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_32']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_32']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_32']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_32']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_32']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_32']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 34":
			String Table34Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_33']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table34Title);

			/*Capture table rows*/

			int Table34rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_33']//tr")).size();
			int tabl34excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table34rows;r++)
			{
				int count1 = tabl34excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_33']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_33']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_33']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_33']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_33']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_33']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_33']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_33']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 35":
			String Table35Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_34']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table35Title);

			/*Capture table rows*/

			int Table35rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_34']//tr")).size();
			int tabl35excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table35rows;r++)
			{
				int count1 = tabl35excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_34']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_34']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_34']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_34']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_34']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_34']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_34']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_34']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 36":
			String Table36Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_35']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table36Title);

			/*Capture table rows*/

			int Table36rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_35']//tr")).size();
			int tabl36excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table36rows;r++)
			{
				int count1 = tabl36excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_35']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_35']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_35']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_35']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_35']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_35']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_35']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_35']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 37":
			String Table37Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_36']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table37Title);

			/*Capture table rows*/

			int Table37rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_36']//tr")).size();
			int tabl37excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table37rows;r++)
			{
				int count1 = tabl37excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_36']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_36']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_36']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_36']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_36']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_36']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_36']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_36']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 38":
			String Table38Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_37']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table38Title);

			/*Capture table rows*/

			int Table38rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_37']//tr")).size();
			int tabl38excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table38rows;r++)
			{
				int count1 = tabl38excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_37']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_37']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_37']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_37']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_37']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_37']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_37']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_37']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 39":
			String Table39Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_38']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table39Title);

			/*Capture table rows*/

			int Table39rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_38']//tr")).size();
			int tabl39excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table39rows;r++)
			{
				int count1 = tabl39excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_38']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_38']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_38']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_38']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_39']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_38']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_38']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_38']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 40":
			String Table40Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_39']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table40Title);

			/*Capture table rows*/

			int Table40rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_39']//tr")).size();
			int tabl40excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table40rows;r++)
			{
				int count1 = tabl40excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_39']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_39']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_39']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_39']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_39']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_39']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_39']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_39']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 41":
			String Table41Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_40']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table41Title);

			/*Capture table rows*/

			int Table41rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_40']//tr")).size();
			int tabl41excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table41rows;r++)
			{
				int count1 = tabl41excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_40']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_40']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_40']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_40']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_40']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_40']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_40']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_40']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 42":
			String Table42Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_41']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table42Title);

			/*Capture table rows*/

			int Table42rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_41']//tr")).size();
			int tabl42excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table42rows;r++)
			{
				int count1 = tabl42excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_41']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_41']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_41']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_41']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_41']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_41']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_41']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_41']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 43":
			String Table43Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_42']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table43Title);

			/*Capture table rows*/

			int Table43rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_42']//tr")).size();
			int tabl43excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table43rows;r++)
			{
				int count1 = tabl43excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_42']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_42']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_42']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_42']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_42']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_42']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_42']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_42']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 44":
			String Table44Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_43']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table44Title);

			/*Capture table rows*/

			int Table44rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_43']//tr")).size();
			int tabl44excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table44rows;r++)
			{
				int count1 = tabl44excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_43']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_43']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_43']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_43']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_43']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_43']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_43']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_43']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 45":
			String Table45Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_44']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table45Title);

			/*Capture table rows*/

			int Table45rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_44']//tr")).size();
			int tabl45excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table45rows;r++)
			{
				int count1 = tabl45excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_44']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_44']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_44']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_44']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_44']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_44']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_44']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_44']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 46":
			String Table46Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_45']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table46Title);

			/*Capture table rows*/

			int Table46rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_45']//tr")).size();
			int tabl46excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table46rows;r++)
			{
				int count1 = tabl46excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_45']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_45']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_45']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_45']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_45']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_45']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_45']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_45']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 47":
			String Table47Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_46']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table47Title);

			/*Capture table rows*/

			int Table47rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_46']//tr")).size();
			int tabl47excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table47rows;r++)
			{
				int count1 = tabl47excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_46']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_46']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_46']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_46']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_46']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_46']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_46']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_46']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 48":
			String Table48Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_47']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table48Title);

			/*Capture table rows*/

			int Table48rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_47']//tr")).size();
			int tabl48excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table48rows;r++)
			{
				int count1 = tabl48excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_47']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_47']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_47']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_47']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_47']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_47']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_47']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_47']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 49":
			String Table49Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_48']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table49Title);

			/*Capture table rows*/

			int Table49rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_48']//tr")).size();
			int tabl49excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table49rows;r++)
			{
				int count1 = tabl49excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_48']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_48']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_48']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_48']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_48']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_48']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_48']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_48']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 50":
			String Table50Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_49']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table50Title);

			/*Capture table rows*/

			int Table50rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_49']//tr")).size();
			int tabl50excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table50rows;r++)
			{
				int count1 = tabl50excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_49']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_49']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_49']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_49']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_49']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_49']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_49']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_49']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 51":
			String Table51Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_50']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table51Title);

			/*Capture table rows*/

			int Table51rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_50']//tr")).size();
			int tabl51excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table51rows;r++)
			{
				int count1 = tabl51excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_50']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_50']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_50']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_50']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_50']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_50']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_50']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_50']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 52":
			String Table52Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_51']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table52Title);

			/*Capture table rows*/

			int Table52rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_51']//tr")).size();
			int tabl52excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table52rows;r++)
			{
				int count1 = tabl52excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_51']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_51']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_51']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_51']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_51']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_51']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_51']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_51']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 53":
			String Table53Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_52']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table53Title);

			/*Capture table rows*/

			int Table53rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_52']//tr")).size();
			int tabl53excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table53rows;r++)
			{
				int count1 = tabl53excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_52']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_52']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_52']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_52']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_52']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_52']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_52']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_52']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 54":
			String Table54Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_53']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table54Title);

			/*Capture table rows*/

			int Table54rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_53']//tr")).size();
			int tabl54excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table54rows;r++)
			{
				int count1 = tabl54excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_53']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_53']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_53']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_53']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_53']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_53']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_53']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_53']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 55":
			String Table55Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_54']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table55Title);

			/*Capture table rows*/

			int Table55rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_54']//tr")).size();
			int tabl55excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table55rows;r++)
			{
				int count1 = tabl55excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_54']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_54']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_54']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_54']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_54']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_54']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_54']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_54']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 56":
			String Table56Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_55']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table56Title);

			/*Capture table rows*/

			int Table56rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_55']//tr")).size();
			int tabl56excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table56rows;r++)
			{
				int count1 = tabl56excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_55']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_55']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_55']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_55']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_55']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_55']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_55']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_55']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 57":
			String Table57Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_56']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table57Title);

			/*Capture table rows*/

			int Table57rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_56']//tr")).size();
			int tabl57excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table57rows;r++)
			{
				int count1 = tabl57excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_56']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_56']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_56']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_56']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_56']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_56']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_56']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_56']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
case "Table 58":
			String Table58Title=driver.findElement(By.xpath("//div[@id='assetgroup_name_0_57']")).getText();

			/*Write Table Title*/
			xlutility.setCellData(LogSheet, row+1, 0, Table58Title);

			/*Capture table rows*/

			int Table58rows=driver.findElements(By.xpath("//tbody[@id='tableBody_0_57']//tr")).size();
			int tabl58excel=xlutility.getRowCount(LogSheet);

			for(int r=1;r<=Table58rows;r++)
			{
				int count1 = tabl58excel+r;
				System.out.println("count ---"+count1);	

				String Gaugename=driver.findElement(By.xpath("//tbody[@id='tableBody_0_57']//tr["+r+"]//td[1]")).getText();
				String Code=driver.findElement(By.xpath("//tbody[@id='tableBody_0_57']//tr["+r+"]//td[2]")).getText();
				String Status=driver.findElement(By.xpath("//tbody[@id='tableBody_0_57']//tr["+r+"]//td[3]")).getText();
				String Display=driver.findElement(By.xpath("//tbody[@id='tableBody_0_57']//tr["+r+"]//td[4]//input")).getAttribute("Value");
				String Enabled=driver.findElement(By.xpath("//tbody[@id='tableBody_0_57']//tr["+r+"]//td[5]//input")).getAttribute("Value");
				String Mandatory=driver.findElement(By.xpath("//tbody[@id='tableBody_0_57']//tr["+r+"]//td[6]//input")).getAttribute("Value");
				String MinValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_57']//tr["+r+"]//td[7]//input")).getAttribute("Value");
				String MaxValue=driver.findElement(By.xpath("//tbody[@id='tableBody_0_57']//tr["+r+"]//td[8]//input")).getAttribute("Value");
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
