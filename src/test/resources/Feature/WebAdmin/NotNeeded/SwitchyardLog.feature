@Batch2
Feature: Switchyard Log - I Log

Scenario Outline: Verify Switchyard Log - I Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Switchyard Log - I" Log Sheet
And I verify if "Switchyard Log - I" is selected in the drop down
And verify Asset headers "Gauge Name" displayed in logsheet page
And verify Asset headers "Code" displayed in logsheet page
And verify Asset headers "Status" displayed in logsheet page
And verify Asset headers "Display" displayed in logsheet page
And verify Asset headers "Enabled" displayed in logsheet page
And verify Asset headers "Mandatory" displayed in logsheet page
And verify Asset headers "Min Value" displayed in logsheet page
And verify Asset headers "Max Value" displayed in logsheet page
And Enter assets for "Table 1" for "GT BAY - GENERAL"
And Enter assets for "Table 2" for "GT BAY - LAVT'S"
And Enter assets for "Table 3" for "GT BAY - BUS I"
And Enter assets for "Table 4" for "TRANSFER BAY"
And Enter assets for "Table 5" for "Bus 1"
And Enter assets for "Table 6" for "Bus 2"
And Enter assets for "Table 7" for "Bus Coupler"
And Enter assets for "Table 8" for "PERAMBALUR BAY General 1"
And Enter assets for "Table 9" for "PERAMBALUR BAY General 2"
And Enter assets for "Table 10" for "PERAMBALUR BAY BUS II"
And Enter assets for "Table 11" for "NLC BAY General 1"
And Enter assets for "Table 12" for "NLC BAY General 2"
And Enter assets for "Table 13" for "NLC BAY BUS II"
And Enter assets for "Table 14" for "DEVIAKURCHI BAY General 1"
And Enter assets for "Table 15" for "DEVIAKURCHI BAY General 2"
And Enter assets for "Table 16" for "DEVIAKURCHI BAY BUS I"
And Enter assets for "Table 17" for "CUDDALORE BAY General 1"
And Enter assets for "Table 18" for "CUDDALORE BAY General 2"
And Enter assets for "Table 19" for "CUDDALORE BAY BUS I"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "GT BAY - GENERAL" are updated
And verify if assets for "Table 2" for "GT BAY - LAVT'S" are updated
And verify if assets for "Table 3" for "GT BAY - BUS I" are updated
And verify if assets for "Table 4" for "TRANSFER BAY" are updated
And verify if assets for "Table 5" for "Bus 1" are updated
And verify if assets for "Table 6" for "Bus 2" are updated
And verify if assets for "Table 7" for "Bus Coupler" are updated
And verify if assets for "Table 8" for "PERAMBALUR BAY General 1" are updated
And verify if assets for "Table 9" for "PERAMBALUR BAY General 2" are updated
And verify if assets for "Table 10" for "PERAMBALUR BAY BUS II" are updated
And verify if assets for "Table 11" for "NLC BAY General 1" are updated
And verify if assets for "Table 12" for "NLC BAY General 2" are updated
And verify if assets for "Table 13" for "NLC BAY BUS II" are updated
And verify if assets for "Table 14" for "DEVIAKURCHI BAY General 1" are updated
And verify if assets for "Table 15" for "DEVIAKURCHI BAY General 2" are updated
And verify if assets for "Table 16" for "DEVIAKURCHI BAY BUS I" are updated
And verify if assets for "Table 17" for "CUDDALORE BAY General 1" are updated
And verify if assets for "Table 18" for "CUDDALORE BAY General 2" are updated
And verify if assets for "Table 19" for "CUDDALORE BAY BUS I" are updated
Then verify "Switchyard Log - I" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 8" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 9" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 10" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 11" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 12" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 13" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 14" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 15" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 16" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 17" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 18" is displayed on logsheet page and save in excel
Then verify "Switchyard Log - I" Asset "Table 19" is displayed on logsheet page and save in excel
Then Logout of the application