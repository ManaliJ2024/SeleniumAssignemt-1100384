@pfizer
Feature: Verify Pfizer Science menu Scenrio3

  Background: 
    Given browser is "chrome"

  @SC3_pfizerScienceMenu
  Scenario Outline: Pfizer Science menu Scenrio3
    Given I navigate to Pfizer App
    When I Hover over Science menu
    When I Hover over clinical trials sub menu
    Then Click on clinical Trials in Children
    Then Verify "<title>" of this page with one given in feature
    And Scroll down and click "Go to Pfizer Clinical Trials Site" link
    And Again Verify "<title1>" of this page with one given in feature
    Then Scroll down to page footer and click on "The Breakthrough newsletter"
    And In the new page, Again Verify "<title2>" of this page with one given in feature

    Examples: 
      | title                                 | title1                                              | title2               |        
      | Clinical Trials for Children \| Pfize | Pfizer Clinical Trials \| Official Participant Site | Stories Subscription \| Pfizer |

      
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