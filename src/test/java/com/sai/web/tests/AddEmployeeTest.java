package com.sai.web.tests;

import com.sai.utility.BrowserUtils;
import com.sai.utility.FakerUtils;
import com.sai.web.annotations.FrameworkAnnotations;
import com.sai.web.base.BaseTest;
import com.sai.enums.Categories;
import com.sai.web.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sai.utility.DataProviderUtils;
import com.sai.utility.DecodeUtils;

import java.util.Map;

public final class AddEmployeeTest extends BaseTest {

    private AddEmployeeTest(){
    }

    @BeforeClass
    public void setUp(){
        DataProviderUtils.setDataSheetName("login");
    }

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void test3(Map<String, String> map) {
        String firstname = FakerUtils.getFirstname();
        String lastname = FakerUtils.getLastname();
        String fullname = new DashboardPage()
                .clickOnPim()
                .clickOnAdd()
                .enterFirstName(firstname)
                .enterLastName(lastname)
                .enterEmployeeID(String.valueOf(FakerUtils.getNumber(1, 9999)))
                .clickOnSave()
                .getFullName();
        Assert.assertEquals(fullname, firstname + " " + lastname);
    }

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
   // @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void test4(Map<String, String> map) {
        System.out.println(map.get("username"));
        System.out.println(DecodeUtils.getdecodedString(map.get("password")));
        Assert.assertTrue(true);
    }

}
