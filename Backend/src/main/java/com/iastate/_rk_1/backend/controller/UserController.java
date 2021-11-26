package com.iastate._rk_1.backend.controller;

import com.iastate._rk_1.backend.entity.*;
import com.iastate._rk_1.backend.service.ModeratorService;
import com.iastate._rk_1.backend.service.UserService;

import java.util.List;

import com.iastate._rk_1.backend.service.ViewerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "DoggyMatchMainRestController", description = "REST Api related to User Entity!")
@RestController
public class UserController {

  @Autowired
  private UserService service;

  
  /**
   * Shows a list of all the users in the repository.
   * @return a list of User objects
   */
  @GetMapping("/user")
  public List<User> getUsers() {
    return service.getUsers();
  }


  
  /**
   * Gets a user by the provided id
   * @param id the id of the user to get
   * @return the User object if the id provided matches with an existing User
   */
  @GetMapping("/user/{id}")
  public User getByID(@PathVariable int id) {
    return service.getUserById(id);
  }

  
  /**
   * Gets a user by the provided email
   * @param email the email of the user to get
   * @return he User object if the email provided matches with an existing User
   */
  @GetMapping("/user/email/{email}")
  public User userByEmail(@PathVariable String email) {
    return service.getUsersByEmail(email);
  }


  
  /**
   * Adds a new user to the database if user isn't already in database
   * @param user the User object that will be added
   * @return the User that has been added to the database
   */
  @ApiOperation(value = "Add user to the database.", tags = "addUser")
  @PostMapping("/user")
  public User addUser(@RequestBody User user) {
    return service.saveUser(user);
  }



  @PostMapping("/user/register/{userType}")
  public String signUp(@RequestBody User user, @PathVariable String userType){
    if (userType.equals("Moderator")){
      return "goes to moderator sign-up page";
    }
    if (userType.equals("Viewer")){
      return "goes to viewer sign-up page";
    }

    return "goes to user sign-up page";
  }


  /**
   * Checks if the user exists and signs them in
   * @param possibleUser the user that will be signed in
   * @return a String "Success: Enters home page" if the possibleUser exists in the database.
   * A String "Email not found" if email not found.
   */
  @ApiOperation(value = "Take user to home page if user is in database. The requestBody should be given " +
          "an email and a password", tags = "signIn")
  @PostMapping("/user/sign-in")
  public String signIn(@RequestBody User possibleUser){
    //verifies if there is given email in repository
    if (userByEmail(possibleUser.getEmail()) != null){
      User existingUser = service.getUsersByEmail(possibleUser.getEmail());
      //verifies if existing email matches with given password
      if (existingUser.getPassword().equals(possibleUser.getPassword())){
        return "Success: Enters home page";
      } else {
        return "Incorrect Password";
      }
    }
    return "Email not found";
  }

  
  /** Updates a User's info provided by an id
   * @param user the user that will be updated
   * @param id the id of the user to update his or her information
   * @return the User object with its new information updated
   */
  @ApiOperation(value = "Complete user's information in the System.", tags = "ownersInfo")
  @PutMapping("/user/register/{id}")
  public User ownersInfo(@RequestBody User user, @PathVariable(name = "id") int id){
    return service.updateUser(user, id);
  }

  
  /**
   * Adds a User's dog information to the database provided by an id
   * @param dogInfo the dogInfo object that will be added to the User
   * @param id the id of the user to update its dogInfo
   * @return the User object with its dogInfo stored
   */
  @ApiOperation(value = "Post users' dog information in the System.", tags = "dogInfo")
  @PostMapping("/user/register/dog-info/{id}")
  public User dogsInfo(@RequestBody DogInfo dogInfo, @PathVariable(name = "id") int id){
    return service.updateUserDogInfo(dogInfo, id);
  }

  
  /**
   * Adds a user's preferences to the database provided by an id
   * @param preferences the preferences that will be added to the User
   * @param id the id of the user to update the preferences
   * @return the User object with its preferences stored
   */
  @ApiOperation(value = "Post users' preferences in the System.", tags = "preferences")
  @PostMapping("/user/register/preferences/{id}")
  public User preferences(@RequestBody Preferences preferences, @PathVariable(name = "id") int id){
    return service.updateUserPreferences(preferences, id);
  }

  
  /**
   * Gets a list of possible matches of a given user, which are User objects, sorted by the user preferences.
   * The first possible match being the "best one" for the user, and the last possible match on the list
   * being the "worst one".
   * @param email the email of the user we want to get its possible matches
   * @return the possible matches (User objects) of the User provided by email
   */
  @ApiOperation(value = "Get list of users (possible matches) sorted by the given user preferences.", tags = "findMatches")
  @GetMapping("/user/home/{email}")
  public List<User> findMatches(@PathVariable(name = "email") String email) {
    return service.findMatches(email);
  }

  
  /**
   * Gets every user except the User from provided email
   * @param email the email of the user to exclude
   * @return all Users on the database except the User from provided email
   */
  @ApiOperation(value = "Get list of users (possible matches) without any sorting.", tags = "getEverybody")
  @GetMapping("/user/everybody/{email}")
  public List<User> getEverybody(@PathVariable(name = "email") String email) {
    return service.findEverybody(email);
  }

  
  /**
   * Creates a match between two users.
   * @param userId the id of the user
   * @param possibleMatchId the id of user who the first user wants to make a match with
   * @return User
   */
  @ApiOperation(value = "Creates a chat in both given users, if both users liked each other. Otherwise, puts the liked user in its possible matches field.", tags = "match")
  @PutMapping("/user/home/match/{id},{id2}")
  public User match(@PathVariable(name = "id") int userId, @PathVariable(name = "id2") int possibleMatchId){
    return service.match(userId, possibleMatchId);
  }


}
