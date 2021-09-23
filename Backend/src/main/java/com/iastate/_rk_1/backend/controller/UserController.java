package com.iastate._rk_1.backend.controller;

import com.iastate._rk_1.backend.entity.User;
import com.iastate._rk_1.backend.service.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping("/list")
  public List<User> index() {
    return service.getUsers();
  }

  @GetMapping("/{name}")
  public User userByName(@PathVariable String name) {
    return service.getUserByFirstName(name);
  }

  @PostMapping("/new")
  public User addUser(@RequestBody User user) {
    return service.saveUser(user);
  }
}
