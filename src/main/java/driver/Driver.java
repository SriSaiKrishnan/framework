package driver;

import enums.ConfigProperties;
import factories.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utility.PropertyUtils;
import java.util.Objects;

public final class Driver {

    private static final Logger logger = LogManager.getLogger(Driver.class);

    private Driver(){}

    public static WebDriver initializeDriver(String browserName)  {
        try {
            logger.info("Initializing the driver");
            DriverManager.setDriver(DriverFactory.init(browserName));
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }catch (Exception e){
            logger.info(e.getMessage());
        }

        return  DriverManager.getDriver();
    }

    public static void quitDriver() {
        try {
            if(Objects.nonNull(DriverManager.getDriver())){
                DriverManager.getDriver().quit(); // Quit the driver instance
                logger.info("Driver instance quit successfully.");
            }
        } catch (Exception e) {
            logger.error("Error while quitting the driver: ", e);
        } finally {
            DriverManager.unload(); // Remove the driver instance from ThreadLocal
        }
    }

}
