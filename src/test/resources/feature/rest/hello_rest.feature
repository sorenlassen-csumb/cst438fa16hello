Feature: Hello REST
  As an API user I want to be greeted by the name of my choice to become amused

  Scenario: Hello Alan
    When I call hello endpoint with "Alan"
    Then the reponse status code is 200
     And the message body is "hello Alan"

  Scenario: Hello fails with empty name
    When I call hello endpoint with ""
    Then the reponse status code is 400
