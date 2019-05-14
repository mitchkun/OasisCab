package com.example.oasiscab;

public class PastTripsClass {

//    local variable declaration
    private String dateTime;
    private String location;

    public PastTripsClass(String dateTime, String location){

        this.dateTime = dateTime;
        this.location = location;

    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
