package com.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static AppiumDriver driver;

    @SuppressWarnings("deprecation")
    public static void initializeDriver() throws MalformedURLException {
        if (driver == null) {
            // System.out.println("Inicializando o driver...");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            capabilities.setCapability("appPackage", "webkul.opencart.mobikul");
            capabilities.setCapability("appActivity", "webkul.opencart_flutter.mobikul.launcherAlias.LauncherAliasDefault");
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            // capabilities.setCapability("uiautomator2ServerLaunchTimeout", 60000); 

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            System.out.println("Driver inicializado com sucesso.");
        } else {
            System.out.println("Driver já inicializado.");
        }
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver não inicializado. Certifique-se de chamar initializeDriver() antes de usar o driver.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            System.out.println("Finalizando o driver...");
            driver.quit();
            driver = null;
            System.out.println("Driver finalizado com sucesso.");
        }
    }
}