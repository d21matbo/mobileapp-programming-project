package com.example.project;

public class Auxdata {
    private final DoB dob;

    public Auxdata(int dob) {
        this.dob = new DoB(dob);
    }

    public DoB getDob() {
        return dob;
    }
}
