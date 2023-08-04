@Batch2
Feature: Weekly Boiler Soot Blower Parameters Log Setup

Scenario Outline: Verify Weekly Boiler Soot Blower Parameters Log sheet Test Data Stored on Excel sheet 
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on Administrator Menu
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"
Then Select "Weekly Boiler Soot Blower Parameters" Log Sheet
And I verify if "Weekly Boiler Soot Blower Parameters" is selected in the drop down
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
And Enter assets for "Table 1" for "Group3-20AT028(Right Side)"
And Enter assets for "Table 2" for "Group3-20AT027(Right Side)"
And Enter assets for "Table 3" for "Group3-20AT026(Right Side)"
And Enter assets for "Table 4" for "Group3-20AT025(Right Side)"
And Enter assets for "Table 5" for "Group4-20AT024(Right Side)"
And Enter assets for "Table 6" for "Group4-20AT023(Right Side)"
And Enter assets for "Table 7" for "Group4-20AT022(Right Side)"
And Enter assets for "Table 8" for "Group4-20AT021(Right Side)"
And Enter assets for "Table 9" for "Group5-20AT020(Right Side)"
And Enter assets for "Table 10" for "Group5-20AT019(Right Side)"
And Enter assets for "Table 11" for "Group6-20AT018(Right Side)"
And Enter assets for "Table 12" for "Group6-20AT017(Right Side)"
And Enter assets for "Table 13" for "Group7-20AT016(Right Side)"
And Enter assets for "Table 14" for "Group7-20AT015(Right Side)"
And Enter assets for "Table 15" for "Group7-20AT014(Right Side)"
And Enter assets for "Table 16" for "Group7-20AT013(Right Side)"
And Enter assets for "Table 17" for "Group8-20AT012(Right Side)"
And Enter assets for "Table 18" for "Group8-20AT011(Right Side)"
And Enter assets for "Table 19" for "Group8-20AT010(Right Side)"
And Enter assets for "Table 20" for "Group8-20AT009(Right Side)"
And Enter assets for "Table 21" for "Group9-20AT008(Right Side)"
And Enter assets for "Table 22" for "Group9-20AT007(Right Side)"
And Enter assets for "Table 23" for "Group9-20AT006(Right Side)"
And Enter assets for "Table 24" for "Group9-20AT005(Right Side)"
And Enter assets for "Table 25" for "Group10-20AT004(Right Side)"
And Enter assets for "Table 26" for "Group10-20AT003(Right Side)"
And Enter assets for "Table 27" for "Group10-20AT002(Right Side)"
And Enter assets for "Table 28" for "Group10-20AT001(Right Side)"
And Enter assets for "Table 29" for "Group11-11AT001(Right Side)"
And Enter assets for "Table 30" for "Group3-21AT028(Left Side)"
And Enter assets for "Table 31" for "Group3-21AT027(Left Side)"
And Enter assets for "Table 32" for "Group3-21AT026(Left Side)"
And Enter assets for "Table 33" for "Group3-21AT025(Left Side)"
And Enter assets for "Table 34" for "Group4-21AT024(Left Side)"
And Enter assets for "Table 35" for "Group4-21AT023(Left Side)"
And Enter assets for "Table 36" for "Group4-21AT022(Left Side)"
And Enter assets for "Table 37" for "Group4-21AT021(Left Side)"
And Enter assets for "Table 38" for "Group5-21AT020(Left Side)"
And Enter assets for "Table 39" for "Group5-21AT019(Left Side)"
And Enter assets for "Table 40" for "Group6-21AT018(Left Side)"
And Enter assets for "Table 41" for "Group6-21AT017(Left Side)"
And Enter assets for "Table 42" for "Group7-21AT016(Left Side)"
And Enter assets for "Table 43" for "Group7-21AT015(Left Side)"
And Enter assets for "Table 44" for "Group7-21AT014(Left Side)"
And Enter assets for "Table 45" for "Group7-21AT013(Left Side)"
And Enter assets for "Table 46" for "Group8-21AT012(Left Side)"
And Enter assets for "Table 47" for "Group8-21AT011(Left Side)"
And Enter assets for "Table 48" for "Group8-21AT010(Left Side)"
And Enter assets for "Table 49" for "Group8-21AT009(Left Side)"
And Enter assets for "Table 50" for "Group9-21AT008(Left Side)"
And Enter assets for "Table 51" for "Group9-21AT007(Left Side)"
And Enter assets for "Table 52" for "Group9-21AT006(Left Side)"
And Enter assets for "Table 53" for "Group9-21AT005(Left Side)"
And Enter assets for "Table 54" for "Group10-21AT004(Left Side)"
And Enter assets for "Table 55" for "Group10-21AT003(Left Side)"
And Enter assets for "Table 56" for "Group10-21AT002(Left Side)"
And Enter assets for "Table 57" for "Group10-21AT001(Left Side)"
And Enter assets for "Table 58" for "Group11-21AT001(Left Side)"

Then Click on Save and Continue button
And verify if assets for "Table 1" for "Group3-20AT028(Right Side)" are updated
And verify if assets for "Table 2" for "Group3-20AT027(Right Side)" are updated
And verify if assets for "Table 3" for "Group3-20AT026(Right Side)" are updated
And verify if assets for "Table 4" for "Group3-20AT025(Right Side)" are updated
And verify if assets for "Table 5" for "Group4-20AT024(Right Side)" are updated
And verify if assets for "Table 6" for "Group4-20AT023(Right Side)" are updated
And verify if assets for "Table 7" for "Group4-20AT022(Right Side)" are updated
And verify if assets for "Table 8" for "Group4-20AT021(Right Side)" are updated
And verify if assets for "Table 9" for "Group5-20AT020(Right Side)" are updated
And verify if assets for "Table 10" for "Group5-20AT019(Right Side)" are updated
And verify if assets for "Table 11" for "Group6-20AT018(Right Side)" are updated
And verify if assets for "Table 12" for "Group6-20AT017(Right Side)" are updated
And verify if assets for "Table 13" for "Group7-20AT016(Right Side)" are updated
And verify if assets for "Table 14" for "Group7-20AT015(Right Side)" are updated
And verify if assets for "Table 15" for "Group7-20AT014(Right Side)" are updated
And verify if assets for "Table 16" for "Group7-20AT013(Right Side)" are updated
And verify if assets for "Table 17" for "Group8-20AT012(Right Side)" are updated
And verify if assets for "Table 18" for "Group8-20AT011(Right Side)" are updated
And verify if assets for "Table 19" for "Group8-20AT010(Right Side)" are updated
And verify if assets for "Table 20" for "Group8-20AT009(Right Side)" are updated
And verify if assets for "Table 21" for "Group9-20AT008(Right Side)" are updated
And verify if assets for "Table 22" for "Group9-20AT007(Right Side)" are updated
And verify if assets for "Table 23" for "Group9-20AT006(Right Side)" are updated
And verify if assets for "Table 24" for "Group9-20AT005(Right Side)" are updated
And verify if assets for "Table 25" for "Group10-20AT004(Right Side)" are updated
And verify if assets for "Table 26" for "Group10-20AT003(Right Side)" are updated
And verify if assets for "Table 27" for "Group10-20AT002(Right Side)" are updated
And verify if assets for "Table 28" for "Group10-20AT001(Right Side)" are updated
And verify if assets for "Table 29" for "Group11-11AT001(Right Side)" are updated
And verify if assets for "Table 30" for "Group3-21AT028(Left Side)" are updated
And verify if assets for "Table 31" for "Group3-21AT027(Left Side)" are updated
And verify if assets for "Table 32" for "Group3-21AT026(Left Side)" are updated
And verify if assets for "Table 33" for "Group3-21AT025(Left Side)" are updated
And verify if assets for "Table 34" for "Group4-21AT024(Left Side)" are updated
And verify if assets for "Table 35" for "Group4-21AT023(Left Side)" are updated
And verify if assets for "Table 36" for "Group4-21AT022(Left Side)" are updated
And verify if assets for "Table 37" for "Group4-21AT021(Left Side)" are updated
And verify if assets for "Table 38" for "Group5-21AT020(Left Side)" are updated
And verify if assets for "Table 39" for "Group5-21AT019(Left Side)" are updated
And verify if assets for "Table 40" for "Group6-21AT018(Left Side)" are updated
And verify if assets for "Table 41" for "Group6-21AT017(Left Side)" are updated
And verify if assets for "Table 42" for "Group7-21AT016(Left Side)" are updated
And verify if assets for "Table 43" for "Group7-21AT015(Left Side)" are updated
And verify if assets for "Table 44" for "Group7-21AT014(Left Side)" are updated
And verify if assets for "Table 45" for "Group7-21AT013(Left Side)" are updated
And verify if assets for "Table 46" for "Group8-21AT012(Left Side)" are updated
And verify if assets for "Table 47" for "Group8-21AT011(Left Side)" are updated
And verify if assets for "Table 48" for "Group8-21AT010(Left Side)" are updated
And verify if assets for "Table 49" for "Group8-21AT009(Left Side)" are updated
And verify if assets for "Table 50" for "Group9-21AT008(Left Side)" are updated
And verify if assets for "Table 51" for "Group9-21AT007(Left Side)" are updated
And verify if assets for "Table 52" for "Group9-21AT006(Left Side)" are updated
And verify if assets for "Table 53" for "Group9-21AT005(Left Side)" are updated
And verify if assets for "Table 54" for "Group10-21AT004(Left Side)" are updated
And verify if assets for "Table 55" for "Group10-21AT003(Left Side)" are updated
And verify if assets for "Table 56" for "Group10-21AT002(Left Side)" are updated
And verify if assets for "Table 57" for "Group10-21AT001(Left Side)" are updated
And verify if assets for "Table 58" for "Group11-21AT001(Left Side)" are updated



Then verify "WeeklyBoilerSoot" Asset "Table 1" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 2" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 3" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 4" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 5" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 6" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 7" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 8" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 9" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 10" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 11" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 12" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 13" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 14" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 15" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 16" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 17" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 18" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 19" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 20" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 21" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 22" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 23" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 24" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 25" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 26" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 27" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 28" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 29" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 30" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 31" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 32" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 33" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 34" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 35" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 36" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 37" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 38" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 39" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 40" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 41" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 42" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 43" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 44" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 45" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 46" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 47" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 48" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 49" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 50" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 51" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 52" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 53" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 54" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 55" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 56" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 57" is displayed on logsheet page and save in excel
Then verify "WeeklyBoilerSoot" Asset "Table 58" is displayed on logsheet page and save in excel

Then Logout of the application