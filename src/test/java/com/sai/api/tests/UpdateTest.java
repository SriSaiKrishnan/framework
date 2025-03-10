package com.sai.api.tests;

import com.sai.api.builder.EmployeeBuilder;
import com.sai.api.pojo.Employee;
import com.sai.api.requestbuilder.RequestBuilder;
import com.sai.utility.RandomUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UpdateTest {

    @Test
   public void validateUpdateTest() {
        Employee requestBody = EmployeeBuilder
                .builder()
                .setFirstName(RandomUtils.getFirstname())
                .setLastName(RandomUtils.getLastname())
                .setEmail(RandomUtils.getEmail())
                .build();

        Response response = RequestBuilder
                .buildPostRequestWithPathParam("id","103")
                .body(requestBody)
                .put("/employees/{id}");

        response
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);

        response.prettyPrint();
   }

}
