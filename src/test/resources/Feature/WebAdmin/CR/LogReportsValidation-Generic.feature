Feature: Log Reports Validation

Scenario Outline: Validation of different sections in the Portal for admin profile
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
And click on the "Report" link
And click on the "<ReportLink>" link
And verify if "<ReportLink>" Report log page is displayed
Then Logout of the application

Examples:
|ReportLink|
|Plant Summary|
|Consolidated Reports|
|Equipment Status Log|
|MCR Boiler Log|
|Main Boiler Lancing Parameters|
|MCR TG and WSC Log|
|Boiler Local Log|
|Weekly Boiler Soot Blower Parameters|
|Turbine Local Log|
|Water Steam Cycle Local Log|
|Ash Handling Plant and FOPH Log|
|Lignite Handling Plant Log|
|Balance of Plant Log|
|DM Plant Log|
|Generator Hourly Log - Main|
|Generator Hourly Log - Check|
|Switchyard Log - I|
|UPS and Transformer - Log|
|Trivector Meter Voltage Log|
|Generator Transformer|
|MLDC Report Log|
|Switchyard Energy Meter Hourly Log - Main|
|Switchyard Energy Meter Hourly Log - Check|
|Shutdown Log|
|Clarifier Chemical Dosing Monitoring Local Log|
|Equipment Change Over Log|