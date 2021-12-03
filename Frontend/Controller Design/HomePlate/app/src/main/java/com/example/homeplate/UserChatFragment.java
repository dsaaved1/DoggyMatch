package com.example.homeplate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Layout for Individual User Chat
 * @author Corbin
 */
public class UserChatFragment extends Fragment {

    // Local Fields
    TextView chatName;
    TextView inputMessage;
    Button sendButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userchat, container, false);

        setValues(view);
        interact();

        return view;
    }

    /**
     * Initialize Fields
     * and Values
     * @param view Current View (Fragment)
     */
    private void setValues(View view)
    {
        // TextView
        chatName = view.findViewById(R.id.chatName);

        // TextBox
        inputMessage = view.findViewById(R.id.inputMessage);

        // Button
        sendButton = view.findViewById(R.id.sendButton);

        // Initialize
    }

    /**
     * Wait for Interaction
     * then Handle interaction
     */
    private void interact()
    {

    }
}
