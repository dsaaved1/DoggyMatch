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

/**
 * Matching Activity
 * View for Match Profiles
 * in sequence.
 * @author Corbin Graham
 */
public class HomeFragment extends Fragment{

    // Local Fields
    private TextView nameText;
    private TextView descriptionText;
    private Button yesButton;
    private Button noButton;
    private ImageView profilePicture;

    // Local Variables
    int i = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setValues(view);
        interact();
        return view;
    }

    private void setValues(View view)
    {
        // Fields
        // Text
        nameText = view.findViewById(R.id.name);
        descriptionText = view.findViewById(R.id.description);

        // Buttons
        yesButton = view.findViewById(R.id.yesButton);
        noButton = view.findViewById(R.id.noButton);

        // Images
        profilePicture = view.findViewById(R.id.profilePicture);

        // Variables
        staticUser.setIndex();

        // Set Initial Values
        nameText.setText(DoggyInterface.DoggyView.getName());
        descriptionText.setText(DoggyInterface.DoggyView.getDescription());
        profilePicture.setImageResource(DoggyInterface.DoggyView.getImage());

        /* Unnecessary
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(staticUser.getUsers().size()>i) {
                    nameText.setText(staticUser.getUsers().get(i).getFirstName());
                    descriptionText.setText(staticUser.getUsers().get(i).getLastName());
                }
                else{
                    nameText.setText("No matches right now, come back tomorrow!");
                    descriptionText.setText("");
                }
            }
        },700);

         */
    }

    private void interact()
    {
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chat code
                //staticUser.user.getChats().stream().findFirst().get().getUserMail();

                DoggyInterface.DoggyController.match();
                nameText.setText(DoggyInterface.DoggyView.getName());
                descriptionText.setText(DoggyInterface.DoggyView.getDescription());
                profilePicture.setImageResource(DoggyInterface.DoggyView.getImage());
        }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(staticUser.getIndex() < staticUser.getUsers().size()) {
                    staticUser.incrementIndex();
                    nameText.setText(DoggyInterface.DoggyView.getName());
                    descriptionText.setText(DoggyInterface.DoggyView.getDescription());
                    profilePicture.setImageResource(DoggyInterface.DoggyView.getImage());
                }
            }
        });
    }
}
