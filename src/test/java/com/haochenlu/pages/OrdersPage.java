package com.haochenlu.pages;

import com.haochenlu.pojos.OrderData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrdersPage {
    WebDriver driver;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text() = 'Logout']")
    private WebElement logoutText;

    @FindBy(xpath = "//*[text() = 'Check All']")
    private WebElement checkAllButton;

    @FindBy(xpath = "//*[text() = 'Uncheck All']")
    private WebElement uncheckAllButton;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']")
    private WebElement orderTable;

    @FindBy(xpath = "//input[@class='btnDeleteSelected']")
    private WebElement deleteButton;

    public void pressCheckAll() {
        checkAllButton.click();
    }

    public void pressUncheckAll() {
        uncheckAllButton.click();
    }

    public List<WebElement> getOrders() {
        List<WebElement> orders = orderTable.findElements(By.xpath("//child::tr"));
        orders.remove(0);
        return orders;
    }

    // returns true if any orders are checked, false otherwise
    public boolean checkChecked() {
        List<WebElement> orders = getOrders();
        for(WebElement order : orders) {
            WebElement checkbox = order.findElement(By.xpath("//child::input[contains(@id, 'OrderSelector')]"));
            if(!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }

    public int numChecked() {
        List<WebElement> orders = getOrders();
        int check = 0;
        for(WebElement order : orders) {
            WebElement checkbox = order.findElement(By.xpath("//child::input[contains(@id, 'OrderSelector')]"));
            if(checkbox.isSelected()) {
                check ++;
            }
        }
        return check;
    }

    public int getNumOrders() {
        if(!driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']")).isEmpty()) {
            return getOrders().size();
        }
        return 0;
    }

    public void editOrderIndex(int index) {
        List<WebElement> orders = getOrders();
        WebElement editOrder = orders.get(index);
        editOrder.findElement(By.xpath("//child::input[@alt='Edit']")).click();
    }

    public void checkAtIndex(int index) {
        List<WebElement> orders = getOrders();
        WebElement checkOrder = orders.get(index);
        checkOrder.findElement(By.xpath("//child::input[contains(@id, 'OrderSelector')]")).click();
    }

    public OrderData getOrderDataAtIndex(int index) {
        List<WebElement> orders = getOrders();
        WebElement order = orders.get(index);
        List<WebElement> orderChild = order.findElements(By.xpath("//child::td"));
        return new OrderData(orderChild.get(3).getText(), orderChild.get(4).getText(), orderChild.get(5).getText(),
                orderChild.get(6).getText(), orderChild.get(7).getText(), orderChild.get(8).getText(),
                orderChild.get(9).getText(), orderChild.get(10).getText(), orderChild.get(11).getText(),
                orderChild.get(12).getText(), orderChild.get(13).getText());
    }

    public boolean isEmptyMessage() {
        return !driver.findElements(By.xpath("//div[contains(@id, 'orderMessage')]")).isEmpty();
    }

    public void pressDelete() {
        deleteButton.click();
    }

    public void logOut() {
        logoutText.click();
    }
}
