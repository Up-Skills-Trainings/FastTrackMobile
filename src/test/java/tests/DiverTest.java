package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class DiverTest {
    @Test
    public void androidDriverTest(){
        AppiumDriver driver = Driver.getDriver("android");
        // click on Wikipedia
        driver.findElement(new AppiumBy.ByAccessibilityId("Wikipedia")).click();

        // verify English lang is visible (default)
        WebElement defaultLanguage = driver.findElement(By.id("org.wikipedia:id/option_label"));

        Driver.closeDriver();
    }
}