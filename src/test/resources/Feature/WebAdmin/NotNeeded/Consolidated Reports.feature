Feature: Generator Check Log Validations

Scenario: Validation of Generator Main log displayed
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
Then Navigate to Generator Check Log Report

Scenario: Asset Validation and Historic data validation
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
Then Validate all the assets displayed in Generator Check log