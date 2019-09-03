package com.example.mapapp.POJO;

public class Feature {

    private String featureTitle;
    private int featureImageId;
    private boolean isActive;

    public Feature() {
    }

    public Feature(String featureTitle, int featureImageId, boolean isActive) {
        this.featureTitle = featureTitle;
        this.featureImageId = featureImageId;
        this.isActive = isActive;
    }

    public String getFeatureTitle() {
        return featureTitle;
    }

    public int getFeatureImageId() {
        return featureImageId;
    }

    public boolean isActive() {
        return isActive;
    }
}
