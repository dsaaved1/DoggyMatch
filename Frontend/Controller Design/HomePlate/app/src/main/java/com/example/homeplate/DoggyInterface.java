package com.example.homeplate;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import android.graphics.drawable.Icon;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homeplate.api.SlimCallback;
import com.example.homeplate.model.User;
import com.example.homeplate.model.staticUser;

import java.util.List;

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
        /**
         * Create a login request
         * and return results as
         * MessageReturn type.
         * @param username Username (Email)
         * @param password Password
         * @return Return Message (String Error Message, ENUM Status)
         */
        public static MessageReturn login(String username, String password){

            MessageReturn returnMessage = new MessageReturn();

        /*GetUserApi().getAllUser().enqueue(new SlimCallback<List<User>>(user->{ staticUser.setlist(user); }));
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() { failed.setText(staticUser.allusers.get(0).getFirstName()); }},700);*/

            if(username.isEmpty() || password.isEmpty()) return new MessageReturn("Username or Password is Empty.", DoggyInterface.Status.FAILURE);
            User puser = new User();

            puser.setEmail(username);
            puser.setPassword(password);

            GetUserApi().getUserByEmail(username).enqueue(new SlimCallback<User>(user -> {

                if(TextUtils.equals(puser.getEmail(), user.getEmail()) && TextUtils.equals(puser.getPassword(), user.getPassword()))
                {
                    returnMessage.setMessage("Login Successful");

                    new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            //sets current user
                            staticUser.setUser(user);
                            //generates the list of all users besides current
                            GetUserApi().getEverbody(user.getEmail()).enqueue(new SlimCallback<List<User>>(user->{ staticUser.setlist(user); }));
                            returnMessage.setStatus(DoggyInterface.Status.SUCCESS);
                            returnMessage.setMessage("Login Successful");
                        }
                    },1000);
                }
                else
                {
                    puser.setEmail(user.getEmail());
                    returnMessage.setStatus(DoggyInterface.Status.FAILURE);
                    returnMessage.setMessage("Username/Password Doesn't Match.");
                }
            }));

            // TODO
            // Change Success to Failure
            if(returnMessage.getStatus() == null) return new MessageReturn("Unable to Connect.", DoggyInterface.Status.SUCCESS);

            return returnMessage;
        }

        /**
         * Matching Function
         */
        public static void match()
        {
            if(staticUser.getIndex() < staticUser.getUsers().size()) {
                GetUserApi().match(staticUser.getUser().getId(), staticUser.getUsers().get(staticUser.getIndex()).getId()).enqueue(new SlimCallback<User>(user -> {
                }));
                staticUser.incrementIndex();
            }
        }
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
     * @author Corbin Graham
     */
    interface DoggyView
    {
        /**
         * Get Next User's Dog Name
         * @return Name
         */
        public static String getName() {
            if(staticUser.getUser() != null && staticUser.getIndex() < staticUser.getUsers().size())
                return staticUser.getUsers().get(staticUser.getIndex()).getDog().getFirstNameDog();
            else return "No Dog Available";
        }

        /**
         * Get Next User's Dog Description
         * @return Description
         */
        public static String getDescription() {
            if(staticUser.getUser() != null && staticUser.getIndex() < staticUser.getUsers().size())
                return staticUser.getUsers().get(staticUser.getIndex()).getDog().getDescriptionDog();
            else return "No Description Available";
        }

        /**
         * Get Next User's Profile Image
         * @return Image
         */
        public static int getImage() {
            if(staticUser.getUser() != null && staticUser.getIndex() < staticUser.getUsers().size())
                return R.drawable.icon_match_24;
            else return R.drawable.icon_profile_24;
        }
    }


}
