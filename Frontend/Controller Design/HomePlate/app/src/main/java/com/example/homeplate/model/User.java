package com.example.homeplate.model;
import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import android.util.ArraySet;

import com.example.homeplate.api.SlimCallback;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//import com.google.gson.annotations.SerializedName;

/** Gets all of the data for a user
 * @author Mark Gores
 */
public class User {
    private int id;
    private String email;
    private String password;
    private Boolean active;
    private Date lastLoginTime;
    private String privacySettings;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String university;
    private String gender;
    private String photo;
    private Doginfo dog;
    private Preferences preferences;
    private Set<User> possibleMatches;
    private Set<Chat> chats = new HashSet<Chat>();

    /**
     * gets possible matches for user
     * @return list of users
     */
    public Set<User> getPossibleMatches() {
        return possibleMatches;
    }

    /**
     * sets the list of possible matches for a user
     * @param possibleMatches
     */
    public void setPossibleMatches(Set<User> possibleMatches) {
        this.possibleMatches = possibleMatches;
    }

    /**
     * gets a list of chats (or matches) for user
     * @return list of chats or matches
     */
    public Set<Chat> getChats() {
        return chats;
    }

    /**
     * sets the list of chats (or matches) for user
     * @param chats
     */
    public void setChats(Set<Chat> chats) {
        this.chats = chats;
    }

    /**
     * basic constructor for user
     */
    public User() {

    }

    /**
     * gets the current dog information
     * @return current dog info
     */
    public Doginfo getDog() {
        return dog;
    }

    /**
     * sets the current dog information
     * @param dog info
     */
    public void setDog(Doginfo dog) {
        this.dog = dog;
    }

    /**
     * gets the current users preferences for matches
     * @return user preferences matches
     */
    public Preferences getPreferences() {
        return preferences;
    }

    /**
     * sets the current users preferences for matches
     * @param preferences
     */
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    /**
     * gets the current user id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * sets current user id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets the current user email
     * @return user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets current user email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * gets current user password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets current user password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * gets if the current user is active
     * @return boolean is active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * sets is active for current user
     * @param active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * gets the date of last time for user login
     * @return
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * sets the time for last login
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * gets current users privacy setting
     * @return privacy setting
     */
    public String getPrivacySettings() {
        return privacySettings;
    }

    /**
     * sets current users privacy setting
     * @param privacySettings
     */
    public void setPrivacySettings(String privacySettings) {
        this.privacySettings = privacySettings;
    }

    /**
     * gets current users first name
     * @return users firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets current users firstname
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get users last name
     * @return users last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets users last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets users age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * sets users age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * gets users address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets users address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * gets users university
     * @return usiversity
     */
    public String getUniversity() {
        return university;
    }

    /**
     * sets users university
     * @param university
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * gets users gender
     * @return user gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * sets users gender
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * gets users photo
     * @return gets user photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * sets user photo
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
