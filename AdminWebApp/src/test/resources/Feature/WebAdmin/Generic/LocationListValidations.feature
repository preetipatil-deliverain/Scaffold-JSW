Feature: User List  Validations

#Scenario Outline: Verify if Location List page is displayed
 #Given Login into Scaffold Log Automation Application As Admin
#And verify if user logged in sucessfully
#When I click on menu icon
#Then Click on Locations option
#And Verify Location List page is displayed 
#
 #Scenario Outline: Verify if all headers are displayed in the table
 #Given Login into Scaffold Log Automation Application As Admin
#And verify if user logged in sucessfully
#When I click on menu icon
#Then Click on Locations option
#And Verify Location List page is displayed 
#Then verify All headers "<Headers>" are displayed on Location List table
#Examples:
#|Headers|
#|Location Name|
#|Status|
#|Created By|
#|Last Modified By|
#|Last Modified On|
#|Action|

#Scenario Outline: Verify Action is displayed in the table
 #Given Navigate to scaffold v2 web application
#	Then Verify if login screen is displayed
  #And I enter the username "<Username>"
  #And I enter the password "<Password>"
  #And I click on login button
  #And verify if user logged in sucessfully
  #When I click on menu icon
#Then Click on Locations option
#And Verify Location List page is displayed 
  #Then verify Edit link is displayed on the location list table
  #
  #Examples:
  #| Username               | Password |
  #| vinod.r@deliverain.com | Test@123 |

#Scenario Outline: Verify if user is able to add the record on location list table
 #Given Navigate to scaffold v2 web application
#	Then Verify if login screen is displayed
  #And I enter the username "<Username>"
  #And I enter the password "<Password>"
  #And I click on login button
  #And verify if user logged in sucessfully
  #When I click on menu icon
#Then Click on Locations option
#And Verify Location List page is displayed 
  #And Click on Add Record button
  #Then I create a Location
  #And Verify Location is created successfuly
  #
  #Examples:
  #| Username               | Password |
  #| vinod.r@deliverain.com | Test@123 |


Scenario Outline: Verify if user is able to add the record on location list table
 Given Navigate to scaffold v2 web application
	Then Verify if login screen is displayed
  And I enter the username "<Username>"
  And I enter the password "<Password>"
  And I click on login button
  And verify if user logged in sucessfully
  When I click on menu icon
Then Click on Locations option
And Verify Location List page is displayed 
  And Click on Add Record button
  Then I create a Location and click on cancel button
  And Verify Location List page is displayed
  
  Examples:
  | Username               | Password |
  | vinod.r@deliverain.com | Test@123 |
