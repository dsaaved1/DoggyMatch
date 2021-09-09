package com.example.example;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    TextView name;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof_activity);
        name = (TextView) findViewById(R.id.usern);
        Intent intent = getIntent();
        String usname = intent.getStringExtra("message_key");
        name.setText(usname);
    }
}
