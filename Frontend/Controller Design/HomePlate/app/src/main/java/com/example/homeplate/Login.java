package com.example.homeplate;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;
import com.example.homeplate.model.staticUser;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homeplate.DoggyInterface;
import com.example.homeplate.api.ApiClientFacotry;
import com.example.homeplate.api.SlimCallback;
import com.example.homeplate.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private Button continueButton;
    private TextView registerButton;
    private TextView pageTitle;
    private TextView usernameBox;
    private TextView passwordBox;
    private TextView failed;
private String email;
private String password;
    private boolean fail= false;

    //private MyDoggy doggy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setValues();
        interact();
    }

    //Set Interaction Values
    private void setValues()
    {
        //Buttons
        continueButton = findViewById(R.id.continueButton);
        registerButton = findViewById(R.id.registerTextButton);
        //TextView
        pageTitle = findViewById(R.id.pageTitleLogin);

        //TextBox
        usernameBox = findViewById(R.id.usernameBox);
        passwordBox = findViewById(R.id.passwordBox);
        failed = findViewById(R.id.failed);
    }

    //Handle Interaction
    private void interact()
    {

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                // Verify username and password match
                // then set account and information
                //doggy = new MyDoggy("Steve", "Steve is kinda cool.", true);
                if(TextUtils.isEmpty(usernameBox.getText().toString())||TextUtils.isEmpty(passwordBox.getText().toString()) )
                {
                    failed.setText("email/password is empty");
                }
                else{ login();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                // Add Register Page and Connect to it
                /*GetUserApi().getAllUser().enqueue(new SlimCallback<List<User>>(user->{ staticUser.setlist(user); }));
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() { failed.setText(staticUser.allusers.get(0).getFirstName()); }},700);*/
            }});
    }
    public void login(){
       User puser = new User();

        puser.setEmail(usernameBox.getText().toString());
        puser.setPassword(passwordBox.getText().toString());
        GetUserApi().getUserByEmail(usernameBox.getText().toString()).enqueue(new SlimCallback<User>(user -> {

            if(TextUtils.equals(puser.getEmail(),user.getEmail())&&TextUtils.equals(puser.getPassword(),user.getPassword())){
                Toast.makeText(Login.this, "login successful", Toast.LENGTH_LONG).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        staticUser.setUser(user);
                        GetUserApi().getAllUser().enqueue(new SlimCallback<List<User>>(user->{ staticUser.setlist(user); }));
                        startActivity(new Intent(Login.this,Home.class));
                    }
                },1000);
            }
            else{
                puser.setEmail(user.getEmail());
                Toast.makeText(Login.this, "login failed", Toast.LENGTH_LONG).show();
            }
        }));


    }
}
