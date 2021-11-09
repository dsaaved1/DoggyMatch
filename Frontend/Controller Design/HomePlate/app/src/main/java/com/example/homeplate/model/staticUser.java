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
public static User user;
public static List<User> allusers = new ArrayList<User>();
public staticUser(){
getall();
}

public static void getall(){
    GetUserApi().getAllUser().enqueue(new SlimCallback<List<User>>(user->{
        for(User u: user){
            allusers.add(u);
        }
    }));
}
public static void setlist(List<User> list){

    for(User u: list){
        allusers.add(u);
    }

}
    public static User getUser(String email) {
    GetUserApi().getUserByEmail(email).enqueue(new SlimCallback<User>(user1 ->{
        user = user1;
    }));
        return user;
    }

    public static void setUser(User user) {
        staticUser.user = user;
    }
}
