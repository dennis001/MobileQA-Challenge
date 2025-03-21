// filepath: src/main/java/com/example/pages/BasePage.java
package com.example.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

public abstract class BasePage {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element) {
        waitForElement(element);
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

     // Método genérico para esperar até que um elemento seja clicável
     protected WebElement waitForElementToBeClickable(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Método genérico para esperar até que um elemento esteja visível
    protected WebElement waitForElementToBeVisible(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}