Feature: 24Hour Report Log

Scenario: Validation of different sections in the Portal for admin profile
Given Login into Scaffold Log Automation Application As Admin
And verify if user logged in sucessfully
Then verify if "24Hr Log Report" report links are displayed
And click on the "24Hr Log Report" link
And verify if "24Hr Log Report" Report log page is displayed
And verify if Filters Overview is displayed
And 
Then Logout of the application