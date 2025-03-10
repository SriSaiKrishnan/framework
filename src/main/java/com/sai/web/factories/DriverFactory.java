package com.sai.web.factories;

import com.sai.enums.ConfigProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.sai.utility.PropertyUtils;
import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    private DriverFactory() {}

    public  static WebDriver init(String browserName){

        WebDriver driver = null;
            try {
                if (PropertyUtils.get(ConfigProperties.REMOTE).equalsIgnoreCase("yes")) {
                    switch (browserName.toLowerCase().trim()) {
                        case "chrome":
                            driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.REMOTEURL)), OptionsFactory.getChromeOptions());
                            break;
                        case "firefox":
                            driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.REMOTEURL)), OptionsFactory.getFirefoxOptions());
                            break;
                        case "edge":
                            driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.REMOTEURL)), OptionsFactory.getEdgeOptions());
                            break;
                        default:
                            logger.info("please pass the right browser on grid..");
                    }

                } else {
                    switch (browserName.toLowerCase().trim()) {
                        case "chrome":
                            driver = new ChromeDriver(OptionsFactory.getChromeOptions());
                            break;
                        case "firefox":
                            driver = new FirefoxDriver(OptionsFactory.getFirefoxOptions());
                            break;
                        case "edge":
                            driver = new EdgeDriver(OptionsFactory.getEdgeOptions());
                            break;
                        default:
                            logger.log(Level.INFO, "please pass the right browser name... {} ", browserName);
                    }
                }
            }catch (MalformedURLException e){
                throw new RuntimeException("Error in launching the browser",e);
            }
        return driver;
    }

}
