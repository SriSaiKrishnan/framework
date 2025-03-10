package com.sai.api.requestbuilder;

import com.sai.enums.ConfigProperties;
import com.sai.utility.PropertyUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public final class RequestBuilder {

    private RequestBuilder() {}

    private static String getBaseUrl(){
        return PropertyUtils.get(ConfigProperties.BASEURL);
    }

    public static RequestSpecification buildGetRequest(){

        return given()
                .log()
                .all()
                .baseUri(getBaseUrl());

    }

    public static RequestSpecification buildGetRequestWithQueryParam(String queryParam){

        return given()
                .log()
                .all()
                .baseUri(getBaseUrl())
                .queryParam(queryParam);

    }

    public static RequestSpecification buildGetRequestWithPathParam(String pathParam, String value){

        return given()
                .log()
                .all()
                .baseUri(getBaseUrl())
                .pathParam(pathParam,value);

    }

    public static RequestSpecification buildGetRequestWithQueryandPathParam(String queryParam, String pathParam, String value){

        return given()
                .log()
                .all()
                .baseUri(getBaseUrl())
                .queryParam(queryParam)
                .pathParam(pathParam,value);

    }

    public static RequestSpecification buildPostRequest(){

        return buildGetRequest()
                .header("Content-Type","application/json");

    }

    public static RequestSpecification buildPostRequestWithPathParam(String parameter, String value){

        return buildGetRequestWithPathParam(parameter, value)
                .header("Content-Type","application/json");

    }

}
