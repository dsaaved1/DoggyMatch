package com.example.homeplate;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import com.example.homeplate.api.*;
import com.example.homeplate.model.*;

/** Trys to log user in
 * @author Mark
 */
public class tryLogin {
String em;
String passw;
    public boolean tryLogin(String email, String password){
        GetUserApi().getUserByEmail(email).enqueue(new SlimCallback<User>(user -> {
            em= String.valueOf(user.getId());
            passw = user.getPassword();
        }));
        if(em.matches(email)&&passw.matches(password)){ return true;}
        return false;
    }
}
