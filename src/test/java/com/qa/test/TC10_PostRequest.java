package com.qa.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TC10_PostRequest {
    @Test
    void RegistrationSuccessful() throws IOException {
        //Specify BaseURI
        RestAssured.baseURI="http://restapi.demoqa.com/customer";
        //Request Specification
        RequestSpecification httpRequest=RestAssured.given();
        //Request paylaod sending along with post request
        JSONObject requestParams=new JSONObject();

        String expectedSuccessJson = FileUtils.readFileToString(new File("/Users/vishesh.gupta/Desktop/RestAPIAutomationUsingRestAssured/src/main/java/JsonData/TC10RequestPayload"));

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(expectedSuccessJson); // attach above data to the request

        //Response object
        Response response=httpRequest.request(Method.POST,"/register");


        //print response in console window

        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 201);

        //success code validation
        String successCode=response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");

    }
}
