package JsonDataAndCorrespondingSerializationClass.Jsaon1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class RetrieveJson2ResponseIntoObject {
    @Test
    public void retrieveJson() throws IOException {
        String responseBody = FileUtils.readFileToString(new File("/Users/vishesh.gupta/Desktop/RestAPIAutomationUsingRestAssured/src/main/java/JsonDataAndCorrespondingSerializationClass/Jsaon1/Json2.Json"));

        ObjectMapper objectMapper = new ObjectMapper();
        Json2class responseObject = objectMapper.readValue(responseBody, Json2class.class);
    responseObject.getEditions().get(0).getfTT().getFreeTrialDuration();
        responseObject.getEditions().get(0).getName();
    //    responseObject.getEditions().get(1).getId();
  //  responseObject.getEditions().get(2).getName();
 //   responseObject.getEditions().get(3).getPricingPlan().get(0).getCurrency();
   // responseObject.getEd().get(3).getPricingPlan().get(1)
        responseObject.getBranding().getDesc();
        responseObject.getBranding().getHref();
        responseObject.getId();
        responseObject.getType();
        responseObject.isStacked();
    }
}
