package com.example.project;

public class DatabaseTable {

    static class SQLEmployee {
        final static String TABLE_NAME = "employee";
        final static String COLUMN_ID = "id";
        final static String COLUMN_NAME = "name";
        final static String COLUMN_POSITION = "position";
        final static String COLUMN_LOCATION = "location";
        final static String COLUMN_NUMBER = "number";
        final static String COLUMN_MAIL = "mail";
        final static String COLUMN_DOB = "dob";
    }

    static final String SQL_CREATE_TABLE_EMPLOYEE =
            String.format("CREATE TABLE %s (%s INT PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s INT, %s TEXT, %s INT)",
                    SQLEmployee.TABLE_NAME,
                    SQLEmployee.COLUMN_ID,
                    SQLEmployee.COLUMN_NAME,
                    SQLEmployee.COLUMN_POSITION,
                    SQLEmployee.COLUMN_LOCATION,
                    SQLEmployee.COLUMN_NUMBER,
                    SQLEmployee.COLUMN_MAIL,
                    SQLEmployee.COLUMN_DOB)
            ;

    static final String SQL_DELETE_TABLE_EMPLOYEE =
            String.format("DROP TABLE IF EXISTS %s", SQLEmployee.TABLE_NAME);

    static final String SQL_SELECT_ALL =
            "SELECT * FROM " + SQLEmployee.TABLE_NAME;

    static final String SQL_SELECT_WHERE_TIER_1 =
            "SELECT * FROM " + SQLEmployee.TABLE_NAME +
                    " WHERE " + SQLEmployee.COLUMN_POSITION +
                    " LIKE \"%tier 1%\"";

    static final String SQL_SELECT_WHERE_TIER_2 =
            "SELECT * FROM " + SQLEmployee.TABLE_NAME +
                    " WHERE " + SQLEmployee.COLUMN_POSITION +
                    " LIKE \"%tier 2%\"";
}
