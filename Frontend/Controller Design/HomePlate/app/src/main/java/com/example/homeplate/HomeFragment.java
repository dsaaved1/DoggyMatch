package com.example.homeplate;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.homeplate.api.SlimCallback;
import com.example.homeplate.model.User;
import com.example.homeplate.model.staticUser;
import com.squareup.picasso.Picasso;

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
    private TextView ageText;
    private TextView a;
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
        // ageText = view.findViewById(R.id.age);
        // a = view.findViewById(R.id.a);

        // Buttons
        yesButton = view.findViewById(R.id.yesButton);
        noButton = view.findViewById(R.id.noButton);

        // Change Button Text for User Type
        if(staticUser.getUserType() == DoggyInterface.UserType.MODERATOR) {
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
                        GetUserApi().delete(staticUser.getUser().getEmail(),staticUser.getUsers().get(staticUser.getIndex()).getId()).enqueue(new SlimCallback<User>(user -> {
                        }));

                        if(staticUser.getUserType() == DoggyInterface.UserType.VIEWER) {
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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nameText.setText(DoggyInterface.DoggyView.getName());
                descriptionText.setText(DoggyInterface.DoggyView.getDescription());
                // ageText.setText(DoggyInterface.DoggyView.getGender());
                // a.setText(DoggyInterface.DoggyView.getBreed());

                    //profilePicture.setImageBitmap(DoggyInterface.DoggyView.getImage());


                if(staticUser.getUser() != null && staticUser.getIndex() < staticUser.getUsers().size()) {
                    // TODO
                    //  Change to Remote URL http://10.0.2.2:8080/dog
                    String url = "http://coms-309-058.cs.iastate.edu:8080/dog" + (staticUser.getIndex() + 1) + ".jpg";
                    System.out.println("Getting url at: " + url);
                    Picasso.with(profilePicture.getContext())
                            .load(url)
                            .into(profilePicture);
                }
                else profilePicture.setImageResource(R.drawable.icon_match_24);

            }
        },70);
    }
}
