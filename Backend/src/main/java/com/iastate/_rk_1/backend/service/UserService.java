package com.iastate._rk_1.backend.service;

import antlr.BaseAST;
import com.iastate._rk_1.backend.repository.UserRepository;

import java.util.List;

import com.iastate._rk_1.backend.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;


  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserService() {
    bCryptPasswordEncoder = null;
  }

  public User saveUser(User user) {
    return repository.save(user);
  }

  public List<User> getUsers() {
    return repository.findAll();
  }

  public User getUserById(int id) {
    return repository.findById(id);
  }

  public User getUsersByEmail(String email) {
    return repository.findByEmail(email);
  }

  public User getUserByFirstName(String name) {
    return repository.findByFirstName(name);
  }

  public String deleteUser(int id) {
    repository.deleteById(id);
    return "success";
  }

  public User updateUser(User user) {
    User existingUser = repository.findById(user.getId());
    existingUser.setActive(user.isActive());
    existingUser.setAddress(user.getAddress());
    existingUser.setAge(user.getAge());
    existingUser.setEmail(user.getEmail());
    existingUser.setFirstName(user.getFirstName());
    existingUser.setGender(user.getGender());
    existingUser.setLastLoginTime(user.getLastLoginTime());
    existingUser.setEmail(user.getEmail());
    existingUser.setLastName(user.getLastName());
    existingUser.setPhoto(user.getPhoto());
    existingUser.setPrivacySettings(user.getPrivacySettings());
    existingUser.setReferenceDogInfoTable(user.getReferenceDogInfoTable());
    existingUser.setUniversity(user.getUniversity());
    return repository.save(existingUser);
  }

  public void signUp(User user) {

    //checking if this email is already in repository
    User userExists = repository.findByEmail(user.getEmail());

    if (userExists != null) {
      throw new IllegalStateException("email already taken");
    }


    //encrypting the user's password using bcrypt, which uses the method "salting"

    String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

    user.setEncryptedPassword(encodedPassword);

    saveUser(user);
  }
}
