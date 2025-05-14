package com.sai.web.factories;

import com.sai.enums.ConfigProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.sai.utility.PropertyUtils;

public final class OptionsFactory {

    private static final Logger logger = LogManager.getLogger(OptionsFactory.class);
    private static ChromeOptions chromeOptions;
    private static FirefoxOptions firefoxOptions;
    private static EdgeOptions edgeOptions;

    private OptionsFactory(){}

    public static ChromeOptions getChromeOptions() {
        try {
            chromeOptions = new ChromeOptions();
            if (PropertyUtils.get(ConfigProperties.HEADLESS).equalsIgnoreCase("yes")) {
                logger.info("Running tests in headless mode");
                chromeOptions.addArguments("--headless");
            }
            if (PropertyUtils.get(ConfigProperties.INCOGNITO).equalsIgnoreCase("yes")) {
                logger.info("Running tests in incognito mode");
                chromeOptions.addArguments("--incognito");
            }
            if (PropertyUtils.get(ConfigProperties.REMOTE).equalsIgnoreCase("yes")) {
                logger.info("Running tests in remote machine");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.setCapability("browserName", "chrome");
                chromeOptions.setCapability("unhandledPromptBehavior", "accept");
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions(){
        try {
            firefoxOptions = new FirefoxOptions();
            if (PropertyUtils.get(ConfigProperties.HEADLESS).equalsIgnoreCase("yes")) {
                logger.info("Running tests in headless mode");
                firefoxOptions.addArguments("--headless");
            }
            if (PropertyUtils.get(ConfigProperties.INCOGNITO).equalsIgnoreCase("yes")) {
                logger.info("Running tests in incognito mode");
                firefoxOptions.addArguments("--incognito");
            }
            if (PropertyUtils.get(ConfigProperties.REMOTE).equalsIgnoreCase("yes")) {
                logger.info("Running tests in remote machine");
                firefoxOptions.addArguments("--disable-extensions");
                firefoxOptions.addArguments("--disable-popup-blocking");
                firefoxOptions.setCapability("browserName", "chrome");
                firefoxOptions.setCapability("unhandledPromptBehavior", "accept");
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return firefoxOptions;
    }

    public static EdgeOptions getEdgeOptions(){
        try {
            edgeOptions = new EdgeOptions();
            if (PropertyUtils.get(ConfigProperties.HEADLESS).equalsIgnoreCase("yes")) {
                logger.info("Running tests in headless mode");
                edgeOptions.addArguments("--headless");
            }
            if (PropertyUtils.get(ConfigProperties.INCOGNITO).equalsIgnoreCase("yes")) {
                logger.info("Running tests in incognito mode");
                edgeOptions.addArguments("--incognito");
            }
            if (PropertyUtils.get(ConfigProperties.REMOTE).equalsIgnoreCase("yes")) {
                logger.info("Running tests in remote machine");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--disable-popup-blocking");
                edgeOptions.setCapability("browserName", "chrome");
                edgeOptions.setCapability("unhandledPromptBehavior", "accept");
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return edgeOptions;
    }
}
