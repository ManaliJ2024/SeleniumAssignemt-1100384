
@herokaupp
Feature: Add and Remove Elements


  Background: 
    Given browser is "chrome"
  
  @SC1_herokuappScenario 
  Scenario: Add and Remove Elements with Data Table
  	Given I navigate to herokuapp App
    And I select Add/Remove Elements
    When I add the following elements
      | Number of Elements |
      | 5                  |
    Then I delete the following elements
      | Number of Elements |
      | 5                  |
      
      
   @SC2_contextMenuAlert
  Scenario: Context Menu alert check
    Given I navigate to herokuapp App context
    When select Context Menu
    When Right click on the dotted box
    Then get and print the "You selected a context menu" from alert
    And Accept the alert
    
  @SC5_horizontalSlider
  Scenario: Horizontal Slider and Frames Scenrio5
    Given I navigate to herokuapp App Horizontal
    And I select Horizontal Slider
    Then Move the slider to "3.5" value
    When Click on browser back
    Then I Select Frames
    Then Select iframe
    And In the new page, delete all the previous content and write "welcome"
    And Select the content with "Ctrl+A" and make bold with "Ctrl+B"
      
      