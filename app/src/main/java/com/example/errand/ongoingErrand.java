package com.example.errand;

public class ongoingErrand {
    private String ongoingErrandId;
    private String volunteerId;
    private String store;
    private long wait_time;
    private geoPoint gp;

    @Override
    public String toString() {
        return "ongoingErrand{" + '\n' +
                "ongoingErrandId= " + ongoingErrandId + '\n' +
                "volunteerId= " + volunteerId + '\n' +
                "store= " + store + '\n' +
                "wait_time= " + wait_time + '\n' +
                "latitude = " + gp.getLat() + '\n' +
                "longitude = " + gp.getLon() + '\n' +
                '}';
    }

    public ongoingErrand(String ongoingErrandId, String volunteerId, String store, long wait_time, geoPoint gp) {
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

    public geoPoint getGp() {
        return gp;
    }
}
