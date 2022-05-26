Feature: 24 Hr Log Setup - Turbine DCS Setup

Scenario Outline: Verification of 24 Hr Turbine DCS Log Setup
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on menu icon
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
And I select "24 Hours - Turbine DCS" as the option for update
And I verify if "24 Hours - Turbine DCS" is selected in the drop down
And verify Asset headers "Gauge Name" displayed in logsheet page
And verify Asset headers "Code" displayed in logsheet page
And verify Asset headers "Status" displayed in logsheet page
And verify Asset headers "Display" displayed in logsheet page
And verify Asset headers "Enabled" displayed in logsheet page
And verify Asset headers "Mandatory" displayed in logsheet page
And verify Asset headers "Min Value" displayed in logsheet page
And verify Asset headers "Max Value" displayed in logsheet page
And Enter assets for "Table 1" for "24 Hours- Turbine DCS General"
And Enter assets for "Table 2" for "HVAC Compressor2"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "24 Hours- Boiler DCS General" are updated
And verify if assets for "Table 2" for "HVAC Compressor2" are updated
Then verify "24 Hours - Turbine DCS" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "24 Hours - Turbine DCS" Asset "Table 2" is displayed on logsheet page and save in excel                                                                                                        
Then Logout of the application