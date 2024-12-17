package com.haochenlu.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static junit.framework.TestCase.*;

public class F5_Logout_Step {
    @Given("user is logged in")
    public void user_is_logged_in() {
        Hooks.driver.navigate().to(Hooks.properties.getProperty("orderURL"));
        assertEquals(Hooks.driver.getCurrentUrl(), Hooks.properties.getProperty("orderURL"));
    }

    @When("user presses the logout button")
    public void user_presses_the_logout_button() {
        Hooks.ordersPage.logOut();
    }

    @Then("user is returned to the log in page")
    public void user_is_returned_to_the_log_in_page() {
        assertTrue(Hooks.driver.getCurrentUrl().contains(Hooks.properties.getProperty("baseURL")));
    }

    @When("logs back in")
    public void logs_back_in() {
        Hooks.loginPage.inputUserName(Hooks.properties.getProperty("validUsername"));
        Hooks.loginPage.inputPassword(Hooks.properties.getProperty("validPassword"));
        Hooks.loginPage.login();
    }

    @Then("the orders table is reset to defaults")
    public void the_orders_table_is_reset_to_defaults() {
        assertFalse(Hooks.ordersPage.isEmptyMessage());
    }

    @Then("the orders table remains empty")
    public void theOrdersTableRemainsEmpty() {
        assertTrue(Hooks.ordersPage.isEmptyMessage());
    }
}
