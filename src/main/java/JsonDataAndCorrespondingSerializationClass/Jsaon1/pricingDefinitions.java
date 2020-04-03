package JsonDataAndCorrespondingSerializationClass.Jsaon1;

public class pricingDefinitions {
    private boolean allowsMeteredUsage;
    private String costType;
    private String costTypeCategory;
    private int increment;

    public boolean isAllowsMeteredUsage() {
        return allowsMeteredUsage;
    }

    public void setAllowsMeteredUsage(boolean allowsMeteredUsage) {
        this.allowsMeteredUsage = allowsMeteredUsage;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getCostTypeCategory() {
        return costTypeCategory;
    }

    public void setCostTypeCategory(String costTypeCategory) {
        this.costTypeCategory = costTypeCategory;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }
}
