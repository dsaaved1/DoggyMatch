package com.iastate._rk_1.backend.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @ApiModelProperty(notes = "email of user",name="email",required=true,value="test email")
  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "active")
  private boolean active;

  @Column(name = "lastLoginTime")
  private Date lastLoginTime;

  @Column(name = "privacySettings")
  private String privacySettings;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "age")
  private int age;

  @Column(name = "address")
  private String address;

  @Column(name = "university")
  private String university;

  @Column(name = "gender")
  private String gender;

  @Column(name = "photo")
  private String photo;

  @OneToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "dogInfo_id")
  private DogInfo dogInfo;

  @OneToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "preferences_id")
  private Preferences preferences;

  @Column(name = "compatibility")
  private int compatibility;

  @OneToMany(cascade = {CascadeType.ALL})
  @JoinColumn(name = "possibleMatches")
  private Set<User> possibleMatches;

  @OneToMany(cascade = {CascadeType.ALL})
  @JoinColumn(name = "chats")
  private Set<Chat> chats;

  public User() {
  }

  public User(String email, String password) {
    this.email = email;
    this.password = password;
    this.active = true;
    this.lastLoginTime = new Date();
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

  public String getPassword(){
    return password;
  }

  public void setEncryptedPassword(String encryptedPassword){
    this.password = encryptedPassword;
  }

  public boolean getActive() {
    return active;
  }

  public void setActive(boolean active) {
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

  public DogInfo getDogInfo() {
    return dogInfo;
  }

  public void setDogInfo(DogInfo dogInfo) {
    this.dogInfo = dogInfo;
  }

  public Preferences getPreferences() {
    return preferences;
  }

  public void setPreferences(Preferences preferences) {
    this.preferences = preferences;
  }

  public int getCompatibility() {
    return compatibility;
  }

  public void clearCompatibility() {
    compatibility = 0;
  }

  public void addCompatibility(){compatibility++;}

  public Set<User> getPossibleMatches() {
    return possibleMatches;
  }

  public Set<Chat> getChats() {
    return chats;
  }

  public void setPossibleMatches(Set<User> possibleMatches) {
    this.possibleMatches = possibleMatches;
  }

  public void setChats(Set<Chat> chats) {
    this.chats = chats;
  }

}
