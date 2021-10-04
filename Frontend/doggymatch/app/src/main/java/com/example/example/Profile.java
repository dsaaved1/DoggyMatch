package com.example.example;


import static com.example.example.api.ApiClientFacotry.GetPhotoApi;
import static com.example.example.api.ApiClientFacotry.GetUserApi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example.api.SlimCallback;
import com.example.example.model.Photo;
import com.example.example.model.User;

public class Profile extends AppCompatActivity {
    TextView name;
    String username;
    TextView data;
    Button refresh;
    String dat;
    String age;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof_activity);
        refresh = findViewById(R.id.ref); //added a refresh button to allow the page to load before sending it server data
        name = (TextView) findViewById(R.id.usern);
        data = findViewById(R.id.usern1);
        TextView dataage = findViewById(R.id.age);
        Intent intent = getIntent();
        String usname = intent.getStringExtra("message_key");
        name.setText("UserId:" + usname);
        //sets the text on page to data from server
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                GetUserApi().getUserByNum(usname).enqueue(new SlimCallback<User>(user -> {
                    // test1.setText(user.getUsername());
                    //data.setText(user.getUsername());
                    username = user.getFirstname();
                    dat = user.getEmail();
                    age = String.valueOf(user.getAge());
                }));
                name.setText("Hello, "+username);
                data.setText("Email: "+dat);
                dataage.setText("age: "+age);
            }
        });


    }
}
