Feature: User List  Validations

 Scenario Outline: Verify if all headers are displayed in the table
 Given Login into Scaffold Log Automation Application As Admin
And verify if user logged in sucessfully
Then verify All headers "<Headers>" are displayed
Examples:
|Headers|
|First Name|
|Email|
|Role|
|Location|
|Shift|
|Phone|
|Action|

Scenario Outline: Verify Action is displayed in the table
 Given Navigate to scaffold v2 web application
	Then Verify if login screen is displayed
  And I enter the username "<Username>"
  And I enter the password "<Password>"
  And I click on login button
  And verify if user logged in sucessfully
  Then verify Action buttons are displayed
  
  Examples:
  | Username               | Password |
  | vinod.r@deliverain.com | Test@123 |
  
  
  
 Scenario Outline: Verify if the newly added record is deleted
 Given Login into Scaffold Log Automation Application As Admin
And verify if user logged in sucessfully
And Click on Add Record button
#Then I Create user "<FirstName>" "<LastName>" "<EmployeeID>" "<Role>" "<ReportingTo>" "<PrimaryLocation>" "<SecondaryLocation 1>" "<SecondaryLocation 2>" "<EmailAddress>" "<PhoneNumber>" "<Password>"
#|First Name|Last Name|Employee ID|Role|Reporting To|Primary Location|Secondary Location 1|Secondary Location 2|Email Address|Phone Number|Password|
#|user1|user1|1234|Operator|Test User User|ASCE|Turbine DCS|Turbine DCS|user1@deliverain.com|9876543210|Test@123|
Then I Create user
And I delete a record

Scenario Outline: Verify if the newly added record is edited
 Given Login into Scaffold Log Automation Application As Admin
And verify if user logged in sucessfully
And Click on Add Record button
Then I Create user
And Click on edit 
And I edit a record
Then Verify the changes

Scenario Outline: Verify user list page is displayed if cancel button is click on create user page 
 Given Login into Scaffold Log Automation Application As Admin
And verify if user logged in sucessfully
And Click on Add Record button
Then Click on cancel button on create user page
And Verify the user list page 



  
 
 
  
  
  
  