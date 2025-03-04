package tests;

import annotations.FrameworkAnnotations;
import base.BaseTest;
import enums.Categories;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.DataProviderUtils;
import utility.DecodeUtils;

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
    public void test3(Map<String, String> map) throws Exception {
        System.out.println(map.get("username"));
        System.out.println(DecodeUtils.getdecodedString(map.get("password")));
        login();
        Assert.assertTrue(true);
        logout();
    }

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void test4(Map<String, String> map) throws Exception {
        System.out.println(map.get("username"));
        System.out.println(DecodeUtils.getdecodedString(map.get("password")));
        login();
        Assert.assertTrue(true);
        logout();
    }


}
