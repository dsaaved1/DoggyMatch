package com.example.homeplate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userchat, container, false);

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
        // Initialize Fields
        // TextView
        chatName = view.findViewById(R.id.chatName);

        // TextBox
        inputMessage = view.findViewById(R.id.inputMessage);

        // Button
        sendButton = view.findViewById(R.id.sendButton);

        // Initialize Values
        // Generate Name and Name Status
        MessageReturn message = DoggyInterface.DoggyView.getChatName(staticUser.getChatIndex());
        if(message.getStatus() == DoggyInterface.Status.SUCCESS) {  // Display Previous Messages
            // TODO
            // Display Messages
            // DoggyViewer->getMessages()

            // Continuously Update View after Initial Setup
            // Maybe a new method
        } else { sendButton.setEnabled(false); }                    // Disable Sending Messages and Don't Display
        chatName.setText(message.getMessage());
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
                /**
                 * If unable to send message, create an error and display.
                 * Unable to Connect / Send
                 *
                 * If able to connect, update view
                 */
                DoggyInterface.DoggyController.sendMessage(staticUser.getChatIndex(), inputMessage.getText().toString());
            }
        });
    }
}
