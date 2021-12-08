package com.example.homeplate.model;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import com.example.homeplate.DoggyInterface;
import com.example.homeplate.MessageReturn;
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
    //list of messages
    private static List<Message> messages = new ArrayList<Message>();
    // User Email
    private static String email;

    // User Index
    private static int index;

    // Current Chat
    private static Chat currentChat;

    // User Type
    private static DoggyInterface.UserType userType;

    // Return message
    public static MessageReturn messageReturn;

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
    public static void setMsg(){
        GetUserApi().getChat(staticUser.getUser().getId(),staticUser.getUsers().get(staticUser.getIndex()).getId()-1).enqueue(new SlimCallback<List<Message>>(list ->{
            System.out.println("List size: " + list.size());
            for(Message x:list){
                messages.add(x);
                System.out.println("Message when set: " + x.getMessage());
            }
        }));
    }

public static List<Message> getMsg(){
        return messages;
}
    /**
     * sets the list of all possible users
     * @param list
     */
    public static void setlist(List<User> list){
        getUsers.clear();
    for(User u: list){
        getUsers.add(u);
        System.out.printf("Name: %s\tIndex: %d%n", u.getDog().getFirstNameDog(), u.getId());
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

    /**
     * Set Chat Index
     */
    public static void setCurrentChat(Chat chat)
    {
        staticUser.currentChat = chat;
    }

    /**
     * Get Chat Index
     * @return Chat Index
     */
    public static Chat getCurrentChat()
    {
        return currentChat;
    }

    /**
     * Set Type of User
     * @param userType User Type
     */
    public static void setUserType(DoggyInterface.UserType userType) {
        staticUser.userType = userType;
    }

    /**
     * Get Type of User
     * @return User Type
     */
    public static DoggyInterface.UserType getUserType() {

        return staticUser.userType.valueOf(staticUser.user.getUserTypeId());
    }
}
