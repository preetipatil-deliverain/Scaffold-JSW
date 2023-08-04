@Batch2
Feature: MCR Boiler Log Setup

Scenario Outline: Verify MCR Boiler Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "MCR Boiler Log" Log Sheet
And I verify if "MCR Boiler Log" is selected in the drop down
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
And Enter assets for "Table 1" for "MCR Boiler General"
And Enter assets for "Table 2" for "Mill 10"
And Enter assets for "Table 3" for "Mill 20"
And Enter assets for "Table 4" for "Mill 30"
And Enter assets for "Table 5" for "Mill 40"
And Enter assets for "Table 6" for "Mill 50"
And Enter assets for "Table 7" for "Mill 60"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "MCR Boiler General" are updated
And verify if assets for "Table 2" for "Mill 10" are updated
And verify if assets for "Table 3" for "Mill 20" are updated
And verify if assets for "Table 4" for "Mill 30" are updated
And verify if assets for "Table 5" for "Mill 40" are updated
And verify if assets for "Table 6" for "Mill 50" are updated
And verify if assets for "Table 7" for "Mill 60" are updated
Then verify "MCR Boiler Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "MCR Boiler Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "MCR Boiler Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "MCR Boiler Log" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "MCR Boiler Log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "MCR Boiler Log" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "MCR Boiler Log" Asset "Table 7" is displayed on logsheet page and save in excel
Then Logout of the application