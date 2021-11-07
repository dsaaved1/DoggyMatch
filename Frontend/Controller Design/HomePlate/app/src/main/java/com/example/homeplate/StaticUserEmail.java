package com.example.homeplate;

public class StaticUserEmail {

    // private String email;
    private static String gEmail;

    public StaticUserEmail()
    {

    }

    public static String getEmail()
    {
        return gEmail;
    }

    public static void setEmail(String email)
    {
        // this.email = email;
        gEmail = email;
    }
}
