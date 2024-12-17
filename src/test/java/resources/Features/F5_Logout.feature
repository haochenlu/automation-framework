Feature: As a user I want to be able to log out
  Background: User is logged in
    Given User is on the login page of the webpage
    When User enters a valid id and password
    And User clicks the login button
    Then User is redirected to the orders page

  Scenario: User can log out of the application
    Given user is logged in
    When user presses the logout button
    Then user is returned to the log in page

#  Scenario: Data does not persist after logging out
#    Given User is in the orders screen and at least one order exists
#    When User deletes all orders
#    And user presses the logout button
#    And logs back in
#    Then the orders table is reset to defaults

  #this step should fail
    Scenario: Data persists after logging out
    Given User is in the orders screen and at least one order exists
    When User deletes all orders
    And user presses the logout button
    And logs back in
    Then the orders table remains empty