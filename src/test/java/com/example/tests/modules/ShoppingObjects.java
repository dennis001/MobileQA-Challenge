package com.example.tests.modules;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ShoppingObjects {

    private AppiumDriver driver;
    
    // Construtor
    public ShoppingObjects(AppiumDriver driver) {
        this.driver = driver;
    }
    
    private By btnAddCart = AppiumBy.accessibilityId("ADD TO CART");
    private By btnBuyNow = AppiumBy.accessibilityId("BUY NOW");
    private By btnProceed = AppiumBy.accessibilityId("PROCEED");
    private By billingAddress = By.xpath("//android.view.View[@content-desc='Billing Address']");
    private By deliveryShippingMethod = By.xpath("//android.widget.RadioButton[@content-desc='Delivery Boy Shipping']");
    private By  flatShippingMethod = By.xpath("//android.widget.RadioButton[@content-desc='Flat Shipping Rate']");
    private By bankPayment = AppiumBy.accessibilityId("Bank Transfer");
    private By deliveryPayment = AppiumBy.accessibilityId("Cash On Delivery");
    private By conditionTerms = By.className("android.widget.CheckBox");

    // Métodos para interagir com os elementos'
    public void buyButton() {
        driver.findElement(btnBuyNow).click();
    }
    
    public void addItemToCart() {
        driver.findElement(btnAddCart).click();
    }

    public void proceedButton() {
        driver.findElement(btnProceed).click();
    }

    public List<String> getBillingAddressDetails() {
        List<WebElement> elements = driver.findElements(billingAddress);
        List<String> details = new ArrayList<>();

        for (WebElement element : elements) {
            String text = element.getText(); // Captura o texto de cada elemento
            details.add(text);
            System.out.println("Detalhe capturado: " + text); // Exibe o texto no log
        }

        return details;
    }

    public void selectDeliveryShippingMethod() {
        driver.findElement(deliveryShippingMethod).click();
    }

    public void selectFlatShippingMethod() {
        driver.findElement(flatShippingMethod).click();
    }

    public void selectBankPayment() {
        driver.findElement(bankPayment).click();
    }

    public void selectDeliveryPayment() {
        driver.findElement(deliveryPayment).click();
    }

    public void acceptConditionTerms() {
        driver.findElement(conditionTerms).click();
    }
    
    public boolean waitForTextToAppear(String expectedText, int timeoutInSeconds) {
        int elapsedTime = 0;
        while (elapsedTime < timeoutInSeconds) {
            String pageSource = driver.getPageSource(); // Captura o conteúdo da tela
            if (pageSource.contains(expectedText)) {
                System.out.println("Texto encontrado: " + expectedText);
                return true;
            }
            try {
                Thread.sleep(1000); // Aguarda 1 segundo antes de verificar novamente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsedTime++;
        }
        System.out.println("Texto não encontrado dentro do tempo limite: " + expectedText);
        return false;
    }
    
}
