package com.example.example.model;

import static com.example.example.api.ApiClientFacotry.GetUserApi;

import com.example.example.api.SlimCallback;
import com.google.gson.annotations.SerializedName;

//import com.google.gson.annotations.SerializedName;
public class User {
    private int id;
    private String firstName;
    private String lastName;
    //private String username;
    private String email;
    private int age;



    public User(String path) {
        GetUserApi().getUserByNum(path).enqueue(new SlimCallback<User>(user -> {


        }));
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
