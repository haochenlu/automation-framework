package com.haochenlu.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class F1_Login_Step {
    @Given("User is on the login page of the webpage")
    public void user_is_on_the_login_page_of_the_webpage() {
        Hooks.driver.navigate().to(Hooks.properties.getProperty("baseURL"));
    }
    @When("User enters a valid id and password")
    public void user_enters_a_valid_id_and_password() {
        Hooks.loginPage.inputUserName(Hooks.properties.getProperty("validUsername"));
        Hooks.loginPage.inputPassword(Hooks.properties.getProperty("validPassword"));
    }
    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        Hooks.loginPage.login();
    }
    @Then("User is redirected to the orders page")
    public void user_is_redirected_to_the_orders_page() throws InterruptedException {
        Thread.sleep(2000);
        String url = Hooks.driver.getCurrentUrl();
        System.out.println(url);
        assertTrue(url.contains(Hooks.properties.getProperty("orderURL")));
    }

    @When("User enters an invalid id and password")
    public void user_enters_an_invalid_id_and_password() {
        Hooks.loginPage.inputUserName(Hooks.properties.getProperty("invalidUsername"));
        Hooks.loginPage.inputPassword(Hooks.properties.getProperty("invalidPassword"));
    }

    @Then("User sees a login error message")
    public void user_sees_a_login_error_mesage() {
        assertTrue(Hooks.loginPage.isLoginError());
    }

    @And("presses the enter key")
    public void pressesTheEnterKey() {
        Hooks.loginPage.pressEnter();
    }

//    @Given("User is on the login page of the webpage")
//    public void user_is_on_the_login_page_of_the_webpage() {
//        Hooks.driver.navigate().to(Hooks.properties.getProperty("baseURL"));
//    }
//    @When("User enters a valid id and password")
//    public void user_enters_a_valid_id_and_password() {
//        Hooks.loginPage.inputUserNameAction(Hooks.properties.getProperty("validUsername"));
//        Hooks.loginPage.inputPasswordAction(Hooks.properties.getProperty("validPassword"));
//    }
//    @When("User clicks the login button")
//    public void user_clicks_the_login_button() {
//        Hooks.loginPage.loginAction();
//    }
//    @Then("User is redirected to the orders page")
//    public void user_is_redirected_to_the_orders_page() throws InterruptedException {
//        Thread.sleep(2000);
//        String url = Hooks.driver.getCurrentUrl();
//        System.out.println(url);
//        assertTrue(url.contains(Hooks.properties.getProperty("orderURL")));
//    }
//
//    @When("User enters an invalid id and password")
//    public void user_enters_an_invalid_id_and_password() {
//        Hooks.loginPage.inputUserNameAction(Hooks.properties.getProperty("invalidUsername"));
//        Hooks.loginPage.inputPasswordAction(Hooks.properties.getProperty("invalidPassword"));
//    }
//
//    @Then("User sees a login error message")
//    public void user_sees_a_login_error_mesage() {
//        assertTrue(Hooks.loginPage.isLoginError());
//    }
//
//    @And("presses the enter key")
//    public void pressesTheEnterKey() {
//        Hooks.loginPage.pressEnterAction();
//    }
}
