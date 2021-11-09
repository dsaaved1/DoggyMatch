package com.example.homeplate;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/** unused for now
 * @author Corbin
 */
public interface DoggyInterface {

    interface DoggyController
    {

    }

    interface DoggyButton extends View.OnClickListener
    {

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
