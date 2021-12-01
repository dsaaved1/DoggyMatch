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

    // Local Variables
    private Button signInButton;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setValues();
        onLaunch(savedInstanceState);
        interact();
    }

    /**
     * Initialize Values
     */
    private void setValues()
    {
        // Buttons
        signInButton = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);
    }

    /**
     * Call with App State to check if the User is Logged in
     * If they are not signed in, it will present buttons for options
     * to either Register or Sign In.
     * @param savedInstanceState
     */
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

        // Assume the User is not Signed in.
        // If the User is not Signed in, do nothing.
    }

    /**
     * Wait for Interaction
     * then Handle interaction
     */
    private void interact()
    {
        // Buttons
        // Sign In -> Login
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        });
        // Sign Up -> Register
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Register.class));
                finish();
            }
        });
    }
}