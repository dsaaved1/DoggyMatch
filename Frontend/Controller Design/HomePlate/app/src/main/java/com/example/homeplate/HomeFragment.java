package com.example.homeplate;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;
import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.homeplate.api.ApiClientFacotry;
import com.example.homeplate.api.SlimCallback;
import com.example.homeplate.model.User;
import com.example.homeplate.model.staticUser;

import java.util.List;

public class HomeFragment extends Fragment{

    TextView nameText;
    TextView descriptionText;
    Button yesButton;
    Button noButton;
    ImageView profilePicture;
    String email;
    int i = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

       email = StaticUserEmail.getEmail();
        setValues(view);
        interact();
        return view;
    }

    private void setValues(View view)
    {
        nameText = view.findViewById(R.id.name);
        descriptionText = view.findViewById(R.id.description);


        //TextView
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(staticUser.allusers.size()>i) {
                    nameText.setText(staticUser.allusers.get(1).getFirstName());
                    descriptionText.setText(staticUser.allusers.get(1).getLastName());
                }
                else{
                    nameText.setText("No matches right now, come back tomorrow!");
                    descriptionText.setText("");
                }
            }
        },700);












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
                if(i<staticUser.allusers.size()) {
                descriptionText.setText(staticUser.allusers.get(i).getLastName());
                nameText.setText(staticUser.allusers.get(i).getFirstName());
                i++;
            }
                else {
                nameText.setText("Out of matches");
                descriptionText.setText("try again tomorrow!");
            }
        }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i<staticUser.allusers.size()) {
                    descriptionText.setText(staticUser.allusers.get(i).getLastName());
                    nameText.setText(staticUser.allusers.get(i).getFirstName());
                    i++;
                }
                else {
                    nameText.setText("Out of matches");
                    descriptionText.setText("try again tomorrow!");
                }
            }
        });
    }
}
