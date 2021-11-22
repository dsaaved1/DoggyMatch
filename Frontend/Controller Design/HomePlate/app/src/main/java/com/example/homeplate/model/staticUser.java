package com.example.homeplate.model;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import com.example.homeplate.api.ApiClientFacotry;
import com.example.homeplate.api.SlimCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * The current user loged in and list of all the users on the data base
 * @author Mark Gores
 */
public class staticUser {
    /**
     * the current user logged in
     */
    public static User user;
    /**
     * list of all possible users to match with, does not include current user
     */
    public static List<User> allusers = new ArrayList<User>();

    /**
     * constructor that calls get all
     */
    public staticUser(){
getall();
}

    /**
     * generates all users besides the current user from the data base
     */
    public static void getall(){
    GetUserApi().getEverbody(user.getEmail()).enqueue(new SlimCallback<List<User>>(user->{
        for(User u: user){
            allusers.add(u);
        }
    }));
}

    /**
     * sets the list of all possible users
     * @param list
     */
    public static void setlist(List<User> list){

    for(User u: list){
        allusers.add(u);
    }

}

    /**
     * Gets the user from the data base by the email
     * @param email
     * @return User
     */
    public static User getUser(String email) {
    GetUserApi().getUserByEmail(email).enqueue(new SlimCallback<User>(user1 ->{
        user = user1;
    }));
        return user;
    }

    /**
     * sets the current user
     * @param user
     */
    public static void setUser(User user) {
        staticUser.user = user;
    }
}
