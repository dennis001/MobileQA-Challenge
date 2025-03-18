package com.example.tests.modules;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TabbarObjects {

    private AppiumDriver driver;

    // Construtor
    public TabbarObjects(AppiumDriver driver) {
        this.driver = driver;
    }

    // Elementos da tabbar
    private By homeTab = By.xpath("//android.view.View[@content-desc='Home\nTab 1 of 4']");
    private By categoriesTab = AppiumBy.accessibilityId("Categories\nTab 2 of 4");
    private By cartTab = AppiumBy.accessibilityId("Cart\nTab 3 of 4");
    private By profileTab = AppiumBy.accessibilityId("Profile\nTab 4 of 4");

    // Métodos para interagir com os elementos
    public void clickHomeTab() {
        driver.findElement(homeTab).click();
    }

    public void clickCategoriesTab() {
        driver.findElement(categoriesTab).click();
    }

    public void clickCartTab() {
        driver.findElement(cartTab).click();
    }

    public void clickProfileTab() {
        driver.findElement(profileTab).click();
    }
    
}
