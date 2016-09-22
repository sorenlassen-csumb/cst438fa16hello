Feature: Day
  As a user, I can get the day of week, so that I can tell if it's weekend.

  Scenario Outline: Dates
    When I request the day on <date>
    Then the day should be <day>

    Examples:
      | date      | day      |
      | 8/23/2016 | Tuesday  |
      | 8/25/2016 | Thursday |
