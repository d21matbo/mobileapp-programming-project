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
        final static String COLUMN_AGE = "age";
        final static String COLUMN_URL = "url";
    }

    static final String SQL_CREATE_TABLE_EMPLOYEE =
            String.format("CREATE TABLE %s (%s INT PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s INT, %s TEXT, %s INT, %s INT, %s TEXT)",
                    SQLEmployee.TABLE_NAME,
                    SQLEmployee.COLUMN_ID,
                    SQLEmployee.COLUMN_NAME,
                    SQLEmployee.COLUMN_POSITION,
                    SQLEmployee.COLUMN_LOCATION,
                    SQLEmployee.COLUMN_NUMBER,
                    SQLEmployee.COLUMN_MAIL,
                    SQLEmployee.COLUMN_DOB,
                    SQLEmployee.COLUMN_AGE,
                    SQLEmployee.COLUMN_URL)
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

    static final String SQL_SELECT_WHERE_AGE_GTEQ_25 =
            String.format("SELECT * FROM %s WHERE %s >= 25", SQLEmployee.TABLE_NAME, SQLEmployee.COLUMN_AGE);
}
