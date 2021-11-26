package com.iastate._rk_1.backend.service;

import com.iastate._rk_1.backend.entity.Moderator;
import com.iastate._rk_1.backend.entity.User;
import com.iastate._rk_1.backend.repository.ModeratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeratorService {

    @Autowired
    private ModeratorRepository moderatorRepository;

    @Autowired
    private UserService userService;

    /**
     * Adds a new user to the database if user isn't already in database
     * @param moderator the User object that will be added
     * @return the User that has been added to the database
     */
    public Moderator saveUser(Moderator moderator) {
        //checking if this email is already in repository
        Moderator userExists = moderatorRepository.findByEmail(moderator.getEmail());

        if (userExists != null) {
            throw new IllegalStateException("email already taken");
        }

        return moderatorRepository.save(moderator);
    }

    /**
     * Shows a list of all the users in the repository.
     * @return a list of User objects
     */
    public List<Moderator> getUsers() {
        return moderatorRepository.findAll();
    }

    /**
     * Gets a user by the provided email
     * @param email the email of the user to get
     * @return he User object if the email provided matches with an existing User
     */
    public Moderator getUsersByEmail(String email) {
        return moderatorRepository.findByEmail(email);
    }


    /**
     * Gets all users in database.
     * @return list of users
     */
    public List<User> findMatches() {
        return userService.getUsers();
    }

    /**
     * Deletes a user with the provided id
     * @param id the id of the user to be deleted
     * @return a string "success" that tells us that the user has been deleted
     */
    public String deleteUserModerator(String email, int id) {
        User userToDelete = userService.getUserById(id);
        Moderator currentModerator = getUsersByEmail(email);
        currentModerator.getDeletedUsers().add(userToDelete);
        userService.deleteUser(id);
        return "success";
    }
}
