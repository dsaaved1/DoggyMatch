package com.iastate._rk_1.service;

import com.iastate._rk_1.backend.repository.UserRepository;

import java.util.List;

import com.iastate._rk_1.backend.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public User saveUser(User user) {
    return repository.save(user);
  }

  public List<User> getUsers() {
    return repository.findAll();
  }

  public User getUsersByEmail(String email) {
    return repository.findByEmail(email);
  }
}
