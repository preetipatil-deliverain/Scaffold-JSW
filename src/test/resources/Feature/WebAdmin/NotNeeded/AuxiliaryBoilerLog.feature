@Batch1
Feature: Auxiliary Boiler Log Setup

Scenario Outline: Verify Auxiliary Boiler Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Auxiliary Boiler Log" Log Sheet
And I verify if "Auxiliary Boiler Log" is selected in the drop down
And verify Asset headers "Gauge Name" displayed in logsheet page
And verify Asset headers "Code" displayed in logsheet page
And verify Asset headers "Status" displayed in logsheet page
And verify Asset headers "Display" displayed in logsheet page
And verify Asset headers "Enabled" displayed in logsheet page
And verify Asset headers "Mandatory" displayed in logsheet page
And verify Asset headers "Min Value" displayed in logsheet page
And verify Asset headers "Max Value" displayed in logsheet page
And Enter assets for "Table 1" for "Auxiliary Boiler Log General ( 1 Service, 2 Standby, 3 Permit) test"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "Auxiliary Boiler Log General ( 1 Service, 2 Standby, 3 Permit) test" are updated
Then verify "Auxiliary Boiler Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then Logout of the application