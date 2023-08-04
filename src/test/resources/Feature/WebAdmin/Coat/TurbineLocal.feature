@Batch2
Feature: Turbine Local  Setup

Scenario: Verification of Turbine local Log Setup
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
And I select "Turbine Local Log" as the option for update
And I verify if "Turbine Local Log" is selected in the drop down
And verify Asset headers "Gauge Name" displayed in logsheet page
And verify Asset headers "Code" displayed in logsheet page
And verify Asset headers "Status" displayed in logsheet page
And verify Asset headers "Display" displayed in logsheet page
And verify Asset headers "Enabled" displayed in logsheet page
And verify Asset headers "Mandatory" displayed in logsheet page
And verify Asset headers "L2 Value" displayed in logsheet page
And verify Asset headers "L1 Value" displayed in logsheet page
And verify Asset headers "H1 Value" displayed in logsheet page
And verify Asset headers "H2 Value" displayed in logsheet page
And Enter assets for "Table 1" for "TG Hall 21 meters"
And Enter assets for "Table 2" for "TG Hall 16.5 Meters"
And Enter assets for "Table 3" for "TG Hall 10.5 meters"
And Enter assets for "Table 4" for "TG Hall 5.5 meters"
And Enter assets for "Table 5" for "Air Washer 1 - Blower ( 1 Service, 2 Standby, 3 Permit)"
And Enter assets for "Table 6" for "Air Washer 1 - CW Pump ( 1 Service, 2 Standby, 3 Permit)"
And Enter assets for "Table 7" for "HP Bypass Pump"
And Enter assets for "Table 8" for "Excitation PAC"
And Enter assets for "Table 9" for "LP Bypass Pump"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "TG Hall 21 meters" are updated
And verify if assets for "Table 2" for "TG Hall 16.5 Meters" are updated
And verify if assets for "Table 3" for "TG Hall 10.5 Meters" are updated
And verify if assets for "Table 4" for "TG Hall 5.5 meters" are updated
And verify if assets for "Table 5" for "Air Washer 1 - Blower ( 1 Service, 2 Standby, 3 Permit)" are updated
And verify if assets for "Table 6" for "Air Washer 1 - CW Pump ( 1 Service, 2 Standby, 3 Permit)" are updated
And verify if assets for "Table 7" for "HP Bypass Pump" are updated
And verify if assets for "Table 8" for "Excitation PAC" are updated
And verify if assets for "Table 9" for "LP Bypass Pump" are updated
And verify "Turbine Local" Asset "Table 1" is displayed on logsheet page and save in excel
And verify "Turbine Local" Asset "Table 2" is displayed on logsheet page and save in excel  
And verify "Turbine Local" Asset "Table 3" is displayed on logsheet page and save in excel  
And verify "Turbine Local" Asset "Table 4" is displayed on logsheet page and save in excel  
And verify "Turbine Local" Asset "Table 5" is displayed on logsheet page and save in excel  
And verify "Turbine Local" Asset "Table 6" is displayed on logsheet page and save in excel  
And verify "Turbine Local" Asset "Table 7" is displayed on logsheet page and save in excel  
And verify "Turbine Local" Asset "Table 8" is displayed on logsheet page and save in excel  
And verify "Turbine Local" Asset "Table 9" is displayed on logsheet page and save in excel                                                                                                   
Then Logout of the application