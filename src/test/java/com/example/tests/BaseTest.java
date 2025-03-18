package com.example.tests;

import com.example.utils.DriverManager;
import io.appium.java_client.AppiumDriver;

public class BaseTest {

    protected static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return DriverManager.getDriver(); // Retorna o driver inicializado
    }
}