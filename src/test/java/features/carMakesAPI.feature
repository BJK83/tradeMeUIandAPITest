@API
Feature: Execute get request on trademe sandbox and verify the number of named carMakes

  @carMakesCount
  Scenario: number of named car makes
    Given I have basePath "getUsedCars"     
    When I execute Get request
    Then I verify the count of named cars in response to be "78"