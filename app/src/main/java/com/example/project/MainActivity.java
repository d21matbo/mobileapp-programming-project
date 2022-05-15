package com.example.project;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseHelper = new DatabaseHelper(this);
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        editor = preferences.edit();
        Log.d("MainActivity", DatabaseTable.SQL_CREATE_TABLE_EMPLOYEE);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new ProjectAdapter(employees);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        new JsonFile(this, this).execute(JSON_FILE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(preferences.getInt("activeFilterItem",0));
        if (item != null) onOptionsItemSelected(item);
        MenuItem mItem = menu.findItem(R.id.action_update);
        mItem.setCheckable(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_update:
                item.setChecked(true);
                editor.putInt("activeFilterItem", 0);
                editor.putString("querySQL", DatabaseTable.SQL_SELECT_ALL);
                editor.apply();

                readSQLData();
                //new JsonFile(this, this).execute(JSON_FILE);
                return true;
            case R.id.action_test_1:
                item.setChecked(true);
                editor.putInt("activeFilterItem", R.id.action_test_1);
                editor.putString("querySQL", DatabaseTable.SQL_SELECT_WHERE_TIER_2);
                editor.apply();
                readSQLData();
                return true;
            case R.id.action_test_2:
                item.setChecked(true);
                editor.putInt("activeFilterItem", R.id.action_test_2);
                editor.apply();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPostExecute(String json) {
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Employee>>(){}.getType();
            ArrayList<Employee> fetchedList = gson.fromJson(json, type);
            writeSQLData(fetchedList);
            updateEmployees(fetchedList);
        }
    }

    private void writeSQLData(List<Employee> list) {
        for (Employee e: list) {
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
                preferences.getString("querySQL", DatabaseTable.SQL_SELECT_ALL), null, null
        );
        List<Employee> fetchedList = new ArrayList<>();
        while (cursor.moveToNext()) {
            fetchedList.add(new Employee(
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_POSITION)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_LOCATION)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_NUMBER)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_MAIL)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTable.SQLEmployee.COLUMN_DOB))
                    ));
        }
        updateEmployees(fetchedList);
    }

    private void updateEmployees(List<Employee> list) {
        employees.clear();
        employees.addAll(list);
        adapter.notifyDataSetChanged();
    }
}
