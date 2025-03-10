package com.sai.web.pages;

import com.sai.web.base.BasePage;
import com.sai.enums.WaitStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(DashboardPage.class);

    private By profileMenu = By.xpath("//img[@alt='profile picture']/parent::span");

    private By logout = By.xpath("//a[text()='Logout']");

    public DashboardPage clickProfile(){
        click(profileMenu, WaitStrategy.CLICKABLE, "profile link");
        return this;
    }

    public LoginPage clickLogout(){
        click(logout, WaitStrategy.CLICKABLE ,"logout");
        return new LoginPage();
    }

}
