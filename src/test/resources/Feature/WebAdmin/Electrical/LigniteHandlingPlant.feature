@Batch2
Feature: Lignite Handling Plant Log Setup

Scenario Outline: Verify Lignite Handling Plant Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Lignite Handling Plant Log" Log Sheet
And I verify if "Lignite Handling Plant Log" is selected in the drop down
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
And Enter assets for "Table 1" for "LHP General"
And Enter assets for "Table 2" for "LHP Shift End Readings"
And Enter assets for "Table 3" for "LHP Transformer 101BHT11"
And Enter assets for "Table 4" for "Load Cell Cumulative (MT)"
And Enter assets for "Table 5" for "LHP - Shift End Status ( 1 Service, 2 Standby, 3 Permit)"
And Enter assets for "Table 6" for "LHP Transformer 101BHT12"
And Enter assets for "Table 7" for "Mill 50"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "LHP General" are updated
And verify if assets for "Table 2" for "LHP Shift End Readings" are updated
And verify if assets for "Table 3" for "LHP Transformer 101BHT11" are updated
And verify if assets for "Table 4" for "Load Cell Cumulative (MT)" are updated
And verify if assets for "Table 5" for "LHP - Shift End Status ( 1 Service, 2 Standby, 3 Permit)" are updated
And verify if assets for "Table 6" for "LHP Transformer 101BHT12" are updated
And verify if assets for "Table 7" for "Mill 50" are updated
Then verify "Lignite Handling Plant Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Lignite Handling Plant Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "Lignite Handling Plant Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Lignite Handling Plant Log" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "Lignite Handling Plant Log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "Lignite Handling Plant Log" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "Lignite Handling Plant Log" Asset "Table 7" is displayed on logsheet page and save in excel
Then Logout of the application