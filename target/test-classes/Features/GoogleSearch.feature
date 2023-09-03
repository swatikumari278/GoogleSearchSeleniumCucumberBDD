@smoke
Feature: Google Search

  Scenario Outline: Search product in google
    Given User in on Google Page
    When User searches for the <product> on the google page
    Then Searched <product> should be visible

    Examples: 
      | product  |
      | tomato   |
      | beetroot |


 Scenario Outline: Search product in google using excel test data
    Given User in on Google Page
    When User searches the product in "<SheetName>" with <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | ProductList |         0 |