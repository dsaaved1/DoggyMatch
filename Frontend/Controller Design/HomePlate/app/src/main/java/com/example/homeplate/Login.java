package com.example.homeplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.homeplate.model.staticUser;

/** Login Page
 * Retrieves User Email and Password
 * and sends it for check before moving
 * to next page.
 * @author Corbin Graham
 */
public class Login extends AppCompatActivity {

    // Local Fields
    private Button continueButton;      // Continue Button
    private TextView registerButton;    // Register Button (Textbox)
    private TextView pageTitle;         // "Sign In" Title
    private TextView usernameBox;       // Textbox for Username
    private TextView passwordBox;       // Textbox for Password
    private TextView statusBox;         // Textbox for Login Status

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
                MessageReturn message = DoggyInterface.DoggyController.login(usernameBox.getText().toString(), passwordBox.getText().toString());
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
