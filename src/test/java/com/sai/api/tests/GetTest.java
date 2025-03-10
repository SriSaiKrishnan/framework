package com.sai.api.tests;

import com.sai.api.requestbuilder.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetTest {

    @Test
    public void validateGetTest() {
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
