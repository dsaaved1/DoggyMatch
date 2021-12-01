package com.example.homeplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Launch Page - Opens the Login or Goes to Home
 * if the User is signed in already.
 * @author Corbin Graham
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onLaunch(savedInstanceState);
    }

    //Handle Interaction
    private void onLaunch(Bundle savedInstanceState)
    {
        //TODO
        // Go straight to home page if the user is logged in and not active on another device
        // using saved instance.
        // This can be done using an object request to the server too.
        // User->Status?

        /*
        if(savedInstanceState.getBoolean("isActive") || !savedInstanceState.getBoolean("isLogged"))
        {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
            finish();
        }


         */

        // Currently Assuming the User is not signed in to this device.
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
        finish();
    }
}