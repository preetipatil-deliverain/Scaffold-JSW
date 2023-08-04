@Batch1
Feature: Balance of Plant Log Setup

Scenario: Verification of Balance of Plant Log Setup
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
And I select "Balance of Plant Log" as the option for update
And I verify if "Balance of Plant Log" is selected in the drop down
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
And Enter assets for "Table 1" for "MCWP 2"
And Enter assets for "Table 2" for "MCWP 3"
And Enter assets for "Table 3" for "Balance of Plant Log General ( 1 Service, 2 Auto Standby, 3 Permit)"
And Enter assets for "Table 4" for "Administration Building AC"
And Enter assets for "Table 5" for "Oil water separation feed pump #1"
And Enter assets for "Table 6" for "Oil recovery pump #1"
And Enter assets for "Table 7" for "Clear water pump #1"
And Enter assets for "Table 8" for "Oily water Sludge pump #1"
And Enter assets for "Table 9" for "Oil water separation feed pump #2"
And Enter assets for "Table 10" for "Oil recovery pump #2"
And Enter assets for "Table 11" for "Clear water pump #2"
And Enter assets for "Table 12" for "Oily water Sludge pump #2"
And Enter assets for "Table 13" for "Oil skimmer test"
And Enter assets for "Table 14" for "Cooling Water Treatment Plant Equipments ( 1 Service, 2 Standby, 3 Permit)"
And Enter assets for "Table 15" for "CW Parameters"
And Enter assets for "Table 16" for "Borewell Pump Group ( 1 Service, 2 Standby, 3 Permit)"
And Enter assets for "Table 17" for "Chlorine Consumption #2"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "MCWP 2" are updated
And verify if assets for "Table 2" for "MCWP 3" are updated
And verify if assets for "Table 3" for "Balance of Plant Log General ( 1 Service, 2 Auto Standby, 3 Permit)" are updated
And verify if assets for "Table 4" for "Administration Building AC" are updated
And verify if assets for "Table 5" for "Oil water separation feed pump #1" are updated
And verify if assets for "Table 6" for "Oil recovery pump #1" are updated
And verify if assets for "Table 7" for "Clear water pump #1" are updated
And verify if assets for "Table 8" for "Oily water Sludge pump #1" are updated
And verify if assets for "Table 9" for "Oil water separation feed pump #2" are updated
And verify if assets for "Table 10" for "Oil recovery pump #2" are updated
And verify if assets for "Table 11" for "Clear water pump #2" are updated
And verify if assets for "Table 12" for "Oily water Sludge pump #2" are updated
And verify if assets for "Table 13" for "Oil skimmer test" are updated
And verify if assets for "Table 14" for "Cooling Water Treatment Plant Equipments ( 1 Service, 2 Standby, 3 Permit)" are updated
And verify if assets for "Table 15" for "CW Parameters" are updated
And verify if assets for "Table 16" for "Borewell Pump Group ( 1 Service, 2 Standby, 3 Permit)" are updated
And verify if assets for "Table 17" for "Chlorine Consumption #2" are updated
Then verify "Balance of Plant Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Balance of Plant Log" Asset "Table 2" is displayed on logsheet page and save in excel                                                                                                            
Then verify "Balance of Plant Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Balance of Plant Log" Asset "Table 4" is displayed on logsheet page and save in excel                                                                                                            
Then verify "Balance of Plant Log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "Balance of Plant Log" Asset "Table 6" is displayed on logsheet page and save in excel                                                                                                            
Then verify "Balance of Plant Log" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "Balance of Plant Log" Asset "Table 8" is displayed on logsheet page and save in excel                                                                                                            
Then verify "Balance of Plant Log" Asset "Table 9" is displayed on logsheet page and save in excel
Then verify "Balance of Plant Log" Asset "Table 10" is displayed on logsheet page and save in excel                                                                                                            
Then verify "Balance of Plant Log" Asset "Table 11" is displayed on logsheet page and save in excel
Then verify "Balance of Plant Log" Asset "Table 12" is displayed on logsheet page and save in excel                                                                                                            
Then verify "Balance of Plant Log" Asset "Table 13" is displayed on logsheet page and save in excel
Then verify "Balance of Plant Log" Asset "Table 14" is displayed on logsheet page and save in excel                                                                                                            
Then verify "Balance of Plant Log" Asset "Table 15" is displayed on logsheet page and save in excel
Then verify "Balance of Plant Log" Asset "Table 16" is displayed on logsheet page and save in excel                                                                                                            
Then verify "Balance of Plant Log" Asset "Table 17" is displayed on logsheet page and save in excel                                                                                                       
Then Logout of the application