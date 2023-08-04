@Batch2
Feature: Generator Hourly  Log Setup

Scenario Outline: Verify Generator Hourly  Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Generator Hourly Log" Log Sheet
And I verify if "Generator Hourly Log" is selected in the drop down
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
And Enter assets for "Table 1" for "Generator (MWhr)"
And Enter assets for "Table 2" for "UAT #1 (MWhr)"
And Enter assets for "Table 3" for "UAT #2 (MWhr)"
And Enter assets for "Table 4" for "Active Load (MW) - MF/2"
And Enter assets for "Table 5" for "Reactive Load (Mvar) - MF/2"
And Enter assets for "Table 6" for "Hourly Generation (MWhr)"
And Enter assets for "Table 7" for "MWhr (Cumulative)"
And Enter assets for "Table 8" for "MWhr (Cumulative)"
And Enter assets for "Table 9" for "MWhr (Cumulative)"
Then Click on Save and Continue button
Then Select "" as Type
And verify if assets for "Table 1" for "Generator (MWhr)" are updated
And verify if assets for "Table 2" for "UAT #1 (MWhr)" are updated
And verify if assets for "Table 3" for "UAT #2 (MWhr)" are updated
And verify if assets for "Table 4" for "Active Load (MW) - MF/2" are updated
And verify if assets for "Table 5" for "Reactive Load (Mvar) - MF/2" are updated
And verify if assets for "Table 6" for "Hourly Generation (MWhr)" are updated
And verify if assets for "Table 7" for "MWhr (Cumulative)" are updated
And verify if assets for "Table 8" for "MWhr (Cumulative)" are updated
And verify if assets for "Table 9" for "MWhr (Cumulative)" are updated
Then verify "Generator" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Generator" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "Generator" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Generator" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "Generator" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "Generator" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "Generator" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "Generator" Asset "Table 8" is displayed on logsheet page and save in excel
Then verify "Generator" Asset "Table 9" is displayed on logsheet page and save in excel
Then Logout of the application