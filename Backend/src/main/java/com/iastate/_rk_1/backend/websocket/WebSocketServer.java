package com.iastate._rk_1.backend.websocket;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.iastate._rk_1.backend.entity.Msg;
/**
 *
 * @author peyton
 *
 */

@ServerEndpoint("/websocket/{username}")
@Component
public class WebSocketServer {

    // Store all socket session and their corresponding username.
    private static Map <Session, String> sessionUsernameMap = new Hashtable < > ();
    private static Map <String, Session> usernameSessionMap = new Hashtable < > ();

    private final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username)
            throws IOException {
        logger.info("Entered into Open");

        sessionUsernameMap.put(session, username);
        usernameSessionMap.put(username, session);
        logger.info(session.getId() + " has connected with username: " + username);
    }


    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        Gson gson = new Gson();
        Msg msg = gson.fromJson(message, Msg.class);
        logger.info("Got message: " + msg.msg + " from " + msg.sender + " to " + msg.receiver);
        String username = sessionUsernameMap.get(session);
        session.getBasicRemote().sendText(username + ": " + msg.msg);

        if (msg.receiver.equals("all")) {
            broadcast(msg.msg);
        } else {
            Session receivingSession = usernameSessionMap.get(msg.receiver);
            if (receivingSession == null) {
                logger.error("There is no such user");
            } else {
                String msgToSend = username + ": " + msg.msg;
                receivingSession.getBasicRemote().sendText(msgToSend);
            }
        }
    }



    @OnClose
    public void onClose(Session session) throws IOException {
        logger.info("Entered into Close");

        String username = sessionUsernameMap.get(session);
        sessionUsernameMap.remove(session);
        usernameSessionMap.remove(username);

        String message = username + " disconnected";
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        logger.info("Entered into Error");
    }

    private void broadcast(String message) {
        sessionUsernameMap.forEach((session, username) -> {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                logger.info("Exception: " + e.getMessage().toString());
                e.printStackTrace();
            }

        });

    }
}
