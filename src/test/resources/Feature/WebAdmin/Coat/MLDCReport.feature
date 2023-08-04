@Batch2
Feature: MLDC Report Log Setup

Scenario Outline: Verify  MLDC Report Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "MLDC Report Log" Log Sheet
And I verify if "MLDC Report Log" is selected in the drop down
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
And Enter assets for "Table 1" for "Load in MW 1"
And Enter assets for "Table 2" for "Load in MVAR"
And Enter assets for "Table 3" for "Bus voltage in KV"
And Enter assets for "Table 4" for "Gen Energy meter reading"
And Enter assets for "Table 5" for "Energy Generated"
And Enter assets for "Table 6" for "Abstract"
And Enter assets for "Table 7" for "Auxiliary power consumption UAT#1"
And Enter assets for "Table 8" for "Auxiliary power consumption UAT#2"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "Load in MW 1" are updated
And verify if assets for "Table 2" for "Load in MVAR" are updated
And verify if assets for "Table 3" for "Bus voltage in KV" are updated
And verify if assets for "Table 4" for "Gen Energy meter reading" are updated
And verify if assets for "Table 5" for "Energy Generated" are updated
And verify if assets for "Table 6" for "Abstract" are updated
And verify if assets for "Table 7" for "Auxiliary power consumption UAT#1" are updated
And verify if assets for "Table 8" for "Auxiliary power consumption UAT#2" are updated
Then verify "MLDC Report Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "MLDC Report Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "MLDC Report Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "MLDC Report Log" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "MLDC Report Log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "MLDC Report Log" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "MLDC Report Log" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "MLDC Report Log" Asset "Table 8" is displayed on logsheet page and save in excel
Then Logout of the application