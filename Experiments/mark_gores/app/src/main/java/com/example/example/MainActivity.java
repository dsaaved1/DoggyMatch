package com.example.example;

import static com.example.example.api.ApiClientFacotry.GetPhotoApi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example.api.SlimCallback;
import com.example.example.model.Photo;

public class MainActivity extends AppCompatActivity {
    Button log, reg;
    EditText username;
    String usern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText1);
        log = (Button) findViewById(R.id.button);
        TextView apiText1 = findViewById(R.id.test);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetPhotoApi().getPhotoByNum(username.getText().toString()).enqueue(new SlimCallback<Photo>(photo ->{
                    //apiText1.setText(photo.printable());
                    usern = photo.printable();
                }));

            profile(usern);
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