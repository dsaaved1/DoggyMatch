package com.iastate._rk_1.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.util.*;

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

  @ElementCollection
  @Column(name = "possibleMatches")
  private Set<String> possibleMatches = new HashSet<>();

  @OneToMany(cascade = {CascadeType.ALL})
  private Set<Chat> chats = new HashSet<>();

  public User() {
  }

  public User(String email, String password) {
    this.email = email;
    this.password = password;
    this.active = true;
    this.lastLoginTime = new Date();
  }


  
  /** 
   * @return int
   */
  public int getId() {
    return id;
  }

  
  /** 
   * @param id
   */
  public void setId(int id) {
    this.id = id;
  }

  
  /** 
   * @return String
   */
  public String getEmail() {
    return email;
  }

  
  /** 
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  
  /** 
   * @return String
   */
  public String getPassword(){
    return password;
  }

  
  /** 
   * @param encryptedPassword
   */
  public void setEncryptedPassword(String encryptedPassword){
    this.password = encryptedPassword;
  }

  
  /** 
   * @return boolean
   */
  public boolean getActive() {
    return active;
  }

  
  /** 
   * @param active
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  
  /** 
   * @return Date
   */
  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  
  /** 
   * @param lastLoginTime
   */
  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  
  /** 
   * @return String
   */
  public String getPrivacySettings() {
    return privacySettings;
  }

  
  /** 
   * @param privacySettings
   */
  public void setPrivacySettings(String privacySettings) {
    this.privacySettings = privacySettings;
  }

  
  /** 
   * @return String
   */
  public String getFirstName() {
    return firstName;
  }

  
  /** 
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  
  /** 
   * @return String
   */
  public String getLastName() {
    return lastName;
  }

  
  /** 
   * @param lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  
  /** 
   * @return int
   */
  public int getAge() {
    return age;
  }

  
  /** 
   * @param age
   */
  public void setAge(int age) {
    this.age = age;
  }

  
  /** 
   * @return String
   */
  public String getAddress() {
    return address;
  }

  
  /** 
   * @param address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  
  /** 
   * @return String
   */
  public String getUniversity() {
    return university;
  }

  
  /** 
   * @param university
   */
  public void setUniversity(String university) {
    this.university = university;
  }

  
  /** 
   * @return String
   */
  public String getGender() {
    return gender;
  }

  
  /** 
   * @param gender
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  
  /** 
   * @return String
   */
  public String getPhoto() {
    return photo;
  }

  
  /** 
   * @param photo
   */
  public void setPhoto(String photo) {
    this.photo = photo;
  }

  
  /** 
   * @return DogInfo
   */
  public DogInfo getDogInfo() {
    return dogInfo;
  }

  
  /** 
   * @param dogInfo
   */
  public void setDogInfo(DogInfo dogInfo) {
    this.dogInfo = dogInfo;
  }

  
  /** 
   * @return Preferences
   */
  public Preferences getPreferences() {
    return preferences;
  }

  
  /** 
   * @param preferences
   */
  public void setPreferences(Preferences preferences) {
    this.preferences = preferences;
  }

  
  /** 
   * @return int
   */
  public int getCompatibility() {
    return compatibility;
  }

  public void clearCompatibility() {
    compatibility = 0;
  }

  
  /**
   */
  public void addCompatibility(){compatibility++;}

  
  /** 
   * @return Set<User>
   */
  public Set<String> getPossibleMatches() {
    return possibleMatches;
  }

  
  /** 
   * @return Set<Chat>
   */
  public Set<Chat> getChats() {
    return chats;
  }

  
  /** 
   * @param possibleMatches
   */
  public void setPossibleMatches(Set<String> possibleMatches) {
    this.possibleMatches = possibleMatches;
  }

  
  /** 
   * @param chats
   */
  public void setChats(Set<Chat> chats) {
    this.chats = chats;
  }

}
