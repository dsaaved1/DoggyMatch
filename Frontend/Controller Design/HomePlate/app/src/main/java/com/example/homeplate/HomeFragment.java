package com.example.homeplate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment{

    TextView nameText;
    TextView descriptionText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        nameText = view.findViewById(R.id.name);
        nameText.setText("Bob");

        descriptionText = view.findViewById(R.id.description);
        descriptionText.setText("Holy Moly");

        return view;
    }

}
