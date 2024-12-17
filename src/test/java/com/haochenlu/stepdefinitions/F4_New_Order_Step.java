package com.haochenlu.stepdefinitions;

import com.haochenlu.pojos.OrderData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class F4_New_Order_Step {
    OrderData cachedOrder;

    @Given("User is logged in and on the order page")
    public void user_is_logged_in_and_on_the_order_page() {
        Hooks.driver.navigate().to(Hooks.properties.getProperty("newOrderURL"));
    }

    @When("presses Process button")
    public void presses_process_button() {
        Hooks.newOrderPage.processOrder();
    }

    @Then("user sees their new order at the top of the order list")
    public void user_sees_their_new_order_at_the_top_of_the_order_list() {
        Hooks.driver.navigate().to(Hooks.properties.getProperty("orderURL"));
        assertEquals(cachedOrder, Hooks.ordersPage.getOrderDataAtIndex(0));
    }

    @When("User fills in form but is missing a required field")
    public void user_fills_in_form_but_is_missing_a_required_field() {
        Hooks.newOrderPage.setQuantity("4");
        Hooks.newOrderPage.setCustomerName("Bob");
        Hooks.newOrderPage.setCustomerStreet("Any");
        Hooks.newOrderPage.setCustomerCity("Anytown");
        Hooks.newOrderPage.setCustomerState("US");
        Hooks.newOrderPage.setCustomerZip("55323");
        Hooks.newOrderPage.setCardExpiry("08/07");
        Hooks.newOrderPage.setCardNumber("5535786799892321");
    }

    @Then("user sees an error message beside the missing field")
    public void user_sees_an_error_message_beside_the_missing_field() {
        assertTrue(Hooks.newOrderPage.isEmptyError());
    }

    @When("User fills in required fields in order page")
    public void user_fills_in_required_fields_in_order_page() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        Hooks.newOrderPage.setQuantity("4");
        Hooks.newOrderPage.setCustomerName("Bob");
        Hooks.newOrderPage.setCustomerStreet("Any");
        Hooks.newOrderPage.setCustomerCity("Anytown");
        Hooks.newOrderPage.setCustomerZip("55323");
        Hooks.newOrderPage.setCustomerState("US");
        Hooks.newOrderPage.setCardExpiry("08/07");
        Hooks.newOrderPage.setCardNumber("5535786799892321");
        Hooks.newOrderPage.selectCardRadio("Visa");
        Hooks.newOrderPage.selectProduct("MyMoney");
        cachedOrder = new OrderData("Bob", "MyMoney", "4", formattedDate, "Any", "Anytown",
        "US", "55323", "Visa", "5535786799892321", "08/07");
    }

    @When("presses reset button")
    public void presses_reset_button() {
        Hooks.newOrderPage.reset();
    }

    @Then("no fields contain non-default values")
    public void no_fields_contain_non_default_values() {
        assertTrue(Hooks.newOrderPage.allDefault());
    }
}
