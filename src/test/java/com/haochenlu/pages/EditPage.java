package com.haochenlu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class EditPage {
    WebDriver driver;

    public EditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    private WebElement productSelector;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    private WebElement quantity;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")
    private WebElement price;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtDiscount']")
    private WebElement discount;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtTotal']")
    private WebElement total;

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateButton;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtName']")
    private WebElement customerName;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")
    private WebElement customerStreet;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")
    private WebElement customerCity;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")
    private WebElement customerState;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")
    private WebElement customerZip;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_fmwOrder_cardList']")
    private WebElement cardRadio;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    private WebElement cardNumber;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    private WebElement cardExpiry;

    public void selectCardRadio(String issuer) {
        switch (issuer) {
            case "American Express" ->
                    cardRadio.findElement(By.xpath("//child::input[@value='American Express']")).click();
            case "MasterCard" -> cardRadio.findElement(By.xpath("//child::input[@value='MasterCard']")).click();
            case "Visa" -> cardRadio.findElement(By.xpath("//child::input[@value='Visa']")).click();
        }
    }

    public void selectProduct(String product) {
        Select productSelect = new Select(productSelector);
        productSelect.selectByValue(product);
    }

    public void setQuantity(String num) {
        quantity.sendKeys(num);
    }

    public void setPrice(String newPrice) {
        price.sendKeys(newPrice);
    }

    public void setDiscount(String newDiscount) {
        discount.sendKeys(newDiscount);
    }

    public void setCustomerName(String newCustomerName) {
        customerName.sendKeys(newCustomerName);
    }

    public void setCustomerStreet(String newCustomerStreet) {
        customerStreet.sendKeys(newCustomerStreet);
    }

    public void setCustomerCity(String newCustomerCity) {
        customerCity.sendKeys(newCustomerCity);
    }

    public void setCustomerState(String newCustomerState) {
        customerState.sendKeys(newCustomerState);
    }

    public void setCustomerZip(String newCustomerZip) {
        customerZip.sendKeys(newCustomerZip);
    }

    public void setCardNumber(String newCardNumber) {
        cardNumber.sendKeys(newCardNumber);
    }

    public void setCardExpiry(String newCardExpiry) {
        cardExpiry.sendKeys(newCardExpiry);
    }

    public void pressCalculate() {
        calculateButton.click();
    }
}
