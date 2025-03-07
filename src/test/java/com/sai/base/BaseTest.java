package com.sai.base;

import com.sai.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import com.sai.pages.DashboardPage;
import com.sai.pages.LoginPage;
import java.util.Map;

public class BaseTest {

    protected BaseTest(){}

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp(Object[] data) {
        Map<String,String> map = (Map<String,String>)data[0];
        Driver.initializeDriver(map.get("browser"));
    }

    public void login(){
        new LoginPage()
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        new DashboardPage()
                .clickProfile()
                .clickLogout();
        Driver.quitDriver();
    }


}
