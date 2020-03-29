package com.example.errand;

import com.google.firebase.firestore.GeoPoint;

public class OngoingErrandModel {
    private String ongoingErrandId;
    private String volunteerId;
    private String store;
    private long wait_time;
    private GeoPoint gp;

    public void setOngoingErrandId(String ongoingErrandId) {
        this.ongoingErrandId = ongoingErrandId;
    }

    @Override
    public String toString() {
        return "ongoingErrand{" + '\n' +
                "ongoingErrandId= " + ongoingErrandId + '\n' +
                "volunteerId= " + volunteerId + '\n' +
                "store= " + store + '\n' +
                "wait_time= " + wait_time + '\n' +
                "latitude = " + gp.getLatitude() + '\n' +
                "longitude = " + gp.getLongitude() + '\n' +
                '}';
    }

    public OngoingErrandModel(String ongoingErrandId, String volunteerId, String store, long wait_time, GeoPoint gp) {
        this.ongoingErrandId = ongoingErrandId;
        this.volunteerId = volunteerId;
        this.store = store;
        this.wait_time = wait_time;
        this.gp = gp;
    }

    public String getOngoingErrandId() {
        return ongoingErrandId;
    }

    public String getVolunteerId() {
        return volunteerId;
    }

    public String getStore() {
        return store;
    }

    public long getWait_time() {
        return wait_time;
    }

    public GeoPoint getGp() {
        return gp;
    }
}
