package com.qa.test;

import SerializationClasses.TC008FailureResponseClass;
import com.fasterxml.jackson.databind.ObjectMapper;
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

public class TC008_ValidateCompleteSuccessAndFailureResponseUsingSerializationAndDeserialization {


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

        }
        else if (statusCode==200){
            ObjectMapper objectMapper = new ObjectMapper();
            TC008FailureResponseClass failureResponse=objectMapper.readValue(responseBody,TC008FailureResponseClass.class);
//           TC008FailureResponseClass failureResponse=response.getBody().as(TC008FailureResponseClass.class);
            Assert.assertEquals(failureResponse.fault,"FAULT_USER_ALREADY_EXISTS");
            Assert.assertEquals(failureResponse.FaultId,"User already exists");
        }

    }
}
