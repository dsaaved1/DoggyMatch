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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof_activity);
        refresh = findViewById(R.id.ref);
        name = (TextView) findViewById(R.id.usern);
        data = findViewById(R.id.usern1);
        Intent intent = getIntent();
        String usname = intent.getStringExtra("message_key");
        name.setText("UserId:" + usname);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                GetUserApi().getUserByNum(usname).enqueue(new SlimCallback<User>(user -> {
                    // test1.setText(user.getUsername());
                    //data.setText(user.getUsername());
                    username = user.getFirstname();
                    dat = user.getEmail();
                }));
                name.setText(username);
                data.setText(dat);

            }
        });


    }
}
