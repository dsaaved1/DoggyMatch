package com.example.homeplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setValues();
        interact();
    }

    //Handle Interaction
    private void interact()
    {
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
        finish();

    }
}