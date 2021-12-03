package com.example.homeplate;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Interface for basic application functions
 * @author Corbin Graham
 */
public interface DoggyInterface {

    /**
     * Status
     * Type: ENUM
     * Status SUCCESS
     * Status FAILURE
     * @author Corbin Graham
     */
    public enum Status
    {
        SUCCESS,
        FAILURE
    }

    /**
     * Handle Static Instances of User
     */
    interface Doggy
    {

    }

    /**
     * Controller for Common Internal Functions
     * used throughout the interface.
     * @todo Currently all functions are Static.
     * @todo Offload Functions to Interface.
     * @author Corbin Graham
     */
    interface DoggyController
    {

    }

    /**
     * Custom Button Actions
     * @todo Currently Unused
     * @author Corbin Graham
     */
    interface DoggyButton extends View.OnClickListener
    {

    }

    /**
     * Model for Consistent App View
     * Allows for Views to be controlled simultaneously
     * @todo Currently Unused
     * @author Corbin Graham
     */
    interface DoggyModel
    {

    }

    /**
     * Offload Data Assertion and
     * Collection from Individual Views
     * @todo Currently Unused
     * @author Corbin Graham
     */
    interface DoggyView
    {

    }


}
