package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityViewContact extends AppCompatActivity {

    ImageView imgView;
    TextView txtName, txtDescription;
    Button btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);

        imgView = findViewById(R.id.imgView);
        txtName = findViewById(R.id.txtName);
        txtDescription = findViewById(R.id.txtDescription);
        btnDial = findViewById(R.id.btnCall);

        Intent activityMain = getIntent();
        Bundle contactDetails = activityMain.getExtras();

        String name = contactDetails.getString("NAME");
        String description = contactDetails.getString("DESCRIPTION");
        int img = contactDetails.getInt("IMG", 0);

        imgView.setImageResource(img);
        txtName.setText(name);
        txtDescription.setText(description);

    }
}