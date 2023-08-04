@Batch1

Feature: Day Shift - DM Plant Log Setup

Scenario: Verification of Day Shift - DM Plant Log Log Setup
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
And I select "DM Plant Log" as the option for update
And I verify if "DM Plant Log" is selected in the drop down
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
And Enter assets for "Table 1" for "BAT Level"
And Enter assets for "Table 2" for "BCT Level"
And Enter assets for "Table 3" for "DM Tank Level"
And Enter assets for "Table 4" for "DM Tank Totaliser"
And Enter assets for "Table 5" for "DM Water"
And Enter assets for "Table 6" for "Portable water tank level"
And Enter assets for "Table 7" for "Flow Totalliser Readings"
And Enter assets for "Table 8" for "N.Pit Level A"
And Enter assets for "Table 9" for "Regeneration Status"
And Enter assets for "Table 10" for "Chemical Consumption"
And Enter assets for "Table 11" for "Chemical Transfer Status"
And Enter assets for "Table 12" for "Ultra Filter Status( 1 Service, 2 Standby, 3 Permit, 4 By-pass)"
And Enter assets for "Table 13" for "CPU Status ( 1 Service, 2 Standby, 3 Permit, 4 Isolated)"
And Enter assets for "Table 14" for "Backwash pit level"
And Enter assets for "Table 15" for "N.Pit Level B"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "BAT Level" are updated
And verify if assets for "Table 2" for "BCT Level" are updated
And verify if assets for "Table 3" for "DM Tank Level" are updated
And verify if assets for "Table 4" for "DM Tank Totaliser" are updated
And verify if assets for "Table 5" for "DM Water" are updated
And verify if assets for "Table 6" for "Portable water tank level" are updated
And verify if assets for "Table 7" for "Flow Totalliser Readings" are updated
And verify if assets for "Table 8" for "N.Pit Level A" are updated
And verify if assets for "Table 9" for "Regeneration Status" are updated
And verify if assets for "Table 10" for "Chemical Consumption" are updated
And verify if assets for "Table 11" for "Chemical Transfer Status" are updated
And verify if assets for "Table 12" for "Ultra Filter Status( 1 Service, 2 Standby, 3 Permit, 4 By-pass)" are updated
And verify if assets for "Table 13" for "CPU Status ( 1 Service, 2 Standby, 3 Permit, 4 Isolated)" are updated
And verify if assets for "Table 14" for "Backwash pit level" are updated
And verify if assets for "Table 15" for "N.Pit Level B" are updated
Then verify "Day Shift - DM Plant Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 8" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 9" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 10" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 11" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 12" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 13" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 14" is displayed on logsheet page and save in excel
Then verify "Day Shift - DM Plant Log" Asset "Table 15" is displayed on logsheet page and save in excel                                                                                                         
Then Logout of the application