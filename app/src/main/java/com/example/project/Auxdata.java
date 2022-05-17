package com.example.project;

public class Auxdata {
    private final DoB dob;
    private final String imageURL;

    public Auxdata(int dob, String imageURL) {
        this.dob = new DoB(dob);
        this.imageURL = imageURL;
    }

    public DoB getDob() {
        return dob;
    }

    public String getImageURL() {
        return imageURL;
    }
}
