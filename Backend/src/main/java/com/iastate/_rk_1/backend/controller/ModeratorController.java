package com.iastate._rk_1.backend.controller;

import com.iastate._rk_1.backend.entity.Moderator;
import com.iastate._rk_1.backend.entity.User;
import com.iastate._rk_1.backend.entity.Viewer;
import com.iastate._rk_1.backend.service.ModeratorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModeratorController {

    @Autowired
    private ModeratorService moderatorService;

    /**
     * Shows a list of all the users in the repository.
     * @return a list of User objects
     */
    @GetMapping("/moderator")
    public List<Moderator> getUsers() {
        return moderatorService.getUsers();
    }

    /**
     * Gets a moderator by the provided email
     * @param email the email of the user to get
     * @return the moderator object if the email provided matches with an existing moderator
     */
    @GetMapping("/moderator/email/{email}")
    public Moderator userByEmail(@PathVariable String email) {
        return moderatorService.getUsersByEmail(email);
    }

    /**
     * Adds a new user to the database if moderator isn't already in database
     * @param moderator the Moderator object that will be added
     * @return the Moderator that has been added to the database
     */
    @ApiOperation(value = "Add moderator to the database.", tags = "addModerator")
    @PostMapping("/moderator")
    public Moderator addModerator(@RequestBody Moderator moderator) {
        return moderatorService.saveUser(moderator);
    }

    /**
     * Checks if the moderator exists and signs them in
     * @param possibleModerator the viewer that will be signed in
     * @return a String "Success: Enters home page" if the possibleModerator exists in the database.
     * A String "Email not found" if email not found.
     */
    @ApiOperation(value = "Take user to home page if user is in database. The requestBody should be given " +
            "an email and a password", tags = "signIn")
    @PostMapping("/moderator/sign-in")
    public String signIn(@RequestBody Viewer possibleModerator){
        //verifies if there is given email in repository
        if (userByEmail(possibleModerator.getEmail()) != null){
            Moderator existingUser = moderatorService.getUsersByEmail(possibleModerator.getEmail());
            //verifies if existing email matches with given password
            if (existingUser.getPassword().equals(possibleModerator.getPassword())){
                return "Success: Enters home page";
            } else {
                return "Incorrect Password";
            }
        }
        return "Email not found";
    }

    /**
     * Gets all users in database.
     * @return list of users
     */
    @GetMapping("/moderator/home")
    public List<User> findMatchesModerator() {
        return moderatorService.findMatches();
    }


    /**
     * Deletes a user with the provided id and add the user to a list of the current moderator
     * @param id the id of the user to be deleted
     * @return a string "success" that tells us that the user has been deleted
     */
    @PutMapping("/moderator/home/{email},{id}")
    public String deleteUserModerator(@PathVariable(name = "email") String email, @PathVariable(name = "id") int id) {
        return moderatorService.deleteUserModerator(email, id);
    }
}
