package com.example.project;

public class Employee {
    private String name;
    private String position;
    private int id;
    private DoB dob;
    private int age; //Derived
    private String location;
    private int number;
    private String mail;

    public Employee(String name, String position, int id, DoB dob, String location, int number, String mail) {
        this.name = name;
        this.position = position;
        this.id = id;
        this.dob = dob;
        this.location = location;
        this.number = number;
        this.mail = mail;

        age = dob.getCurrentAge();
    }

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

    public int getId() {
        return id;
    }

    public String getDob() {
        return dob.getDoB();
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public int getNumber() {
        return number;
    }

    public String getMail() {
        return mail;
    }
}
