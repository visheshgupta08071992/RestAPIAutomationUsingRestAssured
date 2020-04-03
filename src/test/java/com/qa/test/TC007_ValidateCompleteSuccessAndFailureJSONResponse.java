package com.qa.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TC007_ValidateCompleteSuccessAndFailureJSONResponse {
    @Test
    void RegistrationSuccessful() throws IOException {
        //Specify BaseURI
        RestAssured.baseURI="http://restapi.demoqa.com/customer";
        //Request Specification
        RequestSpecification httpRequest=RestAssured.given();
        //Request paylaod sending along with post request
        JSONObject requestParams=new JSONObject();

        requestParams.put("FirstName","1Babuji111123");
        requestParams.put("LastName","1Babuji112113");
        requestParams.put("UserName","1Babuji112113");
        requestParams.put("Password","1Babuji112113");
        requestParams.put("Email","1JohBabuji1211113@gmail.com");

        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        //Response object
        Response response=httpRequest.request(Method.POST,"/register");


        //print response in console window

        String responseBody=response.getBody().asString();
        String actualJson = responseBody;
        System.out.println("Response Body is:" +responseBody);
        System.out.println(response.getStatusCode());

        //status code validation
        int statusCode=response.getStatusCode();
        if(statusCode==201){
            String expectedSuccessJson = FileUtils.readFileToString(new File("/Users/vishesh.gupta/Desktop/RestAPIAutomationUsingRestAssured/src/main/java/JsonData/TC007ExpectedSuccessJsonData"));
            JSONAssert.assertEquals(expectedSuccessJson, actualJson, JSONCompareMode.STRICT);
        }
        else if (statusCode==200){
            String expectedFailJson = FileUtils.readFileToString(new File("/Users/vishesh.gupta/Desktop/RestAPIAutomationUsingRestAssured/src/main/java/JsonData/TC007ExpectedFailJsonData"));
            JSONAssert.assertEquals(expectedFailJson, actualJson, JSONCompareMode.STRICT);
        }

    }
}
