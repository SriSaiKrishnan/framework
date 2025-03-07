package com.sai.driver;

import com.sai.enums.ConfigProperties;
import com.sai.factories.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.sai.utility.PropertyUtils;
import java.util.Objects;

public final class Driver {

    private static final Logger logger = LogManager.getLogger(Driver.class);

    private Driver(){}

    public static void initializeDriver(String browserName)  {
        try {
            logger.info("Initializing the driver");
            if(Objects.isNull(DriverManager.getDriver())){
                DriverManager.setDriver(DriverFactory.init(browserName));
            }
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }catch (Exception e){
            logger.info(e.getMessage());
        }

    }

    public static void quitDriver() {
        try {
            if(Objects.nonNull(DriverManager.getDriver())){
                DriverManager.getDriver().quit();
                DriverManager.unload();
                logger.info("Driver instance quit successfully.");
            }
        } catch (Exception e) {
            logger.error("Error while quitting the driver: ", e);
        }
    }

}
