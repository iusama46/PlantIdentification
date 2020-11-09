
package co.usam.plantix.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("custom_id")
    @Expose
    private Object customId;
    @SerializedName("custom_url")
    @Expose
    private Object customUrl;
    @SerializedName("callback_url")
    @Expose
    private Object callbackUrl;
    @SerializedName("latitude")
    @Expose
    private Object latitude;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("week")
    @Expose
    private Object week;
    @SerializedName("created")
    @Expose
    private Double created;
    @SerializedName("sent")
    @Expose
    private Double sent;
    @SerializedName("classified")
    @Expose
    private Double classified;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("suggestions")
    @Expose
    private List<Suggestion> suggestions = null;
    @SerializedName("parameters")
    @Expose
    private List<Object> parameters = null;
    @SerializedName("feedback")
    @Expose
    private Object feedback;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("fail_cause")
    @Expose
    private Object failCause;
    @SerializedName("countable")
    @Expose
    private Boolean countable;
    @SerializedName("source")
    @Expose
    private String source;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getCustomId() {
        return customId;
    }

    public void setCustomId(Object customId) {
        this.customId = customId;
    }

    public Object getCustomUrl() {
        return customUrl;
    }

    public void setCustomUrl(Object customUrl) {
        this.customUrl = customUrl;
    }

    public Object getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(Object callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getWeek() {
        return week;
    }

    public void setWeek(Object week) {
        this.week = week;
    }

    public Double getCreated() {
        return created;
    }

    public void setCreated(Double created) {
        this.created = created;
    }

    public Double getSent() {
        return sent;
    }

    public void setSent(Double sent) {
        this.sent = sent;
    }

    public Double getClassified() {
        return classified;
    }

    public void setClassified(Double classified) {
        this.classified = classified;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public List<Object> getParameters() {
        return parameters;
    }

    public void setParameters(List<Object> parameters) {
        this.parameters = parameters;
    }

    public Object getFeedback() {
        return feedback;
    }

    public void setFeedback(Object feedback) {
        this.feedback = feedback;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Object getFailCause() {
        return failCause;
    }

    public void setFailCause(Object failCause) {
        this.failCause = failCause;
    }

    public Boolean getCountable() {
        return countable;
    }

    public void setCountable(Boolean countable) {
        this.countable = countable;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
