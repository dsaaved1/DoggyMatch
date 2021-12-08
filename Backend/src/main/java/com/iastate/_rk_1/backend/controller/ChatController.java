package com.iastate._rk_1.backend.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

/**
 * @author peyton
 */
@RestController
public class ChatController {
    class Message {
        String name;
        String message;

        public Message(String name, String message) {
            this.name = name;
            this.message = message;
        }
    }

    class Chat {
        ArrayList<Message> messages = new ArrayList<>();

        public Chat() {;
        }

        public void addMessage(Message message) {
            messages.add(message);
        }
    }

    private HashMap<Set<Integer>, Chat> chats = new HashMap<>();

    @GetMapping("/chat/{id1},{id2}")
    private String getChat(@PathVariable int id1, @PathVariable int id2) {
        Gson gson = new Gson();
        Set<Integer> ids = new HashSet<>();
        ids.add(id1);
        ids.add(id2);
        return gson.toJson(chats.get(ids));
    }

    @PutMapping("/chat/{id1},{id2}")
    private void sendMessage(@RequestBody String message, @PathVariable int id1, @PathVariable int id2) {
        Gson gson = new Gson();
        Message msg = gson.fromJson(message, Message.class);
        Set<Integer> ids = new HashSet<>();
        ids.add(id1);
        ids.add(id2);
        chats.get(ids).addMessage(msg);
    }

    @PostMapping("/chat/{id1},{id2}")
    private void createChat(@PathVariable int id1, @PathVariable int id2) {
        Set<Integer> ids = new HashSet<>();
        ids.add(id1);
        ids.add(id2);
        chats.put(ids, new Chat());
    }

}