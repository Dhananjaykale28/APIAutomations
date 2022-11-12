@LoginFeature
Feature: Login Functionality for Knowledgeware
  I want to use this template for my Loginn functionality testing 

  @ValidLogin 
  Scenario: Validate I should be login with valid credentials
    Given I should have valid credentials
    And I should have chrome browser open
    When I enter username
    And I enter password
    And I enter confirmpassword 
    And I click on login button
    Then I should succesfully logged in 
    And I can see logout button
    
   @InValidLogin 
 	 Scenario: Validate I should be login with invalid credentials
    Given I should have invalid credentials
    And I should have chrome browser open
    When I enter username
    And I enter password
    And I enter confirmpassword 
    And I click on login button
    Then I should succesfully logged in 
    And I can see logout button
    

  