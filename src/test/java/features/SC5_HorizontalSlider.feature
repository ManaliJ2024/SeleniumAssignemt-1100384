#Author: Archana Mali

   Feature: Verify Horizontal Slider and Frames Scenrio5
   
   Background: 
    Given browser is "chrome"

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

