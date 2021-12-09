package com.example.homeplate.model;

import java.util.ArrayList;

public class lmsg {
    ArrayList<Message> messages = new ArrayList<>();

    public lmsg() {;
    }
    public lmsg(ArrayList<Message> mes) {
        messages = mes;
    }


    public void addMessage(Message message) {
        messages.add(message);
    }
}
