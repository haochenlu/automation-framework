package com.haochenlu.stepdefinitions;

import com.haochenlu.pojos.OrderData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class F2_Order_Step {
    int numOrders;
    int editIndex;
    OrderData cachedOrder;
    @Given("User is in the orders screen and at least {int} orders exist")
    public void user_is_in_the_orders_screen_and_at_least_orders_exist(Integer int1) {
        Hooks.driver.navigate().to(Hooks.properties.getProperty("orderURL"));
        assertTrue(Hooks.ordersPage.getNumOrders() >= int1);
    }
    @When("The user modifies order details of the {int} th index order with a new name {string}, product {string}, amount {string}, street {string}, city {string}, state {string}, zip {string}, card {string}, card number {string} and expiry {string}")
    public void the_user_modifies_order_details_of_the_th_index_order_with_a_new_name_product_amount_street_city_state_zip_card_card_number_and_expiry(Integer index, String name, String product, String amount, String street, String city, String state, String zip, String card, String cardNumber, String expiry) {
        // Write code here that turns the phrase above into concrete actions
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        editIndex = index;
        Hooks.ordersPage.editOrderIndex(index);
        Hooks.editPage.selectProduct(product);
        Hooks.editPage.setCustomerName(name);
        Hooks.editPage.setQuantity(amount);
        Hooks.editPage.setCardExpiry(expiry);
        Hooks.editPage.setCardNumber(cardNumber);
        Hooks.editPage.setCustomerCity(city);
        Hooks.editPage.setCustomerState(state);
        Hooks.editPage.selectCardRadio(card);
        Hooks.editPage.setCustomerZip(zip);
        Hooks.editPage.setCustomerStreet(street);
        cachedOrder = new OrderData(name, product, amount, formattedDate, street, city, state, zip, card, cardNumber, expiry);
    }
    @When("Confirms order detail changes")
    public void confirms_order_detail_changes() {
        Hooks.editPage.confirmChanges();
    }
    @Then("The changes are reflected in the order screen")
    public void the_changes_are_reflected_in_the_order_screen() {
        assertEquals(Hooks.ordersPage.getOrderDataAtIndex(editIndex), cachedOrder);
    }

    @Given("User is in the orders screen and at least one order exists")
    public void user_is_in_the_orders_screen_and_at_least_one_order_exists() {
        Hooks.driver.navigate().to(Hooks.properties.getProperty("orderURL"));
        assertTrue(Hooks.ordersPage.getNumOrders() >= 1);
    }
    @When("user selects last order")
    public void user_selects_last_order() {
        numOrders = Hooks.ordersPage.getNumOrders();
        Hooks.ordersPage.checkAtIndex(numOrders - 1);
    }
    @When("presses delete selected button")
    public void presses_delete_selected_button() {
        Hooks.ordersPage.pressDelete();
    }
    @Then("the order is no longer there")
    public void the_order_is_no_longer_there() {
        assertTrue(Hooks.ordersPage.getNumOrders() < numOrders);
    }

    @When("User edits an order")
    public void user_edits_an_order() {
        cachedOrder = Hooks.ordersPage.getOrderDataAtIndex(0);
        Hooks.ordersPage.editOrderIndex(0);
    }

    @When("Doesn't make any changes before pressing update")
    public void doesn_t_make_any_changes_before_pressing_update() {
        Hooks.editPage.confirmChanges();
    }

    @Then("The order's details should remain the same")
    public void the_order_s_details_should_remain_the_same() {
        assertEquals(cachedOrder, Hooks.ordersPage.getOrderDataAtIndex(0));
    }

    @When("Changes the quantity")
    public void changes_the_quantity() {
        Hooks.editPage.setQuantity("10");
    }
    @When("Presses the calculate button")
    public void presses_the_calculate_button() {
        Hooks.editPage.pressCalculate();
    }
    @Then("The total should be updated")
    public void the_total_should_be_updated() {
        assertEquals(Integer.valueOf(Hooks.editPage.getTotal()).intValue(),
                Integer.parseInt(Hooks.editPage.getPrice()) * Integer.parseInt(Hooks.editPage.getQuantity()));
    }
}
