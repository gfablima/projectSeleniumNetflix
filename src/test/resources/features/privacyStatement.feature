@netflixPrivacyStatement
Feature: Privacy Statement

  The Privacy Statement feature explains the practices, use and disclosure of certain
  information by Netflix.

  Background:
    Given the user is at Netflix website

  @scenarioDownloadLinkIsAvailable
  Scenario: Availability of prior version of the Privacy Statement
    Given the user is at Privacy page
    When the user chooses to see prior version of the privacy statement
    Then the link to download document must be available
