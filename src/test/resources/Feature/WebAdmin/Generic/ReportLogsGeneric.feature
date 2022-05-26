Feature: Report logs - General

Scenario Outline: Validation of different sections in the Portal for admin profile
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
Then verify if "<Section>" section is displayed
And Logout of the application

Examples:
|Section|
|Home|
|Administration|
|Analytics|
|Report|