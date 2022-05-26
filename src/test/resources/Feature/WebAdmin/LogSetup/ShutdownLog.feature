Feature: Shutdown Log Setup

Scenario Outline: Verify Shutdown Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on menu icon
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Shutdown Log" Log Sheet
And I verify if "Shutdown Log" is selected in the drop down
And verify Asset headers "Gauge Name" displayed in logsheet page
And verify Asset headers "Code" displayed in logsheet page
And verify Asset headers "Status" displayed in logsheet page
And verify Asset headers "Display" displayed in logsheet page
And verify Asset headers "Enabled" displayed in logsheet page
And verify Asset headers "Mandatory" displayed in logsheet page
And verify Asset headers "Min Value" displayed in logsheet page
And verify Asset headers "Max Value" displayed in logsheet page
And Enter assets for "Table 1" for "Shutdown Log General"
And Enter assets for "Table 2" for "TG ETP Equipments Status ( 1 Service, 2 Standby, 3 Permit)"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "Shutdown Log General" are updated
And verify if assets for "Table 2" for "TG ETP Equipments Status ( 1 Service, 2 Standby, 3 Permit)" are updated
Then verify "Shutdown Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Shutdown Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then Logout of the application