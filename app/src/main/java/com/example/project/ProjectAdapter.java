package com.example.project;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectViewHolder> {

    private List<Employee> employees = new ArrayList<Employee>();
    private RecyclerView recyclerView;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sendIntent(recyclerView.getChildAdapterPosition(view));
        }
    };

    public ProjectAdapter(List<Employee> employees, RecyclerView recyclerView) {
        this.employees = employees;
        this.recyclerView = recyclerView;
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

    private void sendIntent(int position) {
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
