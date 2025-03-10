package com.sai.api.tests;

import com.sai.api.builder.EmployeeBuilder;
import com.sai.api.pojo.Employee;
import com.sai.api.requestbuilder.RequestBuilder;
import com.sai.constants.AppConstants;
import com.sai.utility.FileUtils;
import com.sai.utility.RandomUtils;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PostTest {

    @Test
    public void validatePostWithStringAsPayload(){

        String payload = "{\n" +
                "    \"id\": \"104\",\n" +
                "    \"firstName\": \"John4\",\n" +
                "    \"lastName\": \"Doe4\",\n" +
                "    \"email\": \"john.doe4@example.com\",\n" +
                "    \"phone\": \"+1-123-456-7890\"\n" +
                "  }";

        Response response = RequestBuilder.buildPostRequest()
                .body(payload)
                .post("/employees");

        response
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);

        response.prettyPrint();

    }

    @Test
    public void validatePostWithJsonFileAsPayload(){

        String requestBody = FileUtils.readFile(AppConstants.getJsonFilePath());

        Response response = RequestBuilder
                .buildPostRequest()
                .body(requestBody)
                .post("/employees");

        response
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);

        response.prettyPrint();

    }

    @Test
    public void validatePostWithHashMapAsPayload(){

        Map<String,String> requestBody = new HashMap<>();
        requestBody.put("id", "" + RandomUtils.getRandomNumber());
        requestBody.put("firstName", RandomUtils.getFirstname());
        requestBody.put("firstName", RandomUtils.getLastname());
        requestBody.put("email", RandomUtils.getEmail());
        requestBody.put("phone", RandomUtils.getPhonenumber());

        Response response = RequestBuilder
                .buildPostRequest()
                .body(requestBody)
                .post("/employees");

        response
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);

        response.prettyPrint();

    }

    @Test
    public void validatePostWithJsonObjectAsPayload(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("id", "" + RandomUtils.getRandomNumber());
        requestBody.put("firstName", RandomUtils.getFirstname());
        requestBody.put("firstName", RandomUtils.getLastname());
        requestBody.put("email", RandomUtils.getEmail());
        requestBody.put("phone", RandomUtils.getPhonenumber());

        Response response = RequestBuilder
                .buildPostRequest()
                .body(requestBody.toMap())
                .post("/employees");

        response
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);

        response.prettyPrint();
    }

    @Test
    public void validatePostWithPojoAsPayload(){

        Employee requestBody = EmployeeBuilder
                .builder()
                .setId("" + RandomUtils.getRandomNumber())
                .setFirstName(RandomUtils.getFirstname())
                .setLastName(RandomUtils.getLastname())
                .setEmail(RandomUtils.getEmail())
                .setPhone(RandomUtils.getPhonenumber())
                .build();

        Response response = RequestBuilder
                .buildPostRequest()
                .body(requestBody)
                .post("/employees");

        response
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);

        response.prettyPrint();

    }
}
