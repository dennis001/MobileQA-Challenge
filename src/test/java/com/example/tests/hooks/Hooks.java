package com.example.tests.hooks;

import com.example.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        System.out.println("Chamando initializeDriver() no hook @Before...");
        DriverManager.initializeDriver();
    }

    @After
    public void tearDown() {
        System.out.println("Chamando quitDriver() no hook @After...");
        DriverManager.quitDriver();
    }
}