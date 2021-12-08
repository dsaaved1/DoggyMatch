package com.example.homeplate;

import static com.example.homeplate.DoggyInterface.DoggyController.sendMessage;
import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import androidx.fragment.app.Fragment;

import com.example.homeplate.api.SlimCallback;
import com.example.homeplate.model.Chat;
import com.example.homeplate.model.Message;
import com.example.homeplate.model.User;
import com.example.homeplate.model.staticUser;

/**
 * Layout for Individual User Chat
 * @author Corbin Graham
 */
public class UserChatFragment extends Fragment {

    // Local Fields
    private TextView chatName;
    private TextView inputMessage;
    private Button sendButton;

    //ArrayList<Message> x = DoggyInterface.DoggyController.getMessage();
    private Set<Chat> chats = staticUser.getUser().getChats();
    private List<Chat> lchat = new ArrayList<Chat>();
    private Chat chat= new Chat();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userchat, container, false);
        //x.addAll(DoggyInterface.DoggyController.getMessage());
        staticUser.setMsg();
        setValues(view, savedInstanceState);
        interact();

        return view;
    }

    /**
     * Initialize Fields
     * and Values
     * @param view Current View (Fragment)
     */
    private void setValues(View view, Bundle bundle)
    {
        //ArrayList<Message> A = DoggyInterface.DoggyController.getMessage();
        //x.addAll(DoggyInterface.DoggyController.getMessage());


                // Initialize Fields
                // TextView
                chatName = view.findViewById(R.id.chatName);

                // TextBox
                inputMessage = view.findViewById(R.id.inputMessage);

                // Button
                sendButton = view.findViewById(R.id.sendButton);

                // Initialize Values
                // Generate Name and Name Status

                // Chat
                // for(All Message objects print the string message)

                chatName.setText(staticUser.getCurrentChat().getUserMail());

        /*
        MessageReturn message = DoggyInterface.DoggyView.getChatName(staticUser.getChatIndex());
        if(message.getStatus() == DoggyInterface.Status.SUCCESS) {  // Display Previous Messages
            // TODO
            // Display Messages
            // DoggyViewer->getMessages()

            // Continuously Update View after Initial Setup
            // Maybe a new method
        } else { sendButton.setEnabled(false); }                    // Disable Sending Messages and Don't Display
        chatName.setText(message.getMessage());

         */



    }

    /**
     * Wait for Interaction
     * then Handle interaction
     */
    private void interact()
    {
        // Send Button
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO
                // Send Message
                // inputMessage -> Chat

                sendMessage(inputMessage.getText().toString());
                inputMessage.setText("");
                System.out.println("Our chat list size: "+ staticUser.getMsg().size());
                for(Message m: staticUser.getMsg()) {
                    System.out.println("name: " + m.getName() + "message: " + m.getMessage());
                }
                //System.out.println(x);

                /**
                 * If unable to send message, create an error and display.
                 * Unable to Connect / Send
                 *
                 * If able to connect, update view
                 */

                // sendMessage(staticUser.getChatIndex(), inputMessage.getText().toString());
            }
        });
    }
}
