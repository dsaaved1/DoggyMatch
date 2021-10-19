package com.example.homeplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button continueButton;
    TextView doggyTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setValues();
        interact();
    }

    //Set Interaction Values
    public void setValues()
    {
        //Buttons
        continueButton = findViewById(R.id.continueButton);

        //TextView
        doggyTitle = findViewById(R.id.doggyTitle);

        //TextBox

    }

    //Handle Interaction
    public void interact()
    {

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doggyTitle.setText("YES!");

            }
        });

    }
}