package com.example.project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectViewHolder extends RecyclerView.ViewHolder {
    //Add views from the list_item.xml
    private TextView nameView;
    private TextView positionView;

    public ProjectViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.employee_name);
        positionView = itemView.findViewById(R.id.employee_position);
    }

    public TextView getNameView() {
        return nameView;
    }

    public TextView getPositionView() {
        return positionView;
    }
}
