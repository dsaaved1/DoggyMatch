package com.example.homeplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private Button homeButton;
    private Button chatButton;
    private Button profileButton;
    private TextView pageHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setValues();
    }

    private void setValues()
    {
        //Buttons

        /*
        Possibly:
            DoggyButtons handles all, each is a DoggyButton

        Class DoggyButton setValues(List names, List assignments)
            Pass a list of button names
            Pass a list of assignments
            Convert them to buttons and then use the another class for actions
           Example:
                nameList: homeButton, chatButton, profileButton
                assignmentList: R.id.homeButton, ...
         */

        /*
            DoggyButton interact(Button, Action)
         */


    }

    private void interact()
    {

    }
}