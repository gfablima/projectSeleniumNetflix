@netflixRedeemGiftCardFeature
Feature: Redeem Gift Card

  The Redeem Gift Card feature allows the user to enter a gift card code and redeem credits
  In order to pay for any streaming plan.

  Background:
    Given the user is at Netflix website

  @scenarioRedeemInvalidGiftCard
  Scenario: Redeem invalid gift card
    Given the user is at Redeem Gift Card page
    When the user redeems the invalid gift card code "INVALID"
    Then the error message "The code entered is not valid." is shown
