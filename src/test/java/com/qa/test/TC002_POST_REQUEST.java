package com.qa.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_POST_REQUEST {
    @Test
    void RegistrationSuccessful(){
        //Specify BaseURI
        RestAssured.baseURI="http://restapi.demoqa.com/customer";
        //Request Specification
        RequestSpecification httpRequest=RestAssured.given();
        //Request paylaod sending along with post request
        JSONObject requestParams=new JSONObject();

        requestParams.put("FirstName","1Babu1ji1123");
        requestParams.put("LastName","1Babuj1i1213");
        requestParams.put("UserName","1Babuj1i1213");
        requestParams.put("Password","1Babuji11213");
        requestParams.put("Email","1JohBabuji112113@gmail.com");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

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
