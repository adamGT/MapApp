package com.example.mapapp.POJO;

public class Feature {

    private String featureTitle;
    private String featureDescription;
    private int featureImageId;
    private boolean isActive;

    public Feature() {
    }

    public Feature(String featureTitle,String featureDescription, int featureImageId, boolean isActive) {
        this.featureTitle = featureTitle;
        this.featureDescription = featureDescription;
        this.featureImageId = featureImageId;
        this.isActive = isActive;
    }

    public String getFeatureTitle() {
        return featureTitle;
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public int getFeatureImageId() {
        return featureImageId;
    }

    public boolean isActive() {
        return isActive;
    }
}
