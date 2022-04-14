Feature: GeneratorLog

Scenario: Generator Main log display and validations
Given Login into Scaffold Log Automation Application As Admin
And verify if user logged in sucessfully
Then Navigate to Generator Main Log Report
And Verify if Generator Main Report log is displayed with the require fields


Scenario: Asset Validation and Historic data validation
Given Login into Scaffold Log Automation Application As Admin
And verify if user logged in sucessfully
Then Navigate to Generator Main Log Report
And verify if all the assets associated with Generator Main Report is displayed