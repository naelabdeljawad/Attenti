package com.launcher;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/features/AttentiTestScenario.feature", plugin = {"pretty",
        "html:target/cucumber/AttentiTestScenario.html",
        "rerun:target/cucumber/AttentiTestScenario.txt",
        "json:target/cucumber/AttentiTestScenario.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"com.definitions"})
public class AttentiTestScenarioLauncher extends AbstractTestNGCucumberTests {
}
