@Batch2
Feature: Switchyard Log

Scenario Outline: Verify Switchyard Log sheet and Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Switchyard Energy Meter Hourly Log" Log Sheet
And I verify if "Switchyard Energy Meter Hourly Log" is selected in the drop down
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
And Enter assets for "Table 1" for "PERAMBALUR"
And Enter assets for "Table 2" for "NLC"
And Enter assets for "Table 3" for "DEVIAKURICHI"
And Enter assets for "Table 4" for "CUDDALORE"
And Enter assets for "Table 5" for "PERAMBALUR"
And Enter assets for "Table 6" for "NLC"
And Enter assets for "Table 7" for "DEVIAKURICHI"
And Enter assets for "Table 8" for "CUDDALORE"
Then Click on Save and Continue button
Then Select "Check" as Type
And verify if assets for "Table 1" for "PERAMBALUR" are updated
And verify if assets for "Table 2" for "NLC" are updated
And verify if assets for "Table 3" for "DEVIAKURICHI" are updated
And verify if assets for "Table 4" for "CUDDALORE" are updated
And verify if assets for "Table 5" for "PERAMBALUR" are updated
And verify if assets for "Table 6" for "NLC" are updated
And verify if assets for "Table 7" for "DEVIAKURICHI 123" are updated
And verify if assets for "Table 8" for "CUDDALORE" are updated
Then verify "Switchyard log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Switchyard log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "Switchyard log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Switchyard log" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "Switchyard log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "Switchyard log" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "Switchyard log" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "Switchyard log" Asset "Table 8" is displayed on logsheet page and save in excel
Then Logout of the application