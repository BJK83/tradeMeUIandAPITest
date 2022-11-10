@API
Feature: Title of your feature
  I want to use this template for my feature file

  @carMakesCount
  Scenario: number of named car makes
    Given I have end points    
    When I execute Get request
    Then I have a list of car makes returned
    And I verify the count of named cars