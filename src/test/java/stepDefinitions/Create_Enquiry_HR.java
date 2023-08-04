package stepDefinitions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ExcelUtility;
import cucumber.api.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages.Meta.Product;

public class Create_Enquiry_HR implements Framework_constants {

	public static Scenario scenario;
	WebDriver driver;
	CommonSteps commonsteps;
	ExcelUtility xlutility;
	WebDriverWait wait;

	public Create_Enquiry_HR(CommonSteps commonsteps) {
		driver = commonsteps.getDriver();
	}

	@When("Login into Enquiry management system As {string}")
	public void LoginintoEnquirymanagementsystem(String user) throws InterruptedException {
		// Navigate to URL
//		Thread.sleep(2000);
//		System.out.println("Driver"+driver);
//		System.out.println("Step 1");
//		String envinronment=env;
//		CommonSteps.launchBrowser(envinronment);
//		System.out.println("Scenario"+scenario);
//		Thread.sleep(3000);
		switch (user) {
		// case statements within the switch block
		case "AE":

			driver.findElement(By.id("user-name")).sendKeys("ae.1@deliverain.com");
			driver.findElement(By.id("password")).sendKeys("welcome");
			driver.findElement(By.id("Submit")).click();
			System.out.println("Logged in");
			break;
		case "PDQC":
			driver.findElement(By.id("user-name")).sendKeys("pdqc.1@deliverain.com");
			driver.findElement(By.id("password")).sendKeys("welcome");
			driver.findElement(By.id("Submit")).click();
			System.out.println("Logged in");

			break;
		default:
			System.out.println("Login is not available");
		}

		System.out.println("Logged in");
		// scenario.write("Logged in");
//		CommonSteps.TakeScreenshot("LoginSucessful");
	}

	@Then("Click on create new enquiry")
	public void create_new_enquiry() {
		driver.findElement(By.xpath("//span[@class='add-new-btn']")).click();

//	    driver.findElement(By.xpath("//p[text()='HR']")).click();

	}

	@Then("Select Product or category {string}")
	public void select_product_or_category(String Product) {
		driver.findElement(By.xpath("//p[text()='" + Product + "']")).click();
	}

	@Then("Verify the Basic information page is displayed for {string}")
	public void verify_the_basic_information_page_is_displayed(String Product) {

		driver.findElement(By.xpath("//span[text()='" + Product + "']")).isDisplayed();

	}

	@Then("Verify the mandatory fields are present")
	public void verify_the_mandatory_fields_are_present() {
		WebElement Product = driver.findElement(By.xpath("(//div[@class='sd-dropdown__value'])[1]"));
		Product.isDisplayed();
		WebElement Customername = driver.findElement(By.xpath("(//div[@class='sd-dropdown__value'])[2]"));
		Customername.isDisplayed();
		WebElement Specification = driver.findElement(By.xpath("(//div[@class='sd-dropdown__value'])[3]"));
		Specification.isDisplayed();
		WebElement Supply_condition = driver.findElement(By.xpath("(//div[@class='sd-dropdown__value'])[4]"));
		Supply_condition.isDisplayed();
	}

	@Then("Verify the Product dropdown values")
	public void verify_the_product_dropdown_values() {
		driver.findElement(By.xpath("(//div[@class='sd-dropdown__value'])[1]")).click();
		List<WebElement> products = driver.findElements(
				By.xpath("//div[@class='sv-list__item-body sd-list__item-body']//span[contains(text(),'HR')]"));
		for (WebElement product : products) {
			String pro = product.getText();
			System.out.println(pro);
		}

	}

	@Then("Select the product")
	public void select_the_product() {
//		WebElement Product_dropdown = driver.findElement(By.xpath("(//div[@class='sd-dropdown__value'])[1]"));
//		Product_dropdown.click();
		List<WebElement> Products = driver
				.findElements(By.xpath("(//div[@class='sv-list__container sd-list'])[1]//ul//li//div//span"));
		System.out.println(Products.size());

		for (WebElement Product : Products) {
			String Productname = Product.getText();
//			System.out.println(Productname);
			if (Productname.contains("HRCF")) {
				Product.click();
			}
		}

	}

	@Then("Select the customer name")
	public void verify_the_customer_names() throws InterruptedException {

		Thread.sleep(3000);
		WebElement Customername_dropdown = driver.findElement(By.xpath("(//div[@class='sd-dropdown__value'])[2]"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Customername_dropdown));
		Customername_dropdown.click();
		List<WebElement> Products = driver
				.findElements(By.xpath("(//div[@class='sv-list__container sd-list'])[2]//ul//li//div//span"));
		System.out.println(Products.size());

		for (WebElement Product : Products) {
			String Productname = Product.getText();
//			System.out.println(Productname);
			if (Productname.contains("JSW - MTS")) {
				Product.click();
			}
		}

	}

	@Then("Select the specification")
	public void Select_the_specification() throws InterruptedException {

		Thread.sleep(3000);
		WebElement Specification_dropdown = driver.findElement(By.xpath("(//div[@class='sd-dropdown__value'])[3]"));
		 wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Specification_dropdown));
		Specification_dropdown.click();
		List<WebElement> Specifications = driver
				.findElements(By.xpath("(//div[@class='sv-list__container sd-list'])[3]//ul//li//div//span"));
		System.out.println(Specifications.size());

		for (WebElement Specification : Specifications) {
			String Specificationtype = Specification.getText();
//			System.out.println(Specifications);
			if (Specificationtype.contains("API 5L_PSL1_44E_WP A25")) {
				Specification.click();
			}
		}

	}
	
	@Then("Select the supply condition")
	public void Select_the_supply_condition() throws InterruptedException {

		Thread.sleep(3000);
		WebElement Supplycondition_dropdown = driver.findElement(By.xpath("(//div[@class='sd-dropdown__value'])[4]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Supplycondition_dropdown));
		Supplycondition_dropdown.click();
		List<WebElement> Supplyconditions = driver
				.findElements(By.xpath("(//div[@class='sv-list__container sd-list'])[4]//ul//li//div//span"));
		System.out.println(Supplyconditions.size());

		for (WebElement Supplycondition : Supplyconditions) {
			String Supplyconditiontxt = Supplycondition.getText();
			System.out.println(Supplyconditiontxt);
			if (Supplyconditiontxt.contains("As rolled, mill edge, unpickled, unoiled")) {
				Supplycondition.click();
			}
		}

	}
	
	@When("Click on next button")
	public void Click_on_next_button() throws InterruptedException {
		
		WebElement Next = driver.findElement(By.xpath("//div[@id='sv-nav-next']"));
		wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(Next)).click();
	
	}


	@And("Enter the basic infrormation {string}")
	public void enter_the_basic_information(String sheetname) throws IOException {
//		String path = "./TestData/TestData.xlsx";
		xlutility = new ExcelUtility(path);
		int row = xlutility.getRowCount(sheetname);

		/* Table Values */


		String Enduser_data = xlutility.getCellData(sheetname, 1, 1);
		String Components_data = xlutility.getCellData(sheetname, 2, 1);
		String Customername_data = xlutility.getCellData(sheetname, 3, 1);
		System.out.println(Enduser_data + "" + Components_data + "" + Customername_data);

		driver.findElement(By.xpath("//input[@aria-label='End user']")).sendKeys(Enduser_data);
		driver.findElement(By.xpath("//input[@aria-label='Components']")).sendKeys(Components_data);
		driver.findElement(By.xpath("//input[@aria-label='End Application']")).sendKeys(Customername_data);
	}
	
	@Then("Select the material delivery time")
	public void Select_the_material_delivery_time() throws InterruptedException {

		Thread.sleep(3000);
		WebElement Materialdeliverytime = driver.findElement(By.xpath("//div[@class='sd-question__content']//input[@class='form-control widget-datepicker sd-input sd-text hasDatepicker']"));
//		Materialdeliverytime.click();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		Date today = Calendar.getInstance().getTime();
		String date = dateFormat.format(today);
		
	     System.out.println("Current time of the day: " + date);
	     Materialdeliverytime.sendKeys(date);
		

	}
	
	@When("Verify the {string} page is displayed")
	public void verify_the_order_details_page_is_displayed(String Pagetitle) {
//		driver.findElement(By.xpath("//div[@class='sd-page sd-body__page']//div//span[@class='sv-string-viewer' and text()='Order Details']")).isDisplayed();
		driver.findElement(By.xpath("//div[@class='sd-page sd-body__page']//div//span[@class='sv-string-viewer' and text()='"+Pagetitle+"']")).isDisplayed();
	}
	
	@Then("Enter the order details {string}")
	public void enter_the_order_details(String sheetname) throws IOException {
	    WebElement Quantity = driver.findElement(By.xpath("//input[@aria-label='Quantity']"));
	     List<WebElement> Dimensions = driver.findElements(By.xpath("//div[@class='sd-table-wrapper']//tr//td[2]//input"));
	    List<WebElement> Tolerance = driver.findElements(By.xpath("//div[@class='sd-table-wrapper']//tr//td[3]//input"));
	    
	   
		int row = xlutility.getRowCount(sheetname);
		String Quantity_data = xlutility.getCellData(sheetname, 4, 0);
		String Thickness_Dimension_data =xlutility.getCellData(sheetname, 5, 1);
		String Width_Dimension_data = xlutility.getCellData(sheetname, 6, 0);
		String Thickness_Tolerance_data =xlutility.getCellData(sheetname, 7, 1);
		String Width_Tolerance_data = xlutility.getCellData(sheetname, 8, 0);
		
		
		
		System.out.println(Quantity_data+""+Thickness_Dimension_data+""+Width_Dimension_data+""+Thickness_Tolerance_data+""+Width_Tolerance_data);
		Quantity.sendKeys(Quantity_data);
		
		for(WebElement dimansion:Dimensions)
		{
			dimansion.sendKeys(Thickness_Dimension_data);
		}
		for(WebElement tolerance:Tolerance)
		{
			tolerance.sendKeys(Thickness_Tolerance_data);
		}	    
	}
	
	@When("Select the Application of material checkbox")
	public void Select_th_Application_of_material_checkbox() {
		
		 List<WebElement> checkboxs = driver.findElements(By.xpath("//span[@class='sd-item__decorator sd-checkbox__decorator']"));
		
		 for(WebElement Checkbox:checkboxs)
		 {
			 Checkbox.click();
		}
		
	}
	@Then("Enter the process flow at customer end from {string}")
	public void Enter_the_process_flow_at_customer_end(String sheetname) throws IOException {
		
		 WebElement processflow = driver.findElement(By.xpath("//textarea[@class='sd-input sd-comment']"));
	
		 
		 String customer_processflow = xlutility.getCellData(sheetname, 9, 1);
		 processflow.sendKeys(customer_processflow);
	}
	
	@Then("Select the Chemical Composition from {string}")
	public void Select_the_Chemical_Composition_from(String sheetname) throws IOException, InterruptedException {
		
	
		driver.findElement(By.xpath("//span[@role='combobox']")).click();
		List<WebElement> Chemical_compositions = driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
		 
		int count = Chemical_compositions.size();
		for(int i=0;i<1;i++)
		{
			WebElement ele1 = Chemical_compositions.get(i);
			ele1.click();
		}

		  wait=new WebDriverWait(driver, 40);
//		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='sd-action']")))).click();
		 WebElement Assetproperty = driver.findElement(By.xpath("//button[@class='sd-action']"));
		 wait.until(ExpectedConditions.elementToBeClickable(Assetproperty));
		 Assetproperty.click();
		 Thread.sleep(3000); 
		 List<WebElement> customer_min = driver.findElements(By.xpath("//div[@class='sd-table-wrapper']//tr//td[2]//input"));
		 List<WebElement> customer_max = driver.findElements(By.xpath("//div[@class='sd-table-wrapper']//tr//td[3]//input"));
//		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) customer_min));
//		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) customer_max));
		Thread.sleep(3000); 
		 String customer_mindata = xlutility.getCellData(sheetname, 10, 1);
		 String customer_maxdata = xlutility.getCellData(sheetname, 11, 1);
		 
		 for(WebElement customermin:customer_min)
			{
			 customermin.sendKeys(customer_mindata);
			}
			for(WebElement customermax:customer_max)
			{
				customermax.sendKeys(customer_maxdata);
			}	    
		
		
		 
	}
	
	@Then("Select the Mechanical Properties from {string}")
	public void Select_the_Mechanical_Properties_from(String sheetname) throws IOException, InterruptedException {
		
/*		driver.findElement(By.xpath("//span[@role='combobox']")).click();
		 WebElement Mechanical_Properties = driver.findElement(By.xpath("//div[@class='sd-question__content']//select"));
		 Select s = new Select(Mechanical_Properties);
		 s.isMultiple();
		 s.selectByIndex(1);
		 s.selectByIndex(2);
//		 List<WebElement> options = s.getOptions();
	//	 for(WebElement option:options)
//		 {
//			 option.click();
			 
//		 }
		 System.out.println("select is multi select");
//		 s.selectByValue("selectall");
 * 
 * */
 
		driver.findElement(By.xpath("//span[@role='combobox']")).click();
		List<WebElement> Mechanical_Properties = driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
		 
		int count = Mechanical_Properties.size();
		for(int i=0;i<1;i++)
		{
			WebElement ele2 = Mechanical_Properties.get(i);
			ele2.click();
		}
		 
		 wait=new WebDriverWait(driver, 40);
//		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='sd-action']")))).click();
		 WebElement Assetproperty = driver.findElement(By.xpath("//button[@class='sd-action']"));
		 wait.until(ExpectedConditions.elementToBeClickable(Assetproperty));
		 Assetproperty.click();
		 Thread.sleep(3000); 
		 List<WebElement> customer_min = driver.findElements(By.xpath("//div[@class='sd-table-wrapper']//tr//td[2]//input"));
		 List<WebElement> customer_max = driver.findElements(By.xpath("//div[@class='sd-table-wrapper']//tr//td[3]//input"));
//		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) customer_min));
//		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) customer_max));
		Thread.sleep(3000); 
		 String customer_mindata = xlutility.getCellData(sheetname, 10, 1);
		 String customer_maxdata = xlutility.getCellData(sheetname, 11, 1);
		 
		 for(WebElement customermin:customer_min)
			{
			 customermin.sendKeys(customer_mindata);
			}
			for(WebElement customermax:customer_max)
			{
				customermax.sendKeys(customer_maxdata);
			}	    	 
	}
	@Then("Upload the image for the additional requirements")
	public void Upload_the_image_for_the_additional_requirements() throws IOException {
		
		wait=new WebDriverWait(driver,15,1000);
		WebElement uploadimage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@aria-label='Choose file']//span")));
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.visibility='visible'", uploadimage);		
		
		uploadimage.sendKeys("./uploads/mb.jpg");
		System.out.println("image uploaded");
	}
	@Then("Enter the user comments from {string}")
	public void Enter_the_user_comments(String sheetname) throws IOException {
		
		wait=new WebDriverWait(driver, 40);
		WebElement comments = wait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("//textarea[@class='sd-input sd-comment']")));
		 
		String usercomment = xlutility.getCellData(sheetname, 12, 1);
		
		
	}
	
	@Then("Click on submit button")
	public void Click_on_submit_button() throws IOException {
		
		wait=new WebDriverWait(driver, 40);
		WebElement submit = wait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("//input[@title='Submit']")));
		submit.click();
		
		
		
	}

}
