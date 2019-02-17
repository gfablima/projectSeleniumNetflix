@netflixSearchInHelpCenterFeature
Feature: Search at Help Center page

  The Help Center page allows the user to search for help by entering
  Keywords in the search bar and displays a list of results.

  Background:
    Given the user is at Netflix website

  @scenarioClassifyArticleAsNotHelpful
  Scenario: Evaluate first result as not helpful
    Given the user is at Help Center page
    When the user searches for keyword "watch"
    And the user evaluates the first result as not helpful
    Then the message "Thanks for your feedback." is shown
