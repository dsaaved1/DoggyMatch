package com.example.homeplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button continueButton;
    private TextView pageTitle;
    private TextView usernameBox;
    private TextView passwordBox;

    private Button homeButton;
    private TextView homeTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setValues();
        interact();
    }

    //Set Interaction Values
    private void setValues()
    {
        //Buttons
        continueButton = findViewById(R.id.continueButton);

        homeButton = findViewById(R.id.homeButton);
        homeTitle = findViewById(R.id.pageTitleHome);

        //TextView
        pageTitle = findViewById(R.id.pageTitleMain);

        //TextBox
        usernameBox = findViewById(R.id.usernameBox);
        passwordBox = findViewById(R.id.passwordBox);
    }

    //Handle Interaction
    private void interact()
    {

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pageTitle.setText("YES!");

                setContentView(R.layout.activity_home);


            }
        });

    }
}