package com.example.project;

public class DatabaseTable {

    static class SQLEmployee {
        final static String TABLE_NAME = "employee";
        final static String COLUMN_NAME = "name";
        final static String COLUMN_POSITION = "position";
        final static String COLUMN_LOCATION = "location";
        final static String COLUMN_ID = "id";
        final static String COLUMN_DOB = "dob";
    }

    static final String SQL_CREATE_TABLE_EMPLOYEE =
            String.format("CREATE TABLE %s (%s INT PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s INT)",
                    SQLEmployee.TABLE_NAME,
                    SQLEmployee.COLUMN_ID,
                    SQLEmployee.COLUMN_NAME,
                    SQLEmployee.COLUMN_POSITION,
                    SQLEmployee.COLUMN_LOCATION,
                    SQLEmployee.COLUMN_DOB)
            ;

    static final String SQL_DELETE_TABLE_EMPLOYEE =
            String.format("DROP TABLE IF EXISTS %s", SQLEmployee.TABLE_NAME);
}
