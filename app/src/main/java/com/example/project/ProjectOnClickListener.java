package com.example.project;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProjectOnClickListener implements View.OnClickListener {

    private List<Employee> employees;

    public ProjectOnClickListener(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public void onClick(View view) {
        RecyclerView recyclerView = (RecyclerView) view.getParent();
        Log.d("MainActivity", String.format("%d : %s", recyclerView.getChildAdapterPosition(view), employees.toString()));
        sendIntent(recyclerView, recyclerView.getChildAdapterPosition(view));
    }

    private void sendIntent(RecyclerView recyclerView, int position) {
        Intent intent = new Intent(recyclerView.getContext(), DetailActivity.class);

        intent.putExtra("Name", employees.get(position).getName());
        intent.putExtra("Position", employees.get(position).getPosition());
        intent.putExtra("DoB", employees.get(position).getDob());
        intent.putExtra("Id", employees.get(position).getId());
        intent.putExtra("Age", employees.get(position).getAge());
        intent.putExtra("Mail", employees.get(position).getMail());
        intent.putExtra("Location", employees.get(position).getLocation());
        intent.putExtra("Number", employees.get(position).getNumber());

        recyclerView.getContext().startActivity(intent);
    }
}
