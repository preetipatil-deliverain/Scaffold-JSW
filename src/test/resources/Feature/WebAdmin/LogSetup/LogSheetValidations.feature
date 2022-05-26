Feature: Log Sheet  Validations

Scenario Outline: Validation of Log Sheet Page Table headers displayed
Given Login into Scaffold Log Automation Application As "Admin"
And verify if user logged in sucessfully
When I click on menu icon
Then click on the "Log Sheet" link
And Validate if log sheet is displayed with default display as "Water Steam Cycle Local Log"

Then verify Asset headers "Gauge Name" displayed in logsheet page
Then verify Asset headers "Code" displayed in logsheet page
Then verify Asset headers "Status" displayed in logsheet page
Then verify Asset headers "Display" displayed in logsheet page
Then verify Asset headers "Enabled" displayed in logsheet page
Then verify Asset headers "Mandatory" displayed in logsheet page
Then verify Asset headers "Min Value" displayed in logsheet page
Then verify Asset headers "Max Value" displayed in logsheet page