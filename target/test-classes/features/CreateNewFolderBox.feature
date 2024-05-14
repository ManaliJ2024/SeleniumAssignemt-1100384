#Author       :  Archana Mali
#Scenario     :  Orange HRM login and verify the Title
#Application  :  Orange HRM application

Feature: Login into Orange HRM Feature

  Background: 
    Given browser is "chrome"

  @boxTokenGenarate
  Scenario Outline: Login into Orange HRM
    Given user navigates to the Box App
    When user enter the correct "<name>" and "<password>" and click on submit button
    Then Click on Dev Console
    And Click on folder name and Configuration tab
    Then Click on Generate Developer Token 
    Then Copy Dev token
        
    Examples: 
      | name       | password   | 
      | archana.mali@yash.com			 | Test1234 	| 
    