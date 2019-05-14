package com.example.oasiscab;

public class FavouriteLocationClass {

    private String nameOrSignificance;
    private String location;

    public FavouriteLocationClass(String nameOrSignificance, String location){

        this.nameOrSignificance = nameOrSignificance;
        this.location = location;
    }

    public String getNameOrSignificance() {
        return nameOrSignificance;
    }

    public void setNameOrSignificance(String nameOrSignificance) {
        this.nameOrSignificance = nameOrSignificance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
