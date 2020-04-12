package com.RestAssured.Testcases;

import com.RestAssured.Base.Base;
import com.RestAssured.Utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC004_Put_Employee_Record extends Base {
    String empName= RestUtils.empName();
    String empSalary=RestUtils.empSal();
    String empAge=RestUtils.empAge();


    @BeforeClass
    void updateEmployee() throws InterruptedException
    {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        request = RestAssured.given();

        // JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
        //{"name":"John123X","salary":"123","age":"23"}
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", empName); // Cast
        requestParams.put("salary", empSalary);
        requestParams.put("age", empAge);

        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        response = request.request(Method.PUT, "/update/"+empId);

        Thread.sleep(5000);

    }

    @Test
    void checkResposeBody()
    {
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        Assert.assertEquals(responseBody.contains(empName), true);
        Assert.assertEquals(responseBody.contains(empSalary), true);
        Assert.assertEquals(responseBody.contains(empAge), true);
    }

    @Test
    void checkStatusCode()
    {
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
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
    void checkcontentEncoding()
    {
        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(contentEncoding, "gzip");

    }

}
