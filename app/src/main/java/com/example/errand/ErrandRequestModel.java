package com.example.errand;

import com.google.firebase.firestore.GeoPoint;

public class ErrandRequestModel {

    private String requesterName;
    private GeoPoint requesterPosition;
    private String acceptedStatus;
    private boolean requesterIsVulnerable;
    private String items;
    private String reward;
    private String ongoingErrandId;

    @Override
    public String toString() {
        return "errandRequest{" +
                "volunteerId='" + volunteerId + '\'' +
                ", acceptedStatus='" + acceptedStatus + '\'' +
                ", store='" + store + '\'' +
                ", allowedServiceTime=" + allowedServiceTime +
                ", comments='" + comments + '\'' +
                ", errandCost=" + errandCost +
                ", errandId='" + errandId + '\'' +
                ", distance=" + distance +
                ", startPos=" + startPos +
                '}';
    }



    public ErrandRequestModel(String volunteerId, String acceptedStatus, String store, long allowedServiceTime, String comments, long errandCost, String errandId, long distance, GeoPoint startPos) {
        this.volunteerId = volunteerId;
        this.acceptedStatus = acceptedStatus;
        this.store = store;
        this.allowedServiceTime = allowedServiceTime;
        this.comments = comments;
        this.errandCost = errandCost;
        this.errandId = errandId;
        this.distance = distance;
        this.startPos = startPos;
    }

    public void setVolunteerId(String volunteerId) {
        this.volunteerId = volunteerId;
    }

    public void setErrandId(String errandId) {
        this.errandId = errandId;
    }

    public String getVolunteerId() {
        return volunteerId;
    }

    public String getAcceptedStatus() {
        return acceptedStatus;
    }

    public String getStore() {
        return store;
    }

    public long getAllowedServiceTime() {
        return allowedServiceTime;
    }

    public String getComments() {
        return comments;
    }

    public long getErrandCost() {
        return errandCost;
    }

    public String getErrandId() {
        return errandId;
    }

    public long getDistance() {
        return distance;
    }

    public GeoPoint getStartPos() {
        return startPos;
    }
}
