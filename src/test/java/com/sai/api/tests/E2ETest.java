package com.sai.api.tests;

/*
1. Make a get call to localhost:3000
2. Get the size of the array (size)
3. Store the size in variable
4. Make the post call using pojo and builder
5. Verify the post call is success
6. Validate the schema
7. Make the get call again and check the size (size + 1)
8. Update call to update the firstname
9. Store the response in the external file
10. Make the delete call and delete the record
11. Get the size of the array (size) and verify
13. Log the request body in the Extent Reports
 */

import com.sai.api.builder.EmployeeBuilder;
import com.sai.api.pojo.Employee;
import com.sai.api.requestbuilder.RequestBuilder;
import com.sai.constants.AppConstants;
import com.sai.enums.Categories;
import com.sai.utility.FileUtils;
import com.sai.utility.RandomUtils;
import com.sai.web.annotations.FrameworkAnnotations;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class E2ETest {

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test
    public void validateE2ETest() {

        Response getResponse = validateGetCall();

        List<Object> initialEmployees = getResponse.jsonPath().getList("$");
        int initialSize = initialEmployees.size();

        System.out.println("Initial Size: " + initialSize);

        validatePostCall();

        Response getUpdatedResponse =  validateGetCall();

        List<Object> updatedEmployees = getUpdatedResponse.jsonPath().getList("$");
        int updatedSize = updatedEmployees.size();

        System.out.println("Updated Size: " + updatedSize);

        Assert.assertEquals(updatedSize, initialSize+1);

        validateUpdateCall();

        validateDeleteCall();

        getUpdatedResponse =  validateGetCall();

        updatedEmployees = getUpdatedResponse.jsonPath().getList("$");
        updatedSize = updatedEmployees.size();
        System.out.println("Updated Size: " + updatedSize);

        Assert.assertEquals(updatedSize, initialSize);

    }

    public Response validateGetCall() {

        Response getResponse = RequestBuilder
                .buildGetRequest()
                .get("/employees");

         getResponse
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);

         return getResponse;

    }

    public Response validatePostCall() {

        Employee employee = EmployeeBuilder
                .builder()
                .setId("" + RandomUtils.getRandomNumber())
                .setFirstName(RandomUtils.getFirstname())
                .setLastName(RandomUtils.getLastname())
                .setEmail(RandomUtils.getEmail())
                .setPhone(RandomUtils.getPhonenumber())
                .build();

        Response postResponse = RequestBuilder
                .buildPostRequest()
                .body(employee)
                .post("/employees");

        postResponse
                .then()
                .log()
                .all()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
                .assertThat()
                .statusCode(201);


      return postResponse;

    }

    public void validateUpdateCall() {

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

        FileUtils.writeFile(AppConstants.getResourcePath() + "/jsons/output.json" , response);

        response
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);

    }

    public void validateDeleteCall() {

        Response response = RequestBuilder
                .buildPostRequestWithPathParam("id","220")
                .delete("/employees/{id}");

        response
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);

    }


}
