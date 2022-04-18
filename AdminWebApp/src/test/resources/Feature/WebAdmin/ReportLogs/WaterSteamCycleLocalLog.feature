Feature: Water Steam Cycle Local Log Validations

#Scenario Outline: Verify if Water Steam Cycle Local Log page is displayed
 #Given Login into Scaffold Log Automation Application As Admin
#And verify if user logged in sucessfully
#When I click on menu icon
#Then Verify "Water Steam Cycle Local Log" page is displayed 
#And Verify table data
#
#
#Scenario Outline: Verify Download on water Steam Cycle Local Log page 
 #Given Login into Scaffold Log Automation Application As Admin
#And verify if user logged in sucessfully
#When I click on menu icon
#Then Verify "Water Steam Cycle Local Log" page is displayed 
#Then verify downloaded file

#Scenario Outline: Verify Search field on water Steam Cycle Local Log page 
 #Given Login into Scaffold Log Automation Application As Admin
#And verify if user logged in sucessfully
#When I click on menu icon
#Then Verify "Water Steam Cycle Local Log" page is displayed 
#And Search for result "searchInput"
#And Verify the search Result

Scenario Outline: Verify Search field on water Steam Cycle Local Log page 
 Given Login into Scaffold Log Automation Application As Admin
And verify if user logged in sucessfully
When I click on menu icon
Then Verify "Water Steam Cycle Local Log" page is displayed 
And Select Date from date picker
