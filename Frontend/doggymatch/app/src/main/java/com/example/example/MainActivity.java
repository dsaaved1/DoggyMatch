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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText1);
        TextView test1 = findViewById(R.id.usern);
        log = (Button) findViewById(R.id.button);
        TextView apiText1 = findViewById(R.id.test);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                GetUserApi().getUserByNum(username.getText().toString()).enqueue(new SlimCallback<User>(user -> {
                   // test1.setText(user.getUsername());
                  //data.setText(user.getUsername());
                    userna = String.valueOf(user.getId());
              }));

            profile(username.getText().toString());
            }
        });

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