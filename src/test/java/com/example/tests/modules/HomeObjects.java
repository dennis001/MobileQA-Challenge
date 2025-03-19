package com.example.tests.modules;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomeObjects {

    private AppiumDriver driver;
    
    // Construtor
    public HomeObjects(AppiumDriver driver) {
        this.driver = driver;
    }
    

    // private By skipButton = By.id("btn_skip");
    private By backToTop = AppiumBy.accessibilityId("Back to Top");

    // Métodos para interagir com os elementos'
    public boolean isBackToTopVisible() {
        return driver.findElement(backToTop).isDisplayed();
    }

    
}
