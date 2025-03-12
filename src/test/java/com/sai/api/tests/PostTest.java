package com.sai.api.tests;

import com.sai.api.builder.EmployeeBuilder;
import com.sai.api.pojo.Employee;
import com.sai.api.requestbuilder.RequestBuilder;
import com.sai.constants.AppConstants;
import com.sai.enums.Categories;
import com.sai.reports.ExtentLogger;
import com.sai.utility.FileUtils;
import com.sai.utility.RandomUtils;
import com.sai.web.annotations.FrameworkAnnotations;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PostTest {

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test
    public void validatePostWithStringAsPayload(){

        ExtentLogger.pass("Validate the Post Call with String as Payload");

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

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test
    public void validatePostWithJsonFileAsPayload(){

        ExtentLogger.pass("Validate the Post Call with External File as Payload");

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

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test
    public void validatePostWithHashMapAsPayload(){

        ExtentLogger.pass("Validate the Post Call with Hashmap as Payload");

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

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test
    public void validatePostWithJsonObjectAsPayload(){

        ExtentLogger.pass("Validate the Post Call with Json Object as Payload");

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

    @FrameworkAnnotations(authors = {"Sai","Krishnan"},categories = {Categories.REGRESSION, Categories.SMOKE})
    @Test
    public void validatePostWithPojoAsPayload(){

        ExtentLogger.pass("Validate the Post Call with Pojo as Payload");

        EmployeeBuilder builder = EmployeeBuilder.builder();
        String id = "" + RandomUtils.getRandomNumber();
        String firstName =RandomUtils.getFirstname();
        String lastName = RandomUtils.getLastname();
        String email = RandomUtils.getEmail();
        String phoneNumber = RandomUtils.getPhonenumber();

        builder.setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhone(phoneNumber);

        Employee requestBody = builder.build();

        Response response = RequestBuilder
                .buildPostRequest()
                .body(requestBody)
                .post("/employees");

        Employee employee = response
                .then()
                .log()
                .all()
                .statusCode(201)
                .extract()
                .response()
                .as(Employee.class);

        Assert.assertEquals(id, employee.getId());
        Assert.assertEquals(firstName, employee.getFirstName());
        Assert.assertEquals(lastName, employee.getLastName());
        Assert.assertEquals(email, employee.getEmail());
        Assert.assertEquals(phoneNumber, employee.getPhone());


    }
}
