Feature: Login Page Validation

  Scenario Outline: Verify if user is able to login with valid AE credentials
  Given Navigate to scaffold JSW EMS web application
	Then Verify if login screen is displayed
  And I enter the username "<Username>"
  And I enter the password "<Password>"
  And I click on login button
  And Verify if user logged in sucessfully
  Then Logout of the application
  
  Examples:
  | Username               | Password |
  | ae.1@deliverain.com | welcome |

  