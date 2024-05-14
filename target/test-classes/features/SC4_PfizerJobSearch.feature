#Author: Archana Mali
Feature: Verify Pfizer Careers menu and Search Careers

  Background: 
    Given browser is "chrome"

  @SC4_PfizerJobSearch
  Scenario Outline: : Pfizer Scenrio4
    Given I navigate to Pfizer App
    When I Click on Careers menu and verify the page with its "<title>"
    When I Click on Search Careers button to view all jobs
    Then Verify the new page "<title1>"
    Then Search and view jobs for three locations using datatable
      | location     |
      | India - Mumbai |
      | India - Delhi  |
      | India - Remote |

    Examples: 
      | title             | title1           |        
      | Careers \| Pfizer | Search Results \| Pfizer |
