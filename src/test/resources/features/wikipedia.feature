Feature: HomePage apps functionality
  Background:

  @wip
  Scenario: Open wikipedia and verify language
    When User opens "Wikipedia" application
    Then User verifies default statement contains "English"