package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectViewHolder> {

    private final List<Employee> employees;
    private final ProjectOnClickListener onClickListener;

    public ProjectAdapter(List<Employee> employees) {
        this.employees = employees;
        onClickListener = new ProjectOnClickListener(employees);
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
        if(employees.get(position).getImageURL() != null) {
            Picasso.get().load(employees.get(position).getImageURL()).transform(new PicassoCircleTransformation()).into(holder.getImageView());
        }
        else Picasso.get().load(R.drawable.no_image).transform(new PicassoCircleTransformation()).into(holder.getImageView());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

}
