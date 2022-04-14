package testObjects;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GlobalObjects {
	
	//#Login section
	
	public static String URL = "https://scaffold-dev.deliverain.io:5000/Login";

	public static  By landingPageLogo = By.id("searchFocus");
	public static  By userName = By.id("password");
	public static  By password = By.id("Submit");
	public static  By LoginLink = By.id("AccountLogin");
	public static  By ModalUserName = By.id("hdrUsername");
	public static By RegisterButton = By.id("userRegisterButton");
	public static By LoginUserName = By.id("username");
	public static By LinkForgotUsername = By.linkText("Forgot Username?");
	public static By LoginPassword =By.id("password");
	public static By LoginSubmitt=By.id("userLoginButton");
	public static By LogOut=By.id("logoffLink");
	public static By LinkForgotPassword = By.linkText("Forgot Password?");
	public static By BlankPasswordError = By.className("form_err_wrapper belongsTo_isRequired belongsTo_password primaryErr");
	public static By BlankUsernameError = By.className("form_err_wrapper belongsTo_isRequired belongsTo_username primaryErr");
	
	
	
	//public static WebElement  MyAccountDropDown=(WebElement) By.linkText("My Account");
	
	//MyProfilePage WebElement
	public static By AccountLoginLink=By.id("AccountLogin");
	public static By MyProfileLink=By.linkText("My Profile");
	public static By MyProfileEmail=By.linkText("Email Address");
	public static By MyProfilePasswordLink=By.linkText("Password");
	public static By MyProfileInterestLink=By.linkText("Interests");
	public static By RegistationLink=By.linkText("register");
	public static String Fname="Rabi";
	public static String LName="Ranjan";
	public static String UserEmailId="kodhandd@mscdirect.com";
	public static String UserEmailId2="rabi_chakrabartty@mscdirect.com";
	
	//My Profile
	public static By MyProfileFname=By.id("FirstName");
	public static By MyProfileLname=By.id("LastName");
	public static String MyProfileFnamevalue="ECom_Automation";
	public static String MyProfileLnamevalue="ECom_Automation";
	public static String BlankValueTest="";
	
	public static By MyProfilePhoneareaCode=By.id("areaCode");
	public static By MyProfilePhoneprefix=By.id("prefix");
	public static By MyProfilePhonesuffix=By.id("suffix");
	public static By MyProfilePhoneextension=By.id("extension");
	public static String MyProfilePhoneareaCodevalue="234";
	public static String MyProfilePhoneprefixvalue="234";
	public static String MyProfilePhonesuffixvalue="2342";
	public static String MyProfilePhoneextensionvalue="2342";
	
	public static By MyProfileFaxareaCode1=By.id("areaCode1");
	public static By MyProfileFaxprefix1=By.id("prefix1");
	public static By MyProfileFaxsuffix1=By.id("suffix1");
	public static String MyProfileFaxareaCode1value="234";
	public static String MyProfileFaxprefix1value="234";
	public static String MyProfileFaxsuffix1value="2342";
	public static By  MyProfileUpdate=By.id("registerForm_b1");
	
	//Change Email Address Part
	public static By CurrentEmailAddresXpath=By.xpath(".//*[@id='changeEmailForm']/div/fieldset/table/tbody/tr[1]/td[2]/div");
	public static By NewEmailAddresId=By.id("NewEmail");
	public static int ExpectedSizeOfNewEmailAddres=150;
	public static By ConfirmEmailAddress=By.id("ConfirmEmail");
	public static String UpdateEmailButtonName="UPDATE MY E-MAIL ADDRESS";
	
	public static By UpdateemailFormButton=By.id("emailForm_b1");
	public static By UpdateemailFormButtonXpath=By.id(".//*[@id='emailForm_b1']");
	
	//Change Password Part
	public static By CurrentPassword=By.xpath(".//*[@id='CurrentPass']");
	public static By NewPassword=By.xpath(".//*[@id='NewPass']");
	public static By ConfirmNewPassword=By.xpath(".//*[@id='ConfirmPass']");
	
	public static String EnterNewPassword="abcefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static String EnterCurrentPassword="test123";
	public static By TooltipXpath=By.xpath(".//*[@id='changePasswordForm']/div/fieldset/div[2]/a");
	public static By UpdatePasswordButton=By.id("password_b1");
	
	//Change User Name Part
	public static String UsernameAreaName="Change Username";
	public static By UsernameFieldXpath=By.xpath(".//*[@id='username']");
	public static By UserNameUpdateButtonXpath=By.xpath(".//*[@id='changeUserNameButton']");	
	public static By DropDownListXpath=By.xpath(".//*[@id='InterestsForm']/div/div[1]/div/div/select");
	public static String ToolTipMessage="Password is case-sensitive, must be at least 7 characters, and must include at least 1 number and 1 letter.";
	public static By PurchaseFunction=By.xpath("//*[@id='PURCHASINGFUNCTIONS']/div");
	public static By ProductIterests=By.xpath("//*[@id='CATEGORYINTERESTS']/div[]/input");	
	public static By UpdateInterstButton=By.xpath(".//*[@id='editProfileUpdateButton']");	
	public static By TextBoxXpath=By.xpath("//*[@id='PURCHASINGFUNCTIONS']/div[5]/input[2]");
	public static By UpdateButtonForInterestsSection=By.xpath(".//*[@id='editProfileUpdateButton']");
	public static String CompanyName="ECom_Automation ECom_Automation";
	public static String RegisterUserName="ECom_Automation2";
	public static String RegisterUserName1="ECom_Automation1";
	public static String RegisterPassword="test123";
	
	//Login Page fields
	public static By UsernameFirstName = By.id("Firstname");
	public static By UsernameLastName= By.id("Lastname");
	public static By UsernameEmail= By.id("Email");
	public static By PasswordEmail = By.id("email1");
	public static By UserNameSubmit = By.id("submitButton");
	public static By UserNameClear = By.xpath("//*[@id='ForgotUsernameForm']/div/button[1]");
	public static By ForgotPswdUsername = By.id("Username");
	public static By PasswordSubmit = By.xpath("//*[@id='passwordForm']/div/div/button[2]/span");
	public static By PasswordClear = By.xpath("//*[@id='passwordForm']/div/div/button[1]/span");
	public static By HeaderLoginSubmitt = By.id("hdrInSearchGoButton");
	public static By HeaderLoginPassword = By.xpath(".//*[@id='userLogonForm']/div[3]/input[2]");
	public static By HeaderLoginUserName = By.xpath(".//*[@id='hdrUsername']");
	
	//Register Page fields
	public static By RegisterLink = By.xpath("//*[@id='utilityNav']/li[7]/a");
	public static By RegisterHelpLink = By.linkText("Where can I find this?");
	public static By RegisterAccountYes = By.id("yes");
	public static By RegisterAccountNo = By.id("no");
	public static By RegisterFirstName = By.id("FirstName");
	public static By RegisterLastName = By.id("LastName");
	public static By RegisterAreaCode = By.id("areaCode");
	public static By RegisterPrefix = By.id("prefix");
	public static By RegisterSuffix = By.id("suffix");
	public static By RegisterExtension = By.id("extension");
	public static By RegisterEmailTextBox = By.id("EmailAddress");
	public static By RegisterConfirmEmailTextBox=By.id("ConfirmEmailAddress");
	public static By RegisterSpecialOffers= By.id("Pleaseemailmeaboutspecialoffersandpromotions");
	public static By RegisterUsername= By.id("Username");
	public static By RegisterPassword_First= By.id("Password");
	public static By RegisterPassword_Confirm = By.id("ConfirmPassword");
	public static By RegisterBusinessUse = By.id("BusinessUse");
	public static By RegisterGovernmentUse = By.id("GovernmentUse");
	public static By RegisterIndividualPersonalUse = By.id("IndividualPersonalUse");
	public static By RegisterCompanyName = By.id("CompanyName");
	public static By RegisterButtonSubmit = By.id("registerUserSubmitButton");
	public static By RegisterAccountNumber = By.id("AccountNo");
	public static By RegisterYesEmailTextBox = By.id("email1");
	public static By RegisterBillToZip = By.id("billtozip");
	public static By RegisterUSAPFPORadio = By.id("USAPFPO");
	public static By RegisterInternationalRadio = By.id("international");
	public static By RegisterModalContinueButton = By.id("modalContinueButton");
	
	public GlobalObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}


	public static List<String> Countries()
	{
		List<String> Countries=new LinkedList<String>();
		Countries.add("Select Country");
		Countries.add("Canada");
		Countries.add("Mexico");
		return Countries;
	}
	
		
	public static List<String> DropDownArray()
	{
		List<String> DropdownData=new ArrayList<String>();
		DropdownData.add("Manufacturing - Metal Working");
		DropdownData.add("Manufacturing - Non Metal Working");
		DropdownData.add("Manufacturing - Both Metal Working & Non Metal Working");
		DropdownData.add("Production Equipment Maintenance");
		DropdownData.add("Facility/Plant Maintenance");
		DropdownData.add("R&D/Engineering");
		DropdownData.add("Safety and Personal Protection Equipment");
		DropdownData.add("Repair/Construction");
		DropdownData.add("Home Shop and/or Personal Use");
		DropdownData.add("General Industrial Supplies");
		DropdownData.add("Purchasing Only");
		DropdownData.add("Accounting (AR/AP)");
		DropdownData.add("Executive Management/Owner");
		DropdownData.add("I do not purchase or recommend products");
		return  DropdownData;		
	}
	
	public static  List<String> CheeckBoxContent()
	{
		List<String> CheckBoxData=new ArrayList<String>();
		CheckBoxData.add("Order product for use in my job function");
		CheckBoxData.add("Specify and select products to be ordered by someone else");
		CheckBoxData.add("Purchase products that have been specified by others");
		CheckBoxData.add("Purchasing management");
		CheckBoxData.add("Other  ");		
		return  CheckBoxData;		
	}
	
	
	
	public static List<String> ProductInterests()
	{
		List<String> ProductInterestsData=new ArrayList<String>();		
		ProductInterestsData.add("Holemaking: Solid & Indexable Drills, Reamers & Counterbores");
		ProductInterestsData.add("Threading: Taps, Dies & Other Threading");
		ProductInterestsData.add("End Mills, Saws, Cutters & Tool Bits");
		ProductInterestsData.add("Indexable Turning, Threading & Milling Featuring Kennametal");
		ProductInterestsData.add("Abrasives, Files, Deburring, Soldering & Welding");
		ProductInterestsData.add("Tooling Components: Clamping, Fixturing, Locating, Die & Mold");
		ProductInterestsData.add("Measuring Instruments");
		ProductInterestsData.add("Machinery, DROs, Machine Tool Accessories, Knurls, EDM & Books");
		ProductInterestsData.add("Band Saw Blades, Flat Stock, Drill Rod & Raw Materials");
		ProductInterestsData.add("Fasteners & Hardware");
		ProductInterestsData.add("Hand Tools");
		ProductInterestsData.add("Fleet Maintenance & Power Tools");
		ProductInterestsData.add("Paints, Adhesives, Marking/Labeling, Lubricants & Fluids");
		ProductInterestsData.add("Safety, Communication & Janitorial");
		ProductInterestsData.add("Material Handling, Storage, Office, Packaging & Shipping");
		ProductInterestsData.add("Lighting/Electrical, Motors & Power Transmission");
		ProductInterestsData.add("Pneumatics, Hydraulics, Valves, Fittings, Hose & Tubing");
		ProductInterestsData.add("HVAC, Plumbing, Pumps & Process Equipment");
		return  ProductInterestsData;		
	}
	
	public static List<String> ServicesAndSolutionsInterests()
	{
		List<String> ServicesAndSolutionsInterests=new ArrayList<String>();		
		ServicesAndSolutionsInterests.add("Documenting departmental or job cost savings is a goal of mine or my management");
		ServicesAndSolutionsInterests.add("I sometimes need technical product or vendor information to help my department or myself choose the best product for a job or process");
		ServicesAndSolutionsInterests.add("I sometimes need technical advice on machining processes and/or product application to improve productivity");
		ServicesAndSolutionsInterests.add("I sometimes have the need for special or modified tooling for specific jobs we run");
		ServicesAndSolutionsInterests.add("Increasing efficiency in our Accounts Receivables and Payables is a goal of mine or my department");
		ServicesAndSolutionsInterests.add("Streamlining or automating procurement processes is a goal of mine or my department");
		ServicesAndSolutionsInterests.add("Outages or over stocking of indirect spend items is a common problem or immprovement opportunity within our plant environment");
		ServicesAndSolutionsInterests.add("Gaining visibility and/or accountability on our indirect spend is a goal of mine or my department");
		return  ServicesAndSolutionsInterests;
	}	
}	



