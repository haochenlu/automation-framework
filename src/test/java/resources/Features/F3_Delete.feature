Feature: As a user I want to be able to delete features
  Background: User is logged in
    Given User is on the login page of the webpage
    When User enters a valid id and password
    And User clicks the login button
    Then User is redirected to the orders page

  Scenario: No changes should be made to an order if the user doesn't make any changes in the edit screen
    Given User is in the orders screen and at least one order exists
    When User edits an order
    And Doesn't make any changes before pressing update
    Then The order's details should remain the same

  Scenario: User should not see a table if all orders are deleted
    Given User is in the orders screen and at least one order exists
    When User deletes all orders
    Then The table is replaced by a message directing them to add orders

  Scenario: Pressing delete when no orders are checked should have no effect on the table
    Given User is in the orders screen and at least one order exists
    When the user presses delete selected button and no orders are selected
    Then The table remains the same

  Scenario: Pressing check all will check all the orders in the table
    Given User is in the orders screen and at least one order exists
    When the user presses the check all button
    Then All orders in the table are checked

  Scenario: Pressing uncheck all will uncheck all the orders in the table
    Given User is in the orders screen and at least one order exists
    When the user checks an order
    And presses the uncheck all button
    Then all checked orders become unchecked