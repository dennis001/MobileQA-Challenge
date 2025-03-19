package com.example.tests.modules;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CategoriesObjects {

    private AppiumDriver driver;
    
    // Construtor
    public CategoriesObjects(AppiumDriver driver) {
        this.driver = driver;
    }

    private By notebookHP = By.xpath("//android.widget.ImageView[@content-desc='$122.00\n' + 'HP LP3065']");
    
    // Métodos para interagir com os elementos'
    public void selectNotebookHP() {
        driver.findElement(notebookHP).click();
    }
}
