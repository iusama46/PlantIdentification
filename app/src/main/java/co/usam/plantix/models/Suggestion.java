
package co.usam.plantix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Suggestion {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("plant")
    @Expose
    private PlantInfo plantInfo;
    @SerializedName("probability")
    @Expose
    private Double probability;
    @SerializedName("confidence")
    @Expose
    private Double confidence;
    @SerializedName("similar_images")
    @Expose
    private Object similarImages;
    @SerializedName("confirmed")
    @Expose
    private Boolean confirmed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlantInfo getPlantInfo() {
        return plantInfo;
    }

    public void setPlantInfo(PlantInfo plantInfo) {
        this.plantInfo = plantInfo;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Object getSimilarImages() {
        return similarImages;
    }

    public void setSimilarImages(Object similarImages) {
        this.similarImages = similarImages;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

}
