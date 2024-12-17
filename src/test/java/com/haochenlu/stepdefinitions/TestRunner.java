package com.haochenlu.stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/Features",
        tags = "",
        glue = "com/haochenlu/stepdefinitions",
        plugin = {
                "pretty",
                "json:Report/cucumber.json",
                "junit:Report/cucumber.junit",
                "html:Report/cucumber.html",
        },
        dryRun = false,
        publish = false
)
public class TestRunner {

}
