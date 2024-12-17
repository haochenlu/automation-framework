package com.haochenlu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    Actions actions;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='ctl00_MainContent_username']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_login_button']")
    private WebElement loginButton;

    public void inputUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void inputUserNameAction(String userName) {
        actions.moveToElement(userNameInput).sendKeys(userName).perform();
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void inputPasswordAction(String password) {
        actions.moveToElement(passwordInput).sendKeys(password).perform();
    }

    public void login() {
        loginButton.click();
    }

    public void loginAction() {
        actions.moveToElement(loginButton).click().perform();
    }

    public void pressEnter() {
        userNameInput.sendKeys(Keys.RETURN);
    }

    public void pressEnterAction() {
        actions.moveToElement(userNameInput).sendKeys(Keys.RETURN).perform();
    }

    public boolean isLoginError() {
        return !driver.findElements(By.xpath("//*[text() = 'Invalid Login or Password.']")).isEmpty();
    }
}
