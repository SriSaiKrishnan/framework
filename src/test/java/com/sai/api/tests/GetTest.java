package com.sai.api.tests;

import com.sai.api.requestbuilder.RequestBuilder;
import com.sai.enums.Categories;
import com.sai.reports.ExtentLogger;
import com.sai.web.annotations.FrameworkAnnotations;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetTest {

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test
    public void validateGetTest() {

        ExtentLogger.pass("Validate the Get Call");

       Response response = RequestBuilder.buildGetRequestWithQueryParam("101")
                .get("/employees");

       response
               .then()
               .log()
               .all()
               .assertThat()
               .statusCode(200);

       response.prettyPrint();
    }

}
