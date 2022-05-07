package com.example.project;

import com.google.gson.annotations.SerializedName;

public class Employee {

    private String name;
    @SerializedName("company")
    private String position;
    @SerializedName("size")
    private int id;
    private DoB dob;
    private String location;
    @SerializedName("cost")
    private int number;
    @SerializedName("category")
    private String mail;

    public Employee(String name, String position, int id, DoB dob, String location, int number, String mail) {
        this.name = name;
        this.position = position;
        this.id = id;
        this.dob = dob;
        this.location = location;
        this.number = number;
        this.mail = mail;
    }

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    private String formatNumber(){
        String s = String.valueOf(number);
        return String.format("%s-%s %s-%s", s.substring(0,2), s.charAt(2),s.substring(3,7), s.substring(7,9));
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public String getDob() {
        return dob.getDoB();
    }

    public int getAge() {
        return dob.getCurrentAge();
    }

    public String getLocation() {
        return location;
    }

    public String getNumber() {
        return formatNumber();
    }

    public String getMail() {
        return mail;
    }
}
