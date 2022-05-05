package com.example.project;

    public class Employee {
    private String name;
    private String position;
    private int id;
    //private Date dob;
    private int age; //Derived
    private String location;
    private int number;
    private String mail;


    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
