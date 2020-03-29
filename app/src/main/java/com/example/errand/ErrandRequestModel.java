package com.example.errand;

import com.google.firebase.firestore.GeoPoint;

public class ErrandRequestModel {

    private String requesterName;
    private GeoPoint requesterPosition;
    private String acceptedStatus;
    private boolean requesterIsVulnerable;
    private String items;

    @Override
    public String toString() {
        return "ErrandRequestModel{" +
                "requesterName='" + requesterName + '\'' +
                ", requesterPosition=" + requesterPosition +
                ", acceptedStatus='" + acceptedStatus + '\'' +
                ", requesterIsVulnerable=" + requesterIsVulnerable +
                ", items='" + items + '\'' +
                ", reward='" + reward + '\'' +
                ", ongoingErrandId='" + ongoingErrandId + '\'' +
                '}';
    }

    private String reward;
    private String ongoingErrandId;

    public String getRequesterName() {
        return requesterName;
    }

    public GeoPoint getRequesterPosition() {
        return requesterPosition;
    }

    public String getAcceptedStatus() {
        return acceptedStatus;
    }

    public boolean isRequesterIsVulnerable() {
        return requesterIsVulnerable;
    }

    public String getItems() {
        return items;
    }

    public String getReward() {
        return reward;
    }

    public String getOngoingErrandId() {
        return ongoingErrandId;
    }

    public ErrandRequestModel(String requesterName, GeoPoint requesterPosition, String acceptedStatus, boolean requesterIsVulnerable, String items, String reward, String ongoingErrandId) {
        this.requesterName = requesterName;
        this.requesterPosition = requesterPosition;
        this.acceptedStatus = acceptedStatus;
        this.requesterIsVulnerable = requesterIsVulnerable;
        this.items = items;
        this.reward = reward;
        this.ongoingErrandId = ongoingErrandId;
    }
}
