package com.example.homeplate;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homeplate.api.SlimCallback;
import com.example.homeplate.model.User;
import com.example.homeplate.model.staticUser;

import java.util.List;

/**
 * Controller for Common Internal Functions
 * used throughout the interface.
 * @author Corbin Graham
 */
public class DoggyController extends AppCompatActivity implements DoggyInterface.DoggyController {

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

        if(returnMessage.getStatus() == null) return new MessageReturn("Incorrect Username / Password", DoggyInterface.Status.SUCCESS);
        return returnMessage;
    }
}
