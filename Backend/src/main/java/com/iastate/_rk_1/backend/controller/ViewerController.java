package com.iastate._rk_1.backend.controller;

import com.iastate._rk_1.backend.entity.User;
import com.iastate._rk_1.backend.entity.Viewer;
import com.iastate._rk_1.backend.service.ViewerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ViewerController {

    @Autowired
    private ViewerService viewerService;

    /**
     * Shows a list of all the users in the repository.
     * @return a list of User objects
     */
    @GetMapping("/viewer")
    public List<Viewer> getUsers() {
        return viewerService.getUsers();
    }

    /**
     * Gets a viewer by the provided email
     * @param email the email of the user to get
     * @return viewer object if the email provided matches with an existing viewer
     */
    @GetMapping("/viewer/email/{email}")
    public Viewer userByEmail(@PathVariable String email) {
        return viewerService.getUsersByEmail(email);
    }

    /**
     * Adds a new viewer to the database if user isn't already in database
     * @param viewer the viewer object that will be added
     * @return the Viewer that has been added to the database
     */
    @ApiOperation(value = "Add viewer to the database.", tags = "addViewer")
    @PostMapping("/viewer")
    public Viewer addViewer(@RequestBody Viewer viewer) {
        return viewerService.saveUser(viewer);
    }

    /**
     * Checks if the viewer exists and signs them in
     * @param possibleViewer the viewer that will be signed in
     * @return a String "Success: Enters home page" if the possibleViewer exists in the database.
     * A String "Email not found" if email not found.
     */
    @ApiOperation(value = "Take user to home page if user is in database. The requestBody should be given " +
            "an email and a password", tags = "signIn")
    @PostMapping("/viewer/sign-in")
    public String signIn(@RequestBody Viewer possibleViewer){
        //verifies if there is given email in repository
        if (userByEmail(possibleViewer.getEmail()) != null){
            Viewer existingUser = viewerService.getUsersByEmail(possibleViewer.getEmail());
            //verifies if existing email matches with given password
            if (existingUser.getPassword().equals(possibleViewer.getPassword())){
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
    @GetMapping("/viewer/home")
    public List<User> findMatchesViewer() {
        return viewerService.findMatches();
    }


}
