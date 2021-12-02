package com.example.homeplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/** Login Page
 * Retrieves User Email and Password
 * and sends it for check before moving
 * to next page.
 * @author Corbin Graham
 */
public class Login extends AppCompatActivity {

    // Local Fields
    private Button continueButton;
    private TextView registerButton;
    private TextView pageTitle;
    private TextView usernameBox;
    private TextView passwordBox;
    private TextView statusBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setValues();
        interact();
    }

    /**
     * Initialize Fields
     * and Values
     */
    private void setValues()
    {
        // Buttons
        continueButton = findViewById(R.id.continueButton);
        registerButton = findViewById(R.id.registerTextButton);

        //TextView
        pageTitle = findViewById(R.id.pageTitleLogin);

        //TextBox
        usernameBox = findViewById(R.id.usernameBox);
        passwordBox = findViewById(R.id.passwordBox);
        statusBox = findViewById(R.id.statusBox);
    }

    /**
     * Wait for Interaction
     * then Handle interaction
     */
    private void interact()
    {
        // Continue Button
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageReturn message = DoggyController.login(usernameBox.getText().toString(), passwordBox.getText().toString());
                if(message.getStatus() != DoggyInterface.Status.SUCCESS)
                {
                    statusBox.setText("Status: " + message.getMessage());
                }
                else if (message.getStatus() == DoggyInterface.Status.SUCCESS)
                {
                    startActivity(new Intent(Login.this, Home.class));
                    finish();
                }
            }
        });

        // Register Button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
                finish();
            }
        });
    }
}
