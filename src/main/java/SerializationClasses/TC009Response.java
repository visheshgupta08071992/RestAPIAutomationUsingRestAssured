package SerializationClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;

import java.util.List;

public class TC009Response
{

    //private String per_page;

    public String getPer_page1() {
        return per_page1;
    }

    public void setPer_page1(String per_page1) {
        this.per_page1 = per_page1;
    }

    @JsonProperty("per_page")
    private String per_page1;

    @JsonIgnore
    private String total;

    private Ad ad;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    private List<Data> data;

    private String page;

    private String total_pages;

/*
    public String getPer_page ()
    {
        return per_page;
    }

    public void setPer_page (String per_page)
    {
        this.per_page = per_page;
    }
*/

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public Ad getAd ()
    {
        return ad;
    }

    public void setAd (Ad ad)
    {
        this.ad = ad;
    }


    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public String getTotal_pages ()
    {
        return total_pages;
    }

    public void setTotal_pages (String total_pages)
    {
        this.total_pages = total_pages;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [per_page = "+per_page1+", total = "+total+", ad = "+ad+", data = "+data+", page = "+page+", total_pages = "+total_pages+"]";
    }
}
