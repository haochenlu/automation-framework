Feature: As a user I want to be able to log in to the order platform

  Scenario: User should be able to log in to the website with valid credentials
    Given User is on the login page of the webpage
    When User enters a valid id and password
    And User clicks the login button
    Then User is redirected to the orders page

  Scenario: User should not be able to log in with invalid credentials
    Given User is on the login page of the webpage
    When User enters an invalid id and password
    And User clicks the login button
    Then User sees a login error message

  Scenario: User should be able to log in to the website with valid credentials
    Given User is on the login page of the webpage
    When User enters a valid id and password
    And presses the enter key
    Then User is redirected to the orders page