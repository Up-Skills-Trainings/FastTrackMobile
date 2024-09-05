package step_definitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utils.Driver;

public class HomePageAppsSteps {

    @When("User opens {string} application")
    public void user_opens_application(String appName) {

   Driver.getDriver("android").findElement(new AppiumBy.ByAccessibilityId(appName)).click();

    }
    @Then("User verifies default statement contains {string}")
    public void user_verifies_default_statement_contains(String expectedStatement) {
        String defaultLanguageText =Driver.getDriver("android").findElement(By.id("org.wikipedia:id/option_label")).getAttribute("text");

        Assertions.assertTrue(defaultLanguageText.contains(expectedStatement));
    }
}
