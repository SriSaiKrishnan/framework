package base;

import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import reports.ExtentLogger;

public class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    protected void click(By by, WaitStrategy waitStrategy, String element){
        logger.log(Level.INFO,"Click on the element {}" , by);
        ExtentLogger.pass("Clicking the " + element, true);
        try{
            ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();
        } catch (Exception e) {
            logger.log(Level.ERROR, "Failed to click the element {} and exception {}", by, e);
        }
    }

    protected void sendKeys(By by, String text, WaitStrategy waitStrategy, String element){
        logger.log( Level.INFO, "Enter the text {}", by);
        ExtentLogger.pass("Enter the text " + text + " in the " + element , true);
        try{
           ExplicitWaitFactory.performExplicitWait(waitStrategy,by).clear();
           ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(text);
        } catch (Exception e) {
            logger.log(Level.ERROR, "Failed to enter the text {} and exception {}", by, e);
        }
    }

    protected String getText(By by, WaitStrategy waitStrategy) {
        logger.log(Level.INFO, "Getting the text of the Web Element {}", by);
        String text = "";
        try {
            text = ExplicitWaitFactory.performExplicitWait(waitStrategy,by).getText();
        } catch (Exception e) {
           logger.log(Level.ERROR, "Failed to get the text of the Web Element {} and exception {}", by, e);
        }
        return text;
    }

}