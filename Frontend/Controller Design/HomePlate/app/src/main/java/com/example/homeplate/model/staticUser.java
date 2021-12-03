package com.example.homeplate.model;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import com.example.homeplate.api.SlimCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Store the Current User as a Static Object.
 * Able to be set one time and retrieved throughout the App.
 * Store all Matches from the Database.
 * @author Mark Gores
 * @author Corbin Graham
 */
public class staticUser {

    // Variables
    // Start Static User as NULL
    // NULL if No User is Signed in.
    private static User user = null;

    // List of all possible users to match with, does not include current user
    private static List<User> getUsers = new ArrayList<User>();

    // User Email
    private static String email;

    // User Index
    private static int index;

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
            getUsers.add(u);
        }
    }));
    }

    /**
     * sets the list of all possible users
     * @param list
     */
    public static void setlist(List<User> list){

    for(User u: list){
        getUsers.add(u);
    }

}

    /**
     * Gets the user from the data base by the email
     * @param email Email
     * @return User
     */
    public static User getUserByEmail(String email) {
    GetUserApi().getUserByEmail(email).enqueue(new SlimCallback<User>(user1 ->{
        user = user1;
    }));
        return user;
    }

    /**
     * Get Current User
     * @return User
     */
    public static User getUser()
    {
        return user;
    }

    /**
     * Get Possible Matches
     * @return List of Users (User)
     */
    public static List<User> getUsers()
    {
        return getUsers;
    }

    /**
     * Set Current User
     * @param user User
     */
    public static void setUser(User user) {
        staticUser.user = user;
    }

    /**
     * Initialize or Reset Index
     */
    public static void setIndex()
    {
        staticUser.index = 0;
    }

    /**
     * Increment Index
     */
    public static void incrementIndex()
    {
        staticUser.index += 1;
    }

    /**
     * Get Current Index
     * @return Index
     */
    public static int getIndex()
    {
        return index;
    }

    // Email

    /**
     * Get the current User Email
     * @return Email
     */
    public static String getEmail()
    {
        return email;
    }

    /**
     * Set the current User Email
     * @param email Email
     */
    public static void setEmail(String email)
    {
        staticUser.email = email;
    }
}
