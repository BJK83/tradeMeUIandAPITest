@API
Feature: Title of your feature
  I want to use this template for my feature file

  @carMakesCount
  Scenario: number of named car makes
    Given I have basePath "getUsedCars"     
    When I execute Get request
    Then I verify the count of named cars in response to be "78"