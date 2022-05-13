package com.example.project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoB {

    private final int dateOfBirth;

    public DoB(int dob) {
        dateOfBirth = dob;
    }

    public int getCurrentAge() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String s = String.valueOf(Integer.parseInt(dateFormat.format(new Date()))-dateOfBirth);
        return Integer.parseInt(s.substring(0,2));
    }

    public String getDateOfBirth() {
        String s = String.valueOf(dateOfBirth);
        return String.format("%s-%s-%s", s.substring(0, 4), s.substring(4, 6), s.substring(6, 8));
    }

    public int getDateOfBirthRaw() {
        return dateOfBirth;
    }
}
