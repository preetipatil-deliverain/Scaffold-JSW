@Batch1
Feature: Boiler Local Log Setup

Scenario Outline: Verify Boiler Local Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Boiler Local Log" Log Sheet
And I verify if "Boiler Local Log" is selected in the drop down
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
And Enter assets for "Table 1" for "Boiler Local General ( 1 Service, 2 Standby, 3 Permit)"
And Enter assets for "Table 2" for "Mill 10 test"
And Enter assets for "Table 3" for "Mill 20"
And Enter assets for "Table 4" for "Mill 30"
And Enter assets for "Table 5" for "Mill 40"
And Enter assets for "Table 6" for "Mill 50"
And Enter assets for "Table 7" for "Mill 60"
And Enter assets for "Table 8" for "RAPH 1"
And Enter assets for "Table 9" for "RAPH 2"
And Enter assets for "Table 10" for "ESP Switchgear Building AC"
And Enter assets for "Table 11" for "HFO"
And Enter assets for "Table 12" for "Compressor 1"
And Enter assets for "Table 13" for "Compressor 2"
And Enter assets for "Table 14" for "Transformer 10BFT03-USS#2"
And Enter assets for "Table 15" for "Transformer 10BFT04-USS#2"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "Boiler Local General ( 1 Service, 2 Standby, 3 Permit)" are updated
And verify if assets for "Table 2" for "Mill 10 test" are updated
And verify if assets for "Table 3" for "Mill 20" are updated
And verify if assets for "Table 4" for "Mill 30" are updated
And verify if assets for "Table 5" for "Mill 40" are updated
And verify if assets for "Table 6" for "Mill 50" are updated
And verify if assets for "Table 7" for "Mill 60" are updated
And verify if assets for "Table 8" for "RAPH 1" are updated
And verify if assets for "Table 9" for "RAPH 2" are updated
And verify if assets for "Table 10" for "ESP Switchgear Building AC" are updated
And verify if assets for "Table 11" for "HFO" are updated
And verify if assets for "Table 12" for "Compressor 1" are updated
And verify if assets for "Table 13" for "Compressor 2" are updated
And verify if assets for "Table 14" for "Transformer 10BFT03-USS#2" are updated
And verify if assets for "Table 15" for "Transformer 10BFT04-USS#2" are updated
Then verify "Boiler Local Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 8" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 9" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 10" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 11" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 12" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 13" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 14" is displayed on logsheet page and save in excel
Then verify "Boiler Local Log" Asset "Table 15" is displayed on logsheet page and save in excel
Then Logout of the application