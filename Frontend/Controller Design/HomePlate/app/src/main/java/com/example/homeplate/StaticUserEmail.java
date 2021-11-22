package com.example.homeplate;

/**
 * Quick way to get current users email
 * @author Mark Gores
 */
public class StaticUserEmail {


    private static String gEmail;

    /**
     * basic constructor
     */
    public StaticUserEmail()
    {

    }

    /**
     * gets the current user email
     * @return
     */
    public static String getEmail()
    {
        return gEmail;
    }

    /**
     * sets the currents users email
     * @param email
     */
    public static void setEmail(String email)
    {
        // this.email = email;
        gEmail = email;
    }
}
