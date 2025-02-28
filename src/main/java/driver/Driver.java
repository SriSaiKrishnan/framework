package driver;

import enums.ConfigProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utility.PropertyUtils;
import java.net.URL;
import java.util.Objects;

public final class Driver {

    private static final Logger logger = LogManager.getLogger(Driver.class);

    private Driver(){}

    public static WebDriver initializeDriver()  {
        try {
            logger.info("Initializing the driver");
            String browserName = PropertyUtils.get(ConfigProperties.BROWSER);
            Boolean remoteSession = Boolean.parseBoolean(PropertyUtils.get(ConfigProperties.REMOTE));
            String remoteUrl = PropertyUtils.get(ConfigProperties.REMOTEURL);

            if (Objects.isNull(DriverManager.getDriver())) {
                if (remoteSession) {
                    switch (browserName.toLowerCase().trim()) {
                        case "chrome":
                            DriverManager.setDriver(new RemoteWebDriver(new URL(remoteUrl), OptionsManager.getChromeOptions()));
                            break;
                        case "firefox":
                            DriverManager.setDriver(new RemoteWebDriver(new URL(remoteUrl), OptionsManager.getFirefoxOptions()));
                            break;
                        case "edge":
                            DriverManager.setDriver(new RemoteWebDriver(new URL(remoteUrl), OptionsManager.getEdgeOptions()));
                            break;
                        default:
                            logger.info("please pass the right browser on grid..");
                    }

                } else {
                    switch (browserName.toLowerCase().trim()) {
                        case "chrome":
                            DriverManager.setDriver(new ChromeDriver(OptionsManager.getChromeOptions()));
                            break;
                        case "firefox":
                            DriverManager.setDriver(new FirefoxDriver(OptionsManager.getFirefoxOptions()));
                            break;
                        case "edge":
                            DriverManager.setDriver(new EdgeDriver(OptionsManager.getEdgeOptions()));
                            break;
                        default:
                            logger.log(Level.INFO,"please pass the right browser name... {} ", browserName);
                    }
                }
            }
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
