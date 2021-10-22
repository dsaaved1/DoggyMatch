package com.example.homeplate;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public interface DoggyInterface {

    interface DoggyController
    {

    }

    interface DoggyButton extends View.OnClickListener
    {
        void setAction();
    }

    interface DoggyModel
    {
        interface OnFinishedListener
        {
            void onFinished(String string);
        }


    }

    interface DoggyView
    {
        void showProgress();
        void hideProgress();
        void setString(String string);
    }

    interface DoggyPresenter
    {
        void onButtonClick();
        void onDestroy();
    }
}
