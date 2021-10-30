package com.iastate._rk_1.backend.service;

import antlr.BaseAST;
import com.iastate._rk_1.backend.entity.Chat;
import com.iastate._rk_1.backend.entity.DogInfo;
import com.iastate._rk_1.backend.entity.Preferences;
import com.iastate._rk_1.backend.repository.UserRepository;

import java.util.Iterator;
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

  //Diego
  public User updateUser(User user, int id) {
    User existingUser = repository.findById(id);
    existingUser.setFirstName(user.getFirstName());
    existingUser.setLastName(user.getLastName());
    existingUser.setAge(user.getAge());
    existingUser.setAddress(user.getAddress());
    existingUser.setUniversity(user.getUniversity());
    existingUser.setGender(user.getGender());
    existingUser.setPhoto(user.getPhoto());
    return repository.save(existingUser);
  }

  //Diego
  public User updateUserDogInfo(DogInfo dogInfo, int id){
    User existingUser = repository.findById(id);
    existingUser.setDogInfo(dogInfo);
    return repository.save(existingUser);
  }

  //Diego
  public User updateUserPreferences(Preferences preferences, int id){
    User existingUser = repository.findById(id);
    existingUser.setPreferences(preferences);
    return repository.save(existingUser);
  }

  //Diego
  public User signUp(User user) {

    //checking if this email is already in repository
    User userExists = repository.findByEmail(user.getEmail());

    if (userExists != null) {
      throw new IllegalStateException("email already taken");
    }

    //encrypting the user's password using bcrypt, which uses the method "salting"

    String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

    user.setEncryptedPassword(encodedPassword);

    return saveUser(user);
  }

  //Diego
  public List<User> findMatches(String email) {
      List<User> allUsers = repository.findAll();

        for (Iterator<User> iterator = allUsers.iterator(); iterator.hasNext(); ) {
          User user = iterator.next();
          if (user.getEmail().equals(email)){
            iterator.remove();
          }
        }

       Preferences userPreferences = getUsersByEmail(email).getPreferences();
       for (Iterator<User> iterator = allUsers.iterator(); iterator.hasNext(); ) {

           User possibleMatch = iterator.next();
           DogInfo dogPossibleMatch = possibleMatch.getDogInfo();

           if (dogPossibleMatch.getBreed().equals(userPreferences.getBreed())){
              possibleMatch.addCompatibility();
           }
           if (dogPossibleMatch.getAgeDog() == userPreferences.getAgeDog()){
              possibleMatch.addCompatibility();
           }
           if (dogPossibleMatch.getGenderDog().equals(userPreferences.getGenderDog())){
              possibleMatch.addCompatibility();
           }

       }

      int n = allUsers.size();
       // One by one move boundary of unsorted subarray
       for (int i = 0; i < n-1; i++) {
       // Find the user with the highest compatibility in unsorted array
       int max_idx = i;
       for (int j = i+1; j < n; j++) {
         if (allUsers.get(j).getCompatibility() > allUsers.get(max_idx).getCompatibility()){
           max_idx = j;
          }
       }
       // Swap the user with the highest compatibility with the first user
       User temp = allUsers.get(max_idx);
       allUsers.set(max_idx, allUsers.get(i));
       allUsers.set(i, temp);
       }

       for (Iterator<User> iterator = allUsers.iterator(); iterator.hasNext(); ) {
          User user = iterator.next();
          user.clearCompatibility();
       }

      return allUsers;
  }

  /**
    public void match(int userId, int possibleMatchId) {
        User currentUser = getUserById(userId);
        User possibleMatchUser = getUserById(possibleMatchId);
        System.out.println(currentUser.getPossibleMatches());
        System.out.println(possibleMatchUser.getPossibleMatches());
    }

   */


     //Diego
     public User match(int userId, int possibleMatchId) {
     User currentUser = getUserById(userId);
     User possibleMatchUser = getUserById(possibleMatchId);


     //checks if you are on possibleMatches of the user you would like to match with
     System.out.println("checking possible matches from possibleMatch: should be empty");
     System.out.println(possibleMatchUser.getPossibleMatches());
     for (User user: possibleMatchUser.getPossibleMatches()){
     System.out.println("checking user in possibleMatches");
     System.out.println(user.getEmail());
     //if you are, it creates a chat with you
         if (user.getId() == userId){
             System.out.println("checking if it has the same id as user");
             System.out.println(user.getId());
             Chat chat = new Chat();
             chat.getUsers().add(currentUser);
             chat.getUsers().add(possibleMatchUser);
             currentUser.getChats().add(chat);
             possibleMatchUser.getChats().add(chat);
             possibleMatchUser.getPossibleMatches().remove(currentUser);
             return repository.save(currentUser);
         }
     }

     System.out.println("checking if they don't match");
     System.out.println(currentUser.getPossibleMatches());
     //if user doesn't like you yet, it adds the possibleMatchUser to possible matches
     currentUser.getPossibleMatches().add(possibleMatchUser);

     return repository.save(currentUser);
     }


}
