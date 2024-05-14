#Author       :  Archana Mali
#Scenario     :  Orange HRM login and verify the Title
#Application  :  Orange HRM application

Feature: Login into Orange HRM Feature

  Background: 
    Given browser is "chrome"

  @orangeHRMLoginScenario
  Scenario Outline: Login into Orange HRM
    Given user navigates to the Orange HRM App
    When user enter the correct "<name>" and "<password>" and Login to the app
    Then user verify the "<title>" in the app
    Then verify orangeHRM logo on dashboard
    
    Examples: 
      | name       | password   | title     |
      | Admin			 | admin123 	| OrangeHRM | 
    