@Batch1
Feature: 24 Hr Log Setup - General

Scenario Outline: Verification of 24 Hr Log Setup
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
And I select "<Log>" as the option for update
And I verify if "<Log>" is selected in the drop down
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
Then Logout of the application

Examples:
|Log|
|24 Hours - Boiler DCS |
|24 Hours - Turbine DCS |
|24 Hours- Switchyard (PLCC) |
|24 Hours- AHP |
|24 Hours- Boiler Field |
|24 Hours- LHP |
|24 Hours- Turbine Local |
|24 Hours- DM and BOPP |