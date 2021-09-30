package com.iastate._rk_1.backend.controller;

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
  public User updateUser(@RequestBody User user) {
    return service.updateUser(user);
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
}
