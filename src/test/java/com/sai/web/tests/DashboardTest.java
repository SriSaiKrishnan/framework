package com.sai.web.tests;

import com.sai.web.annotations.FrameworkAnnotations;
import com.sai.web.base.BaseTest;
import com.sai.enums.Categories;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sai.utility.DataProviderUtils;
import com.sai.utility.DecodeUtils;

import java.util.Map;

public final class DashboardTest extends BaseTest {

    private DashboardTest(){
    }

    @BeforeClass
    public void setUp(){
        DataProviderUtils.setDataSheetName("login");
    }

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void test3(Map<String, String> map) {
        login();
        System.out.println(map.get("username"));
        System.out.println(DecodeUtils.getdecodedString(map.get("password")));
        Assert.assertTrue(true);
    }

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void test4(Map<String, String> map) {
        login();
        System.out.println(map.get("username"));
        System.out.println(DecodeUtils.getdecodedString(map.get("password")));
        Assert.assertTrue(true);
    }

}
