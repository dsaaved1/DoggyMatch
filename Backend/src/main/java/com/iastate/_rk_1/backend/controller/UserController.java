package com.iastate._rk_1.backend.controller;

import com.iastate._rk_1.backend.entity.DogInfo;
import com.iastate._rk_1.backend.entity.Preferences;
import com.iastate._rk_1.backend.entity.User;
import com.iastate._rk_1.backend.service.UserService;

import java.util.List;

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
   * @return List<User>
   */
  @GetMapping("/user")
  public List<User> index() {
    return service.getUsers();
  }

  
  /**
   * Updates a user with the given user object
   * @param user the user that will be updated
   * @param id the id of the user that will be updated
   * @return User the user that will be updated
   */
  @PutMapping("/user")
  public User updateUser(@RequestBody User user, @PathVariable int id) {
    return service.updateUser(user, id);
  }

  
  /**
   * Deletes a user with the provided id
   * @param id the id of the user to be deleted
   * @return String
   */
  @DeleteMapping("/user/{id}")
  public String deleteUser(@PathVariable int id) {
    return service.deleteUser(id);
  }

  
  /**
   * Gets a user by the provided id
   * @param id the id of the user to get
   * @return User
   */
  @GetMapping("/user/{id}")
  public User getByID(@PathVariable int id) {
    return service.getUserById(id);
  }

  
  /**
   * Gets a user by the provided email
   * @param email the email of the user to get
   * @return User
   */
  @GetMapping("/user/email/{email}")
  public User userByEmail(@PathVariable String email) {
    return service.getUsersByEmail(email);
  }


  
  /**
   * Adds a new user to the database
   * @param user the user that will be added
   * @return User
   */
  @ApiOperation(value = "Add user to the database.", tags = "addUser")
  @PostMapping("/user")
  public User addUser(@RequestBody User user) {
    return service.saveUser(user);
  }

  
  /**
   * Checks if the user exists and signs them in
   * @param possibleUser the user that will be signed in
   * @return String
   */
  @ApiOperation(value = "Take user to home page if user is in database.", tags = "signIn")
  @PostMapping("/user/sign-in")
  public String signIn(@RequestBody User possibleUser){
    //verifies if there is given email in repository
    if (userByEmail(possibleUser.getEmail()) != null){
      User existingUser = service.getUsersByEmail(possibleUser.getEmail());
      //verifies if existing email matches with given password
      if (existingUser.getPassword().equals(possibleUser.getPassword())){
        return "Success: Enters home page";
      }
    }
    return "Email not found";
  }

  
  /** Registers a user and adds them to the database
   * @param user the user that will be registered
   * @param id the id of the user to register
   * @return User
   */
  @ApiOperation(value = "Complete user's information in the System.", tags = "ownersInfo")
  @PutMapping("/user/register/{id}")
  public User ownersInfo(@RequestBody User user, @PathVariable(name = "id") int id){
    return service.updateUser(user, id);
  }

  
  /**
   * Adds a users dog info to the database
   * @param dogInfo the doginfo that will be added
   * @param id the id of the user to update the doginfo
   * @return User
   */
  @ApiOperation(value = "Post users' dog information in the System.", tags = "dogInfo")
  @PostMapping("/user/register/dog-info/{id}")
  public User dogsInfo(@RequestBody DogInfo dogInfo, @PathVariable(name = "id") int id){
    return service.updateUserDogInfo(dogInfo, id);
  }

  
  /**
   * Adds a user's preferences to the database
   * @param preferences the preferences that will be added
   * @param id the id of the user to update the preferences
   * @return User
   */
  @ApiOperation(value = "Post users' preferences in the System.", tags = "preferences")
  @PostMapping("/user/register/preferences/{id}")
  public User preferences(@RequestBody Preferences preferences, @PathVariable(name = "id") int id){
    return service.updateUserPreferences(preferences, id);
  }

  
  /**
   * Gets a list of possible matches
   * @param email the email of the user to get matches for
   * @return List<User>
   */
  @ApiOperation(value = "Get list of users (possible matches) sorted by the given user preferences.", tags = "findMatches")
  @GetMapping("/user/home/{email}")
  public List<User> findMatches(@PathVariable(name = "email") String email) {
    return service.findMatches(email);
  }

  
  /**
   * Gets every user except the provided email
   * @param email the email of the user to exclude
   * @return List<User>
   */
  @ApiOperation(value = "Get list of users (possible matches) without any sorting.", tags = "getEverybody")
  @GetMapping("/user/everybody/{email}")
  public List<User> getEverybody(@PathVariable(name = "email") String email) {
    return service.findEverybody(email);
  }

  
  /**
   * Creates a match between two users
   * @param userId the id of the first match
   * @param possibleMatchId the id of the second match
   * @return User
   */
  @ApiOperation(value = "Creates a chat in both given users, if both users liked each other. Otherwise, puts the liked user in its possible matches field.", tags = "match")
  @PutMapping("/user/home/match/{id},{id2}")
  public User match(@PathVariable(name = "id") int userId, @PathVariable(name = "id2") int possibleMatchId){
    return service.match(userId, possibleMatchId);
  }

}
