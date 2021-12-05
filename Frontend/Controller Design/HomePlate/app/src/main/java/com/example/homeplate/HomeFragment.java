package com.example.homeplate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.homeplate.model.staticUser;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

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
        // Fields
        // Text
        nameText = view.findViewById(R.id.name);
        descriptionText = view.findViewById(R.id.description);

        // Buttons
        yesButton = view.findViewById(R.id.yesButton);
        noButton = view.findViewById(R.id.noButton);

        // Change Button Text for User Type
        if(staticUser.getUserType() != DoggyInterface.UserType.OWNER) {
            yesButton.setText("GOOD");
            noButton.setText("REPORT");
        }

        // Images
        profilePicture = view.findViewById(R.id.profilePicture);

        // Variables
        staticUser.setIndex();

        // Set Initial Display
        displayProfile();

        // TODO
        //  Idk what you want to do this; Remove if not necessary
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

    /**
     * Wait for Interaction
     * then Handle interaction
     */
    private void interact()
    {
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* I don't know what this does
                //chat code
                //staticUser.user.getChats().stream().findFirst().get().getUserMail();
                 */

                if(staticUser.getUserType() == DoggyInterface.UserType.OWNER) DoggyInterface.DoggyController.match();
                else staticUser.incrementIndex();
                displayProfile();
        }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the Current Index is within bounds
                if(staticUser.getIndex() < staticUser.getUsers().size()) {
                    if(staticUser.getUserType() != DoggyInterface.UserType.OWNER) {
                        // Generate a REPORT
                        if(staticUser.getUserType() == DoggyInterface.UserType.ADMIN) {
                            // Remove Account IMMEDIATELY
                        }
                    }
                    staticUser.incrementIndex();
                    displayProfile();
                }
            }
        });
    }

    /**
     * Display Match Profile
     * and Set Values
     */
    private void displayProfile()
    {
        nameText.setText(DoggyInterface.DoggyView.getName());
        descriptionText.setText(DoggyInterface.DoggyView.getDescription());
        profilePicture.setImageResource(DoggyInterface.DoggyView.getImage());
    }
}
