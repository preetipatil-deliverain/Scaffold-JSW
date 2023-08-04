@Batch1
Feature: 24 Hours- DM and BOPP General Setup

Scenario: Verification of 24 Hours- DM and BOPP General Log Setup
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
And I select "24 Hours- DM and BOPP" as the option for update
And I verify if "24 Hours- DM and BOPP" is selected in the drop down
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
And Enter assets for "Table 1" for "24 Hours- DM and BOPP General"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "24 Hours- DM and BOPP General" are updated
Then verify "24 Hours- DM and BOPP General" Asset "Table 1" is displayed on logsheet page and save in excel                                                                                                           
Then Logout of the application