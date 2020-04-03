package com.qa.test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_ValidatingJsonResponse {
    @Test
    public void getWeatherDetails(){
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET,"/Hyderabad");
        String responseBody=response.getBody().asString();
        System.out.println(responseBody);
        Assert.assertTrue(responseBody.contains("Hyderabad"),"Response Body does not contains Hyderabad");
    }
}
