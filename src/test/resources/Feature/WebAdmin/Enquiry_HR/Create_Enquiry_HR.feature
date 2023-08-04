Feature: Create Enquiry-HR

  Scenario Outline: Create Enquiry- HR request
    Given Navigate to scaffold JSW EMS web application
    Then Verify if login screen is displayed
    When Login into Enquiry management system As "AE"
    And Verify if user logged in sucessfully
    Then Click on create new enquiry
    Then Select Product or category "HR"
    And Verify the Basic information page is displayed for "Create Enquiry - HR"
    Then Verify the mandatory fields are present
    And Verify the Product dropdown values
    Then Select the product
    Then Select the customer name
    Then Select the specification
    Then Select the supply condition
    Then Select the material delivery time
    And Enter the basic infrormation "HR"
    When Click on next button
    #And Verify the order details page is displayed
    And Verify the "Order Details" page is displayed
    Then Enter the order details "HR"
    And Click on next button
    And Verify the "Application of Material" page is displayed
    When Select the Application of material checkbox
    And Click on next button
    And Verify the "Process Flow at Customer End" page is displayed
    Then Enter the process flow at customer end from "HR"
    And Click on next button
    And Verify the "Chemical Composition" page is displayed
    Then Select the Chemical Composition from "HR"
    And Click on next button
    And Verify the "Mechanical Properties" page is displayed
    Then Select the Mechanical Properties from "HR"
    And Click on next button
    And Verify the "Additional Requirements – Attach Component Photograph" page is displayed
    Then Upload the image for the additional requirements
    And Click on next button
    And Verify the "User Comments" page is displayed
    Then Enter the user comments from "HR"
    When Click on submit button
    
    
