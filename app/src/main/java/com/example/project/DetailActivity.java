package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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
}