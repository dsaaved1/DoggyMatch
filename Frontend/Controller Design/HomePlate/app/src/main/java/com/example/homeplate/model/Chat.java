package com.example.homeplate.model;

import java.util.ArrayList;

/**
 * Users ability to send and receive chats
 * @author Mark Gores
 */
public class Chat {
    private int id;

    private String userMail;

    public Chat() {
    }

    /**
     * Gets the id of current chat
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of Chat
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the message from the chat
     * @return
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * sends the chat message
     * @param userMail
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }


}

