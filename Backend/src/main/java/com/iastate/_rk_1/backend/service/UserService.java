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

    /**
     * Adds a new user to the database if user isn't already in database
     * @param user the User object that will be added
     * @return the User that has been added to the database
     */
  public User saveUser(User user) {
    return repository.save(user);
  }

    /**
     * Shows a list of all the users in the repository.
     * @return a list of User objects
     */
  public List<User> getUsers() {
    return repository.findAll();
  }

    /**
     * Gets a user by the provided id
     * @param id the id of the user to get
     * @return the User object if the id provided matches with an existing User
     */
  public User getUserById(int id) {
    return repository.findById(id);
  }

    /**
     * Gets a user by the provided email
     * @param email the email of the user to get
     * @return he User object if the email provided matches with an existing User
     */
  public User getUsersByEmail(String email) {
    return repository.findByEmail(email);
  }

  public User getUserByFirstName(String name) {
    return repository.findByFirstName(name);
  }

    /**
     * Deletes a user with the provided id
     * @param id the id of the user to be deleted
     * @return a string "success" that tells us that the user has been deleted
     */
  public String deleteUser(int id) {
    repository.deleteById(id);
    return "success";
  }

    /**
     * Updates a user with the given user object
     * @param user the user that will be updated
     * @param id the id of the user that will be updated
     * @return User the user that will be updated with the information already updated
     */
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

    /**
     * Adds a User's dog information to the database provided by an id
     * @param dogInfo the dogInfo object that will be added to the User
     * @param id the id of the user to update its dogInfo
     * @return the User object with its dogInfo stored
     */
  //Diego
  public User updateUserDogInfo(DogInfo dogInfo, int id){
    User existingUser = repository.findById(id);
    existingUser.setDogInfo(dogInfo);
    return repository.save(existingUser);
  }

    /**
     * Adds a user's preferences to the database provided by an id
     * @param preferences the preferences that will be added to the User
     * @param id the id of the user to update the preferences
     * @return the User object with its preferences stored
     */
  //Diego
  public User updateUserPreferences(Preferences preferences, int id){
    User existingUser = repository.findById(id);
    existingUser.setPreferences(preferences);
    return repository.save(existingUser);
  }

    /**
     * Adds a new user to the database if user isn't already in database
     * @param user the User object that will be added
     * @return the User that has been added to the database
     */
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

    /**
     * Gets every user except the User from provided email
     * @param email the email of the user to exclude
     * @return all Users on the database except the User from provided email
     */
  public List<User> findEverybody(String email) {
    List<User> users = repository.findAll();

    for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
      User user = iterator.next();
      if (user.getEmail().equals(email)){
        iterator.remove();
      }
    }
    return users;
  }

    /**
     * Gets a list of possible matches of a given user, which are User objects, sorted by the user preferences.
     * The first possible match being the "best one" for the user, and the last possible match on the list
     * being the "worst one".
     * @param email the email of the user we want to get its possible matches
     * @return the possible matches (User objects) of the User provided by email
     */
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
     * Creates a match between two users.
     * @param userId the id of the user
     * @param possibleMatchId the id of user who the first user wants to make a match with
     * @return User
     */
  //Diego
  public User match(int userId, int possibleMatchId) {
         User currentUser = getUserById(userId);
         User possibleMatchUser = getUserById(possibleMatchId);

         //checks if you are on the possibleMatches of the user you would like to match with
         for (String userMail: possibleMatchUser.getPossibleMatches()){
             //if you are, it creates a chat with you because both "liked" each other
             if (userMail == currentUser.getEmail()){
                 Chat chatCurrentUser = new Chat();
                 Chat chatMatchUser = new Chat();

                 //for now only storing the email on each chat object of the person they got the match with
                 chatCurrentUser.setUserMail(possibleMatchUser.getEmail());
                 chatMatchUser.setUserMail(currentUser.getEmail());

                 currentUser.getChats().add(chatCurrentUser);
                 possibleMatchUser.getChats().add(chatMatchUser);
                 possibleMatchUser.getPossibleMatches().remove(currentUser.getEmail());
                 repository.save(possibleMatchUser);
                 return repository.save(currentUser);
             }
         }
          //if user doesn't like you yet, it adds the possibleMatchUser to possibleMatches
         currentUser.getPossibleMatches().add(possibleMatchUser.getEmail());
         return repository.save(currentUser);
  }


}
