@Batch2
Feature: Water Steam Cycle Local Log

Scenario Outline: Verify Water Steam Cycle Local Log sheet Test Data Stored on Excel sheet tablewise for Water Steam Cycle
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Water Steam Cycle Local Log" Log Sheet
And I verify if "Water Steam Cycle Local Log" is selected in the drop down
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
And Enter assets for "Table 1" for "Boiler Feed Pump #1"
And Enter assets for "Table 2" for "Boiler Feed Pump #3"
And Enter assets for "Table 3" for "Boiler Feed Pump #2"
And Enter assets for "Table 4" for "CEP #2"
And Enter assets for "Table 5" for "Condenser parameters"
And Enter assets for "Table 6" for "CCCW Pump #1"
And Enter assets for "Table 7" for "CCCW Pump #2"
And Enter assets for "Table 8" for "CEP #1"
And Enter assets for "Table 9" for "Plate Type Heat Exchanger #2"
And Enter assets for "Table 10" for "ACW Pump #1"
And Enter assets for "Table 11" for "WSC Pumps - General"
And Enter assets for "Table 12" for "Plate Type Heat Exchanger #1"
And Enter assets for "Table 13" for "ACW Pump #2"
And Enter assets for "Table 14" for "Oil recovery pump #1"
And Enter assets for "Table 15" for "TG ETP Equipments Status ( 1 Service, 2 Standby, 3 Permit)"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "Boiler Feed Pump #1" are updated
And verify if assets for "Table 2" for "Boiler Feed Pump #3" are updated
And verify if assets for "Table 3" for "Boiler Feed Pump #2" are updated
And verify if assets for "Table 4" for "CEP #2" are updated
And verify if assets for "Table 5" for "Condenser parameters" are updated
And verify if assets for "Table 6" for "CCCW Pump #1" are updated
And verify if assets for "Table 7" for "CCCW Pump #2" are updated
And verify if assets for "Table 8" for "CEP #1" are updated
And verify if assets for "Table 9" for "Plate Type Heat Exchanger #2" are updated
And verify if assets for "Table 10" for "ACW Pump #1" are updated
And verify if assets for "Table 11" for "WSC Pumps - General" are updated
And verify if assets for "Table 12" for "Plate Type Heat Exchanger #1" are updated
And verify if assets for "Table 13" for "ACW Pump #2" are updated
And verify if assets for "Table 14" for "Oil recovery pump #1" are updated
And verify if assets for "Table 15" for "TG ETP Equipments Status ( 1 Service, 2 Standby, 3 Permit)" are updated
Then verify "Water Steam Cycle Local Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 8" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 9" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 10" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 11" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 12" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 13" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 14" is displayed on logsheet page and save in excel
Then verify "Water Steam Cycle Local Log" Asset "Table 15" is displayed on logsheet page and save in excel
Then Logout of the application