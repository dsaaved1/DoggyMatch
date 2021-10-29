package com.iastate._rk_1.backend.controller;

import com.iastate._rk_1.backend.entity.DogInfo;
import com.iastate._rk_1.backend.entity.Preferences;
import com.iastate._rk_1.backend.entity.User;
import com.iastate._rk_1.backend.service.UserService;

import java.util.List;
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



  @PostMapping("/user")
  public User addUser(@RequestBody User user) {
    return service.saveUser(user);
  }

  //Diego
  @PutMapping("/user/sign-in")
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

  //Diego path should be: /user/register/{id} with path variable int id as a parameter
  @PutMapping("/user/register/{id}")
  public User ownersInfo(@RequestBody User user, @PathVariable(name = "id") int id){
    return service.updateUser(user, id);
  }

  //Diego path should be /user/register/dog-info/{id} with path variable int id as a parameter
  @PostMapping("/user/register/dog-info/{id}")
  public User dogsInfo(@RequestBody DogInfo dogInfo, @PathVariable(name = "id") int id){
    return service.updateUserDogInfo(dogInfo, id);
  }

  //Diego path should be: /user/register/preferences/{id} with path variable int id as a parameter
  @PostMapping("/user/register/preferences/{id}")
  public User preferences(@RequestBody Preferences preferences, @PathVariable(name = "id") int id){
    return service.updateUserPreferences(preferences, id);
  }

  //Diego path should be" /user/home/{email} with path variable String email as a parameter
  @GetMapping("/user/home/{email}")
  public List<User> findMatches(@PathVariable(name = "email") String email) {
    return service.findMatches(email);
  }

}
