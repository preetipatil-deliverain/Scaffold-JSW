@Batch1
Feature: Clarifier Chemical Dosing Monitoring Local Log Setup

Scenario Outline: Verify Clarifier Chemical Dosing Monitoring Local Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Clarifier Chemical Dosing Monitoring Local Log" Log Sheet
And I verify if "Clarifier Chemical Dosing Monitoring Local Log" is selected in the drop down
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
And Enter assets for "Table 1" for "Poly Aluminium Chloride(PAC)"
And Enter assets for "Table 2" for "POLYMER Dosing"
And Enter assets for "Table 3" for "LIME Slaking Tank"
And Enter assets for "Table 4" for "LIME Dosing"
And Enter assets for "Table 5" for "CMB Waste Disposal Pump 1"
And Enter assets for "Table 6" for "CMB Waste Disposal Pump 2"
And Enter assets for "Table 7" for "CMB Acid Dozing Pump 1"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "Poly Aluminium Chloride(PAC)" are updated
And verify if assets for "Table 2" for "POLYMER Dosing" are updated
And verify if assets for "Table 3" for "LIME Slaking Tank" are updated
And verify if assets for "Table 4" for "LIME Dosing" are updated
And verify if assets for "Table 5" for "CMB Waste Disposal Pump 1" are updated
And verify if assets for "Table 6" for "CMB Waste Disposal Pump 2" are updated
And verify if assets for "Table 7" for "CMB Acid Dozing Pump 1" are updated
Then verify "Clarifier Chemical" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Clarifier Chemical" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "Clarifier Chemical" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Clarifier Chemical" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "Clarifier Chemical" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "Clarifier Chemical" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "Clarifier Chemical" Asset "Table 7" is displayed on logsheet page and save in excel
Then Logout of the application