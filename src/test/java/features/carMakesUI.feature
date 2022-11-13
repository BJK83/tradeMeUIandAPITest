@UI
Feature: test the car makes and number of listings
  
  Scenario: get the count of listed named cars
    Given I am on TradeMe home page
    When I click on Motors search
    Then I evaluate count of all named cars "78"


  Scenario Outline: get the count of listings for specific car makes
    Given I am on TradeMe home page
    When I click on Motors search
    And search for car make "<carMake>"
    Then I evaluate the count of total listings for the "<carMake>" 

    Examples: 
      | carMake  |
      | Ferrari |
      | BMW |
      | Mazda |
      | Honda |