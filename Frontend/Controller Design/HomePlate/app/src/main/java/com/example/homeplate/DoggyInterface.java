package com.example.homeplate;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Interface for basic application functions
 * @author Corbin
 */
public interface DoggyInterface {

    public enum Status
    {
        SUCCESS,
        FAILURE
    }

    /**
     * Controller for Internal Functions
     */

    interface DoggyController
    {

    }
    /**
     * Custom Button Actions and Design
     */

    interface DoggyButton extends View.OnClickListener
    {

    }
    /**
     * Model for Consistent App View
     */

    interface DoggyModel
    {
        /**
         * Sets the onclick listener for buttons
         */
        interface OnFinishedListener
        {
            void onFinished(String string);
        }


    }
    /**
     * Offload Data Assertion and Collection from Individual Views
     * Last Page to Create
     */
    interface DoggyView
    {
        /**
         * shows progress of view
         */
        void showProgress();

        /**
         * hides progress
         */
        void hideProgress();

        /**
         * sets the string to view
         * @param string view
         */
        void setString(String string);
    }


}
