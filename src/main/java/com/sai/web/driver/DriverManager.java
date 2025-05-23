package com.sai.web.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static final Logger logger = LogManager.getLogger(DriverManager.class);
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private DriverManager(){}

    public static WebDriver getDriver(){
        return tlDriver.get();
    }

    public static void setDriver(WebDriver driver){
        tlDriver.set(driver);
    }

    public static void unload(){

        if (tlDriver.get() != null) {
            tlDriver.remove();
            }
        }
    }

