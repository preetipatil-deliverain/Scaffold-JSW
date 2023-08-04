@Batch2
Feature: Main Boiler Lancing Parameters Setup

Scenario Outline: Verify Main Boiler Lancing Parameters Log sheet Test Data Stored on Excel sheet 
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Main Boiler Lancing Parameters" Log Sheet
And I verify if "Main Boiler Lancing Parameters" is selected in the drop down
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
And Enter assets for "Table 1" for "Before & After Water Lance Operation"
And Enter assets for "Table 2" for "During Water Lance Operation "
Then Click on Save and Continue button
And verify if assets for "Table 1" for "Before & After Water Lance Operation" are updated
And verify if assets for "Table 2" for "During Water Lance Operation" are updated
Then verify "Main Boiler Lancing" Asset "Table 1" is displayed on logsheet page and save in excel
Then Logout of the application