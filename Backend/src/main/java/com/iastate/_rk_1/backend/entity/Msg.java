package com.iastate._rk_1.backend.entity;

/**
 * @author peyton
 */
public class Msg {
    public String msg;
    public String sender;
    public String receiver;
    public Msg(String msg, String sender, String receiver) {
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
    }
}