Feature: Hello friend
  As a user I want to be greeted by the name of my choice to become amused

  Scenario: Hello Alan
    Given I am on the hello page
    When I enter "Alan"
    Then I see the greeting "hello Alan"

  Scenario: Hello fails with empty name
    Given I am on the hello page
    When I enter ""
    Then I see an error message
