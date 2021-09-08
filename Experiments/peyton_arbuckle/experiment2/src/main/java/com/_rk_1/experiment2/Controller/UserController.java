package com._rk_1.experiment2.Controller;

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

  private UserRepository userRepository;

  @PostMapping("/register")
  public @ResponseBody String register(@RequestParam String name, @RequestParam String email,
      @RequestParam String password) {

    // System.out.println(userRepository.findByEmail(email));
    User n = new User();
    n.setName(name);
    n.setEmail(email);

    byte[] salt = Util.getSalt();
    n.setSalt(Util.toHex(salt));

    byte[] hash = Util.PBKDF2(password, salt);

    n.setPassword(Util.toHex(hash));
    userRepository.save(n);

    return n.getPassword();
  }

  @GetMapping("/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
