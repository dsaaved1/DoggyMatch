package com.example.homeplate;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DoggyButton extends AppCompatActivity implements DoggyInterface.DoggyButton, View.OnClickListener {

    private int currentView;
    private int previousView;
    private int nextView;

    public DoggyButton(int view)
    {
        this.currentView = view;
    }

    public void setAction()
    {
        
    }

    public void setViewer(int view)
    {
        this.nextView = view;
        this.previousView = currentView;
        this.currentView = nextView;
    }

    @Override
    public void onClick(String view) {
        setContentView(R.id.nextView);
    }
}
