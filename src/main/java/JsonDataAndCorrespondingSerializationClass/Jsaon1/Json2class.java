package JsonDataAndCorrespondingSerializationClass.Jsaon1;

import java.util.List;

public class Json2class {
    private branding branding;
    private List<editions> editions;
    private String id;
    private boolean stacked;
    private String type;


    public branding getBranding() {
        return branding;
    }

    public List<editions> getEditions() {
        return editions;
    }

    public String getId() {
        return id;
    }

    public boolean isStacked() {
        return stacked;
    }

    public String getType() {
        return type;
    }

    public void setBranding(branding branding) {
        this.branding = branding;
    }

    public void setEditions(List<editions> editions) {
        this.editions = editions;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStacked(boolean stacked) {
        this.stacked = stacked;
    }

    public void setType(String type) {
        this.type = type;
    }
}
