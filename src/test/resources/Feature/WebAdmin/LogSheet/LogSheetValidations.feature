Feature: Log Sheet  Validations

Scenario Outline: Verify Log sheet 
 Given Navigate to scaffold v2 web application
	Then Verify if login screen is displayed
  And I enter the username "<Username>"
  And I enter the password "<Password>"
  And I click on login button
  And verify if user logged in sucessfully
  Then Click on save button
  
  Examples:
  | Username               | Password |
  | gokulrajesh.p@deliverain.com | Test@123 |