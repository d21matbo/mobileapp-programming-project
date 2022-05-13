package com.example.project;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_FILE = "employees.json";

    private final List<Employee> employees = new ArrayList<Employee>();
    private ProjectAdapter adapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseHelper = new DatabaseHelper(this);
        Log.d("MainActivity", DatabaseTable.SQL_CREATE_TABLE_EMPLOYEE);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new ProjectAdapter(employees);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new JsonFile(this, this).execute(JSON_FILE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);

            startActivity(intent);
            return true;
        }
        if(id == R.id.action_update) {
            readSQLData();
            //writeSQLData();
            //new JsonFile(this, this).execute(JSON_FILE);
            //TODO: add Json code that works with internet data.
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostExecute(String json) {
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Employee>>(){}.getType();
            ArrayList<Employee> fetchedList = gson.fromJson(json, type);
            employees.clear();
            employees.addAll(fetchedList);

            adapter.notifyDataSetChanged();
        }
    }

    private void writeSQLData() {
        for (Employee e: employees) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseTable.SQLEmployee.COLUMN_ID, e.getId());
            contentValues.put(DatabaseTable.SQLEmployee.COLUMN_NAME, e.getName());
            contentValues.put(DatabaseTable.SQLEmployee.COLUMN_POSITION, e.getPosition());
            contentValues.put(DatabaseTable.SQLEmployee.COLUMN_LOCATION, e.getLocation());
            contentValues.put(DatabaseTable.SQLEmployee.COLUMN_NUMBER, e.getNumberRaw());
            contentValues.put(DatabaseTable.SQLEmployee.COLUMN_MAIL, e.getMail());
            contentValues.put(DatabaseTable.SQLEmployee.COLUMN_DOB, e.getDobRaw());
            databaseHelper.getWritableDatabase().insert(
                    DatabaseTable.SQLEmployee.TABLE_NAME,
                    null,
                    contentValues);
        }
    }

    private void readSQLData() {
        @SuppressLint("Recycle")
        Cursor cursor = databaseHelper.getReadableDatabase().rawQuery(
                "SELECT * FROM " + DatabaseTable.SQLEmployee.TABLE_NAME, null, null
        );
        List<Employee> temp = new ArrayList<>();
        while (cursor.moveToNext()) {
            temp.add(new Employee(
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_POSITION)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_LOCATION)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_NUMBER)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_MAIL)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_DOB))
                    ));
        }
        employees.clear();
        employees.addAll(temp);
        adapter.notifyDataSetChanged();
    }
}
