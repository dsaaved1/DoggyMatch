package com.example.homeplate;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homeplate.api.SlimCallback;
import com.example.homeplate.model.Doginfo;
import com.example.homeplate.model.User;
import com.example.homeplate.model.staticUser;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Registration Activity
 * <br>
 *     Sends a put request for a new user
 * @author Corbin Graham
 */
public class Register extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    
    // Local Fields
    private TextView pageTitle;
    private Button continueButton;
    // Dynamic Textboxes
    private TextView box1;
    private TextView box2;
    private TextView box3;
    private TextView box4;
    // Dynamic Dropdown Menu
    private Spinner menu;

    // Local Variables
    private int page;
    private final int LAST_PAGE = 4;    // This is the last page - TODO Change as needed.
    private HashMap<Integer, String> optionMap;
    private User newUser = new User();
    private Doginfo newDog = new Doginfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setValues();
        interact();
    }

    /**
     * Initialize Fields
     * and Values
     */
    private void setValues()
    {
        // TextView
        pageTitle = findViewById(R.id.pageTitleRegister);

        // Buttons
        continueButton = findViewById(R.id.continueButtonRegister);

        // Text Box
        box1 = findViewById(R.id.registerBox1);
        box2 = findViewById(R.id.registerBox2);
        box3 = findViewById(R.id.registerBox3);
        box4 = findViewById(R.id.registerBox4);

        // Dropdown Menu
        menu = findViewById(R.id.registerDropDown);

        // Initialize Values
        optionMap = new HashMap<>();
        if(DoggyInterface.DoggyController.isSignedIn()) page = 3;
        else page = 1;
        displayPage(page);

        /**
         * Previous Register Button
         * @author Mark Gores
         */
        /*
            registerButton.onClick{
                newUser.setEmail(email.getText().toString());
                newUser.setPassword(password.getText().toString());
                GetUserApi().postuser(newUser).enqueue(new SlimCallback<User>(user->{  }));
                email.setText("");
                password.setText("");
            }
         */

    }

    /**
     * Wait for Interaction
     * then Handle interaction
     */
    private void interact()
    {
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decide();
                // TODO Remove this when necessary (Proof of Concept)
               /* for(int i : optionMap.keySet()) {
                    if(optionMap.get(i).equals(menu.getSelectedItem().toString()))
                        System.out.println("i: " + i + " Value: " + menu.getSelectedItem().toString());
                }*/

            }
        });

        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }

    private void decide()
    {

        if(page == 1){
            System.out.println(box1.getText().toString());
            newUser.setFirstName(box1.getText().toString());
            System.out.println(box2.getText().toString());
            newUser.setEmail(box2.getText().toString());
            newUser.setPassword(box4.getText().toString());
            newUser.setUserTypeId(0);
        }
        if(page == 2){
            newUser.setLastName(box2.getText().toString());
            newUser.setAge(Integer.parseInt(box3.getText().toString()));
            newUser.setAddress(box4.getText().toString());
            newUser.setUniversity(menu.getSelectedItem().toString());
        }
        if(page == 3){
            newDog.setFirstNameDog(box1.getText().toString());
            newDog.setBreed(box2.getText().toString());
            newDog.setAgeDog(Integer.parseInt(box3.getText().toString()));
            newDog.setDescriptionDog(box4.getText().toString());
            newDog.setEnergyDog(menu.getSelectedItem().toString());
            newUser.setDog(newDog);
        }
        // If they register as an Admin or Moderator, their profile should be generated immediately.
        if(page == 1 && !menu.getSelectedItem().toString().equals(DoggyInterface.UserType.OWNER.getDescription())) {
            System.out.println("This is not a dog owner!");

            // TODO Remove
            // TODO Generate User and set user type to Moderator or Admin
            newUser.setFirstName(box1.getText().toString());
            newUser.setEmail(box2.getText().toString());
            newUser.setPassword(box4.getText().toString());

            newUser.setDog(newDog);
            if(menu.getSelectedItem().toString() == "Moderator") {
                newUser.setUserTypeId(1);
                newDog.setFirstNameDog("Moderator");
                newDog.setDescriptionDog("Moderate people");
            }
            else{
                newUser.setUserTypeId(2);
                newDog.setFirstNameDog("Viewer");
                newDog.setDescriptionDog("just seeing");
            }
            GetUserApi().postuser(newUser).enqueue(new SlimCallback<User>(user->{  }));
            staticUser.setUser(newUser);
            GetUserApi().getEverbody(newUser.getEmail()).enqueue(new SlimCallback<List<User>>(user->{ staticUser.setlist(user); }));
            startActivity(new Intent(Register.this, Home.class));
            finish();

        } else {

            if(++page < LAST_PAGE) displayPage(page);
            else {
                if(DoggyInterface.DoggyController.isSignedIn()) {

                    staticUser.getUser().getDog().setFirstNameDog(box1.getText().toString());
                    staticUser.getUser().getDog().setBreed(box2.getText().toString());
                    staticUser.getUser().getDog().setAgeDog(Integer.parseInt(box3.getText().toString()));
                    staticUser.getUser().getDog().setDescriptionDog(box4.getText().toString());
                    staticUser.getUser().getDog().setEnergyDog(menu.getSelectedItem().toString());
                    newUser = staticUser.getUser();
                }
                    GetUserApi().postuser(newUser).enqueue(new SlimCallback<User>(user -> {
                    }));
                    staticUser.setUser(newUser);
                    GetUserApi().getEverbody(newUser.getEmail()).enqueue(new SlimCallback<List<User>>(user -> {
                        staticUser.setlist(user);
                    }));
                    startActivity(new Intent(Register.this, Home.class));
                    finish();
                }
                // TODO Generate a NEW User Request
                //  OR Check if the User is signed in,
                //  then instead of generating a new User Object, Update Current
                //      FUNCTION: DoggyInterface.DoggyController.isSignedIn();
            }
        }


    /**
     * Display the Next Page
     * @param page Page Number
     */
    private void displayPage(int page)
    {
        // Clear Text in TextBoxes from Previous Entries
        clearEntries();

        switch(page)
        {
            case 1:
                // Set Page Title - Page 1 Create an Account
                pageTitle.setText("Create an Account");
                // Set Menu Items
                // User Type: Dog Owner, Moderator, Admin
                    // For all USERTYPE add DESCRIPTION to MENU OPTIONS
                    for(DoggyInterface.UserType type : DoggyInterface.UserType.values()) {
                        optionMap.put(optionMap.size(), type.getDescription());
                    }
                break;
            case 2:
                // Set Page Title - Page 2 Owner Information
                pageTitle.setText("Owner's Information");
                // Set TextBox values
                box1.setHint("First Name");
                    box1.setInputType(InputType.TYPE_CLASS_TEXT);
                box2.setHint("Last Name");
                    box2.setInputType(InputType.TYPE_CLASS_TEXT);
                box3.setHint("Age");
                    box3.setInputType(InputType.TYPE_CLASS_NUMBER);
                box4.setHint("Street Address");
                    box4.setInputType(InputType.TYPE_CLASS_TEXT);
                // Set Menu Items
                // Universities - TODO can be automated
                    optionMap.put(optionMap.size(), "Iowa State University");
                    optionMap.put(optionMap.size(), "University of Iowa");
                    optionMap.put(optionMap.size(), "DMACC");
                break;
            case 3:
                // Set Page Title - Page 3 Dog Information
                if(DoggyInterface.DoggyController.isSignedIn()) pageTitle.setText("Update Dog");
                else pageTitle.setText("Dog's Information");
                box1.setHint("Name");
                    box1.setInputType(InputType.TYPE_CLASS_TEXT);
                box2.setHint("Breed");
                    box2.setInputType(InputType.TYPE_CLASS_TEXT);
                box3.setHint("Age");
                    box3.setInputType(InputType.TYPE_CLASS_NUMBER);
                box4.setHint("Description");
                    box4.setInputType(InputType.TYPE_CLASS_TEXT);
                // Set Menu Items
                // Energy: High, Moderate, Low - TODO can be automated
                    optionMap.put(optionMap.size(), "High");
                    optionMap.put(optionMap.size(), "Moderate");
                    optionMap.put(optionMap.size(), "Low");
                break;
            default:
                pageTitle.setText("Unable to Load Registration Page");
                continueButton.setEnabled(false);
                break;
        }

        // Generate Menu Items
        String[] options = new String[optionMap.keySet().size()];
        for(int i : optionMap.keySet()) {
            options[i] = optionMap.get(i);
        }
        menu.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, options));
        optionMap.clear();
    }

    /**
     * Sets Text Entries to BLANK
     */
    private void clearEntries()
    {
        box1.setText("");
        box2.setText("");
        box3.setText("");
        box4.setText("");
    }

    /**
     * Shows a Date Picker Dialog
     * Source from GitHub
     * https://github.com/mitchtabian/DatePickerDialog-Example
     */
    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    /**
     * Retrieves the Actual Date
     * from Date Picker Dialog
     * Source from GitHub
     * https://github.com/mitchtabian/DatePickerDialog-Example
     * @param view Date Picker Dialog
     * @param year Year
     * @param month Month
     * @param dayOfMonth Day
     */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = (month + 1) + "/" + dayOfMonth + "/" + year;
        // Display in BOX3 - TODO return to ?? as DATE
        box3.setText(date);
    }
}
