package com.example.homeplate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private TextView nameText;
    private Button signOutButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        setValues(view);
        interact();
        return view;
    }

    private void setValues(View view)
    {

        //TextView
        nameText = view.findViewById(R.id.profileName);

        //Buttons
        signOutButton = view.findViewById(R.id.signOutButtonProfile);
    }

    private void interact()
    {
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}
