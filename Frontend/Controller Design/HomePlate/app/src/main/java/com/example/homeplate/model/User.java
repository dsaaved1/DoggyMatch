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


    public Set<User> getPossibleMatches() {
        return possibleMatches;
    }

    public void setPossibleMatches(Set<User> possibleMatches) {
        this.possibleMatches = possibleMatches;
    }

    public Set<Chat> getChats() {
        return chats;
    }

    public void setChats(Set<Chat> chats) {
        this.chats = chats;
    }

    public User() {

    }

    public Doginfo getDog() {
        return dog;
    }

    public void setDog(Doginfo dog) {
        this.dog = dog;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getPrivacySettings() {
        return privacySettings;
    }

    public void setPrivacySettings(String privacySettings) {
        this.privacySettings = privacySettings;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
