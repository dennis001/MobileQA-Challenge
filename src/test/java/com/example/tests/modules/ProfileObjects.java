package com.example.tests.modules;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProfileObjects {
    private AppiumDriver driver;

    // Construtor
    public ProfileObjects(AppiumDriver driver) {
        this.driver = driver; // Ensure the class-level driver is assigned
    }

    // Elementos da tabbar
    private By signinButton = By.xpath("//android.widget.Button[@content-desc='Sign In']");
    private By singoutButton = AppiumBy.accessibilityId("Sign Out");

    // Métodos para interagir com os elementos
    public void clickSigninButton() {
        driver.findElement(signinButton).click();
    }

    public void clickSignoutButton() {
        driver.findElement(singoutButton).click();
    }
}
