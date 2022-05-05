package com.example.project;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class ProjectOnClickListener implements View.OnClickListener {

    private RecyclerView recyclerView;

    public ProjectOnClickListener(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public void onClick(View view) {
        sendIntent();
    }

    private void sendIntent(){
        Intent intent = new Intent(recyclerView.getContext(), DetailActivity.class);
        recyclerView.getContext().startActivity(intent);
    }
}
