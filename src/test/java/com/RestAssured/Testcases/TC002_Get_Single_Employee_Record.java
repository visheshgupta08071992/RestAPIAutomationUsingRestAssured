package com.RestAssured.Testcases;

import com.RestAssured.Base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002_Get_Single_Employee_Record extends Base {


    @BeforeClass
    void getEmployeeData() throws InterruptedException
    {


        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        request = RestAssured.given();
        response = request.request(Method.GET, "/employee/"+empId);

        Thread.sleep(7000);
    }

    @Test
    void checkResposeBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains(empId), true);
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void checkResponseTime()
    {
        long responseTime = response.getTime(); // Getting status Line
        Assert.assertTrue(responseTime<6000);

    }

    @Test
    void checkstatusLine()
    {
        String statusLine = response.getStatusLine(); // Gettng status Line
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

    @Test
    void checkContentType()
    {
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "text/html; charset=UTF-8");
    }

    @Test
    void checkserverType()
    {
        String serverType = response.header("Server");
        Assert.assertEquals(serverType, "nginx/1.14.1");
    }

    @Test
    void checkContentLenght()
    {
        String contentLength = response.header("Content-Length");
        Assert.assertTrue(Integer.parseInt(contentLength)<1500);
    }
}
