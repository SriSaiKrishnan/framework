package com.sai.api.tests;

import com.sai.api.requestbuilder.RequestBuilder;
import com.sai.enums.Categories;
import com.sai.reports.ExtentLogger;
import com.sai.web.annotations.FrameworkAnnotations;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteTest {

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test
    public void validateDeleteTest(){
        ExtentLogger.pass("Validate the Delete Call");
        Response response = RequestBuilder
                .buildPostRequestWithPathParam("id","102")
                .delete("/employees/{id}");

        response
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);

    }

}
