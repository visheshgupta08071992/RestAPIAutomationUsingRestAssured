package com.RestAssured.Testcases;

import com.RestAssured.Base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC005_Delete_Employee_Record extends Base {

        @BeforeClass
        void deleteEmployee() throws InterruptedException
        {
          //  logger.info("*********Started TC005_Delete_Employee_Record **********");

            RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
            request = RestAssured.given();

            response = request.request(Method.GET, "/employees");
            String responseBody=response.getBody().asString();

            // First get the JsonPath object instance from the Response interface
            String empID = response.jsonPath().get("data[0].id");

            System.out.println("Employee Id is :" +empID);
            response = request.request(Method.DELETE, "/delete/"+empId); //Pass ID to delete record

            Thread.sleep(3000);
        }

        @Test
        void checkResposeBody()
        {
            String responseBody = response.getBody().asString();
            System.out.println("Response is :" + responseBody);
            Assert.assertEquals(responseBody.contains("successfully! deleted Records"), true);

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

        @AfterClass
        void tearDown()
        {
//            logger.info("*********  Finished TC005_Delete_Employee_Record **********");
        }
}
