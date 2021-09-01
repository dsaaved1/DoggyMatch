package com.experiment2.experiment2;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final HashMap<Integer, String> users;

  public UserController(HashMap<Integer, String> users) {
    this.users = users;
  }

  @GetMapping("/{id}")
  public String getUser(@PathVariable int id) {
    return users.get(id);
  }

  @GetMapping("/new")
  public String newUser(@RequestParam(name = "id") int id, @RequestParam String name) {
    if (users.get(id) == null) {
      users.put(id, name);
      return "success";
    }
    return "user already exists";
  }
}
