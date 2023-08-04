Feature: Manage Assets Page Validation

  Scenario Outline: Verify if Manage Assets page is displayed
  Given Login into Scaffold Log Automation Application As "Admin"
  And verify if user logged in sucessfully
  When I click on Administrator Menu
  And click on the "Manage Assets" link
  And Verify Manage Assets List page is displayed

  Scenario Outline: Verify if all headers are displayed in the Manage Assets page
  Given Login into Scaffold Log Automation Application As "Admin"
  And verify if user logged in sucessfully
  When I click on Administrator Menu
  And click on the "Manage Assets" link
  And Verify Manage Assets List page is displayed
	Then verify All headers "<Headers>" are displayed on Manage Assets List table
	
	Examples:
	|Headers|
	|Logsheet Name|
	|Is NFC Enabled|
	|Action|
  
  Scenario Outline: Verify Action is displayed in the table
	Given Navigate to scaffold v2 web application
	Then Verify if login screen is displayed
	And I enter the username "<Username>"
	And I enter the password "<Password>"
	And I click on login button
	And verify if user logged in sucessfully
	When I click on Administrator Menu
  And click on the "Manage Assets" link
  And Verify Manage Assets List page is displayed
	Then verify Edit link is displayed on the location list table
	  
	Examples:
	| Username               | Password |
	| vinod.r@deliverain.com | Test@1234 |

	Scenario Outline: Verify if user is able to add the record on location list table
  Given Login into Scaffold Log Automation Application As "Admin"
  And verify if user logged in sucessfully
  When I click on Administrator Menu
  And click on the "Manage Assets" link
	  And Verify Manage Assets List page is displayed
  And verify if "<LogSheet>" is displayed in Manage Assets page
	  
	 Examples:
	|LogSheet|
	|24 Hours - Boiler DCS|
	|24 Hours - Turbine DCS| 
	|24 Hours- Switchyard (PLCC)| 
	|24 Hours- AHP| 
	|24 Hours- Boiler Field| 
	|24 Hours- LHP| 
	|24 Hours- Turbine Local| 
	|24 Hours- DM and BOPP| 
	|Equipment Status Log| 
	|MCR Boiler Log| 
	|Main Boiler Lancing Parameters| 
	|MCR TG and WSC Log| 
	|Boiler Local Log| 
	|Weekly Boiler Soot Blower Parameters| 
	|Turbine Local Log| 
	|Water Steam Cycle Local Log| 
	|Ash Handling Plant and FOPH Log| 
	|Lignite Handling Plant Log|
	|Balance of Plant Log| 
	|DM Plant Log| 
	|Switchyard Log - I| 
	|Trivector Meter Voltage Log| 
	|Generator Transformer| 
	|Shutdown Log|
	|Clarifier Chemical Dosing Monitoring Local Log|