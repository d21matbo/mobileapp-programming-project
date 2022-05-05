package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectViewHolder> {

    private List<Employee> employees = new ArrayList<Employee>();
    private ProjectOnClickListener onClickListener;

    public ProjectAdapter(List<Employee> employees, RecyclerView recyclerView) {
        this.employees = employees;
        onClickListener = new ProjectOnClickListener(recyclerView);
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        view.setOnClickListener(onClickListener);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.getNameView().setText(employees.get(position).getName());
        holder.getPositionView().setText(employees.get(position).getPosition());
        //holder.variable.setText, Set all values for the list_item
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
