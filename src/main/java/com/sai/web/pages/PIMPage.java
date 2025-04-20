package com.sai.web.pages;

import com.sai.enums.WaitStrategy;
import com.sai.web.base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class PIMPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(PIMPage.class);

    private static By eleAdd = By.xpath("//button[normalize-space()='Add']");

    private static By eleFirstName = By.name("firstName");

    private static By eleLastName = By.name("lastName");

    private static By eleEmployeeID = By.cssSelector("div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']");

    private static By eleSave = By.xpath("//button[normalize-space()='Save']");

    private static By eleFullname = By.cssSelector("div[class='orangehrm-edit-employee-name']");

    public PIMPage clickOnAdd()
    {
        click(eleAdd, WaitStrategy.CLICKABLE,"Add button");
        return new PIMPage();
    }

    public PIMPage enterFirstName(String firstname)
    {
        sendKeys(eleFirstName, firstname,WaitStrategy.PRESENCE, "firstname textbox");
        return new PIMPage();
    }

    public PIMPage enterLastName(String  lastname)
    {
        sendKeys(eleLastName, lastname, WaitStrategy.PRESENCE, "lastname textbox");
        return new PIMPage();
    }

    public PIMPage enterEmployeeID(String empID)
    {
        sendKeys(eleEmployeeID, empID, WaitStrategy.PRESENCE, "Employee ID textbox");
        return new PIMPage();
    }

    public  PIMPage clickOnSave()
    {
        click(eleSave, WaitStrategy.CLICKABLE, "Save button");
        return new PIMPage();
    }

    public String getFullName()
    {
        waitTenSeconds();
        return getText(eleFullname,WaitStrategy.VISIBLE);
    }

}
