package com.example.homeplate;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homeplate.api.SlimCallback;
import com.example.homeplate.model.User;

/**
 * Registration Activity
 * <br>
 *     Sends a put request for a new user
 * @author Corbin Graham
 */
public class Register extends AppCompatActivity {
    Button regs;
    EditText email;
    EditText password;
    User newUser = new User();

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // DoggyInterface.DoggyController.isSignedIn();
        Spinner spinner = findViewById(R.id.registerDropDown);
        spinner.setPrompt("Hello");
        String[] items = {"Bob", "Steve", "Stan"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, items));


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

            }
        });
    }

    private void displayPage(int page)
    {
        switch(page)
        {
            case 1:
                pageTitle.setText("Create an Account");

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
    }
}
