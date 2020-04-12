package com.RestAssured.Base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;



public class Base {
    public static RequestSpecification request;
    public static Response response;
    public static final String STATUS_200="200";
    public static final String STATUS_201="201";
    public static final String STATUS_400="400";
    public static final String STATUS_500="500";
    public static final String STATUS_204="204";

    //Hardcoded Input to Get details of Single employee and update employee
    public String empId="51838";

    public static void Assertions(){

    }

}
