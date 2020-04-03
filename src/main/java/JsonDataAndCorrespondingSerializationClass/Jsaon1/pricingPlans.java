package JsonDataAndCorrespondingSerializationClass.Jsaon1;

import java.util.List;

public class pricingPlans {
    private String currency;
    private int id;
    private String pricingPeriod;
    private List<pricingSources> pricingSource;


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
