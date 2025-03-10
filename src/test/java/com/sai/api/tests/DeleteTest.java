package com.sai.api.tests;

import com.sai.api.requestbuilder.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteTest {

    @Test
    public void validateDeleteTest(){

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
