package com.example.errand;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.GeoPoint;

public class OngoingErrandModel {
    private String ongoingErrandId;
    private String volunteerId;
    private String store;
    private long wait_time;
    private GeoPoint gp;
    private String category;
    private String name;
    private String reward;
    private Timestamp time;

    public void setOngoingErrandId(String ongoingErrandId) {
        this.ongoingErrandId = ongoingErrandId;
    }

    @Override
    public String toString() {
        return "OngoingErrandModel{" +
                "ongoingErrandId='" + ongoingErrandId + '\'' +
                ", volunteerId='" + volunteerId + '\'' +
                ", store='" + store + '\'' +
                ", wait_time=" + wait_time +
                ", gp=" + gp +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", reward=" + reward +
                ", time=" + time +
                '}';
    }

    public OngoingErrandModel(String ongoingErrandId, String volunteerId, String store, long wait_time, GeoPoint gp, String category, String name, String reward, Timestamp time) {
        this.ongoingErrandId = ongoingErrandId;
        this.volunteerId = volunteerId;
        this.store = store;
        this.wait_time = wait_time;
        this.gp = gp;
        this.category = category;
        this.name = name;
        this.reward = reward;
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getReward() {
        return reward;
    }

    public Timestamp getTime() {
        return time;
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
