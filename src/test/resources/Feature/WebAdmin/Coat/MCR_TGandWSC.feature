@Batch2
Feature: MCR TG and WSC Log Setup

Scenario Outline: Verify MCR TG and WSC Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "MCR TG and WSC Log" Log Sheet
And I verify if "MCR TG and WSC Log" is selected in the drop down
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
And Enter assets for "Table 1" for "Turbo Generator / WSC General"
And Enter assets for "Table 2" for "CPU vessels flow A"
And Enter assets for "Table 3" for "CPU vessels flow B"
And Enter assets for "Table 4" for "CPU vessels flow C"
And Enter assets for "Table 5" for "CEP 1"
And Enter assets for "Table 6" for "CEP 2"
And Enter assets for "Table 7" for "FWT Temperature"
And Enter assets for "Table 8" for "BFP 1"
And Enter assets for "Table 9" for "BFP 2"
And Enter assets for "Table 10" for "Test Reassign"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "Turbo Generator / WSC General" are updated
And verify if assets for "Table 2" for "CPU vessels flow A" are updated
And verify if assets for "Table 3" for "CPU vessels flow B" are updated
And verify if assets for "Table 4" for "CPU vessels flow C" are updated
And verify if assets for "Table 5" for "CEP 1" are updated
And verify if assets for "Table 6" for "CEP 2" are updated
And verify if assets for "Table 7" for "FWT Temperature" are updated
And verify if assets for "Table 8" for "BFP 1" are updated
And verify if assets for "Table 9" for "BFP 2" are updated
And verify if assets for "Table 10" for "Test Reassign" are updated
Then verify "MCR TG and WSC Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "MCR TG and WSC Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "MCR TG and WSC Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "MCR TG and WSC Log" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "MCR TG and WSC Log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "MCR TG and WSC Log" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "MCR TG and WSC Log" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "MCR TG and WSC Log" Asset "Table 8" is displayed on logsheet page and save in excel
Then verify "MCR TG and WSC Log" Asset "Table 9" is displayed on logsheet page and save in excel
Then verify "MCR TG and WSC Log" Asset "Table 10" is displayed on logsheet page and save in excel
Then Logout of the application