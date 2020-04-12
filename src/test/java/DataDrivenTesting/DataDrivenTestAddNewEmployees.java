package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataDrivenTestAddNewEmployees {
    @Test(dataProvider = "employeeData")
    void postNewEmployess(String empName,String empSal,String empAge){
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        RequestSpecification request=RestAssured.given();
        JSONObject requestParam=new JSONObject();
        requestParam.put("name",empName);
        requestParam.put("salary",empSal);
        requestParam.put("age",empAge);

        request.header("Content-Type","application/json");
        request.body(requestParam.toJSONString());


        Response response=request.request(Method.POST,"/create");
        String responseBody=response.getBody().asString();
        Assert.assertTrue(responseBody.contains(empName));
        Assert.assertTrue(responseBody.contains(empSal));
        Assert.assertTrue(responseBody.contains(empAge));
    }

    @DataProvider(name="employeeData")
    Object[][] getEmployeeData() throws IOException {

//        String path= System.getProperty("user.dir")+"/src/test/java/DataDrivenTesting/empdata.xlsx";
//        int rowCount=XLUtility.getRowCount(path,"Sheet1");
//        int columnCount=XLUtility.getCellCount(path,"Sheet1",1);
//        String [][] empData=new String[rowCount][columnCount];
//for(int i=1;i<=rowCount;i++){
//    for(int j=0;j<columnCount;j++){
//        empData[i-1][j]=XLUtility.getCellData(path,"Sheet1",i,j);
//
//    }
//}


        String [][] empData={{"Babu","90000","27"},{"Babulal","80999","25"},{"Babuji","987608","12"}};
        return (empData);
    }
}
