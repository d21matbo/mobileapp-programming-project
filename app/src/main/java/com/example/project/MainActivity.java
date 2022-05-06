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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Employee> employees = new ArrayList<Employee>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        employees.add(new Employee("Kanj-ik Norin","Executive Director", 10010, new DoB(19900716), "Sweden", 789123, "kanj.nori@something.nihility.com"));
        employees.add(new Employee("Adam A", "Technician Tier 1"));
        employees.add(new Employee("Bertil B", "Technician Tier 2"));
        employees.add(new Employee("Ceria C", "Technician Tier 2"));
        employees.add(new Employee("Dean D", "Sales & Store Tier 1"));
        employees.add(new Employee("Eva E", "Sales & Store Tier 2"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ProjectAdapter adapter = new ProjectAdapter(employees, recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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

        return super.onOptionsItemSelected(item);
    }
}
