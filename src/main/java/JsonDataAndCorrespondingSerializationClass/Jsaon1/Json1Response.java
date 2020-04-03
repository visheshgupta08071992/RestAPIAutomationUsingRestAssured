package JsonDataAndCorrespondingSerializationClass.Jsaon1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Json1Response {
    private List<String> bundleIds;
    private String buyerCompanyId;
    private String buyerUserId;
    private String currency;
    private String ownerCompanyId;
    private String ownerUserId;
    private List<String> pricingPlanIds;
    private List<String> productIds;
    private List<String> subscriptionIds;

    public List<String> getBundleIds() {
        return bundleIds;
    }

    public String getBuyerCompanyId() {
        return buyerCompanyId;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public String getCurrency() {
        return currency;
    }

    public String getOwnerCompanyId() {
        return ownerCompanyId;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public List<String> getPricingPlanIds() {
        return pricingPlanIds;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public List<String> getSubscriptionIds() {
        return subscriptionIds;
    }

    public void setBundleIds(List<String> bundleIds) {
        this.bundleIds = bundleIds;
    }

    public void setBuyerCompanyId(String buyerCompanyId) {
        this.buyerCompanyId = buyerCompanyId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setOwnerCompanyId(String ownerCompanyId) {
        this.ownerCompanyId = ownerCompanyId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public void setPricingPlanIds(List<String> pricingPlanIds) {
        this.pricingPlanIds = pricingPlanIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public void setSubscriptionIds(List<String> subscriptionIds) {
        this.subscriptionIds = subscriptionIds;
    }
}
