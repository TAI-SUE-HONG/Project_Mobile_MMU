package com.emart.disco;

public class Location_list {
    private String Lname;
    private double latitude;
    private double longitude;
    private final float zoom=15;

    public Location_list(String lname, double latitude, double longitude) {
        this.Lname =lname;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLname() {
        return Lname;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public float getZoom() {
        return zoom;
    }
}
