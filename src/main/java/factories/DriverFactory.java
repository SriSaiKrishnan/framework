package factories;

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
import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    private DriverFactory() {}

    public  static WebDriver init(String browserName){
        Boolean remoteSession = Boolean.parseBoolean(PropertyUtils.get(ConfigProperties.REMOTE));
        String remoteUrl = PropertyUtils.get(ConfigProperties.REMOTEURL);
        WebDriver driver = null;
            try {
                if (remoteSession) {
                    switch (browserName.toLowerCase().trim()) {
                        case "chrome":
                            driver = new RemoteWebDriver(new URL(remoteUrl), OptionsFactory.getChromeOptions());
                            break;
                        case "firefox":
                            driver = new RemoteWebDriver(new URL(remoteUrl), OptionsFactory.getFirefoxOptions());
                            break;
                        case "edge":
                            driver = new RemoteWebDriver(new URL(remoteUrl), OptionsFactory.getEdgeOptions());
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
