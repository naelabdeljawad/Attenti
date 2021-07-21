package com.definitions;

import com.CommonUtils;
import com.PropertiesReader;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import org.testng.Assert;
import pom.MetricConversionsPage;
import pom.ResultsPage;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.getCurrentStep;

public class AttentiDefinitions extends TestBase {

    private MetricConversionsPage metricConversionsPage;
    private ResultsPage resultsPage;
    private static String baseURL;

    @Before
    public static void setup() {
        baseURL = PropertiesReader.getInstance().getProperty("base.url");
        RestAssured.baseURI = baseURL;
    }

    @Given("I open browser")
    public void i_open_browser() {
        getCurrentStep().log(Status.INFO, "Opening Chrome browser...");
        metricConversionsPage = new MetricConversionsPage(chromeDriver);
        getCurrentStep().log(Status.INFO, "Chrome is open!");
        metricConversionsPage.openPage(baseURL);
        Assert.assertTrue(metricConversionsPage.isPageDisplayed());
    }

    @When("I convert {int} {string} to {string}")
    public void i_convert_to(Integer value, String unit1, String unit2) {
        Assert.assertTrue(metricConversionsPage.convert(value, unit1, unit2));
    }

    @Then("I expect result to be {string}")
    public void i_expect_result_to_be(String result) {
        resultsPage = new ResultsPage(chromeDriver);
        Assert.assertTrue(resultsPage.isPageDisplayed());
        Assert.assertEquals(resultsPage.getResult(), result, "Results are not equal");
    }

    @When("I navigate back")
    public void i_navigate_back() {
        CommonUtils.navigateBack(chromeDriver);
        Assert.assertTrue(metricConversionsPage.isPageDisplayed());
    }

    @After
    public void afterAll() {
        getCurrentStep().log(Status.INFO, "Closing chrome driver...");
        closeDriver();
        getCurrentStep().log(Status.INFO, "Chrome driver is closed!");
    }
}
