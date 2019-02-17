@netflixSignInFeature
Feature: Sign In in Netflix website

  The Sign In feature allows the user to have access to all Netflix content.

  Background:
    Given the user is at Netflix website

  @scenarioLoginWithInvalidCredentials
  Scenario: Service unavailable after seven failed attempts to sign in
    Given the user is at Sign In page
    When the user enters invalid credentials to Login
      | erg6dfg129@gmail.com | 123r4 |
      | inval3rfq2@gmail.com | @3cd3 |
    Then the application must display the error message "Sorry, we can't find an account with this email address."