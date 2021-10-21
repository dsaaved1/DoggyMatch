package com.example.homeplate;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DoggyController extends AppCompatActivity {

    private Button myButton;
    private TextView myTextView;

    public DoggyController()
    {

    }

    public DoggyController(Button button, TextView textView)
    {
        myButton = button;
        myTextView = textView;
    }

    protected void createTextField()
    {
        myTextView.setText("Success.");
    }
}
