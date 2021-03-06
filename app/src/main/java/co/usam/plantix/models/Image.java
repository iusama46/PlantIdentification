
package co.usam.plantix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("file_name")
    @Expose
    private String fileName;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("url_small")
    @Expose
    private String urlSmall;
    @SerializedName("url_tiny")
    @Expose
    private String urlTiny;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlSmall() {
        return urlSmall;
    }

    public void setUrlSmall(String urlSmall) {
        this.urlSmall = urlSmall;
    }

    public String getUrlTiny() {
        return urlTiny;
    }

    public void setUrlTiny(String urlTiny) {
        this.urlTiny = urlTiny;
    }

}
