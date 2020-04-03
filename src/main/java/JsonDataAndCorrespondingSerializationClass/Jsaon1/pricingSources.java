package JsonDataAndCorrespondingSerializationClass.Jsaon1;

import java.util.List;

public class pricingSources {
    private List<pricingDefinitions> pricingDefinition;
    private String source;

    public List<pricingDefinitions> getPricingDefinition() {
        return pricingDefinition;
    }

    public void setPricingDefinition(List<pricingDefinitions> pricingDefinition) {
        this.pricingDefinition = pricingDefinition;
    }
}
