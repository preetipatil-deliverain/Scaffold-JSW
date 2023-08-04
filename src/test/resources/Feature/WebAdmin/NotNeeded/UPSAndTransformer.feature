@Batch2
Feature: Generator UPS Log Setup

Scenario Outline: Verify UPS and Transformer - Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Generator UPS" Log Sheet
And I verify if "Generator UPS" is selected in the drop down
And verify Asset headers "Gauge Name" displayed in logsheet page
And verify Asset headers "Code" displayed in logsheet page
And verify Asset headers "Status" displayed in logsheet page
And verify Asset headers "Display" displayed in logsheet page
And verify Asset headers "Enabled" displayed in logsheet page
And verify Asset headers "Mandatory" displayed in logsheet page
And verify Asset headers "Min Value" displayed in logsheet page
And verify Asset headers "Max Value" displayed in logsheet page
And Enter assets for "Table 1" for "MAIN UPS Inverter 1 (10 BRU 01)"
And Enter assets for "Table 2" for "MAIN UPS Inverter 2 (10 BRU 04)"
And Enter assets for "Table 3" for "MAIN UPS"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "MAIN UPS Inverter 1 (10 BRU 01)" are updated
And verify if assets for "Table 2" for "MAIN UPS Inverter 2 (10 BRU 04)" are updated
And verify if assets for "Table 3" for "MAIN UPS" are updated
Then verify "UPS and Transformer - Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "UPS and Transformer - Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "UPS and Transformer - Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then Logout of the application