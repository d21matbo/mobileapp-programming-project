package com.example.project;

import com.google.gson.annotations.SerializedName;

public class Employee {

    private final String name;
    @SerializedName("company")
    private final String position;
    @SerializedName("size")
    private final int id;
    private final String location;
    @SerializedName("cost")
    private final int number;
    @SerializedName("category")
    private final String mail;
    private final Auxdata auxdata;

    public Employee(int id, String name, String position, String location, int number, String mail, int dob, String imageURL) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.location = location;
        this.number = number;
        this.mail = mail;
        auxdata = new Auxdata(dob, imageURL);
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
        return auxdata.getDob().getDateOfBirth();
    }

    public int getDobRaw() {
        return auxdata.getDob().getDateOfBirthRaw();
    }

    public int getAge() {
            return auxdata.getDob().getCurrentAge();
    }

    public String getLocation() {
        return location;
    }

    public String getNumber() {
        return formatNumber();
    }

    public int getNumberRaw() {
        return number;
    }

    public String getMail() {
        return mail;
    }

    public String getImageURL() {
        return auxdata.getImageURL();
    }
}
