package com.example.homeplate;

public interface DoggyInterface {

    interface DoggyController
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
