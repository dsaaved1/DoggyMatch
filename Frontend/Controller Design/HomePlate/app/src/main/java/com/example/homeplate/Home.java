package com.example.homeplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    private Button homeButton;
    private Button chatButton;
    private Button profileButton;
    private TextView pageHome;

    private TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, HomeFragment.class, null)
                .commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        bottomNav.setSelectedItemId(R.id.nav_home);

        /* getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

         */
        setValues();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.nav_chat:
                            selectedFragment = new ChatsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view,
                            selectedFragment).commit();

                    return true;
                }
            };

    private void setValues()
    {
        //Buttons

        /*
        Possibly:
            DoggyButtons handles all, each is a DoggyButton

        Class DoggyButton setValues(List names, List assignments)
            Pass a list of button names
            Pass a list of assignments
            Convert them to buttons and then use the another class for actions
           Example:
                nameList: homeButton, chatButton, profileButton
                assignmentList: R.id.homeButton, ...
         */

        /*
            DoggyButton interact(Button, Action)
         */

        nameText = findViewById(R.id.name);

    }

    private void interact()
    {

    }
}