package com.sai.utility;

import com.sai.web.driver.DriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;

public final class BrowserUtils {

    private BrowserUtils() {}

    public static String getBrowserName(){
        Capabilities capabilities = ((HasCapabilities) DriverManager.getDriver()).getCapabilities();
        return capabilities.getBrowserName();
    }

    public static String getBrowserVersion(){
        Capabilities capabilities = ((HasCapabilities) DriverManager.getDriver()).getCapabilities();
        return capabilities.getBrowserVersion();
    }

}
