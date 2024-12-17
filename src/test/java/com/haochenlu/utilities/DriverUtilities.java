package com.haochenlu.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverUtilities {
    private static DriverUtilities driverUtilities;

    private WebDriver driver;

    private DriverUtilities() {
        super();
    }

    public static DriverUtilities getInstance() {
        if (driverUtilities == null) {
            driverUtilities = new DriverUtilities();
        }
        return driverUtilities;
    }

    public WebDriver getDriver() {
        if(driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void resetDriver() {
        driverUtilities.driver.quit();
        driverUtilities.driver = null;
        driverUtilities = null;
    }

    private void createDriver() {
        String driverName = getDriverName();
        switch (driverName) {
            case "Chrome" -> {
                this.driver = new ChromeDriver();
            }
            case "Firefox" -> this.driver = new FirefoxDriver();
            default -> {
                this.driver = new EdgeDriver();
            }
        }
    }

    private String getDriverName() {
        String driverName = "";
        Properties config = new Properties();
        try {
            config.load(new FileInputStream("src/test/java/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driverName = config.getProperty("browser");
        return driverName;
    }
}
