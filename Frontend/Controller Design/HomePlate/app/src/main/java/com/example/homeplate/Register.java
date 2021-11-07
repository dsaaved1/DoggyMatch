package com.example.homeplate;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homeplate.api.SlimCallback;
import com.example.homeplate.model.User;

public class Register extends AppCompatActivity {
    Button regs;
    EditText email;
    EditText password;
    User newUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setValues();
        interact();

    }
    private void setValues(){
        regs = findViewById(R.id.button);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }
    private void interact(){
        regs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newUser.setEmail(email.getText().toString());
                newUser.setPassword(password.getText().toString());
                GetUserApi().postuser(newUser).enqueue(new SlimCallback<User>(user->{  }));
                email.setText("");
                password.setText("");

            }
        });
    }
}
