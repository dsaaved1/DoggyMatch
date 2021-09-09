package com._rk_1.experiment2.Controller;

import java.util.Base64;

import com._rk_1.experiment2.Entity.User;
import com._rk_1.experiment2.Repository.UserRepository;
import com._rk_1.experiment2.Util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/user")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/register")
  public @ResponseBody String register(@RequestParam String name, @RequestParam String email,
      @RequestParam String password) {

    User tmp = userRepository.findByEmail(email);

    if (tmp != null) {
      return "user already exists";
    }

    byte[] salt = Util.getSalt();
    byte[] hash = Util.PBKDF2(password, salt);

    String encodedSalt = Base64.getEncoder().encodeToString(salt);
    String encodedHash = Base64.getEncoder().encodeToString(hash);

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    n.setSalt(encodedSalt);
    n.setPassword(encodedHash);
    userRepository.save(n);

    return n.getPassword();
  }

  @PostMapping("/login")
  public @ResponseBody String login(@RequestParam String email, @RequestParam String password) {
    User currentUser = userRepository.findByEmail(email);

    if (currentUser == null) {
      return "user does not exist";
    }

    byte[] salt = Base64.getDecoder().decode(currentUser.getSalt());
    byte[] hash = Util.PBKDF2(password, salt);

    String userPassword = currentUser.getPassword();
    String encodedHash = Base64.getEncoder().encodeToString(hash);

    if (!encodedHash.equals(userPassword)) {
      return "incorrect username or password";
    }
    return "logged in, welcome";
  }

  @GetMapping("/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
