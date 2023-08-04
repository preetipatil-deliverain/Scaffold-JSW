@Batch1
Feature: Ash Handling Plant and FOPH Log Log

Scenario Outline: Verify Ash Handling Plant and FOPH Operator Assistant Log sheet Test Data Stored on Excel sheet 
 Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Ash Handling Plant and FOPH Log" Log Sheet
And I verify if "Ash Handling Plant and FOPH Log" is selected in the drop down
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
And Enter assets for "Table 1" for "Conveying Air Compressor 1"
And Enter assets for "Table 2" for "Conveying Air Compressor 2"
And Enter assets for "Table 3" for "Conveying Air Compressor 3"
And Enter assets for "Table 4" for "Ash Water Pump 1"
And Enter assets for "Table 5" for "RAD"
And Enter assets for "Table 6" for "Seal Water Pump ( 1 Service, 2 Standby, 3 Permit)"
And Enter assets for "Table 7" for "Ash Water Pump 2"
And Enter assets for "Table 8" for "Ash Slurry Pump 1"
And Enter assets for "Table 9" for "Ash Water Pump 3"
And Enter assets for "Table 10" for "Ash Slurry Pump 2"
And Enter assets for "Table 11" for "Ash Slurry Pump 3"
And Enter assets for "Table 12" for "HFO Forwarding Pump 1"
And Enter assets for "Table 13" for "HFO Forwarding Pump 2"
And Enter assets for "Table 14" for "Ash Recovery Pump 1"
And Enter assets for "Table 15" for "Ash Recovery Pump 2"
And Enter assets for "Table 16" for "HFO and HSD Tanks ( 1 Service, 2 Standby, 3 Permit)"
And Enter assets for "Table 17" for "FOPH ETP Oil water Separation feed pump #1"
And Enter assets for "Table 18" for "FOPH ETP Oil water Separation feed pump #2"
And Enter assets for "Table 19" for "FOPH ETP Oil recovery pump #1"
And Enter assets for "Table 20" for "FOPH ETP Oil recovery pump #2"
And Enter assets for "Table 21" for "FOPH ETP Clear water pump #1"
And Enter assets for "Table 22" for "FOPH ETP Clear water pump #2"
And Enter assets for "Table 23" for "FOPH ETP Sludge disposal pump #1"
And Enter assets for "Table 24" for "FOPH ETP Sludge disposal pump #2"
And Enter assets for "Table 25" for "FOPH ETP Oil skimmer"
And Enter assets for "Table 26" for "Transformer 10BHT07-AHP"
And Enter assets for "Table 27" for "Transformer 10BHT08-AHP"
And Enter assets for "Table 28" for "Transformer 10BHT13CT/AUX"
And Enter assets for "Table 29" for "Transformer 10BHT14CT/AUX"
Then Click on Save and Continue button
And verify if assets for "Table 1" for "Conveying Air Compressor 1" are updated
And verify if assets for "Table 2" for "Conveying Air Compressor 2" are updated
And verify if assets for "Table 3" for "Conveying Air Compressor 3" are updated
And verify if assets for "Table 4" for "Ash Water Pump 1" are updated
And verify if assets for "Table 5" for "RAD" are updated
And verify if assets for "Table 6" for "Seal Water Pump ( 1 Service, 2 Standby, 3 Permit)" are updated
And verify if assets for "Table 7" for "Ash Water Pump 2" are updated
And verify if assets for "Table 8" for "Ash Slurry Pump 1" are updated
And verify if assets for "Table 9" for "Ash Water Pump 3" are updated
And verify if assets for "Table 10" for "Ash Slurry Pump 2" are updated
And verify if assets for "Table 11" for "Ash Slurry Pump 3" are updated
And verify if assets for "Table 12" for "HFO Forwarding Pump 1" are updated
And verify if assets for "Table 13" for "HFO Forwarding Pump 2" are updated
And verify if assets for "Table 14" for "Ash Recovery Pump 1" are updated
And verify if assets for "Table 15" for "Ash Recovery Pump 2" are updated
And verify if assets for "Table 16" for "HFO and HSD Tanks ( 1 Service, 2 Standby, 3 Permit)" are updated
And verify if assets for "Table 17" for "FOPH ETP Oil water Separation feed pump #1" are updated
And verify if assets for "Table 18" for "FOPH ETP Oil water Separation feed pump #2" are updated
And verify if assets for "Table 19" for "FOPH ETP Oil recovery pump #1" are updated
And verify if assets for "Table 20" for "FOPH ETP Oil recovery pump #2" are updated
And verify if assets for "Table 21" for "FOPH ETP Clear water pump #1" are updated
And verify if assets for "Table 22" for "FOPH ETP Clear water pump #2" are updated
And verify if assets for "Table 23" for "FOPH ETP Sludge disposal pump #1" are updated
And verify if assets for "Table 24" for "FOPH ETP Sludge disposal pump #2" are updated
And verify if assets for "Table 25" for "FOPH ETP Oil skimmer" are updated
And verify if assets for "Table 26" for "Transformer 10BHT07-AHP" are updated
And verify if assets for "Table 27" for "Transformer 10BHT08-AHP" are updated
And verify if assets for "Table 28" for "Transformer 10BHT13CT/AUX" are updated
And verify if assets for "Table 29" for "Transformer 10BHT14CT/AUX" are updated
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 8" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 9" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 10" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 11" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 12" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 13" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 14" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 15" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 16" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 17" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 18" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 19" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 20" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 21" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 22" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 23" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 24" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 25" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 26" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 27" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 28" is displayed on logsheet page and save in excel
Then verify "Ash Handling Plant and FOPH Log" Asset "Table 29" is displayed on logsheet page and save in excel
Then Logout of the application