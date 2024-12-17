package com.haochenlu.stepdefinitions;

import com.haochenlu.pages.*;
import com.haochenlu.utilities.DriverUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {
    static DriverUtilities driverUtilities;
    static LoginPage loginPage;
    static OrdersPage ordersPage;
    static WebDriver driver;
    static Properties properties;
    static EditOrderEditPage editPage;
    static NewOrderPage newOrderPage;

    @Before
    public void init() {
        driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
        loginPage = new LoginPage(driver);
        ordersPage = new OrdersPage(driver);
        editPage = new EditOrderEditPage(driver);
        newOrderPage = new NewOrderPage(driver);
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/java/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public static void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File newFile = new File(properties.getProperty("resourcePath") + String.format("/%s.png", scenario.getName()));
            newFile.createNewFile();
            FileHandler.copy(scrFile, newFile);
        }
        DriverUtilities.resetDriver();
    }
}
