package JsonDataAndCorrespondingSerializationClass.Jsaon1;

import SerializationClasses.TC009Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class RetrieveJson1ResponseIntoObject {
    @Test
public void retrieveJson() throws IOException {
    String responseBody = FileUtils.readFileToString(new File("/Users/vishesh.gupta/Desktop/RestAPIAutomationUsingRestAssured/src/main/java/JsonDataAndCorrespondingSerializationClass/Jsaon1/Json1"));

    ObjectMapper objectMapper = new ObjectMapper();
    Json1Response responseObject = objectMapper.readValue(responseBody, Json1Response.class);
        Assert.assertEquals(responseObject.getBundleIds().get(0),"300");
        Assert.assertEquals(responseObject.getBundleIds().get(1),"400");
        responseObject.getProductIds().get(0);
        responseObject.getProductIds().get(1);
        responseObject.getCurrency();
        responseObject.getBuyerUserId();

    }
}
