Feature: As a user I want to be able to modify order details
  Background: User is logged in
    Given User is on the login page of the webpage
    When User enters a valid id and password
    And User clicks the login button
    Then User is redirected to the orders page

  Scenario: User should be able to delete an order
    Given User is in the orders screen and at least one order exists
    When user selects last order
    And presses delete selected button
    Then the order is no longer there

  Scenario Outline: User should be able to modify any order
    Given User is in the orders screen and at least 4 orders exist
    When The user modifies order details of the <index> th index order with a new name <name>, product <product>, amount <amount>, street <street>, city <city>, state <state>, zip <zip>, card <card>, card number <card number> and expiry <expiry>
    And Confirms order detail changes
    Then The changes are reflected in the order screen
    Examples:
      | index | name          | product       | amount | date         | street       | city       | state | zip     | card               | card number         | expiry  |
      | 1     | "Steph Curry" | "FamilyAlbum" | "4"    | "03/07/2010" | "54, Jack"   | "Red Deer" | "AB"  | "68878" | "MasterCard"       | "54445532552331123" | "08/21" |
      | 2     | "Steve Ball"  | "MyMoney"     | "2"    | "02/26/2010" | "33, Court"  | "Miami"    | "FL"  | "88782" | "Visa"             | "45223656673443221" | "01/26" |
      | 3     | "Harry Cane"  | "ScreenSaver" | "1"    | "02/15/2010" | "8, Fortune" | "Dallas"   | "TX"  | "97882" | "American Express" | "66230890229893421" | "09/09" |

  Scenario: Total should update when user changes quantity
    Given User is in the orders screen and at least one order exists
    When User edits an order
    And Changes the quantity
    And Presses the calculate button
    Then The total should be updated
