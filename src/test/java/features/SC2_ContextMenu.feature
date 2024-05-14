#Author: Archana Mali

 Feature: Verify Context Menu Alert scenario
 
  Background: 
    Given browser is "chrome"

  @SC2_contextMenuAlert
  Scenario: Context Menu alert check
    Given I navigate to herokuapp App context
    When select Context Menu
    When Right click on the dotted box
    Then get and print the "You selected a context menu" from alert
    And Accept the alert