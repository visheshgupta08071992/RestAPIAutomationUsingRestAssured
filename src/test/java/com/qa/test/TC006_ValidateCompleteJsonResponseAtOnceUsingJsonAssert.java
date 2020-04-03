package com.qa.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.File;
import java.io.IOException;

public class TC006_ValidateCompleteJsonResponseAtOnceUsingJsonAssert {
    @Test
    public void getWeatherDetails() throws IOException {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET,"/Hyderabad");
        String responseBody=response.getBody().asString();
        System.out.println(responseBody);
        Assert.assertTrue(responseBody.contains("Hyderabad"),"Response Body does not contains Hyderabad");
        String expectedJson = FileUtils.readFileToString(new File("/Users/vishesh.gupta/Desktop/RestAPIAutomationUsingRestAssured/src/main/java/JsonData/TC006ExpectedJsonData"));
        String actualJson = responseBody;
        JSONAssert.assertEquals(expectedJson, actualJson, JSONCompareMode.STRICT);
    }
}
