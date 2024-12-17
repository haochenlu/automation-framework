Feature: As a user I want to be able to add new orders
  Background: User is logged in
    Given User is on the login page of the webpage
    When User enters a valid id and password
    And User clicks the login button
    Then User is redirected to the orders page

  Scenario: User can add new orders when all required fields are filled
    Given User is logged in and on the order page
    When User fills in required fields in order page
    And presses Process button
    Then user sees their new order at the top of the order list

  Scenario: User cannot add new orders when a required field is not filled
    Given User is logged in and on the order page
    When User fills in form but is missing a required field
    And presses Process button
    Then user sees an error message beside the missing field

  Scenario: User can reset all fields by pressing the reset button
    Given User is logged in and on the order page
    When User fills in required fields in order page
    And presses reset button
    Then no fields contain non-default values