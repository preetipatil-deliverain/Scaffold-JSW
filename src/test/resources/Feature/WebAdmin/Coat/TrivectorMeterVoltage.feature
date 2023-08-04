@Batch2
Feature: Trivector Meter Voltage Log Setup

Scenario Outline: Verify Trivector Meter Voltage Log sheet Test Data Stored on Excel sheet 
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Trivector Meter Voltage Log" Log Sheet
And I verify if "Trivector Meter Voltage Log" is selected in the drop down
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
And Enter assets for "Table 1" for "Perambalur"
And Enter assets for "Table 2" for "NLC - II"
And Enter assets for "Table 3" for "Deivakurichi"
And Enter assets for "Table 4" for "Cuddalore"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "Perambalur" are updated
And verify if assets for "Table 2" for "NLC - II" are updated
And verify if assets for "Table 3" for "Deivakurichi" are updated
And verify if assets for "Table 4" for "Cuddalore" are updated
Then verify "Trivector Meter Voltage" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Trivector Meter Voltage" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "Trivector Meter Voltage" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Trivector Meter Voltage" Asset "Table 4" is displayed on logsheet page and save in excel
Then Logout of the application