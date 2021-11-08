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

  @GetMapping("/user")
  public List<User> index() {
    return service.getUsers();
  }

  @PutMapping("/user")
  public User updateUser(@RequestBody User user, @PathVariable int id) {
    return service.updateUser(user, id);
  }

  @DeleteMapping("/user/{id}")
  public String deleteUser(@PathVariable int id) {
    return service.deleteUser(id);
  }

  @GetMapping("/user/{id}")
  public User getByID(@PathVariable int id) {
    return service.getUserById(id);
  }

  @GetMapping("/user/email/{email}")
  public User userByEmail(@PathVariable String email) {
    return service.getUsersByEmail(email);
  }


  @ApiOperation(value = "Add user to the database.", tags = "addUser")
  @PostMapping("/user")
  public User addUser(@RequestBody User user) {
    return service.saveUser(user);
  }

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

  @ApiOperation(value = "Complete user's information in the System.", tags = "ownersInfo")
  @PutMapping("/user/register/{id}")
  public User ownersInfo(@RequestBody User user, @PathVariable(name = "id") int id){
    return service.updateUser(user, id);
  }

  @ApiOperation(value = "Post users' dog information in the System.", tags = "dogInfo")
  @PostMapping("/user/register/dog-info/{id}")
  public User dogsInfo(@RequestBody DogInfo dogInfo, @PathVariable(name = "id") int id){
    return service.updateUserDogInfo(dogInfo, id);
  }

  @ApiOperation(value = "Post users' preferences in the System.", tags = "preferences")
  @PostMapping("/user/register/preferences/{id}")
  public User preferences(@RequestBody Preferences preferences, @PathVariable(name = "id") int id){
    return service.updateUserPreferences(preferences, id);
  }

  @ApiOperation(value = "Get list of users (possible matches) sorted by the given user preferences.", tags = "findMatches")
  @GetMapping("/user/home/{email}")
  public List<User> findMatches(@PathVariable(name = "email") String email) {
    return service.findMatches(email);
  }

  @ApiOperation(value = "Get list of users (possible matches) without any sorting.", tags = "getEverybody")
  @GetMapping("/user/everybody/{email}")
  public List<User> getEverybody(@PathVariable(name = "email") String email) {
    return service.findEverybody(email);
  }

  @ApiOperation(value = "Creates a chat in both given users, if both users liked each other. Otherwise, puts the liked user in its possible matches field.", tags = "match")
  @PutMapping("/user/home/match/{id},{id2}")
  public User match(@PathVariable(name = "id") int userId, @PathVariable(name = "id2") int possibleMatchId){
    return service.match(userId, possibleMatchId);
  }

}
