
package co.usam.plantix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlantInfo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("common_name")
    @Expose
    private Object commonName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getCommonName() {
        return commonName;
    }

    public void setCommonName(Object commonName) {
        this.commonName = commonName;
    }

}
