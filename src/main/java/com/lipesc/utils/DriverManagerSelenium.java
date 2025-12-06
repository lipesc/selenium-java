package com.lipesc.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerSelenium {
    private static WebDriver driver;

       
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
    
    public static void closerDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
    }

