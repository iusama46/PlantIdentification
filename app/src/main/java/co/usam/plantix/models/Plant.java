package co.usam.plantix.models;

import java.io.Serializable;

public class Plant implements Serializable {
    String id;
    String name;
    String commonName;
    double confidence;
    double probability;
    String wikiUrl;
    boolean isConfirmed;


    public Plant(String id, String name, String commonName, double confidence, double probability, String wikiUrl, boolean isConfirmed) {
        this.id = id;
        this.name = name;
        this.commonName = commonName;
        this.confidence = confidence;
        this.probability = probability;
        this.wikiUrl = wikiUrl;
        this.isConfirmed = isConfirmed;
    }

    public Plant(String id, String name, String commonName, double confidence, double probability, String wikiUrl) {
        this.id = id;
        this.name = name;
        this.commonName = commonName;
        this.confidence = confidence;
        this.probability = probability;
        this.wikiUrl = wikiUrl;
    }

    public Plant(String id, String name, double confidence, double probability, String wikiUrl) {
        this.id = id;
        this.name = name;
        this.confidence = confidence;
        this.probability = probability;
        this.wikiUrl = wikiUrl;
    }

    public Plant() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public double getConfidence() {
        //double temp = Math.round(confidence*10000);
        //return temp/100;
        return confidence ;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public double getProbability() {
       // return Math.round(probability * 100.0) / 100.0;
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
