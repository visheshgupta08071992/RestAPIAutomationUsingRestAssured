package JsonDataAndCorrespondingSerializationClass.Jsaon1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class editions {
    @JsonProperty("freeTrialTerms")
    private freeTrialTerms fTT;
    private String id;
    private String name;
//    @JsonIgnore
//    private List<pricingPlans> pricingPlan;
    private String revenueModel;

    public freeTrialTerms getfTT() {
        return fTT;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
//    @JsonIgnore
//    public List<pricingPlans> getPricingPlan() {
//        return pricingPlan;
//    }

    public String getRevenueModel() {
        return revenueModel;
    }

    public void setfTT(freeTrialTerms fTT) {
        this.fTT = fTT;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
//    @JsonIgnore
//    public void setPricingPlan(List<pricingPlans> pricingPlan) {
//        this.pricingPlan = pricingPlan;
//    }

    public void setRevenueModel(String revenueModel) {
        this.revenueModel = revenueModel;
    }
}
