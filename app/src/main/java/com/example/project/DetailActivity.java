package com.example.project;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView profileView;
    private TextView nameView;
    private TextView positionView;
    private TextView idView;
    private TextView dobView;
    private TextView ageView;
    private TextView locationView;
    private TextView numberView;
    private TextView mailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        findViews();
        setViews();
    }

    //A method that groups the finding of the wanted views in one place.
    private void findViews(){
        profileView = findViewById(R.id.detail_profile);
        nameView = findViewById(R.id.detail_name);
        positionView = findViewById(R.id.detail_position);
        idView = findViewById(R.id.detail_id);
        dobView = findViewById(R.id.detail_dob);
        ageView = findViewById(R.id.detail_age);
        locationView = findViewById(R.id.detail_location);
        numberView = findViewById(R.id.detail_number);
        mailView = findViewById(R.id.detail_mail);
    }

    private void setViews(){
        nameView.setText(getIntent().getExtras().getString("Name", "Missing Name"));
        positionView.setText(getIntent().getExtras().getString("Position", "Missing"));
        dobView.setText(getIntent().getExtras().getString("DoB", "Missing"));
        idView.setText(String.valueOf(getIntent().getExtras().getInt("Id")));
        ageView.setText(String.valueOf(getIntent().getExtras().getInt("Age")));
        mailView.setText(getIntent().getExtras().getString("Mail", "Missing"));
        locationView.setText(getIntent().getExtras().getString("Location", "Missing"));
        numberView.setText(String.valueOf(getIntent().getExtras().getInt("Number")));

    }
}