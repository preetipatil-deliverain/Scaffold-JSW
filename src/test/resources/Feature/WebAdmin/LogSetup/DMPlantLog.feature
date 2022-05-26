Feature: DM Plant Log Setup

Scenario Outline: Verify DM Plant Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on menu icon
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "DM Plant Log" Log Sheet
And I verify if "DM Plant Log" is selected in the drop down
And verify Asset headers "Gauge Name" displayed in logsheet page
And verify Asset headers "Code" displayed in logsheet page
And verify Asset headers "Status" displayed in logsheet page
And verify Asset headers "Display" displayed in logsheet page
And verify Asset headers "Enabled" displayed in logsheet page
And verify Asset headers "Mandatory" displayed in logsheet page
And verify Asset headers "Min Value" displayed in logsheet page
And verify Asset headers "Max Value" displayed in logsheet page
And Enter assets for "Table 1" for "DM Plant Building A/C"
And Enter assets for "Table 2" for "DM Plant PAC in service 1"
And Enter assets for "Table 3" for "DM Plant PAC in service 2"
And Enter assets for "Table 4" for "DM Plant PAC in service 3"
And Enter assets for "Table 5" for "Transformer 10BHT03CT/CW"
And Enter assets for "Table 6" for "Transformer 10BHT04CT/CW"
And Enter assets for "Table 7" for "Transformer 10BHT05R/W-FF"
And Enter assets for "Table 8" for "Transformer 10BHT06R/W-FF"
And Enter assets for "Table 9" for "Boiler Feed Pump #1"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "DM Plant Building A/C" are updated
And verify if assets for "Table 2" for "DM Plant PAC in service 1" are updated
And verify if assets for "Table 3" for "DM Plant PAC in service 2" are updated
And verify if assets for "Table 4" for "DM Plant PAC in service 3" are updated
And verify if assets for "Table 5" for "Transformer 10BHT03CT/CW" are updated
And verify if assets for "Table 6" for "Transformer 10BHT04CT/CW" are updated
And verify if assets for "Table 7" for "Transformer 10BHT05R/W-FF" are updated
And verify if assets for "Table 8" for "Transformer 10BHT06R/W-FF" are updated
And verify if assets for "Table 9" for "Boiler Feed Pump #1" are updated
Then verify "DM Plant Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "DM Plant Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "DM Plant Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "DM Plant Log" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "DM Plant Log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "DM Plant Log" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "DM Plant Log" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "DM Plant Log" Asset "Table 8" is displayed on logsheet page and save in excel
Then verify "DM Plant Log" Asset "Table 9" is displayed on logsheet page and save in excel
Then Logout of the application