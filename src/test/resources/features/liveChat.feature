@netflixLiveChatFeature
Feature: Live Chat

  The Live Chat feature allows the user to talk to Netflix online support
  In order to get information or solve a problem related to the application.

  Background:
    Given the user is at Netflix website

  @scenarioStartLiveChat
  Scenario: Start live chat as non-member
    Given the user is at Contact Us page
    When the user chooses to start a live chat
    And the user inserts the issue "Access denied"
    And the user is not a member
    Then the live chat pops up displaying the title "Netflix Customer Service"