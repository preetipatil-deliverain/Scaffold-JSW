Feature: Log Reports Validation

Scenario Outline: Validation of different sections in the Portal for admin profile
Given Login into Scaffold Log Automation Application As Admin
And verify if user logged in sucessfully
Then verify if "<ReportLink>" report links are displayed
And click on the "<ReportLink>" link
And verify if "<ReportLink>" Report log page is displayed
Then Logout of the application

Examples:
|ReportLink|
|24Hr Log Report|
|Consolidated Reports|
|Water Steam Cycle Local Log|
|Generator Hourly Log - Main|
|Generator Hourly Log - Check|
|Turbine Local Log|
|MCR TG and WSC Log|
|Switchyard Energy Meter Hourly Log - Main|
|Switchyard Energy Meter Hourly Log - Check|
|Switchyard Log - I|
|MCR Boiler Log|
|Boiler Local Log|
|UPS and Transformer - Log|
|MLDC Report Log|
|Equipment Status Log|
|Ash Handling Plant and FOPH Operator Assistant Log|
|Auxiliary Boiler Log|
|Balance of Plant Operator Assistant Log|
|Clarifier Chemical Dosing Monitoring Local Log|
|Balance of Plant Log|
|Ash Handling Plant and FOPH Log|
|Lignite Handling Plant Log|
|DM Plant Log|
|Shutdown Log|
|24 Hours - Switchyard|
|24 Hours - Boiler DCS|
|24 Hours - Turbine DCS|
|24 Hours- Switchyard (PLCC)|
|24 Hours- AHP|
|24 Hours- Boiler Field|
|24 Hours- LHP|
|24 Hours- Turbine Local|
|24 Hours- DM and BOPP|
|Day Shift - DM Plant Log|
|Equipment Change Over Log|