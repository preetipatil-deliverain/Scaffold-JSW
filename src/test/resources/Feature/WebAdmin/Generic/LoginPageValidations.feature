Feature: Login Page Validation

  Scenario Outline: Verify if user is able to login with valid Admin credentials
  Given Navigate to scaffold v2 web application
	Then Verify if login screen is displayed
  And I enter the username "<Username>"
  And I enter the password "<Password>"
  And I click on login button
  And verify if user logged in sucessfully
  Then Logout of the application
  
  Examples:
  | Username               | Password |
  | vinod.r@deliverain.com | Test@123 |

  Scenario Outline: Verify if user is able to login with valid Reporter credentials
  Given Navigate to scaffold v2 web application
	Then Verify if login screen is displayed
  And I enter the username "<Username>"
  And I enter the password "<Password>"
  And I click on login button
  And verify if user logged in sucessfully
  Then Logout of the application
  
  Examples:
  | Username               | Password |
  | deepa.k@deliverain.com | Test@123 |
  
  
  Scenario Outline: Verify if user is able to login with invalid credentials
   Given Navigate to scaffold v2 web application
	Then Verify if login screen is displayed
  And I enter the username "<Username>"
  And I enter the password "<Password>"
  And I click on login button
  And verify if error message "<Message>" displayed
 
  
  Examples:
  | Username               | Password |Message|
  | xcvp@deliverain.com | Test@ |Incorrect Email or Password|
  
  Scenario Outline: Verify if error message is displayed if username and password are not entered
  Given Navigate to scaffold v2 web application
	Then Verify if login screen is displayed
  And I enter the username "<Username>"
  And I enter the password "<Password>"
  And I click on login button
  Then verify if error message "<Message1>" "<Message2>" displayed
 
  
  Examples:
  | Username               | Password |Message1|Message2|
  |  |  |Username field is required|Password field is required|
  
   Scenario Outline: Verify if error message is displayed if username is not entered
  Given Navigate to scaffold v2 web application
	Then Verify if login screen is displayed
  And I enter the username "<Username>"
  And I enter the password "<Password>"
  And I click on login button
  Then verify if error message "<Message1>" displayed for blank username field
 
  
  Examples:
  | Username               | Password |Message1|
  |  | Test@123 |Username field is required|

 Scenario Outline: Verify if error message is displayed if password is not entered
  Given Navigate to scaffold v2 web application
	Then Verify if login screen is displayed
  And I enter the username "<Username>"
  And I enter the password "<Password>"
  And I click on login button
  Then verify if error message "<Message1>" displayed for blank password field
 
  
  Examples:
  | Username               | Password |Message1|
  |preeti.p@deliverain.com |  |Password field is required|