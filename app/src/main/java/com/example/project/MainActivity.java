package com.example.project;

import android.content.Intent;
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
            new JsonFile(this, this).execute(JSON_FILE);
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

    }

    private void readSQLData() {

    }
}
