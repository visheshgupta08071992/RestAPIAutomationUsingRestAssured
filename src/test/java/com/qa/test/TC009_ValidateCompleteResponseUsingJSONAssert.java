package com.qa.test;

import SerializationClasses.TC008FailureResponseClass;
import SerializationClasses.TC009Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class TC009_ValidateCompleteResponseUsingJSONAssert {
    @Test
    public void getWeatherDetails() throws IOException {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/users?page=2");
        String responseBody = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        TC009Response responseObject=objectMapper.readValue(responseBody, TC009Response.class);
      responseObject.getData().get(0).getAvatar();
      responseObject.getPage();
      responseObject.getAd().getCompany();





    }
}
