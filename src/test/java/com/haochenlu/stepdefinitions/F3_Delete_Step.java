package com.haochenlu.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static junit.framework.TestCase.*;

public class F3_Delete_Step {
    private int numOrders;

    @When("User deletes all orders")
    public void user_deletes_all_orders() {
        Hooks.ordersPage.pressCheckAll();
        Hooks.ordersPage.pressDelete();
    }

    @Then("The table is replaced by a message directing them to add orders")
    public void the_table_is_replaced_by_a_message_directing_them_to_add_orders() {
        assertTrue(Hooks.ordersPage.isEmptyMessage());
    }

    @When("the user presses delete selected button and no orders are selected")
    public void the_user_presses_delete_selected_button_and_no_orders_are_selected() {
        numOrders = Hooks.ordersPage.getNumOrders();
        Hooks.ordersPage.pressDelete();
    }

    @Then("The table remains the same")
    public void the_table_remains_the_same() {
        assertEquals(numOrders, Hooks.ordersPage.getNumOrders());
    }

    @When("the user presses the check all button")
    public void the_user_presses_the_check_all_button() {
        Hooks.ordersPage.pressCheckAll();
    }

    @Then("All orders in the table are checked")
    public void all_orders_in_the_table_are_checked() {
        assertEquals(Hooks.ordersPage.getNumOrders(), Hooks.ordersPage.numChecked());
    }

    @When("the user checks an order")
    public void the_user_checks_an_order() {
        Hooks.ordersPage.checkAtIndex(0);
    }

    @When("presses the uncheck all button")
    public void presses_the_uncheck_all_button() {
        Hooks.ordersPage.pressUncheckAll();
    }

    @Then("all checked orders become unchecked")
    public void all_checked_orders_become_unchecked() {
        assertFalse(Hooks.ordersPage.checkChecked());
    }
}
