package com.example.errand;

public class geoPoint implements Comparable<geoPoint> {
    private double lat;
    private double lon;

    public geoPoint(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public int compareTo(geoPoint o) {
        return 0;
    }
}
