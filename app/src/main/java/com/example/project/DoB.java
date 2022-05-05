package com.example.project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoB {

    private int dob;
    private String dobFormat;

    public DoB(int dob) {
        String a = String.valueOf(dob);
        if(a.length() != 8) {
            System.err.println("Not the correct length");
            return;
        }
        String year = a.substring(0, 4);
        String month = a.substring(4, 6);
        if(Integer.parseInt(month)<1 || Integer.parseInt(month)>12) {
            System.err.println("Not a valid month");
            return;
        }
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String day = a.substring(6, 8);
        if(Integer.parseInt(day) < 1 || Integer.parseInt(day) > daysInMonth[Integer.parseInt(month)-1]) {
            System.err.println("Not a valid day");
            return;
        }
        this.dob = dob;
        dobFormat = String.format("%s-%s-%s", year, month, day);
    }

    public int getCurrentAge() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String s = String.valueOf(Integer.parseInt(dateFormat.format(new Date()))-dob);
        return Integer.parseInt(s.substring(0,2));
    }

    public String getDoB() {
        return dobFormat;
    }
}
