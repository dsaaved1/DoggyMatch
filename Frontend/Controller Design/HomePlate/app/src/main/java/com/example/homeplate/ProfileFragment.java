package com.example.homeplate;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.homeplate.model.User;
import com.example.homeplate.model.staticUser;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;

/**
 * Profile Activity
 * @author Corbin Graham
 */
public class ProfileFragment extends Fragment {

    // Local Fields
    private TextView nameText;
    private TextView descriptionText;
    private Button signOutButton;
    private Button preferenceButton;
    private ImageView profilePicture;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

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
        //TextView
        nameText = view.findViewById(R.id.profileName);
        descriptionText = view.findViewById(R.id.profileDescription);

        //Buttons
        signOutButton = view.findViewById(R.id.signOutButtonProfile);
        preferenceButton = view.findViewById(R.id.preferenceButton);

        // Images
        profilePicture = view.findViewById(R.id.myProfilePicture);
        // TODO http://coms-309-058.cs.iastate.edu:8080/dog http://10.0.2.2:8080/dog
        String url = "http://coms-309-058.cs.iastate.edu:8080/dog" + (new Random().nextInt(9) + 1) + ".jpg";
        System.out.println("Getting url at: " + url);
        Picasso.with(profilePicture.getContext())
                .load(url)
                .into(profilePicture);

        // Set Initial Values
        nameText.setText(DoggyInterface.DoggyView.getMyName());
        descriptionText.setText(DoggyInterface.DoggyView.getMyDescription());
        /*try {
            profilePicture.setImageBitmap(DoggyInterface.DoggyView.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * Wait for Interaction
     * then Handle interaction
     */
    private void interact()
    {
        // Sign Out Button
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                staticUser.setUser(null);
                startActivity(new Intent(getActivity(), Login.class));
                // Set User to NULL before Login
                getActivity().finish();
            }
        });

        // Change Preferences
        preferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Register but Since there is a USER OBJECT, it will UPDATE PREFERENCES instead of REGISTER
                startActivity(new Intent(getActivity(),Register.class));
                getActivity().finish();
            }
        });
    }
}
