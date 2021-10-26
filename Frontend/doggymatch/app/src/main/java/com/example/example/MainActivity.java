package com.example.example;

import static com.example.example.api.ApiClientFacotry.*;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example.api.SlimCallback;
import com.example.example.model.Photo;
import com.example.example.model.User;

public class MainActivity extends AppCompatActivity {
    Button log, reg;
    EditText username;
    String userna;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editText1);

       // TextView test1 = findViewById(R.id.usern); //debugging purposes
        log = (Button) findViewById(R.id.button);
       // Button test = findViewById(R.id.button2);  //debugging purposes
       // TextView apiText1 = findViewById(R.id.test);  //debugging purposes
        //button to log in
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //gets the username by id number and creates a user object
                user = new User(username.getText().toString());
                GetUserApi().getUserByNum(username.getText().toString()).enqueue(new SlimCallback<User>(user -> {
                   // test1.setText(user.getUsername());
                  //data.setText(user.getUsername());
                    userna = String.valueOf(user.getId()); //sets the id to a string
              }));

            profile(username.getText().toString()); // starts profile activity and sends it the user id
            }
        });
        //test for receving data from server on home page
//        test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                GetUserApi().getFirstUser().enqueue(new SlimCallback<User>(user1 ->{
//                    String test1 = String.valueOf(user1.getId());
//                    apiText1.setText(test1);
//                }));
//        GetUserApi().getUserByNum(username.getText().toString()).enqueue(new SlimCallback<User>(user -> {
//            // test1.setText(user.getUsername());
//            //data.setText(user.getUsername());
//            apiText1.setText(user.getId());
//        }));
//            }
//        });

        //starts regiser page
        reg = (Button) findViewById(R.id.button1);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });



    }

    private void profile(String str) {
        Intent prof = new Intent(this, Profile.class);
        prof.putExtra("message_key", str);
        startActivity(prof);
    }
    private void register(){
        Intent regs = new Intent(this, Register.class);
        startActivity(regs);
    }
}