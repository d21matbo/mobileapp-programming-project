package com.example.project;

public class Auxdata {
    private DoB dob;

    public Auxdata(int dob) {
        this.dob = new DoB(dob);
    }

    public DoB dob() {
        return dob;
    }
}
