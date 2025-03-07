package com.sai.pages;

import com.sai.base.BasePage;
import com.sai.enums.WaitStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    private By userName = By.name("username");

    private By passWord = By.name("password");

    private By login = By.xpath("//button[normalize-space()='Login']");

    public LoginPage enterUsername(String username){
        sendKeys(userName, username, WaitStrategy.PRESENCE,"username textbox");
        return this;
    }

    public LoginPage enterPassword(String password){
        sendKeys(passWord,password,WaitStrategy.PRESENCE, "password textbox");
        return this;
    }

    public DashboardPage clickLogin(){
        click(login,WaitStrategy.CLICKABLE, "login link");
        return new DashboardPage();
    }

}
