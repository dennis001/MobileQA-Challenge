package com.example.tests.modules;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import java.time.Duration;

import org.openqa.selenium.By;

import com.example.pages.BasePage;

public class LoginObjects extends BasePage {

    // Construtor
    public LoginObjects(AppiumDriver driver) {
        super(driver); // Chama o construtor da BasePage
    }

    // private By skipButton = By.id("btn_skip");
    private By skipButton = AppiumBy.accessibilityId("Skip");
    private By signinEmailButton = By.xpath("//android.widget.Button[@content-desc='SIGN IN WITH EMAIL']");
    private By userEmailField = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.EditText[1]");
    private By passwordField = By.id("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.EditText[2]");
    private By signinButton = By.id("com.studiobluelime.ecommerceapp:id/btn_login");
    private By errorMessage = AppiumBy.accessibilityId("SIGN IN");  // contem o texto: Please Enter Correct Email ID
    private By btnCardLogin = AppiumBy.accessibilityId("login");
    private By navBar = AppiumBy.accessibilityId("Sign In With Email");
    private By btnCardSignup = AppiumBy.accessibilityId("Sign up");
    private By navBarCreatAccount = AppiumBy.accessibilityId("Create an account");

    // Métodos para interagir com os elementos'
    public void clickSkipButton() {
        // click(driver.findElement(skipButton)); // Usa o método click da BasePage
        waitForElementToBeVisible(skipButton, Duration.ofSeconds(15)).click();
    }

    public void clickSigninEmailButton() {
        // click(driver.findElement(signinEmailButton));
        waitForElementToBeVisible(signinEmailButton, Duration.ofSeconds(15)).click();
    }

    public void clickSigninButton() {
        click(driver.findElement(signinButton));
    }

    public void enterUserEmail(String username) {
        var emailField = driver.findElement(userEmailField);
        emailField.clear(); // Usa o método clear da BasePage
        sendKeys(emailField, username); // Usa o método sendKeys da BasePage
    }

    public void enterPassword(String password) {
        var passField = driver.findElement(passwordField);
        passField.clear();
        sendKeys(passField, password);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String clickCardLogin() {
        click(driver.findElement(btnCardLogin));
        waitForElementToBeVisible(navBar, Duration.ofSeconds(15));
        return driver.findElement(navBar).getText();
    }

    public String clickCardSignup() {
        click(driver.findElement(btnCardSignup));
        waitForElementToBeVisible(navBarCreatAccount, Duration.ofSeconds(15));
        return driver.findElement(navBarCreatAccount).getText();
    }


}