package com.qa.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_REQUEST {

    @Test
    void getweatherDetails(){
        //Specify Base URI
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

        //Request Object
        RequestSpecification httpRequest=RestAssured.given();

        //Response Object
        Response response=httpRequest.request(Method.GET,"/Hyderabad");

        //Convert the Response Object to String
        String responseBody=response.getBody().asString();
        System.out.println("Response is -> " +responseBody);
        System.out.println("Status Code is -> " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200,"Status Code did not match");
        System.out.println("Status line is -> " + response.getStatusLine());
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK","Status Line did not match");
    }
}
