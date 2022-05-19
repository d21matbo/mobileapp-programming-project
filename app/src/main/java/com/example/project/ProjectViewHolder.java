package com.example.project;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectViewHolder extends RecyclerView.ViewHolder {
    private final ImageView imageView;
    private final TextView nameView;
    private final TextView positionView;

    public ProjectViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.employee_picture);
        nameView = itemView.findViewById(R.id.employee_name);
        positionView = itemView.findViewById(R.id.employee_position);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getNameView() {
        return nameView;
    }

    public TextView getPositionView() {
        return positionView;
    }
}
