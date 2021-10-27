package com.example.homeplate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment{

    TextView nameText;
    TextView descriptionText;
    Button yesButton;
    Button noButton;
    ImageView profilePicture;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setValues(view);
        interact();
        return view;
    }

    private void setValues(View view)
    {
        //TextView
        nameText = view.findViewById(R.id.name);
        nameText.setText("Bob");

        descriptionText = view.findViewById(R.id.description);
        descriptionText.setText("Holy Moly");

        //Buttons
        yesButton = view.findViewById(R.id.yesButton);
        noButton = view.findViewById(R.id.noButton);

        //Image
        profilePicture = view.findViewById(R.id.profilePicture);
    }

    private void interact()
    {
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descriptionText.setText("Wow it works!");
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
