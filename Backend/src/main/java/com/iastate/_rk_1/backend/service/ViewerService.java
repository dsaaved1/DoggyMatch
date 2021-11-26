package com.iastate._rk_1.backend.service;

import com.iastate._rk_1.backend.entity.User;
import com.iastate._rk_1.backend.entity.Viewer;
import com.iastate._rk_1.backend.repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewerService {

    @Autowired
    private ViewerRepository viewerRepository;

    @Autowired
    private UserService userService;

    /**
     * Adds a new user to the database if user isn't already in database
     * @param viewer the User object that will be added
     * @return the User that has been added to the database
     */
    public Viewer saveUser(Viewer viewer) {
        //checking if this email is already in repository
        Viewer userExists = viewerRepository.findByEmail(viewer.getEmail());

        if (userExists != null) {
            throw new IllegalStateException("email already taken");
        }
        return viewerRepository.save(viewer);
    }

    /**
     * Shows a list of all the users in the repository.
     * @return a list of User objects
     */
    public List<Viewer> getUsers() {
        return viewerRepository.findAll();
    }

    /**
     * Gets a user by the provided email
     * @param email the email of the user to get
     * @return he User object if the email provided matches with an existing User
     */
    public Viewer getUsersByEmail(String email) {
        return viewerRepository.findByEmail(email);
    }


    /**
     * Gets all users in database.
     * @return list of users
     */
    public List<User> findMatches() {
        return userService.getUsers();
    }
}
